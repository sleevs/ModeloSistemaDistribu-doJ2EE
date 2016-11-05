/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.apresentacao;

import com.freedomsoftware.jsnprototipo.controle.AnuncioFacade;
import com.freedomsoftware.jsnprototipo.controle.ContaFacade;
import com.freedomsoftware.jsnprototipo.modelo.Anuncio;
import com.freedomsoftware.jsnprototipo.modelo.Conta;
import com.freedomsoftware.jsnprototipo.security.MonitorDeSessao;
import com.freedomsoftware.jsnprototipo.security.SentinelaDeAcesso;
import com.freedomsoftware.jsnprototipo.security.SessaoUsuario;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Named;


/**
 *
 * @author Jeison
 */
@Named(value = "gerenteConta")
@SessionScoped
public class GerenteConta implements Serializable {

    
    
    @EJB
    private ContaFacade contaEJB;
    @EJB
    private AnuncioFacade anuncioEJB;
     
    @EJB
    SentinelaDeAcesso sentinelaDeAcessoEJB ;
    
    private Conta conta = new Conta();
    private Anuncio anuncio = new Anuncio();
   
    
    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    /*
    
    FacesContext fc = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
session.setAttribute("ID_USUARIO", this.idUsuario);
    
    
    */

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }
    
    
    
    public String criarConta(){
       
       
       this.contaEJB.create(this.conta);

       
        try {
       
        this.anuncio.setContaContaId(this.conta);
        
        this.anuncioEJB.create(this.anuncio);
        
        this.conta = new Conta();
        this.anuncio = new Anuncio();
        
        System.out.println(" BUSQUEI A ULTIMA CONTA QUE FOI CRIADA POR " + conta.getContaNome());
         System.out.println(" BUSQUEI A ULTIMO ANUNCIO QUE FOI CRIADO por  " +anuncio.getAnuncioId());
         
       
       }catch(Exception e){
          System.out.println(" NÃO FOI CRIADA O ANUNCIO JUNTO COM A CONTA " );
    
          return "erro.html";
       }

        return "prototipo1.xhtml";
    }
    
    
    public void deletarConta(Conta conta){
        
        this.contaEJB.remove(conta);
    }
    
  
    
     public String editarConta(Conta c){
         
         this.conta = c ;
         
         return "editarConta.xhtml";
         
         
    }
    
     
     
       public String editarConta(){
    
      this.contaEJB.edit(this.conta);
      
        return "prototipo1.xhtml";
    
    }
       
       
       
       
     public String encontrarConta(Conta c){
         
         this.conta = c ;
         
         return "principal.xhtml";
         
         
    }
    
     
     
       public List<Anuncio> encontrarAnuncios(){
    
           
          
       return anuncioEJB.encontrarPorId(this.conta);
    }
       
       
     
    
    public List<Conta> listarContas(){
    
    return contaEJB.findAll();
    
    }
    
    
    
    
     public String editarAnuncio(Anuncio a){
         
         this.anuncio = a ;
         
         return "editarAnuncio.xhtml";
         
         
    }
    
     
     
       public String editarAnuncio(){
    
       anuncioEJB.edit(this.anuncio);
      
        return "principal.xhtml";
    
    }
       
    
    
    
   
        public String iniciarSessao(Conta c) {

           
            String redirecionar = null;
            FacesContext fc = FacesContext.getCurrentInstance();
            
        try {

          
            this.conta = this.sentinelaDeAcessoEJB.login(c);

  
            if (this.conta != null) {

                
                
                fc.getExternalContext().getSessionMap().put("usuario", this.conta);
  
                redirecionar = "usuario.xhtml?faces-redirect=true";

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso Credenciais Incorreta", "Credenciais Incorreta!"));

            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Erro!"));
        }

        System.out.println("USUARIO : " + conta.toString());
  
        
        return redirecionar;
    } 
    
    
}
