package view;

import util.FormattedTextFields;
import bean.Cliente;
import util.LogEvents;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;
import listener.CadastroClienteListener;

public class CadastroClienteJIF extends javax.swing.JInternalFrame implements FocusListener {

    private LogEvents logEvents = new LogEvents();

    private CadastroClienteListener jInternalListeners = new CadastroClienteListener(this);
    private String sexo = "";
    private boolean camposValidos = true;

    private MaskFormatter cpfFormatter;
    private MaskFormatter dataFormatter;
    private MaskFormatter cepFormatter;

    public CadastroClienteJIF() {

        try {
            cpfFormatter = new MaskFormatter("###.###.###-##"); // o # representa qualquer número
            cpfFormatter.setPlaceholderCharacter('_');
            dataFormatter = new MaskFormatter("##/##/####");
            dataFormatter.setPlaceholderCharacter('_');
            cepFormatter = new MaskFormatter("#####-###");
            cepFormatter.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            logEvents.gravarLog(ex.getMessage() + "\n");
        }

        initComponents();

        jTextFieldBairro.addFocusListener(this);
        jTextFieldNum.addFocusListener(this);
        jTextFieldCidade.addFocusListener(this);
        jTextFieldEstado.addFocusListener(this);
        jTextFieldNome.addFocusListener(this);
        jTextFieldPais.addFocusListener(this);
        jTextFieldRua.addFocusListener(this);
        jTextFieldSobrenome.addFocusListener(this);
        jTextFieldEmail.addFocusListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel15 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabelNome = new javax.swing.JLabel();
        jLabelSobrenome = new javax.swing.JLabel();
        jLabelCPF = new javax.swing.JLabel();
        jLabelNasc = new javax.swing.JLabel();
        jLabelSexo = new javax.swing.JLabel();
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
        jTextFieldNum = new FormattedTextFields();
        jLabelTel = new javax.swing.JLabel();
        jTextFieldTel = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();

        jPasswordField1.setText("jPasswordField1");

        jPasswordField2.setText("jPasswordField2");

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jInternalFrame2.setVisible(true);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Cadastro Cliente");

        jLabelNome.setText("Nome:");

        jLabelSobrenome.setText("Sobrenome:");

        jLabelCPF.setText("CPF:");

        jLabelNasc.setText("Data Nascimento:");

        jLabelSexo.setText("Sexo:");

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

        jLabelTel.setText("Telefone:");

        jLabelEmail.setText("E-mail");

        jTextFieldSobrenome.addFocusListener(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabelAviso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salvarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(cancelarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5)
                        .addGap(5, 5, 5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBairro)
                                    .addComponent(jLabelRua))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(227, 227, 227)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelCep)
                                                .addGap(18, 18, 18)
                                                .addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelNumero)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelCidade)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEstado)
                                    .addComponent(jLabelPais))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPais, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelSobrenome)
                                    .addComponent(jLabelNome)
                                    .addComponent(jLabelCPF))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNome)
                                    .addComponent(jTextFieldSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNasc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextFieldNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelSexo)
                                    .addComponent(jLabelEmail))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radioButtonFeminino)
                                        .addGap(44, 44, 44)
                                        .addComponent(radioButtonMasculino)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSobrenome)
                    .addComponent(jTextFieldSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCPF)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNasc)
                    .addComponent(jFormattedTextFieldNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTel)
                    .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSexo)
                    .addComponent(radioButtonFeminino)
                    .addComponent(radioButtonMasculino))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRua))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBairro)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumero)
                    .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCidade)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstado)
                    .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCep)
                    .addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelarCliente)
                        .addComponent(salvarCliente))
                    .addComponent(jLabelAviso, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Cliente getDadosCliente() {

        if (validarCampos()) {
            Cliente cliente = new Cliente();

            cliente.setNome(jTextFieldNome.getText());
            cliente.setSobreNome(jTextFieldSobrenome.getText());
            cliente.setCpf(jFormattedTextFieldCPF.getText());
            cliente.setDataNascimento(jFormattedTextFieldNasc.getText());
            cliente.setEmail(jTextFieldEmail.getText());
            cliente.setTelefone(jTextFieldTel.getText());
            cliente.setSexo(radioButtonFeminino.isSelected() ? "F" : "M");
            cliente.setRua(jTextFieldRua.getText());
            cliente.setBairro(jTextFieldBairro.getText());
            cliente.setNumCasa(jTextFieldNum.getText());
            cliente.setCidade(jTextFieldCidade.getText());
            cliente.setEstado(jTextFieldEstado.getText());
            cliente.setPais(jTextFieldPais.getText());
            cliente.setCep(jFormattedTextFieldCEP.getText());

            return cliente;
        } else {
            return null;
        }
    }

    public boolean validarCampos() {
        camposValidos = true;

        if (jTextFieldNome.getText().equals("")) {
            jLabelNome.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelNome.setForeground(Color.black);
        }

        if (jTextFieldSobrenome.getText().equals("")) {
            jLabelSobrenome.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelSobrenome.setForeground(Color.black);
        }

        if (jFormattedTextFieldCPF.getValue() == null) {
            jLabelCPF.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelCPF.setForeground(Color.black);
        }

        if (jLabelEmail.getText().equals("")) {
            jLabelEmail.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelEmail.setForeground(Color.black);
        }

        if (jFormattedTextFieldNasc.getValue() == null) {
            jLabelNasc.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelNasc.setForeground(Color.black);
        }

        if (jTextFieldTel.getText().equals("")) {
            jLabelTel.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelTel.setForeground(Color.black);
        }

        if (!radioButtonFeminino.isSelected()
                && !radioButtonMasculino.isSelected()) {
            jLabelSexo.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelSexo.setForeground(Color.black);
        }

        if (jTextFieldRua.getText().equals("")) {
            jLabelRua.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelRua.setForeground(Color.black);
        }

        if (jTextFieldBairro.getText().equals("")) {
            jLabelBairro.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelBairro.setForeground(Color.black);
        }

        if (jTextFieldNum.getText().equals("")) {
            jLabelNumero.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelNumero.setForeground(Color.black);
        }

        if (jTextFieldCidade.getText().equals("")) {
            jLabelCidade.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelCidade.setForeground(Color.black);
        }

        if (jTextFieldEstado.getText().equals("")) {
            jLabelEstado.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelEstado.setForeground(Color.black);
        }

        if (jTextFieldPais.getText().equals("")) {
            jLabelPais.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelPais.setForeground(Color.black);
        }

        if (jFormattedTextFieldCEP.getValue() == null) {
            jLabelCep.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelCep.setForeground(Color.black);
        }

        if (!camposValidos) {
            jLabelAviso.setVisible(true);
        } else {
            jLabelAviso.setVisible(false);
        }

        return camposValidos;
    }


    private void radioButtonFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonFemininoActionPerformed
        radioButtonMasculino.setSelected(false);
        sexo = "Feminino";

    }//GEN-LAST:event_radioButtonFemininoActionPerformed

    private void radioButtonMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonMasculinoActionPerformed
        radioButtonFeminino.setSelected(false);
        sexo = "Masculino";
    }//GEN-LAST:event_radioButtonMasculinoActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        limparCampos();
    }//GEN-LAST:event_formComponentHidden

    public void limparCampos() {
        jTextFieldNome.setText("");
        jTextFieldSobrenome.setText("");
        jFormattedTextFieldCPF.setText("");
        jFormattedTextFieldNasc.setText("");
        jTextFieldEmail.setText("");
        jTextFieldTel.setText("");
        radioButtonFeminino.setSelected(false);
        radioButtonMasculino.setSelected(false);
        jTextFieldRua.setText("");
        jTextFieldBairro.setText("");
        jTextFieldNum.setText("");
        jTextFieldCidade.setText("");
        jTextFieldEstado.setText("");
        jTextFieldPais.setText("");
        jFormattedTextFieldCEP.setText("");

    }

    @Override
    public void focusGained(FocusEvent e) {
        if (!camposValidos) {
            validarCampos();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarCliente;
    private javax.swing.JFormattedTextField jFormattedTextFieldCEP;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldNasc;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabelAviso;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelCep;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelNasc;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelPais;
    private javax.swing.JLabel jLabelRua;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelSobrenome;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNum;
    private javax.swing.JTextField jTextFieldPais;
    private javax.swing.JTextField jTextFieldRua;
    private javax.swing.JTextField jTextFieldSobrenome;
    private javax.swing.JTextField jTextFieldTel;
    private javax.swing.JRadioButton radioButtonFeminino;
    private javax.swing.JRadioButton radioButtonMasculino;
    private javax.swing.JButton salvarCliente;
    // End of variables declaration//GEN-END:variables
}
