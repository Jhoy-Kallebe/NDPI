package br.com.Ndpi.telas;

import java.sql.*;
import br.com.Ndpi.dal.ModuloConexao;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

public class TelaAlunos extends javax.swing.JFrame {

    static Connection conexao = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;

    TelaAddAluno addaluno = new TelaAddAluno();
    TelaRmvAluno rmvaluno = new TelaRmvAluno();
    TelaEditAluno editaluno = new TelaEditAluno();

    TelaPerfilAluno perfil = new TelaPerfilAluno();

    private boolean adiciona = false;
    private boolean edita = false;
    private boolean remove = false;

    Date data = null;
    String datForm = null;

    private boolean control = false;

    public TelaAlunos() {

        add(addaluno);
        add(rmvaluno);
        add(editaluno);

        addaluno.setBounds(247, 123, 406, 400);
        rmvaluno.setBounds(247, 123, 406, 400);
        editaluno.setBounds(247, 123, 406, 400);

        initComponents();

        this.getContentPane().setBackground(Color.BLACK);

        conexao = ModuloConexao.conector();

        editaTabela();
        showAlunos();

    }

    public static void showAlunos() {
        String sql = "select id,nome from tbalunos order by nome";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            tblAlunos.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void editaTabela() {

        tblAlunos.getParent().setBackground(new Color(051, 051, 051));
        tblAlunos.setShowGrid(true);
        tblAlunos.setShowVerticalLines(false);
        tblAlunos.setGridColor(new Color(204, 204, 204));

    }

    public boolean getControl() {

        return control;

    }

    public void setControl(boolean con) {

        control = con;

    }

    public void formata(Date nasc) {
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        datForm = formata.format(data);

    }

    public void prePerfil(String id) {
        String sql = "select * from tbalunos where id= ?";

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, id);

            rs = pst.executeQuery();

            if (rs.next()) {
                data = rs.getDate("nascimento");
                formata(data);
                String id2 = rs.getString("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String curso = rs.getString("curso");
                String serie = rs.getString("serie");

                perfil.setarCampos(id2, nome, datForm, email, curso, serie);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAdiciona = new javax.swing.JButton();
        btnEdita = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAlunos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(100, 100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 80));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        btnAdiciona.setBackground(new java.awt.Color(51, 153, 255));
        btnAdiciona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Ndpi/img/person-add.png"))); // NOI18N
        btnAdiciona.setBorder(null);
        btnAdiciona.setContentAreaFilled(false);
        btnAdiciona.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdiciona.setFocusPainted(false);
        btnAdiciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaActionPerformed(evt);
            }
        });

        btnEdita.setBackground(new java.awt.Color(51, 153, 255));
        btnEdita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Ndpi/img/edit-person.png"))); // NOI18N
        btnEdita.setBorder(null);
        btnEdita.setContentAreaFilled(false);
        btnEdita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdita.setFocusPainted(false);
        btnEdita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditaActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(51, 153, 255));
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Ndpi/img/person-remove.png"))); // NOI18N
        btnRemove.setBorder(null);
        btnRemove.setContentAreaFilled(false);
        btnRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove.setFocusPainted(false);
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(51, 153, 255));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Ndpi/img/back.png"))); // NOI18N
        btnSair.setBorder(null);
        btnSair.setContentAreaFilled(false);
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSair.setFocusPainted(false);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(btnAdiciona)
                .addGap(116, 116, 116)
                .addComponent(btnRemove)
                .addGap(116, 116, 116)
                .addComponent(btnEdita)
                .addGap(259, 259, 259))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdiciona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdita, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 910, 80);

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80)));

        tblAlunos.setBackground(new java.awt.Color(51, 51, 51));
        tblAlunos.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        tblAlunos.setForeground(new java.awt.Color(255, 255, 255));
        tblAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAlunos.setAutoscrolls(false);
        tblAlunos.setEditingRow(0);
        tblAlunos.setRowHeight(60);
        tblAlunos.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tblAlunos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAlunos.setTableHeader(null);
        tblAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblAlunosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tblAlunosMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblAlunosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblAlunos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(117, 79, 666, 531);

        setSize(new java.awt.Dimension(916, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   private void btnAdicionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaActionPerformed

       // Este método abre um "pop-up" para adicionar alunos
       if (rmvaluno.isVisible() || editaluno.isVisible()) {
           rmvaluno.setVisible(false);
           editaluno.setVisible(false);
           addaluno.setVisible(true);

       } else if (adiciona == false) {
           addaluno.setVisible(true);
           adiciona = true;

       } else {
           addaluno.setVisible(false);
           adiciona = false;

       }

   }//GEN-LAST:event_btnAdicionaActionPerformed

   private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

       // Este método abre um "pop-up" para remover alunos
       if (addaluno.isVisible() || editaluno.isVisible()) {
           addaluno.setVisible(false);
           editaluno.setVisible(false);
           rmvaluno.setVisible(true);

       } else if (remove == false) {
           rmvaluno.setVisible(true);
           remove = true;

       } else {
           rmvaluno.setVisible(false);
           remove = false;

       }

   }//GEN-LAST:event_btnRemoveActionPerformed

   private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

       // Este método volta para a tela de configurações
       TelaConfig config = new TelaConfig();

       config.setVisible(true);
       dispose();

   }//GEN-LAST:event_btnSairActionPerformed

   private void btnEditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditaActionPerformed

       // Este método abre um "pop-up" para editar os dados do aluno
       if (addaluno.isVisible() || rmvaluno.isVisible()) {
           addaluno.setVisible(false);
           rmvaluno.setVisible(false);
           editaluno.setVisible(true);

       } else if (edita == false) {
           editaluno.setVisible(true);
           edita = true;

       } else {
           editaluno.setVisible(false);
           edita = false;
       }

   }//GEN-LAST:event_btnEditaActionPerformed

   private void tblAlunosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlunosMousePressed

       if (adiciona == true || edita == true || remove == true) {
           addaluno.setVisible(false);
           rmvaluno.setVisible(false);
           editaluno.setVisible(false);

       }

       control = true;
       perfil.setVisible(true);

       int i = tblAlunos.getSelectedRow();

       prePerfil(tblAlunos.getModel().getValueAt(i, 0).toString());

   }//GEN-LAST:event_tblAlunosMousePressed

   private void tblAlunosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlunosMouseEntered

       control = true;

   }//GEN-LAST:event_tblAlunosMouseEntered

   private void tblAlunosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlunosMouseExited

       control = false;

   }//GEN-LAST:event_tblAlunosMouseExited

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(TelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAlunos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdiciona;
    private javax.swing.JButton btnEdita;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JTable tblAlunos;
    // End of variables declaration//GEN-END:variables
}
