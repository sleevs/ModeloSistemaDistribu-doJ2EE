/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.apresentacao;

import com.freedomsoftware.jsnprototipo.controle.AnuncioFacade;
import com.freedomsoftware.jsnprototipo.controle.ContaFacade;
import com.freedomsoftware.jsnprototipo.controle.PropostaFacade;
import com.freedomsoftware.jsnprototipo.modelo.Anuncio;
import com.freedomsoftware.jsnprototipo.modelo.Conta;
import com.freedomsoftware.jsnprototipo.modelo.Proposta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;



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

@Named(value = "gerenteUsuario")
@SessionScoped
public class GerenteUsuario implements Serializable {

    /**
     * Creates a new instance of GerenteUsuario
     */
    @EJB
    private PropostaFacade propostaEJB;

    @EJB
    private AnuncioFacade anuncioEJB;
    
    @EJB
    private ContaFacade contaEJB;

    private Conta conta = new Conta();
    private Proposta proposta = new Proposta();

    private Anuncio anuncio = new Anuncio();

    List<Anuncio> anuncios = new ArrayList<>();
    List<Proposta> propostas = new ArrayList<>();


    
   /*
   
   request = (HttpServletRequest) req ;
        HttpSession session = (HttpSession) request.getSession();
        int idUsuarioSession = session.getAttribute("ID_USUARIO");
   
   */
    
    
    

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Proposta getProposta() {
        return proposta;
    }

    public void setProposta(Proposta proposta) {
        this.proposta = proposta;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anuncios) {
        this.anuncios = anuncios;
    }

    public List<Proposta> getPropostas() {
        return propostas;
    }

    public void setPropostas(List<Proposta> propostas) {
        this.propostas = propostas;
    }
    
    
    
    
    
    
    
    
    
    public Conta buscarConta(){
        
        Conta contaTemp = new Conta();
        Anuncio a = new Anuncio();
        FacesContext fc = FacesContext.getCurrentInstance();
      
        this.conta = (Conta) fc.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
       
    
        
        System.out.println("USUARIO LOGADO :" + conta.getContaNome() + " IDENTIFICADOR NUMERO " +conta.toString()  );
          
        
        return conta ;
        
    }
    
    public void buscarAnuncio() {

        Conta contaTemp = new Conta();
        // 
        FacesContext fc = FacesContext.getCurrentInstance();
        contaTemp = (Conta) fc.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        
        
      //  anuncio = (Anuncio) anuncioEJB.encontrarPorId(contaTemp);
        System.out.println(" EDITANDO ANUNCIO  :" + contaTemp.getContaNome() + " IDENTIFICADOR NUMERO " + contaTemp.toString() + " NUMERO DO ANUNCIO DESTE USUARIO :" + anuncio.getAnuncioId());


    }
    
  
    public void  buscarTodosAnuncios(){
     
   // return  this.anuncioEJB.encontrarPorId(buscarConta());
   
    
    }




   public void deslogar(){
       
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
       
   }
    
    
    public void buscarProposta(){
   
        /*
        
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().getSessionMap().put("proposta", proposta);
      
         
        */
      
    
    }
    
    
    
    
    
    
    
        public String editarAnuncio(Anuncio a) {

        System.out.println("ANUNCIO RECEBIDO :" + a.toString());
        this.anuncio = a;
        System.out.println("ANUNCIO RECUPERADO :" + anuncio.toString());

        return "templateTeste.xhtml";

    }

      
    
          public String editarAnuncio() {

        this.anuncioEJB.edit(this.anuncio);

        return "usuario.xhtml";

    }
          
          
          
    
      
    
    
        
        public String criarNovoAnuncio(){
        
            this.anuncio.setContaContaId(this.conta);
            this.anuncioEJB.create(this.anuncio);
            anuncio = new Anuncio();
            
            return "usuario.xhtml";
        }
    
    
}
