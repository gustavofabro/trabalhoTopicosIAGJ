package br.unesc.topicos.grc.view;

import br.unesc.topicos.grc.bean.Cliente;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;
import br.unesc.topicos.grc.listener.ProcurarClienteListener;
import br.unesc.topicos.grc.util.LogEvents;
import java.awt.Color;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ProcurarClienteJIF extends javax.swing.JInternalFrame {

    private LogEvents logEvents = new LogEvents();
    private boolean camposValidos;
    private MaskFormatter cpfFormatter;
    private MaskFormatter dataFormatter;
    private MaskFormatter cepFormatter;
    private ProcurarClienteListener listener;

    private Cliente cliente;

    public ProcurarClienteJIF() {
        listener = new ProcurarClienteListener(this);

        try {
            cpfFormatter = new MaskFormatter("###.###.###-##"); // o # representa qualquer número
            cpfFormatter.setPlaceholderCharacter('_');
            dataFormatter = new MaskFormatter("##/##/####");
            dataFormatter.setPlaceholderCharacter('_');
            cepFormatter = new MaskFormatter("#####-###");
            cepFormatter.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            logEvents.gravarLog(ex.getMessage());
        }

        initComponents();
    }

    public boolean confirmarExclusao() {
        int opc = 0;
        if (cliente != null) {
            opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar \""
                    + cliente.getNome() + " - " + cliente.getCpf() + "\""
                    + "?", "Confirmar exclusão", JOptionPane.YES_NO_OPTION);

        }

        return opc == 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void camposEnables(boolean state) {
        jTextFieldNome.setEditable(state);
        jTextFieldSobrenome.setEditable(state);
        radioButtonF.setEnabled(state);
        radioButtonM.setEnabled(state);
        jFormattedTextFieldNascimento.setEditable(state);
        jTextFieldEmail.setEditable(state);
        jTextFieldRua.setEditable(state);
        jTextFieldBairro.setEditable(state);
        jTextFieldCidade.setEditable(state);
        jFormattedTextFieldCEP.setEditable(state);;
        jComboBoxEstado.setEditable(state);
        jTextFieldNum.setEditable(state);
        jTextFieldPais.setEditable(state);
        jTextFieldTel.setEditable(state);
    }

    public Cliente salvar() {
        if (!validarCampos()) {
            return null;
        }

        jLabelAviso.setVisible(false);

        Cliente clienteUpdate = new Cliente();

        clienteUpdate.setId_cliente(cliente.getId_cliente());
        clienteUpdate.setNome(jTextFieldNome.getText());
        clienteUpdate.setSobreNome(jTextFieldSobrenome.getText());
        clienteUpdate.setCpf(jFormattedTextFieldCpf.getText());
        clienteUpdate.setSexo(radioButtonM.isSelected() ? "M" : "F");
        clienteUpdate.setNascimento(jFormattedTextFieldNascimento.getText());
        clienteUpdate.setEmail(jTextFieldEmail.getText());
        clienteUpdate.setRua(jTextFieldRua.getText());
        clienteUpdate.setBairro(jTextFieldBairro.getText());
        clienteUpdate.setCidade(jTextFieldCidade.getText());
        clienteUpdate.setCep(jFormattedTextFieldCEP.getText());
        clienteUpdate.setEstado((String) jComboBoxEstado.getSelectedItem());
        clienteUpdate.setNumCasa(jTextFieldNum.getText());
        clienteUpdate.setPais(jTextFieldPais.getText());
        clienteUpdate.setTelefone(jTextFieldTel.getText());

        return clienteUpdate;
    }

    public String[] getDadosProcura() {
        return new String[]{campoNome.getText(),
            campoCPF.isEditValid()
            ? campoCPF.getText() : ""};
    }

    public void editarCliente() {
        camposEnables(true);
    }

    public void disableButtons() {
        limparCampos(true, false);

        btnExcluir.setEnabled(false);
        btnEditar.setEnabled(false);
        btnSalvar.setEnabled(false);
    }

    public void editarActions() {
        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnSalvar.setEnabled(true);

    }

    public void setListaProdutos(List<Cliente> lista) {
        listaClientes.setListData(
                new Vector(new Vector(lista)));
    }

    public void limparCampos(boolean clearList, boolean clearPesq) {
        if (clearList) {
            listaClientes.setListData(new String[0]);
        }

        if (clearPesq) {
            campoNome.setText("");
            campoCPF.setValue(null);
        }

        jTextFieldNome.setText("");
        jTextFieldSobrenome.setText("");
        jFormattedTextFieldCpf.setValue(null);
        radioButtonF.setSelected(false);
        radioButtonM.setSelected(false);
        jFormattedTextFieldNascimento.setValue(null);
        jTextFieldEmail.setText("");
        jTextFieldRua.setText("");
        jTextFieldBairro.setText("");
        jTextFieldCidade.setText("");
        jFormattedTextFieldCEP.setValue(null);;
        jComboBoxEstado.setSelectedIndex(-1); 
        jTextFieldNum.setText("");
        jTextFieldPais.setText("");
        jTextFieldTel.setText("");
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

        if (!jFormattedTextFieldCpf.isEditValid()) {
            jLabelCPF.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelCPF.setForeground(Color.black);
        }

        if (!jFormattedTextFieldNascimento.isEditValid()) {
            jLabelNascimento.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelNascimento.setForeground(Color.black);
        }

        if (jTextFieldTel.getText().equals("")) {
            jLabelTel.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelTel.setForeground(Color.black);
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

        if (jComboBoxEstado.getSelectedIndex() == -1) {
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

        if (!jFormattedTextFieldCEP.isEditValid()) {
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
        jLabel18 = new javax.swing.JLabel();
        buttonGroupSexo = new javax.swing.ButtonGroup();
        labelNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        labelCPF = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaClientes = new javax.swing.JList();
        campoCPF = new javax.swing.JFormattedTextField(cpfFormatter);
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanelDados = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelSobrenome = new javax.swing.JLabel();
        jLabelCPF = new javax.swing.JLabel();
        jLabelSexo = new javax.swing.JLabel();
        jLabelBairro = new javax.swing.JLabel();
        jLabelRua = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelPais = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldSobrenome = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jTextFieldRua = new javax.swing.JTextField();
        jTextFieldPais = new javax.swing.JTextField();
        jLabelNascimento = new javax.swing.JLabel();
        jLabelCep = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelTel = new javax.swing.JLabel();
        jTextFieldNum = new javax.swing.JTextField();
        jTextFieldTel = new javax.swing.JTextField();
        jFormattedTextFieldNascimento = new javax.swing.JFormattedTextField(dataFormatter);
        jFormattedTextFieldCpf = new javax.swing.JFormattedTextField(cpfFormatter);
        jFormattedTextFieldCEP = new javax.swing.JFormattedTextField(cepFormatter);
        jLabelCidade = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        radioButtonM = new javax.swing.JRadioButton();
        radioButtonF = new javax.swing.JRadioButton();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        btnProcurar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabelAviso = new javax.swing.JLabel();

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

        jLabel18.setText("jLabel18");

        buttonGroupSexo.add(radioButtonF);
        buttonGroupSexo.add(radioButtonM);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        labelNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelNome.setText("Nome:");

        labelCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labelCPF.setText("CPF:");

        listaClientes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaClientesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaClientes);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Procurar Cliente");

        jPanelDados.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Cliente"));

        jLabelNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelNome.setText("Nome:");

        jLabelSobrenome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelSobrenome.setText("Sobrenome:");

        jLabelCPF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelCPF.setText("CPF:");

        jLabelSexo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelSexo.setText("Sexo:");

        jLabelBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelBairro.setText("Bairro:");

        jLabelRua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelRua.setText("Rua:");

        jLabelEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelEmail.setText("E-mail");

        jLabelPais.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelPais.setText("Pais:");

        jLabelEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelEstado.setText("Estado:");

        jTextFieldNome.setEditable(false);

        jTextFieldSobrenome.setEditable(false);

        jTextFieldEmail.setEditable(false);

        jTextFieldBairro.setEditable(false);

        jTextFieldRua.setEditable(false);

        jTextFieldPais.setEditable(false);

        jLabelNascimento.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabelNascimento.setText("Nascimento:");

        jLabelCep.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelCep.setText("CEP:");

        jLabelNumero.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabelNumero.setText("Nº");

        jLabelTel.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabelTel.setText("Telefone");

        jTextFieldNum.setEditable(false);

        jTextFieldTel.setEditable(false);

        jFormattedTextFieldNascimento.setEditable(false);

        jFormattedTextFieldCpf.setEditable(false);

        jFormattedTextFieldCEP.setEditable(false);
        jFormattedTextFieldCEP.setText("                                                                   ");

        jLabelCidade.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabelCidade.setText("Cidade:");

        jTextFieldCidade.setEditable(false);

        radioButtonM.setText("M");
        radioButtonM.setEnabled(false);

        radioButtonF.setText("F");
        radioButtonF.setEnabled(false);

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[]
            { "AC", "AL", "AP", "AM", "BA", "CE",
                "DF",
                "ES",
                "GO",
                "MA",
                "MT",
                "MS",
                "MG",
                "PA",
                "PB",
                "PR",
                "PE",
                "PI",
                "RJ",
                "RN",
                "RS",
                "RO",
                "RR",
                "SC",
                "SP",
                "SE",
                "TO"}));

    javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
    jPanelDados.setLayout(jPanelDadosLayout);
    jPanelDadosLayout.setHorizontalGroup(
        jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelDadosLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelDadosLayout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jLabel24)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28)
                    .addGap(98, 98, 98))
                .addGroup(jPanelDadosLayout.createSequentialGroup()
                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelDadosLayout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addComponent(jLabel20)
                                    .addGap(177, 177, 177)
                                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                                            .addGap(158, 158, 158)
                                            .addComponent(jLabel25))
                                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                                            .addGap(116, 116, 116)
                                            .addComponent(jLabel26))))
                                .addGroup(jPanelDadosLayout.createSequentialGroup()
                                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelEmail)
                                        .addComponent(jLabelRua)
                                        .addComponent(jLabelBairro)
                                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelNascimento)
                                                .addComponent(jLabelCidade))
                                            .addGap(7, 7, 7)
                                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                                .addComponent(jTextFieldRua)
                                                .addComponent(jTextFieldBairro)
                                                .addComponent(jTextFieldCidade)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanelDadosLayout.createSequentialGroup()
                                                    .addComponent(jLabelCep)
                                                    .addGap(57, 57, 57))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDadosLayout.createSequentialGroup()
                                                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelTel, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelPais, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelNumero, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelEstado, javax.swing.GroupLayout.Alignment.LEADING))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextFieldTel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldPais)
                                                .addComponent(jTextFieldNum)
                                                .addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel23)
                                        .addComponent(jLabel22))))
                            .addGap(484, 484, 484)
                            .addComponent(jLabel27))
                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDadosLayout.createSequentialGroup()
                                    .addComponent(jLabelNome)
                                    .addGap(49, 49, 49)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDadosLayout.createSequentialGroup()
                                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelSobrenome)
                                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                                            .addComponent(jLabelCPF)
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel19)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel17))
                                        .addComponent(jLabelSexo))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(radioButtonM)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(radioButtonF))
                                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldSobrenome, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                            .addComponent(jFormattedTextFieldNascimento)
                                            .addComponent(jFormattedTextFieldCpf)))))
                            .addGap(197, 197, 197)
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelDadosLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );
    jPanelDadosLayout.setVerticalGroup(
        jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelDadosLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelDadosLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelSobrenome)
                .addComponent(jLabel16)
                .addComponent(jTextFieldSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelCPF)
                .addComponent(jLabel17)
                .addComponent(jLabel19)
                .addComponent(jFormattedTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel25))
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioButtonM)
                    .addComponent(radioButtonF)
                    .addComponent(jLabelSexo)))
            .addGap(10, 10, 10)
            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelNascimento)
                .addComponent(jFormattedTextFieldNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(5, 5, 5)
            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel21)
                .addComponent(jLabel26))
            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelDadosLayout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(jLabel23)
                        .addComponent(jLabel27)))
                .addGroup(jPanelDadosLayout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelEmail)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelRua)
                        .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelBairro))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelCidade)
                .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelDadosLayout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(jLabelCep)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelEstado)
                        .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(7, 7, 7)
                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelNumero))
                    .addGap(4, 4, 4)
                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPais))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelTel)))
                .addComponent(jFormattedTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel24)
                .addComponent(jLabel28)))
    );

    btnProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unesc/topicos/grc/layout/account-search.png"))); // NOI18N
    btnProcurar.setActionCommand("procurarCliente");
    btnProcurar.addActionListener(listener);

    btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unesc/topicos/grc/layout/border-color.png"))); // NOI18N
    btnEditar.setText("Editar");
    btnEditar.setActionCommand("editarCliente");
    btnEditar.addActionListener(listener);
    btnEditar.setEnabled(false);

    btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unesc/topicos/grc/layout/delete-forever.png"))); // NOI18N
    btnExcluir.setText("Excluir");
    btnExcluir.setEnabled(false);
    btnExcluir.setActionCommand("deletarCliente");
    btnExcluir.addActionListener(listener);

    btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unesc/topicos/grc/layout/content-save.png"))); // NOI18N
    btnSalvar.setText("Salvar Alterações");
    btnSalvar.setEnabled(false);
    btnSalvar.setActionCommand("salvarAlteracoes");
    btnSalvar.addActionListener(listener);

    jLabelAviso.setText("Preencha todos os campos!");
    jLabelAviso.setVisible(false);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(154, 154, 154)
                    .addComponent(btnEditar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnExcluir)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelAviso)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalvar))
                        .addComponent(jPanelDados, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelCPF)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnProcurar))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2)
                        .addComponent(jSeparator1))))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnProcurar)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelNome))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelCPF))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(298, 298, 298)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jPanelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelAviso))
            .addGap(16, 16, 16))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        limparCampos(true, true);
    }//GEN-LAST:event_formComponentHidden

    private void listaClientesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaClientesValueChanged
        cliente = (Cliente) listaClientes.getSelectedValue();

        if (cliente != null) {
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            btnSalvar.setEnabled(false);

            jTextFieldNome.setText(cliente.getNome());
            jTextFieldSobrenome.setText(cliente.getSobreNome());
            jFormattedTextFieldCpf.setText(cliente.getCpf());

            if (cliente.getSexo().equals("M")) {
                radioButtonM.setSelected(true);
            } else {
                radioButtonF.setSelected(true);
            }

            jFormattedTextFieldNascimento.setText(
                    convertDate(cliente.getDataNascimento().split("-")));
            jTextFieldEmail.setText(cliente.getEmail());
            jTextFieldRua.setText(cliente.getRua());
            jTextFieldCidade.setText(cliente.getCidade());
            jTextFieldBairro.setText(cliente.getBairro());
            jFormattedTextFieldCEP.setText(cliente.getCep());
            jComboBoxEstado.setSelectedItem((String)cliente.getEstado());
            jTextFieldNum.setText(cliente.getNumCasa());
            jTextFieldPais.setText(cliente.getPais());
            jTextFieldTel.setText((cliente.getTelefone()));
        }
    }//GEN-LAST:event_listaClientesValueChanged

    public String convertDate(String[] data) {
        return data[2] + "/" + data[1] + "/" + data[0];
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroupSexo;
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JTextField campoNome;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JFormattedTextField jFormattedTextFieldCEP;
    private javax.swing.JFormattedTextField jFormattedTextFieldCpf;
    private javax.swing.JFormattedTextField jFormattedTextFieldNascimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabelAviso;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelCep;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelNascimento;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelPais;
    private javax.swing.JLabel jLabelRua;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelSobrenome;
    private javax.swing.JLabel jLabelTel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNum;
    private javax.swing.JTextField jTextFieldPais;
    private javax.swing.JTextField jTextFieldRua;
    private javax.swing.JTextField jTextFieldSobrenome;
    private javax.swing.JTextField jTextFieldTel;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelNome;
    private javax.swing.JList listaClientes;
    private javax.swing.JRadioButton radioButtonF;
    private javax.swing.JRadioButton radioButtonM;
    // End of variables declaration//GEN-END:variables
}
