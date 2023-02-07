package br.com.Ndpi.telas;

import java.sql.*;
import br.com.Ndpi.dal.ModuloConexao;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;

public class TelaEscOficinas extends javax.swing.JInternalFrame {

			// Variáveis de conexão
			static Connection conexao = null;
			static PreparedStatement pst = null;
			static ResultSet rs = null;

			// Arrays criados para o armazenamento dos "JCheckBox" e das oficinas selecionadas
			static ArrayList<JCheckBox> caixas;
			static ArrayList<String> ofsel;

			public TelaEscOficinas() {
						initComponents();

						// Instanciamento dos Arrays
						caixas = new ArrayList<>();
						ofsel = new ArrayList<>();

						inicioTela();

						conexao = ModuloConexao.conector();
						addOficina();

			}

			// Este método cria um componente "JCheckBox" e o configura
			private void addComponent(String nome) {

						// Instância
						JCheckBox caixa = new JCheckBox(nome);

						// Adição do componente ao painel e ao Array
						pnlPainel.add(caixa);
						caixas.add(caixa);

						// Configuração da fonte do componente
						caixa.setFont(new Font("Segoe UI Light", 0, 13));
						caixa.setForeground(Color.white);

						// Esta ação é responsável por verificar se o componente está selecionando ou não e assim adicionar ou retirar alguma oficina do Array
						caixa.addActionListener(new ActionListener() {

									public void actionPerformed(ActionEvent e) {

												if (caixa.isSelected()) {
															ofsel.add(caixa.getText());

												} else {
															ofsel.remove(caixa.getText());

												}

									}

						});

						// Esta linha abaixo atualiza o painel
						pnlPainel.updateUI();

			}

			// Este método é responsável por inserir as oficinas no painel
			private void addOficina() {

						String sql = "select * from tboficinas;";

						try {
									pst = conexao.prepareStatement(sql);
									rs = pst.executeQuery();

									while (rs.next()) {
												addComponent(rs.getString("nome"));
									}

						} catch (Exception e) {
						}

			}

			public static void inicioTela() {

						ofsel.clear();

						for (JCheckBox i : caixas) {
									i.setSelected(false);
						}

			}


   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jScrollPane1 = new javax.swing.JScrollPane();
      pnlPainel = new javax.swing.JPanel();

      setBackground(new java.awt.Color(51, 51, 51));
      try {
         setSelected(true);
      } catch (java.beans.PropertyVetoException e1) {
         e1.printStackTrace();
      }
      setVisible(true);
      addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
         public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            formInternalFrameActivated(evt);
         }
         public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
         }
         public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
         }
         public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
         }
         public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
         }
         public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
         }
         public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            formInternalFrameOpened(evt);
         }
      });
      addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseEntered(java.awt.event.MouseEvent evt) {
            formMouseEntered(evt);
         }
         public void mouseExited(java.awt.event.MouseEvent evt) {
            formMouseExited(evt);
         }
      });

      pnlPainel.setBackground(new java.awt.Color(51, 51, 51));
      pnlPainel.setLayout(new java.awt.GridLayout(0, 1));
      jScrollPane1.setViewportView(pnlPainel);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered

   }//GEN-LAST:event_formMouseEntered

   private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited

   }//GEN-LAST:event_formMouseExited

   private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened


   }//GEN-LAST:event_formInternalFrameOpened

   private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated


   }//GEN-LAST:event_formInternalFrameActivated


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JPanel pnlPainel;
   // End of variables declaration//GEN-END:variables
}
