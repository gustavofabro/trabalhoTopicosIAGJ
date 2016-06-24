package br.unesc.topicos.grc.view;

import br.unesc.topicos.grc.dao.Conexao;
import br.unesc.topicos.grc.dao.LoginDao;
import br.unesc.topicos.grc.util.LogEvents;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

    private LoginDao dao = new LoginDao();
    private LogEvents logEvents = new LogEvents();
    private JTextField entradaLogin;
    private final JPasswordField entradaSenha;
    private final JLabel usuarioLabel;
    private final JLabel senhaLabel;
    private final JLabel warning;
    private final JButton btnEntrar;
    private final JButton btnAjuda;
    private final Container c;

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
        entradaLogin.setText(lerUsuario());

        //listeners
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarLogin(entradaLogin.getText(), entradaSenha.getPassword());
            }
        });

        getRootPane().setDefaultButton(btnEntrar);

    }

    public void validarLogin(String usuarioEntrada, char[] senhaEntrada) {

        if (Conexao.getConnection() != null) {
            if (dao.select(usuarioEntrada, new String(senhaEntrada))) {

                warning.setVisible(false);
                carregarSistema();
                this.dispose();

                gravaUsuario(entradaLogin.getText());

                logEvents.gravarLog("Login realizado pelo usuario: "
                        + entradaLogin.getText());
            } else {
                warning.setVisible(true);
            }
        }
    }

    public void gravaUsuario(String usuario) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileWriter = new FileWriter("lastuser.txt", false);
            bufferedWriter = new BufferedWriter(fileWriter);;

            bufferedWriter.write(usuario);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ex) {
            logEvents.gravarLog(ex.getMessage() + "\n");
        }
    }

    public String lerUsuario() {
        String linha = "";
        try {
            FileReader fr = new FileReader("lastuser.txt");
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()) {
                linha = br.readLine();
            }

            br.close();
            fr.close();

        } catch (IOException ex) {
            gravaUsuario("");
        }

        return linha;
    }

    public void setFocusSenha() {
        if (!entradaLogin.getText().equals("")) {
            entradaSenha.requestFocusInWindow();
        }
    }

    public void carregarSistema() {
        TelaPrincipal grcTela = new TelaPrincipal();
        grcTela.setSize(1024, 700);
        grcTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grcTela.setVisible(true);
    }

}
