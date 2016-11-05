/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.security;

import com.freedomsoftware.jsnprototipo.modelo.Conta;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeison
 */
@Stateless
public class SentinelaDeAcesso implements Serializable {

    
    
    
    @PersistenceContext(unitName = "com.freedomsoftware_JSNPrototipo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    
    
   public  SentinelaDeAcesso (){
       super();
    }
    

       
    
    public Conta logar(String email, String senha) {
        
        String s = senha;
        String e = email;

        Conta usuario = new Conta();

        TypedQuery<Conta> consulta = em.createNamedQuery("Conta.login", Conta.class);
        consulta.setParameter("contaEmail", e);
        consulta.setParameter("contaSenha", s);

        List<Conta> resultado = consulta.getResultList();

        usuario = resultado.get(0);

        return usuario;

    }
    
    
    
    public Conta login(Conta c) {
        
       
        Conta usuario = new Conta();

       TypedQuery<Conta> consulta = em.createQuery("SELECT c FROM Conta c WHERE c.contaEmail =contaEmail AND c.contaSenha =contaSenha", Conta.class);
      
       return consulta.setParameter("contaEmail", c.getContaEmail()).setParameter("contaSenha", c.getContaSenha()).getSingleResult();
     

      /*
         List<Conta> resultado = consulta.getResultList();

        usuario = resultado.get(0);

        return usuario;
       
       */

    }
    
        
        
        
        
        ///////////////////////////////////////////
        //metodo para aplicar criptografia na senha
        private String convertStringToMd5(String valor) {
        MessageDigest mDigest;
        try {
            //Instanciamos o nosso HASH MD5, poderíamos usar outro como
            //SHA, por exemplo, mas optamos por MD5.
            mDigest = MessageDigest.getInstance("MD5");

            //Convert a String valor para um array de bytes em MD5
            byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));

            //Convertemos os bytes para hexadecimal, assim podemos salvar
            //no banco para posterior comparação se senhas
            StringBuffer sb = new StringBuffer();
            for (byte b : valorMD5) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

       
    
    
    
    
    
    
}
