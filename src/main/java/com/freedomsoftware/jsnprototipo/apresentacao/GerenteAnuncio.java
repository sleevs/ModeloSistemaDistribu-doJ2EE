/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.apresentacao;

import com.freedomsoftware.jsnprototipo.controle.AnuncioFacade;
import com.freedomsoftware.jsnprototipo.modelo.Anuncio;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Jeison
 */
@Named(value = "gerenteAnuncio")
@SessionScoped
public class GerenteAnuncio implements Serializable {

    /**
     * Creates a new instance of GerenteAnuncio
     */
    public GerenteAnuncio() {
    }
    
    @EJB
    private AnuncioFacade anuncioEJB ;
    
    private Anuncio anuncio = new Anuncio();

    
    
    
    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }
    
    
    
    
    
    
    
}
