/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jeison
 */
@Entity
@Table(name = "grupo_conta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoConta.findAll", query = "SELECT g FROM GrupoConta g"),
    @NamedQuery(name = "GrupoConta.findByGrupoContaId", query = "SELECT g FROM GrupoConta g WHERE g.grupoContaId = :grupoContaId")})
public class GrupoConta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grupo_conta_id")
    private Integer grupoContaId;
    @JoinColumn(name = "conta_conta_id", referencedColumnName = "conta_id")
    @ManyToOne(optional = false)
    private Conta contaContaId;
    @JoinColumn(name = "grupo_grupo_id", referencedColumnName = "grupo_id")
    @ManyToOne(optional = false)
    private Grupo grupoGrupoId;

    public GrupoConta() {
    }

    public GrupoConta(Integer grupoContaId) {
        this.grupoContaId = grupoContaId;
    }

    public Integer getGrupoContaId() {
        return grupoContaId;
    }

    public void setGrupoContaId(Integer grupoContaId) {
        this.grupoContaId = grupoContaId;
    }

    public Conta getContaContaId() {
        return contaContaId;
    }

    public void setContaContaId(Conta contaContaId) {
        this.contaContaId = contaContaId;
    }

    public Grupo getGrupoGrupoId() {
        return grupoGrupoId;
    }

    public void setGrupoGrupoId(Grupo grupoGrupoId) {
        this.grupoGrupoId = grupoGrupoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoContaId != null ? grupoContaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoConta)) {
            return false;
        }
        GrupoConta other = (GrupoConta) object;
        if ((this.grupoContaId == null && other.grupoContaId != null) || (this.grupoContaId != null && !this.grupoContaId.equals(other.grupoContaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.freedomsoftware.jsnprototipo.modelo.GrupoConta[ grupoContaId=" + grupoContaId + " ]";
    }
    
}
