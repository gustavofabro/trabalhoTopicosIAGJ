package br.unesc.topicos.grc.listener;

import br.unesc.topicos.grc.dao.ProdutoDao;
import br.unesc.topicos.grc.util.LogEvents;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.grc.view.ProcurarProdutoJIF;

public class ProcurarProdutoListener implements ActionListener {
    private ProdutoDao dao = new ProdutoDao();
    private ProcurarProdutoJIF procurarProduto;

    public ProcurarProdutoListener(ProcurarProdutoJIF procurarProduto) {
        this.procurarProduto = procurarProduto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "procurarProduto":
                String [] valores = procurarProduto.getDadosProcura();
                procurarProduto.setListaProdutos(
                        dao.selectProduto(valores[0], valores[1])); 
                
        }
    }
}
