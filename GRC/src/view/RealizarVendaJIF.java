package view;

import bean.Venda;
import dao.ProdutoDao;
import dao.VendaDao;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.text.MaskFormatter;
import listener.RealizarVendaListener;
import util.LogEvents;

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

        setProdutosComboBox();

    }

    public static void setProdutosComboBox() {
        List<String> lista = daoProd.getAll();
        jComboBoxProdutos.removeAllItems();

        for (String l : lista) {
            jComboBoxProdutos.addItem(l);
        }
        
        jComboBoxProdutos.setSelectedIndex(-1);

    }

    public Venda getDadoVenda() {

        if (validarCampos()) {
            Venda venda = new Venda();
            venda.setReferencia(getReferenciaSelected(
                    ((String) jComboBoxProdutos.getSelectedItem()).split("-")
            )
            );
            venda.setCpf(jFormattedTextFieldCPF.getText());
            //  venda.setReferencia(jTextFieldReferencia.getText());
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

        if (jComboBoxProdutos.getSelectedIndex() == -1) {
            jLabelReferencia.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelReferencia.setForeground(Color.black);
        }
        if (jFormattedTextFieldCPF.getValue() == null) {
            jLabelCPF.setForeground(Color.red);
            camposValidos = false;
        } else {
            jLabelCPF.setForeground(Color.black);
        }

        return camposValidos;

    }

    public void limparCampos() {
        jComboBoxProdutos.setSelectedIndex(-1);
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
        jButtonCancelarVenda = new javax.swing.JButton();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField(cpfFormatter);
        jSeparator2 = new javax.swing.JSeparator();
        jButtonSalvarVenda = new javax.swing.JButton();
        jComboBoxProdutos = new javax.swing.JComboBox<>();
        btnNovoProduto = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Realizar Vendas");

        jLabelReferencia.setText("Produto");

        jLabelCPF.setText("CPF Cliente:");

        jButtonCancelarVenda.setText("Cancelar");
        jButtonCancelarVenda.addActionListener(jInternalListeners);
        jButtonCancelarVenda.setActionCommand("cancelarVenda");

        jButtonSalvarVenda.setText("Salvar");
        jButtonSalvarVenda.addActionListener(jInternalListeners);
        jButtonSalvarVenda.setActionCommand("salvarVenda");

        jComboBoxProdutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        btnNovoProduto.addActionListener(jInternalListeners);
        btnNovoProduto.setText("+");
        btnNovoProduto.setActionCommand("novoProduto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonSalvarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelCPF))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabelReferencia)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 97, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNovoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoProduto))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCPF)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarVenda)
                    .addComponent(jButtonSalvarVenda))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        limparCampos();
    }//GEN-LAST:event_formComponentHidden


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovoProduto;
    private javax.swing.JButton jButtonCancelarVenda;
    private javax.swing.JButton jButtonSalvarVenda;
    private static javax.swing.JComboBox<String> jComboBoxProdutos;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelReferencia;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
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
