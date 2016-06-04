package listener;

import util.LogEvents;
import bean.Produto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroProdutoJIF;

public class CadastroProdutoListener implements ActionListener {
    private LogEvents logEvents = new LogEvents();

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
                    
                    //if(salvo com sucesso no banco)
                    logEvents.gravarLog("log.txt", "Produto salvo: "
                            + produto.getReferencia());
                    //else
                    //   logEvents.gravarLog("log.txt", "Erro ao salvar Produto: "
                    //        + produto.getReferencia());
                    
                    cadProduto.setVisible(false);
                }

                break;
            case "cancelarProduto":
                cadProduto.setVisible(false);
                break;
        
        }
    }

}
