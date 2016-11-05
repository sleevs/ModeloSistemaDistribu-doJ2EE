/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.apresentacao;

import com.freedomsoftware.jsnprototipo.controle.AnuncioFacade;
import com.freedomsoftware.jsnprototipo.modelo.Anuncio;
import com.freedomsoftware.jsnprototipo.modelo.Conta;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jeison
 */
@Named(value = "gerenteCrudAnuncio")
@RequestScoped
public class GerenteCrudAnuncio {

    /**
     * Creates a new instance of GerenteCrudAnuncio
     */
    public GerenteCrudAnuncio() {
    }
    
    
    @EJB
    private AnuncioFacade anuncioEJB;
    
    private Anuncio anuncio = new Anuncio();

    private Conta conta = new Conta ();
    
    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
    
    
    
    
    
    public Conta buscarConta(){
        
     
        
        FacesContext fc = FacesContext.getCurrentInstance();
      
        this.conta = (Conta) fc.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
       
    
        
        System.out.println("USUARIO LOGADO :" + conta.getContaNome() + " IDENTIFICADOR NUMERO " +conta.toString()  );
          
        
        return conta ;
        
    }
    
    
    
    
    
      public String editarAnuncio(Anuncio a) {

            
            this.anuncio = a;
       
     return "editarAnuncio.xhtml";
    }
    
    
    public String editarAnuncio(){
       
        
        
        this.anuncioEJB.edit(this.anuncio);

        
    
    return "filtro.xhtml";
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
