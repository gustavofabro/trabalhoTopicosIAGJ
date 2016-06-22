package listener;

import util.LogEvents;
import bean.Venda;
import dao.VendaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.CadastroClienteJIF;
import view.RealizarVendaJIF;
import view.TelaPrincipal;

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
                    if (dao.cpfIsValido(venda.getCpf())) {
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
                } else {
                    logEvents.gravarLog("Erro ao realizar venda");
                }

                break;
            case "cancelarVenda":
                realizarVenda.setVisible(false);
                break;
        }
    }

}
