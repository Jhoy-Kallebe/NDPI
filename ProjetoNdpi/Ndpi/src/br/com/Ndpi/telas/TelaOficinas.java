package br.com.Ndpi.telas;

import java.sql.*;
import br.com.Ndpi.dal.ModuloConexao;
import java.awt.Color;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;

public class TelaOficinas extends javax.swing.JFrame {

    // Variáveis de conexão com o banco de dados
    static Connection conexao = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;

    // Instâncias das telas secundárias para a manipulação dos dados
    TelaAddOficina addofi = new TelaAddOficina();
    TelaRmvOficina rmvofi = new TelaRmvOficina();
    TelaEditOficina edofi = new TelaEditOficina();

    // Variáveis de controle para decidir quais telas ficarão visiveis
    private boolean adiciona = false;
    private boolean edita = false;
    private boolean remove = false;

    public TelaOficinas() {

        // Adição das telas secundárias (OBS: Essas declarações foram feitas aqui por conta da precedencia dos itens)
        add(addofi);
        add(rmvofi);
        add(edofi);

        // Redimencionamento das telas
        addofi.setBounds(303, 200, 294, 200);
        rmvofi.setBounds(303, 200, 294, 200);
        edofi.setBounds(303, 200, 294, 200);

        initComponents();

        // Este método serve para colorir o background de "TelaOficinas"
        this.getContentPane().setBackground(Color.BLACK);

        // Conexão com o BD
        conexao = ModuloConexao.conector();

        editaTabela();
        showAlunos();

    }

    // Método para mostrar todas as oficinas cadastradas
    public static void showAlunos() {
        // Ordenado por "ID"
        String sql = "select id,nome from tboficinas order by id";

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            tblOficinas.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Método responsável por configurar a tabela
    private void editaTabela() {

        tblOficinas.getParent().setBackground(new Color(051, 051, 051));
        tblOficinas.setShowGrid(true);
        tblOficinas.setShowVerticalLines(false);
        tblOficinas.setGridColor(new Color(204, 204, 204));

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
        tblOficinas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(100, 100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 80));

        btnAdiciona.setBackground(new java.awt.Color(51, 153, 255));
        btnAdiciona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Ndpi/img/add-oficina.png"))); // NOI18N
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
        btnEdita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Ndpi/img/edit-oficina.png"))); // NOI18N
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
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Ndpi/img/remove-oficina.png"))); // NOI18N
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
                .addComponent(btnAdiciona, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(btnEdita, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdiciona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEdita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 910, 80);

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80)));

        tblOficinas.setBackground(new java.awt.Color(51, 51, 51));
        tblOficinas.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        tblOficinas.setForeground(new java.awt.Color(255, 255, 255));
        tblOficinas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblOficinas.setRowHeight(60);
        tblOficinas.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tblOficinas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblOficinas.setTableHeader(null);
        tblOficinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblOficinasMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblOficinas);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(117, 79, 666, 531);

        setSize(new java.awt.Dimension(916, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   private void btnAdicionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaActionPerformed

       // Este bloco de códigos faz comparações para ativar ou desativar a janela de "adicionar oficina" 
       // Primeira comparação: verifica se há alguma janela aberta
       if (rmvofi.isVisible() || edofi.isVisible()) {
           addofi.setVisible(true);

           rmvofi.setVisible(false);
           edofi.setVisible(false);

       } else if (adiciona == false) {
           // Segunda comparação: verifica se "adicionar" é invisivel
           addofi.setVisible(true);
           adiciona = true;

       } else {
           // Caso contrário ela simplesmente fecha
           addofi.setVisible(false);
           adiciona = false;

       }

   }//GEN-LAST:event_btnAdicionaActionPerformed

   private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

       // Este bloco de códigos faz comparações para ativar ou desativar a janela de "remover oficina"
       // Primeira comparação: verifica se há alguma janela aberta
       if (addofi.isVisible() || edofi.isVisible()) {

           rmvofi.setVisible(true);

           // Essa comparação serve para averiguar se existe alguma linha da tabela selecionada
           if (tblOficinas.getSelectedRow() >= 0) {

               int i = tblOficinas.getSelectedRow();
               String id = tblOficinas.getModel().getValueAt(i, 0).toString();

               rmvofi.pesquisa(id);
               rmvofi.setTxt(id);
               rmvofi.alteraId(id);

           } else {
               // Caso não existir, simplismente os dados de cada campo são anulados
               rmvofi.pesquisa(null);
               rmvofi.setId(null);
               rmvofi.setTxt(null);

           }

           addofi.setVisible(false);
           edofi.setVisible(false);

       } else if (remove == false) {

           // Segunda comparação: verifica se "remover" é invisivel
           rmvofi.setVisible(true);

           // Essa comparação serve para averiguar se existe alguma linha da tabela selecionada
           if (tblOficinas.getSelectedRow() >= 0) {

               int i = tblOficinas.getSelectedRow();
               String id = tblOficinas.getModel().getValueAt(i, 0).toString();

               rmvofi.alteraId(id);
               rmvofi.pesquisa(id);
               rmvofi.setTxt(id);

           } else {
               // Caso não existir, simplismente os dados de cada campo são anulados
               rmvofi.pesquisa(null);
               rmvofi.setId(null);
               rmvofi.setTxt(null);
           }

           remove = true;

       } else {
           // Caso contrário ela simplesmente fecha
           rmvofi.setVisible(false);
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

       // Este bloco de códigos faz comparações para ativar ou desativar a janela de "editar oficina"
       if (addofi.isVisible() || rmvofi.isVisible()) {

           edofi.setVisible(true);

           // Essa comparação serve para averiguar se existe alguma linha da tabela selecionada
           if (tblOficinas.getSelectedRow() >= 0) {

               int i = tblOficinas.getSelectedRow();
               String id = tblOficinas.getModel().getValueAt(i, 0).toString();

               edofi.setId(id);
               edofi.pesquisa(id);
               edofi.setTxt(id);

           } else {
               // Caso não existir, simplismente os dados de cada campo são anulados
               edofi.pesquisa(null);
               edofi.setId("id");
               edofi.setTxt(null);

           }

           rmvofi.setVisible(false);
           addofi.setVisible(false);

       } else if (edita == false) {

           // Segunda comparação: verifica se "editar" é invisivel
           edofi.setVisible(true);

           // Essa comparação serve para averiguar se existe alguma linha da tabela selecionada
           if (tblOficinas.getSelectedRow() >= 0) {

               int i = tblOficinas.getSelectedRow();
               String id = tblOficinas.getModel().getValueAt(i, 0).toString();

               edofi.setId(id);
               edofi.pesquisa(id);
               edofi.setTxt(id);

           } else {
               // Caso não existir, simplismente os dados de cada campo são anulados
               edofi.pesquisa(null);
               edofi.setId("id");
               edofi.setTxt(null);
           }

           edita = true;

       } else {
           // Caso contrário ela simplesmente fecha
           edofi.setVisible(false);
           edita = false;

       }

   }//GEN-LAST:event_btnEditaActionPerformed

   private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

       tblOficinas.clearSelection();

   }//GEN-LAST:event_formMouseClicked

   private void tblOficinasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOficinasMousePressed
       if (adiciona == true || edita == true || remove == true) {
           addofi.setVisible(false);
           rmvofi.setVisible(false);
           edofi.setVisible(false);

       }
   }//GEN-LAST:event_tblOficinasMousePressed

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
            java.util.logging.Logger.getLogger(TelaOficinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaOficinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaOficinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaOficinas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaOficinas().setVisible(true);
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
    private static javax.swing.JTable tblOficinas;
    // End of variables declaration//GEN-END:variables
}
