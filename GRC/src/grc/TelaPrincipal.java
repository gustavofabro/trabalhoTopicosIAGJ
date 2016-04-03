/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grc;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class TelaPrincipal extends JFrame implements ActionListener {

    private JMenuBar menuBar;

    private JMenu cadastrarMenu;
    private JMenu vendasMenu;
    private JMenu relatorioMenu;
    private JMenu sobreMenu;

    private JMenuItem cadCliente;
    private JMenuItem cadProduto;
    private JMenuItem cadGrupoPro;
    private JMenuItem realizarVenda;
    private JMenuItem procurarCliente;
    private JMenuItem procurarProduto;
    private JMenuItem aniversario;
    private JMenuItem dataCompra;

    private Container c;

    private JDesktopPane deskPane;
    private JInternalFrame cadClienteIFrame;
    private JInternalFrame cadProdutoIFrame;
    private JInternalFrame cadGrupoProdIFrame;
    private JInternalFrame procurarClienteIFrame;
    private JInternalFrame procurarProdutoIFrame;
    private JInternalFrame vendaIFrame;

    public TelaPrincipal() {
        super("GRC");
        c = getContentPane();

        //JInternals Frames
        cadClienteIFrame = new CadastroCliente();
        cadProdutoIFrame = new CadastroProduto();
        cadGrupoProdIFrame = new CadastroGrupoProduto();
        procurarClienteIFrame = new ProcurarCliente();
        procurarProdutoIFrame = new ProcurarProduto();
        vendaIFrame = new RealizarVenda();

        menuBar = new JMenuBar();

        //menus
        cadastrarMenu = new JMenu("Cadastrar");
        vendasMenu = new JMenu("Venda");
        relatorioMenu = new JMenu("Relatórios");
        sobreMenu = new JMenu("Sobre");

        //itens de menu
        cadCliente = new JMenuItem("Clientes");
        cadProduto = new JMenuItem("Produtos");
        cadGrupoPro = new JMenuItem("Grupo de produtos");
        realizarVenda = new JMenuItem("Realizar venda");
        procurarCliente = new JMenuItem("Procurar Clientes");
        procurarProduto = new JMenuItem("Procurar Produtos");
        aniversario = new JMenuItem("Aniversários");
        dataCompra = new JMenuItem("Data compra");

        //adiciona um listener único para todos os botões
        cadCliente.addActionListener(this);
        cadProduto.addActionListener(this);
        cadGrupoPro.addActionListener(this);
        realizarVenda.addActionListener(this);
        procurarCliente.addActionListener(this);
        procurarProduto.addActionListener(this);
        aniversario.addActionListener(this);
        dataCompra.addActionListener(this);

        //adicionando itens de menu nos menus
        cadastrarMenu.add(cadCliente);
        cadastrarMenu.add(cadProduto);
        cadastrarMenu.add(cadGrupoPro);
        vendasMenu.add(realizarVenda);
        relatorioMenu.add(procurarCliente);
        relatorioMenu.add(procurarProduto);
        relatorioMenu.add(aniversario);
        relatorioMenu.add(dataCompra);

        menuBar.add(cadastrarMenu);
        menuBar.add(vendasMenu);
        menuBar.add(relatorioMenu);
        menuBar.add(sobreMenu);

        super.setJMenuBar(menuBar);

        //adiciona os Internals Frames ao DeskPane mas não os exibe 
        deskPane = new JDesktopPane();
        deskPane.add(cadClienteIFrame);
        deskPane.add(cadProdutoIFrame);
        deskPane.add(cadGrupoProdIFrame);
        deskPane.add(procurarClienteIFrame);
        deskPane.add(procurarProdutoIFrame);
        deskPane.add(vendaIFrame);

        //adiciona o DeskPane ao frame base
        add(deskPane);
    }

    //Implementei Action Listener aqui para servir somente pros MenuItens, e 
    //pensei em deixar a classe JInternalListeners para os eventos dos JInterNalFrames.
    //Não sei se pode ser assim
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Clientes":          cadCliente.setVisible(true);break;
            case "Produtos":          cadProduto.setVisible(true);break;
            case "Grupo de produtos": cadGrupoPro.setVisible(true);break;
            case "Realizar venda":    realizarVenda.setVisible(true);break;
            case "Procurar Clientes": procurarCliente.setVisible(true);break;
            case "Procurar Produtos": procurarProduto.setVisible(true);break;
            case "Aniversários":      aniversario.setVisible(true);break;
            case "Data compra":       dataCompra.setVisible(true); break;
        }
    }
}
