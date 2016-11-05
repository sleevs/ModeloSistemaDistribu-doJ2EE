/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.controle;

import com.freedomsoftware.jsnprototipo.modelo.Anuncio;
import com.freedomsoftware.jsnprototipo.modelo.Conta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jeison
 */
@Stateless
public class AnuncioFacade extends AbstractFacade<Anuncio> {

    @PersistenceContext(unitName = "com.freedomsoftware_JSNPrototipo_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnuncioFacade() {
        super(Anuncio.class);
    }
    
    
    
    
    
    
    
    public List<Anuncio> encontrarPorId(Conta c){
    
    
       Anuncio usuario = new Anuncio();

       TypedQuery<Anuncio> consulta = em.createQuery("SELECT a FROM Anuncio a WHERE a.contaContaId = : contaContaId", Anuncio.class);
       
       return consulta.setParameter("contaContaId", c.getContaId()).getResultList();
             

        //List<Anuncio> resultado = consulta.getResultList();

        //usuario = resultado.get(0);

        //return resultado;

    
    }
    
    
    
    
    
    
        
    
    
}
