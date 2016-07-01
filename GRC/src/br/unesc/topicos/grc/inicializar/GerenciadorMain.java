/*
Ciência da Computação - UNESC
Disciplina: Topicos Especias - 5º fase 
Professor: Gilberto Vieira
Academicos: Alini Eyng e Gustavo Fabro
Ano: 2016/07

Tema: GRC (Gerenciamento e relacionamento com o Cliente) - baseado em um sistema de CRM
_____________________________________________________________________________________________
*/

package br.unesc.topicos.grc.inicializar;

import javax.swing.JFrame;
import br.unesc.topicos.grc.view.Login;

public class GerenciadorMain {

    public static void main(String[] args) {
        Login telalogin = new Login();
        telalogin.setSize(300, 310);
        telalogin.setLocationRelativeTo(null);
        telalogin.setResizable(false);
        telalogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telalogin.setVisible(true);
        telalogin.setFocusSenha();
    }
}
