package listener;

import dao.ClienteDao;
import util.LogEvents;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.AniversarioJIF;

public class AniversarioListener implements ActionListener {
    private LogEvents logEvents = new LogEvents();
    private ClienteDao dao = new ClienteDao();
    private AniversarioJIF buscaAniver;

    public AniversarioListener(AniversarioJIF buscaAniversario){
        this.buscaAniver = buscaAniversario;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "procurar":
                
            buscaAniver.
                    setListaAniversariantes(
                            dao.pesquisaAniversario(buscaAniver.getAniversario()));
            break;
            
	    case "copiarPesquisaAniversario":
		if(!buscaAniver.getAniversario().isEmpty()){
		}
		break;
		
	    case "cancelar":
		buscaAniver.setVisible(false);
		buscaAniver.limparCampos();
		break;
        }
    }
}
