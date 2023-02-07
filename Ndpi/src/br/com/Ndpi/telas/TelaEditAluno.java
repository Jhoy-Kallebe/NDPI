package br.com.Ndpi.telas;

import java.sql.*;
import br.com.Ndpi.dal.ModuloConexao;
import java.awt.Color;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TelaEditAluno extends javax.swing.JInternalFrame {

			// Estas três variáveis são para a conexão com o banco de dados
			Connection conexao = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			TelaEscOficinas oficinas = new TelaEscOficinas();

			java.util.Date dia = new java.util.Date();
			SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");

			Date data = null;
			String datForm = null;

			String data2 = null;

			String txt = null;

			public TelaEditAluno() {
						initComponents();

						this.getContentPane().setBackground(new Color(51, 51, 51));

						conexao = ModuloConexao.conector();
						txtData.setText(form.format(dia));

			}

			// Este método possui a primeira String sql e é responsável por editar o cadastro do aluno, menos as oficinas
			public void editar() {
						formataBd(txtData.getText());
						String sql = "update tbalunos set nome=?, email=?, curso=?, serie=?, nascimento=? where id=? ";

						try {
									pst = conexao.prepareStatement(sql);

									pst.setString(1, txtNome.getText());
									pst.setString(2, txtEmail.getText());
									pst.setString(3, (String) jcbCurso.getSelectedItem());
									pst.setString(4, (String) jcbAno.getSelectedItem());
									pst.setString(5, data2);

									pst.setString(6, lblIdNome.getText());

									pst.executeUpdate();

									deletaOf();
									escOf(lblIdNome.getText());

									JOptionPane.showMessageDialog(null, "Aluno editado com sucesso!");

									txtId.setText(null);
									lblIdNome.setText("id");
									txtNome.setText("Nome");
									txtEmail.setText("Email");
									txtData.setText(form.format(dia));
									TelaEscOficinas.ofsel.clear();

									borderUm.setBorder(new LineBorder(new Color(150, 150, 150)));
									borderDois.setBorder(new LineBorder(new Color(150, 150, 150)));
									borderQuatro.setBorder(new LineBorder(new Color(150, 150, 150)));
									btnOficinas.setBorder(new LineBorder(new Color(150, 150, 150)));

						} catch (Exception e) {
									JOptionPane.showMessageDialog(null, e);
						}

			}

			// Este método é responsável por recuperar o id do aluno registrado acima
			private void deletaOf() {
						String sql = "delete from cursa where id=? ";

						try {
									pst = conexao.prepareStatement(sql);
									pst.setString(1, lblIdNome.getText());

									pst.executeUpdate();

						} catch (Exception e) {
									JOptionPane.showMessageDialog(null, e);
						}

			}

			// Este método é responsável por fazer a relação no banco de dados do aluno com as oficinas que ele deseja cursar utilizando como parâmetro o id do mesmo
			private void escOf(String id) {
						String sql = "insert into cursa(id,nome) values(?,?)";

						try {
									for (String i : TelaEscOficinas.ofsel) {
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
			public void formataBd(String data3) {

						String dia = data3.substring(0, 2);
						String mes = data3.substring(3, 5);
						String ano = data3.substring(6, 10);

						data2 = (ano + "-" + mes + "-" + dia);
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
									pst.setString(1, id);
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
												txtNome.setText(nome);
												txtData.setText(datForm);
												txtEmail.setText(email);
												jcbAno.setSelectedItem(serie);
												jcbCurso.setSelectedItem(curso);

									} else {

												// O bloco de códigos abaixo é responsável por zerar os campos
												txtNome.setText(null);
												txtData.setText(null);
												txtEmail.setText(null);
												jcbAno.setSelectedIndex(0);
												jcbCurso.setSelectedIndex(0);

									}

						} catch (Exception e) {
						}

			}

			// Este método formata a data de nascimento
			public void formata(Date nasc) {
						SimpleDateFormat formata = new SimpleDateFormat("ddMMyyyy");
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

      borderUm = new javax.swing.JLabel();
      borderDois = new javax.swing.JLabel();
      borderTres = new javax.swing.JLabel();
      borderQuatro = new javax.swing.JLabel();
      lblIdNome = new javax.swing.JLabel();
      btnOficinas = new javax.swing.JLabel();
      btnAdicionar = new javax.swing.JButton();
      txtNome = new javax.swing.JTextField();
      txtEmail = new javax.swing.JTextField();
      jcbCurso = new javax.swing.JComboBox();
      txtData = new javax.swing.JFormattedTextField();
      jcbAno = new javax.swing.JComboBox();
      txtId = new javax.swing.JFormattedTextField();

      setClosable(true);
      setTitle("Editar Dados Do Aluno");
      setPreferredSize(new java.awt.Dimension(406, 408));
      getContentPane().setLayout(null);

      borderUm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
      getContentPane().add(borderUm);
      borderUm.setBounds(160, 40, 70, 1);

      borderDois.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
      getContentPane().add(borderDois);
      borderDois.setBounds(50, 81, 290, 1);

      borderTres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
      getContentPane().add(borderTres);
      borderTres.setBounds(50, 129, 290, 1);

      borderQuatro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
      getContentPane().add(borderQuatro);
      borderQuatro.setBounds(50, 177, 290, 1);

      lblIdNome.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      lblIdNome.setForeground(new java.awt.Color(51, 102, 255));
      lblIdNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      lblIdNome.setText("id");
      lblIdNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
      lblIdNome.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            lblIdNomeMouseClicked(evt);
         }
      });
      getContentPane().add(lblIdNome);
      lblIdNome.setBounds(170, 12, 50, 28);

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
      btnOficinas.setBounds(50, 244, 290, 35);

      btnAdicionar.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      btnAdicionar.setForeground(new java.awt.Color(255, 255, 255));
      btnAdicionar.setText("Editar");
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
      txtNome.setToolTipText("");
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
      txtNome.setBounds(60, 52, 274, 30);

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
      txtEmail.setBounds(60, 100, 274, 30);

      jcbCurso.setBackground(new java.awt.Color(51, 51, 51));
      jcbCurso.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      jcbCurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Informática", "Agricultura", "Agroecologia", "Informática Outros", "Agrária Outros" }));
      jcbCurso.setBorder(null);
      jcbCurso.addItemListener(new java.awt.event.ItemListener() {
         public void itemStateChanged(java.awt.event.ItemEvent evt) {
            jcbCursoItemStateChanged(evt);
         }
      });
      getContentPane().add(jcbCurso);
      jcbCurso.setBounds(150, 196, 190, 30);

      txtData.setBackground(new java.awt.Color(51, 51, 51));
      txtData.setBorder(null);
      txtData.setForeground(new java.awt.Color(153, 153, 153));
      try {
         txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
      } catch (java.text.ParseException ex) {
         ex.printStackTrace();
      }
      txtData.setText("09/10/2020");
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
      txtData.setBounds(60, 148, 274, 30);

      jcbAno.setBackground(new java.awt.Color(51, 51, 51));
      jcbAno.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
      jcbAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1º ano", "2º ano", "3º ano" }));
      jcbAno.setBorder(null);
      jcbAno.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(java.awt.event.KeyEvent evt) {
            jcbAnoKeyPressed(evt);
         }
      });
      getContentPane().add(jcbAno);
      jcbAno.setBounds(50, 196, 90, 30);

      txtId.setBackground(new java.awt.Color(51, 51, 51));
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
      txtId.setBounds(170, 11, 50, 30);

      setBounds(0, 0, 406, 408);
   }// </editor-fold>//GEN-END:initComponents

   private void btnOficinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOficinasMouseClicked

						// Este método abre a tela para a escolha das oficinas
						if (!(oficinas.isVisible())) {
									int x = btnOficinas.getX();
									int y = btnOficinas.getY();

									add(oficinas);
									oficinas.setVisible(true);
									oficinas.setBounds(x, y + 35, 290, 100);

									btnOficinas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));

									btnAdicionar.setVisible(false);

						} else {
									oficinas.setVisible(false);
									btnAdicionar.setVisible(true);

									btnOficinas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));

						}
   }//GEN-LAST:event_btnOficinasMouseClicked

   private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

						String fo = txtData.getText().replace("/", "");

						if ((txtNome.getText().isEmpty() || fo.isEmpty()) || oficinas.ofsel.isEmpty()) {

									JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios !");

									borderUm.setBorder(new LineBorder(new Color(255, 51, 51)));
									borderDois.setBorder(new LineBorder(new Color(255, 51, 51)));
									borderQuatro.setBorder(new LineBorder(new Color(255, 51, 51)));
									btnOficinas.setBorder(new LineBorder(new Color(255, 51, 51)));

						} else {
									editar();

						}

						this.setVisible(false);
						this.setVisible(true);

						TelaAlunos.showAlunos();

   }//GEN-LAST:event_btnAdicionarActionPerformed


   private void jcbCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCursoItemStateChanged

						// Este método verifica se o aluno faz parte do ensino médio para ativar ou desativar a escolha da série
						if (jcbCurso.getSelectedItem().equals("Informática Outros") || jcbCurso.getSelectedItem().equals("Agrária Outros")) {

									jcbAno.disable();

						} else {
									jcbAno.enable();
						}

   }//GEN-LAST:event_jcbCursoItemStateChanged


   private void txtIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyReleased

						pesquisar(txtId.getText());

						txt = txtId.getText();

						String re = txtId.getText().replace(" ", "");

						if (re.isEmpty()) {

									lblIdNome.setVisible(true);
									lblIdNome.setText("id");
									txtId.setText("");
									txtNome.setText("Nome");
									txtData.setText(form.format(dia));
									txtEmail.setText("Email");
									jcbAno.setSelectedIndex(0);
									jcbCurso.setSelectedIndex(0);

						}

						if (evt.getKeyChar() == VK_ENTER) {
									txtNome.requestFocus();
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

						String re = txtId.getText().replace(" ", "");

						if (re.isEmpty()) {
									if (lblIdNome.isVisible()) {
												lblIdNome.setVisible(false);

									}

						}

   }//GEN-LAST:event_txtIdKeyPressed

   private void txtIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusGained

						borderUm.setBorder(new LineBorder(new Color(51, 102, 255)));
						lblIdNome.setForeground(new Color(51, 102, 255));

						String re = txtId.getText().replace(" ", "");

						if (re.isEmpty()) {
									txtId.setCaretPosition(0);
						}

   }//GEN-LAST:event_txtIdFocusGained

   private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost

						borderUm.setBorder(new LineBorder(new Color(150, 150, 150)));
						lblIdNome.setForeground(new Color(150, 150, 150));

						String re = txtId.getText().replace(" ", "");

						if (re.isEmpty()) {
									lblIdNome.setVisible(true);

						} else {
									lblIdNome.setVisible(true);
									lblIdNome.setText(txtId.getText());

						}

   }//GEN-LAST:event_txtIdFocusLost


   private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained

						ganhouFoco(txtNome, borderDois, "Nome");

   }//GEN-LAST:event_txtNomeFocusGained

   private void txtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusLost

						perdeuFoco(txtNome, borderDois, "Nome");

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


   private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained

						ganhouFoco(txtEmail, borderTres, "Email");

   }//GEN-LAST:event_txtEmailFocusGained

   private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost

						perdeuFoco(txtEmail, borderTres, "Email");

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


   private void txtDataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataFocusGained
						ganhouFoco(txtData, borderQuatro, form.format(dia));
   }//GEN-LAST:event_txtDataFocusGained

   private void txtDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataFocusLost
						borderQuatro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 150, 150)));
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
   private javax.swing.JLabel borderQuatro;
   private javax.swing.JLabel borderTres;
   private javax.swing.JLabel borderUm;
   private javax.swing.JButton btnAdicionar;
   private javax.swing.JLabel btnOficinas;
   private javax.swing.JComboBox jcbAno;
   private javax.swing.JComboBox jcbCurso;
   private javax.swing.JLabel lblIdNome;
   private javax.swing.JFormattedTextField txtData;
   private javax.swing.JTextField txtEmail;
   private javax.swing.JFormattedTextField txtId;
   private javax.swing.JTextField txtNome;
   // End of variables declaration//GEN-END:variables
}
