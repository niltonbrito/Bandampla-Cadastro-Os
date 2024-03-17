/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nilton.brito
 */
public class Funcionario extends Pessoa{
    
    private String txtMatricula;
    private String txtLogin;
    private String txtSenha;
    private String cmbPerfil;
    private String txtCargo;
    private String cmbStatus;
    private String txtSalario;
    
    public Funcionario() {
    }

    public String getTxtMatricula() {
        return txtMatricula;
    }

    public void setTxtMatricula(String txtMatricula) {
        this.txtMatricula = txtMatricula;
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
    
    
}
