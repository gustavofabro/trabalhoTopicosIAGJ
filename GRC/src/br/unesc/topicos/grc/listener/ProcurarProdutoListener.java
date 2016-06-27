package br.unesc.topicos.grc.listener;

import br.unesc.topicos.grc.bean.Produto;
import br.unesc.topicos.grc.dao.GrupoProdutoDao;
import br.unesc.topicos.grc.dao.ProdutoDao;
import br.unesc.topicos.grc.exceptions.SistemaException;
import br.unesc.topicos.grc.util.LogEvents;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.grc.view.ProcurarProdutoJIF;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProcurarProdutoListener implements ActionListener {

    private ProdutoDao dao = new ProdutoDao();
    private GrupoProdutoDao daoGrupo = new GrupoProdutoDao();

    private ProcurarProdutoJIF procurarProduto;

    public ProcurarProdutoListener(ProcurarProdutoJIF procurarProduto) {
        this.procurarProduto = procurarProduto;
    }

    public void atualizarLista() {
        String[] valores = procurarProduto.getDadosProcura();
        procurarProduto.setListaProdutos(
                dao.selectProduto(valores[0], valores[1]));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "procurarProduto":
                atualizarLista();
                break;

            case "deletarProduto":
                if (procurarProduto.confirmarExclusao()) {
                    dao.delete(procurarProduto.getProduto());

                    atualizarLista();
                }

                break;

            case "editarProduto":
                Produto produto = procurarProduto.editarSalvarProduto();
                procurarProduto.setComboBox(daoGrupo.getAll());
                if (produto != null) {
                    try {
                        dao.update(produto);
                    } catch (SistemaException ex) {
                         JOptionPane.showMessageDialog(null,
                                ex.getMessage(), "Erro", JOptionPane.OK_OPTION);
                    }

                }
        }
    }
}