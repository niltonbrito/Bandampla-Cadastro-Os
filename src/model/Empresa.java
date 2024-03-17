/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.EmpresaDao;
import business.IntegracaoApiBS;
import java.util.*;
import javax.swing.Icon;

/**
 *
 * @author nilton.brito
 */
public class Empresa {

    private String cnpj;
    private String nome;
    private String fantasia;
    private String porte;
    private String natureza_juridica;
    private String situacao;
    private String data_situacao;
    private String abertura;
    private String principal;
    private String secundarias;
    private List<AtividadeDto> atividade_principal = new ArrayList<>();   
    private List<AtividadeDto> atividades_secundarias = new ArrayList<>();
    private String capital_social;
    private String email;
    private String telefone;
    private String celular;
    private String tipo;
    private String logradouro;
    private String numero;
    private String complemento;
    private String localidade;
    private String municipio;
    private String bairro;
    private String uf;
    private String cep;
    private String txtId;
    private String txtDataCadastro;
    private String txtInscricaoEstadual;
    private String txtPesquisar;
    private String txtResponsalvel;
    private String txtCelular;
    private Icon lblStatusCep;
    private Icon lblStatusCnpj;

    public EmpresaDao empresadao = new EmpresaDao();
    public Endereco endereco = new Endereco();
    public static IntegracaoApiBS consulta = new IntegracaoApiBS();

    public Empresa() {
    }
      
    public String getNatureza_juridica() {
        return natureza_juridica;
    }

    public void setNatureza_juridica(String natureza_juridica) {
        this.natureza_juridica = natureza_juridica;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getSecundarias() {
        return secundarias;
    }

    public void setSecundarias(String secundarias) {
        this.secundarias = secundarias;
    }
    
    
    public List<AtividadeDto> getAtividade_principal() {
        return atividade_principal;
    }

    public void setAtividade_principal(List<AtividadeDto> atividade_principal) {
        this.atividade_principal = atividade_principal;
    }

    public List<AtividadeDto> getAtividades_secundarias() {
        return atividades_secundarias;
    }

    public void setAtividades_secundarias(List<AtividadeDto> atividades_secundarias) {
        this.atividades_secundarias = atividades_secundarias;
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getData_situacao() {
        return data_situacao;
    }

    public void setData_situacao(String data_situacao) {
        this.data_situacao = data_situacao;
    }

    public String getAbertura() {
        return abertura;
    }

    public void setAbertura(String abertura) {
        this.abertura = abertura;
    }
    
    public String getCapital_social() {
        return capital_social;
    }

    public void setCapital_social(String capital_social) {
        this.capital_social = capital_social;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTxtId() {
        return txtId;
    }

    public void setTxtId(String txtId) {
        this.txtId = txtId;
    }

    public String getTxtDataCadastro() {
        return txtDataCadastro;
    }

    public void setTxtDataCadastro(String txtDataCadastro) {
        this.txtDataCadastro = txtDataCadastro;
    }

    public String getTxtInscricaoEstadual() {
        return txtInscricaoEstadual;
    }

    public void setTxtInscricaoEstadual(String txtInscricaoEstadual) {
        this.txtInscricaoEstadual = txtInscricaoEstadual;
    }

    public String getTxtPesquisar() {
        return txtPesquisar;
    }

    public void setTxtPesquisar(String txtPesquisar) {
        this.txtPesquisar = txtPesquisar;
    }

    public String getTxtResponsalvel() {
        return txtResponsalvel;
    }

    public void setTxtResponsalvel(String txtResponsalvel) {
        this.txtResponsalvel = txtResponsalvel;
    }

    public String getTxtCelular() {
        return txtCelular;
    }

    public void setTxtCelular(String txtCelular) {
        this.txtCelular = txtCelular;
    }

    public Icon getLblStatusCnpj() {
        return lblStatusCnpj;
    }

    public void setLblStatusCnpj(Icon lblStatusCnpj) {
        this.lblStatusCnpj = lblStatusCnpj;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Icon getLblStatusCep() {
        return lblStatusCep;
    }

    public void setLblStatusCep(Icon lblStatusCep) {
        this.lblStatusCep = lblStatusCep;
    }

}
