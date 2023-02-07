package br.com.Ndpi.telas;

import java.sql.*;
import br.com.Ndpi.dal.ModuloConexao;
import java.awt.Color;
import static java.awt.event.KeyEvent.VK_ENTER;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class TelaAddOficina extends javax.swing.JInternalFrame {

			Connection conexao = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			public TelaAddOficina() {
						initComponents();
						this.getContentPane().setBackground(new Color(51, 51, 51));
						conexao = ModuloConexao.conector();
			}

			private void adicionar() {
						String sql = "insert into tboficinas(nome) values(?)";

						try {

									pst = conexao.prepareStatement(sql);
									pst.setString(1, txtOfi.getText());

									pst.executeUpdate();

									JOptionPane.showMessageDialog(null, "Oficina adicionada com sucesso !");

									txtOfi.setText("Nome da nova Oficina");

						} catch (Exception e) {
						}

			}

   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      borderUm = new javax.swing.JLabel();
      txtOfi = new javax.swing.JTextField();
      btnAdiciona = new javax.swing.JButton();

      setBackground(new java.awt.Color(51, 51, 51));
      setClosable(true);
      setTitle("Adicionar Oficina");
      getContentPane().setLayout(null);

      borderUm.setText("jLabel1");
      borderUm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
      getContentPane().add(borderUm);
      borderUm.setBounds(18, 70, 240, 1);

      txtOfi.setBackground(null);
      txtOfi.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      txtOfi.setForeground(new java.awt.Color(255, 255, 255));
      txtOfi.setText("Nome da nova Oficina");
      txtOfi.setBorder(null);
      txtOfi.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusGained(java.awt.event.FocusEvent evt) {
            txtOfiFocusGained(evt);
         }
         public void focusLost(java.awt.event.FocusEvent evt) {
            txtOfiFocusLost(evt);
         }
      });
      txtOfi.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(java.awt.event.KeyEvent evt) {
            txtOfiKeyPressed(evt);
         }
         public void keyReleased(java.awt.event.KeyEvent evt) {
            txtOfiKeyReleased(evt);
         }
      });
      getContentPane().add(txtOfi);
      txtOfi.setBounds(26, 41, 230, 30);

      btnAdiciona.setBackground(new java.awt.Color(255, 128, 0));
      btnAdiciona.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      btnAdiciona.setForeground(new java.awt.Color(255, 255, 255));
      btnAdiciona.setText("Adicionar");
      btnAdiciona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 128, 0)));
      btnAdiciona.setContentAreaFilled(false);
      btnAdiciona.setFocusPainted(false);
      btnAdiciona.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAdicionaActionPerformed(evt);
         }
      });
      getContentPane().add(btnAdiciona);
      btnAdiciona.setBounds(90, 125, 100, 30);

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btnAdicionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaActionPerformed

						String txt = txtOfi.getText().replace(" ", "");
						
						if (txt.isEmpty()) {
									JOptionPane.showMessageDialog(null, "Por favor, insíra o nome da oficina !");

						} else {
									adicionar();

						}

						this.setVisible(false);
						this.setVisible(true);

						TelaOficinas.showAlunos();

   }//GEN-LAST:event_btnAdicionaActionPerformed

   private void txtOfiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOfiFocusGained

						if (txtOfi.getText().equals("Nome da nova Oficina")) {
									txtOfi.setForeground(new Color(51, 102, 255));
									txtOfi.setCaretPosition(0);
									
						}

						txtOfi.setCaretColor(new Color(255, 255, 255));
						borderUm.setBorder(new LineBorder(new Color(51, 102, 255)));

   }//GEN-LAST:event_txtOfiFocusGained

   private void txtOfiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOfiFocusLost

						String txt = txtOfi.getText().replace(" ", "");

						if (txt.isEmpty()) {
									txtOfi.setText("Nome da nova Oficina");
						}

						txtOfi.setForeground(new Color(153, 153, 153));
						borderUm.setBorder(new LineBorder(new Color(150, 150, 150)));

   }//GEN-LAST:event_txtOfiFocusLost

   private void txtOfiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOfiKeyPressed

						if (txtOfi.getText().equals("Nome da nova Oficina") && !(evt.getKeyCode() == 8)) {
									txtOfi.setText("");
									txtOfi.setForeground(new Color(255, 255, 255));

						}

   }//GEN-LAST:event_txtOfiKeyPressed

   private void txtOfiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOfiKeyReleased

						if (txtOfi.getText().length() < 1) {
									txtOfi.setText("Nome da nova Oficina");
									txtOfi.setForeground(new Color(51, 102, 255));
									txtOfi.setCaretPosition(0);
									txtOfi.setCaretColor(new Color(255, 255, 255));

						}
						
						if(evt.getKeyChar() == VK_ENTER) {
									btnAdiciona.doClick();
						}

   }//GEN-LAST:event_txtOfiKeyReleased

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel borderUm;
   private javax.swing.JButton btnAdiciona;
   private javax.swing.JTextField txtOfi;
   // End of variables declaration//GEN-END:variables
}
