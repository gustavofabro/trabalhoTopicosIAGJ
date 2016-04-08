package grc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JInternalListeners implements ActionListener {
    private CadastroCliente cadCliente;
   
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
