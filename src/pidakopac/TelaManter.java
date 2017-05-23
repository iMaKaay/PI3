package pidakopac;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaManter extends javax.swing.JFrame {
    
    private TelaPrincipal principal;
    private String[] lista;
    private DBcon banco;
    private int idSelecionada;
    private String caminhoIndicadores;
    private arvoreEmpreendimento arvore;
    
    public TelaPrincipal getTela(){
        return principal;
    }
    
    public void setPrincipal(TelaPrincipal _tela) {
        this.principal = _tela;
    }
    public void setBanco (DBcon _banco){
        banco = _banco;
    }
    public void carregaLista(DBcon _banco) throws SQLException {
        
        //Carrega a lista de empresas cadastradas para exibição 
        this.banco = _banco;
        listaEmpreendimento listaTmp = new listaEmpreendimento();
        listaTmp.constroiLista(this.banco);
        lista = listaTmp.listaEmpreendimento();
        comboListaEmpreendimento.setEnabled(true);
        botaoExcluir.setEnabled(true);

        if (lista.length == 0) {
            comboListaEmpreendimento.setEnabled(false);
            botaoExcluir.setEnabled(false);
        }
        try {
            comboListaEmpreendimento.setModel(new javax.swing.DefaultComboBoxModel<>(listaTmp.listaEmpreendimento()));
            comboListaEmpreendimento.setSelectedIndex(0);
        } catch (NullPointerException n) {
            comboListaEmpreendimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Erro no carregamento"}));
            comboListaEmpreendimento.setEnabled(false);
            botaoExcluir.setEnabled(false);
        }

    }
    public TelaManter() {
        config config = new config();     
        try {
            config.carregar();//Checa o diretorio onde os dados devem ser salvos
            caminhoIndicadores = config.getCaminhoIndicadores();//JSON com os dados colculados
        } catch (IOException ex) {
            Logger.getLogger(TelaManter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botaoExcluir = new javax.swing.JButton();
        comboListaEmpreendimento = new javax.swing.JComboBox<>();
        botaoCadastrar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("dakoPAC");

        jLabel1.setText("Nome:");

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        comboListaEmpreendimento.setEditable(true);
        comboListaEmpreendimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carregando ..." }));
        comboListaEmpreendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboListaEmpreendimentoActionPerformed(evt);
            }
        });

        botaoCadastrar.setText("Cadastrar Empreendimento");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboListaEmpreendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botaoExcluir)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoCadastrar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoExcluir)
                    .addComponent(comboListaEmpreendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrar)
                    .addComponent(botaoVoltar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        try {
            banco.exec("delete empreendimento where id_empreendimento ='" + idSelecionada + "'");
            banco.exec("commit");
            carregaLista(banco);//atualiza lista de empresas exibida
            idSelecionada = 0;//reseta id da empresa selecionada
        } catch (SQLException ex) {
            Logger.getLogger(TelaManter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void comboListaEmpreendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboListaEmpreendimentoActionPerformed
        //Realiza atualização das informaçoes 
        String empreendimentoSelecionado = comboListaEmpreendimento.getItemAt(comboListaEmpreendimento.getSelectedIndex());
        try {
            idSelecionada = Integer.parseInt(banco.retornaCelula("select id_empreendimento from empreendimento where nome_empreendimento ='" + empreendimentoSelecionado + "'"));
        } catch (SQLException | NumberFormatException ex) {
            Logger.getLogger(TelaManter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboListaEmpreendimentoActionPerformed

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        TelaCadastro TelaCadastro = new TelaCadastro();
        TelaCadastro.setBanco(banco);
        TelaCadastro.setVisible(true);
        TelaCadastro.setTelaManter(this);
        this.disable();
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.setVisible(false);
        principal.setVisible(true);
        principal.enable();
    }//GEN-LAST:event_botaoVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaManter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaManter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaManter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaManter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaManter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JComboBox<String> comboListaEmpreendimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
