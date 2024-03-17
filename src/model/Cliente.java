/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nilton.brito
 */
public class Cliente extends Pessoa{
    
    private String txtCnpj;

    public Cliente() {
    }

    public String getTxtCnpj() {
        return txtCnpj;
    }

    public void setTxtCnpj(String txtCnpj) {
        this.txtCnpj = txtCnpj;
    }
    
}
