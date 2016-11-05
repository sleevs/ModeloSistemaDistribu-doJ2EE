/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.apresentacao;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Jeison
 */
@Named(value = "gerenteProposta")
@SessionScoped
public class GerenteProposta implements Serializable {

    /**
     * Creates a new instance of GerenteProposta
     */
    public GerenteProposta() {
    }
    
}
