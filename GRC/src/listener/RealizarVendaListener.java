package listener;

import util.LogEvents;
import bean.Venda;
import dao.VendaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.RealizarVendaJIF;

public class RealizarVendaListener implements ActionListener{
    private LogEvents logEvents = new LogEvents();
    private VendaDao dao = new VendaDao();
    private Venda venda;
    private RealizarVendaJIF realizarVenda;

    public RealizarVendaListener(RealizarVendaJIF realizarVenda) {
        this.realizarVenda = realizarVenda;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
                   
            case "salvarVenda":
                venda = realizarVenda.getDadoVenda();
                if(venda != null){
                    dao.insert(venda);
                     
                 
                    realizarVenda.setVisible(false); 
                }
                
                break;
            case "cancelarVenda":
                realizarVenda.setVisible(false);
                break;
        }
    }
    
}
