package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TelaCadastroCliente extends JFrame{
    private JPanel pnlCadastroCliente;
    private JLabel txtPoupexxx;
    private JLabel lblCodCliente;
    private JLabel lblNome;
    private JLabel lblSobrenome;
    private JLabel lblProfissao;
    private JLabel lblTelefone;
    private JTextField txtCodCliente;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtProfissao;
    private JTextField txtTelefone;
    private JButton btnOK;
    private JButton btnVoltar;
    final String URL = "jdbc:mysql://localhost:3306/cadastroCliente";
    final String USER = "root";
    final String PASSWORD = "root";
    final String INSERIR = "INSERT INTO cliente (cod_cliente, nome, sobrenome, profissao, telefone) VALUES(?,?,?,?,?)";
    final String BUSCAR = "SELECT * FROM cliente";
public TelaCadastroCliente() {
    iniciarComponentes();
    conectar();

    btnVoltar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            telaMenu telaMenu = new telaMenu();
        }
    });
}
    public void iniciarComponentes(){
        setTitle("Cadastro de Clientes");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlCadastroCliente);
        setVisible(true);
    }

    public void conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado!");

            final PreparedStatement stmtInserir;


            stmtInserir = con.prepareStatement(INSERIR);

            btnOK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String codCliente1 = txtCodCliente.getText();
                    String nome = txtNome.getText();
                    String sobrenome = txtSobrenome.getText();
                    String profissao = txtProfissao.getText();
                    String telefone = txtTelefone.getText();
                        try {
                            Integer codCliente = Integer.parseInt(codCliente1);
                            stmtInserir.setInt(1, codCliente);
                            stmtInserir.setString(2, nome);
                            stmtInserir.setString(3, sobrenome);
                            stmtInserir.setString(4, profissao);
                            stmtInserir.setString(5, telefone);
                            stmtInserir.executeUpdate();
                            System.out.println("Dados Inseridos!");
                            String dadosCadastrados = "Código do Cliente: " + txtCodCliente.getText() + "\n"
                                    + "Nome: " + txtNome.getText() + "\n"
                                    + "Sobrenome: " + txtSobrenome.getText() +"\n"
                                    + "Profissão: " + txtProfissao.getText() +"\n"
                                    + "Telefone: " + txtTelefone.getText() + "\n";
                            JOptionPane.showMessageDialog(btnOK, dadosCadastrados);
                            txtNome.setText("");
                            txtCodCliente.setText("");
                            txtSobrenome.setText("");
                            txtProfissao.setText("");
                            txtTelefone.setText("");
                        }catch (SQLException ex) {
                            System.out.println("Erro ao conectar o banco de dados 1!");
                        }
                }
            });
        }catch (Exception ex) {
            System.out.println("Erro ao conectar o banco de dados 2!");
        }
    }

    public static void main(String[] args) {

    TelaCadastroCliente calculadoraInvestimento = new TelaCadastroCliente();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
