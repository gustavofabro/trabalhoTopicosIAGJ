package br.unesc.topicos.grc.listener;

import br.unesc.topicos.grc.util.LogEvents;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.grc.view.ProcurarClienteJIF;

public class ProcurarClienteListener implements ActionListener {

    private ProcurarClienteJIF procurarCliente;

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
                }
                break;

            case "cancelarProcurarCliente":
                procurarCliente.setVisible(false);
                //System.out.println(e.paramString().substring(e.paramString().indexOf("cmd=")+4, e.paramString().indexOf(",when=")));
                break;

        }
    }
}