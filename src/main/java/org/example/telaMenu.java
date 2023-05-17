package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaMenu extends JFrame{
    private JPanel pnlMenu;
    private JLabel txtMenu;
    private JButton btnCadastro;
    private JButton btnListar;
public telaMenu() {
    iniciarComponentes();
}
    public void iniciarComponentes(){
        setTitle("Menu");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(pnlMenu);
        setVisible(true);
    }
    {
    btnCadastro.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
        }
    });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRelatorioClientes telaCadastroClientes = new TelaRelatorioClientes();
            }
        });
}
}
