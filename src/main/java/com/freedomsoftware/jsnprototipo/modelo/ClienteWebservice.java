/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jeison
 */
@Entity
@Table(name = "cliente_webservice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteWebservice.findAll", query = "SELECT c FROM ClienteWebservice c"),
    @NamedQuery(name = "ClienteWebservice.findByClienteWebserviceId", query = "SELECT c FROM ClienteWebservice c WHERE c.clienteWebserviceId = :clienteWebserviceId"),
    @NamedQuery(name = "ClienteWebservice.findByClienteWebserviceUserId", query = "SELECT c FROM ClienteWebservice c WHERE c.clienteWebserviceUserId = :clienteWebserviceUserId"),
    @NamedQuery(name = "ClienteWebservice.findByClienteWebserviceTipo", query = "SELECT c FROM ClienteWebservice c WHERE c.clienteWebserviceTipo = :clienteWebserviceTipo"),
    @NamedQuery(name = "ClienteWebservice.findByClienteWebserviceNome", query = "SELECT c FROM ClienteWebservice c WHERE c.clienteWebserviceNome = :clienteWebserviceNome"),
    @NamedQuery(name = "ClienteWebservice.findByClienteWebserviceToken", query = "SELECT c FROM ClienteWebservice c WHERE c.clienteWebserviceToken = :clienteWebserviceToken"),
    @NamedQuery(name = "ClienteWebservice.findByClienteWebserviceTokenSecreto", query = "SELECT c FROM ClienteWebservice c WHERE c.clienteWebserviceTokenSecreto = :clienteWebserviceTokenSecreto"),
    @NamedQuery(name = "ClienteWebservice.findByClienteWebserviceData", query = "SELECT c FROM ClienteWebservice c WHERE c.clienteWebserviceData = :clienteWebserviceData"),
    @NamedQuery(name = "ClienteWebservice.findByClienteWebserviceEmpresa", query = "SELECT c FROM ClienteWebservice c WHERE c.clienteWebserviceEmpresa = :clienteWebserviceEmpresa"),
    @NamedQuery(name = "ClienteWebservice.findByClienteWebserviceDescricao", query = "SELECT c FROM ClienteWebservice c WHERE c.clienteWebserviceDescricao = :clienteWebserviceDescricao")})
public class ClienteWebservice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cliente_webservice_id")
    private Integer clienteWebserviceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cliente_webservice_user_id")
    private int clienteWebserviceUserId;
    @Size(max = 100)
    @Column(name = "cliente_webservice_tipo")
    private String clienteWebserviceTipo;
    @Size(max = 100)
    @Column(name = "cliente_webservice_nome")
    private String clienteWebserviceNome;
    @Size(max = 100)
    @Column(name = "cliente_webservice_token")
    private String clienteWebserviceToken;
    @Size(max = 100)
    @Column(name = "cliente_webservice_token_secreto")
    private String clienteWebserviceTokenSecreto;
    @Column(name = "cliente_webservice_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date clienteWebserviceData;
    @Size(max = 100)
    @Column(name = "cliente_webservice_empresa")
    private String clienteWebserviceEmpresa;
    @Size(max = 200)
    @Column(name = "cliente_webservice_descricao")
    private String clienteWebserviceDescricao;
    @JoinColumn(name = "conta_conta_id", referencedColumnName = "conta_id")
    @ManyToOne(optional = false)
    private Conta contaContaId;

    public ClienteWebservice() {
    }

    public ClienteWebservice(Integer clienteWebserviceId) {
        this.clienteWebserviceId = clienteWebserviceId;
    }

    public ClienteWebservice(Integer clienteWebserviceId, int clienteWebserviceUserId) {
        this.clienteWebserviceId = clienteWebserviceId;
        this.clienteWebserviceUserId = clienteWebserviceUserId;
    }

    public Integer getClienteWebserviceId() {
        return clienteWebserviceId;
    }

    public void setClienteWebserviceId(Integer clienteWebserviceId) {
        this.clienteWebserviceId = clienteWebserviceId;
    }

    public int getClienteWebserviceUserId() {
        return clienteWebserviceUserId;
    }

    public void setClienteWebserviceUserId(int clienteWebserviceUserId) {
        this.clienteWebserviceUserId = clienteWebserviceUserId;
    }

    public String getClienteWebserviceTipo() {
        return clienteWebserviceTipo;
    }

    public void setClienteWebserviceTipo(String clienteWebserviceTipo) {
        this.clienteWebserviceTipo = clienteWebserviceTipo;
    }

    public String getClienteWebserviceNome() {
        return clienteWebserviceNome;
    }

    public void setClienteWebserviceNome(String clienteWebserviceNome) {
        this.clienteWebserviceNome = clienteWebserviceNome;
    }

    public String getClienteWebserviceToken() {
        return clienteWebserviceToken;
    }

    public void setClienteWebserviceToken(String clienteWebserviceToken) {
        this.clienteWebserviceToken = clienteWebserviceToken;
    }

    public String getClienteWebserviceTokenSecreto() {
        return clienteWebserviceTokenSecreto;
    }

    public void setClienteWebserviceTokenSecreto(String clienteWebserviceTokenSecreto) {
        this.clienteWebserviceTokenSecreto = clienteWebserviceTokenSecreto;
    }

    public Date getClienteWebserviceData() {
        return clienteWebserviceData;
    }

    public void setClienteWebserviceData(Date clienteWebserviceData) {
        this.clienteWebserviceData = clienteWebserviceData;
    }

    public String getClienteWebserviceEmpresa() {
        return clienteWebserviceEmpresa;
    }

    public void setClienteWebserviceEmpresa(String clienteWebserviceEmpresa) {
        this.clienteWebserviceEmpresa = clienteWebserviceEmpresa;
    }

    public String getClienteWebserviceDescricao() {
        return clienteWebserviceDescricao;
    }

    public void setClienteWebserviceDescricao(String clienteWebserviceDescricao) {
        this.clienteWebserviceDescricao = clienteWebserviceDescricao;
    }

    public Conta getContaContaId() {
        return contaContaId;
    }

    public void setContaContaId(Conta contaContaId) {
        this.contaContaId = contaContaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteWebserviceId != null ? clienteWebserviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteWebservice)) {
            return false;
        }
        ClienteWebservice other = (ClienteWebservice) object;
        if ((this.clienteWebserviceId == null && other.clienteWebserviceId != null) || (this.clienteWebserviceId != null && !this.clienteWebserviceId.equals(other.clienteWebserviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.freedomsoftware.jsnprototipo.modelo.ClienteWebservice[ clienteWebserviceId=" + clienteWebserviceId + " ]";
    }
    
}
