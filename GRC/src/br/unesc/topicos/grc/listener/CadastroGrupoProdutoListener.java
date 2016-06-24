package br.unesc.topicos.grc.listener;

import br.unesc.topicos.grc.bean.GrupoProduto;
import br.unesc.topicos.grc.dao.GrupoProdutoDao;
import br.unesc.topicos.grc.util.LogEvents;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.grc.view.CadastroGrupoProdutoJIF;

public class CadastroGrupoProdutoListener implements ActionListener {
    private CadastroGrupoProdutoJIF cadGrupoProd;
    private GrupoProdutoDao dao = new GrupoProdutoDao();
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
                    grupoProduto.setIdGrupoProduto(dao.getId()); 
                    dao.insert(grupoProduto); 
                 //   logEvents.gravarLog("Salvo Grupo de Produtos: " 
                 //           + grupoProduto.getNome());
                 
                    cadGrupoProd.setVisible(false);
                }
                break;
            case "cancelarNGrupo":
                cadGrupoProd.setVisible(false);
                cadGrupoProd.limparCampos();
        }
    }

}
