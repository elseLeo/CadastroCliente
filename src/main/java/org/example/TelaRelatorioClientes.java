package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class TelaRelatorioClientes extends JFrame {

    private JPanel pnlRelatorioClientes;
    private JLabel txtMenu;
    private JButton btnListar;
    private JButton btnVoltar;
    private JTable tblListarClientes;
    private JPanel tabelaClientes;
    final String URL = "jdbc:mysql://localhost:3306/cadastroCliente";
    final String USER = "root";
    final String PASSWORD = "root";
    final String BUSCAR = "SELECT * FROM cliente";

    public TelaRelatorioClientes() {
        iniciarComponentes();
        addListners();
    }

    public void iniciarComponentes() {
        setTitle("Relatório de Clientes");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlRelatorioClientes);
        setVisible(true);
    }

    public void addListners() {

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel clientes = new DefaultTableModel();
                clientes.addColumn("1");
                clientes.addColumn("2");
                clientes.addColumn("3");
                clientes.addColumn("4");
                clientes.addColumn("5");
                tblListarClientes.setModel(clientes);
                Connection connection = null;

                try {
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);
                    System.out.println("Conectado!");
                    Statement stmt = null;
                    stmt = connection.createStatement();
                    ResultSet rs = null;
                    rs = stmt.executeQuery(BUSCAR);

                    while (rs.next()) {
                        Object[] row = new Object[5];
                        row[0] = rs.getObject(1);
                        row[1] = rs.getObject(2);
                        row[2] = rs.getObject(3);
                        row[3] = rs.getObject(4);
                        row[4] = rs.getObject(5);
                        clientes.addRow(row);
                    }

                } catch (SQLException ex) {
                    System.out.println("Erro ao conectar no banco de dados");

                }
            }
        });


        {
            btnVoltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    telaMenu menu = new telaMenu();
                }
            });
        }

    }

    public static void main(String[] args) {
        TelaRelatorioClientes telaRelatorioClientes = new TelaRelatorioClientes();
    }
}
