package listener;

import bean.Cliente;
import dao.ClienteDao;
import util.LogEvents;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroClienteJIF;

public class CadastroClienteListener implements ActionListener {

    private CadastroClienteJIF cadCliente;
    private ClienteDao dao = new ClienteDao();
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

                    cliente.setId_cliente(dao.getId());

                    dao.insert(cliente);

                    cadCliente.setVisible(false);
                    cadCliente.limparCampos();

                }

                break;
            case "cancelarCliente":
                cadCliente.setVisible(false);
                cadCliente.limparCampos();
                break;
        }
    }

}
