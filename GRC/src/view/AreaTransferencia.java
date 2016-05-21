/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.awt.Toolkit;

/**
 *
 * @author juanvmr
 */
public class AreaTransferencia {
    
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    
    //Métodos para área de transferencia
    //Ainda em teste
    public void copy(String cpy){
	StringSelection selection = new StringSelection(cpy);
	clipboard.setContents(selection, null);
    }
    
    public String paste(){
	StringSelection selection = new StringSelection(null);
	clipboard.getContents(selection);
	
	return (selection.toString());
    }
    
}
