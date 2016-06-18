/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;
import view.ProcurarClienteJIF;

/**
 *
 * @author juanvmr
 */
public class ProcurarClienteDocumentListener implements javax.swing.event.DocumentListener{

    private ProcurarClienteJIF procurarCliente;
    
    public ProcurarClienteDocumentListener(ProcurarClienteJIF procurarCliente){
        this.procurarCliente = procurarCliente;
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
            case "campoNome":
                procurarCliente.ProcurarNomeCliente();
                break;
                
            case "campoCPF":
                procurarCliente.ProcurarCPFCliente();
                break;
                
            default:
                break;
        }
    }   
}
