package grc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JInternalListeners implements ActionListener {
    Cliente cliente;
    Produto produto;
    private CadastroCliente cadCliente;
    private CadastroProduto cadProduto;
   
    
    public JInternalListeners(CadastroCliente cadCliente){
        this.cadCliente = cadCliente;
    }
    
    public JInternalListeners(CadastroProduto cadProduto){
        this.cadProduto = cadProduto;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
         switch(e.getActionCommand()){
             case "salvarCliente": break;
             case "cancelarCliente": break;
             case "salvarNGrupo" : break;
             case "cancelarNGrupo": break;
             case "salvarProduto": break;
             case "cancelarProduto": break;
         }
    }

}
