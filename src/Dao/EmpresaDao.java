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

/**
 *
 * @author nilton.brito
 */
public class EmpresaDao {

    private Connection conexao = null;
    PreparedStatement statement;
    ResultSet resp = null;
    public int resultado;
    public boolean resultado1;
    public String erro;

    public void adicionarEmpresa(Empresa empresa) {

        String sql = "insert into tbempresa (cnpj_empresa,tipo_empresa,inscr_estad_empresa,nome_empresa,nome_fanta_empresa,data_abert_empresa,porte_empresa,email_empresa,situac_cadast_empresa,capit_soci_empresa,data_situ_cadast_empresa,ativ_pri_empresa,ativ_seg_empresa,natur_jurid_empresa,telefone_empresa,celular_empresa,respons_empresa,endereco_empresa,numero_empresa,complem_empresa,bairro_empresa,cidade_empresa,estado_empresa,cep_empresa) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            statement.setString(1, empresa.getCnpj());
            statement.setString(2, empresa.getTipo());
            statement.setString(3, empresa.getTxtInscricaoEstadual());
            statement.setString(4, empresa.getNome());
            statement.setString(5, empresa.getFantasia());
            statement.setString(6, empresa.getAbertura());
            statement.setString(7, empresa.getPorte());
            statement.setString(8, empresa.getEmail());
            statement.setString(9, empresa.getSituacao());
            statement.setString(10, empresa.getCapital_social());
            statement.setString(11, empresa.getData_situacao());
            statement.setString(12, empresa.getAtividade_principal().toString());
            statement.setString(13, empresa.getAtividades_secundarias().toString());
            statement.setString(14, empresa.getNatureza_juridica());
            statement.setString(15, empresa.getTelefone());
            statement.setString(16, empresa.getTxtCelular());
            statement.setString(17, empresa.getTxtResponsalvel());
            statement.setString(18, empresa.getLogradouro());
            statement.setString(19, empresa.getNumero());
            statement.setString(20, empresa.getComplemento());
            statement.setString(21, empresa.getBairro());
            statement.setString(22, empresa.getMunicipio());
            statement.setString(23, empresa.getUf());
            statement.setString(24, empresa.getCep());

            resultado = statement.executeUpdate();// Se tiver êxito retorna o valor 1 para a variavel adicionado
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

    // Metodo para Consultar usuários
    public void consultarEmpresa(Empresa empresa) {

        String num_cnpj = JOptionPane.showInputDialog("Informe o número do CNPJ:");

        String sql = "select id_empresa,cnpj_empresa,tipo_empresa,inscr_estad_empresa,nome_empresa,nome_fanta_empresa,data_abert_empresa,porte_empresa,email_empresa,situac_cadast_empresa,capit_soci_empresa,data_situ_cadast_empresa,ativ_pri_empresa,ativ_seg_empresa,natur_jurid_empresa,telefone_empresa,celular_empresa,respons_empresa,endereco_empresa,numero_empresa,complem_empresa,bairro_empresa,cidade_empresa,estado_empresa,cep_empresa,date_format(data_cadast_empresa,'%d/%m/%y - %H:%i') from tbempresa where cnpj_empresa=" + num_cnpj;

        try {

            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);
            resp = statement.executeQuery();
            resultado1 = resp.next();

            empresa.setTxtId(resp.getString(1));
            empresa.setCnpj(resp.getString(2));
            empresa.setTipo(resp.getString(3));
            empresa.setTxtInscricaoEstadual(resp.getString(4));
            empresa.setNome(resp.getString(5));
            empresa.setFantasia(resp.getString(6));
            empresa.setAbertura(resp.getString(7));
            empresa.setPorte(resp.getString(8));
            empresa.setEmail(resp.getString(9));
            empresa.setSituacao(resp.getString(10));
            empresa.setCapital_social(resp.getString(11));
            empresa.setData_situacao(resp.getString(12));
            empresa.setPrincipal(resp.getString(13));
            empresa.setSecundarias(resp.getString(14));
            empresa.setNatureza_juridica(resp.getString(15));
            empresa.setTelefone(resp.getString(16));
            empresa.setTxtCelular(resp.getString(17));
            empresa.setTxtResponsalvel(resp.getString(18));
            empresa.setLogradouro(resp.getString(19));
            empresa.setNumero(resp.getString(20));
            empresa.setComplemento(resp.getString(21));
            empresa.setBairro(resp.getString(22));
            empresa.setMunicipio(resp.getString(23));
            empresa.setUf(resp.getString(24));
            empresa.setCep(resp.getString(25));
            empresa.setTxtDataCadastro(resp.getString(26));

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

    // Metodo para alterar dados do usuários
    public void atualizarEmpresa(Empresa empresa) {

        LocalDateTime datahora = LocalDateTime.now();
        DateTimeFormatter formatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataatualizacao = (datahora.format(formatada));

        String sql = "update tbempresa set tipo_empresa=?,inscr_estad_empresa=?,nome_empresa=?,nome_fanta_empresa=?,data_abert_empresa=?,porte_empresa=?,email_empresa=?,situac_cadast_empresa=?,capit_soci_empresa=?,data_situ_cadast_empresa=?,ativ_pri_empresa=?,ativ_seg_empresa=?,natur_jurid_empresa=?,telefone_empresa=?,celular_empresa=?,respons_empresa=?,endereco_empresa=?,numero_empresa=?,complem_empresa=?,bairro_empresa=?,cidade_empresa=?,estado_empresa=?,cep_empresa=?,data_atualiz_empresa=? where cnpj_empresa=?";
        try {
            conexao = ConexaoDB.conectar();
            statement = conexao.prepareStatement(sql);

            statement.setString(1, empresa.getTipo());
            statement.setString(2, empresa.getTxtInscricaoEstadual());
            statement.setString(3, empresa.getNome());
            statement.setString(4, empresa.getFantasia());
            statement.setString(5, empresa.getAbertura());
            statement.setString(6, empresa.getPorte());
            statement.setString(7, empresa.getEmail());
            statement.setString(8, empresa.getSituacao());
            statement.setString(9, empresa.getCapital_social());
            statement.setString(10, empresa.getData_situacao());
            statement.setString(11, empresa.getPrincipal());
            statement.setString(12, empresa.getSecundarias());
            statement.setString(13, empresa.getNatureza_juridica());
            statement.setString(14, empresa.getTelefone());
            statement.setString(15, empresa.getTxtCelular());
            statement.setString(16, empresa.getTxtResponsalvel());
            statement.setString(17, empresa.getLogradouro());
            statement.setString(18, empresa.getNumero());
            statement.setString(19, empresa.getComplemento());
            statement.setString(20, empresa.getBairro());
            statement.setString(21, empresa.getMunicipio());
            statement.setString(22, empresa.getUf());
            statement.setString(23, empresa.getCep());
            statement.setString(24, dataatualizacao);
            statement.setString(25, empresa.getCnpj());

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

    // Metodo para deletar usuários
    public void deletarEmpresa(Empresa empresa) {

        String sql = "delete from tbempresa where id_empresa=?";
        try {
            conexao = ConexaoDB.conectar();

            statement = conexao.prepareStatement(sql);
            statement.setString(1, empresa.getTxtId());
            resultado = statement.executeUpdate();
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
