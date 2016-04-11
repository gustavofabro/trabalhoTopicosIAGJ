
package grc;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;


public class CadastroProduto extends javax.swing.JInternalFrame {
    private JInternalListeners jInternalListeners = new JInternalListeners(this);
    private MaskFormatter valorFormatter;
   
    
    public CadastroProduto(){
        try {
            valorFormatter = new MaskFormatter("**********");
        } catch (ParseException ex) {}
        valorFormatter.setValidCharacters("[123456789].");
        
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelReferencia = new javax.swing.JLabel();
        jComboBoxGrupo = new javax.swing.JComboBox<>();
        jLabelDescricao = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelTamanho = new javax.swing.JLabel();
        jLabelCor = new javax.swing.JLabel();
        jLabelGrupo = new javax.swing.JLabel();
        jTextFieldReferencia = new javax.swing.JTextField();
        jTextFieldDescricao = new javax.swing.JTextField();
        jTextFieldTamanho = new javax.swing.JTextField();
        jTextFieldCor = new javax.swing.JTextField();
        jButtonCancelarProduto = new javax.swing.JButton();
        jButtonSalvarProduto = new javax.swing.JButton();
        jFormattedTextFieldValor = new javax.swing.JFormattedTextField(valorFormatter);

        jLabel1.setText("CADASTRO DE PRODUTO");

        jLabelReferencia.setText("Referência:");

        jComboBoxGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGrupoActionPerformed(evt);
            }
        });

        jLabelDescricao.setText("Descrição:");

        jLabel4.setText("Valor:");

        jLabelTamanho.setText("Tamanho:");

        jLabelCor.setText("Cor:");

        jLabelGrupo.setText("Grupo do produto:");

        jButtonCancelarProduto.setText("Cancelar");
        jButtonCancelarProduto.addActionListener(jInternalListeners);
        jButtonCancelarProduto.setActionCommand("CadastroProduto");

        jButtonSalvarProduto.setText("Salvar");
        jButtonSalvarProduto.addActionListener(jInternalListeners);
        jButtonSalvarProduto.setActionCommand("SalvarProduto");

        jFormattedTextFieldValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldValorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(121, 121, 121)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabelDescricao)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextFieldDescricao))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelTamanho)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldTamanho))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelReferencia)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelCor)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldCor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jFormattedTextFieldValor))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButtonSalvarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonCancelarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelGrupo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelReferencia)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescricao)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTamanho)
                    .addComponent(jLabelCor)
                    .addComponent(jTextFieldTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGrupo)
                    .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarProduto)
                    .addComponent(jButtonSalvarProduto))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public Produto getDadosProduto(){
        Produto produto = new Produto();
        
        validarCampos();
        
        produto.setReferencia(jTextFieldReferencia.getText());
        produto.setValor(Double.parseDouble(jFormattedTextFieldValor.getText()));
        produto.setDescricao(jTextFieldDescricao.getText());
        produto.setTamanho(jTextFieldTamanho.getText());
        produto.setCor(jTextFieldCor.getText());
        //produto.setGrupo(jComboBoxGrupo.getItemAt(jComboBoxGrupo.getSelectedIndex())); 
       
        return produto;
    }

     public void validarCampos(){
     
     }
    
    private void jFormattedTextFieldValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldValorActionPerformed

    private void jComboBoxGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxGrupoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarProduto;
    private javax.swing.JButton jButtonSalvarProduto;
    private javax.swing.JComboBox<String> jComboBoxGrupo;
    private javax.swing.JFormattedTextField jFormattedTextFieldValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCor;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelGrupo;
    private javax.swing.JLabel jLabelReferencia;
    private javax.swing.JLabel jLabelTamanho;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldCor;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldReferencia;
    private javax.swing.JTextField jTextFieldTamanho;
    // End of variables declaration//GEN-END:variables
}
