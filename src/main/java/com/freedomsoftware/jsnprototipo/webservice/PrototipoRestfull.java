/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jeison
 */


@Path("freedomsoftwareWS")
public class PrototipoRestfull {
    
    
    
    @GET
    @Path("teste")
    @Produces(MediaType.TEXT_PLAIN)
    public String metodoTeste(){
    
    
    return "Teste JSNSoftware";
    }
    
    
}
