package br.unesc.topicos.grc.listener;

import br.unesc.topicos.grc.bean.Produto;
import br.unesc.topicos.grc.dao.GrupoProdutoDao;
import br.unesc.topicos.grc.dao.ProdutoDao;
import br.unesc.topicos.grc.exceptions.SistemaException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.grc.view.ProcurarProdutoJIF;
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
        
        procurarProduto.camposEnables(false);
        procurarProduto.limparCampos(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "procurarProduto":
                atualizarLista();
                procurarProduto.pesquisarActions();
                break;
            
            case "deletarProduto":
                if (procurarProduto.confirmarExclusao()) {
                    dao.delete(procurarProduto.getProduto());
                    atualizarLista();
                }
                
                break;
            
            case "editarProduto":
                procurarProduto.camposEnables(true);
                procurarProduto.setComboBox(daoGrupo.getAll());
                
                break;
            case "salvarAlteracoes":
                Produto produto = procurarProduto.salvar();
                
                if (produto != null) {
                    try {
                        dao.update(produto);
                        procurarProduto.limparCampos(false);
                        atualizarLista();
                        
                    } catch (SistemaException ex) {
                        JOptionPane.showMessageDialog(null,
                                ex.getMessage(), "Erro", JOptionPane.OK_OPTION);
                    }
                    
                }
                break;
            
        }
    }
}
