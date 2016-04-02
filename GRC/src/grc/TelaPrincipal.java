/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grc;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

/**
 *
 * @author gustavo
 */
public class TelaPrincipal  extends JFrame{
    private JMenuBar menuBar;
    private JMenu cadastrarMenu;
    private JMenu vendasMenu;
    private JMenu relatorioMenu;
    private JMenu sobreMenu;
    private JMenuItem cadCliente;
    private JMenuItem cadProduto;
    private JMenuItem cadGrupoPro;
    private Container c;

    public TelaPrincipal(){
        super("GRC");
        c = getContentPane();
        
        menuBar = new JMenuBar();
        
        cadastrarMenu = new JMenu("Cadastrar");
        vendasMenu = new JMenu("Cadastrar");
        relatorioMenu = new JMenu("Relatórios");
        sobreMenu = new JMenu("Sobre");

        cadCliente = new JMenuItem("Cadastrar Clientes");
        cadProduto = new JMenuItem("Cadastrar Produtos");
        cadGrupoPro = new JMenuItem("Cadastrar Grupo de produtos");
        
        cadastrarMenu.add(cadCliente);
        cadastrarMenu.add(cadProduto);
        cadastrarMenu.add(cadGrupoPro);
        
        menuBar.add(cadastrarMenu);
        menuBar.add(vendasMenu);
        menuBar.add(relatorioMenu);
        menuBar.add(sobreMenu);
        
        super.setJMenuBar(menuBar); 

    }
    
    
    public static void main(String[] args) {
        TelaPrincipal grcTela = new TelaPrincipal();
        grcTela.setSize(800, 600);
        grcTela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        grcTela.setVisible(true);
    }


    
}
