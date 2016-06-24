package br.unesc.topicos.grc.listener;

import br.unesc.topicos.grc.util.LogEvents;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.grc.view.ProcurarProdutoJIF;

public class ProcurarProdutoListener implements ActionListener {

    private ProcurarProdutoJIF procurarProduto;

    public ProcurarProdutoListener(ProcurarProdutoJIF procurarProduto) {
        this.procurarProduto = procurarProduto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "campoReferencia":
                procurarProduto.ProcurarReferencia();
                break;

            case "copiarProcurarProduto":
                if (!procurarProduto.getReferencia().isEmpty()) {
                }
                break;

            case "cancelarProcurarProduto":
                procurarProduto.setVisible(false);
                break;

        }
    }
}
