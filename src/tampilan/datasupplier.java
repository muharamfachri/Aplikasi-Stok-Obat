/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

/**
 *
 * @author user
 */
public class datasupplier extends javax.swing.JFrame {
private Connection conn = koneksi.connect();
    private DefaultTableModel tabmode;
    
    
    
    public datasupplier() {
        initComponents();
        datatable();
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) /2,
        (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight())/2);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDataSupplier = new javax.swing.JTable();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        cmdCetak1 = new javax.swing.JButton();
        txtKdSupplier = new javax.swing.JTextField();
        lblKdBarang1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNmSupplier = new javax.swing.JTextField();
        lblNmBarang1 = new javax.swing.JLabel();
        txtTelepon = new javax.swing.JTextField();
        lblHarga1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        txtNmMarketing = new javax.swing.JTextField();
        lblJumlah1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Stok Obat Klinik Tine - Data Supplier");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("../img/icon.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(232, 241, 251));

        tabelDataSupplier.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelDataSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDataSupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelDataSupplier);

        btnCari.setBackground(new java.awt.Color(255, 255, 255));
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        cmdCetak1.setBackground(new java.awt.Color(255, 255, 255));
        cmdCetak1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmdCetak1.setText("Print");
        cmdCetak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCetak1ActionPerformed(evt);
            }
        });

        txtKdSupplier.setEditable(false);

        lblKdBarang1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblKdBarang1.setForeground(new java.awt.Color(150, 182, 230));
        lblKdBarang1.setText("Kode Supplier");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(150, 182, 230));
        jLabel6.setText("Data Supplier");

        lblNmBarang1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNmBarang1.setForeground(new java.awt.Color(150, 182, 230));
        lblNmBarang1.setText("Nama Supplier");

        lblHarga1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHarga1.setForeground(new java.awt.Color(150, 182, 230));
        lblHarga1.setText("Nomor Telepon");

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane3.setViewportView(txtAlamat);

        lblJumlah1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblJumlah1.setForeground(new java.awt.Color(150, 182, 230));
        lblJumlah1.setText("Alamat");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(150, 182, 230));
        jLabel1.setText("Nama Marketing");

        btnRefresh.setBackground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(255, 255, 255));
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKeluar.setBackground(new java.awt.Color(255, 255, 255));
        btnKeluar.setText("Kembali");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        btnTambah.setBackground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Buat");
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtCari))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnRefresh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSimpan)
                                .addGap(51, 51, 51)
                                .addComponent(btnUbah))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(btnTambah)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCari)
                        .addGap(53, 53, 53)
                        .addComponent(cmdCetak1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHapus)
                        .addGap(38, 38, 38)
                        .addComponent(btnKeluar)))
                .addGap(84, 84, 84))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(209, 209, 209)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(133, 133, 133)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNmMarketing, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblHarga1)
                                .addComponent(lblKdBarang1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblNmBarang1)
                                    .addGap(34, 34, 34)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNmSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtKdSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(lblJumlah1)
                                .addComponent(jLabel1))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKeluar)
                    .addComponent(btnHapus)
                    .addComponent(btnUbah)
                    .addComponent(btnSimpan)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCetak1))
                .addGap(151, 151, 151))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel6)
                    .addGap(24, 24, 24)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblKdBarang1)
                        .addComponent(txtKdSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNmSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNmBarang1))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHarga1))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblJumlah1)
                            .addGap(90, 90, 90))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNmMarketing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  protected void aktif(){
      
        txtNmSupplier.setEnabled(true);
        txtAlamat.setEnabled(true);
        txtTelepon.setEnabled(true);
        txtKdSupplier.setEnabled(true);
        txtNmMarketing.setEnabled(true);
    }
    protected void kosong(){
        txtKdSupplier.setText("");
        txtNmSupplier.setText("");
        txtAlamat.setText("");
        txtTelepon.setText("");
        txtNmMarketing.setText("");
        txtKdSupplier.requestFocus();
    }
    private void no_supplier(){
        try {
            java.sql.Statement stat = conn.createStatement();
            String sql = "select * from datasupplier order by kd_supp desc";
            ResultSet hasil = stat.executeQuery(sql);
            if(hasil.next()){
                String kd_supp = hasil.getString("kd_supp").substring(3);
                String AN = "" +(Integer.parseInt(kd_supp)+1);
                String Nol = "";
                if(AN.length()==1)
                {Nol="00";}
                else if(AN.length()==2)
                {Nol="0";}
                else if(AN.length()==3)
                {Nol="";}
                txtKdSupplier.setText("SUP"+Nol+AN);
            }else{
                txtKdSupplier.setText("SUP001");
                   }
            hasil.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    protected void datatable(){
        Object[] Baris={"Kode Supplier","Nama Supplier","No. Telepon","Alamat","Nama Marketing"};
        tabmode = new DefaultTableModel(null,Baris);
        tabelDataSupplier.setModel(tabmode);
        String sql = "select * from datasupplier";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String kd_supp = hasil.getString("kd_supp");
                String nm_supp = hasil.getString("nm_supp");
                String no_tlp = hasil.getString("no_tlp");
                String alamat = hasil.getString("alamat");
                String nm_marketing = hasil.getString("nm_marketing");
                String[] data = {kd_supp,nm_supp,no_tlp,alamat,nm_marketing};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
        }
    }
    private void cari() {
        Object header[] = {"Kode Supplier", "Nama Supplier","No. Telepon","Alamat","Nama Marketing"};
        tabmode = new DefaultTableModel(null, header);
        tabelDataSupplier.setModel(tabmode);

        int baris = tabelDataSupplier.getRowCount();
        for (int i = 0; i < baris; i++) {
            tabmode.removeRow(i);
        }

        String sql_select = "select * from datasupplier where kd_supp like '%"+txtCari.getText() +"%' or nm_supp like '%"+txtCari.getText()+"%'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql_select);
            while (rs.next()) {
                String kd_supp = rs.getString("kd_supp");
                String nm_supp = rs.getString("nm_supp");
                String no_tlp = rs.getString("no_tlp");
                String alamat = rs.getString("alamat");
                String nm_marketing = rs.getString("nm_marketing");
                String[] kolom = {kd_supp,nm_supp,no_tlp,alamat,nm_marketing};
                tabmode.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void tabelDataSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataSupplierMouseClicked
         int bar = tabelDataSupplier.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();

        txtKdSupplier.setText(a);
        txtNmSupplier.setText(b);
        txtTelepon.setText(d);
        txtAlamat.setText(c);
        txtNmMarketing.setText(e);
    }//GEN-LAST:event_tabelDataSupplierMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

    
    
    private void cmdCetak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCetak1ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Laporan Pengguna");
        MessageFormat footer = new MessageFormat("page (0, number,integer)");
        try {
            tabelDataSupplier.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        } catch(java.awt.print.PrinterException e) {
            System.err.format("tidak bisa di pritn",e.getMessage());
        }
    }//GEN-LAST:event_cmdCetak1ActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        datatable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String sql = "insert into datasupplier values (?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtKdSupplier.getText());
            stat.setString(2, txtNmSupplier.getText());
            stat.setString(3, txtAlamat.getText());
            stat.setString(4, txtTelepon.getText());
            stat.setString(5, txtNmMarketing.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diSimpan");
            kosong();
            txtKdSupplier.requestFocus();
            datatable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal disimpan"+e);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        String sql = "update datasupplier set nm_supp=?,no_tlp=?,alamat=?,nm_marketing=? where kd_cust='"+txtKdSupplier.getText()+"'";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtNmSupplier.getText());
            stat.setString(2, txtAlamat.getText());
            stat.setString(3, txtTelepon.getText());
            stat.setString(3, txtNmMarketing.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diSimpan");
            kosong();
            txtKdSupplier.requestFocus();
            datatable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal disimpan"+e);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        String sql = "delete from datasupplier where kd_supp='"+txtKdSupplier.getText()+"'";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            int sukses = stat.executeUpdate();
            if(sukses>0){
                JOptionPane.showMessageDialog(null, "Data berhasil diHapus");
                kosong();
                txtKdSupplier.requestFocus();
                datatable();
            }else{
                JOptionPane.showMessageDialog(null, "Data Gagal dihapus");
            }
            conn.close();
            stat.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        int ex= JOptionPane.showConfirmDialog(null,"Apakah Anda akan keluar? ","Anda yakin?",
            JOptionPane.YES_NO_OPTION);
        if(ex==0)
        {
            new menuutama().setVisible(true); 
                    dispose();
}
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        no_supplier();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(datasupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datasupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datasupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datasupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datasupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton cmdCetak1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblHarga1;
    private javax.swing.JLabel lblJumlah1;
    private javax.swing.JLabel lblKdBarang1;
    private javax.swing.JLabel lblNmBarang1;
    private javax.swing.JTable tabelDataSupplier;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtKdSupplier;
    private javax.swing.JTextField txtNmMarketing;
    private javax.swing.JTextField txtNmSupplier;
    private javax.swing.JTextField txtTelepon;
    // End of variables declaration//GEN-END:variables
}
