package br.unesc.topicos.grc.listener;

import br.unesc.topicos.grc.bean.Produto;
import br.unesc.topicos.grc.dao.ProdutoDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.grc.view.CadastroProdutoJIF;

public class CadastroProdutoListener implements ActionListener {
    private CadastroProdutoJIF cadProduto;
    private ProdutoDao dao = new ProdutoDao();
    private Produto produto;
    
    public CadastroProdutoListener(CadastroProdutoJIF cadProduto) {
        this.cadProduto = cadProduto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
             case "salvarProduto":
                produto = cadProduto.getDadosProduto();
                
                if (produto != null) {
                    produto.setId_produto(dao.getId());
                    
                    dao.insert(produto); 
                    cadProduto.setVisible(false);
                }

                break;
            case "cancelarProduto":
                cadProduto.setVisible(false);
                break;
        
        }
    }

}