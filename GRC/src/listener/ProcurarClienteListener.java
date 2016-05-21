package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.AreaTransferencia;
import view.ProcurarClienteJIF;

public class ProcurarClienteListener implements ActionListener {

    private ProcurarClienteJIF procurarCliente;
    private AreaTransferencia clipboard;

    public ProcurarClienteListener(ProcurarClienteJIF procurarCliente) {
        this.procurarCliente = procurarCliente;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "campoNome":
                procurarCliente.ProcurarNomeCliente();
                break;

            case "campoCPF":
                procurarCliente.ProcurarCPFCliente();
                break;

            case "copiarProcurarCliente":
                if (!procurarCliente.getNome().isEmpty()) {
                    clipboard.copy(procurarCliente.getNome());
                }
                break;

            case "cancelarProcurarCliente":
                procurarCliente.setVisible(false);
                procurarCliente.apagarCampos();
                //System.out.println(e.paramString().substring(e.paramString().indexOf("cmd=")+4, e.paramString().indexOf(",when=")));
                break;

        }
    }
}
