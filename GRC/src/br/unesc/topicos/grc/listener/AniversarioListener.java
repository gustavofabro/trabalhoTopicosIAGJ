package br.unesc.topicos.grc.listener;

import br.unesc.topicos.grc.dao.ClienteDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.unesc.topicos.grc.view.AniversarioJIF;

public class AniversarioListener implements ActionListener {
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
