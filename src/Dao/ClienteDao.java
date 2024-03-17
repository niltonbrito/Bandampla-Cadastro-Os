package dao;

import factory.ConexaoDB;
import java.awt.HeadlessException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import model.Cliente;
import net.proteanit.sql.DbUtils;
import static view.TelaCadastroCliente.*;

/**
 *
 * @author nilton.brito
 */
public class ClienteDao {

    private Connection conexao = null;
    PreparedStatement statement = null;
    ResultSet resp = null;
    public int resultado;
    public String erro;

    /**
     * Creates new form TelaUsuario
     */
    public ClienteDao() {
    }

    // Metodo para Adicionar usuários
    public void adicionarCliente(Cliente cliente) {

        String sql = "insert into tbclientes (nome_cliente,sobrenome_cliente,cpf_cliente,rg_cliente,celular_cliente,telefone_cliente,email_cliente,sexo_cliente,endereco_cliente,numero_cliente,complemento_cliente,complemento2_cliente,bairro_cliente,cidade_cliente,estado_cliente,cep_cliente) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, cliente.getTxtNome());
            statement.setString(2, cliente.getTxtSobrenome());
            statement.setString(3, cliente.getTxtCpf());
            statement.setString(4, cliente.getTxtRg());
            statement.setString(5, cliente.getTxtCelular());
            statement.setString(6, cliente.getTxtTelefone());
            statement.setString(7, cliente.getTxtEmail());
            statement.setString(8, cliente.getCmbSexo());
            statement.setString(9, cliente.endereco.getLogradouro());
            statement.setString(10, cliente.getNumero());
            statement.setString(11, cliente.endereco.getComplemento());
            statement.setString(12, cliente.getComplemento2());
            statement.setString(13, cliente.endereco.getBairro());
            statement.setString(14, cliente.endereco.getLocalidade());
            statement.setString(15, cliente.endereco.getUf());
            statement.setString(16, cliente.endereco.getCep());

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
    public void editarCliente(Cliente cliente) {

        LocalDateTime datahora = LocalDateTime.now();
        DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataAgora = (datahora.format(formatada));

        String sql = "update tbclientes set nome_cliente=?,sobrenome_cliente=?,cpf_cliente=?,rg_cliente=?,celular_cliente=?,telefone_cliente=?,email_cliente=?,sexo_cliente=?,endereco_cliente=?,numero_cliente=?,complemento_cliente=?,complemento2_cliente=?,bairro_cliente=?,cidade_cliente=?,estado_cliente=?,cep_cliente=?,data_atualizacao_cliente=? where id_cliente=?";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, cliente.getTxtNome());
            statement.setString(2, cliente.getTxtSobrenome());
            statement.setString(3, cliente.getTxtCpf());
            statement.setString(4, cliente.getTxtRg());
            statement.setString(5, cliente.getTxtCelular());
            statement.setString(6, cliente.getTxtTelefone());
            statement.setString(7, cliente.getTxtEmail());
            statement.setString(8, cliente.getCmbSexo());
            statement.setString(9, cliente.endereco.getLogradouro());
            statement.setString(10, cliente.getNumero());
            statement.setString(11, cliente.endereco.getComplemento());
            statement.setString(12, cliente.getComplemento2());
            statement.setString(13, cliente.endereco.getBairro());
            statement.setString(14, cliente.endereco.getLocalidade());
            statement.setString(15, cliente.endereco.getUf());
            statement.setString(16, cliente.endereco.getCep());
            statement.setString(17, dataAgora);
            statement.setString(18, cliente.getTxtId());

            resultado = statement.executeUpdate();
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

    // Metodo para deletar usuários
    public void deletarCliente(Cliente cliente) {

        try {
            String sql = "delete from tbclientes where id_cliente=?";
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, cliente.getTxtId());
            resultado = statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e1) {
            erro = e1.getMessage();
            JOptionPane.showMessageDialog(null, "Exclusão não realizada.\nCliente possui OS pendente.");
        } catch (HeadlessException | SQLException e2) {
            JOptionPane.showMessageDialog(null, e2);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

// Metodo para Consultar clientes com filtos
    public void pesquisarCliente(Cliente cliente) {
        //String sql = "select * from tbclientes where nome_cliente like ?";
        String sql = "select id_cliente as ID, nome_cliente as Nome, sobrenome_cliente as Sobrenome, cpf_cliente as CPF, rg_cliente as RG,celular_cliente as Celular, telefone_cliente as Telefone,email_cliente as Email, sexo_cliente as Sexo, endereco_cliente as Endereço,numero_cliente as Numero,complemento_cliente as Complemento,Complemento2_cliente as Complemento2, bairro_cliente as Bairro, cidade_cliente as Cidade, estado_cliente as Estado,cep_cliente as CEP, data_cadastro_cliente as Data_Cadastro, data_atualizacao_cliente as Data_Atualizacao from tbclientes where nome_cliente like ?";

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            // Passando o conteúdo da caixa de pesquisa para o ?
            // Atenção ao "%" - continuação da String sql 
            statement.setString(1, cliente.getTxtPesquisar() + "%");
            resp = statement.executeQuery();
            // A linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tabelaCliente.setModel(DbUtils.resultSetToTableModel(resp));
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
    public void setarCampos() {

        try {
            conexao = ConexaoDB.conectar();
            int setar = tabelaCliente.getSelectedRow();
            txtId.setText(tabelaCliente.getModel().getValueAt(setar, 0).toString());
            txtNome.setText(tabelaCliente.getModel().getValueAt(setar, 1).toString());
            txtSobrenome.setText(tabelaCliente.getModel().getValueAt(setar, 2).toString());
            txtCpf.setText(tabelaCliente.getModel().getValueAt(setar, 3).toString());
            txtRg.setText(tabelaCliente.getModel().getValueAt(setar, 4).toString());
            txtCelular.setText(tabelaCliente.getModel().getValueAt(setar, 5).toString());
            txtTelefone.setText(tabelaCliente.getModel().getValueAt(setar, 6).toString());
            txtEmail.setText(tabelaCliente.getModel().getValueAt(setar, 7).toString());
            cmbSexo.setSelectedItem(tabelaCliente.getModel().getValueAt(setar, 8).toString());
            txtEndereco.setText(tabelaCliente.getModel().getValueAt(setar, 9).toString());
            txtNumero.setText(tabelaCliente.getModel().getValueAt(setar, 10).toString());
            txtComplemento.setText(tabelaCliente.getModel().getValueAt(setar, 11).toString());
            txtComplemento2.setText(tabelaCliente.getModel().getValueAt(setar, 12).toString());
            txtBairro.setText(tabelaCliente.getModel().getValueAt(setar, 13).toString());
            txtCidade.setText(tabelaCliente.getModel().getValueAt(setar, 14).toString());
            cmbEstado.setSelectedItem(tabelaCliente.getModel().getValueAt(setar, 15).toString());
            txtCep.setText(tabelaCliente.getModel().getValueAt(setar, 16).toString());
            lblDataCad.setText(tabelaCliente.getModel().getValueAt(setar, 17).toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        btnAdicionar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnDeletar.setEnabled(true);
        btnLimpar.setEnabled(true);
    }
}
