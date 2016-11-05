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
import javax.persistence.Lob;
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
@Table(name = "proposta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proposta.findAll", query = "SELECT p FROM Proposta p"),
    @NamedQuery(name = "Proposta.findByPropostaId", query = "SELECT p FROM Proposta p WHERE p.propostaId = :propostaId"),
    @NamedQuery(name = "Proposta.findByPropostaTipo", query = "SELECT p FROM Proposta p WHERE p.propostaTipo = :propostaTipo"),
    @NamedQuery(name = "Proposta.findByPropostaValor", query = "SELECT p FROM Proposta p WHERE p.propostaValor = :propostaValor"),
    @NamedQuery(name = "Proposta.findByPropostaData", query = "SELECT p FROM Proposta p WHERE p.propostaData = :propostaData"),
    @NamedQuery(name = "Proposta.findByPropostaCategoria", query = "SELECT p FROM Proposta p WHERE p.propostaCategoria = :propostaCategoria"),
    @NamedQuery(name = "Proposta.findByPropostaAtualizacao", query = "SELECT p FROM Proposta p WHERE p.propostaAtualizacao = :propostaAtualizacao"),
    @NamedQuery(name = "Proposta.findByPropostaArquivo", query = "SELECT p FROM Proposta p WHERE p.propostaArquivo = :propostaArquivo")})
public class Proposta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proposta_id")
    private Integer propostaId;
    @Size(max = 45)
    @Column(name = "proposta_tipo")
    private String propostaTipo;
    @Lob
    @Size(max = 16777215)
    @Column(name = "proposta_descricao")
    private String propostaDescricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "proposta_valor")
    private Double propostaValor;
    @Column(name = "proposta_data")
    @Temporal(TemporalType.DATE)
    private Date propostaData;
    @Size(max = 45)
    @Column(name = "proposta_categoria")
    private String propostaCategoria;
    @Size(max = 45)
    @Column(name = "proposta_atualizacao")
    private String propostaAtualizacao;
    @Size(max = 500)
    @Column(name = "proposta_arquivo")
    private String propostaArquivo;
    @JoinColumn(name = "anuncio_anuncio_id", referencedColumnName = "anuncio_id")
    @ManyToOne(optional = false)
    private Anuncio anuncioAnuncioId;
    @JoinColumn(name = "conta_conta_id", referencedColumnName = "conta_id")
    @ManyToOne(optional = false)
    private Conta contaContaId;

    public Proposta() {
    }

    public Proposta(Integer propostaId) {
        this.propostaId = propostaId;
    }

    public Integer getPropostaId() {
        return propostaId;
    }

    public void setPropostaId(Integer propostaId) {
        this.propostaId = propostaId;
    }

    public String getPropostaTipo() {
        return propostaTipo;
    }

    public void setPropostaTipo(String propostaTipo) {
        this.propostaTipo = propostaTipo;
    }

    public String getPropostaDescricao() {
        return propostaDescricao;
    }

    public void setPropostaDescricao(String propostaDescricao) {
        this.propostaDescricao = propostaDescricao;
    }

    public Double getPropostaValor() {
        return propostaValor;
    }

    public void setPropostaValor(Double propostaValor) {
        this.propostaValor = propostaValor;
    }

    public Date getPropostaData() {
        return propostaData;
    }

    public void setPropostaData(Date propostaData) {
        this.propostaData = propostaData;
    }

    public String getPropostaCategoria() {
        return propostaCategoria;
    }

    public void setPropostaCategoria(String propostaCategoria) {
        this.propostaCategoria = propostaCategoria;
    }

    public String getPropostaAtualizacao() {
        return propostaAtualizacao;
    }

    public void setPropostaAtualizacao(String propostaAtualizacao) {
        this.propostaAtualizacao = propostaAtualizacao;
    }

    public String getPropostaArquivo() {
        return propostaArquivo;
    }

    public void setPropostaArquivo(String propostaArquivo) {
        this.propostaArquivo = propostaArquivo;
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
        hash += (propostaId != null ? propostaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proposta)) {
            return false;
        }
        Proposta other = (Proposta) object;
        if ((this.propostaId == null && other.propostaId != null) || (this.propostaId != null && !this.propostaId.equals(other.propostaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.freedomsoftware.jsnprototipo.modelo.Proposta[ propostaId=" + propostaId + " ]";
    }
    
}
