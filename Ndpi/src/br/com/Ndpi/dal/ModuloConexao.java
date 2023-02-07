package br.com.Ndpi.dal;

import java.sql.*;
import javax.swing.JOptionPane;

public class ModuloConexao {

    public static Connection conector() {
        java.sql.Connection conexao;

        String driver = "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/bdndpi";
        String user = "root";
        String password = "";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);

            return conexao;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao se conectar! " + e);

            return null;
        }
    }

}
