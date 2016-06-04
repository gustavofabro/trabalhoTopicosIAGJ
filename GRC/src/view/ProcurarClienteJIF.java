/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Cliente;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;
import listener.ProcurarClienteListener;
import util.LogEvents;

/**
 *
 * @author gustavo
 * @mod juanvmr
 * @implementation juanvmr
 */
public class ProcurarClienteJIF extends javax.swing.JInternalFrame {
    private LogEvents logEvents = new LogEvents();

    private MaskFormatter cpfFormat;
    private ProcurarClienteListener listener;
    
    private Cliente cliente;
    private String[] listNome;
    private String[] listCPF;
    private String[] listAux;
    private String auxNome;
    private String auxCPF;
    private String auxCampo;
    
    public void apagarCampos(){
	campoCPF.setText("");
	campoNome.setText("");
	listaNomes.removeAll();
    }
    
    public String getNome(){
	String selection = "Vazio";
	if(listaNomes.getMaxSelectionIndex() > -1){
	    selection = listaNomes.getSelectedValue().toString();
	}
	
	return selection;
    }
        
    public void ProcurarNomeCliente(){
        auxNome = cliente.getNome();
	auxCampo = campoNome.getText();
	
	if(auxNome.contains(auxCampo)){
	    listNome[listNome.length] = auxNome;
	}
	
	addLista();
    }
    
    public void ProcurarCPFCliente(){
	auxCPF = cliente.getCpf();
	auxCampo = campoCPF.getText();
	
	if(auxCPF.contains(auxCampo)){
	    listCPF[listCPF.length] = auxNome;
	}
	
	addLista();
    }
    
    private void addLista(){
	listaNomes.removeAll();
	
	int maxSize = (listCPF.length > listNome.length)
		    ? listCPF.length
		    : listNome.length;
	
	if(listCPF.length == 0){
	    listAux = listNome;
	}
	else if(listNome.length == 0){
	    listAux = listCPF;
	}
	else{
	    for (int i = 0; i < maxSize; i++) {
		if(listAux[i] == null || listNome[i] == null){
		    break;
		}
		
		if(listAux[i].equals(listNome[i])){
		    listAux[i] = listNome[i];
		}
	    }
	}
	
	listaNomes.setListData(listAux);
    }

    /**
     * Creates new form ProcurarCliente
     */
    public ProcurarClienteJIF() {
	listener = new ProcurarClienteListener(this);
	
	try {
	    cpfFormat = new MaskFormatter("###.###.###-##");
	    cpfFormat.setPlaceholderCharacter('_');
	}
	catch(ParseException ex) {
	    logEvents.gravarLog("log.txt", ex.getMessage());
	}
	
        initComponents();
	
	campoNome.setActionCommand("campoNome");
	campoCPF.setActionCommand("campoCPF");
	copiarProcurarCliente.setActionCommand("copiarProcurarCliente");
	cancelarProcurarCliente.setActionCommand("cancelarProcurarCliente");
	campoNome.addActionListener(listener);
	campoCPF.addActionListener(listener);
	copiarProcurarCliente.addActionListener(listener);
	cancelarProcurarCliente.addActionListener(listener);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        jTextField4 = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        labelCPF = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaNomes = new javax.swing.JList();
        campoCPF = new javax.swing.JFormattedTextField(cpfFormat);
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        copiarProcurarCliente = new javax.swing.JButton();
        cancelarProcurarCliente = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField4.setText("jTextField4");

        labelNome.setText("Nome :");

        labelCPF.setText("CPF :");

        jScrollPane2.setViewportView(listaNomes);

        jLabel1.setText("PROCURAR CLIENTE");

        copiarProcurarCliente.setText("Copiar");

        cancelarProcurarCliente.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(labelCPF)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(labelNome)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cancelarProcurarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(copiarProcurarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCPF)
                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(copiarProcurarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelarProcurarCliente)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JTextField campoNome;
    private javax.swing.JButton cancelarProcurarCliente;
    private javax.swing.JButton copiarProcurarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelNome;
    private javax.swing.JList listaNomes;
    // End of variables declaration//GEN-END:variables
}
