/*
 * The MIT License
 *
 * Copyright 2023 nilto.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package factory;

/**
 *
 * @author nilton.brito
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoDB {

    //CONSTRUTOR
    public ConexaoDB() {
    }

    // MÉTODOS
    public static Connection conectar() {

        java.sql.Connection conexao = null;

        //Variavel para conexão com banco de dados
        String driver = "com.mysql.cj.jdbc.Driver";
        //String url = "jdbc:mysql://database-bandampla.cwdtmxf8izpl.us-east-2.rds.amazonaws.com:3306/bandampla_db?characterEncoding=utf-8";
        String url = "jdbc:mysql://localhost:3306/bandampla_db?characterEncoding=utf-8";
        String user = "root";
        String password = "";
        try {
            //Indica o caminho da classe Driver na biblioteca do jdbc
            Class.forName(driver);
            //Faz a conexão com o banco de dados
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (ClassNotFoundException cnf) {
            if (conexao == null) {
                JOptionPane.showMessageDialog(null, "Classe JDBC Driver nao encontrada.");
                System.exit(0);
            }
            return null;
        } catch (SQLException e) {
            if (conexao == null) {
                JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco de dados.");
                System.exit(0);
                return null;
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    """
                    Ocorreu um erro de conex\u00e3o. Verifique a Base de Dados indicada !
                    """ + erro.getMessage(), "Conexão", 3);
        }
        return null;
    }
}
