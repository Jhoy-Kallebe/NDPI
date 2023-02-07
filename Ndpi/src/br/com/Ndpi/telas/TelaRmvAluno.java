package br.com.Ndpi.telas;

import br.com.Ndpi.dal.ModuloConexao;
import java.awt.Color;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class TelaRmvAluno extends javax.swing.JInternalFrame {

			// Estas três variáveis são para a conexão com o banco de dados
			Connection conexao = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			Date data = null;
			String datForm = null;

			String txt = null;

			public TelaRmvAluno() {
						initComponents();

						this.getContentPane().setBackground(new Color(51, 51, 51));

						conexao = ModuloConexao.conector();

			}

			/*
			 ************** Este método é responsável por fazer a pesquisa no banco de dados **************
			 ********************** e setar os resultados nos respectivos campos **********************
			 */
			public void pesquisar(String id) {

						// String de pesquisa
						String sql = "select * from tbalunos where id=? ;";

						// Circundação para o tratamentode erros
						try {

									// Às três linhas abaixo são responsáveis por executar a pesquisa no banco de dados e retornar o resultado
									pst = conexao.prepareStatement(sql);
									pst.setString(1,id);
									rs = pst.executeQuery();

									// O bloco de código abaixo verifica se a pesquisa acima obteve algum resultado
									if (rs.next()) {
												String nome = rs.getString("nome");
												data = rs.getDate("nascimento");
												String email = rs.getString("email");
												String serie = rs.getString("serie");
												String curso = rs.getString("curso");

												formata(data);

												// Este bloco de códigos é responsável por setar os valores que vieram do BD nos campos respectivos
												lblNome.setText(nome);
												lblDatNasc.setText(datForm);
												lblEmail.setText(email);
												lblSerie.setText(serie);
												lblCurso.setText(curso);

									} else {
												// O bloco de códigos abaixo é responsável por zerar os campos
												lblNome.setText(null);
												lblDatNasc.setText(null);
												lblEmail.setText(null);
												lblSerie.setText(null);
												lblCurso.setText(null);

									}

						} catch (Exception e) {
									JOptionPane.showMessageDialog(null, e);
						}

			}

			private void apagar() {
						String sql = "delete from tbalunos where id=? ";

						try {

									int opcao = JOptionPane.showConfirmDialog(null, "Você realmente deseja excluir este aluno ?");

									if (opcao == 0) {
												apagarOf();

												pst = conexao.prepareStatement(sql);
												pst.setString(1, lblIdNome.getText());

												pst.executeUpdate();

												JOptionPane.showMessageDialog(null, "Exclusão concluida com sucesso!");

												lblIdNome.setVisible(true);
												txtId.setText("");
												lblNome.setText("Nome");
												lblDatNasc.setText("Data de nascimento");
												lblEmail.setText("Email");
												lblSerie.setText("Série");
												lblCurso.setText("");

									}

						} catch (Exception e) {
									JOptionPane.showMessageDialog(null, e);
						}

			}

			private void apagarOf() {
						String sql = "delete from cursa where id=?";

						try {
									pst = conexao.prepareStatement(sql);
									pst.setString(1, lblIdNome.getText());

									pst.executeUpdate();

						} catch (Exception e) {
									JOptionPane.showMessageDialog(null, e);
						}

			}

			// Este método formata a data de nascimento
			public void formata(Date nasc) {
						SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
						datForm = formata.format(data);

			}

			public void setVisibilidade(boolean f) {

						borderUm.setVisible(f);
						txtId.setVisible(f);

			}

			public void setId(String Id) {

						lblIdNome.setText(Id);
						lblIdNome.setForeground(new Color(153, 153, 153));

			}
			
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      borderDois = new javax.swing.JLabel();
      borderTres = new javax.swing.JLabel();
      borderQuatro = new javax.swing.JLabel();
      borderCinco = new javax.swing.JLabel();
      borderUm = new javax.swing.JLabel();
      lblIdNome = new javax.swing.JLabel();
      btnRemove = new javax.swing.JButton();
      lblNome = new javax.swing.JLabel();
      lblDatNasc = new javax.swing.JLabel();
      lblEmail = new javax.swing.JLabel();
      lblCurso = new javax.swing.JLabel();
      lblSerie = new javax.swing.JLabel();
      txtId = new javax.swing.JFormattedTextField();

      setClosable(true);
      setTitle("Remover Aluno");
      setToolTipText("");
      setPreferredSize(new java.awt.Dimension(406, 408));
      getContentPane().setLayout(null);

      borderDois.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
      getContentPane().add(borderDois);
      borderDois.setBounds(50, 120, 290, 1);

      borderTres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
      getContentPane().add(borderTres);
      borderTres.setBounds(50, 168, 290, 1);

      borderQuatro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
      getContentPane().add(borderQuatro);
      borderQuatro.setBounds(50, 216, 290, 1);

      borderCinco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
      getContentPane().add(borderCinco);
      borderCinco.setBounds(50, 264, 290, 1);

      borderUm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
      getContentPane().add(borderUm);
      borderUm.setBounds(160, 62, 70, 1);

      lblIdNome.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      lblIdNome.setForeground(new java.awt.Color(51, 102, 255));
      lblIdNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lblIdNome.setText("id");
      lblIdNome.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            lblIdNomeMouseClicked(evt);
         }
      });
      getContentPane().add(lblIdNome);
      lblIdNome.setBounds(170, 34, 50, 28);

      btnRemove.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      btnRemove.setForeground(new java.awt.Color(255, 255, 255));
      btnRemove.setText("Remover");
      btnRemove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 128, 0)));
      btnRemove.setContentAreaFilled(false);
      btnRemove.setFocusPainted(false);
      btnRemove.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRemoveActionPerformed(evt);
         }
      });
      getContentPane().add(btnRemove);
      btnRemove.setBounds(135, 316, 130, 37);

      lblNome.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      lblNome.setForeground(new java.awt.Color(153, 153, 153));
      lblNome.setText("Nome");
      lblNome.setToolTipText("Este campo é preenchido automáticamente");
      getContentPane().add(lblNome);
      lblNome.setBounds(60, 91, 270, 30);

      lblDatNasc.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      lblDatNasc.setForeground(new java.awt.Color(153, 153, 153));
      lblDatNasc.setText("Data de nascimento");
      lblDatNasc.setToolTipText("Este campo é preenchido automáticamente");
      getContentPane().add(lblDatNasc);
      lblDatNasc.setBounds(60, 139, 270, 30);

      lblEmail.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      lblEmail.setForeground(new java.awt.Color(153, 153, 153));
      lblEmail.setText("Email");
      lblEmail.setToolTipText("Este campo é preenchido automáticamente");
      getContentPane().add(lblEmail);
      lblEmail.setBounds(60, 187, 270, 30);

      lblCurso.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      lblCurso.setForeground(new java.awt.Color(153, 153, 153));
      getContentPane().add(lblCurso);
      lblCurso.setBounds(144, 235, 186, 30);

      lblSerie.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      lblSerie.setForeground(new java.awt.Color(153, 153, 153));
      lblSerie.setText("Série");
      lblSerie.setToolTipText("Este campo é preenchido automáticamente");
      getContentPane().add(lblSerie);
      lblSerie.setBounds(60, 235, 78, 30);

      txtId.setBackground(new java.awt.Color(51, 51, 51));
      txtId.setBorder(null);
      txtId.setForeground(new java.awt.Color(255, 255, 255));
      try {
         txtId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
      } catch (java.text.ParseException ex) {
         ex.printStackTrace();
      }
      txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
      txtId.setText("");
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
      txtId.setBounds(170, 33, 50, 30);

      setBounds(0, 0, 406, 408);
   }// </editor-fold>//GEN-END:initComponents

   private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

						if (lblIdNome.getText().equals("id")) {
									JOptionPane.showMessageDialog(null, "Preencha o campo 'ID' !");
									this.setVisible(false);
									this.setVisible(true);

									borderUm.setBorder(new LineBorder(new Color(255, 51, 51)));

						} else {
									apagar();

						}

						this.setVisible(false);
						this.setVisible(true);

						TelaAlunos.showAlunos();

   }//GEN-LAST:event_btnRemoveActionPerformed

   private void txtIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusGained

						borderUm.setBorder(new LineBorder(new Color(51, 102, 255)));

						String re = txtId.getText().replace(" ", "");

						if (re.isEmpty()) {
									txtId.setCaretPosition(0);
						}

   }//GEN-LAST:event_txtIdFocusGained

   private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased

						pesquisar(txtId.getText());
						
						txt = txtId.getText();

						String re = txtId.getText().replace(" ", "");

						if (re.isEmpty()) {

									lblIdNome.setVisible(true);
									txtId.setText("");
									lblNome.setText("Nome");
									lblDatNasc.setText("Data de nascimento");
									lblEmail.setText("Email");
									lblSerie.setText("Série");
									lblCurso.setText("");

						}

						if (evt.getKeyChar() == VK_ENTER) {
									btnRemove.doClick();
						}

   }//GEN-LAST:event_txtIdKeyReleased

   private void lblIdNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIdNomeMouseClicked

						txtId.requestFocus();

						String re = txtId.getText().replace(" ", "");

						if (re.isEmpty()) {
									txtId.setCaretPosition(0);
						}

   }//GEN-LAST:event_lblIdNomeMouseClicked

   private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed

						if (lblIdNome.isVisible()) {
									lblIdNome.setVisible(false);
						}

   }//GEN-LAST:event_txtIdKeyPressed

   private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost

						borderUm.setBorder(new LineBorder(new Color(150, 150, 150)));

						if (txtId.getText().length() < 1) {
									lblIdNome.setVisible(true);
						}

   }//GEN-LAST:event_txtIdFocusLost


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel borderCinco;
   private javax.swing.JLabel borderDois;
   private javax.swing.JLabel borderQuatro;
   private javax.swing.JLabel borderTres;
   private javax.swing.JLabel borderUm;
   private javax.swing.JButton btnRemove;
   private javax.swing.JLabel lblCurso;
   private javax.swing.JLabel lblDatNasc;
   private javax.swing.JLabel lblEmail;
   private javax.swing.JLabel lblIdNome;
   private javax.swing.JLabel lblNome;
   private javax.swing.JLabel lblSerie;
   private javax.swing.JFormattedTextField txtId;
   // End of variables declaration//GEN-END:variables
}
