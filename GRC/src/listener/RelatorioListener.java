/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import util.LogEvents;
import view.RelatorioJIF;

/**
 *
 * @author juanvmr
 */
public class RelatorioListener implements ActionListener{
    private LogEvents logevents = new LogEvents();
    private RelatorioJIF relatorio;
    
    public RelatorioListener(RelatorioJIF relatorio){
        this.relatorio = relatorio;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "fecharRelatorio":
                relatorio.setVisible(false);
                relatorio.apagarCampos();
                break;
                
            case "limparRelatorio":
                relatorio.apagarCampos();
                break;
        }
    }
}
