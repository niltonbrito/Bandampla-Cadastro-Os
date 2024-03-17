/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import model.Empresa;
import static view.TelaCadastroEmpresa.*;

/**
 *
 * @author nilton.brito
 */
public class EmpresaBS {

    public void adicionar() throws SQLException {
        Empresa empresa = new Empresa();

        empresa.setCnpj(txtCnpj.getText());
        empresa.setTipo(txtTipo.getText());
        empresa.setTxtInscricaoEstadual(txtInscricaoEstadual.getText());
        empresa.setNome(txtNome.getText());
        empresa.setFantasia(txtNomeFantasia.getText());
        empresa.setAbertura(txtDataAbertura.getText());
        empresa.setPorte(txtPorte.getText());
        empresa.setEmail(txtEmail.getText());
        empresa.setSituacao(txtSituacaoCadastral.getText());
        empresa.setCapital_social(txtCapitalSocial.getText().replaceAll("\\.", "").replace(",", "."));
        empresa.setData_situacao(txtDataSituacaoCadastral.getText());
        empresa.setPrincipal(txtAtividadePrincipal.getText());
        empresa.setSecundarias(txtAtividadeSecundaria.getText());
        empresa.setNatureza_juridica(txtNaturezaJuridica.getText());
        empresa.setTelefone(txtTelefone.getText());
        empresa.setCelular(txtCelular.getText());
        empresa.setTxtResponsalvel(txtResponsalvel.getText());
        empresa.setLogradouro(txtEndereco.getText());
        empresa.setNumero(txtNumero.getText());
        empresa.setComplemento(txtComplemento.getText());
        empresa.setBairro(txtBairro.getText());
        empresa.setMunicipio(txtCidade.getText());
        empresa.setUf(cmbEstado.getSelectedItem().toString());
        empresa.setCep(txtCep.getText());
        if ((empresa.getCnpj().isEmpty()) || (empresa.getNome().isEmpty()) || (empresa.getEmail().isEmpty()) || (empresa.getTelefone().isEmpty()) || (empresa.getSituacao().isEmpty()) || (empresa.getTxtResponsalvel().isEmpty()) || (empresa.getCep().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else {

            empresa.empresadao.adicionarEmpresa(empresa);

            if (empresa.empresadao.resultado > 0) {
                JOptionPane.showMessageDialog(null, "Dados da empresa cadastrado com sucesso!");
                limparCampos();
            } else if (empresa.empresadao.erro.equals("Duplicate entry '" + empresa.getCnpj() + "' for key 'tbempresa.cnpj_empresa'")) {
                JOptionPane.showMessageDialog(null, "CNPJ informada já cadastada.\nInforme outro CNPJ.");
                empresa.setCnpj(null);
            } else if (empresa.empresadao.erro.equals("Duplicate entry '" + empresa.getNome() + "' for key 'tbempresa.nome_empresa'")) {
                JOptionPane.showMessageDialog(null, "Nome da empresa informado já cadastado.\nInforme outro Nome.");
                empresa.setNome(null);
            } else if (empresa.empresadao.erro.equals("Duplicate entry '" + empresa.getEmail() + "' for key 'tbempresa.email_empresa'")) {
                JOptionPane.showMessageDialog(null, "E-mail informado já cadastado.\nInforme outro E-mail.");
                empresa.setEmail(null);
            } else {
                JOptionPane.showMessageDialog(null, "Inscrição estadual informado já cadastado.\nInforme outro Inscrição estadual.");
                empresa.setTxtInscricaoEstadual(null);
            }
        }

    }

    public void alterar() throws SQLException {

        Empresa empresa = new Empresa();

        empresa.setCnpj(txtCnpj.getText());
        empresa.setTipo(txtTipo.getText());
        empresa.setTxtInscricaoEstadual(txtInscricaoEstadual.getText());
        empresa.setNome(txtNome.getText());
        empresa.setFantasia(txtNomeFantasia.getText());
        empresa.setAbertura(txtDataAbertura.getText());
        empresa.setPorte(txtPorte.getText());
        empresa.setEmail(txtEmail.getText());
        empresa.setSituacao(txtSituacaoCadastral.getText());
        empresa.setCapital_social(txtCapitalSocial.getText().replaceAll("\\.", "").replace(",", "."));
        empresa.setData_situacao(txtDataSituacaoCadastral.getText());
        empresa.setPrincipal(txtAtividadePrincipal.getText());
        empresa.setSecundarias(txtAtividadeSecundaria.getText());
        empresa.setNatureza_juridica(txtNaturezaJuridica.getText());
        empresa.setTelefone(txtTelefone.getText());
        empresa.setTxtCelular(txtCelular.getText());
        empresa.setTxtResponsalvel(txtResponsalvel.getText());
        empresa.setLogradouro(txtEndereco.getText());
        empresa.setNumero(txtNumero.getText());
        empresa.setComplemento(txtComplemento.getText());
        empresa.setBairro(txtBairro.getText());
        empresa.setMunicipio(txtCidade.getText());
        empresa.setUf(cmbEstado.getSelectedItem().toString());
        empresa.setCep(txtCep.getText());

        if ((empresa.getCnpj().isEmpty()) || (empresa.getNome().isEmpty()) || (empresa.getEmail().isEmpty()) || (empresa.getTelefone().isEmpty()) || (empresa.getSituacao().isEmpty()) || (empresa.getTxtResponsalvel().isEmpty()) || (empresa.getCep().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else {
            empresa.empresadao.atualizarEmpresa(empresa);
            if (empresa.empresadao.resultado > 0) {
                JOptionPane.showMessageDialog(null, "Dados da empresa alterado com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao alterar os dados da empresa", "Erro", 1);
            }
        }
    }

    public void deletar() {

        Empresa empresa = new Empresa();
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esta empresa", "Aviso", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            if (empresa.getTxtId().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                empresa.empresadao.deletarEmpresa(empresa);
                if (empresa.empresadao.resultado > 0) {
                    JOptionPane.showMessageDialog(null, "Empresa deletada com sucesso!");
                    limparCampos();
                }
            }
        }
    }

    public void consultar() {
        Empresa empresa = new Empresa();
        empresa.empresadao.consultarEmpresa(empresa);

        if (empresa.empresadao.resultado1 == true) {

            btnAdicionar.setEnabled(false);
            btnPesquisar.setEnabled(false);
            btnAlterar.setEnabled(true);
            btnDeletar.setEnabled(true);
            btnLimpar.setEnabled(true);

            DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
            txtId.setText(empresa.getTxtId());
            txtCnpj.setText(empresa.getCnpj());
            txtTipo.setText(empresa.getTipo());
            txtInscricaoEstadual.setText(empresa.getTxtInscricaoEstadual());
            txtNome.setText(empresa.getNome());
            txtNomeFantasia.setText(empresa.getFantasia());
            txtDataAbertura.setText(empresa.getAbertura());
            txtPorte.setText(empresa.getPorte());
            txtEmail.setText(empresa.getEmail());
            txtSituacaoCadastral.setText(empresa.getSituacao());
            txtCapitalSocial.setText(empresa.getCapital_social());
            txtDataSituacaoCadastral.setText(empresa.getData_situacao());
            txtAtividadePrincipal.setText(empresa.getAtividade_principal().toString());
            txtAtividadeSecundaria.setText(empresa.getAtividades_secundarias().toString());
            txtNaturezaJuridica.setText(empresa.getNatureza_juridica());
            txtTelefone.setText(empresa.getTelefone());
            txtCelular.setText(empresa.getTxtCelular());
            txtResponsalvel.setText(empresa.getTxtResponsalvel());
            txtEndereco.setText(empresa.getLogradouro());
            txtNumero.setText(empresa.getNumero());
            txtComplemento.setText(empresa.getComplemento());
            txtBairro.setText(empresa.getBairro());
            txtCidade.setText(empresa.getMunicipio());
            cmbEstado.setSelectedItem(empresa.getUf());
            txtCep.setText(empresa.getCep());
            txtDataCadastro.setText(empresa.getTxtDataCadastro());

            txtCnpj.setEditable(false);
            txtCnpj.setEnabled(false);
            txtInscricaoEstadual.setEditable(false);
            txtInscricaoEstadual.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Empresa não cadastrado na base de dados.", "Aviso", HEIGHT);
        }
    }

    public void consultarcep() {

        txtEndereco.setText("Aguarde...");
        if (txtCep.getText().length() == 8) {
            try {
                Empresa empresa = new Empresa();
                IntegracaoApiBS.buscarCep(txtCep.getText());

                lblStatusCep.setIcon(empresa.getLblStatusCep());
                txtEndereco.setText(empresa.getLogradouro());
                txtCnpj.setText(empresa.getComplemento());
                txtBairro.setText(empresa.getBairro());
                txtCidade.setText(empresa.getLocalidade());
                cmbEstado.setSelectedItem(empresa.getUf());
            } catch (Exception ex) {
            }
        }
    }

    public void consultaCnpj() throws Exception {
        txtNome.setText("Aguarde...");
        if (txtCnpj.getText().length() == 14) {
            Empresa empresa = new Empresa();
            empresa = IntegracaoApiBS.buscarCnpj(txtCnpj.getText());

            DecimalFormat df = new DecimalFormat("###,###,###,##0.00");
            lblStatusCnpj.setIcon(empresa.getLblStatusCnpj());
            txtCnpj.setText(empresa.getCnpj());
            txtTipo.setText(empresa.getTipo());
            txtInscricaoEstadual.setText(empresa.getTxtInscricaoEstadual());
            txtNome.setText(empresa.getNome());
            txtNomeFantasia.setText(empresa.getFantasia());
            txtDataAbertura.setText(empresa.getAbertura());
            txtPorte.setText(empresa.getPorte());
            txtEmail.setText(empresa.getEmail());
            txtSituacaoCadastral.setText(empresa.getSituacao());
            txtCapitalSocial.setText(df.format(Double.parseDouble(empresa.getCapital_social())));
            txtDataSituacaoCadastral.setText(empresa.getData_situacao());
            txtAtividadePrincipal.setText(empresa.getAtividade_principal().listIterator().next().getCode() + " - " + empresa.getAtividade_principal().listIterator().next().getText());
            for (int i = 0; i < empresa.getAtividades_secundarias().size(); i++) {
                txtAtividadeSecundaria.append(empresa.getAtividades_secundarias().get(i).getCode() + " - " + empresa.getAtividades_secundarias().get(i).getText() + "\n");
            }
            txtAtividadeSecundaria.setLineWrap(true);
            txtAtividadeSecundaria.setWrapStyleWord(true);
            txtNaturezaJuridica.setText(empresa.getNatureza_juridica());
            txtTelefone.setText(empresa.getTelefone());
            txtCelular.setText(empresa.getTxtCelular());
            txtResponsalvel.setText(empresa.getTxtResponsalvel());
            txtEndereco.setText(empresa.getLogradouro());
            txtNumero.setText(empresa.getNumero());
            txtComplemento.setText(empresa.getComplemento());
            txtBairro.setText(empresa.getBairro());
            txtCidade.setText(empresa.getMunicipio());
            cmbEstado.setSelectedItem(empresa.getUf());
            txtCep.setText(empresa.getCep());
        }
    }

    // Metodo para limpar os campos do formularios   
    public void limparCampos() {

        txtId.setText(null);
        txtCnpj.setText(null);
        txtTipo.setText(null);
        txtInscricaoEstadual.setText(null);
        txtNome.setText(null);
        txtNomeFantasia.setText(null);
        txtDataAbertura.setText(null);
        txtPorte.setText(null);
        txtEmail.setText(null);
        txtSituacaoCadastral.setText(null);
        txtCapitalSocial.setText(null);
        txtDataSituacaoCadastral.setText(null);
        txtAtividadePrincipal.setText(null);
        txtAtividadeSecundaria.setText(null);
        txtNaturezaJuridica.setText(null);
        txtTelefone.setText(null);
        txtCelular.setText(null);
        txtResponsalvel.setText(null);
        txtEndereco.setText(null);
        txtNumero.setText(null);
        txtComplemento.setText(null);
        txtBairro.setText(null);
        txtCidade.setText(null);
        cmbEstado.setSelectedItem("");
        txtCep.setText(null);
        txtDataCadastro.setText(null);

        txtCnpj.setEditable(true);
        txtCnpj.setEnabled(true);
        txtInscricaoEstadual.setEditable(true);
        txtInscricaoEstadual.setEnabled(true);
        btnAdicionar.setEnabled(true);
        btnPesquisar.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnDeletar.setEnabled(false);
        btnLimpar.setEnabled(false);
    }
}
