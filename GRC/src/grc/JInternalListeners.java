package grc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JInternalListeners implements ActionListener {
    Cliente cliente;
    private CadastroCliente cadCliente;
   
    
    public JInternalListeners(CadastroCliente cadCliente){
        this.cadCliente = cadCliente;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
         switch(e.getActionCommand()){
             case "salvarCliente": cliente = cadCliente.getDadosCliente();
             break;
             case "cancelarCliente": break;
             case "salvarNGrupo" : break;
             case "cancelarNGrupo": break;
             case "salvarProduto": break;
             case "cancelarProduto": break;
         }
    }

}
