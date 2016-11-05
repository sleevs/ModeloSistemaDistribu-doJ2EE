/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.apresentacao;

import com.freedomsoftware.jsnprototipo.controle.ContaFacade;
import com.freedomsoftware.jsnprototipo.modelo.Conta;
import com.freedomsoftware.jsnprototipo.security.SentinelaDeAcesso;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Jeison
 */
@Named(value = "gerenteDeSeguranca")
@SessionScoped
public class GerenteDeSeguranca  implements Serializable {

    /**
     * Creates a new instance of GerenteDeSeguranca
     */
   
    
    @EJB
    private ContaFacade contaEJB ;
    
    private Conta conta = new Conta ();
    
     
    @EJB
    SentinelaDeAcesso sentinelaDeAcessoEJB ;
    
    
    
    
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
    
        public String iniciarSessao(Conta c) {

        String redirecionar = null;
        FacesContext fc = FacesContext.getCurrentInstance();

        try {

            this.conta = this.sentinelaDeAcessoEJB.logar(c.getContaEmail(), c.getContaSenha());

            if (this.conta != null) {

                fc.getExternalContext().getSessionMap().put("usuario", this.conta);

                 redirecionar = "usuario.xhtml?faces-redirect=true";
                //redirecionar = "usuario.xhtml";

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso Credenciais Incorreta", "Credenciais Incorreta!"));

            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Erro!"));
        }

        System.out.println("USUARIO : " + this.conta.toString());

        return redirecionar;
    }

    
        
    
    public void solicitarNovaSenha(){
   
    }
    
    
    public void deslogar(){
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
