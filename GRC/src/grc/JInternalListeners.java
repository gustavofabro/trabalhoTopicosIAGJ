package grc;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JInternalListeners implements ActionListener {

    Cliente cliente;
    Produto produto;
    GrupoProduto grupoProduto;

    private ProcurarCliente procurarCliente;
    private ProcurarProduto procurarProduto;
    private Aniversario aniversario;
    private DataCompra dataCompra;
    private RealizarVenda realizarVenda;
    private CadastroCliente cadCliente;
    private CadastroProduto cadProduto;
    private CadastroGrupoProduto cadGrupoProduto;
    
    private Clipboard clipboard;
    
    public JInternalListeners(){
	clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }
    
    //quero deixa só um construtor com todos, vou ver ainda.
    public JInternalListeners(CadastroCliente cadCliente) {
        this.cadCliente = cadCliente;
    }

    public JInternalListeners(CadastroProduto cadProduto) {
        this.cadProduto = cadProduto;
    }
    
    public JInternalListeners(CadastroGrupoProduto cadGrupoProduto) {
        this.cadGrupoProduto = cadGrupoProduto;
    }

    public JInternalListeners(RealizarVenda realizarVenda) {
        this.realizarVenda = realizarVenda;
    }
    
    public JInternalListeners(ProcurarCliente procurarCliente){
	this.procurarCliente = procurarCliente;
    }
    
    public JInternalListeners(ProcurarProduto procurarProduto){
	this.procurarProduto = procurarProduto;
    }
    
    public JInternalListeners(Aniversario aniversario){
	this.aniversario = aniversario;
    }
    
    public JInternalListeners(DataCompra dataCompra){
	this.dataCompra = dataCompra;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "salvarCliente":
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
