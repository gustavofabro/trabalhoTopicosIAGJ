
package view;

import util.FormattedTextFields;
import bean.Produto;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;
import listener.CadastroProdutoListener;


public class CadastroProdutoJIF extends javax.swing.JInternalFrame implements FocusListener{
    private CadastroProdutoListener jInternalListeners = new CadastroProdutoListener(this);
    private MaskFormatter valorFormatter;
    private boolean camposValidos = true;

    public CadastroProdutoJIF(){
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
        jTextFieldValor = new FormattedTextFields();
        ;
        jSeparator2 = new javax.swing.JSeparator();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastro de Produto");

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
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelAviso)
                        .addGap(67, 67, 67)
                        .addComponent(jButtonSalvarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelDescricao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldDescricao))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                            .addComponent(jTextFieldCor, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelGrupo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(37, 37, 37)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelReferencia)
                    .addComponent(jLabelValor)
                    .addComponent(jTextFieldReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescricao)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTamanho)
                    .addComponent(jLabelCor)
                    .addComponent(jTextFieldTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGrupo)
                    .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarProduto)
                    .addComponent(jButtonSalvarProduto)
                    .addComponent(jLabelAviso))
                .addGap(5, 5, 5))
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
    private javax.swing.JSeparator jSeparator2;
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
