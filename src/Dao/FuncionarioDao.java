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
import model.*;
import net.proteanit.sql.DbUtils;
import static view.TelaCadastroFuncionario.*;

/**
 *
 * @author nilto
 */
public class FuncionarioDao {

    private Connection conexao = null;
    PreparedStatement statement = null;
    public ResultSet resultSet = null;
    public int resultado;
    public String erro;

    /**
     * Creates new form TelaUsuario
     */
    public FuncionarioDao() {
    }

    // Metodo para Adicionar usuários
    public void adicionarFuncionario(Funcionario funcionario) {

        String sql = "insert into tbusuarios (matricula_usuario,nome_usuario,sobrenome_usuario,cpf_usuario,rg_usuario,celular_usuario,telefone_usuario,email_usuario,sexo_usuario,endereco_usuario,numero_usuario,complemento_usuario,complemento2_usuario,bairro_usuario,cidade_usuario,estado_usuario,cep_usuario,login_usuario,senha_usuario,perfil_usuario,status_usuario,cargo_usuario,salario_usuario) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,md5(?),?,?,?,?)";

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, funcionario.getTxtMatricula());
            statement.setString(2, funcionario.getTxtNome());
            statement.setString(3, funcionario.getTxtSobrenome());
            statement.setString(4, funcionario.getTxtCpf());
            statement.setString(5, funcionario.getTxtRg());
            statement.setString(6, funcionario.getTxtCelular());
            statement.setString(7, funcionario.getTxtTelefone());
            statement.setString(8, funcionario.getTxtEmail());
            statement.setString(9, funcionario.getCmbSexo());
            statement.setString(10, funcionario.endereco.getLogradouro());
            statement.setString(11, funcionario.getNumero());
            statement.setString(12, funcionario.endereco.getComplemento());
            statement.setString(13, funcionario.getComplemento2());
            statement.setString(14, funcionario.endereco.getBairro());
            statement.setString(15, funcionario.endereco.getLocalidade());
            statement.setString(16, funcionario.endereco.getUf());
            statement.setString(17, funcionario.endereco.getCep());
            statement.setString(18, funcionario.getTxtLogin());
            statement.setString(19, funcionario.getTxtSenha());
            statement.setString(20, funcionario.getCmbPerfil());
            statement.setString(21, funcionario.getCmbStatus());
            statement.setString(22, funcionario.getTxtCargo());
            statement.setString(23, funcionario.getTxtSalario().replace(",", "."));

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel adicionado
        } catch (SQLIntegrityConstraintViolationException e1) {
            erro = e1.getMessage();
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

    // Metodo para alterar dados do usuários
    public void editarFuncionarioSemSenha(Funcionario funcionario) {

        LocalDateTime datahora = LocalDateTime.now();
        DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataAgora = (datahora.format(formatada));

        String sql = "update tbusuarios set nome_usuario=?,sobrenome_usuario=?,cpf_usuario=?,rg_usuario=?,celular_usuario=?,telefone_usuario=?,email_usuario=?,sexo_usuario=?,endereco_usuario=?,numero_usuario=?,complemento_usuario=?,complemento2_usuario=?,bairro_usuario=?,cidade_usuario=?,estado_usuario=?,cep_usuario=?,login_usuario=?,perfil_usuario=?,status_usuario=?,cargo_usuario=?,salario_usuario=?,data_atualizacao_usuario=? where matricula_usuario=?";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, funcionario.getTxtNome());
            statement.setString(2, funcionario.getTxtSobrenome());
            statement.setString(3, funcionario.getTxtCpf());
            statement.setString(4, funcionario.getTxtRg());
            statement.setString(5, funcionario.getTxtCelular());
            statement.setString(6, funcionario.getTxtTelefone());
            statement.setString(7, funcionario.getTxtEmail());
            statement.setString(8, funcionario.getCmbSexo());
            statement.setString(9, funcionario.endereco.getLogradouro());
            statement.setString(10, funcionario.getNumero());
            statement.setString(11, funcionario.endereco.getComplemento());
            statement.setString(12, funcionario.getComplemento2());
            statement.setString(13, funcionario.endereco.getBairro());
            statement.setString(14, funcionario.endereco.getLocalidade());
            statement.setString(15, funcionario.endereco.getUf());
            statement.setString(16, funcionario.endereco.getCep());
            statement.setString(17, funcionario.getTxtLogin().toLowerCase());
            statement.setString(18, funcionario.getCmbPerfil());
            statement.setString(19, funcionario.getCmbStatus());
            statement.setString(20, funcionario.getTxtCargo());
            statement.setString(21, funcionario.getTxtSalario().replace(",", "."));
            statement.setString(22, dataAgora);
            statement.setString(23, funcionario.getTxtMatricula());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel alterado
        } catch (HeadlessException | SQLException e) {
            erro = e.getMessage();
            System.out.println("teste "+erro);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para alterar dados do usuários com senha
    public void editarFuncionarioComSenha(Funcionario funcionario) {

        LocalDateTime datahora = LocalDateTime.now();
        DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataAgora = (datahora.format(formatada));

        String sql = "update tbusuarios set nome_usuario=?,sobrenome_usuario=?,cpf_usuario=?,rg_usuario=?,celular_usuario=?,telefone_usuario=?,email_usuario=?,sexo_usuario=?,endereco_usuario=?,numero_usuario=?,complemento_usuario=?,complemento2_usuario=?,bairro_usuario=?,cidade_usuario=?,estado_usuario=?,cep_usuario=?,login_usuario=?,senha_usuario= md5(?),perfil_usuario=?,status_usuario=?,cargo_usuario=?,salario_usuario=?,data_atualizacao_usuario=? where matricula_usuario=?";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, funcionario.getTxtNome());
            statement.setString(2, funcionario.getTxtSobrenome());
            statement.setString(3, funcionario.getTxtCpf());
            statement.setString(4, funcionario.getTxtRg());
            statement.setString(5, funcionario.getTxtCelular());
            statement.setString(6, funcionario.getTxtTelefone());
            statement.setString(7, funcionario.getTxtEmail());
            statement.setString(8, funcionario.getCmbSexo());
            statement.setString(9, funcionario.endereco.getLogradouro());
            statement.setString(10, funcionario.getNumero());
            statement.setString(11, funcionario.endereco.getComplemento());
            statement.setString(12, funcionario.getComplemento2());
            statement.setString(13, funcionario.endereco.getBairro());
            statement.setString(14, funcionario.endereco.getLocalidade());
            statement.setString(15, funcionario.endereco.getUf());
            statement.setString(16, funcionario.endereco.getCep());
            statement.setString(17, funcionario.getTxtLogin().toLowerCase());
            statement.setString(18, funcionario.getTxtSenha());
            statement.setString(19, funcionario.getCmbPerfil());
            statement.setString(20, funcionario.getCmbStatus());
            statement.setString(21, funcionario.getTxtCargo());
            statement.setString(22, funcionario.getTxtSalario().replace(",", "."));
            statement.setString(23, dataAgora);
            statement.setString(24, funcionario.getTxtMatricula());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel alterado
        } catch (HeadlessException | SQLException e) {
            erro = e.getMessage();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    // Metodo para Consultar clientes com filtos
    public void pesquisarFuncionario(Funcionario funcionario) {
        // String sql = "select * from tbusuarios where nome_usuario like ?";
        String sql = "select id_usuario as ID, matricula_usuario as Matricula, nome_usuario as Nome, sobrenome_usuario as Sobrenome, cpf_usuario as CPF, rg_usuario as RG, celular_usuario as Celular, telefone_usuario as Telefone, email_usuario as Email, sexo_usuario as Sexo, endereco_usuario as Endereço, numero_usuario as Numero, complemento_usuario as Complemento, complemento2_usuario as Complemeto2, bairro_usuario as Bairro, cidade_usuario as Cidade, estado_usuario as Estado, cep_usuario as CEP, login_usuario as Login, senha_usuario as Senha, perfil_usuario as Perfil, status_usuario as Status, cargo_usuario as Cargo, salario_usuario as Salario, data_cadastro_usuario as Data_Cadastro, data_atualizacao_usuario as Data_Atualizacao from tbusuarios where nome_usuario like ?";

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            // Passando o conteúdo da caixa de pesquisa para o ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, funcionario.getTxtPesquisar() + "%");
            resultSet = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tabelaUsuario.setModel(DbUtils.resultSetToTableModel(resultSet));
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

    // Metodo para resultado os campos do formulario com conteúdo da tabela
    public void setarCampos() {
        try {
            conexao = ConexaoDB.conectar();
            resultado = tabelaUsuario.getSelectedRow();
            txtId.setText(tabelaUsuario.getModel().getValueAt(resultado, 0).toString());
            txtMatricula.setText(tabelaUsuario.getModel().getValueAt(resultado, 1).toString());
            txtNome.setText(tabelaUsuario.getModel().getValueAt(resultado, 2).toString());
            txtSobrenome.setText(tabelaUsuario.getModel().getValueAt(resultado, 3).toString());
            txtCpf.setText(tabelaUsuario.getModel().getValueAt(resultado, 4).toString());
            txtRg.setText(tabelaUsuario.getModel().getValueAt(resultado, 5).toString());
            txtCelular.setText(tabelaUsuario.getModel().getValueAt(resultado, 6).toString());
            txtTelefone.setText(tabelaUsuario.getModel().getValueAt(resultado, 7).toString());
            txtEmail.setText(tabelaUsuario.getModel().getValueAt(resultado, 8).toString());
            cmbSexo.setSelectedItem(tabelaUsuario.getModel().getValueAt(resultado, 9).toString());
            txtEndereco.setText(tabelaUsuario.getModel().getValueAt(resultado, 10).toString());
            txtNumero.setText(tabelaUsuario.getModel().getValueAt(resultado, 11).toString());
            txtComplemento.setText(tabelaUsuario.getModel().getValueAt(resultado, 12).toString());
            txtComplemento2.setText(tabelaUsuario.getModel().getValueAt(resultado, 13).toString());
            txtBairro.setText(tabelaUsuario.getModel().getValueAt(resultado, 14).toString());
            txtCidade.setText(tabelaUsuario.getModel().getValueAt(resultado, 15).toString());
            cmbEstado.setSelectedItem(tabelaUsuario.getModel().getValueAt(resultado, 16).toString());
            txtCep.setText(tabelaUsuario.getModel().getValueAt(resultado, 17).toString());
            txtLogin.setText(tabelaUsuario.getModel().getValueAt(resultado, 18).toString());
            txtSenha.setText(tabelaUsuario.getModel().getValueAt(resultado, 19).toString());
            cmbPerfil.setSelectedItem(tabelaUsuario.getModel().getValueAt(resultado, 20).toString());
            cmbStatus.setSelectedItem(tabelaUsuario.getModel().getValueAt(resultado, 21).toString());
            txtUsuCargo.setText(tabelaUsuario.getModel().getValueAt(resultado, 22).toString());
            txtUsuSalario.setText(tabelaUsuario.getModel().getValueAt(resultado, 23).toString().replace(".", ","));
            lblDataCad.setText(tabelaUsuario.getModel().getValueAt(resultado, 24).toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

    }

    // Metodo para deletar usuários
    public void deletarFuncionario(Funcionario funcionario) {

        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário", "Aviso", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from tbusuarios where id_usuario=?";
            try {
                conexao = ConexaoDB.conectar();
                statement = conexao.prepareStatement(sql);
                statement.setString(1, funcionario.getTxtId());
                resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel alterado
            } catch (HeadlessException | SQLException e) {
                erro = e.getMessage();
            } finally {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }
}
