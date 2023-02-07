package br.com.Ndpi.telas;

import java.sql.*;
import br.com.Ndpi.dal.ModuloConexao;
import java.awt.Color;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TelaAddAluno extends javax.swing.JInternalFrame {

			Connection conexao = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			TelaEscOficinas oficinas = new TelaEscOficinas();
			static boolean cont = false;

			java.util.Date dia = new java.util.Date();
			SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");

			String data = null;

			public TelaAddAluno() {

						oficinas.setBounds(50, 232 + 35, 290, 113);

						initComponents();

						this.getContentPane().setBackground(new Color(51, 51, 51));

						conexao = ModuloConexao.conector();
						txtData.setText(form.format(dia));
			}

			// Este método possui a primeira String sql e é responsável por fazer o cadastro do aluno, meno as oficinas
			public void inserir() {
						formata(txtData.getText());
						String sql = "insert into tbalunos(nome,email,curso,serie,nascimento) values(?,?,?,?,?)";

						try {
									pst = conexao.prepareStatement(sql);

									pst.setString(1, txtNome.getText());
									pst.setString(2, txtEmail.getText());
									pst.setString(3, (String) jcbCurso.getSelectedItem());
									pst.setString(4, (String) jcbAno.getSelectedItem());
									pst.setString(5, data);

									pst.executeUpdate();

									juntaCurso();

									JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso!");

						} catch (Exception e) {
									JOptionPane.showMessageDialog(null, e);
						}

			}

			// Este método é responsável por recuperar o id do aluno registrado acima
			private void juntaCurso() {
						String sql = "select * from tbalunos where nome=? and email=? and nascimento=?";

						try {
									pst = conexao.prepareStatement(sql);
									pst.setString(1, txtNome.getText());
									pst.setString(2, txtEmail.getText());
									pst.setString(3, data);

									rs = pst.executeQuery();

									if (rs.next()) {
												escOf(rs.getString("id"));
									}

						} catch (Exception e) {
									JOptionPane.showMessageDialog(null, e);
						}

			}

			// Este método é responsável por fazer a relação no banco de dados do aluno com as oficinas que ele deseja cursar utilizando como parâmetro o id do mesmo
			private void escOf(String id) {
						String sql = "insert into cursa(id,nome) values(?,?)";

						try {
									for (String i : oficinas.ofsel) {
												pst = conexao.prepareStatement(sql);
												pst.setString(1, id);
												pst.setString(2, i);

												pst.executeUpdate();

									}
						} catch (Exception e) {
									JOptionPane.showMessageDialog(null, e);
						}

			}

			// Este método é responsável por formatar a data que entrará no banco de dados utilizando como parâmetro a data inserida na interface
			public void formata(String data2) {

						String dia = data2.substring(0, 2);
						String mes = data2.substring(3, 5);
						String ano = data2.substring(6, 10);

						data = (ano + "-" + mes + "-" + dia);
			}

   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      borderUm2 = new javax.swing.JLabel();
      btnAdicionar = new javax.swing.JButton();
      txtNome = new javax.swing.JTextField();
      txtEmail = new javax.swing.JTextField();
      txtData = new javax.swing.JFormattedTextField();
      btnOficinas = new javax.swing.JLabel();
      jcbCurso = new javax.swing.JComboBox();
      jcbAno = new javax.swing.JComboBox();
      borderUm = new javax.swing.JLabel();
      borderDois = new javax.swing.JLabel();
      borderTres = new javax.swing.JLabel();

      borderUm2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

      setClosable(true);
      setTitle("Adicionar Aluno");
      setPreferredSize(new java.awt.Dimension(406, 408));
      getContentPane().setLayout(null);

      btnAdicionar.setBackground(new java.awt.Color(255, 128, 0));
      btnAdicionar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      btnAdicionar.setForeground(new java.awt.Color(255, 255, 255));
      btnAdicionar.setText("Adicionar");
      btnAdicionar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 128, 0)));
      btnAdicionar.setContentAreaFilled(false);
      btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAdicionarActionPerformed(evt);
         }
      });
      getContentPane().add(btnAdicionar);
      btnAdicionar.setBounds(135, 316, 130, 37);

      txtNome.setBackground(new java.awt.Color(51, 51, 51));
      txtNome.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      txtNome.setForeground(new java.awt.Color(153, 153, 153));
      txtNome.setText("Nome");
      txtNome.setBorder(null);
      txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusGained(java.awt.event.FocusEvent evt) {
            txtNomeFocusGained(evt);
         }
         public void focusLost(java.awt.event.FocusEvent evt) {
            txtNomeFocusLost(evt);
         }
      });
      txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(java.awt.event.KeyEvent evt) {
            txtNomeKeyPressed(evt);
         }
         public void keyReleased(java.awt.event.KeyEvent evt) {
            txtNomeKeyReleased(evt);
         }
      });
      getContentPane().add(txtNome);
      txtNome.setBounds(60, 40, 274, 30);

      txtEmail.setBackground(new java.awt.Color(51, 51, 51));
      txtEmail.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      txtEmail.setForeground(new java.awt.Color(153, 153, 153));
      txtEmail.setText("Email");
      txtEmail.setBorder(null);
      txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusGained(java.awt.event.FocusEvent evt) {
            txtEmailFocusGained(evt);
         }
         public void focusLost(java.awt.event.FocusEvent evt) {
            txtEmailFocusLost(evt);
         }
      });
      txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(java.awt.event.KeyEvent evt) {
            txtEmailKeyPressed(evt);
         }
         public void keyReleased(java.awt.event.KeyEvent evt) {
            txtEmailKeyReleased(evt);
         }
      });
      getContentPane().add(txtEmail);
      txtEmail.setBounds(60, 88, 274, 30);

      txtData.setBackground(new java.awt.Color(51, 51, 51));
      txtData.setBorder(null);
      txtData.setForeground(new java.awt.Color(153, 153, 153));
      try {
         txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
      } catch (java.text.ParseException ex) {
         ex.printStackTrace();
      }
      txtData.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      txtData.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusGained(java.awt.event.FocusEvent evt) {
            txtDataFocusGained(evt);
         }
         public void focusLost(java.awt.event.FocusEvent evt) {
            txtDataFocusLost(evt);
         }
      });
      txtData.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(java.awt.event.KeyEvent evt) {
            txtDataKeyPressed(evt);
         }
         public void keyReleased(java.awt.event.KeyEvent evt) {
            txtDataKeyReleased(evt);
         }
      });
      getContentPane().add(txtData);
      txtData.setBounds(60, 136, 274, 30);

      btnOficinas.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      btnOficinas.setForeground(new java.awt.Color(255, 255, 255));
      btnOficinas.setText(" Escolha as oficinas");
      btnOficinas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
      btnOficinas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
      btnOficinas.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            btnOficinasMouseClicked(evt);
         }
      });
      getContentPane().add(btnOficinas);
      btnOficinas.setBounds(50, 232, 290, 35);

      jcbCurso.setBackground(new java.awt.Color(51, 51, 51));
      jcbCurso.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      jcbCurso.setForeground(new java.awt.Color(255, 255, 255));
      jcbCurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Informática", "Agricultura", "Agroecologia", "Informática Outros", "Agrária Outros" }));
      jcbCurso.setBorder(null);
      jcbCurso.addItemListener(new java.awt.event.ItemListener() {
         public void itemStateChanged(java.awt.event.ItemEvent evt) {
            jcbCursoItemStateChanged(evt);
         }
      });
      getContentPane().add(jcbCurso);
      jcbCurso.setBounds(150, 184, 190, 30);

      jcbAno.setBackground(new java.awt.Color(51, 51, 51));
      jcbAno.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      jcbAno.setForeground(new java.awt.Color(255, 255, 255));
      jcbAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1º ano", "2º ano", "3º ano" }));
      jcbAno.setBorder(null);
      jcbAno.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(java.awt.event.KeyEvent evt) {
            jcbAnoKeyPressed(evt);
         }
      });
      getContentPane().add(jcbAno);
      jcbAno.setBounds(50, 184, 90, 30);

      borderUm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
      getContentPane().add(borderUm);
      borderUm.setBounds(50, 70, 290, 1);

      borderDois.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
      getContentPane().add(borderDois);
      borderDois.setBounds(50, 118, 290, 1);

      borderTres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
      getContentPane().add(borderTres);
      borderTres.setBounds(50, 166, 290, 1);

      setBounds(0, 0, 406, 408);
   }// </editor-fold>//GEN-END:initComponents

   private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

						String fo = txtData.getText().replace("/", "");

						if ((txtNome.getText().isEmpty() || fo.isEmpty()) || oficinas.ofsel.isEmpty()) {
									JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios !");
									this.setVisible(false);
									this.setVisible(true);

									borderUm.setBorder(new LineBorder(new Color(255, 51, 51)));
									borderTres.setBorder(new LineBorder(new Color(255, 51, 51)));
									btnOficinas.setBorder(new LineBorder(new Color(255, 51, 51)));

						} else {
									inserir();

									JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso !");

									txtNome.setText(null);
									txtEmail.setText(null);
									txtData.setText(null);
									TelaEscOficinas.inicioTela();

						}

						TelaAlunos.showAlunos();

   }//GEN-LAST:event_btnAdicionarActionPerformed

			// *************** Este método abre a tela para a escolha das oficinas *************** 
   private void btnOficinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOficinasMouseClicked

						// Este método verifica se a tela ja está aberta ou não
						if (cont == false) {
									add(oficinas);
									oficinas.setVisible(true);
									btnOficinas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

									btnAdicionar.setVisible(false);

									cont = true;

						} else {
									oficinas.setVisible(false);
									btnOficinas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));

									btnAdicionar.setVisible(true);

									cont = false;

						}

   }//GEN-LAST:event_btnOficinasMouseClicked


   private void jcbCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCursoItemStateChanged

						// Este método verifica se o aluno faz parte do ensino médio para ativar ou desativar a escolha da série
						if (jcbCurso.getSelectedItem().equals("Informática Outros") || jcbCurso.getSelectedItem().equals("Agrária Outros")) {

									jcbAno.disable();

						} else {
									jcbAno.enable();
						}

   }//GEN-LAST:event_jcbCursoItemStateChanged

			/**
			 * Os Métodos abaixo são apenas para a estética do programa
			 */
			/**
			 * **************************** TXT NOME*****************************
			 */

   private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained

						ganhouFoco(txtNome, borderUm, "Nome");

   }//GEN-LAST:event_txtNomeFocusGained

   private void txtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusLost

						perdeuFoco(txtNome, borderUm, "Nome");

   }//GEN-LAST:event_txtNomeFocusLost

   private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed

						apertouTecla(txtNome, "Nome");

   }//GEN-LAST:event_txtNomeKeyPressed

   private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased

						soltouTecla(txtNome, "Nome", evt);

						if (evt.getKeyChar() == VK_ENTER) {
									txtEmail.requestFocus();

						}

   }//GEN-LAST:event_txtNomeKeyReleased

			/**
			 * ****************************** TXT EMAIL *******************************
			 */

   private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained

						ganhouFoco(txtEmail, borderDois, "Email");

   }//GEN-LAST:event_txtEmailFocusGained

   private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost

						perdeuFoco(txtEmail, borderDois, "Email");

   }//GEN-LAST:event_txtEmailFocusLost

   private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed

						apertouTecla(txtEmail, "Email");

   }//GEN-LAST:event_txtEmailKeyPressed

   private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased

						soltouTecla(txtEmail, "Email", evt);

						if (evt.getKeyChar() == VK_ENTER) {
									txtData.requestFocus();

						}

   }//GEN-LAST:event_txtEmailKeyReleased

			/**
			 * ****************************** TXT DATA *******************************
			 */

   private void txtDataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataFocusGained

						ganhouFoco(txtData, borderTres, form.format(dia));

   }//GEN-LAST:event_txtDataFocusGained

   private void txtDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataFocusLost

						borderTres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
						txtData.setForeground(new Color(153, 153, 153));

						String nome = txtData.getText().replace(" ", "");
						String nome2 = nome.replace("/", "");

						if (nome2.isEmpty()) {
									txtData.setText(form.format(dia));
						}

   }//GEN-LAST:event_txtDataFocusLost

   private void txtDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataKeyPressed

						apertouTecla(txtData, form.format(dia));

   }//GEN-LAST:event_txtDataKeyPressed

   private void txtDataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataKeyReleased

						String nome = txtData.getText().replace(" ", "");
						String nome2 = nome.replace("/", "");

						if (nome2.isEmpty()) {
									txtData.setText(form.format(dia));
									txtData.setForeground(new Color(51, 102, 255));
									txtData.setCaretPosition(0);
						}

						if (evt.getKeyChar() == VK_ENTER) {
									jcbAno.requestFocus();

						}

   }//GEN-LAST:event_txtDataKeyReleased

   private void jcbAnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbAnoKeyPressed

						if (evt.getKeyChar() == VK_ENTER) {
									jcbCurso.requestFocus();
						}

   }//GEN-LAST:event_jcbAnoKeyPressed

			public void ganhouFoco(JTextField txt, JLabel lbl, String tipo) {

						lbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

						if (txt.getText().equals(tipo)) {
									txt.setForeground(new Color(51, 102, 255));
									txt.setCaretPosition(0);
									txt.setCaretColor(Color.WHITE);

						}

			}

			public void perdeuFoco(JTextField txt, JLabel lbl, String tipo) {

						lbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
						txt.setForeground(new Color(153, 153, 153));

						String nome = txt.getText().replace(" ", "");

						if (nome.isEmpty()) {
									txt.setText(tipo);
						}

			}

			public void apertouTecla(JTextField txt, String tipo) {

						if (txt.getText().equals(tipo)) {
									txt.setText("");
									txt.setForeground(new Color(255, 255, 255));

						}

			}

			public void soltouTecla(JTextField txt, String tipo, KeyEvent evt) {

						String nome = txt.getText().replace(" ", "");

						if (txt.getText().length() < 1) {
									txt.setText(tipo);
									txt.setForeground(new Color(51, 102, 255));
									txt.setCaretPosition(0);

						}

			}


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel borderDois;
   private javax.swing.JLabel borderTres;
   private javax.swing.JLabel borderUm;
   private javax.swing.JLabel borderUm2;
   private javax.swing.JButton btnAdicionar;
   private javax.swing.JLabel btnOficinas;
   private javax.swing.JComboBox jcbAno;
   private javax.swing.JComboBox jcbCurso;
   private javax.swing.JFormattedTextField txtData;
   private javax.swing.JTextField txtEmail;
   private javax.swing.JTextField txtNome;
   // End of variables declaration//GEN-END:variables
}
