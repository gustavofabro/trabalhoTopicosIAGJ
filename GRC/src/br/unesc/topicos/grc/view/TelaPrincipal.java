
package br.unesc.topicos.grc.view;

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

public class TelaPrincipal extends JFrame implements ActionListener {

    private final String sobreInfo;
    private final JMenuBar menuBar;

    private final JMenu cadastrarMenu;
    private final JMenu vendasMenu;
    private final JMenu relatorioMenu;
    private final JMenu sobreMenu;

    private final JMenuItem cadCliente;
    private final JMenuItem cadProduto;
    private final JMenuItem cadGrupoPro;
    private final JMenuItem realizarVenda;
    private final JMenuItem procurarCliente;
    private final JMenuItem procurarProduto;
    private final JMenuItem aniversario;
    private final JMenuItem dataCompra;
    private final JMenuItem sobre;

    private final Container c;

    private final JDesktopPane deskPane;
    private static JInternalFrame cadClienteIFrame;
    private static JInternalFrame cadProdutoIFrame;
    private final JInternalFrame cadGrupoProdIFrame;
    private final JInternalFrame procurarClienteIFrame;
    private final JInternalFrame procurarProdutoIFrame;
    private final JInternalFrame vendaIFrame;
    private final JInternalFrame aniversarioIFrame;
    private final JInternalFrame dataCompraIFrame;

    // private JPanel logoPanel;
    // private final ImageIcon logoGRC;
    public TelaPrincipal() {

        super("GRC");
        c = getContentPane();
        deskPane = new JDesktopPane();
        sobreInfo = "GRC - Tópicos I";

        //JInternals Frames
        cadClienteIFrame = new CadastroClienteJIF();
        cadProdutoIFrame = new CadastroProdutoJIF();
        cadGrupoProdIFrame = new CadastroGrupoProdutoJIF();
        procurarClienteIFrame = new ProcurarClienteJIF();
        procurarProdutoIFrame = new ProcurarProdutoJIF();
        vendaIFrame = new RealizarVendaJIF();
        aniversarioIFrame = new AniversarioJIF();
        dataCompraIFrame = new DataCompraJIF();

        menuBar = new JMenuBar();

        //menus
        cadastrarMenu = new JMenu("Cadastrar");
        vendasMenu = new JMenu("Venda");
        relatorioMenu = new JMenu("Relatórios");
        sobreMenu = new JMenu("Ajuda");

        //itens de menu
        cadCliente = new JMenuItem("Clientes");
        cadProduto = new JMenuItem("Produtos");
        cadGrupoPro = new JMenuItem("Grupo de produtos");
        realizarVenda = new JMenuItem("Realizar venda");
        procurarCliente = new JMenuItem("Procurar Clientes");
        procurarProduto = new JMenuItem("Procurar Produtos");
        aniversario = new JMenuItem("Aniversários");
        dataCompra = new JMenuItem("Data compra");
        sobre = new JMenuItem("Sobre");

        cadCliente.addActionListener(this);
        cadProduto.addActionListener(this);
        cadGrupoPro.addActionListener(this);
        realizarVenda.addActionListener(this);
        procurarCliente.addActionListener(this);
        procurarProduto.addActionListener(this);
        aniversario.addActionListener(this);
        dataCompra.addActionListener(this);
        sobre.addActionListener(this);

        //adicionando itens de menu nos menus
        cadastrarMenu.add(cadCliente);
        cadastrarMenu.add(cadProduto);
        cadastrarMenu.add(cadGrupoPro);
        vendasMenu.add(realizarVenda);
        relatorioMenu.add(procurarCliente);
        relatorioMenu.add(procurarProduto);
        relatorioMenu.add(aniversario);
        relatorioMenu.add(dataCompra);
        sobreMenu.add(sobre);

        menuBar.add(relatorioMenu);
        menuBar.add(vendasMenu);
        menuBar.add(cadastrarMenu);
        menuBar.add(sobreMenu);

        super.setJMenuBar(menuBar);

        //adiciona os Internals Frames ao DeskPane mas não os exibe 
        deskPane.add(cadClienteIFrame);
        deskPane.add(cadProdutoIFrame);
        deskPane.add(cadGrupoProdIFrame);
        deskPane.add(vendaIFrame);
        deskPane.add(procurarClienteIFrame);
        deskPane.add(procurarProdutoIFrame);
        deskPane.add(aniversarioIFrame);
        deskPane.add(dataCompraIFrame);

        add(deskPane);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Clientes":
                cadClienteIFrame.setVisible(true);
                break;
            case "Produtos":
                cadProdutoIFrame.setVisible(true);
                break;
            case "Grupo de produtos":
                cadGrupoProdIFrame.setVisible(true);
                break;
            case "Realizar venda":
                vendaIFrame.setVisible(true);
                break;
            case "Procurar Clientes":
                procurarClienteIFrame.setVisible(true);
                break;
            case "Procurar Produtos":
                procurarProdutoIFrame.setVisible(true);
                break;
            case "Aniversários":
                aniversarioIFrame.setVisible(true);
                break;
            case "Data compra":
                dataCompraIFrame.setVisible(true);
                break;
            case "Sobre":

                JOptionPane.showMessageDialog(this, sobreInfo);
        }
    }

    public static void novoCadastro() {
        cadClienteIFrame.setVisible(true);
    }

    public static void novoProduto() {
        cadProdutoIFrame.setVisible(true);
    }
}
