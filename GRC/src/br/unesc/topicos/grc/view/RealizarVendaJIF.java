package br.unesc.topicos.grc.view;

import br.unesc.topicos.grc.bean.Venda;
import br.unesc.topicos.grc.dao.ProdutoDao;
import br.unesc.topicos.grc.dao.VendaDao;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.text.MaskFormatter;
import br.unesc.topicos.grc.listener.RealizarVendaListener;
import br.unesc.topicos.grc.util.LogEvents;

public class RealizarVendaJIF extends javax.swing.JInternalFrame implements FocusListener {

    private LogEvents logEvents = new LogEvents();
    private VendaDao dao = new VendaDao();
    private static ProdutoDao daoProd = new ProdutoDao();
    private MaskFormatter cpfFormatter;
    private boolean camposValidos = true;
    private RealizarVendaListener jInternalListeners = new RealizarVendaListener(this);

    Date date = new Date();
    DateFormat formattedDate = new SimpleDateFormat("YYYY-MM-dd");

    public RealizarVendaJIF() {
        try {
            cpfFormatter = new MaskFormatter("###.###.###-##"); // o # representa qualquer número
            cpfFormatter.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            logEvents.gravarLog(ex.getMessage());
        }
        initComponents();
    }

  
    public Venda getDadoVenda() {

        if (validarCampos()) {
            Venda venda = new Venda();
            venda.setReferencia(jTextFieldReferencia.getText()); 
            venda.setCpf(jFormattedTextFieldCPF.getText());
            venda.setDate(formattedDate.format(date));

            return venda;
        } else {
            return null;
        }

    }
    public String getReferenciaSelected(String[] referencia){
        return referencia[1];
    }
    
    public boolean validarCampos() {
        camposValidos = true;

        if (jTextFieldReferencia.getText().equals("")) {
            jLabelReferencia.setForeground(Color.red);
            camposValidos = false; 
        } else {
            jLabelReferencia.setForeground(Color.black);
        }
     
        return camposValidos;

    }

    public void limparCampos() {
        jTextFieldReferencia.setText(""); 
        jFormattedTextFieldCPF.setText("");

        jLabelCPF.setForeground(Color.black);
        jLabelReferencia.setForeground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelReferencia = new javax.swing.JLabel();
        jLabelCPF = new javax.swing.JLabel();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField(cpfFormatter);
        jSeparator2 = new javax.swing.JSeparator();
        jButtonSalvarVenda = new javax.swing.JButton();
        jTextFieldReferencia = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Realizar Vendas");

        jLabelReferencia.setText("Referência");

        jLabelCPF.setText("CPF Cliente:");

        jButtonSalvarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unesc/topicos/grc/layout/content-save.png"))); // NOI18N
        jButtonSalvarVenda.setText("Salvar");
        jButtonSalvarVenda.addActionListener(jInternalListeners);
        jButtonSalvarVenda.setActionCommand("salvarVenda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCPF)
                                    .addComponent(jLabelReferencia))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldReferencia)
                                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSalvarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCPF)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jButtonSalvarVenda)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        limparCampos();
    }//GEN-LAST:event_formComponentHidden


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvarVenda;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelReferencia;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldReferencia;
    // End of variables declaration//GEN-END:variables

    @Override
    public void focusGained(FocusEvent e) {
        if (!camposValidos) {
            validarCampos();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
