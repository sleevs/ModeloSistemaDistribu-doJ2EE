/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.security;

import com.freedomsoftware.jsnprototipo.controle.ContaFacade;
import com.freedomsoftware.jsnprototipo.modelo.Conta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jeison
 */


/*

// Set session Object in Session
  
FacesContext context = FacesContext.getCurrentInstance();
HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
HttpSession httpSession = request.getSession(false);
httpSession.setAttribute(attName, reqdObj);
  
// Get session object from Session
  
FacesContext context = FacesContext.getCurrentInstance();
HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
HttpSession httpSession = request.getSession(false);
RequiredObject reqdObj = (RequiredObject) httpSession.getAttribute(attName);


*/





public class MonitorDeSessao  extends HttpServlet {
    
    
    
   
    

   
 
 
       public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
   
              
                
         	


    }
       
       
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("freedomsoftware");
            out.println("</body>");
            out.println("</html>");
      
      
       }
      
       
       
       
       
    
      public String enviarParametro(){
      
      return "";
      }

   

      
      
  
       
    
    
}
