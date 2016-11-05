/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.security;

import com.freedomsoftware.jsnprototipo.controle.ContaFacade;
import com.freedomsoftware.jsnprototipo.modelo.Conta;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jeison
 */
@Stateless
public class TesteBean implements Serializable {
    
  
    
    @PersistenceContext(unitName = "com.freedomsoftware_JSNPrototipo_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    

     public  TesteBean (){
       super();
    }
    
     public String getMessage() {
        return "FREEDOMSOFTWARE";
    }

   

    
    
    
    
    
    
    
    
    
    
    
}
