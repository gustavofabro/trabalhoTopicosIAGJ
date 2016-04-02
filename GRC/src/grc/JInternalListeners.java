/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gustavo
 */
public class JInternalListeners implements ActionListener {

    //ATENÇÃO: para os eventos dos JInterFrames que vocês estão criando
    //funcionarem nesta classe vocês devem instanciar um 
    //objeto dela e passa-lo ao addActionListener dos botões dessa forma:
    //button.addActionListener(objetoDoJInternalListeners);
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("asd");
    }

}
