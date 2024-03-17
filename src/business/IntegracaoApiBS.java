/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import com.google.gson.*;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;
import model.Empresa;
import model.Endereco;
import static view.TelaCadastroEmpresa.*;

/**
 *
 * @author nilto
 */
public class IntegracaoApiBS {

    public static Endereco buscarCep(String cep) throws IOException, Exception {

        try {
            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setDoInput(true);
            String convertJsonString = new String(conexao.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            Gson gson = new Gson();
            Endereco endereco = gson.fromJson(convertJsonString, Endereco.class);
            if (convertJsonString.length() == 18) {
                endereco.setLblStatusCep(new javax.swing.ImageIcon("src/image/unconfirm.png"));
                JOptionPane.showMessageDialog(null, "CEP não encontrado na base de Dados");
                endereco.setCep("");
            } else {
                endereco.setLblStatusCep(new javax.swing.ImageIcon("src/image/confirm.png"));
                return endereco;
            }
        } catch (JsonSyntaxException | IOException msgErro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão- status Code " + msgErro.toString());
        }
        return null;
    }

    public static Empresa buscarCnpj(String cnpj) {

        try {
            URL url = new URL("https://www.receitaws.com.br/v1/cnpj/" + cnpj);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");
            conexao.setDoInput(true);
            String convertJsonString = new String(conexao.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            Gson gson = new Gson();
            Empresa empresa = gson.fromJson(convertJsonString, Empresa.class);
            if (convertJsonString.length() == 53) {
                lblStatusCnpj.setIcon(new javax.swing.ImageIcon("src/image/unconfirm.png"));
                JOptionPane.showMessageDialog(null, "CNPJ Inválido não encontrado na base de Dados");
                empresa.setCnpj("");
            } else {
                lblStatusCnpj.setIcon(new javax.swing.ImageIcon("src/image/confirm.png"));
                return empresa;
            }
        } catch (JsonSyntaxException | IOException msgErro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão- status Code " + msgErro.toString());
        }
        return null;
    }
}
