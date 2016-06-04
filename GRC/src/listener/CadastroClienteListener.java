package listener;

import bean.Cliente;
import util.LogEvents;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroClienteJIF;

public class CadastroClienteListener implements ActionListener {
    private LogEvents logEvents = new LogEvents();
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

                    //if (salvo com sucesso no banco)
                    logEvents.gravarLog("log.txt", "Cadastrado Cliente: " 
                            + cliente.getNome());
                    //else
                    // logEvents.gravarLog("log.txt", "Erro ao cadastrar Cliente: " 
                    //+ cliente.getNome());  
                 cadCliente.setVisible(false);
                }

                break;
            case "cancelarCliente":
                cadCliente.setVisible(false);
                break;
        }
    }

}
