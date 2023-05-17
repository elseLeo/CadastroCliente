package br.sc.senac.cadastroCliente.util;

import javax.swing.*;
import java.sql.*;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql//localhost:3306/cadastroCliente";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConexao() {
        Connection conexao = null;

        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);

            if (conexao != null) {
                System.out.println("Conexão com o banco de dados estabelecida");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados: "
                    + e.getMessage(), " Erro 46: ", JOptionPane.ERROR_MESSAGE);
        }
        return conexao;
    }
}

