package pidakopac;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;

public class TelaCadastro extends javax.swing.JFrame {
    
    private String orgao_fiscalizador;
    private String nome_empreendimento;
    private String executores;
    private double total_investido;
    private int id_estado;
    private int id_municipio;
    private int id_digs;
    private int id_estagio;
    private String ano;
    private TelaManter TelaManter;

    public void setTelaManter(TelaManter _telaManter) {
        this.TelaManter = _telaManter;
    }

    public TelaCadastro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        _estado = new javax.swing.JTextField();
        _municipio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        _orgaoFiscalizador = new javax.swing.JTextField();
        _nomeEmpreendimento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        _executores = new javax.swing.JTextField();
        _totalInvestido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        _idDigs = new javax.swing.JTextField();
        _idEstagio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        _ano = new javax.swing.JTextField();
        botaoVoltar = new javax.swing.JButton();
        botaoOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("dakoPAC");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Cadastrar Empreendimento");

        jLabel2.setText("Estado:");

        jLabel3.setText("Municipio:");

        jLabel4.setText("Orgao Fiscalizador");

        jLabel5.setText("Nome Empreendimento");

        jLabel6.setText("Executores");

        jLabel7.setText("Total Investido");

        jLabel8.setText("Conversão Digs");

        jLabel9.setText("Conversão Estágio");

        jLabel10.setText("Ano");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(_idDigs, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(_executores, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(_orgaoFiscalizador, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(_estado)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 3, Short.MAX_VALUE))
                                    .addComponent(_ano, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(14, 14, 14)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(_municipio)
                            .addComponent(jLabel5)
                            .addComponent(_nomeEmpreendimento)
                            .addComponent(_totalInvestido)
                            .addComponent(_idEstagio, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_orgaoFiscalizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_nomeEmpreendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_executores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_totalInvestido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_idDigs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_idEstagio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        botaoOk.setText("Cadastrar");
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel1)
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botaoVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoOk)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoOk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
        TelaManter.getTela().setVisible(true);
        TelaManter.setVisible(true);
        TelaManter.enable();
        try {
            TelaManter.carregaLista();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOkActionPerformed
        int verificado = 0;
        try {
            DBcon bancoC = new DBcon("dako", "123456", "jdbc:oracle:thin:@localhost:1521:XE");
            //Verifica se o nome da empresa já está em uso.
            if (!bancoC.jaExiste("select nome_empreendimento from empreendimento where nome_empreendimento ='" + nome_empreendimento + "'")) {
                verificado++;
            } else {
                showMessageDialog(null, "Já existe um empreendimento cadastrado com o mesmo nome!");
            }
            bancoC.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Verificado se o nome da empresa encontra-se em branco.
        if (_estado.getText().length() > 0) {
            verificado++;
        } else {
            showMessageDialog(null, "Campo \"Estado\" não preenchido!");
        }
        
        //Verificado se o nome do municipio encontra-se em branco.
        if (_municipio.getText().length() > 0) {
            verificado++;
        } else {
            showMessageDialog(null, "Campo \"Município\" não preenchido!");
        }
        
        //Verificado se o orgaoFiscalizador do empreendimento encontra-se em branco.
        if (_orgaoFiscalizador.getText().length() > 0) {
            verificado++;
        } else {
            showMessageDialog(null, "Campo \"Orgão Fiscalizador\" não preenchido!");
        }

        //Verificado se executores do empreendimento encontra-se em branco.
        if (_executores.getText().length() > 0) {
            verificado++;
        } else {
            showMessageDialog(null, "Campo \"Executores\" não preenchido!");
        }

        //Verificado se total investido do empreendimento encontra-se em branco.
        if (_totalInvestido.getText().length() > 0) {
            verificado++;
        } else {
            showMessageDialog(null, "Campo \"Total Investido\" não preenchido!");
        }
        
        //Verificado se Conversao de Digs do empreendimento encontra-se em branco.
        if (_idDigs.getText().length() > 0) {
            verificado++;
        } else {
            showMessageDialog(null, "Campo \"Conversão de Digs\" não preenchido!");
        }
        
        //Verificado se Conversao de Estagio do empreendimento encontra-se em branco.
        if (_idEstagio.getText().length() > 0) {
            verificado++;
        } else {
            showMessageDialog(null, "Campo \"Conversão de Estágio\" não preenchido!");
        }

        try {
            DBcon bancoI = new DBcon("dako", "123456", "jdbc:oracle:thin:@localhost:1521:XE");
            nome_empreendimento = _nomeEmpreendimento.getText();
            id_estado = Integer.parseInt(bancoI.retornaCelula("select id_estado from estado where upper(nome_estado) ='" + _estado.getText().toUpperCase() + "'"));
            if(bancoI.retornaCelula("select id_municipio from municipio where upper(nome_municipio) ='" + _municipio.getText().toUpperCase() + "'") != null)
                id_municipio = Integer.parseInt(bancoI.retornaCelula("select id_municipio from municipio where upper(nome_municipio) ='" + _municipio.getText().toUpperCase() + "'"));
            else
                bancoI.exec("INSERT INTO municipio VALUES(seq_id_municipio.nextval,'" + _municipio.getText().toUpperCase() + "'," + id_estado + ")");
            //Realiza o cadastro caso as 8 validações tenham sido feitas.
            if (verificado == 8) {
                orgao_fiscalizador = _orgaoFiscalizador.getText();
                executores = _executores.getText();
                total_investido = Double.parseDouble(_totalInvestido.getText());
                id_digs = Integer.parseInt(_idDigs.getText());
                id_estagio = Integer.parseInt(_idEstagio.getText());
                ano = _ano.getText();
                Empreendimento novoEmpreendimento = new Empreendimento();
                novoEmpreendimento.cadastro(orgao_fiscalizador, nome_empreendimento, total_investido, executores,id_municipio, id_estado, id_digs, id_estagio, ano);
                bancoI.exec(novoEmpreendimento.getQuery());
                bancoI.exec("commit");
                bancoI.desconectar();
                showMessageDialog(null,"Cadastro realizado!");
                this.setVisible(false);
                TelaManter.setVisible(true);
                TelaManter.carregaLista();
                TelaManter.enable();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoOkActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField _ano;
    private javax.swing.JTextField _estado;
    private javax.swing.JTextField _executores;
    private javax.swing.JTextField _idDigs;
    private javax.swing.JTextField _idEstagio;
    private javax.swing.JTextField _municipio;
    private javax.swing.JTextField _nomeEmpreendimento;
    private javax.swing.JTextField _orgaoFiscalizador;
    private javax.swing.JTextField _totalInvestido;
    private javax.swing.JButton botaoOk;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
