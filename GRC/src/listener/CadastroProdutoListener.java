package listener;

import bean.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroProdutoJIF;

public class CadastroProdutoListener implements ActionListener {

    private CadastroProdutoJIF cadProduto;
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
                    //mandar banco
                    cadProduto.setVisible(false);
                }

                break;
            case "cancelarProduto":
                cadProduto.setVisible(false);
                break;
        
        }
    }

}
