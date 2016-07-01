package br.unesc.topicos.grc.view;

import br.unesc.topicos.grc.bean.Produto;
import br.unesc.topicos.grc.listener.ProcurarProdutoListener;
import java.awt.Color;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ProcurarProdutoJIF extends javax.swing.JInternalFrame {

    private final ProcurarProdutoListener listener = new ProcurarProdutoListener(this);
    private Produto produto;
    private boolean camposValidos;

    public ProcurarProdutoJIF() {
        initComponents();
        getRootPane().setDefaultButton(btnProcurar);
    }

    public boolean confirmarExclusao() {
        int opc = 0;
        if (produto != null) {
            opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar \""
                    + produto.getReferencia() + "-" + produto.getDescricao() + "\""
                    + "?", "Confirmar exclusão", JOptionPane.YES_NO_OPTION);

        }

        return opc == 0;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setComboBox(List<String> lista) {
        jComboBoxGrupo.removeAllItems();

        for (String l : lista) {
            jComboBoxGrupo.addItem(l);
        }

    }

    public void camposEnables(boolean state) {
        btnExcluir.setEnabled(!state);
        btnEditar.setEnabled(!state);
        btnSalvar.setEnabled(state);

        textReferencia.setEditable(state);
        textDescricao.setEditable(state);
        textValor.setEditable(state);
        textTamanho.setEditable(state);
        textCor.setEditable(state);
        jComboBoxGrupo.setEditable(state);
        jComboBoxGrupo.setEnabled(state);
    }

    public void editarProduto() {
        camposEnables(true);
    }

    public void pesquisarActions() {
        btnExcluir.setEnabled(false);
        btnEditar.setEnabled(false);
        btnSalvar.setEnabled(false);
    }

    public Produto salvar() {
        if (!validarCampos()) {
            return null;
        }

        jLabelAviso.setVisible(false);

        Produto produtoUpdate = new Produto();

        produtoUpdate.setId_produto(produto.getId_produto());
        produtoUpdate.setDescricao(textDescricao.getText());
        produtoUpdate.setReferencia(textReferencia.getText());
        produtoUpdate.setValor(Double.parseDouble(textValor.getText()));
        produtoUpdate.setTamanho(textTamanho.getText());
        produtoUpdate.setCor(textCor.getText());
        produtoUpdate.setGrupo((String) jComboBoxGrupo.getSelectedItem());

        return produtoUpdate;
    }

    public String[] getDadosProcura() {
        String selection;

        if (jRadioButtonRefe.isSelected()) {
            selection = "referencia";
        } else if (jRadioButtonNome.isSelected()) {
            selection = "descricao";
        } else {
            selection = "grupo";
        }

        return new String[]{campoProcura.getText(), selection};
    }

    public void setListaProdutos(List<Produto> lista) {
        listaProdutos.setListData(
                new Vector(new Vector(lista)));

        btnEditar.setEnabled(false);
        btnExcluir.setEnabled(false);
    }

    public void limparCampos(boolean clearList) {
        if (clearList) {
            listaProdutos.setListData(new String[0]);
            jRadioButtonRefe.setSelected(true);
            campoProcura.setText("");
        }

        textReferencia.setText("");
        textDescricao.setText("");
        textValor.setText("");
        textTamanho.setText("");
        textCor.setText("");
        jComboBoxGrupo.setSelectedIndex(-1);
    }

    public boolean validarCampos() {
        camposValidos = true;

        if (textReferencia.getText().equals("")) {
            labelReferencia.setForeground(Color.red);
            camposValidos = false;
        } else {
            labelReferencia.setForeground(Color.black);
        }

        if (textValor.getText().equals("")) {
            labelValor.setForeground(Color.red);
            camposValidos = false;
        } else {
            labelValor.setForeground(Color.black);
        }

        if (textDescricao.getText().equals("")) {
            labelDescricao.setForeground(Color.red);
            camposValidos = false;
        } else {
            labelDescricao.setForeground(Color.black);
        }

        if (textTamanho.getText().equals("")) {
            labelTamanho.setForeground(Color.red);
            camposValidos = false;
        } else {
            labelTamanho.setForeground(Color.black);
        }

        if (textCor.getText().equals("")) {
            labelCor.setForeground(Color.red);
            camposValidos = false;
        } else {
            labelCor.setForeground(Color.black);
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

        grupoFiltro = new javax.swing.ButtonGroup();
        campoProcura = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProdutos = new javax.swing.JList();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jRadioButtonRefe = new javax.swing.JRadioButton();
        jRadioButtonNome = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        btnProcurar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        labelReferencia = new javax.swing.JLabel();
        labelDescricao = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        labelTamanho = new javax.swing.JLabel();
        labelCor = new javax.swing.JLabel();
        labelGrupo = new javax.swing.JLabel();
        textReferencia = new javax.swing.JTextField();
        textDescricao = new javax.swing.JTextField();
        textValor = new javax.swing.JTextField();
        textTamanho = new javax.swing.JTextField();
        textCor = new javax.swing.JTextField();
        jComboBoxGrupo = new javax.swing.JComboBox<>();
        jRadioButtonGrupo = new javax.swing.JRadioButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabelAviso = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();

        grupoFiltro.add(jRadioButtonRefe);
        grupoFiltro.add(jRadioButtonNome);
        grupoFiltro.add(jRadioButtonGrupo);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(790, 400));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        listaProdutos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaProdutosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaProdutos);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Procurar Produto");

        jRadioButtonRefe.setSelected(true);
        jRadioButtonRefe.setText("Referência");

        jRadioButtonNome.setText("Nome");

        jLabel2.setText("Filtrar por:");

        btnProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unesc/topicos/grc/layout/account-search.png"))); // NOI18N
        btnProcurar.setMinimumSize(new java.awt.Dimension(48, 48));
        btnProcurar.setActionCommand("procurarProduto");
        btnProcurar.addActionListener(listener);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Produto"));

        labelReferencia.setText("Referência:");

        labelDescricao.setText("Descrição:");

        labelValor.setText("Valor (R$):");

        labelTamanho.setText("Tamanho:");

        labelCor.setText("Cor:");

        labelGrupo.setText("Grupo:");

        textReferencia.setEditable(false);
        textReferencia.setText("                                      ");

        textDescricao.setEditable(false);

        textValor.setEditable(false);

        textTamanho.setEditable(false);

        textCor.setEditable(false);

        jComboBoxGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        jComboBoxGrupo.setEnabled(false);
        jComboBoxGrupo.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDescricao)
                            .addComponent(labelReferencia)
                            .addComponent(labelValor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textValor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDescricao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textReferencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTamanho)
                            .addComponent(labelCor)
                            .addComponent(labelGrupo))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textCor)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 63, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelReferencia)
                    .addComponent(textReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDescricao)
                    .addComponent(textDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValor)
                    .addComponent(textValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTamanho)
                    .addComponent(textTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCor)
                    .addComponent(textCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelGrupo)
                    .addComponent(jComboBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jRadioButtonGrupo.setText("Grupo");

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unesc/topicos/grc/layout/delete-forever.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.setActionCommand("deletarProduto");
        btnExcluir.addActionListener(listener);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unesc/topicos/grc/layout/border-color.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(listener);

        btnEditar.setActionCommand("editarProduto");
        btnEditar.setEnabled(false);

        jLabelAviso.setForeground(new java.awt.Color(255, 0, 0));
        jLabelAviso.setText("Preencha todos os campos!");
        jLabelAviso.setVisible(false);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unesc/topicos/grc/layout/content-save.png"))); // NOI18N
        btnSalvar.setText("Salvar Alterações");
        btnSalvar.addActionListener(listener);
        btnSalvar.setActionCommand("salvarAlteracoes");
        btnSalvar.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(campoProcura, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jRadioButtonRefe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonGrupo))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelAviso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalvar)
                                .addGap(8, 8, 8)))))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSeparator2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonRefe)
                    .addComponent(jRadioButtonNome)
                    .addComponent(jRadioButtonGrupo))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoProcura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir)
                    .addComponent(jLabelAviso)
                    .addComponent(btnSalvar))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        limparCampos(true);
    }//GEN-LAST:event_formComponentHidden

    private void listaProdutosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaProdutosValueChanged
        produto = (Produto) listaProdutos.getSelectedValue();

        if (produto != null) {
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
            textReferencia.setText(produto.getReferencia());
            textDescricao.setText(produto.getDescricao());
            textValor.setText("" + produto.getValor());
            textTamanho.setText(produto.getTamanho());
            textCor.setText(produto.getCor());
            jComboBoxGrupo.removeAllItems();
            jComboBoxGrupo.addItem(produto.getGrupo());
        }
    }//GEN-LAST:event_listaProdutosValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField campoProcura;
    private javax.swing.ButtonGroup grupoFiltro;
    private javax.swing.JComboBox<String> jComboBoxGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAviso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonGrupo;
    private javax.swing.JRadioButton jRadioButtonNome;
    private javax.swing.JRadioButton jRadioButtonRefe;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelCor;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelGrupo;
    private javax.swing.JLabel labelReferencia;
    private javax.swing.JLabel labelTamanho;
    private javax.swing.JLabel labelValor;
    private javax.swing.JList listaProdutos;
    private javax.swing.JTextField textCor;
    private javax.swing.JTextField textDescricao;
    private javax.swing.JTextField textReferencia;
    private javax.swing.JTextField textTamanho;
    private javax.swing.JTextField textValor;
    // End of variables declaration//GEN-END:variables

}
