package br.unesc.topicos.grc.listener;

import br.unesc.topicos.grc.util.LogEvents;
import br.unesc.topicos.grc.bean.Venda;
import br.unesc.topicos.grc.dao.VendaDao;
import br.unesc.topicos.grc.exceptions.ReferenciaInvalidaException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import br.unesc.topicos.grc.view.RealizarVendaJIF;
import br.unesc.topicos.grc.view.TelaPrincipal;

public class RealizarVendaListener implements ActionListener {

    private LogEvents logEvents = new LogEvents();
    private VendaDao dao = new VendaDao();
    private Venda venda;
    private RealizarVendaJIF realizarVenda;

    public RealizarVendaListener(RealizarVendaJIF realizarVenda) {
        this.realizarVenda = realizarVenda;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "salvarVenda":
                venda = realizarVenda.getDadoVenda();

                if (venda != null) {
                   
                    try{
                        dao.referenciaIsValida(venda.getReferencia());
                            
                        if (dao.cpfIsValido(venda.getCpf())) {
                            venda.setIdVenda(dao.getId());

                            dao.insert(venda);

                            realizarVenda.setVisible(false);
                        } else {
                            int opt = JOptionPane.showConfirmDialog(null,
                                    "Ciente não cadastrado no sistema."
                                  + "Cadastrar novo cliente?",
                                    "CPF inválido", JOptionPane.YES_NO_OPTION);

                            if (opt == 0) {
                                TelaPrincipal.novoCadastro();
                            }
                        }
                    } catch(ReferenciaInvalidaException ex){
                          JOptionPane.showMessageDialog(null,
                                 ex.getMessage(), "", JOptionPane.YES_NO_OPTION);
                    }
                    
                } else {
                    logEvents.gravarLog("Erro ao realizar venda");
                }

                break;

            case "novoProduto":
                TelaPrincipal.novoProduto();
                break;
            case "cancelarVenda":
                realizarVenda.setVisible(false);
                break;
        }
    }

}
