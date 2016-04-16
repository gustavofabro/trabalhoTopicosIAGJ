package grc;

import java.awt.Color;

public class CadastroGrupoProduto extends javax.swing.JInternalFrame {

    private boolean camposValidos = true;
    private JInternalListeners jInternalListeners = new JInternalListeners(this);

    public CadastroGrupoProduto() {
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

        jLabel1.setText("CADASTRAR GRUPO DE PRODUTO");

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
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonSalvarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabelGrupo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(111, 111, 111)
                            .addComponent(jLabel1))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGrupo)
                    .addComponent(jTextFieldGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarGrupo)
                    .addComponent(jButtonSalvarGrupo))
                .addContainerGap(27, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarGrupo;
    private javax.swing.JButton jButtonSalvarGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelGrupo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldGrupo;
    // End of variables declaration//GEN-END:variables
}
