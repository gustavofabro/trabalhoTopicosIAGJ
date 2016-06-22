package view;

import bean.GrupoProduto;
import java.awt.Color;
import listener.CadastroGrupoProdutoListener;

public class CadastroGrupoProdutoJIF extends javax.swing.JInternalFrame {

    private boolean camposValidos = true;
    private CadastroGrupoProdutoListener jInternalListeners = new CadastroGrupoProdutoListener(this);

    public CadastroGrupoProdutoJIF() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelGrupo = new javax.swing.JLabel();
        jTextFieldGrupo = new javax.swing.JTextField();
        jButtonSalvarGrupo = new javax.swing.JButton();
        jButtonCancelarGrupo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cadastrar Grupo de Produtos");

        jLabelGrupo.setText("Novo Grupo:");

        jButtonSalvarGrupo.setText("Salvar");
        jButtonSalvarGrupo.addActionListener(jInternalListeners);
        jButtonSalvarGrupo.setActionCommand("salvarNGrupo");

        jButtonCancelarGrupo.setText("Cancelar");
        jButtonCancelarGrupo.addActionListener(jInternalListeners);
        jButtonCancelarGrupo.setActionCommand("cancelarNGrupo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalvarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelGrupo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGrupo)
                    .addComponent(jTextFieldGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarGrupo)
                    .addComponent(jButtonSalvarGrupo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public GrupoProduto getDadoGrupoProduto() {
        if (validarCampos()) {
            GrupoProduto grupoProduto = new GrupoProduto();
            grupoProduto.setNome(jTextFieldGrupo.getText());

            return grupoProduto;
        }

        return null;
    }

    public boolean validarCampos() {
        camposValidos = true;

        if (jTextFieldGrupo.getText().equals("")) {
            jLabelGrupo.setForeground(Color.red);
            camposValidos = false;

        }
        return camposValidos;
    }
    
    public void limparCampos() {
       jTextFieldGrupo.setText(""); 
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarGrupo;
    private javax.swing.JButton jButtonSalvarGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelGrupo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldGrupo;
    // End of variables declaration//GEN-END:variables
}
