package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.RealizarVendaJIF;

public class RealizarVendaListener implements ActionListener{
    private RealizarVendaJIF realizarVenda;

    public RealizarVendaListener(RealizarVendaJIF realizarVenda) {
        this.realizarVenda = realizarVenda;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
                   
            case "salvarVenda":
                if(realizarVenda.getDadoVenda() != null){
                    realizarVenda.setVisible(false); 
                }
                break;
            case "cancelarVenda":
                realizarVenda.setVisible(false);
                break;
        }
    }
    
}
