package listener;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ProcurarProdutoJIF;

public class ProcurarProdutoListener implements ActionListener {

    private ProcurarProdutoJIF procurarProduto;
    private Clipboard clipboard;

    public ProcurarProdutoListener(ProcurarProdutoJIF procurarProduto) {
        this.procurarProduto = procurarProduto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "campoReferencia":
                procurarProduto.ProcurarReferencia();
                break;

            case "copiarProcurarProduto":
                if (!procurarProduto.getReferencia().isEmpty()) {
                    copy(procurarProduto.getReferencia());
                }
                break;

            case "cancelarProcurarProduto":
                procurarProduto.setVisible(false);
                procurarProduto.apagarCampos();
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
