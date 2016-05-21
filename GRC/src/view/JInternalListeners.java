package view;

import bean.GrupoProduto;
import bean.Produto;
import bean.Cliente;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JInternalListeners implements ActionListener {

    Cliente cliente;
    Produto produto;
    GrupoProduto grupoProduto;

    private ProcurarClienteJIF procurarCliente;
    private ProcurarProdutoJIF procurarProduto;
    private AniversarioJIF aniversario;
    private DataCompraJIF dataCompra;
    private RealizarVendaJIF realizarVenda;
    private CadastroClienteJIF cadCliente;
    private CadastroProdutoJIF cadProduto;
    private CadastroGrupoProdutoJIF cadGrupoProduto;
    
    private Clipboard clipboard;
    
    public JInternalListeners(){
	clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }
    
    public JInternalListeners(CadastroClienteJIF cadCliente) {
        this.cadCliente = cadCliente;
    }

    public JInternalListeners(CadastroProdutoJIF cadProduto) {
        this.cadProduto = cadProduto;
    }
    
    public JInternalListeners(CadastroGrupoProdutoJIF cadGrupoProduto) {
        this.cadGrupoProduto = cadGrupoProduto;
    }

    public JInternalListeners(RealizarVendaJIF realizarVenda) {
        this.realizarVenda = realizarVenda;
    }
    
    public JInternalListeners(ProcurarClienteJIF procurarCliente){
	this.procurarCliente = procurarCliente;
    }
    
    public JInternalListeners(ProcurarProdutoJIF procurarProduto){
	this.procurarProduto = procurarProduto;
    }
    
    public JInternalListeners(AniversarioJIF aniversario){
	this.aniversario = aniversario;
    }
    
    public JInternalListeners(DataCompraJIF dataCompra){
	this.dataCompra = dataCompra;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "salvarCliente":
                //obs CLiente c = cadCliente.getDadosCliente(); para usar dps
                if (cadCliente.getDadosCliente() != null) {
                    //mandar banco 
                    
                    cadCliente.setVisible(false);
                }

                break;
            case "cancelarCliente":
                cadCliente.setVisible(false);

                break;
            case "salvarNGrupo":
               if(cadGrupoProduto.getDadoGrupoProduto() != null){
                   //mandar banco
                   cadGrupoProduto.setVisible(false); 
               }
                break;
            case "cancelarNGrupo":
                  cadGrupoProduto.setVisible(false); 
                 
                break;
            case "salvarProduto":
                if (cadProduto.getDadosProduto() != null) {
                    //mandar banco
                    cadProduto.setVisible(false);
                }

                break;
            case "cancelarProduto":
                cadProduto.setVisible(false);
                break;
                
            case "salvarVenda":
                if(realizarVenda.getDadoVenda() != null){
                    realizarVenda.setVisible(false); 
                }
                break;
            case "cancelarVenda":
                realizarVenda.setVisible(false);
                break;
		
		
	    case "campoNome":
		procurarCliente.ProcurarNomeCliente();
		break;
		
	    case "campoCPF":
		procurarCliente.ProcurarCPFCliente();
		break;
		
	    case "copiarProcurarCliente":
		if(!procurarCliente.getNome().isEmpty()){
		    copy(procurarCliente.getNome());
		}
		break;
		
	    case "cancelarProcurarCliente":
		procurarCliente.setVisible(false);
		procurarCliente.apagarCampos();
		//System.out.println(e.paramString().substring(e.paramString().indexOf("cmd=")+4, e.paramString().indexOf(",when=")));
		break;
		
	    case "campoReferencia":
		procurarProduto.ProcurarReferencia();
		break;
		
	    case "copiarProcurarProduto":
		if(!procurarProduto.getReferencia().isEmpty()){
		    copy(procurarProduto.getReferencia());
		}
		break;
		
	    case "cancelarProcurarProduto":
		procurarProduto.setVisible(false);
		procurarProduto.apagarCampos();
		break;
		
	    case "campoAniversario":
		aniversario.procurarAniversario();
		break;
		
	    case "copiarPesquisaAniversario":
		if(!aniversario.getAniversario().isEmpty()){
		    copy(aniversario.getAniversario());
		}
		break;
		
	    case "cancelarPesquisaAniversario":
		aniversario.setVisible(false);
		aniversario.apagarCampos();
		break;
		
	    case "campoData":
		dataCompra.procurarDataCompra();
		break;
		
	    case "copiarDataCompra":
		if(!dataCompra.getCompra().isEmpty()){
		    copy(dataCompra.getCompra());
		}
		break;
		
	    case "cancelarDataCompra":
		dataCompra.setVisible(false);
		dataCompra.apagarCampos();
		break;
        }
    }
    
    //Métodos para área de transferencia
    //Ainda em teste
    private void copy(String cpy){
	StringSelection selection = new StringSelection(cpy);
	clipboard.setContents(selection, null);
    }
    
    private String paste(){
	StringSelection selection = new StringSelection(null);
	clipboard.getContents(selection);
	
	return (selection.toString());
    }

}
