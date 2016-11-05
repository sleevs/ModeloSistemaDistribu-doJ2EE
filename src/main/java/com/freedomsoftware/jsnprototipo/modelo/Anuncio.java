/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jeison
 */
@Entity
@Table(name = "anuncio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anuncio.findConta", query = "SELECT a FROM Anuncio a WHERE a.contaContaId =: contaContaId"),
    @NamedQuery(name = "Anuncio.findAll", query = "SELECT a FROM Anuncio a"),
    @NamedQuery(name = "Anuncio.findByAnuncioId", query = "SELECT a FROM Anuncio a WHERE a.anuncioId = :anuncioId"),
    @NamedQuery(name = "Anuncio.findByAnuncioTipo", query = "SELECT a FROM Anuncio a WHERE a.anuncioTipo = :anuncioTipo"),
    @NamedQuery(name = "Anuncio.findByAnuncioCategoria", query = "SELECT a FROM Anuncio a WHERE a.anuncioCategoria = :anuncioCategoria"),
    @NamedQuery(name = "Anuncio.findByAnuncioTitulo", query = "SELECT a FROM Anuncio a WHERE a.anuncioTitulo = :anuncioTitulo"),
    @NamedQuery(name = "Anuncio.findByAnuncioTipoPagamento", query = "SELECT a FROM Anuncio a WHERE a.anuncioTipoPagamento = :anuncioTipoPagamento"),
    @NamedQuery(name = "Anuncio.findByAnuncioValor", query = "SELECT a FROM Anuncio a WHERE a.anuncioValor = :anuncioValor"),
    @NamedQuery(name = "Anuncio.findByAnuncioData", query = "SELECT a FROM Anuncio a WHERE a.anuncioData = :anuncioData"),
    @NamedQuery(name = "Anuncio.findByAnuncioTempo", query = "SELECT a FROM Anuncio a WHERE a.anuncioTempo = :anuncioTempo"),
    @NamedQuery(name = "Anuncio.findByAnuncioNivel", query = "SELECT a FROM Anuncio a WHERE a.anuncioNivel = :anuncioNivel"),
    @NamedQuery(name = "Anuncio.findByAnuncioEstatus", query = "SELECT a FROM Anuncio a WHERE a.anuncioEstatus = :anuncioEstatus"),
    @NamedQuery(name = "Anuncio.findByAnuncioRank", query = "SELECT a FROM Anuncio a WHERE a.anuncioRank = :anuncioRank"),
    @NamedQuery(name = "Anuncio.findByAnuncioArquivo", query = "SELECT a FROM Anuncio a WHERE a.anuncioArquivo = :anuncioArquivo"),
    @NamedQuery(name = "Anuncio.findByAnuncioEndereco", query = "SELECT a FROM Anuncio a WHERE a.anuncioEndereco = :anuncioEndereco"),
    @NamedQuery(name = "Anuncio.findByAnuncioBeneficio", query = "SELECT a FROM Anuncio a WHERE a.anuncioBeneficio = :anuncioBeneficio"),
    @NamedQuery(name = "Anuncio.findByAnuncioExperiencia", query = "SELECT a FROM Anuncio a WHERE a.anuncioExperiencia = :anuncioExperiencia"),
    @NamedQuery(name = "Anuncio.findByAnuncioUrl", query = "SELECT a FROM Anuncio a WHERE a.anuncioUrl = :anuncioUrl")})
public class Anuncio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "anuncio_id")
    private Integer anuncioId;
    @Size(max = 45)
    @Column(name = "anuncio_tipo")
    private String anuncioTipo;
    @Size(max = 45)
    @Column(name = "anuncio_categoria")
    private String anuncioCategoria;
    @Size(max = 50)
    @Column(name = "anuncio_titulo")
    private String anuncioTitulo;
    @Size(max = 45)
    @Column(name = "anuncio_tipo_pagamento")
    private String anuncioTipoPagamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "anuncio_valor")
    private Double anuncioValor;
    @Lob
    @Size(max = 16777215)
    @Column(name = "anuncio_descricao")
    private String anuncioDescricao;
    @Column(name = "anuncio_data")
    @Temporal(TemporalType.DATE)
    private Date anuncioData;
    @Column(name = "anuncio_tempo")
    private Integer anuncioTempo;
    @Size(max = 50)
    @Column(name = "anuncio_nivel")
    private String anuncioNivel;
    @Column(name = "anuncio_estatus")
    private Boolean anuncioEstatus;
    @Column(name = "anuncio_rank")
    private Integer anuncioRank;
    @Size(max = 500)
    @Column(name = "anuncio_arquivo")
    private String anuncioArquivo;
    @Size(max = 100)
    @Column(name = "anuncio_endereco")
    private String anuncioEndereco;
    @Size(max = 255)
    @Column(name = "anuncio_beneficio")
    private String anuncioBeneficio;
    @Size(max = 255)
    @Column(name = "anuncio_experiencia")
    private String anuncioExperiencia;
    @Size(max = 300)
    @Column(name = "anuncio_url")
    private String anuncioUrl;
    
    @JoinColumn(name = "conta_conta_id", referencedColumnName = "conta_id")
    @ManyToOne(optional = false)
    private Conta contaContaId;
    
    @JoinColumn(name = "servico_servico_id", referencedColumnName = "servico_id")
    @ManyToOne
    private Servico servicoServicoId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anuncioAnuncioId")
    private List<Proposta> propostaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anuncioAnuncioId")
    private List<Mensagem> mensagemList;

    public Anuncio() {
    }

    public Anuncio(Integer anuncioId) {
        this.anuncioId = anuncioId;
    }

    public Integer getAnuncioId() {
        return anuncioId;
    }

    public void setAnuncioId(Integer anuncioId) {
        this.anuncioId = anuncioId;
    }

    public String getAnuncioTipo() {
        return anuncioTipo;
    }

    public void setAnuncioTipo(String anuncioTipo) {
        this.anuncioTipo = anuncioTipo;
    }

    public String getAnuncioCategoria() {
        return anuncioCategoria;
    }

    public void setAnuncioCategoria(String anuncioCategoria) {
        this.anuncioCategoria = anuncioCategoria;
    }

    public String getAnuncioTitulo() {
        return anuncioTitulo;
    }

    public void setAnuncioTitulo(String anuncioTitulo) {
        this.anuncioTitulo = anuncioTitulo;
    }

    public String getAnuncioTipoPagamento() {
        return anuncioTipoPagamento;
    }

    public void setAnuncioTipoPagamento(String anuncioTipoPagamento) {
        this.anuncioTipoPagamento = anuncioTipoPagamento;
    }

    public Double getAnuncioValor() {
        return anuncioValor;
    }

    public void setAnuncioValor(Double anuncioValor) {
        this.anuncioValor = anuncioValor;
    }

    public String getAnuncioDescricao() {
        return anuncioDescricao;
    }

    public void setAnuncioDescricao(String anuncioDescricao) {
        this.anuncioDescricao = anuncioDescricao;
    }

    public Date getAnuncioData() {
        return anuncioData;
    }

    public void setAnuncioData(Date anuncioData) {
        this.anuncioData = anuncioData;
    }

    public Integer getAnuncioTempo() {
        return anuncioTempo;
    }

    public void setAnuncioTempo(Integer anuncioTempo) {
        this.anuncioTempo = anuncioTempo;
    }

    public String getAnuncioNivel() {
        return anuncioNivel;
    }

    public void setAnuncioNivel(String anuncioNivel) {
        this.anuncioNivel = anuncioNivel;
    }

    public Boolean getAnuncioEstatus() {
        return anuncioEstatus;
    }

    public void setAnuncioEstatus(Boolean anuncioEstatus) {
        this.anuncioEstatus = anuncioEstatus;
    }

    public Integer getAnuncioRank() {
        return anuncioRank;
    }

    public void setAnuncioRank(Integer anuncioRank) {
        this.anuncioRank = anuncioRank;
    }

    public String getAnuncioArquivo() {
        return anuncioArquivo;
    }

    public void setAnuncioArquivo(String anuncioArquivo) {
        this.anuncioArquivo = anuncioArquivo;
    }

    public String getAnuncioEndereco() {
        return anuncioEndereco;
    }

    public void setAnuncioEndereco(String anuncioEndereco) {
        this.anuncioEndereco = anuncioEndereco;
    }

    public String getAnuncioBeneficio() {
        return anuncioBeneficio;
    }

    public void setAnuncioBeneficio(String anuncioBeneficio) {
        this.anuncioBeneficio = anuncioBeneficio;
    }

    public String getAnuncioExperiencia() {
        return anuncioExperiencia;
    }

    public void setAnuncioExperiencia(String anuncioExperiencia) {
        this.anuncioExperiencia = anuncioExperiencia;
    }

    public String getAnuncioUrl() {
        return anuncioUrl;
    }

    public void setAnuncioUrl(String anuncioUrl) {
        this.anuncioUrl = anuncioUrl;
    }

    public Conta getContaContaId() {
        return contaContaId;
    }

    public void setContaContaId(Conta contaContaId) {
        this.contaContaId = contaContaId;
    }

    public Servico getServicoServicoId() {
        return servicoServicoId;
    }

    public void setServicoServicoId(Servico servicoServicoId) {
        this.servicoServicoId = servicoServicoId;
    }

    @XmlTransient
    public List<Proposta> getPropostaList() {
        return propostaList;
    }

    public void setPropostaList(List<Proposta> propostaList) {
        this.propostaList = propostaList;
    }

    @XmlTransient
    public List<Mensagem> getMensagemList() {
        return mensagemList;
    }

    public void setMensagemList(List<Mensagem> mensagemList) {
        this.mensagemList = mensagemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anuncioId != null ? anuncioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anuncio)) {
            return false;
        }
        Anuncio other = (Anuncio) object;
        if ((this.anuncioId == null && other.anuncioId != null) || (this.anuncioId != null && !this.anuncioId.equals(other.anuncioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.freedomsoftware.jsnprototipo.modelo.Anuncio[ anuncioId=" + anuncioId + " ]";
    }
    
}
