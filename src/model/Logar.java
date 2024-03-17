/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.Icon;

/*
 * @author nilto
 */
public class Logar{
        private String login;
    private String senha;
    private Icon lblStatusDB;

    public Logar() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Icon getLblStatusDB() {
        return lblStatusDB;
    }

    public void setLblStatusDB(Icon lblStatusDB) {
        this.lblStatusDB = lblStatusDB;
    }
}
