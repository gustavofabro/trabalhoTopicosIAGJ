package listener;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.AniversarioJIF;

public class AniversarioListener implements ActionListener {

    private AniversarioJIF aniversario;
    private Clipboard clipboard;

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
		    copy(aniversario.getAniversario());
		}
		break;
		
	    case "cancelarPesquisaAniversario":
		aniversario.setVisible(false);
		aniversario.apagarCampos();
		break;
        }
    }

       //Métodos para área de transferencia
    //Ainda em teste
    private void copy(String cpy){
	StringSelection selection = new StringSelection(cpy);
	clipboard.setContents(selection, null);
    }
    
    private String paste(){
	StringSelection selection = new StringSelection(null);
	clipboard.getContents(selection);
	
	return (selection.toString());
    }
}
