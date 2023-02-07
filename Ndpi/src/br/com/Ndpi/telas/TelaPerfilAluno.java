package br.com.Ndpi.telas;

import java.awt.Font;
import java.sql.*;
import br.com.Ndpi.dal.ModuloConexao;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;

public class TelaPerfilAluno extends javax.swing.JFrame {

    private Connection conexao = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    TelaRmvAluno rmvaluno = new TelaRmvAluno();
    TelaEditAluno editaluno = new TelaEditAluno();

    ArrayList<JLabel> labels;
    int cont = 0;

    private String txt = null;

    public TelaPerfilAluno() {

        add(rmvaluno);
        add(editaluno);

        editaluno.setBounds(25, 33, 406, 400);
        rmvaluno.setBounds(25, 33, 406, 400);

        initComponents();

        labels = new ArrayList<>();
        conexao = ModuloConexao.conector();

    }

    public void setarCampos(String id, String nome, String datNasc, String email, String curso, String serie) {

        lblId.setText(id);
        lblNome.setText(nome);
        lblDatNasc.setText(datNasc);
        lblEmail.setText(email);
        lblCurso.setText(serie + " " + curso);

        addOficina(lblId.getText());

    }

    // Este método é responsável por inserir as oficinas no painel
    public void addOficina(String id) {

        String sql = "select nome from cursa where id = ? ";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, id);

            rs = pst.executeQuery();

            while (rs.next()) {

                txt = rs.getString("nome");
                addComponent(txt);
                cont++;

            }

        } catch (Exception e) {
        }

        labels.get(cont - 1).setText(txt + ".");

    }

    private void addComponent(String nome) {

        // Instância
        JLabel caixa = new JLabel(nome + ",");

        // Adição do componente ao painel e ao Array
        pnlOfi.add(caixa);
        labels.add(caixa);

        // Configuração da fonte do componente
        caixa.setFont(new Font("Segoe UI Light", 0, 13));
        caixa.setForeground(Color.WHITE);

        // Esta linha abaixo atualiza o painel
        pnlOfi.updateUI();

    }

   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      borderUm = new javax.swing.JLabel();
      borderDois = new javax.swing.JLabel();
      borderTres = new javax.swing.JLabel();
      borderQuatro = new javax.swing.JLabel();
      borderCinco = new javax.swing.JLabel();
      lblProfile = new javax.swing.JLabel();
      lblId = new javax.swing.JLabel();
      lblDatNasc = new javax.swing.JLabel();
      lblNome = new javax.swing.JLabel();
      lblEmail = new javax.swing.JLabel();
      lblCurso = new javax.swing.JLabel();
      jScrollPane1 = new javax.swing.JScrollPane();
      pnlOfi = new javax.swing.JPanel();
      txtNomeOficina = new javax.swing.JTextField();
      jSeparator1 = new javax.swing.JSeparator();
      btnRemove = new javax.swing.JLabel();
      btnEdita = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Perfil");
      setBackground(new java.awt.Color(51, 51, 51));
      setResizable(false);
      setType(java.awt.Window.Type.POPUP);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowActivated(java.awt.event.WindowEvent evt) {
            formWindowActivated(evt);
         }
         public void windowDeactivated(java.awt.event.WindowEvent evt) {
            formWindowDeactivated(evt);
         }
      });
      getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

      borderUm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
      getContentPane().add(borderUm, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 150, 50, 1));

      borderDois.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
      getContentPane().add(borderDois, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 150, 235, 1));

      borderTres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
      getContentPane().add(borderTres, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 190, 304, 1));

      borderQuatro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
      getContentPane().add(borderQuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 230, 304, 1));

      borderCinco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
      getContentPane().add(borderCinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 270, 304, 1));

      lblProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lblProfile.setText("Profile");
      lblProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
      getContentPane().add(lblProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 11, 60, 68));

      lblId.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
      lblId.setForeground(new java.awt.Color(255, 255, 255));
      lblId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lblId.setText("id");
      getContentPane().add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 121, 51, 30));

      lblDatNasc.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      lblDatNasc.setForeground(new java.awt.Color(255, 255, 255));
      lblDatNasc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lblDatNasc.setText("Data de nascimento");
      getContentPane().add(lblDatNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 121, 235, 30));

      lblNome.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      lblNome.setForeground(new java.awt.Color(255, 255, 255));
      lblNome.setText("Nome");
      getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 161, 299, 30));

      lblEmail.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      lblEmail.setForeground(new java.awt.Color(255, 255, 255));
      lblEmail.setText("Email");
      getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 201, 299, 30));

      lblCurso.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      lblCurso.setForeground(new java.awt.Color(255, 255, 255));
      lblCurso.setText("Curso");
      getContentPane().add(lblCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 241, 299, 30));

      jScrollPane1.setBorder(null);

      pnlOfi.setBackground(new java.awt.Color(51, 51, 51));
      pnlOfi.setLayout(new java.awt.GridLayout(0, 1));
      jScrollPane1.setViewportView(pnlOfi);

      getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 325, 304, 130));

      txtNomeOficina.setEditable(false);
      txtNomeOficina.setBackground(new java.awt.Color(51, 51, 51));
      txtNomeOficina.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
      txtNomeOficina.setForeground(new java.awt.Color(153, 153, 153));
      txtNomeOficina.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      txtNomeOficina.setText("Oficinas");
      txtNomeOficina.setBorder(null);
      getContentPane().add(txtNomeOficina, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 80, 30));
      getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 305, 400, 10));

      btnRemove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
      btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnRemoveMouseClicked(evt);
         }
      });
      getContentPane().add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 31, 40, 40));

      btnEdita.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
      btnEdita.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnEditaMouseClicked(evt);
         }
      });
      getContentPane().add(btnEdita, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 31, 40, 40));

      setSize(new java.awt.Dimension(460, 500));
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

   private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
       TelaPrincipal princ = new TelaPrincipal();

       if (!princ.getControl() == true) {
           dispose();

           cont = 0;
           pnlOfi.removeAll();
           pnlOfi.updateUI();

       } else {
           princ.setControl(false);

           cont = 0;
           pnlOfi.removeAll();
           pnlOfi.updateUI();

       }

       labels.clear();

   }//GEN-LAST:event_formWindowDeactivated

   private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked

       // Este método abre um "pop-up" para editar os dados do aluno
       if (editaluno.isVisible()) {
           editaluno.setVisible(false);
           rmvaluno.setVisible(true);
           rmvaluno.pesquisar(lblId.getText());
           rmvaluno.setVisibilidade(false);
           rmvaluno.setId(lblId.getText());

       } else if (!(rmvaluno.isVisible())) {
           rmvaluno.setVisible(true);
           rmvaluno.pesquisar(lblId.getText());
           rmvaluno.setVisibilidade(false);
           rmvaluno.setId(lblId.getText());

       } else {
           rmvaluno.setVisible(false);

       }

   }//GEN-LAST:event_btnRemoveMouseClicked

   private void btnEditaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditaMouseClicked

       // Este método abre um "pop-up" para editar os dados do aluno
       if (rmvaluno.isVisible()) {
           rmvaluno.setVisible(false);
           editaluno.setVisible(true);
           editaluno.pesquisar(lblId.getText());
           editaluno.setVisibilidade(false);
           editaluno.setId(lblId.getText());

       } else if (!(editaluno.isVisible())) {
           editaluno.setVisible(true);
           editaluno.pesquisar(lblId.getText());
           editaluno.setVisibilidade(false);
           editaluno.setId(lblId.getText());

       } else {
           editaluno.setVisible(false);

       }

   }//GEN-LAST:event_btnEditaMouseClicked

   private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       if (editaluno.isVisible() || rmvaluno.isVisible()) {
           rmvaluno.setVisible(false);
           editaluno.setVisible(false);
       }
   }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(TelaPerfilAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPerfilAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPerfilAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPerfilAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPerfilAluno().setVisible(true);
            }
        });
    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel borderCinco;
   private javax.swing.JLabel borderDois;
   private javax.swing.JLabel borderQuatro;
   private javax.swing.JLabel borderTres;
   private javax.swing.JLabel borderUm;
   private javax.swing.JLabel btnEdita;
   private javax.swing.JLabel btnRemove;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JSeparator jSeparator1;
   private javax.swing.JLabel lblCurso;
   private javax.swing.JLabel lblDatNasc;
   private javax.swing.JLabel lblEmail;
   private javax.swing.JLabel lblId;
   private javax.swing.JLabel lblNome;
   private javax.swing.JLabel lblProfile;
   private javax.swing.JPanel pnlOfi;
   private javax.swing.JTextField txtNomeOficina;
   // End of variables declaration//GEN-END:variables
}
