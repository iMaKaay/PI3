package pidakopac;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;

public class TelaExportar extends javax.swing.JFrame {

    private TelaPrincipal pai;
    private int idSelecionada;
    private DBcon banco;
    private String[] lista;

    public void setBanco(DBcon _banco) {
        banco = _banco;
    }

    public void setPai(TelaPrincipal _pai) {
        pai = _pai;
    }

    public TelaExportar() {
        initComponents();
    }

    public void carregaLista(DBcon _banco) throws SQLException {

        //Carrega a lista de estados cadastradas para exibição 
        this.banco = _banco;
        listaEstado listaTmp = new listaEstado();
        listaTmp.constroiLista(this.banco);
        lista = listaTmp.listaEstado();
        comboListaEstado.setEnabled(true);
        botaoExportar.setEnabled(true);

        if (lista.length == 0) {
            comboListaEstado.setEnabled(false);
            botaoExportar.setEnabled(false);
        }
        try {
            comboListaEstado.setModel(new javax.swing.DefaultComboBoxModel<>(listaTmp.listaEstado()));
            comboListaEstado.setSelectedIndex(0);
        } catch (NullPointerException n) {
            comboListaEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Erro no carregamento"}));
            comboListaEstado.setEnabled(false);
            botaoExportar.setEnabled(false);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboListaEstado = new javax.swing.JComboBox<>();
        botaoExportar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        botaoExportarTeste = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Selecione um Estado:");

        comboListaEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carregando ..." }));
        comboListaEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboListaEstadoActionPerformed(evt);
            }
        });

        botaoExportar.setText("Exportar");
        botaoExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExportarActionPerformed(evt);
            }
        });

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        botaoExportarTeste.setText("ExportarTeste");
        botaoExportarTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExportarTesteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoExportarTeste))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboListaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botaoExportar)))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboListaEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoExportar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoExportarTeste))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.setVisible(false);
        pai.setVisible(true);
        pai.enable();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void comboListaEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboListaEstadoActionPerformed
        //Realiza atualização das informaçoes 
        String estadoSelecionado = comboListaEstado.getItemAt(comboListaEstado.getSelectedIndex());
        try {
            idSelecionada = Integer.parseInt(banco.retornaCelula("select id_estado from estado where nome_estado ='" + estadoSelecionado + "'"));
        } catch (SQLException | NumberFormatException ex) {
            Logger.getLogger(TelaExportar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboListaEstadoActionPerformed

    private void botaoExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExportarActionPerformed
        config config = new config();
        try {
            config.carregar();
        } catch (IOException ex) {
            Logger.getLogger(TelaExportar.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (idSelecionada != 0) {
            try {
                Json json = new Json();
                json.exportar(idSelecionada, banco);
            } catch (IOException ex) {
                Logger.getLogger(TelaExportar.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            showMessageDialog(null, "Selecione uma empresa antes de prosseguir");
        }
    }//GEN-LAST:event_botaoExportarActionPerformed

    private void botaoExportarTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExportarTesteActionPerformed
        try {
            Json json = new Json();
            json.exportar(banco);
        } catch (IOException ex) {
            Logger.getLogger(TelaExportar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoExportarTesteActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaExportar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaExportar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaExportar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExportar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaExportar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoExportar;
    private javax.swing.JButton botaoExportarTeste;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JComboBox<String> comboListaEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
