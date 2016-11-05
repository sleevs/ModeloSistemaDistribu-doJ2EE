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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jeison
 */
@Entity
@Table(name = "mensagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensagem.findAll", query = "SELECT m FROM Mensagem m"),
    @NamedQuery(name = "Mensagem.findByMensagemId", query = "SELECT m FROM Mensagem m WHERE m.mensagemId = :mensagemId"),
    @NamedQuery(name = "Mensagem.findByMensagemTipo", query = "SELECT m FROM Mensagem m WHERE m.mensagemTipo = :mensagemTipo"),
    @NamedQuery(name = "Mensagem.findByMensagemCategoria", query = "SELECT m FROM Mensagem m WHERE m.mensagemCategoria = :mensagemCategoria"),
    @NamedQuery(name = "Mensagem.findByMensagemDescricao", query = "SELECT m FROM Mensagem m WHERE m.mensagemDescricao = :mensagemDescricao"),
    @NamedQuery(name = "Mensagem.findByMensagemEnvio", query = "SELECT m FROM Mensagem m WHERE m.mensagemEnvio = :mensagemEnvio"),
    @NamedQuery(name = "Mensagem.findByMensagemRecebida", query = "SELECT m FROM Mensagem m WHERE m.mensagemRecebida = :mensagemRecebida"),
    @NamedQuery(name = "Mensagem.findByMensagemData", query = "SELECT m FROM Mensagem m WHERE m.mensagemData = :mensagemData")})
public class Mensagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mensagem_id")
    private Integer mensagemId;
    @Size(max = 45)
    @Column(name = "mensagem_tipo")
    private String mensagemTipo;
    @Size(max = 45)
    @Column(name = "mensagem_categoria")
    private String mensagemCategoria;
    @Size(max = 255)
    @Column(name = "mensagem_descricao")
    private String mensagemDescricao;
    @Size(max = 45)
    @Column(name = "mensagem_envio")
    private String mensagemEnvio;
    @Size(max = 45)
    @Column(name = "mensagem_recebida")
    private String mensagemRecebida;
    @Column(name = "mensagem_data")
    @Temporal(TemporalType.DATE)
    private Date mensagemData;
    @JoinColumn(name = "anuncio_anuncio_id", referencedColumnName = "anuncio_id")
    @ManyToOne(optional = false)
    private Anuncio anuncioAnuncioId;
    @JoinColumn(name = "conta_conta_id", referencedColumnName = "conta_id")
    @ManyToOne(optional = false)
    private Conta contaContaId;

    public Mensagem() {
    }

    public Mensagem(Integer mensagemId) {
        this.mensagemId = mensagemId;
    }

    public Integer getMensagemId() {
        return mensagemId;
    }

    public void setMensagemId(Integer mensagemId) {
        this.mensagemId = mensagemId;
    }

    public String getMensagemTipo() {
        return mensagemTipo;
    }

    public void setMensagemTipo(String mensagemTipo) {
        this.mensagemTipo = mensagemTipo;
    }

    public String getMensagemCategoria() {
        return mensagemCategoria;
    }

    public void setMensagemCategoria(String mensagemCategoria) {
        this.mensagemCategoria = mensagemCategoria;
    }

    public String getMensagemDescricao() {
        return mensagemDescricao;
    }

    public void setMensagemDescricao(String mensagemDescricao) {
        this.mensagemDescricao = mensagemDescricao;
    }

    public String getMensagemEnvio() {
        return mensagemEnvio;
    }

    public void setMensagemEnvio(String mensagemEnvio) {
        this.mensagemEnvio = mensagemEnvio;
    }

    public String getMensagemRecebida() {
        return mensagemRecebida;
    }

    public void setMensagemRecebida(String mensagemRecebida) {
        this.mensagemRecebida = mensagemRecebida;
    }

    public Date getMensagemData() {
        return mensagemData;
    }

    public void setMensagemData(Date mensagemData) {
        this.mensagemData = mensagemData;
    }

    public Anuncio getAnuncioAnuncioId() {
        return anuncioAnuncioId;
    }

    public void setAnuncioAnuncioId(Anuncio anuncioAnuncioId) {
        this.anuncioAnuncioId = anuncioAnuncioId;
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
        hash += (mensagemId != null ? mensagemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensagem)) {
            return false;
        }
        Mensagem other = (Mensagem) object;
        if ((this.mensagemId == null && other.mensagemId != null) || (this.mensagemId != null && !this.mensagemId.equals(other.mensagemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.freedomsoftware.jsnprototipo.modelo.Mensagem[ mensagemId=" + mensagemId + " ]";
    }
    
}
