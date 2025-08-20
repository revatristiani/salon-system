/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ta_salon;

import Config.Koneksi;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class inventory extends javax.swing.JFrame {

    private Connection conn;
    
    
    public inventory() {
        initComponents();
        conn = Koneksi.getkoneksi();
        getData();
        nonAktifButton();
        aktifButton();
        
    }
    
    private void getData() {
        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0);
        
        try {
          Statement statement = (Statement)conn.createStatement();
            ResultSet result = statement.executeQuery("select * from tb_inventoris ");
            while (result.next()){
                int id = result.getInt("id");
                String layanan = result.getString("layanan");
                int harga = result.getInt("harga");
                
                
                Object[] rowData = {id,layanan,harga};
                model.addRow(rowData);
            }
            
            result.close();
            statement.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi kesalahan "+e.getMessage());
        }
        
        
        
    }
    private void resetForm() {
        t_layanan.setText("");
        t_harga.setText("");
        
    }

    private void nonAktifButton() {
        btn_perbarui.setEnabled(false);
        btn_hapus.setEnabled(false);
        
    }

    private void aktifButton() {
        btn_tambah.setEnabled(true);
        btn_batal.setEnabled(true);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_kelola = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        t_cari = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        t_layanan = new javax.swing.JTextField();
        t_harga = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_perbarui = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        btn_kelola.setBackground(new java.awt.Color(0, 0, 0));
        btn_kelola.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_kelola.setForeground(new java.awt.Color(255, 204, 204));
        btn_kelola.setText("ENTER");
        btn_kelola.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 2, true));
        btn_kelola.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_kelola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kelolaActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(226, 202, 218));

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Layanan", "Harga"
            }
        ));
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        t_cari.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        t_cari.setForeground(new java.awt.Color(126, 92, 92));
        t_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cariActionPerformed(evt);
            }
        });
        t_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_cariKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(90, 55, 55), 10, true));
        jPanel2.setForeground(new java.awt.Color(90, 55, 55));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(126, 92, 92));
        jLabel2.setText("Layanan");

        t_layanan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        t_layanan.setForeground(new java.awt.Color(126, 92, 92));
        t_layanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_layananActionPerformed(evt);
            }
        });

        t_harga.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        t_harga.setForeground(new java.awt.Color(126, 92, 92));
        t_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_hargaActionPerformed(evt);
            }
        });

        btn_tambah.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(122, 76, 76));
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_perbarui.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        btn_perbarui.setForeground(new java.awt.Color(122, 76, 76));
        btn_perbarui.setText("Edit");
        btn_perbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbaruiActionPerformed(evt);
            }
        });

        btn_hapus.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(122, 76, 76));
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_batal.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        btn_batal.setForeground(new java.awt.Color(122, 76, 76));
        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(62, 46, 46));
        jLabel1.setText("KELOLA LAYANAN");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(126, 92, 92));
        jLabel5.setText("Harga");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_tambah)
                        .addGap(27, 27, 27)
                        .addComponent(btn_perbarui)
                        .addGap(18, 18, 18)
                        .addComponent(btn_hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_batal)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(t_layanan, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30)
                        .addComponent(t_harga))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_layanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(t_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah)
                    .addComponent(btn_perbarui)
                    .addComponent(btn_hapus)
                    .addComponent(btn_batal))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btn_back.setFont(new java.awt.Font("Broadway", 0, 18)); // NOI18N
        btn_back.setForeground(new java.awt.Color(78, 49, 49));
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 255, 102));
        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(69, 47, 47));
        jLabel6.setText("CARI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(32, 32, 32)
                                .addComponent(t_cari))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(817, 817, 817))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_data.getSelectedRow();
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(this, "pilih data yang ingin dihapus");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "anda yakin mau hapus ?","konfirmasi", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            String id = tbl_data.getValueAt(selectedRow, 0).toString();

            try {
                String sql = "DELETE FROM tb_inventoris WHERE id=?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, id);

                int rowDelete = statement.executeUpdate();
                if(rowDelete > 0){
                    JOptionPane.showMessageDialog(this, "data berhasil di hapus");

                }
                statement.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Terjadi kesalahan "+e.getMessage());
            }

        }
        resetForm();
        getData();
        aktifButton();
        nonAktifButton();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        resetForm();
        aktifButton();
        nonAktifButton();

    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_perbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbaruiActionPerformed
        // TODO add your handling code here:

        int selectedRow = tbl_data.getSelectedRow();
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(this, "pilih data yang ingin diperbarui");
            return;
        }

        String id = tbl_data.getValueAt(selectedRow, 0).toString();
        String layanan = t_layanan.getText();
        String harga = t_harga.getText();

        if(layanan.isEmpty() || harga.isEmpty()){
            JOptionPane.showMessageDialog(null, "tidak boleh kosong!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try{
            String sql = "UPDATE tb_inventoris SET layanan=?, harga=? WHERE id =?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, layanan);
            statement.setString(2, harga);
            statement.setString(3, id);

            int rowUpdated = statement.executeUpdate();
            if(rowUpdated > 0){
                JOptionPane.showMessageDialog(this, "data berhasil diperbarui");
                resetForm();
                getData();
            }
            statement.close();

        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Terjadi kesalahan "+e.getMessage());
        }

    }//GEN-LAST:event_btn_perbaruiActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        
        String layanan = t_layanan.getText();
        String harga = t_harga.getText();

        if(layanan.isEmpty() || harga.isEmpty()){
            JOptionPane.showMessageDialog(null, "tidak boleh kosong!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try{
            String sql = "INSERT INTO tb_inventoris(layanan,harga) VALUES (?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, layanan);
            statement.setString(2, harga);

            int rowInserted = statement.executeUpdate();
            if(rowInserted > 0){
                JOptionPane.showMessageDialog(this, "data berhasil ditambahkan");
                resetForm();
                getData();
            }
            statement.close();

        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Terjadi kesalahan "+e.getMessage());
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void t_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariKeyTyped
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0);

        String cari = t_cari.getText();
        try {
            String sql = "SELECT * FROM tb_inventoris WHERE layanan LIKE ? ";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1,"%" + cari + "%");
            

            ResultSet result = statement.executeQuery();
            while (result.next()){
                int id = result.getInt("id");
                String layanan = result.getString("layanan");
                int harga = result.getInt("harga");

                Object[] rowData = {id,layanan,harga};
                model.addRow(rowData);
            }

            result.close();
            statement.close();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi kesalahan "+e.getMessage());
        }

    }//GEN-LAST:event_t_cariKeyTyped

    private void t_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cariActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_t_cariActionPerformed

    private void t_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_hargaActionPerformed

    private void t_layananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_layananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_layananActionPerformed

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        // TODO add your handling code here:
        int selectedRow = tbl_data.getSelectedRow();
        if(selectedRow != -1 ){
            String layanan = tbl_data.getValueAt(selectedRow, 1).toString();
            String harga = tbl_data.getValueAt(selectedRow, 2).toString();
        
            t_layanan.setText(layanan);
            t_harga.setText(harga);
        }
        btn_tambah.setEnabled(false);
        btn_perbarui.setEnabled(true);
        btn_hapus.setEnabled(true);
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        new pilihan().show();
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_kelolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kelolaActionPerformed
        new inventory().show();
        dispose();
    }//GEN-LAST:event_btn_kelolaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_kelola;
    private javax.swing.JButton btn_perbarui;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextField t_harga;
    private javax.swing.JTextField t_layanan;
    private javax.swing.JTable tbl_data;
    // End of variables declaration//GEN-END:variables

}
   

   

    

