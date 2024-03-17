/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import dao.OsDao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Os;
import static view.TelaOs.*;

/**
 *
 * @author nilto
 */
public class OsBS {
    // Metodo para Consultar clientes com filtos

    public void pesquisarCliente() {
        // Camando o metodo pesquisar clientes
        Os os = new Os();
        os.setTxtCliPesquisar(txtCliPesquisar.getText());

        OsDao osDao = new OsDao();
        osDao.pesquisarCliente(os);
    }

    // Metodo para setar os campos do formulario com conteúdo da tabela
    public void setarCampos() {

        Os os = new Os();
        OsDao osDao = new OsDao();
        osDao.setarCampos(os);
        txtCliId.setText(os.getTxtCliId());

        btnEmitirOs.setEnabled(true);
        btnOsPesquisar.setEnabled(false);
        btnOsAlterar.setEnabled(false);
        btnOsExcluir.setEnabled(false);
        btnOsLimpar.setEnabled(true);
        btnOsImprimir.setEnabled(false);
    }

    // Metodo para emitir uma OS
    public void emitirOs() {

        Os os = new Os();

        os.setCmbOstipo(cmbOsTipo.getSelectedItem().toString());
        os.setCmbOsSituacao(cmbOsSituacao.getSelectedItem().toString());
        os.setTxtOsEquip(txtOsEquip.getText());
        os.setTxtOsDef(txtOsDef.getText());
        os.setTxtOsServ(txtOsServ.getText());
        os.setTxtOsTecnico(txtOsTecnico.getText());
        os.setTxtOsValor(txtOsValor.getText());
        os.setTxtOsCondicao(txtOsCondicao.getText());
        os.setTxtOsMarca(txtOsMarca.getText());
        os.setTxtOsModelo(txtOsModelo.getText());
        os.setTxtOsNSerie(txtOsNSerie.getText());
        os.setTxtOsAcessorios(txtOsAcessorios.getText());
        os.setTxtOsLaudo(txtOsLaudo.getText());
        os.setTxtCliId(txtCliId.getText());

        OsDao osDao = new OsDao();
        osDao.emitirOs(os);

        if ((os.getTxtCliId().isEmpty()) || (os.getTxtOsEquip().isEmpty()) || (os.getTxtOsDef().isEmpty()) || (os.getCmbOsSituacao().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else if (osDao.resultado > 0) {
            JOptionPane.showMessageDialog(null, "OS emitida com sucesso!");
            // Recuperar o numero da OS
            recuperarOs();
            btnEmitirOs.setEnabled(false);
            btnOsPesquisar.setEnabled(false);
            btnOsImprimir.setEnabled(true);
        }
    }

    // Metodo para pesquisar uma OS
    public void pesquisarOs() {

        Os os = new Os();

        OsDao osDao = new OsDao();
        osDao.pesquisarOs(os);

        txtOs.setText(os.getTxtOs());
        txtDataOs.setText(os.getTxtDataOs());
        cmbOsTipo.setSelectedItem(os.getCmbOstipo());
        cmbOsSituacao.setSelectedItem(os.getCmbOsSituacao());
        txtOsEquip.setText(os.getTxtOsEquip());
        txtOsDef.setText(os.getTxtOsDef());
        txtOsServ.setText(os.getTxtOsServ());
        txtOsTecnico.setText(os.getTxtOsTecnico());
        txtOsValor.setText(os.getTxtOsValor());
        txtOsCondicao.setText(os.getTxtOsCondicao());
        txtOsMarca.setText(os.getTxtOsMarca());
        txtOsModelo.setText(os.getTxtOsModelo());
        txtOsNSerie.setText(os.getTxtOsNSerie());
        txtOsAcessorios.setText(os.getTxtOsAcessorios());
        txtOsLaudo.setText(os.getTxtOsLaudo());
        txtCliId.setText(os.getTxtCliId());

        btnEmitirOs.setEnabled(false);
        btnOsPesquisar.setEnabled(false);
        txtCliPesquisar.setEnabled(false);
        tabelaClientes.setVisible(false);
        btnOsAlterar.setEnabled(true);
        btnOsExcluir.setEnabled(true);
        btnOsLimpar.setEnabled(true);
        btnOsImprimir.setEnabled(true);
    }

    // Metodo para alterar uma OS
    public void alterarOs() {
        Os os = new Os();

        os.setCmbOstipo(cmbOsTipo.getSelectedItem().toString());
        os.setCmbOsSituacao(cmbOsSituacao.getSelectedItem().toString());
        os.setTxtOsEquip(txtOsEquip.getText());
        os.setTxtOsDef(txtOsDef.getText());
        os.setTxtOsServ(txtOsServ.getText());
        os.setTxtOsTecnico(txtOsTecnico.getText());
        os.setTxtOsValor(txtOsValor.getText());
        os.setTxtOsCondicao(txtOsCondicao.getText());
        os.setTxtOsMarca(txtOsMarca.getText());
        os.setTxtOsModelo(txtOsModelo.getText());
        os.setTxtOsNSerie(txtOsNSerie.getText());
        os.setTxtOsAcessorios(txtOsAcessorios.getText());
        os.setTxtOsLaudo(txtOsLaudo.getText());

        OsDao osDao = new OsDao();
        osDao.alterarOs(os);
        if ((os.getTxtCliId().isEmpty()) || (os.getTxtOsEquip().isEmpty()) || (os.getTxtOsDef().isEmpty()) || (os.getCmbOstipo().isEmpty()) || (os.getCmbOsSituacao().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else if (osDao.resultado > 0) {
            JOptionPane.showMessageDialog(null, "OS alterada com sucesso!");

            btnEmitirOs.setEnabled(false);
            btnOsPesquisar.setEnabled(false);
            txtCliPesquisar.setEnabled(false);
            tabelaClientes.setVisible(false);
            btnOsAlterar.setEnabled(true);
            btnOsExcluir.setEnabled(false);
            btnOsLimpar.setEnabled(true);
            btnOsImprimir.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao alterar dados da OS");
        }
    }

    // Metodo para deletar OS
    public void excluirOs() {

        Os os = new Os();
        os.setTxtOs(txtOs.getText());
        os.setCmbOsSituacao(cmbOsSituacao.getSelectedItem().toString());
        String verifica = os.getCmbOsSituacao();
        if (verifica.equals("Retirado")) {
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir a OS", "Aviso", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {
                if (os.getTxtOs().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
                } else {
                    OsDao osDao = new OsDao();
                    osDao.excluirOs(os);
                    if (osDao.resultado > 0) {
                        JOptionPane.showMessageDialog(null, "OS excluida com sucesso!");
                        limparOS();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Para excluir esta OS é necessário modificar\no status para \"Retirado\"");
        }
    }

// Metodo para recuperar OS
    public void recuperarOs() {

        Os os = new Os();
        OsDao osDao = new OsDao();
        osDao.recuperarOs(os);
        txtOs.setText(os.getTxtOs());
    }

// Metodo para limpar formulario da OS
    public void limparOS() {

        txtCliId.setText(null);
        txtDataOs.setText(null);
        txtOs.setText(null);
        txtOsDef.setText(null);
        txtOsEquip.setText(null);
        txtOsLaudo.setText(null);
        txtOsServ.setText(null);
        txtOsTecnico.setText(null);
        txtOsValor.setText(null);
        txtOsCondicao.setText(null);
        txtOsMarca.setText(null);
        txtOsModelo.setText(null);
        txtOsNSerie.setText(null);
        txtOsAcessorios.setText(null);
        txtOsLaudo.setText(null);
        cmbOsTipo.setSelectedItem("");
        cmbOsSituacao.setSelectedItem("");
        ((DefaultTableModel) tabelaClientes.getModel()).setRowCount(0);
        // Habilitar Botões
        btnEmitirOs.setEnabled(true);
        btnOsPesquisar.setEnabled(true);
        tabelaClientes.setVisible(true);
        txtCliPesquisar.setEnabled(true);
        // Desabilitar Botões
        btnOsAlterar.setEnabled(false);
        btnOsExcluir.setEnabled(false);
        btnOsImprimir.setEnabled(false);
        btnOsLimpar.setEnabled(false);
    }
}
