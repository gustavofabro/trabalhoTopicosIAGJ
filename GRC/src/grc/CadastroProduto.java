
package grc;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;


public class CadastroProduto extends javax.swing.JInternalFrame implements FocusListener{
    private JInternalListeners jInternalListeners = new JInternalListeners(this);
    private MaskFormatter valorFormatter;
    private boolean camposValidos = true;
    
    public CadastroProduto(){
      /*  try {
            valorFormatter = new MaskFormatter("##########");
        } catch (ParseException ex) {}
        valorFormatter.setValidCharacters("123456789.");*/

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
        jLabelValor = new javax.swing.JLabel();
        jLabelTamanho = new javax.swing.JLabel();
        jLabelCor = new javax.swing.JLabel();
        jLabelGrupo = new javax.swing.JLabel();
        jTextFieldReferencia = new javax.swing.JTextField();
        jTextFieldDescricao = new javax.swing.JTextField();
        jTextFieldTamanho = new javax.swing.JTextField();
        jTextFieldCor = new javax.swing.JTextField();
        jButtonCancelarProduto = new javax.swing.JButton();
        jButtonSalvarProduto = new javax.swing.JButton();
        jLabelAviso = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.black));

        jLabel1.setText("CADASTRO DE PRODUTO");

        jLabelReferencia.setText("Referência:");

        jComboBoxGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxGrupo.setSelectedIndex(-1);

        jLabelDescricao.setText("Descrição:");

        jLabelValor.setText("Valor:");

        jLabelTamanho.setText("Tamanho:");

        jLabelCor.setText("Cor:");

        jLabelGrupo.setText("Grupo do produto:");

        jTextFieldReferencia.addFocusListener(this);

        jTextFieldDescricao.addFocusListener(this);

        jTextFieldTamanho.addFocusListener(this);

        jTextFieldCor.addFocusListener(this);

        jButtonCancelarProduto.setText("Cancelar");
        jButtonCancelarProduto.addActionListener(jInternalListeners);
        jButtonCancelarProduto.setActionCommand("cancelarProduto");

        jButtonSalvarProduto.setText("Salvar");
        jButtonSalvarProduto.addActionListener(jInternalListeners);
        jButtonSalvarProduto.setActionCommand("salvarProduto");

        jLabelAviso.setForeground(new java.awt.Color(255, 0, 0));
        jLabelAviso.setText("*Preencha todos os campos ");
        jLabelAviso.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelTamanho)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelReferencia)
                                        .addGap(3, 3, 3)
                                        .addComponent(jTextFieldReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelValor)
                                        .addGap(4, 4, 4)
                                        .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelCor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldCor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelGrupo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelDescricao))))
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAviso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalvarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancelarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
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
                    .addComponent(jLabelValor)
                    .addComponent(jTextFieldReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarProduto)
                    .addComponent(jButtonSalvarProduto)
                    .addComponent(jLabelAviso))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public Produto getDadosProduto(){
        if(validarCampos()){
            Produto produto = new Produto();

            produto.setReferencia(jTextFieldReferencia.getText());
            produto.setValor(Double.parseDouble(jTextFieldValor.getText()));
            produto.setDescricao(jTextFieldDescricao.getText());
            produto.setTamanho(jTextFieldTamanho.getText());
            produto.setCor(jTextFieldCor.getText());
            produto.setGrupo(jComboBoxGrupo.getItemAt(jComboBoxGrupo.getSelectedIndex())); 

            return produto;
        }else
            return null;
    }

    public boolean validarCampos(){
         camposValidos = true;
         
         if(jTextFieldReferencia.getText().equals("")){
             jLabelReferencia.setForeground(Color.red); 
             camposValidos = false;
         }else
             jLabelReferencia.setForeground(Color.black); 

         if(jTextFieldValor.getText().equals("")){
             jLabelValor.setForeground(Color.red); 
             camposValidos = false;             
         }else 
             jLabelValor.setForeground(Color.black); 

         if(jTextFieldDescricao.getText().equals("")){
             jLabelDescricao.setForeground(Color.red); 
             camposValidos = false;
         }else
             jLabelDescricao.setForeground(Color.black);
         
         if(jTextFieldTamanho.getText().equals("")){
             jLabelTamanho.setForeground(Color.red); 
             camposValidos = false;
         }else
             jLabelTamanho.setForeground(Color.black);

         if(jTextFieldCor.getText().equals("")){
             jLabelCor.setForeground(Color.red); 
             camposValidos = false;
         }else
             jLabelCor.setForeground(Color.black);
         
         if(jComboBoxGrupo.getSelectedIndex() == -1){
             jLabelGrupo.setForeground(Color.red);
             camposValidos = false;
         }else
             jLabelGrupo.setForeground(Color.black);

         
         if(!camposValidos){
             jLabelAviso.setVisible(true);
         }else
             jLabelAviso.setVisible(false);
         
         return camposValidos;        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarProduto;
    private javax.swing.JButton jButtonSalvarProduto;
    private javax.swing.JComboBox<String> jComboBoxGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAviso;
    private javax.swing.JLabel jLabelCor;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelGrupo;
    private javax.swing.JLabel jLabelReferencia;
    private javax.swing.JLabel jLabelTamanho;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldCor;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldReferencia;
    private javax.swing.JTextField jTextFieldTamanho;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(!camposValidos)
            validarCampos();
    } 

}
