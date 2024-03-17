/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import factory.ConexaoDB;
import view.TelaOs;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author nilton.brito
 */
@SuppressWarnings("unchecked")
public class RelatoriosBS {

    Connection conexao = null;
    public void relServicos() {
        // Gerando um relatório de serviços
        int confirma = JOptionPane.showConfirmDialog(null, "Confima a impressao do relatório", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            // Imprimindo ralatorio com o framework jasperreports
            try {
                conexao = ConexaoDB.conectar();
                // Usando a classe JasperPrint para prepara a impressão de um relatorio  
                // Fonte de dados
                String jasperReport = "src/reports/servicos.jrxml";
                // Paramentros
                JasperReport relatorio = JasperCompileManager.compileReport(jasperReport);
                JasperPrint JasperPrint = JasperFillManager.fillReport(relatorio, null, conexao);
                // a linha abaixo exibe o relatório atraves da classe JasperViewer
                JasperViewer.viewReport(JasperPrint, false);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, """
                                                   Ocorreu um erro de conex\u00e3o. Verifique a Base de Dados indicada !
                                                   """ + e.getMessage(), "Conexão", 3);
            }
        }
    }

    public void relUsuarios() {
        // Gerando um relatório de serviços
        int confirma = JOptionPane.showConfirmDialog(null, "Confima a impressao do relatório", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            // Imprimindo ralatorio com o framework jasperreports
            try {
                conexao = ConexaoDB.conectar();
                // Usando a classe JasperPrint para prepara a impressão de um relatorio  
                // Fonte de dados
                String jasperReport = "src/reports/uruarios.jrxml";
                // Paramentros
                JasperReport relatorio = JasperCompileManager.compileReport(jasperReport);
                JasperPrint JasperPrint = JasperFillManager.fillReport(relatorio, null, conexao);
                // a linha abaixo exibe o relatório atraves da classe JasperViewer
                JasperViewer.viewReport(JasperPrint, false);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, """
                                                   Ocorreu um erro de conex\u00e3o. Verifique a Base de Dados indicada !
                                                   """ + e.getMessage(), "Conexão", 3);
            }
        }
    }
    public void relClientes() {

        // Gerando um relatório de clientes
        int confirma = JOptionPane.showConfirmDialog(null, "Confima a impressao do relatório", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            // Imprimindo ralatorio com o framework jasperreports
            try {
                conexao = ConexaoDB.conectar();
                // Usando a classe JasperPrint para prepara a impressão de um relatorio  
                // Fonte de dados
                String jasperReport = "src/reports/clientes.jrxml";
                // Paramentros
                JasperReport relatorio = JasperCompileManager.compileReport(jasperReport);
                JasperPrint JasperPrint = JasperFillManager.fillReport(relatorio, null, conexao);
                // a linha abaixo exibe o relatório atraves da classe JasperViewer
                JasperViewer.viewReport(JasperPrint, false);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, """
                                                   Ocorreu um erro de conex\u00e3o. Verifique a Base de Dados indicada !
                                                   """ + e.getMessage(), "Conexão", 3);
            }
        }

    }

    // Metodo para imprimir uma OS
    public void imprimirOs() {

        // imprimindo uma OS de clientes
        int confirma = JOptionPane.showConfirmDialog(null, "Confima a impressao da OS?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            // Imprimindo ralatorio com o framework jasperreports
            try {
                conexao = ConexaoDB.conectar();
                // A classe HashMap para criar um filtro
                HashMap filtro = new HashMap();
                filtro.put("id_os", Integer.valueOf(TelaOs.txtOs.getText()));
                // Usando a classe JasperPrint para prepara a impressão de um relatorio  
                // Fonte de dados
                String jasperReport = "src/reports/ordemservico.jrxml";
                // Paramentros
                JasperReport relatorio = JasperCompileManager.compileReport(jasperReport);
                JasperPrint JasperPrint = JasperFillManager.fillReport(relatorio, filtro, conexao);
                // a linha abaixo exibe o relatório atraves da classe JasperViewer
                JasperViewer.viewReport(JasperPrint, false);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao gerar a OS " + e);
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
