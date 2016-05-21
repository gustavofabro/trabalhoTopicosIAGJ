package listener;

import bean.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroClienteJIF;

public class CadastroClienteListener implements ActionListener {

    private CadastroClienteJIF cadCliente;
    private Cliente cliente;

    public CadastroClienteListener(CadastroClienteJIF cadCliente) {
        this.cadCliente = cadCliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "salvarCliente":
               cliente = cadCliente.getDadosCliente();
                if (cliente != null) {
                    //mandar banco 

                    cadCliente.setVisible(false);
                }

                break;
            case "cancelarCliente":
                cadCliente.setVisible(false);
                break;
        }
    }

}
