package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.AniversarioJIF;
import view.AreaTransferencia;

public class AniversarioListener implements ActionListener {

    private AniversarioJIF aniversario;
    private AreaTransferencia clipboard;

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
		    clipboard.copy(aniversario.getAniversario());
		}
		break;
		
	    case "cancelarPesquisaAniversario":
		aniversario.setVisible(false);
		aniversario.apagarCampos();
		break;
        }
    }
}
