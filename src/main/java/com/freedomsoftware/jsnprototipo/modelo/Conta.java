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
@Table(name = "conta")
@XmlRootElement
@NamedQueries({
    
    @NamedQuery(name = "Conta.login", query = "SELECT c FROM Conta c WHERE c.contaEmail = :contaEmail AND c.contaSenha = :contaSenha"),
    @NamedQuery(name = "Conta.findAll", query = "SELECT c FROM Conta c"),
    @NamedQuery(name = "Conta.findByContaId", query = "SELECT c FROM Conta c WHERE c.contaId = :contaId"),
    @NamedQuery(name = "Conta.findByContaData", query = "SELECT c FROM Conta c WHERE c.contaData = :contaData"),
    @NamedQuery(name = "Conta.findByContaTipo", query = "SELECT c FROM Conta c WHERE c.contaTipo = :contaTipo"),
    @NamedQuery(name = "Conta.findByContaCategoria", query = "SELECT c FROM Conta c WHERE c.contaCategoria = :contaCategoria"),
    @NamedQuery(name = "Conta.findByContaEstatus", query = "SELECT c FROM Conta c WHERE c.contaEstatus = :contaEstatus"),
    @NamedQuery(name = "Conta.findByContaLogin", query = "SELECT c FROM Conta c WHERE c.contaLogin = :contaLogin"),
    @NamedQuery(name = "Conta.findByContaEmail", query = "SELECT c FROM Conta c WHERE c.contaEmail = :contaEmail"),
    @NamedQuery(name = "Conta.findByContaSenha", query = "SELECT c FROM Conta c WHERE c.contaSenha = :contaSenha"),
    @NamedQuery(name = "Conta.findByContaNome", query = "SELECT c FROM Conta c WHERE c.contaNome = :contaNome"),
    @NamedQuery(name = "Conta.findByContaSobrenome", query = "SELECT c FROM Conta c WHERE c.contaSobrenome = :contaSobrenome"),
    @NamedQuery(name = "Conta.findByContaNascimento", query = "SELECT c FROM Conta c WHERE c.contaNascimento = :contaNascimento"),
    @NamedQuery(name = "Conta.findByContaSexo", query = "SELECT c FROM Conta c WHERE c.contaSexo = :contaSexo"),
    @NamedQuery(name = "Conta.findByContaFoto", query = "SELECT c FROM Conta c WHERE c.contaFoto = :contaFoto"),
    @NamedQuery(name = "Conta.findByContaCpf", query = "SELECT c FROM Conta c WHERE c.contaCpf = :contaCpf"),
    @NamedQuery(name = "Conta.findByContaCnpj", query = "SELECT c FROM Conta c WHERE c.contaCnpj = :contaCnpj"),
    @NamedQuery(name = "Conta.findByContaCep", query = "SELECT c FROM Conta c WHERE c.contaCep = :contaCep"),
    @NamedQuery(name = "Conta.findByContaEndereco", query = "SELECT c FROM Conta c WHERE c.contaEndereco = :contaEndereco"),
    @NamedQuery(name = "Conta.findByContaBairro", query = "SELECT c FROM Conta c WHERE c.contaBairro = :contaBairro"),
    @NamedQuery(name = "Conta.findByContaCidade", query = "SELECT c FROM Conta c WHERE c.contaCidade = :contaCidade"),
    @NamedQuery(name = "Conta.findByContaUf", query = "SELECT c FROM Conta c WHERE c.contaUf = :contaUf"),
    @NamedQuery(name = "Conta.findByContaPais", query = "SELECT c FROM Conta c WHERE c.contaPais = :contaPais"),
    @NamedQuery(name = "Conta.findByContaArquivo", query = "SELECT c FROM Conta c WHERE c.contaArquivo = :contaArquivo"),
    @NamedQuery(name = "Conta.findByContaTema", query = "SELECT c FROM Conta c WHERE c.contaTema = :contaTema"),
    @NamedQuery(name = "Conta.findByContaVideo", query = "SELECT c FROM Conta c WHERE c.contaVideo = :contaVideo"),
    @NamedQuery(name = "Conta.findByContaAudio", query = "SELECT c FROM Conta c WHERE c.contaAudio = :contaAudio"),
    @NamedQuery(name = "Conta.findByContaLatitude", query = "SELECT c FROM Conta c WHERE c.contaLatitude = :contaLatitude"),
    @NamedQuery(name = "Conta.findByContaLongetude", query = "SELECT c FROM Conta c WHERE c.contaLongetude = :contaLongetude"),
    @NamedQuery(name = "Conta.findByContaImagens", query = "SELECT c FROM Conta c WHERE c.contaImagens = :contaImagens"),
    @NamedQuery(name = "Conta.findByContaDescricao", query = "SELECT c FROM Conta c WHERE c.contaDescricao = :contaDescricao"),
    @NamedQuery(name = "Conta.findByContaRank", query = "SELECT c FROM Conta c WHERE c.contaRank = :contaRank"),
    @NamedQuery(name = "Conta.findByContaSeguranca", query = "SELECT c FROM Conta c WHERE c.contaSeguranca = :contaSeguranca")})
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "conta_id")
    private Integer contaId;
    @Column(name = "conta_data")
    @Temporal(TemporalType.DATE)
    private Date contaData;
    @Size(max = 60)
    @Column(name = "conta_tipo")
    private String contaTipo;
    @Size(max = 60)
    @Column(name = "conta_categoria")
    private String contaCategoria;
    @Column(name = "conta_estatus")
    private Boolean contaEstatus;
    @Size(max = 60)
    @Column(name = "conta_login")
    private String contaLogin;
    @Size(max = 60)
    @Column(name = "conta_email")
    private String contaEmail;
    @Size(max = 10)
    @Column(name = "conta_senha")
    private String contaSenha;
    @Size(max = 60)
    @Column(name = "conta_nome")
    private String contaNome;
    @Size(max = 60)
    @Column(name = "conta_sobrenome")
    private String contaSobrenome;
    @Column(name = "conta_nascimento")
    @Temporal(TemporalType.DATE)
    private Date contaNascimento;
    @Size(max = 60)
    @Column(name = "conta_sexo")
    private String contaSexo;
    @Lob
    @Size(max = 16777215)
    @Column(name = "conta_telefone")
    private String contaTelefone;
    @Size(max = 500)
    @Column(name = "conta_foto")
    private String contaFoto;
    @Size(max = 60)
    @Column(name = "conta_cpf")
    private String contaCpf;
    @Size(max = 60)
    @Column(name = "conta_cnpj")
    private String contaCnpj;
    @Size(max = 60)
    @Column(name = "conta_cep")
    private String contaCep;
    @Size(max = 60)
    @Column(name = "conta_endereco")
    private String contaEndereco;
    @Size(max = 60)
    @Column(name = "conta_bairro")
    private String contaBairro;
    @Size(max = 60)
    @Column(name = "conta_cidade")
    private String contaCidade;
    @Size(max = 60)
    @Column(name = "conta_uf")
    private String contaUf;
    @Size(max = 100)
    @Column(name = "conta_pais")
    private String contaPais;
    @Size(max = 500)
    @Column(name = "conta_arquivo")
    private String contaArquivo;
    @Size(max = 500)
    @Column(name = "conta_tema")
    private String contaTema;
    @Size(max = 500)
    @Column(name = "conta_video")
    private String contaVideo;
    @Size(max = 500)
    @Column(name = "conta_audio")
    private String contaAudio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "conta_latitude")
    private Double contaLatitude;
    @Column(name = "conta_longetude")
    private Double contaLongetude;
    @Size(max = 500)
    @Column(name = "conta_imagens")
    private String contaImagens;
    @Size(max = 60)
    @Column(name = "conta_descricao")
    private String contaDescricao;
    @Column(name = "conta_rank")
    private Integer contaRank;
    
    @Size(max = 60)
    @Column(name = "conta_seguranca")
    private String contaSeguranca;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaContaId")
    private List<GrupoConta> grupoContaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaContaId")
    private List<Qualificacao> qualificacaoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaContaId")
    private List<Compra> compraList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaContaId")
    private List<ClienteWebservice> clienteWebserviceList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaContaId")
    private List<Anuncio> anuncioList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaContaId")
    private List<Proposta> propostaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaContaId")
    private List<Mensagem> mensagemList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contaContaId")
    private List<Pagamento> pagamentoList;

    public Conta() {
    }

    public Conta(Integer contaId) {
        this.contaId = contaId;
    }

    public Integer getContaId() {
        return contaId;
    }

    public void setContaId(Integer contaId) {
        this.contaId = contaId;
    }

    public Date getContaData() {
        return contaData;
    }

    public void setContaData(Date contaData) {
        this.contaData = contaData;
    }

    public String getContaTipo() {
        return contaTipo;
    }

    public void setContaTipo(String contaTipo) {
        this.contaTipo = contaTipo;
    }

    public String getContaCategoria() {
        return contaCategoria;
    }

    public void setContaCategoria(String contaCategoria) {
        this.contaCategoria = contaCategoria;
    }

    public Boolean getContaEstatus() {
        return contaEstatus;
    }

    public void setContaEstatus(Boolean contaEstatus) {
        this.contaEstatus = contaEstatus;
    }

    public String getContaLogin() {
        return contaLogin;
    }

    public void setContaLogin(String contaLogin) {
        this.contaLogin = contaLogin;
    }

    public String getContaEmail() {
        return contaEmail;
    }

    public void setContaEmail(String contaEmail) {
        this.contaEmail = contaEmail;
    }

    public String getContaSenha() {
        return contaSenha;
    }

    public void setContaSenha(String contaSenha) {
        this.contaSenha = contaSenha;
    }

    public String getContaNome() {
        return contaNome;
    }

    public void setContaNome(String contaNome) {
        this.contaNome = contaNome;
    }

    public String getContaSobrenome() {
        return contaSobrenome;
    }

    public void setContaSobrenome(String contaSobrenome) {
        this.contaSobrenome = contaSobrenome;
    }

    public Date getContaNascimento() {
        return contaNascimento;
    }

    public void setContaNascimento(Date contaNascimento) {
        this.contaNascimento = contaNascimento;
    }

    public String getContaSexo() {
        return contaSexo;
    }

    public void setContaSexo(String contaSexo) {
        this.contaSexo = contaSexo;
    }

    public String getContaTelefone() {
        return contaTelefone;
    }

    public void setContaTelefone(String contaTelefone) {
        this.contaTelefone = contaTelefone;
    }

    public String getContaFoto() {
        return contaFoto;
    }

    public void setContaFoto(String contaFoto) {
        this.contaFoto = contaFoto;
    }

    public String getContaCpf() {
        return contaCpf;
    }

    public void setContaCpf(String contaCpf) {
        this.contaCpf = contaCpf;
    }

    public String getContaCnpj() {
        return contaCnpj;
    }

    public void setContaCnpj(String contaCnpj) {
        this.contaCnpj = contaCnpj;
    }

    public String getContaCep() {
        return contaCep;
    }

    public void setContaCep(String contaCep) {
        this.contaCep = contaCep;
    }

    public String getContaEndereco() {
        return contaEndereco;
    }

    public void setContaEndereco(String contaEndereco) {
        this.contaEndereco = contaEndereco;
    }

    public String getContaBairro() {
        return contaBairro;
    }

    public void setContaBairro(String contaBairro) {
        this.contaBairro = contaBairro;
    }

    public String getContaCidade() {
        return contaCidade;
    }

    public void setContaCidade(String contaCidade) {
        this.contaCidade = contaCidade;
    }

    public String getContaUf() {
        return contaUf;
    }

    public void setContaUf(String contaUf) {
        this.contaUf = contaUf;
    }

    public String getContaPais() {
        return contaPais;
    }

    public void setContaPais(String contaPais) {
        this.contaPais = contaPais;
    }

    public String getContaArquivo() {
        return contaArquivo;
    }

    public void setContaArquivo(String contaArquivo) {
        this.contaArquivo = contaArquivo;
    }

    public String getContaTema() {
        return contaTema;
    }

    public void setContaTema(String contaTema) {
        this.contaTema = contaTema;
    }

    public String getContaVideo() {
        return contaVideo;
    }

    public void setContaVideo(String contaVideo) {
        this.contaVideo = contaVideo;
    }

    public String getContaAudio() {
        return contaAudio;
    }

    public void setContaAudio(String contaAudio) {
        this.contaAudio = contaAudio;
    }

    public Double getContaLatitude() {
        return contaLatitude;
    }

    public void setContaLatitude(Double contaLatitude) {
        this.contaLatitude = contaLatitude;
    }

    public Double getContaLongetude() {
        return contaLongetude;
    }

    public void setContaLongetude(Double contaLongetude) {
        this.contaLongetude = contaLongetude;
    }

    public String getContaImagens() {
        return contaImagens;
    }

    public void setContaImagens(String contaImagens) {
        this.contaImagens = contaImagens;
    }

    public String getContaDescricao() {
        return contaDescricao;
    }

    public void setContaDescricao(String contaDescricao) {
        this.contaDescricao = contaDescricao;
    }

    public Integer getContaRank() {
        return contaRank;
    }

    public void setContaRank(Integer contaRank) {
        this.contaRank = contaRank;
    }

    public String getContaSeguranca() {
        return contaSeguranca;
    }

    public void setContaSeguranca(String contaSeguranca) {
        this.contaSeguranca = contaSeguranca;
    }

    @XmlTransient
    public List<GrupoConta> getGrupoContaList() {
        return grupoContaList;
    }

    public void setGrupoContaList(List<GrupoConta> grupoContaList) {
        this.grupoContaList = grupoContaList;
    }

    @XmlTransient
    public List<Qualificacao> getQualificacaoList() {
        return qualificacaoList;
    }

    public void setQualificacaoList(List<Qualificacao> qualificacaoList) {
        this.qualificacaoList = qualificacaoList;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    @XmlTransient
    public List<ClienteWebservice> getClienteWebserviceList() {
        return clienteWebserviceList;
    }

    public void setClienteWebserviceList(List<ClienteWebservice> clienteWebserviceList) {
        this.clienteWebserviceList = clienteWebserviceList;
    }

    @XmlTransient
    public List<Anuncio> getAnuncioList() {
        return anuncioList;
    }

    public void setAnuncioList(List<Anuncio> anuncioList) {
        this.anuncioList = anuncioList;
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
        hash += (contaId != null ? contaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.contaId == null && other.contaId != null) || (this.contaId != null && !this.contaId.equals(other.contaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.freedomsoftware.jsnprototipo.modelo.Conta[ contaId=" + contaId + " ]";
    }
    
}
