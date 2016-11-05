/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.security;

import com.freedomsoftware.jsnprototipo.modelo.Conta;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeison
 */
public class TesteSessao {
    
    public static  void main(String [] args){
    
    
       String temp = null;
        Conta conta = new Conta();
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(false);
         temp = (String) httpSession.getAttribute("VDB");
         conta.setContaNome(temp);
         System.out.println(" REQUISICAO " + temp);
         System.out.println("USUARIO DA REQUISICAO " + conta.getContaNome());
    
    }
    
}
