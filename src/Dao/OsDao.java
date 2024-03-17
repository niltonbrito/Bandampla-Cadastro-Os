/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import factory.ConexaoDB;
import java.awt.HeadlessException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import model.Os;
import static view.TelaOs.*;

/**
 *
 * @author nilton.brito
 */
public class OsDao {

    Connection conexao = null;
    PreparedStatement statement = null;
    ResultSet resp = null;
    public int resultado;
    public String erro;
    public boolean validar;

    // Metodo para Consultar clientes com filtos
    public void pesquisarCliente(Os os) {

        // String sql = "select * from tbusuarios where nome_usuario like ?";
        String sql = "select id_cliente as ID, nome_cliente as Nome, cpf_cliente as CPF, celular_cliente as Celular from tbclientes where nome_cliente like ?";

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            // Passando o conteúdo da caixa de pesquisa para o ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, os.getTxtCliPesquisar() + "%");
            resp = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tabelaClientes.setModel(DbUtils.resultSetToTableModel(resp));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para setar os campos do formulario com conteúdo da tabela
    public void setarCampos(Os os) {

        try {
            int setar = tabelaClientes.getSelectedRow();
            os.setTxtCliId(tabelaClientes.getModel().getValueAt(setar, 0).toString());
            tabelaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

// Metodo para emitir uma OS
    public void emitirOs(Os os) {

        // String sql = "select * from tbusuarios where nome_usuario like ?";
        String sql = "insert into tbos(tipo_os,situacao_os, equipamento_os, defeito_os, servico_os, tecnico_os, valor_os,condicao_os,marca_os,modelo_os,nserie_os,acessorio_os,laudotecnico_os, id_cliente) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            // Passando o conteúdo da caixa de pesquisa para o ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, os.getCmbOstipo());
            statement.setString(2, os.getCmbOsSituacao());
            statement.setString(3, os.getTxtOsEquip());
            statement.setString(4, os.getTxtOsDef());
            statement.setString(5, os.getTxtOsServ());
            statement.setString(6, os.getTxtOsTecnico());
            statement.setString(7, os.getTxtOsValor().replace(",", "."));
            statement.setString(8, os.getTxtOsCondicao());
            statement.setString(9, os.getTxtOsMarca());
            statement.setString(10, os.getTxtOsModelo());
            statement.setString(11, os.getTxtOsNSerie());
            statement.setString(12, os.getTxtOsAcessorios());
            statement.setString(13, os.getTxtOsLaudo());
            statement.setString(14, os.getTxtCliId());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel adicionado

        } catch (SQLException e) {
            erro = e.getMessage();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para pesquisar uma OS
    public void pesquisarOs(Os os) {
        // Alinha abaixo cria uma caixa de entrada para o tipo JOption Pane
        String numOS = JOptionPane.showInputDialog("Informe o número da OS:");

        String sql = "SELECT id_os,date_format(data_os,'%d/%m/%y - %H:%i'),tipo_os,situacao_os, equipamento_os, defeito_os, servico_os, tecnico_os, valor_os,condicao_os,marca_os,modelo_os,nserie_os,acessorio_os,laudotecnico_os,id_cliente from tbos where id_os=" + numOS;
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            resp = statement.executeQuery();
            if (resp.next()) {

                os.setTxtOs(resp.getString(1));
                os.setTxtDataOs(resp.getString(2));
                os.setCmbOstipo(resp.getString(3));
                os.setCmbOsSituacao(resp.getString(4));
                os.setTxtOsEquip(resp.getString(5));
                os.setTxtOsDef(resp.getString(6));
                os.setTxtOsServ(resp.getString(7));
                os.setTxtOsTecnico(resp.getString(8));
                os.setTxtOsValor(resp.getString(9).replace(".", ","));
                os.setTxtOsCondicao(resp.getString(10));
                os.setTxtOsMarca(resp.getString(11));
                os.setTxtOsModelo(resp.getString(12));
                os.setTxtOsNSerie(resp.getString(13));
                os.setTxtOsAcessorios(resp.getString(14));
                os.setTxtOsLaudo(resp.getString(15));
                os.setTxtCliId(resp.getString(16));

            } else {
                JOptionPane.showMessageDialog(null, "OS nao cadastrada");
            }
        } catch (java.sql.SQLSyntaxErrorException ex) {
            erro = ex.getMessage();
            JOptionPane.showMessageDialog(null, "OS Inválida");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para alterar uma OS
    public void alterarOs(Os os) {

        LocalDateTime datahora = LocalDateTime.now();
        DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataAgora = (datahora.format(formatada));

        String sql = "update tbos set tipo_os=?, situacao_os=?, equipamento_os=?, defeito_os=?, servico_os=?, tecnico_os=?, valor_os=?, condicao_os=?,marca_os=?,modelo_os=?,nserie_os=?,acessorio_os=?,laudotecnico_os=?, data_atualizacao_os=? where id_os=? ";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            // Passando o conteúdo da caixa de pesquisa para o ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, os.getCmbOstipo());
            statement.setString(2, os.getCmbOsSituacao());
            statement.setString(3, os.getTxtOsEquip());
            statement.setString(4, os.getTxtOsDef());
            statement.setString(5, os.getTxtOsServ());
            statement.setString(6, os.getTxtOsTecnico());
            statement.setString(7, os.getTxtOsValor().replace(",", "."));
            statement.setString(8, os.getTxtOsCondicao());
            statement.setString(9, os.getTxtOsMarca());
            statement.setString(10, os.getTxtOsModelo());
            statement.setString(11, os.getTxtOsNSerie());
            statement.setString(12, os.getTxtOsAcessorios());
            statement.setString(13, os.getTxtOsLaudo());
            statement.setString(14, dataAgora);
            statement.setString(15, os.getTxtOs());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel adicionado

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para deletar OS
    public void excluirOs(Os os) {

        String sql = "delete from tbos where id_os=?";
        try {
            conexao = ConexaoDB.conectar();

            statement = conexao.prepareStatement(sql);
            statement.setString(1, os.getTxtOs());
            resultado = statement.executeUpdate();
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

// Metodo para recuperar OS
    public void recuperarOs(Os os) {

        String sql = "select max(id_os) from tbos";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            resp = statement.executeQuery();
            os.setTxtOs(resp.getString(1));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

}
