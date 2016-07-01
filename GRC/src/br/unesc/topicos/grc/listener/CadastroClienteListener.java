package br.unesc.topicos.grc.listener;

import br.unesc.topicos.grc.bean.Cliente;
import br.unesc.topicos.grc.dao.ClienteDao;
import br.unesc.topicos.grc.exceptions.SistemaException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.grc.view.CadastroClienteJIF;
import javax.swing.JOptionPane;

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

                    try {
                        dao.insert(cliente);

                        cadCliente.setVisible(false);
                        cadCliente.limparCampos();
                    } catch (SistemaException ex) {
                        JOptionPane.showMessageDialog(null,
                                ex.getMessage(), "Erro", JOptionPane.OK_OPTION);
                    }

                }

                break;
        }
    }

}
