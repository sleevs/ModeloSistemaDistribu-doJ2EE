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
@Table(name = "qualificacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qualificacao.findAll", query = "SELECT q FROM Qualificacao q"),
    @NamedQuery(name = "Qualificacao.findByQualificacaoId", query = "SELECT q FROM Qualificacao q WHERE q.qualificacaoId = :qualificacaoId"),
    @NamedQuery(name = "Qualificacao.findByQualificacaoNumeroServico", query = "SELECT q FROM Qualificacao q WHERE q.qualificacaoNumeroServico = :qualificacaoNumeroServico"),
    @NamedQuery(name = "Qualificacao.findByQualificacaoServicoConcretizado", query = "SELECT q FROM Qualificacao q WHERE q.qualificacaoServicoConcretizado = :qualificacaoServicoConcretizado"),
    @NamedQuery(name = "Qualificacao.findByQualificacaoPonto", query = "SELECT q FROM Qualificacao q WHERE q.qualificacaoPonto = :qualificacaoPonto"),
    @NamedQuery(name = "Qualificacao.findByQualificacaoPontoPositivo", query = "SELECT q FROM Qualificacao q WHERE q.qualificacaoPontoPositivo = :qualificacaoPontoPositivo"),
    @NamedQuery(name = "Qualificacao.findByQualificacaoPontoNegativo", query = "SELECT q FROM Qualificacao q WHERE q.qualificacaoPontoNegativo = :qualificacaoPontoNegativo"),
    @NamedQuery(name = "Qualificacao.findByQualificacaoServicoIncompleto", query = "SELECT q FROM Qualificacao q WHERE q.qualificacaoServicoIncompleto = :qualificacaoServicoIncompleto"),
    @NamedQuery(name = "Qualificacao.findByQualificacaoData", query = "SELECT q FROM Qualificacao q WHERE q.qualificacaoData = :qualificacaoData")})
public class Qualificacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "qualificacao_id")
    private Integer qualificacaoId;
    @Column(name = "qualificacao_numero_servico")
    private Integer qualificacaoNumeroServico;
    @Column(name = "qualificacao_servico_concretizado")
    private Integer qualificacaoServicoConcretizado;
    @Column(name = "qualificacao_ponto")
    private Integer qualificacaoPonto;
    @Column(name = "qualificacao_ponto_positivo")
    private Integer qualificacaoPontoPositivo;
    @Column(name = "qualificacao_ponto_negativo")
    private Integer qualificacaoPontoNegativo;
    @Lob
    @Size(max = 16777215)
    @Column(name = "qualificacao_descricao")
    private String qualificacaoDescricao;
    @Column(name = "qualificacao_servico_incompleto")
    private Integer qualificacaoServicoIncompleto;
    @Column(name = "qualificacao_data")
    @Temporal(TemporalType.DATE)
    private Date qualificacaoData;
    @JoinColumn(name = "conta_conta_id", referencedColumnName = "conta_id")
    @ManyToOne(optional = false)
    private Conta contaContaId;
    @JoinColumn(name = "servico_servico_id", referencedColumnName = "servico_id")
    @ManyToOne(optional = false)
    private Servico servicoServicoId;

    public Qualificacao() {
    }

    public Qualificacao(Integer qualificacaoId) {
        this.qualificacaoId = qualificacaoId;
    }

    public Integer getQualificacaoId() {
        return qualificacaoId;
    }

    public void setQualificacaoId(Integer qualificacaoId) {
        this.qualificacaoId = qualificacaoId;
    }

    public Integer getQualificacaoNumeroServico() {
        return qualificacaoNumeroServico;
    }

    public void setQualificacaoNumeroServico(Integer qualificacaoNumeroServico) {
        this.qualificacaoNumeroServico = qualificacaoNumeroServico;
    }

    public Integer getQualificacaoServicoConcretizado() {
        return qualificacaoServicoConcretizado;
    }

    public void setQualificacaoServicoConcretizado(Integer qualificacaoServicoConcretizado) {
        this.qualificacaoServicoConcretizado = qualificacaoServicoConcretizado;
    }

    public Integer getQualificacaoPonto() {
        return qualificacaoPonto;
    }

    public void setQualificacaoPonto(Integer qualificacaoPonto) {
        this.qualificacaoPonto = qualificacaoPonto;
    }

    public Integer getQualificacaoPontoPositivo() {
        return qualificacaoPontoPositivo;
    }

    public void setQualificacaoPontoPositivo(Integer qualificacaoPontoPositivo) {
        this.qualificacaoPontoPositivo = qualificacaoPontoPositivo;
    }

    public Integer getQualificacaoPontoNegativo() {
        return qualificacaoPontoNegativo;
    }

    public void setQualificacaoPontoNegativo(Integer qualificacaoPontoNegativo) {
        this.qualificacaoPontoNegativo = qualificacaoPontoNegativo;
    }

    public String getQualificacaoDescricao() {
        return qualificacaoDescricao;
    }

    public void setQualificacaoDescricao(String qualificacaoDescricao) {
        this.qualificacaoDescricao = qualificacaoDescricao;
    }

    public Integer getQualificacaoServicoIncompleto() {
        return qualificacaoServicoIncompleto;
    }

    public void setQualificacaoServicoIncompleto(Integer qualificacaoServicoIncompleto) {
        this.qualificacaoServicoIncompleto = qualificacaoServicoIncompleto;
    }

    public Date getQualificacaoData() {
        return qualificacaoData;
    }

    public void setQualificacaoData(Date qualificacaoData) {
        this.qualificacaoData = qualificacaoData;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qualificacaoId != null ? qualificacaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qualificacao)) {
            return false;
        }
        Qualificacao other = (Qualificacao) object;
        if ((this.qualificacaoId == null && other.qualificacaoId != null) || (this.qualificacaoId != null && !this.qualificacaoId.equals(other.qualificacaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.freedomsoftware.jsnprototipo.modelo.Qualificacao[ qualificacaoId=" + qualificacaoId + " ]";
    }
    
}
