package listener;

import util.LogEvents;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.AniversarioJIF;

public class AniversarioListener implements ActionListener {
    private LogEvents logEvents = new LogEvents();
    
    private AniversarioJIF aniversario;

    public AniversarioListener(AniversarioJIF aniversario){
        this.aniversario = aniversario;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
             case "campoAniversario":
		aniversario.procurarAniversario();
		break;
		
	    case "copiarPesquisaAniversario":
		if(!aniversario.getAniversario().isEmpty()){
		}
		break;
		
	    case "cancelarPesquisaAniversario":
		aniversario.setVisible(false);
		aniversario.apagarCampos();
		break;
        }
    }
}
