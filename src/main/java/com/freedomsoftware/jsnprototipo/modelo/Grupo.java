/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freedomsoftware.jsnprototipo.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jeison
 */
@Entity
@Table(name = "grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findByGrupoId", query = "SELECT g FROM Grupo g WHERE g.grupoId = :grupoId"),
    @NamedQuery(name = "Grupo.findByGrupoDescricao", query = "SELECT g FROM Grupo g WHERE g.grupoDescricao = :grupoDescricao"),
    @NamedQuery(name = "Grupo.findByGrupoSeguranca", query = "SELECT g FROM Grupo g WHERE g.grupoSeguranca = :grupoSeguranca"),
    @NamedQuery(name = "Grupo.findByGrupoNome", query = "SELECT g FROM Grupo g WHERE g.grupoNome = :grupoNome"),
    @NamedQuery(name = "Grupo.findByGrupoNivel", query = "SELECT g FROM Grupo g WHERE g.grupoNivel = :grupoNivel"),
    @NamedQuery(name = "Grupo.findByGrupoTipo", query = "SELECT g FROM Grupo g WHERE g.grupoTipo = :grupoTipo")})
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "grupo_id")
    private Integer grupoId;
    @Size(max = 300)
    @Column(name = "grupo_descricao")
    private String grupoDescricao;
    @Size(max = 45)
    @Column(name = "grupo_seguranca")
    private String grupoSeguranca;
    @Size(max = 45)
    @Column(name = "grupo_nome")
    private String grupoNome;
    @Size(max = 45)
    @Column(name = "grupo_nivel")
    private String grupoNivel;
    @Size(max = 45)
    @Column(name = "grupo_tipo")
    private String grupoTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoGrupoId")
    private List<GrupoConta> grupoContaList;

    public Grupo() {
    }

    public Grupo(Integer grupoId) {
        this.grupoId = grupoId;
    }

    public Integer getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Integer grupoId) {
        this.grupoId = grupoId;
    }

    public String getGrupoDescricao() {
        return grupoDescricao;
    }

    public void setGrupoDescricao(String grupoDescricao) {
        this.grupoDescricao = grupoDescricao;
    }

    public String getGrupoSeguranca() {
        return grupoSeguranca;
    }

    public void setGrupoSeguranca(String grupoSeguranca) {
        this.grupoSeguranca = grupoSeguranca;
    }

    public String getGrupoNome() {
        return grupoNome;
    }

    public void setGrupoNome(String grupoNome) {
        this.grupoNome = grupoNome;
    }

    public String getGrupoNivel() {
        return grupoNivel;
    }

    public void setGrupoNivel(String grupoNivel) {
        this.grupoNivel = grupoNivel;
    }

    public String getGrupoTipo() {
        return grupoTipo;
    }

    public void setGrupoTipo(String grupoTipo) {
        this.grupoTipo = grupoTipo;
    }

    @XmlTransient
    public List<GrupoConta> getGrupoContaList() {
        return grupoContaList;
    }

    public void setGrupoContaList(List<GrupoConta> grupoContaList) {
        this.grupoContaList = grupoContaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoId != null ? grupoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.grupoId == null && other.grupoId != null) || (this.grupoId != null && !this.grupoId.equals(other.grupoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.freedomsoftware.jsnprototipo.modelo.Grupo[ grupoId=" + grupoId + " ]";
    }
    
}
