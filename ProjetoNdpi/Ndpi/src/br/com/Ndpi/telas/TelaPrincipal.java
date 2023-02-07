package br.com.Ndpi.telas;

import java.sql.*;
import br.com.Ndpi.dal.ModuloConexao;
import java.awt.Color;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

public class TelaPrincipal extends javax.swing.JFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Date data = null;
    String datForm = null;

    TelaPerfilAluno perfil = new TelaPerfilAluno();

    private boolean control = false;

    public TelaPrincipal() {
        initComponents();

        this.getContentPane().setBackground(Color.BLACK);

        conexao = ModuloConexao.conector();

        editaTabela();
        showAlunos();

    }

    private void editaTabela() {

        tblPrincipal.getParent().setBackground(new Color(051, 051, 051));
        tblPrincipal.setShowGrid(true);
        tblPrincipal.setShowVerticalLines(false);
        tblPrincipal.setGridColor(new Color(204, 204, 204));

    }

    private void pesquisarAlunos() {
        String sql = "select id,nome from tbalunos where nome like ?";

        try {

            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPesquisa.getText() + "%");

            rs = pst.executeQuery();

            tblPrincipal.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void showAlunos() {
        String sql = "select id,nome from tbalunos order by nome";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            tblPrincipal.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
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

    public boolean getControl() {

        return control;

    }

    public void setControl(boolean con) {

        control = con;

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnPrincipal = new javax.swing.JButton();
        btnConfig = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPrincipal = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(100, 100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 80));
        jPanel1.setLayout(null);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(817, 20, 3, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Ndpi/img/close.png"))); // NOI18N
        jLabel1.setBorder(null);
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(680, 30, 20, 20);

        txtPesquisa.setBackground(new java.awt.Color(239, 239, 239));
        txtPesquisa.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        txtPesquisa.setBorder(null);
        txtPesquisa.setCaretColor(new java.awt.Color(153, 153, 153));
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });
        jPanel1.add(txtPesquisa);
        txtPesquisa.setBounds(200, 20, 470, 40);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 78, 979, 3);

        btnPrincipal.setBackground(new java.awt.Color(51, 153, 255));
        btnPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Ndpi/img/group.png"))); // NOI18N
        btnPrincipal.setBorder(null);
        btnPrincipal.setContentAreaFilled(false);
        btnPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrincipal.setFocusPainted(false);
        jPanel1.add(btnPrincipal);
        btnPrincipal.setBounds(751, 20, 60, 40);

        btnConfig.setBackground(new java.awt.Color(51, 153, 255));
        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Ndpi/img/settings.png"))); // NOI18N
        btnConfig.setBorder(null);
        btnConfig.setContentAreaFilled(false);
        btnConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfig.setFocusPainted(false);
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfig);
        btnConfig.setBounds(830, 10, 50, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Ndpi/img/search-bar.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(170, 10, 560, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 910, 80);

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80)));

        tblPrincipal.setBackground(new java.awt.Color(51, 51, 51));
        tblPrincipal.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        tblPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        tblPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPrincipal.setAutoscrolls(false);
        tblPrincipal.setEditingRow(0);
        tblPrincipal.setRowHeight(60);
        tblPrincipal.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tblPrincipal.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPrincipal.setTableHeader(null);
        tblPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblPrincipalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tblPrincipalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPrincipalMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblPrincipal);
        if (tblPrincipal.getColumnModel().getColumnCount() > 0) {
            tblPrincipal.getColumnModel().getColumn(0).setResizable(false);
            tblPrincipal.getColumnModel().getColumn(1).setResizable(false);
            tblPrincipal.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(117, 79, 666, 532);

        setSize(new java.awt.Dimension(916, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed

       // Este método abre a tela de configurações
       TelaConfig config = new TelaConfig();

       config.setVisible(true);
       dispose();

   }//GEN-LAST:event_btnConfigActionPerformed

   private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased

       if (txtPesquisa.getText().length() < 1) {
           showAlunos();

       } else {
           pesquisarAlunos();

       }

   }//GEN-LAST:event_txtPesquisaKeyReleased

   private void tblPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrincipalMouseEntered
       control = true;
   }//GEN-LAST:event_tblPrincipalMouseEntered

   private void tblPrincipalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrincipalMouseExited
       control = false;
   }//GEN-LAST:event_tblPrincipalMouseExited

   private void tblPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrincipalMousePressed

       control = true;
       perfil.setVisible(true);
       int i = tblPrincipal.getSelectedRow();

       prePerfil(tblPrincipal.getModel().getValueAt(i, 0).toString());


   }//GEN-LAST:event_tblPrincipalMousePressed

   private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

       txtPesquisa.setText("");
       showAlunos();

   }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfig;
    private javax.swing.JButton btnPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblPrincipal;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
