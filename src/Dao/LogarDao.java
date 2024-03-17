/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import factory.ConexaoDB;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import model.Logar;
import view.TelaPrincipal;

/*
 * @author nilto
 */
public class LogarDao extends TelaPrincipal {

    Connection conexao;
    PreparedStatement statement = null;
    ResultSet resultset = null;
    String status;
    public static int validar;

    public LogarDao() {
    }

    /**
     * Método responsável pela autenticação e gestão de perfil do usuário
     *
     * @param logar
     */
    public void logar(Logar logar) {

        conexao = ConexaoDB.conectar();
        String sql = "select * from tbusuarios where login_usuario = ? and senha_usuario = md5(?)";
        try {
            statement = conexao.prepareStatement(sql);
            statement.setString(1, logar.getLogin());
            statement.setString(2, logar.getSenha());
            // A linha abaixo realiza a consulta Query
            resultset = statement.executeQuery();
            // Se existir se a senha e usuario e correspondente
            if (resultset.next()) {
                // A linha abaixo obtem o conteudo do campo perfil da tabela tbusuarios
                status = resultset.getString(22);
                if (status.equalsIgnoreCase("ativo")) {
                    validar = 1;
                    // A linha abaixo obtem o conteudo do campo perfil da tabela tbusuarios
                    String perfil = resultset.getString(21);
                    // A linha abaixo exibe o painel principal
                    TelaPrincipal principal = new TelaPrincipal();
                    principal.setVisible(true);
                    // A estrutura abaixo faz o tratamento do perfil do usuario
                    if (perfil.equalsIgnoreCase("administrador")) {
                        menRelatorios.setEnabled(true);
                        menCadUsuario.setEnabled(true);
                        menCadEstoque.setEnabled(true);
                        menCadEmpresa.setEnabled(true);
                        menConfSistema.setEnabled(true);
                        menPropSistema.setEnabled(true);
                        lblUsuario.setText("<html>" + (resultset.getString(3)) + "<br>" + (resultset.getString(4)) + "</html>");
                        lblUsuario.setForeground(Color.getHSBColor(0, 102, 102));
                    } else if (perfil.equalsIgnoreCase("gerente")) {
                        menRelatorios.setEnabled(true);
                        menCadUsuario.setEnabled(true);
                        menCadEstoque.setEnabled(true);
                        menCadEmpresa.setEnabled(true);
                        menConfSistema.setEnabled(true);
                        menPropSistema.setEnabled(false);
                        lblUsuario.setText("<html>" + (resultset.getString(3)) + "<br>" + (resultset.getString(4)) + "</html>");
                        lblUsuario.setForeground(Color.BLUE);
                    } else if (perfil.equalsIgnoreCase("usuario")) {
                        menRelatorios.setEnabled(false);
                        menCadUsuario.setEnabled(false);
                        menCadEstoque.setEnabled(true);
                        menConfSistema.setEnabled(false);
                        menPropSistema.setEnabled(false);
                        lblUsuario.setText("<html>" + (resultset.getString(3)) + "<br>" + (resultset.getString(4)) + "</html>");
                    } else {
                        menCadastro.setEnabled(false);
                        menRelatorios.setEnabled(false);
                        menOpcoes.setEnabled(false);
                        lblUsuario.setText("<html>" + (resultset.getString(3)) + "<br>" + (resultset.getString(4)) + "</html>");
                        lblUsuario.setForeground(Color.red);
                    }
                    conexao.close();
                } else {

                    JOptionPane.showMessageDialog(null, "Usuário com acesso bloqueado", "Aviso", HEIGHT);
                }
            } else {
                //System.out.println("conteudo2 "+resultset.next());
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido(s)");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
