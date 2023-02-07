package br.com.Ndpi.telas;

import java.sql.*;
import br.com.Ndpi.dal.ModuloConexao;
import java.awt.Color;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaLogin extends javax.swing.JFrame {

    boolean cont = false;

    // variáveis necessárias para relação com o banco de dados  
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaLogin() {
        initComponents();

        this.getContentPane().setBackground(Color.BLACK);

        conexao = ModuloConexao.conector();

    }

    //************************** Esse método serve para fazer o login do admin **************************
    public void logar() {
        // Variável de pesquisa
        String sql = "select * from usuario where nome = ? and senha = ? ";

        // Esse bloco de código faz a pesquisa e verifica se existe o admin no banco de dados 
        try {
            // prepara a pesquisa
            pst = conexao.prepareStatement(sql);

            // substitui as interrogações
            pst.setString(1, txtUsu.getText());
            pst.setString(2, txtSenha.getText());

            // executa a pesquisa
            rs = pst.executeQuery();

            // verifica se existe o item pesquisado
            if (rs.next()) {
                // se sim, abre a tela principal
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
                dispose();

            } else {
                // se não, mostra a mensagem entre aspas
                JOptionPane.showMessageDialog(null, "Usuário não encontrado! ");
                borderUm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
                borderDois.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        borderUm = new javax.swing.JLabel();
        borderDois = new javax.swing.JLabel();
        lblVer = new javax.swing.JLabel();
        txtSenhaVisivel = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        txtUsu = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)));
        jPanel1.setPreferredSize(new java.awt.Dimension(328, 336));
        jPanel1.setLayout(null);

        borderUm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
        jPanel1.add(borderUm);
        borderUm.setBounds(40, 112, 250, 2);

        borderDois.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
        jPanel1.add(borderDois);
        borderDois.setBounds(40, 172, 250, 2);

        lblVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Ndpi/img/eye.png"))); // NOI18N
        lblVer.setBorder(null);
        lblVer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVer.setNextFocusableComponent(txtSenhaVisivel);
        lblVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVerMouseClicked(evt);
            }
        });
        jPanel1.add(lblVer);
        lblVer.setBounds(260, 140, 20, 30);

        txtSenhaVisivel.setBackground(new java.awt.Color(51, 51, 51));
        txtSenhaVisivel.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtSenhaVisivel.setForeground(new java.awt.Color(255, 255, 255));
        txtSenhaVisivel.setText("Senha");
        txtSenhaVisivel.setBorder(null);
        txtSenhaVisivel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSenhaVisivelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSenhaVisivelFocusLost(evt);
            }
        });
        txtSenhaVisivel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaVisivelKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSenhaVisivelKeyReleased(evt);
            }
        });
        jPanel1.add(txtSenhaVisivel);
        txtSenhaVisivel.setBounds(45, 135, 238, 38);

        txtSenha.setBackground(new java.awt.Color(51, 51, 51));
        txtSenha.setForeground(new java.awt.Color(255, 255, 255));
        txtSenha.setBorder(null);
        txtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSenhaFocusLost(evt);
            }
        });
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSenhaKeyReleased(evt);
            }
        });
        jPanel1.add(txtSenha);
        txtSenha.setBounds(45, 135, 238, 38);

        txtUsu.setBackground(new java.awt.Color(51, 51, 51));
        txtUsu.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txtUsu.setForeground(new java.awt.Color(255, 255, 255));
        txtUsu.setText("Nome");
        txtUsu.setBorder(null);
        txtUsu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuFocusLost(evt);
            }
        });
        txtUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsuKeyReleased(evt);
            }
        });
        jPanel1.add(txtUsu);
        txtUsu.setBounds(45, 75, 238, 38);

        btnSubmit.setBackground(new java.awt.Color(102, 102, 102));
        btnSubmit.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Entrar");
        btnSubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(32, 255, 113)));
        btnSubmit.setContentAreaFilled(false);
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.setFocusPainted(false);
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubmit);
        btnSubmit.setBounds(45, 250, 238, 42);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Ndpi/img/profile.png"))); // NOI18N
        jLabel3.setBorder(null);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(140, 0, 48, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(286, 121, 328, 336);

        setSize(new java.awt.Dimension(916, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

       logar();

   }//GEN-LAST:event_btnSubmitActionPerformed

   private void lblVerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerMouseClicked

       if (!txtSenhaVisivel.isVisible()) {
           txtSenhaVisivel.setVisible(true);
           txtSenhaVisivel.setText(txtSenha.getText());
           txtSenha.setVisible(false);
           txtSenhaVisivel.requestFocus();

           cont = true;

       } else if (txtSenhaVisivel.getText().equals("Senha")) {
           txtSenha.setVisible(true);
           txtSenha.setText("");
           txtSenha.requestFocus();

       } else {
           txtSenha.setVisible(true);
           txtSenha.setText(txtSenhaVisivel.getText());
           txtSenhaVisivel.setVisible(false);
           txtSenha.requestFocus();

       }

   }//GEN-LAST:event_lblVerMouseClicked


   private void txtUsuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuFocusGained

       ganhouFoco(txtUsu, borderUm, "Nome");

   }//GEN-LAST:event_txtUsuFocusGained

   private void txtUsuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuFocusLost

       perdeuFoco(txtUsu, borderUm, "Nome");

   }//GEN-LAST:event_txtUsuFocusLost

   private void txtUsuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuKeyPressed

       apertouTecla(txtUsu, "Nome");

   }//GEN-LAST:event_txtUsuKeyPressed

   private void txtUsuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuKeyReleased

       soltouTecla(txtUsu, "Nome", evt);

       if (txtUsu.getText().length() < 1) {
           txtUsu.setText("Nome");
           txtUsu.setForeground(new Color(51, 102, 255));
           txtUsu.setCaretPosition(0);

       }

       if (evt.getKeyChar() == VK_ENTER) {
           txtSenha.requestFocus();

       }

   }//GEN-LAST:event_txtUsuKeyReleased


   private void txtSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusGained

       borderDois.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

       if (txtSenhaVisivel.getText().equals("Senha")) {

           txtSenhaVisivel.setForeground(new Color(51, 102, 255));

       }

   }//GEN-LAST:event_txtSenhaFocusGained

   private void txtSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusLost
       borderDois.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
       txtSenhaVisivel.setForeground(new Color(255, 255, 255));

       String nome = txtSenha.getText().replace(" ", "");

       if (nome.isEmpty()) {
           txtSenhaVisivel.setText("Senha");
           txtSenhaVisivel.setVisible(true);

       }

   }//GEN-LAST:event_txtSenhaFocusLost

   private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed

       if (txtSenhaVisivel.getText().equals("Senha")) {
           txtSenhaVisivel.setVisible(false);
           txtSenha.requestFocus();

       }

   }//GEN-LAST:event_txtSenhaKeyPressed

   private void txtSenhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyReleased

       if (txtSenha.getText().length() < 1) {
           txtSenhaVisivel.setVisible(true);
           txtSenhaVisivel.setText("Senha");
           txtSenhaVisivel.setForeground(new Color(51, 102, 255));
       }

       if (evt.getKeyChar() == VK_ENTER) {
           btnSubmit.doClick();

       }

   }//GEN-LAST:event_txtSenhaKeyReleased


   private void txtSenhaVisivelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaVisivelFocusGained

       ganhouFoco(txtSenhaVisivel, borderDois, "Senha");

       if (txtSenhaVisivel.getText().equals("Senha")) {
           txtSenha.setVisible(true);
           txtSenha.requestFocus();

       }

   }//GEN-LAST:event_txtSenhaVisivelFocusGained

   private void txtSenhaVisivelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaVisivelFocusLost

       perdeuFoco(txtSenhaVisivel, borderDois, "Senha");

   }//GEN-LAST:event_txtSenhaVisivelFocusLost

   private void txtSenhaVisivelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaVisivelKeyPressed
       apertouTecla(txtSenhaVisivel, "Senha");
   }//GEN-LAST:event_txtSenhaVisivelKeyPressed

   private void txtSenhaVisivelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaVisivelKeyReleased
       soltouTecla(txtSenhaVisivel, "Senha", evt);

       if (txtSenhaVisivel.getText().length() < 1) {
           txtSenhaVisivel.setText("Senha");
           txtSenhaVisivel.setForeground(new Color(51, 102, 255));
           txtSenhaVisivel.setCaretPosition(0);
           txtSenhaVisivel.setCaretColor(Color.WHITE);
       }

       if (evt.getKeyChar() == VK_ENTER) {
           btnSubmit.doClick();

       }
   }//GEN-LAST:event_txtSenhaVisivelKeyReleased

    public void ganhouFoco(JTextField txt, JLabel lbl, String tipo) {

        lbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

        if (txt.getText().equals(tipo)) {
            txt.setForeground(new Color(51, 102, 255));
            txt.setCaretPosition(0);
            txt.setCaretColor(Color.WHITE);

        } else {
            txt.setCaretPosition(txt.getText().length());

        }

    }

    public void perdeuFoco(JTextField txt, JLabel lbl, String tipo) {

        lbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
        txt.setForeground(new Color(255, 255, 255));

        String nome = txt.getText().replace(" ", "");

        if (nome.isEmpty()) {
            txt.setText(tipo);
        }

    }

    public void apertouTecla(JTextField txt, String tipo) {

        if (txt.getText().equals(tipo)) {
            txt.setText("");
            txt.setForeground(Color.WHITE);

        }

    }

    public void soltouTecla(JTextField txt, String tipo, KeyEvent evt) {

        String nome = txt.getText().replace(" ", "");

        if (nome.isEmpty() && !(evt.getKeyChar() == 8)) {
            txt.setText(tipo);
            txt.setForeground(new Color(51, 102, 255));
            txt.setCaretPosition(0);
        }

    }

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel borderDois;
    private javax.swing.JLabel borderUm;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblVer;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtSenhaVisivel;
    private javax.swing.JTextField txtUsu;
    // End of variables declaration//GEN-END:variables
}
