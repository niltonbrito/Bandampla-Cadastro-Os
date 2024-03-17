/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.JTable;

public class Pessoa {

    
    private String txtId;
    private String txtMatricula;
    private String txtNome;
    private String txtSobrenome;
    private String txtCpf;
    private String txtCnpj;
    private String txtRg;
    private String txtCelular;
    private String txtTelefone;
    private String txtEmail;
    private String cmbSexo;
    private String txtLogin;
    private String txtSenha;
    private String cmbPerfil;
    private String txtCargo;
    private String cmbStatus;
    private String txtSalario;
    private String lblDataCad;
    private String txtPesquisar;
    private String txtDataCadastro;
    
    private JTable tabelaPessoa;
    private String numero;
    private String complemento2;

    public Endereco endereco = new Endereco();
    public Pessoa() {
    }

    public String getTxtDataCadastro() {
        return txtDataCadastro;
    }

    public void setTxtDataCadastro(String txtDataCadastro) {
        this.txtDataCadastro = txtDataCadastro;
    }

    public String getTxtId() {
        return txtId;
    }

    public void setTxtId(String txtId) {
        this.txtId = txtId;
    }

    public String getTxtMatricula() {
        return txtMatricula;
    }

    public void setTxtMatricula(String txtMatricula) {
        this.txtMatricula = txtMatricula;
    }

    public String getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(String txtNome) {
        this.txtNome = txtNome;
    }

    public String getTxtSobrenome() {
        return txtSobrenome;
    }

    public void setTxtSobrenome(String txtSobrenome) {
        this.txtSobrenome = txtSobrenome;
    }

    public String getTxtCpf() {
        return txtCpf;
    }

    public void setTxtCpf(String txtCpf) {
        this.txtCpf = txtCpf;
    }

    public String getTxtCnpj() {
        return txtCnpj;
    }

    public void setTxtCnpj(String txtCnpj) {
        this.txtCnpj = txtCnpj;
    }

    public String getTxtRg() {
        return txtRg;
    }

    public void setTxtRg(String txtRg) {
        this.txtRg = txtRg;
    }

    public String getTxtCelular() {
        return txtCelular;
    }

    public void setTxtCelular(String txtCelular) {
        this.txtCelular = txtCelular;
    }

    public String getTxtTelefone() {
        return txtTelefone;
    }

    public void setTxtTelefone(String txtTelefone) {
        this.txtTelefone = txtTelefone;
    }

    public String getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(String txtEmail) {
        this.txtEmail = txtEmail;
    }

    public String getCmbSexo() {
        return cmbSexo;
    }

    public void setCmbSexo(String cmbSexo) {
        this.cmbSexo = cmbSexo;
    }

    public String getTxtLogin() {
        return txtLogin;
    }

    public void setTxtLogin(String txtLogin) {
        this.txtLogin = txtLogin;
    }

    public String getTxtSenha() {
        return txtSenha;
    }

    public void setTxtSenha(String txtSenha) {
        this.txtSenha = txtSenha;
    }

    public String getCmbPerfil() {
        return cmbPerfil;
    }

    public void setCmbPerfil(String cmbPerfil) {
        this.cmbPerfil = cmbPerfil;
    }

    public String getTxtCargo() {
        return txtCargo;
    }

    public void setTxtCargo(String txtCargo) {
        this.txtCargo = txtCargo;
    }

    public String getCmbStatus() {
        return cmbStatus;
    }

    public void setCmbStatus(String cmbStatus) {
        this.cmbStatus = cmbStatus;
    }

    public String getTxtSalario() {
        return txtSalario;
    }

    public void setTxtSalario(String txtSalario) {
        this.txtSalario = txtSalario;
    }

    public String getLblDataCad() {
        return lblDataCad;
    }

    public void setLblDataCad(String lblDataCad) {
        this.lblDataCad = lblDataCad;
    }

    public String getTxtPesquisar() {
        return txtPesquisar;
    }

    public void setTxtPesquisar(String txtPesquisar) {
        this.txtPesquisar = txtPesquisar;
    }

    public JTable getTabelaPessoa() {
        return tabelaPessoa;
    }

    public void setTabelaPessoa(JTable tabelaPessoa) {
        this.tabelaPessoa = tabelaPessoa;
    }

    public String getComplemento2() {
        return complemento2;
    }

    public void setComplemento2(String complemento2) {
        this.complemento2 = complemento2;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
}
