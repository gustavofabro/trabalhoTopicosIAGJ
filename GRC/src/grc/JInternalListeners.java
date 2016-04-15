package grc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JInternalListeners implements ActionListener {
    Cliente cliente;
    Produto produto;
    private ProcurarCliente procurarCliente;
    private ProcurarProduto procurarProduto;
    private CadastroCliente cadCliente;
    private CadastroProduto cadProduto;
   
    
    public JInternalListeners(CadastroCliente cadCliente){
        this.cadCliente = cadCliente;
    }
    
    public JInternalListeners(CadastroProduto cadProduto){
        this.cadProduto = cadProduto;
    }
    
    public JInternalListeners(ProcurarCliente procurarCliente){
	this.procurarCliente = procurarCliente;
    }
    
    public JInternalListeners(ProcurarProduto procurarProduto){
	this.procurarProduto = procurarProduto;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "salvarCliente":
                if (cadCliente.getDadosCliente() != null) {
                    //mandar banco 
                }

                break;
            case "cancelarCliente":
                break;
            case "salvarNGrupo":
                break;
            case "cancelarNGrupo":
                break;
            case "salvarProduto":
                if (cadProduto.getDadosProduto() != null) {
                    //mandar banco
                }
                break;
            case "cancelarProduto":
                break;
		
	    case "campoNome":
		//if ()
        }
    }

}
