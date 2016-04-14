/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grc;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author gustavo
 */
public class Login extends JFrame {

    private JTextField entradaLogin;
    private JPasswordField entradaSenha;
    private JLabel usuarioLabel;
    private JLabel senhaLabel;
    private JLabel warning;
    private JButton btnEntrar;
    private JButton btnAjuda;
    private Container c;
    private Font font;
    private String usuario = "admin";
    private char[] senha = {'1', '2', '3'};
    
    public Login() {
        super("GRC Login (BETA)");
     
        entradaLogin = new JTextField();
        entradaSenha = new JPasswordField();
        usuarioLabel = new JLabel("Usuário");
        senhaLabel = new JLabel("Senha");
        btnEntrar = new JButton("Entrar");
        btnAjuda = new JButton("Ajuda");
        warning = new JLabel("Usuário e/ou senha inválido(s)");
        
        usuarioLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        senhaLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        warning.setForeground(Color.red);
 
        usuarioLabel.setBounds(10, 5, 150, 50);
        entradaLogin.setBounds(10, 50, 280, 30);
        senhaLabel.setBounds(10, 90, 150, 50);
        entradaSenha.setBounds(10, 135, 280, 30);
        warning.setBounds(10, 165, 280, 30);
        btnEntrar.setBounds(10, 200, 135, 30);
        btnAjuda.setBounds(155, 200, 135, 30);

        warning.setVisible(false);
        
        c = getContentPane();
        c.setLayout(null);
        
        c.add(usuarioLabel);
        c.add(entradaLogin);
        c.add(senhaLabel);
        c.add(entradaSenha);
        c.add(warning);
        c.add(btnEntrar);
        c.add(btnAjuda);
        
        //listeners
        btnEntrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                validarLogin(entradaLogin.getText(), entradaSenha.getPassword());
            }
        });

        getRootPane().setDefaultButton(btnEntrar); 
        
    }
    
    public void validarLogin(String usuarioEntrada, char[] senhaEntrada){
        if (usuarioEntrada.equals(usuario) && Arrays.equals(senhaEntrada, senha)) {
            warning.setVisible(false); //se travar pra abrir o sistema, pelo menos vai sumir o aviso 
            carregarSistema();
            this.dispose();            
        } else {
            warning.setVisible(true);
        }
    }
    
    public void carregarSistema(){
        TelaPrincipal grcTela = new TelaPrincipal();
        grcTela.setSize(1024, 700);
        grcTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grcTela.setVisible(true);
    }
}
