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
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByCompraId", query = "SELECT c FROM Compra c WHERE c.compraId = :compraId"),
    @NamedQuery(name = "Compra.findByCompraData", query = "SELECT c FROM Compra c WHERE c.compraData = :compraData"),
    @NamedQuery(name = "Compra.findByCompraTipo", query = "SELECT c FROM Compra c WHERE c.compraTipo = :compraTipo"),
    @NamedQuery(name = "Compra.findByCompraDescricao", query = "SELECT c FROM Compra c WHERE c.compraDescricao = :compraDescricao"),
    @NamedQuery(name = "Compra.findByCompraForma", query = "SELECT c FROM Compra c WHERE c.compraForma = :compraForma"),
    @NamedQuery(name = "Compra.findByCompraQuantidade", query = "SELECT c FROM Compra c WHERE c.compraQuantidade = :compraQuantidade"),
    @NamedQuery(name = "Compra.findByCompraValor", query = "SELECT c FROM Compra c WHERE c.compraValor = :compraValor"),
    @NamedQuery(name = "Compra.findByCompraTotal", query = "SELECT c FROM Compra c WHERE c.compraTotal = :compraTotal")})
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "compra_id")
    private Integer compraId;
    @Column(name = "compra_data")
    @Temporal(TemporalType.DATE)
    private Date compraData;
    @Size(max = 45)
    @Column(name = "compra_tipo")
    private String compraTipo;
    @Size(max = 200)
    @Column(name = "compra_descricao")
    private String compraDescricao;
    @Size(max = 45)
    @Column(name = "compra_forma")
    private String compraForma;
    @Column(name = "compra_quantidade")
    private Integer compraQuantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "compra_valor")
    private Double compraValor;
    @Column(name = "compra_total")
    private Double compraTotal;
    @JoinColumn(name = "conta_conta_id", referencedColumnName = "conta_id")
    @ManyToOne(optional = false)
    private Conta contaContaId;
    @JoinColumn(name = "produto_produto_id", referencedColumnName = "produto_id")
    @ManyToOne(optional = false)
    private Produto produtoProdutoId;

    public Compra() {
    }

    public Compra(Integer compraId) {
        this.compraId = compraId;
    }

    public Integer getCompraId() {
        return compraId;
    }

    public void setCompraId(Integer compraId) {
        this.compraId = compraId;
    }

    public Date getCompraData() {
        return compraData;
    }

    public void setCompraData(Date compraData) {
        this.compraData = compraData;
    }

    public String getCompraTipo() {
        return compraTipo;
    }

    public void setCompraTipo(String compraTipo) {
        this.compraTipo = compraTipo;
    }

    public String getCompraDescricao() {
        return compraDescricao;
    }

    public void setCompraDescricao(String compraDescricao) {
        this.compraDescricao = compraDescricao;
    }

    public String getCompraForma() {
        return compraForma;
    }

    public void setCompraForma(String compraForma) {
        this.compraForma = compraForma;
    }

    public Integer getCompraQuantidade() {
        return compraQuantidade;
    }

    public void setCompraQuantidade(Integer compraQuantidade) {
        this.compraQuantidade = compraQuantidade;
    }

    public Double getCompraValor() {
        return compraValor;
    }

    public void setCompraValor(Double compraValor) {
        this.compraValor = compraValor;
    }

    public Double getCompraTotal() {
        return compraTotal;
    }

    public void setCompraTotal(Double compraTotal) {
        this.compraTotal = compraTotal;
    }

    public Conta getContaContaId() {
        return contaContaId;
    }

    public void setContaContaId(Conta contaContaId) {
        this.contaContaId = contaContaId;
    }

    public Produto getProdutoProdutoId() {
        return produtoProdutoId;
    }

    public void setProdutoProdutoId(Produto produtoProdutoId) {
        this.produtoProdutoId = produtoProdutoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraId != null ? compraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.compraId == null && other.compraId != null) || (this.compraId != null && !this.compraId.equals(other.compraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.freedomsoftware.jsnprototipo.modelo.Compra[ compraId=" + compraId + " ]";
    }
    
}
