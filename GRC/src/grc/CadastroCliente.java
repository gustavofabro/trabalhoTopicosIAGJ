
package grc;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

public class CadastroCliente extends javax.swing.JInternalFrame implements FocusListener{
    private JInternalListeners jInternalListeners = new JInternalListeners(this);
    private String sexo = "";
    private boolean camposValidos = true;
    
    private MaskFormatter cpfFormatter;
    private MaskFormatter dataFormatter;
    private MaskFormatter numFormatter;
    private MaskFormatter cepFormatter; 
    
    public CadastroCliente(){
        
        try {
            cpfFormatter = new MaskFormatter("###.###.###-##"); // o # representa qualquer número
            cpfFormatter.setPlaceholderCharacter('_');
            dataFormatter = new MaskFormatter("##/##/####");
            dataFormatter.setPlaceholderCharacter('_');
            numFormatter = new MaskFormatter("#########");
            cepFormatter = new MaskFormatter("#####-###");
            cepFormatter.setPlaceholderCharacter('_');
            
        } catch (ParseException ex) {}
        
        
        initComponents();
        
        jTextFieldBairro.addFocusListener(this);
        jTextFieldCidade.addFocusListener(this);
        jTextFieldEstado.addFocusListener(this);
        jTextFieldNome.addFocusListener(this);
        jTextFieldPais.addFocusListener(this);
        jTextFieldRua.addFocusListener(this);
        jTextFieldSobrenome.addFocusListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabelNome = new javax.swing.JLabel();
        jLabelSobrenome = new javax.swing.JLabel();
        jLabelCPF = new javax.swing.JLabel();
        jLabelNasc = new javax.swing.JLabel();
        jLabelSexo = new javax.swing.JLabel();
        jLabelEndereco = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelRua = new javax.swing.JLabel();
        jLabelBairro = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelPais = new javax.swing.JLabel();
        jLabelCep = new javax.swing.JLabel();
        salvarCliente = new javax.swing.JButton();
        cancelarCliente = new javax.swing.JButton();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldSobrenome = new javax.swing.JTextField();
        jFormattedTextFieldNasc = new javax.swing.JFormattedTextField(dataFormatter);
        jTextFieldRua = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jTextFieldCidade = new javax.swing.JTextField();
        jTextFieldEstado = new javax.swing.JTextField();
        jTextFieldPais = new javax.swing.JTextField();
        radioButtonFeminino = new javax.swing.JRadioButton();
        radioButtonMasculino = new javax.swing.JRadioButton();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField(cpfFormatter);
        jFormattedTextFieldCEP = new javax.swing.JFormattedTextField(cepFormatter);
        jLabelAviso = new javax.swing.JLabel();
        jTextFieldNum = new javax.swing.JTextField();

        jPasswordField1.setText("jPasswordField1");

        jPasswordField2.setText("jPasswordField2");

        setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(80, 80, 80), new java.awt.Color(1, 1, 1)));

        jLabel15.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel15.setText("Cadastro Cliente");

        jLabelNome.setText("Nome:");

        jLabelSobrenome.setText("Sobrenome:");

        jLabelCPF.setText("CPF:");

        jLabelNasc.setText("Data Nascimento:");

        jLabelSexo.setText("Sexo:");

        jLabelEndereco.setText("Endereço:");

        jLabelRua.setText("Rua:");

        jLabelBairro.setText("Bairro:");

        jLabelCidade.setText("Cidade:");

        jLabelEstado.setText("Estado:");

        jLabelNumero.setText("Nº:");

        jLabelPais.setText("Pais:");

        jLabelCep.setText("CEP:");

        salvarCliente.setText("Salvar");
        salvarCliente.addActionListener(jInternalListeners);
        salvarCliente.setActionCommand("salvarCliente");

        cancelarCliente.setText("Cancelar");
        cancelarCliente.addActionListener(jInternalListeners);
        cancelarCliente.setActionCommand("cancelarCliente");

        jTextFieldNome.addFocusListener(this);

        jTextFieldSobrenome.addFocusListener(this);

        jFormattedTextFieldNasc.addFocusListener(this);

        jTextFieldRua.addFocusListener(this);

        jTextFieldBairro.addFocusListener(this);

        jTextFieldCidade.addFocusListener(this);

        jTextFieldEstado.addFocusListener(this);

        jTextFieldPais.addFocusListener(this);

        radioButtonFeminino.setText("Feminimo");
        radioButtonFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonFemininoActionPerformed(evt);
            }
        });

        radioButtonMasculino.setText("Masculino");
        radioButtonMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonMasculinoActionPerformed(evt);
            }
        });

        jFormattedTextFieldCPF.addFocusListener(this);

        jFormattedTextFieldCEP.addFocusListener(this);

        jLabelAviso.setForeground(new java.awt.Color(255, 0, 0));
        jLabelAviso.setText("*Preencha todos os campos");
        jLabelAviso.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator4)
                        .addGap(156, 156, 156))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEstado)
                                    .addComponent(jLabelPais))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldEstado)
                                .addGap(204, 204, 204))
                            .addComponent(jLabelEndereco)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelSexo)
                                .addGap(61, 61, 61)
                                .addComponent(radioButtonFeminino)
                                .addGap(44, 44, 44)
                                .addComponent(radioButtonMasculino))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNasc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextFieldNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBairro)
                                    .addComponent(jLabelRua))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelNumero)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldNum))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelSobrenome)
                                        .addComponent(jLabelNome)
                                        .addComponent(jLabelCPF))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldNome)
                                        .addComponent(jTextFieldSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jFormattedTextFieldCPF))
                                    .addGap(59, 59, 59)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(jTextFieldPais, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelCep))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabelAviso)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(salvarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cancelarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel15)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(14, 14, 14)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSobrenome)
                    .addComponent(jTextFieldSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCPF)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNasc)
                    .addComponent(jFormattedTextFieldNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSexo)
                    .addComponent(radioButtonFeminino)
                    .addComponent(radioButtonMasculino))
                .addGap(18, 18, 18)
                .addComponent(jLabelEndereco)
                .addGap(23, 23, 23)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRua))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBairro)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumero)
                    .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCidade)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstado)
                    .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPais)
                    .addComponent(jLabelCep)
                    .addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarCliente)
                    .addComponent(salvarCliente)
                    .addComponent(jLabelAviso))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Cliente getDadosCliente(){
         
        if(validarCampos()){
            Cliente cliente = new Cliente();

            cliente.setNome(jTextFieldNome.getText());
            cliente.setSobreNome(jTextFieldSobrenome.getText());
            cliente.setCpf(jFormattedTextFieldCPF.getText());
            cliente.setDataNascimento(jFormattedTextFieldNasc.getText());
            cliente.setSexo(sexo);
            cliente.setRua(jTextFieldRua.getText());
            cliente.setBairro(jTextFieldBairro.getText());
            cliente.setNumCasa(jTextFieldNum.getText());
            cliente.setCidade(jTextFieldCidade.getText());
            cliente.setEstado(jTextFieldEstado.getText());
            cliente.setPais(jTextFieldPais.getText());
            cliente.setCep(jFormattedTextFieldCEP.getText());

            return cliente;
        }else
            return null;
    }
    
    public boolean validarCampos(){ 
        camposValidos = true;
  
        if( jTextFieldNome.getText().equals("") ){
            jLabelNome.setForeground(Color.red); 
            camposValidos = false;
        }else
            jLabelNome.setForeground(Color.black); 
        
        if(jTextFieldSobrenome.getText().equals("")){
            jLabelSobrenome.setForeground(Color.red);
            camposValidos = false;
        }else 
            jLabelSobrenome.setForeground(Color.black);
        
        if(jFormattedTextFieldCPF.getValue()==null){
            jLabelCPF.setForeground(Color.red); 
            camposValidos = false;
        }else {
            jLabelCPF.setForeground(Color.black);
        }

        if(jFormattedTextFieldNasc.getValue()==null){
            jLabelNasc.setForeground(Color.red);
            camposValidos = false;
        }else
            jLabelNasc.setForeground(Color.black);

        if(!radioButtonFeminino.isSelected() 
                && !radioButtonMasculino.isSelected()){
            jLabelSexo.setForeground(Color.red);
            camposValidos = false;
        }else
            jLabelSexo.setForeground(Color.black);

        if(jTextFieldRua.getText().equals("")){
            jLabelRua.setForeground(Color.red);
            camposValidos = false;
        }else
            jLabelRua.setForeground(Color.black);
        
        if(jTextFieldBairro.getText().equals("")){
            jLabelBairro.setForeground(Color.red);
            camposValidos = false; 
        }else
            jLabelBairro.setForeground(Color.black);
        
        
        if(jTextFieldNum.getText().equals("")){
            jLabelNumero.setForeground(Color.red);
            camposValidos = false;
        }else
            jLabelNumero.setForeground(Color.black);
        
        if(jTextFieldCidade.getText().equals("")){
            jLabelCidade.setForeground(Color.red);
            camposValidos = false;
        }else
            jLabelCidade.setForeground(Color.black);
        
        if(jTextFieldEstado.getText().equals("")){
            jLabelEstado.setForeground(Color.red);
            camposValidos = false;
        }else
            jLabelEstado.setForeground(Color.black);
      
        if(jTextFieldPais.getText().equals("")){
            jLabelPais.setForeground(Color.red);
            camposValidos = false;
        }else
            jLabelPais.setForeground(Color.black);
        
        if(jFormattedTextFieldCEP.getValue()==null){
            jLabelCep.setForeground(Color.red);
            camposValidos = false;
        }else
            jLabelCep.setForeground(Color.black);
        
        if(!camposValidos){
             jLabelAviso.setVisible(true);
        }else
             jLabelAviso.setVisible(false);
        
        return camposValidos;
    }
    
      
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void radioButtonFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonFemininoActionPerformed
        radioButtonMasculino.setSelected(false);
        sexo = "Feminino";
        
    }//GEN-LAST:event_radioButtonFemininoActionPerformed

    private void radioButtonMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonMasculinoActionPerformed
        radioButtonFeminino.setSelected(false);
        sexo = "Masculino";
    }//GEN-LAST:event_radioButtonMasculinoActionPerformed

    @Override
    public void focusGained(FocusEvent e) {
        if (!camposValidos) 
            validarCampos();
    }
    @Override
    public void focusLost(FocusEvent e) {}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarCliente;
    private javax.swing.JFormattedTextField jFormattedTextFieldCEP;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldNasc;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabelAviso;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelCep;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelNasc;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelPais;
    private javax.swing.JLabel jLabelRua;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelSobrenome;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNum;
    private javax.swing.JTextField jTextFieldPais;
    private javax.swing.JTextField jTextFieldRua;
    private javax.swing.JTextField jTextFieldSobrenome;
    private javax.swing.JRadioButton radioButtonFeminino;
    private javax.swing.JRadioButton radioButtonMasculino;
    private javax.swing.JButton salvarCliente;
    // End of variables declaration//GEN-END:variables
}
