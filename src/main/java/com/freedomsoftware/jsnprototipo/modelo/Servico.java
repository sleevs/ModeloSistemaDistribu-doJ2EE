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
import javax.persistence.Lob;
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
@Table(name = "servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s"),
    @NamedQuery(name = "Servico.findByServicoId", query = "SELECT s FROM Servico s WHERE s.servicoId = :servicoId"),
    @NamedQuery(name = "Servico.findByServicoTipo", query = "SELECT s FROM Servico s WHERE s.servicoTipo = :servicoTipo"),
    @NamedQuery(name = "Servico.findByServicoCategoria", query = "SELECT s FROM Servico s WHERE s.servicoCategoria = :servicoCategoria"),
    @NamedQuery(name = "Servico.findByServicoData", query = "SELECT s FROM Servico s WHERE s.servicoData = :servicoData"),
    @NamedQuery(name = "Servico.findByServicoContrato", query = "SELECT s FROM Servico s WHERE s.servicoContrato = :servicoContrato"),
    @NamedQuery(name = "Servico.findByServicoStatus", query = "SELECT s FROM Servico s WHERE s.servicoStatus = :servicoStatus")})
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "servico_id")
    private Integer servicoId;
    @Size(max = 50)
    @Column(name = "servico_tipo")
    private String servicoTipo;
    @Size(max = 100)
    @Column(name = "servico_categoria")
    private String servicoCategoria;
    @Column(name = "servico_data")
    @Temporal(TemporalType.DATE)
    private Date servicoData;
    @Lob
    @Size(max = 16777215)
    @Column(name = "servico_descricao")
    private String servicoDescricao;
    @Size(max = 45)
    @Column(name = "servico_contrato")
    private String servicoContrato;
    @Column(name = "servico_status")
    private Integer servicoStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicoServicoId")
    private List<Qualificacao> qualificacaoList;
    @OneToMany(mappedBy = "servicoServicoId")
    private List<Anuncio> anuncioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicoServicoId")
    private List<Pagamento> pagamentoList;

    public Servico() {
    }

    public Servico(Integer servicoId) {
        this.servicoId = servicoId;
    }

    public Integer getServicoId() {
        return servicoId;
    }

    public void setServicoId(Integer servicoId) {
        this.servicoId = servicoId;
    }

    public String getServicoTipo() {
        return servicoTipo;
    }

    public void setServicoTipo(String servicoTipo) {
        this.servicoTipo = servicoTipo;
    }

    public String getServicoCategoria() {
        return servicoCategoria;
    }

    public void setServicoCategoria(String servicoCategoria) {
        this.servicoCategoria = servicoCategoria;
    }

    public Date getServicoData() {
        return servicoData;
    }

    public void setServicoData(Date servicoData) {
        this.servicoData = servicoData;
    }

    public String getServicoDescricao() {
        return servicoDescricao;
    }

    public void setServicoDescricao(String servicoDescricao) {
        this.servicoDescricao = servicoDescricao;
    }

    public String getServicoContrato() {
        return servicoContrato;
    }

    public void setServicoContrato(String servicoContrato) {
        this.servicoContrato = servicoContrato;
    }

    public Integer getServicoStatus() {
        return servicoStatus;
    }

    public void setServicoStatus(Integer servicoStatus) {
        this.servicoStatus = servicoStatus;
    }

    @XmlTransient
    public List<Qualificacao> getQualificacaoList() {
        return qualificacaoList;
    }

    public void setQualificacaoList(List<Qualificacao> qualificacaoList) {
        this.qualificacaoList = qualificacaoList;
    }

    @XmlTransient
    public List<Anuncio> getAnuncioList() {
        return anuncioList;
    }

    public void setAnuncioList(List<Anuncio> anuncioList) {
        this.anuncioList = anuncioList;
    }

    @XmlTransient
    public List<Pagamento> getPagamentoList() {
        return pagamentoList;
    }

    public void setPagamentoList(List<Pagamento> pagamentoList) {
        this.pagamentoList = pagamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicoId != null ? servicoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.servicoId == null && other.servicoId != null) || (this.servicoId != null && !this.servicoId.equals(other.servicoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.freedomsoftware.jsnprototipo.modelo.Servico[ servicoId=" + servicoId + " ]";
    }
    
}
