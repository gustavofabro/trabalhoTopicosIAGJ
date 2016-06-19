package listener;

import bean.GrupoProduto;
import util.LogEvents;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroGrupoProdutoJIF;

public class CadastroGrupoProdutoListener implements ActionListener {
    private LogEvents logEvents = new LogEvents();

    private CadastroGrupoProdutoJIF cadGrupoProd;
    private GrupoProduto grupoProduto;
    
    public CadastroGrupoProdutoListener(CadastroGrupoProdutoJIF cadGrupoProd) {
        this.cadGrupoProd = cadGrupoProd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "salvarNGrupo":
                grupoProduto = cadGrupoProd.getDadoGrupoProduto();
                if (grupoProduto != null) {
                    //mandar banco
                    
                    //if(salvo com sucesso no banco)
                    logEvents.gravarLog("Salvo Grupo de Produtos: " 
                            + grupoProduto.getNome());
                    //else
                    //  logEvents.gravarLog("log.txt", "Erro ao salvar Grupo de Produtos: " 
                    //        + grupoProduto.getNome());
                    
                    cadGrupoProd.setVisible(false);
                }
                break;
            case "cancelarNGrupo":
                cadGrupoProd.setVisible(false);

        }
    }

}
