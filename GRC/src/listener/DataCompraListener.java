package listener;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.DataCompraJIF;

public class DataCompraListener implements ActionListener {

    private DataCompraJIF dataCompra;
    private Clipboard clipboard;

    public DataCompraListener(DataCompraJIF dataCompra) {
        this.dataCompra = dataCompra;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "campoData":
                dataCompra.procurarDataCompra();
                break;

            case "copiarDataCompra":
                if (!dataCompra.getCompra().isEmpty()) {
                    copy(dataCompra.getCompra());
                }
                break;

            case "cancelarDataCompra":
                dataCompra.setVisible(false);
                dataCompra.apagarCampos();
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
