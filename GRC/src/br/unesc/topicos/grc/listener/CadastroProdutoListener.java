package br.unesc.topicos.grc.listener;

import br.unesc.topicos.grc.bean.Produto;
import br.unesc.topicos.grc.dao.ProdutoDao;
import br.unesc.topicos.grc.exceptions.SistemaException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.grc.view.CadastroProdutoJIF;
import javax.swing.JOptionPane;

public class CadastroProdutoListener implements ActionListener {

    private CadastroProdutoJIF cadProduto;
    private ProdutoDao dao = new ProdutoDao();
    private Produto produto;

    public CadastroProdutoListener(CadastroProdutoJIF cadProduto) {
        this.cadProduto = cadProduto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "salvarProduto":
                produto = cadProduto.getDadosProduto();

                if (produto != null) {
                    try {
                        dao.insert(produto);
                        cadProduto.setVisible(false);

                    } catch (SistemaException ex) {
                        JOptionPane.showMessageDialog(null,
                                ex.getMessage(), "Erro", JOptionPane.OK_OPTION);
                    }
                }

                break;
        }
    }

}
