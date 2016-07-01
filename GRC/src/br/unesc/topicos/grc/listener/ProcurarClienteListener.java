package br.unesc.topicos.grc.listener;

import br.unesc.topicos.grc.bean.Cliente;
import br.unesc.topicos.grc.dao.ClienteDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.grc.view.ProcurarClienteJIF;

public class ProcurarClienteListener implements ActionListener {

    private ClienteDao dao = new ClienteDao();
    private ProcurarClienteJIF procurarCliente;

    public ProcurarClienteListener(ProcurarClienteJIF procurarCliente) {
        this.procurarCliente = procurarCliente;
    }

    public void atualizarLista() {
        String[] valores = procurarCliente.getDadosProcura();
        procurarCliente.setListaClientes(
                dao.selectCliente(valores[0], valores[1]));

        procurarCliente.camposEnables(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "procurarCliente":
                procurarCliente.disableButtons();
                atualizarLista();
                break;

            case "deletarCliente":
                if (procurarCliente.confirmarExclusao()) {
                    dao.delete(procurarCliente.getCliente());

                    atualizarLista();
                }

                break;

            case "editarCliente":
                procurarCliente.camposEnables(true);
                procurarCliente.editarActions();
                break;

            case "salvarAlteracoes":
                Cliente cliente = procurarCliente.salvar();

                if (cliente != null) {
                    dao.update(cliente);
                    procurarCliente.limparCampos(false, false);
                    procurarCliente.disableButtons();
                    atualizarLista();
                }
                break;

        }
    }
}
