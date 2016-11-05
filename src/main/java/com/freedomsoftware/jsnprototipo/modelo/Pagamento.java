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
@Table(name = "pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p"),
    @NamedQuery(name = "Pagamento.findByPagamentoId", query = "SELECT p FROM Pagamento p WHERE p.pagamentoId = :pagamentoId"),
    @NamedQuery(name = "Pagamento.findByPagamentoData", query = "SELECT p FROM Pagamento p WHERE p.pagamentoData = :pagamentoData"),
    @NamedQuery(name = "Pagamento.findByPagamentoForma", query = "SELECT p FROM Pagamento p WHERE p.pagamentoForma = :pagamentoForma"),
    @NamedQuery(name = "Pagamento.findByPagamentoValor", query = "SELECT p FROM Pagamento p WHERE p.pagamentoValor = :pagamentoValor"),
    @NamedQuery(name = "Pagamento.findByPagamentoTotal", query = "SELECT p FROM Pagamento p WHERE p.pagamentoTotal = :pagamentoTotal")})
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pagamento_id")
    private Integer pagamentoId;
    @Column(name = "pagamento_data")
    @Temporal(TemporalType.DATE)
    private Date pagamentoData;
    @Size(max = 45)
    @Column(name = "pagamento_forma")
    private String pagamentoForma;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pagamento_valor")
    private Double pagamentoValor;
    @Column(name = "pagamento_total")
    private Double pagamentoTotal;
    @JoinColumn(name = "conta_conta_id", referencedColumnName = "conta_id")
    @ManyToOne(optional = false)
    private Conta contaContaId;
    @JoinColumn(name = "servico_servico_id", referencedColumnName = "servico_id")
    @ManyToOne(optional = false)
    private Servico servicoServicoId;

    public Pagamento() {
    }

    public Pagamento(Integer pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public Integer getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(Integer pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public Date getPagamentoData() {
        return pagamentoData;
    }

    public void setPagamentoData(Date pagamentoData) {
        this.pagamentoData = pagamentoData;
    }

    public String getPagamentoForma() {
        return pagamentoForma;
    }

    public void setPagamentoForma(String pagamentoForma) {
        this.pagamentoForma = pagamentoForma;
    }

    public Double getPagamentoValor() {
        return pagamentoValor;
    }

    public void setPagamentoValor(Double pagamentoValor) {
        this.pagamentoValor = pagamentoValor;
    }

    public Double getPagamentoTotal() {
        return pagamentoTotal;
    }

    public void setPagamentoTotal(Double pagamentoTotal) {
        this.pagamentoTotal = pagamentoTotal;
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
        hash += (pagamentoId != null ? pagamentoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamento)) {
            return false;
        }
        Pagamento other = (Pagamento) object;
        if ((this.pagamentoId == null && other.pagamentoId != null) || (this.pagamentoId != null && !this.pagamentoId.equals(other.pagamentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.freedomsoftware.jsnprototipo.modelo.Pagamento[ pagamentoId=" + pagamentoId + " ]";
    }
    
}
