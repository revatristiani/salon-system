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

public class Salon extends javax.swing.JFrame {

    private Connection conn;
    
    
    public Salon() {
        initComponents();
        conn = Koneksi.getkoneksi();
        getData();
        getData2();
        nonAktifButton();
        aktifButton();
        
        
    }
    
    private void getData() {
        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0);
        
        try {
          Statement statement = (Statement)conn.createStatement();
            ResultSet result = statement.executeQuery("select * from tb_crud ");
            while (result.next()){
                int id = result.getInt("id");
                String nama = result.getString("nama");
                String layanan = result.getString("layanan");
                int subtotal = result.getInt("subtotal");
                int bayar = result.getInt("bayar");
                double kembalian = result.getDouble("kembalian");
                
                Object[] rowData = {id,nama,layanan,subtotal,bayar,kembalian};
                model.addRow(rowData);
            }
            
            result.close();
            statement.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi kesalahan "+e.getMessage());
        }
        
    }
    
    private void getData2() {
        DefaultTableModel model = (DefaultTableModel) tbl_data2.getModel();
        model.setRowCount(0);
        
        try {
          Statement statement = (Statement)conn.createStatement();
            ResultSet result = statement.executeQuery("select * from tb_inventoris ");
            while (result.next()){
                String layanan = result.getString("layanan");
                int harga = result.getInt("harga");
                
                
                Object[] rowData = {layanan,harga};
                model.addRow(rowData);
            }
            
            result.close();
            statement.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi kesalahan "+e.getMessage());
        }
        
    }
      private void resetForm() {
        t_nama.setText("");
        t_layanan.setText("");
        t_subtotal3.setText("");
        t_bayar.setText("");
        t_kembalian.setText("");
        
        
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

        jPanel1 = new javax.swing.JPanel();
        t_nama = new javax.swing.JTextField();
        t_layanan = new javax.swing.JTextField();
        t_cari = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        t_bayar = new javax.swing.JTextField();
        t_kembalian = new javax.swing.JTextField();
        t_subtotal3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_hitung = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_data2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data = new javax.swing.JTable();
        btn_batal = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_perbarui = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(226, 202, 218));
        jPanel1.setLayout(null);

        t_nama.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        t_nama.setForeground(new java.awt.Color(92, 57, 57));
        t_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_namaActionPerformed(evt);
            }
        });
        jPanel1.add(t_nama);
        t_nama.setBounds(110, 380, 310, 27);

        t_layanan.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        t_layanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_layananActionPerformed(evt);
            }
        });
        jPanel1.add(t_layanan);
        t_layanan.setBounds(110, 430, 310, 27);

        t_cari.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        t_cari.setForeground(new java.awt.Color(80, 55, 55));
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
        jPanel1.add(t_cari);
        t_cari.setBounds(680, 20, 520, 27);

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(89, 68, 68));
        jLabel7.setText("TABLE TRANSAKSI");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(490, 20, 170, 20);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(114, 85, 76), 4, true));
        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(80, 55, 55));
        jLabel5.setText("Bayar");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(270, 10, 91, 21);

        t_bayar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        t_bayar.setForeground(new java.awt.Color(80, 55, 55));
        t_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_bayarActionPerformed(evt);
            }
        });
        jPanel2.add(t_bayar);
        t_bayar.setBounds(370, 10, 155, 27);

        t_kembalian.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        t_kembalian.setForeground(new java.awt.Color(80, 55, 55));
        t_kembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_kembalianActionPerformed(evt);
            }
        });
        jPanel2.add(t_kembalian);
        t_kembalian.setBounds(370, 100, 155, 27);

        t_subtotal3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        t_subtotal3.setForeground(new java.awt.Color(80, 55, 55));
        jPanel2.add(t_subtotal3);
        t_subtotal3.setBounds(100, 10, 155, 27);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(80, 55, 55));
        jLabel13.setText("Subtotal");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(10, 10, 91, 21);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(80, 55, 55));
        jLabel14.setText("Kembalian");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(260, 100, 91, 21);

        btn_hitung.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        btn_hitung.setForeground(new java.awt.Color(122, 76, 76));
        btn_hitung.setText("Hitung");
        btn_hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hitungActionPerformed(evt);
            }
        });
        jPanel2.add(btn_hitung);
        btn_hitung.setBounds(410, 50, 90, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(550, 370, 550, 140);

        jLabel10.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(89, 68, 68));
        jLabel10.setText("MENU LAYANAN");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(130, 10, 170, 20);

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(92, 57, 57));
        jLabel8.setText("Nama");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 380, 50, 21);

        jLabel11.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(92, 57, 57));
        jLabel11.setText("Layanan");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 430, 80, 18);

        btn_back.setFont(new java.awt.Font("Broadway", 0, 18)); // NOI18N
        btn_back.setForeground(new java.awt.Color(78, 49, 49));
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel1.add(btn_back);
        btn_back.setBounds(10, 530, 110, 30);

        tbl_data2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Layanan", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_data2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_data2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_data2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 50, 410, 300);

        tbl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Layanan", "Subtotal", "Bayar", "Kembalian"
            }
        ));
        tbl_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(490, 50, 710, 300);

        btn_batal.setBackground(new java.awt.Color(153, 104, 104));
        btn_batal.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btn_batal.setForeground(new java.awt.Color(255, 255, 255));
        btn_batal.setText("Batal");
        btn_batal.setBorder(null);
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        jPanel1.add(btn_batal);
        btn_batal.setBounds(330, 480, 80, 30);

        btn_tambah.setBackground(new java.awt.Color(153, 104, 104));
        btn_tambah.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("Tambah");
        btn_tambah.setBorder(null);
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        jPanel1.add(btn_tambah);
        btn_tambah.setBounds(30, 480, 80, 30);

        btn_perbarui.setBackground(new java.awt.Color(153, 104, 104));
        btn_perbarui.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btn_perbarui.setForeground(new java.awt.Color(255, 255, 255));
        btn_perbarui.setText("Edit");
        btn_perbarui.setBorder(null);
        btn_perbarui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_perbaruiActionPerformed(evt);
            }
        });
        jPanel1.add(btn_perbarui);
        btn_perbarui.setBounds(130, 480, 80, 30);

        btn_hapus.setBackground(new java.awt.Color(153, 104, 104));
        btn_hapus.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("Hapus");
        btn_hapus.setBorder(null);
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        jPanel1.add(btn_hapus);
        btn_hapus.setBounds(230, 480, 80, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1220, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void t_layananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_layananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_layananActionPerformed

    private void t_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cariActionPerformed
        // TODO add your handling code here:
        
    
        
    }//GEN-LAST:event_t_cariActionPerformed

    private void t_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_namaActionPerformed

    private void t_cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_cariKeyTyped
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbl_data.getModel();
        model.setRowCount(0);
        
        String cari = t_cari.getText();
        try {
          String sql = "SELECT * FROM tb_crud WHERE nama LIKE ? OR layanan LIKE ? ";
          PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1,"%" + cari + "%");
            statement.setString(2,"%" + cari + "%");

            ResultSet result = statement.executeQuery();
            while (result.next()){
                int id = result.getInt("id");
                String nama = result.getString("nama");
                String layanan = result.getString("layanan");
                int subtotal = result.getInt("subtotal");
                int bayar = result.getInt("bayar");
                double kembalian  = result.getDouble("kembalian");
                
                Object[] rowData = {id,nama,layanan,subtotal,bayar,kembalian};
                model.addRow(rowData);
            }
            
            result.close();
            statement.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Terjadi kesalahan "+e.getMessage());
        }
        
    }//GEN-LAST:event_t_cariKeyTyped

    private void t_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_bayarActionPerformed

    private void t_kembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_kembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_kembalianActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        new pilihan().show();
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void tbl_data2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_data2MouseClicked
        int selectedRow = tbl_data2.getSelectedRow();
        if(selectedRow != -1 ){
            String layanan = tbl_data2.getValueAt(selectedRow, 0).toString();
            String harga = tbl_data2.getValueAt(selectedRow, 1).toString();
            t_layanan.setText(layanan );
            t_subtotal3.setText(harga );
        }
    }//GEN-LAST:event_tbl_data2MouseClicked

    private void tbl_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dataMouseClicked
        // TODO add your handling code here:
         int selectedRow = tbl_data.getSelectedRow();
        if(selectedRow != -1 ){
            String nama = tbl_data.getValueAt(selectedRow, 1).toString();
            String layanan = tbl_data.getValueAt(selectedRow, 2).toString();
            String subtotal = tbl_data.getValueAt(selectedRow, 3).toString();
            String bayar = tbl_data.getValueAt(selectedRow, 4).toString();
            String kembalian = tbl_data.getValueAt(selectedRow, 5).toString();
            
            t_nama.setText(nama);
            t_layanan.setText(layanan);
            t_subtotal3.setText(subtotal);
            t_bayar.setText(bayar);
            t_kembalian.setText(kembalian);
            
        }
        btn_tambah.setEnabled(false);
        btn_perbarui.setEnabled(true);
        btn_hapus.setEnabled(true);
    }//GEN-LAST:event_tbl_dataMouseClicked

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        resetForm();
        aktifButton();
        nonAktifButton();
        
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        String nama = t_nama.getText();
        String layanan = t_layanan.getText();
        String subtotal = t_subtotal3.getText();
        String bayar = t_bayar.getText();
        String kembalian = t_kembalian.getText();

        if(nama.isEmpty() || layanan.isEmpty() ||  subtotal.isEmpty() || bayar.isEmpty() || kembalian.isEmpty()){
            JOptionPane.showMessageDialog(null, "tidak boleh kosong!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try{
            String sql = "INSERT INTO tb_crud(nama,layanan,subtotal,bayar,kembalian) VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nama);
            statement.setString(2, layanan);
            statement.setString(3, subtotal);
            statement.setString(4, bayar);
            statement.setString(5, kembalian);

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

    private void btn_perbaruiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_perbaruiActionPerformed
         int selectedRow = tbl_data.getSelectedRow();
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(this, "pilih data yang ingin diperbarui");
            return;
        }
        
        String id = tbl_data.getValueAt(selectedRow, 0).toString();
        String nama = t_nama.getText();
        String layanan = t_layanan.getText();
        String subtotal = t_subtotal3.getText();
        String bayar = t_bayar.getText();
        String kembalian = t_kembalian.getText();
        
        if(nama.isEmpty() || layanan.isEmpty() ||  subtotal.isEmpty() || bayar.isEmpty() || kembalian.isEmpty()){
            JOptionPane.showMessageDialog(null, "tidak boleh kosong!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
            try{
            String sql = "UPDATE tb_crud SET nama=?, layanan=?, subtotal=?, bayar=?,kembalian=? WHERE id =?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nama);
            statement.setString(2, layanan);
            statement.setString(3,subtotal);
            statement.setString(4, bayar);
            statement.setString(5, kembalian);
            statement.setString(6, id);
            
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

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        int selectedRow = tbl_data.getSelectedRow();
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(this, "pilih data yang ingin dihapus");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "anda yakin mau hapus ?","konfirmasi", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            String id = tbl_data.getValueAt(selectedRow, 0).toString();
            
            
            try {
                String sql = "DELETE FROM tb_crud WHERE id=?";
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

    private void btn_hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitungActionPerformed

       try {
            
            int angka1 = Integer.parseInt(t_bayar.getText());
            int angka2 = Integer.parseInt(t_subtotal3.getText());
            
              if (angka1 < angka2) {
                 JOptionPane.showMessageDialog(null, "Tidak dapat melakukan transaksi, uang Anda kurang", "Error", JOptionPane.ERROR_MESSAGE);
               } else {
            double hasil = angka1 - angka2;
            t_kembalian.setText(String.valueOf(hasil));
             }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Masukkan angka yang valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_hitungActionPerformed

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
            java.util.logging.Logger.getLogger(Salon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Salon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Salon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Salon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Salon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_hitung;
    private javax.swing.JButton btn_perbarui;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField t_bayar;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextField t_kembalian;
    private javax.swing.JTextField t_layanan;
    private javax.swing.JTextField t_nama;
    private javax.swing.JTextField t_subtotal3;
    private javax.swing.JTable tbl_data;
    private javax.swing.JTable tbl_data2;
    // End of variables declaration//GEN-END:variables
 
}
