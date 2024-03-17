/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import dao.ClienteDao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import view.TelaCadastroCliente;
import static view.TelaCadastroCliente.*;

/**
 *
 * @author nilton.brito
 */
public class ClienteBS {

    // Metodo para Adicionar usuários
    public void adicionarCliente() {
        Cliente cliente = new Cliente();

        cliente.setTxtNome(txtNome.getText());
        cliente.setTxtSobrenome(txtSobrenome.getText());
        cliente.setTxtCpf(txtCpf.getText());
        cliente.setTxtRg(txtRg.getText());
        cliente.setTxtCelular(txtCelular.getText());
        cliente.setTxtTelefone(txtTelefone.getText());
        cliente.setTxtEmail(txtEmail.getText());
        cliente.setCmbSexo(cmbSexo.getSelectedItem().toString());
        cliente.endereco.setLogradouro(txtEndereco.getText());
        cliente.setNumero(txtNumero.getText());
        cliente.endereco.setComplemento(txtComplemento.getText());
        cliente.setComplemento2(txtComplemento2.getText());
        cliente.endereco.setBairro(txtBairro.getText());
        cliente.endereco.setLocalidade(txtCidade.getText());
        cliente.endereco.setUf(cmbEstado.getSelectedItem().toString());
        cliente.endereco.setCep(txtCep.getText());

        ClienteDao clienteDao = new ClienteDao();
        clienteDao.adicionarCliente(cliente);
        if ((cliente.getTxtNome().isEmpty()) || (cliente.getTxtCelular().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else if (clienteDao.resultado > 0) {
            JOptionPane.showMessageDialog(null, "Cliente " + cliente.getTxtNome() + " cadastrado com sucesso!");
            limparCampos();
        } else if (clienteDao.erro.equals("Duplicate entry '" + cliente.getTxtCpf() + "' for key 'cpf_cliente'")) {
            JOptionPane.showMessageDialog(null, "Cpf informado já cadastado.\nInforme outro Cpf.");
            cliente.setTxtCpf(null);
        } else {
            JOptionPane.showMessageDialog(null, "E-mail informado já cadastado.\nInforme outro E-mail.");
            cliente.setTxtEmail(null);
        }
    }

    public void editarCliente() {

        Cliente cliente = new Cliente();

        cliente.setTxtId(txtId.getText());
        cliente.setTxtNome(txtNome.getText());
        cliente.setTxtSobrenome(txtSobrenome.getText());
        cliente.setTxtCpf(txtCpf.getText());
        cliente.setTxtRg(txtRg.getText());
        cliente.setTxtCelular(txtCelular.getText());
        cliente.setTxtTelefone(txtTelefone.getText());
        cliente.setTxtEmail(txtEmail.getText());
        cliente.setCmbSexo(cmbSexo.getSelectedItem().toString());
        cliente.endereco.setLogradouro(txtEndereco.getText());
        cliente.setNumero(txtNumero.getText());
        cliente.endereco.setComplemento(txtComplemento.getText());
        cliente.setComplemento2(txtComplemento2.getText());
        cliente.endereco.setBairro(txtBairro.getText());
        cliente.endereco.setLocalidade(txtCidade.getText());
        cliente.endereco.setUf(cmbEstado.getSelectedItem().toString());
        cliente.endereco.setCep(txtCep.getText());

        ClienteDao clienteDao = new ClienteDao();
        clienteDao.editarCliente(cliente);
        if ((cliente.getTxtNome().isEmpty()) || (cliente.getTxtCpf().isEmpty()) || (cliente.getTxtCelular().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else if (clienteDao.resultado > 0) {
            JOptionPane.showMessageDialog(null, "Dados do cliente " + cliente.getTxtNome() + " alterado com sucesso!");
            limparCampos();
        } else if (clienteDao.erro.equals("Duplicate entry '" + cliente.getTxtCpf() + "' for key 'cpf_usuario'")) {
            JOptionPane.showMessageDialog(null, "Cpf informado já cadastado.\nInforme outro Cpf.");
            cliente.setTxtCpf(null);
            TelaCadastroCliente.txtCpf.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Email não preenchido ou já cadastado.\nInforme outro E-mail.");
            cliente.setTxtEmail(null);
            TelaCadastroCliente.txtEmail.requestFocus();
        }
    }

    public void deletarCliente() {

        Cliente cliente = new Cliente();
        cliente.setTxtId(txtId.getText());
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este cliente", "Aviso", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            if (cliente.getTxtId().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                ClienteDao clienteDao = new ClienteDao();
                clienteDao.deletarCliente(cliente);
                if (clienteDao.resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");
                    limparCampos();
                }
            }
        }
    }

    public void pesquisarCliente() {
        Cliente cliente = new Cliente();
        cliente.setTxtPesquisar(txtPesquisar.getText());
        
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.pesquisarCliente(cliente);
    }

    public void setarCampos() {
        ClienteDao cliente = new ClienteDao();
        cliente.setarCampos();
    }

    public void consultaCep() {
        txtEndereco.setText("Aguarde...");
        Cliente cliente = new Cliente();
        cliente.endereco.setCep(txtCep.getText());
        if (cliente.endereco.getCep().length() == 8) {
            try {
                cliente.endereco = IntegracaoApiBS.buscarCep(cliente.endereco.getCep());

                lblStatusCep.setIcon(cliente.endereco.getLblStatusCep());
                txtEndereco.setText(cliente.endereco.getLogradouro());
                txtComplemento2.setText(cliente.endereco.getComplemento());
                txtBairro.setText(cliente.endereco.getBairro());
                txtCidade.setText(cliente.endereco.getLocalidade());
                cmbEstado.setSelectedItem(cliente.endereco.getUf());
            } catch (Exception ex) {
            }
        }
    }

    public void limparCampos() {

        txtId.setText(null);
        txtNome.setText(null);
        txtNome.requestFocus();
        txtSobrenome.setText(null);
        txtCpf.setText(null);
        txtRg.setText(null);
        txtCelular.setText(null);
        txtTelefone.setText(null);
        txtEmail.setText(null);
        cmbSexo.setSelectedItem(null);
        txtEndereco.setText(null);
        txtNumero.setText(null);
        txtComplemento.setText(null);
        txtComplemento2.setText(null);
        txtBairro.setText(null);
        txtCidade.setText(null);
        cmbEstado.setSelectedItem(null);
        txtCep.setText(null);
        lblDataCad.setText(null);
        txtPesquisar.setText(null);
        lblStatusCep.setIcon(null);
        ((DefaultTableModel) tabelaCliente.getModel()).setRowCount(0);
        btnAdicionar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnDeletar.setEnabled(false);
        btnLimpar.setEnabled(false);
    }

}
