package inicializar;

import javax.swing.JFrame;
import view.Login;

public class GerenciadorMain {

    public static void main(String[] args) {
        Login telalogin = new Login();
        telalogin.setSize(300, 310);
        telalogin.setLocationRelativeTo(null);
        telalogin.setResizable(false);
        telalogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telalogin.setVisible(true);
	
    }
}
