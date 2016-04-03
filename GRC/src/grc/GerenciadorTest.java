package grc;

import javax.swing.JFrame;

/**
 *
 * @author gustavo
 */
public class GerenciadorTest {

    public static void main(String[] args) {
        Login telalogin = new Login();
        telalogin.setSize(300, 320);
        telalogin.setLocationRelativeTo(null);
        telalogin.setResizable(false);
        telalogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telalogin.setVisible(true);
      
    }
}
