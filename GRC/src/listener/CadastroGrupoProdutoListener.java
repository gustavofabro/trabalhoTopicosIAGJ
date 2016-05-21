package listener;

import bean.GrupoProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroGrupoProdutoJIF;

public class CadastroGrupoProdutoListener implements ActionListener {

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
                    cadGrupoProd.setVisible(false);
                }
                break;
            case "cancelarNGrupo":
                cadGrupoProd.setVisible(false);

        }
    }

}
