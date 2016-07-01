package br.unesc.topicos.grc.listener;

import br.unesc.topicos.grc.bean.GrupoProduto;
import br.unesc.topicos.grc.dao.GrupoProdutoDao;
import br.unesc.topicos.grc.exceptions.SistemaException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.grc.view.CadastroGrupoProdutoJIF;
import javax.swing.JOptionPane;

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
                    try {
                        dao.insert(grupoProduto);
                    } catch (SistemaException ex) {
                        JOptionPane.showMessageDialog(null,
                                ex.getMessage(), "Erro", JOptionPane.OK_OPTION);
                    }
                    
                    cadGrupoProd.setVisible(false);
                }
                break;

        }
    }

}
