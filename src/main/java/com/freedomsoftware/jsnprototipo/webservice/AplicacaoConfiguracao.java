/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.webservice;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Jeison
 */


@javax.ws.rs.ApplicationPath("rest")
public class AplicacaoConfiguracao extends Application{
    
    
    
    public Set<Class<?>> getClasses(){
    
    Set<Class<?>> resources = new java.util.HashSet<>();
    addRestResourceClasses(resources);
    return resources;
    
    }
    
    
    private void addRestResourceClasses(Set<Class<?>> resources){
    
    resources.add(com.freedomsoftware.jsnprototipo.webservice.PrototipoRestfull.class);
    
    
    
    }
    
    
}
