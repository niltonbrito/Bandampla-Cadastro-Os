/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import dao.FuncionarioDao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import static view.TelaCadastroFuncionario.*;

/**
 *
 * @author nilto
 */
public class FuncionarioBS {

    // Metodo para Adicionar usuários
    public void adicionarFuncionario() {

        Funcionario funcionario = new Funcionario();

        funcionario.setTxtMatricula(txtMatricula.getText());
        funcionario.setTxtNome(txtNome.getText());
        funcionario.setTxtSobrenome(txtSobrenome.getText());
        funcionario.setTxtCpf(txtCpf.getText());
        funcionario.setTxtRg(txtRg.getText());
        funcionario.setTxtCelular(txtCelular.getText());
        funcionario.setTxtTelefone(txtTelefone.getText());
        funcionario.setTxtEmail(txtEmail.getText().toLowerCase());
        funcionario.setCmbSexo(cmbSexo.getSelectedItem().toString());
        funcionario.setTxtLogin(txtLogin.getText().toLowerCase());
        funcionario.setTxtSenha(new String(txtSenha.getPassword()));
        funcionario.setCmbPerfil(cmbPerfil.getSelectedItem().toString());
        funcionario.setCmbStatus(cmbStatus.getSelectedItem().toString());
        funcionario.setTxtCargo(txtUsuCargo.getText());
        funcionario.setTxtSalario(txtUsuSalario.getText());
        funcionario.endereco.setLogradouro(txtEndereco.getText());
        funcionario.setNumero(txtNumero.getText());
        funcionario.endereco.setComplemento(txtComplemento.getText());
        funcionario.setComplemento2(txtComplemento2.getText());
        funcionario.endereco.setBairro(txtBairro.getText());
        funcionario.endereco.setLocalidade(txtCidade.getText());
        funcionario.endereco.setUf(cmbEstado.getSelectedItem().toString());
        funcionario.endereco.setCep(txtCep.getText());

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.adicionarFuncionario(funcionario);

        if ((funcionario.getTxtMatricula().isEmpty()) || (funcionario.getTxtNome().isEmpty()) || (funcionario.getTxtCelular().isEmpty()) || (funcionario.getTxtLogin().isEmpty()) || (funcionario.getTxtSenha().length() == 0) || (funcionario.getCmbPerfil().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else if (funcionarioDao.resultado > 0) {
            JOptionPane.showMessageDialog(null, "Funcioario " + funcionario.getTxtNome() + " cadastrado com sucesso!");
            limparCampos();
        } else if (funcionarioDao.erro.equals("Duplicate entry '" + funcionario.getTxtMatricula() + "' for key 'matricula_usuario'")) {
            JOptionPane.showMessageDialog(null, "Matricula informada já cadastada.\nInforme outra matricula.");
            funcionario.setTxtMatricula(null);
        } else if (funcionarioDao.erro.equals("Duplicate entry '" + funcionario.getTxtCpf() + "' for key 'cpf_usuario'")) {
            JOptionPane.showMessageDialog(null, "Cpf informado já cadastado.\nInforme outro Cpf.");
            funcionario.setTxtCpf(null);
        } else if (funcionarioDao.erro.equals("Duplicate entry '" + funcionario.getTxtEmail() + "' for key 'email_usuario'")) {
            JOptionPane.showMessageDialog(null, "E-mail informado já cadastado.\nInforme outro E-mail.");
            funcionario.setTxtEmail(null);
        } else {
            JOptionPane.showMessageDialog(null, "Login informado já cadastado.\nEscolha outro Login.");
            funcionario.setTxtLogin(null);
        }
    }

    // Metodo para escolher um metodo de alterar dados do funcionário
    public void editarFuncionario() {
        if (chkSenha.isSelected()) {
            editarFuncionarioComSenha();
        } else {
            editarFuncionarioSemSenha();
        }
    }

// Metodo para alterar dados do usuários
    public void editarFuncionarioSemSenha() {
        // Chamando o metodo alterar
        Funcionario funcionario = new Funcionario();
        txtMatricula.setEditable(false);
        txtMatricula.setEnabled(false);

        funcionario.setTxtMatricula(txtMatricula.getText());
        funcionario.setTxtNome(txtNome.getText());
        funcionario.setTxtSobrenome(txtSobrenome.getText());
        funcionario.setTxtCpf(txtCpf.getText());
        funcionario.setTxtRg(txtRg.getText());
        funcionario.setTxtCelular(txtCelular.getText());
        funcionario.setTxtTelefone(txtTelefone.getText());
        funcionario.setTxtEmail(txtEmail.getText());
        funcionario.setCmbSexo(cmbSexo.getSelectedItem().toString());
        funcionario.setTxtLogin(txtLogin.getText());
        funcionario.setCmbPerfil(cmbPerfil.getSelectedItem().toString());
        funcionario.setCmbStatus(cmbStatus.getSelectedItem().toString());
        funcionario.setTxtCargo(txtUsuCargo.getText());
        funcionario.setTxtSalario(txtUsuSalario.getText());
        funcionario.endereco.setLogradouro(txtEndereco.getText());
        funcionario.setNumero(txtNumero.getText());
        funcionario.endereco.setComplemento(txtComplemento.getText());
        funcionario.setComplemento2(txtComplemento2.getText());
        funcionario.endereco.setBairro(txtBairro.getText());
        funcionario.endereco.setLocalidade(txtCidade.getText());
        funcionario.endereco.setUf(cmbEstado.getSelectedItem().toString());
        funcionario.endereco.setCep(txtCep.getText());

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.editarFuncionarioSemSenha(funcionario);
        if ((funcionario.getTxtMatricula().isEmpty()) || (funcionario.getTxtNome().isEmpty()) || (funcionario.getTxtLogin().isEmpty()) || (funcionario.endereco.getCep().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else {
            if (funcionarioDao.resultado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do funcionário alterado com sucesso!");
                limparCampos();
            }
        }
    }

    // Metodo para alterar dados do usuários com senha
    public void editarFuncionarioComSenha() {
        // Chamando o metodo alterar
        Funcionario funcionario = new Funcionario();
        txtMatricula.setEditable(false);
        txtMatricula.setEnabled(false);

        funcionario.setTxtMatricula(txtMatricula.getText());
        funcionario.setTxtNome(txtNome.getText());
        funcionario.setTxtSobrenome(txtSobrenome.getText());
        funcionario.setTxtCpf(txtCpf.getText());
        funcionario.setTxtRg(txtRg.getText());
        funcionario.setTxtCelular(txtCelular.getText());
        funcionario.setTxtTelefone(txtTelefone.getText());
        funcionario.setTxtEmail(txtEmail.getText());
        funcionario.setCmbSexo(cmbSexo.getSelectedItem().toString());
        funcionario.setTxtLogin(txtLogin.getText());
        funcionario.setTxtSenha(new String(txtSenha.getPassword()));
        funcionario.setCmbPerfil(cmbPerfil.getSelectedItem().toString());
        funcionario.setCmbStatus(cmbStatus.getSelectedItem().toString());
        funcionario.setTxtCargo(txtUsuCargo.getText());
        funcionario.setTxtSalario(txtUsuSalario.getText());
        funcionario.endereco.setLogradouro(txtEndereco.getText());
        funcionario.setNumero(txtNumero.getText());
        funcionario.endereco.setComplemento(txtComplemento.getText());
        funcionario.setComplemento2(txtComplemento2.getText());
        funcionario.endereco.setBairro(txtBairro.getText());
        funcionario.endereco.setLocalidade(txtCidade.getText());
        funcionario.endereco.setUf(cmbEstado.getSelectedItem().toString());
        funcionario.endereco.setCep(txtCep.getText());

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.editarFuncionarioComSenha(funcionario);
        if ((funcionario.getTxtMatricula().isEmpty()) || (funcionario.getTxtNome().isEmpty()) || (funcionario.getTxtLogin().isEmpty()) || (funcionario.endereco.getCep().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else {
            if (funcionarioDao.resultado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do funcionário alterado com sucesso!");
                limparCampos();
            }
        }
    }

    // Metodo para Consultar clientes com filtos
    public void pesquisarFuncionario() {
        // Chamando o metodo pesquisar clientes
        Funcionario funcionario = new Funcionario();
        funcionario.setTxtPesquisar(txtPesquisar.getText());

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.pesquisarFuncionario(funcionario);
    }

    // Metodo para setar os campos do formulario com conteúdo da tabela
    public void setarCampos() {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        funcionarioDao.setarCampos();
        if ((tabelaUsuario.getModel().getValueAt(funcionarioDao.resultado, 18).toString().equalsIgnoreCase("admin")) && (tabelaUsuario.getModel().getValueAt(funcionarioDao.resultado, 20).toString().equalsIgnoreCase("administrador"))) {
            txtLogin.setEditable(false);
            txtLogin.setEnabled(false);
            cmbPerfil.setEditable(false);
            cmbPerfil.setEnabled(false);
            cmbStatus.setEditable(false);
            cmbStatus.setEnabled(false);
        } else {
            txtLogin.setEditable(true);
            txtLogin.setEnabled(true);
            cmbPerfil.setEditable(true);
            cmbPerfil.setEnabled(true);
            cmbStatus.setEditable(true);
            cmbStatus.setEnabled(true);
        }
        btnAdicionar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnDeletar.setEnabled(true);
        btnLimpar.setEnabled(true);
        chkSenha.setVisible(true);
    }

    // Metodo para deletar usuários
    public void deletarFuncionario() {
        Funcionario funcionario = new Funcionario();

        funcionario.setTxtMatricula(txtMatricula.getText());
        funcionario.setTxtLogin(txtLogin.getText());
        funcionario.setCmbPerfil(cmbPerfil.getSelectedItem().toString());
        funcionario.setTxtId(txtId.getText());

        if (funcionario.getTxtMatricula().isEmpty() || funcionario.getTxtLogin().isEmpty() || funcionario.getCmbPerfil().isEmpty() || funcionario.getTxtId().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else if ((funcionario.getTxtLogin().equalsIgnoreCase("admin")) && (funcionario.getCmbPerfil().equalsIgnoreCase("administrador"))) {
            JOptionPane.showMessageDialog(null, "Ação proibida, não e possivel deletar o Administrador do Sistema");
        } else {
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            funcionarioDao.deletarFuncionario(funcionario);
            if (funcionarioDao.resultado > 0) {
                JOptionPane.showMessageDialog(null, "funcionario " + funcionario.getTxtNome() + " deletado com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao tentar deletar o funcionario, erro: " + funcionarioDao.erro);
            }
        }
    }

    // Metodo para consultar API do CEP
    public void consultaCep() {
        txtEndereco.setText("Aguarde...");
        Funcionario funcionario = new Funcionario();
        funcionario.endereco.setCep(txtCep.getText());
        if (funcionario.endereco.getCep().length() == 8) {
            try {
                funcionario.endereco = IntegracaoApiBS.buscarCep(funcionario.endereco.getCep());

                lblStatusCep.setIcon(funcionario.endereco.getLblStatusCep());
                txtEndereco.setText(funcionario.endereco.getLogradouro());
                txtComplemento2.setText(funcionario.endereco.getComplemento());
                txtBairro.setText(funcionario.endereco.getBairro());
                txtCidade.setText(funcionario.endereco.getLocalidade());
                cmbEstado.setSelectedItem(funcionario.endereco.getUf());
            } catch (Exception ex) {
            }
        }
    }

    // Metodo para limpar os campos do formularios   
    public void limparCampos() {

        txtId.setText(null);
        txtMatricula.setText(null);
        txtNome.setText(null);
        txtSobrenome.setText(null);
        txtCpf.setText(null);
        txtRg.setText(null);
        txtCelular.setText(null);
        txtTelefone.setText(null);
        txtEmail.setText(null);
        cmbSexo.setSelectedItem("");
        txtEndereco.setText(null);
        txtNumero.setText(null);
        txtComplemento.setText(null);
        txtComplemento2.setText(null);
        txtBairro.setText(null);
        txtCidade.setText(null);
        cmbEstado.setSelectedItem("");
        txtCep.setText(null);
        lblStatusCep.setIcon(null);
        txtLogin.setText(null);
        txtSenha.setText(null);
        txtSenha.setEnabled(true);
        cmbPerfil.setSelectedItem("");
        cmbStatus.setSelectedItem("");
        txtUsuCargo.setText(null);
        txtUsuSalario.setText(null);
        lblDataCad.setText(null);
        txtPesquisar.setText(null);
        lblStatusCep.setIcon(null);
        ((DefaultTableModel) tabelaUsuario.getModel()).setRowCount(0);
        btnAdicionar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnDeletar.setEnabled(false);
        btnLimpar.setEnabled(false);
        chkSenha.setSelected(false);
        chkSenha.setVisible(false);
        chkSenha.setEnabled(true);
        txtMatricula.requestFocus();

        txtLogin.setEditable(true);
        txtLogin.setEnabled(true);
        cmbPerfil.setEditable(true);
        cmbPerfil.setEnabled(true);
        cmbStatus.setEditable(true);
        cmbStatus.setEnabled(true);
        txtMatricula.setEditable(true);
        txtMatricula.setEnabled(true);
    }
}
