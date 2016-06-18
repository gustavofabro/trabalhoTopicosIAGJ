/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;
import view.DataCompraJIF;

/**
 *
 * @author juanvmr
 */
public class DataCompraDocumentListener implements javax.swing.event.DocumentListener{

    private DataCompraJIF dataCompra;
    
    public DataCompraDocumentListener(DataCompraJIF dataCompra){
        this.dataCompra = dataCompra;
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        switch (e.getDocument().getProperty(Document.TitleProperty).toString()){
            case "campoData":
                dataCompra.procurarDataCompra();
                break;
                
            default:
                break;
        }
    }
    
}
