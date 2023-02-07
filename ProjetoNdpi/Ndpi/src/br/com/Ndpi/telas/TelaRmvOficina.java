package br.com.Ndpi.telas;

import java.sql.*;
import br.com.Ndpi.dal.ModuloConexao;
import java.awt.Color;
import java.awt.HeadlessException;
import static java.awt.event.KeyEvent.VK_ENTER;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class TelaRmvOficina extends javax.swing.JInternalFrame {

			Connection conexao = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			private String txt = "";
			boolean vali = false;

			public TelaRmvOficina() {
						initComponents();
						this.getContentPane().setBackground(new Color(51, 51, 51));
						conexao = ModuloConexao.conector();

			}

			private void remover() {
						String sql = "delete from tboficinas where id=? ";
						validacao(txtOfi.getText());

						try {

									if (vali) {

												int res = JOptionPane.showConfirmDialog(null, "Você realmente deseja remover esta oficina ?");

												if (res == 0) {
															pst = conexao.prepareStatement(sql);
															pst.setString(1, txt);

															pst.executeUpdate();

															JOptionPane.showMessageDialog(null, "Oficina removida com sucesso !");

															txt = null;
															txtId.setText(null);
															txtOfi.setText("Oficina");

												}
									} else {
												JOptionPane.showMessageDialog(null, "A oficina não pode ser removida, pois exitem alunos matriculados nela !");
									}

						} catch (HeadlessException | SQLException e) {
						}

			}

			public void pesquisa(String id) {
						String sql = "select * from tboficinas where id=?";

						try {

									pst = conexao.prepareStatement(sql);
									pst.setString(1, id);

									rs = pst.executeQuery();

									if (rs.next()) {
												txtOfi.setText(rs.getString("nome"));

									} else {
												txtOfi.setText("Oficina");

									}

						} catch (Exception e) {
						}

			}

			private void validacao(String nome) {
						String sql = "select * from cursa where nome=?";

						try {

									pst = conexao.prepareStatement(sql);
									pst.setString(1, nome);

									rs = pst.executeQuery();

									vali = !rs.next();

						} catch (Exception e) {
						}

			}

			public void setId(String id) {
						txtId.setText(id);

			}

			public void setTxt(String id) {
						txt = id;
			}

			public String getTxt() {
						return txt;
			}
			
			public void alteraId(String id) {
						lblId.setText(id);
			}

   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      borderDois = new javax.swing.JLabel();
      borderUm = new javax.swing.JLabel();
      lblId = new javax.swing.JLabel();
      txtOfi = new javax.swing.JTextField();
      btnAdiciona = new javax.swing.JButton();
      txtId = new javax.swing.JFormattedTextField();

      setBackground(new java.awt.Color(51, 51, 51));
      setClosable(true);
      setTitle("Remover Oficina");
      getContentPane().setLayout(null);

      borderDois.setText("jLabel1");
      borderDois.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
      getContentPane().add(borderDois);
      borderDois.setBounds(18, 88, 240, 1);

      borderUm.setText("jLabel1");
      borderUm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
      getContentPane().add(borderUm);
      borderUm.setBounds(116, 52, 60, 1);

      lblId.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      lblId.setForeground(new java.awt.Color(153, 153, 153));
      lblId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lblId.setText("id");
      lblId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
      lblId.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mousePressed(java.awt.event.MouseEvent evt) {
            lblIdMousePressed(evt);
         }
      });
      getContentPane().add(lblId);
      lblId.setBounds(122, 23, 50, 30);

      txtOfi.setEditable(false);
      txtOfi.setBackground(null);
      txtOfi.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      txtOfi.setForeground(new java.awt.Color(153, 153, 153));
      txtOfi.setText("Oficina");
      txtOfi.setToolTipText("Este campo é preenchido automáticamente");
      txtOfi.setBorder(null);
      getContentPane().add(txtOfi);
      txtOfi.setBounds(23, 59, 234, 30);

      btnAdiciona.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      btnAdiciona.setForeground(new java.awt.Color(255, 255, 255));
      btnAdiciona.setText("Remover");
      btnAdiciona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 128, 0)));
      btnAdiciona.setContentAreaFilled(false);
      btnAdiciona.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
      btnAdiciona.setFocusPainted(false);
      btnAdiciona.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAdicionaActionPerformed(evt);
         }
      });
      getContentPane().add(btnAdiciona);
      btnAdiciona.setBounds(90, 125, 100, 30);

      txtId.setBackground(null);
      txtId.setBorder(null);
      txtId.setForeground(new java.awt.Color(255, 255, 255));
      try {
         txtId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
      } catch (java.text.ParseException ex) {
         ex.printStackTrace();
      }
      txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      txtId.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      txtId.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusGained(java.awt.event.FocusEvent evt) {
            txtIdFocusGained(evt);
         }
         public void focusLost(java.awt.event.FocusEvent evt) {
            txtIdFocusLost(evt);
         }
      });
      txtId.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(java.awt.event.KeyEvent evt) {
            txtIdKeyPressed(evt);
         }
         public void keyReleased(java.awt.event.KeyEvent evt) {
            txtIdKeyReleased(evt);
         }
      });
      getContentPane().add(txtId);
      txtId.setBounds(122, 23, 50, 30);

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btnAdicionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaActionPerformed
												
						if (txt.isEmpty()) {
									JOptionPane.showMessageDialog(null, "Por favor, insíra o número da oficina !");

						} else {
									remover();

						}

						this.setVisible(false);
						this.setVisible(true);

						TelaOficinas.showAlunos();

   }//GEN-LAST:event_btnAdicionaActionPerformed

   private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased

						pesquisa(txtId.getText());
						txt = txtId.getText();

						String txti = txtId.getText().replace(" ","");
						
						if (txti.isEmpty()) {
									lblId.setText("id");
									lblId.setForeground(new Color(51, 102, 255));

						}
						
						if(evt.getKeyChar() == VK_ENTER){
									btnAdiciona.doClick();
									System.out.println(txt);
									
						}

   }//GEN-LAST:event_txtIdKeyReleased

   private void lblIdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIdMousePressed

						txtId.requestFocus();

   }//GEN-LAST:event_lblIdMousePressed

   private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed

						lblId.setText("");

   }//GEN-LAST:event_txtIdKeyPressed

   private void txtIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusGained

						if (lblId.getText().equals("id")) {
									lblId.setForeground(new Color(51, 102, 255));
						}

						txtId.setCaretPosition(0);
						borderUm.setBorder(new LineBorder(new Color(51, 102, 255)));

   }//GEN-LAST:event_txtIdFocusGained

   private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost

						String txti = txtId.getText().replace(" ","");
						
						if(txti.isEmpty()) {
									lblId.setText("id");
									
						} else {
									lblId.setText(txtId.getText());
									
						}
						
						lblId.setForeground(new Color(153, 153, 153));
						borderUm.setBorder(new LineBorder(new Color(150, 150, 150)));

   }//GEN-LAST:event_txtIdFocusLost


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel borderDois;
   private javax.swing.JLabel borderUm;
   private javax.swing.JButton btnAdiciona;
   private javax.swing.JLabel lblId;
   private javax.swing.JFormattedTextField txtId;
   private javax.swing.JTextField txtOfi;
   // End of variables declaration//GEN-END:variables
}
