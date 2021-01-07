/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

public class dataobat extends javax.swing.JFrame {
private Connection conn = koneksi.connect();
    private DefaultTableModel tabmode;
    
    
    
    public dataobat() {
        initComponents();
        datatable();
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) /2,
        (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight())/2);
    }

     protected void aktif(){
        txtKdObat.setEnabled(true);
        cbJenis.setSelectedItem (true);
        txtNmObat.setEnabled(true);
        txtMerkObat.setEnabled(true);
        txtHarga.setEnabled(true);
    }
    protected void kosong(){
        txtKdObat.setText("");
       cbJenis.setSelectedItem("- Pilih status -");
        txtNmObat.setText("");
        txtMerkObat.setText("");
        tanggal.setDate(null);
        txtJumlah.setText("");
        txtHarga.setText("");
    }
     private void no_obat(){
        try {
            java.sql.Statement stat = conn.createStatement();
            String sql = "select * from dataobat order by kd_obat desc";
            ResultSet hasil = stat.executeQuery(sql);
            if(hasil.next()){
                String kd_obat = hasil.getString("kd_obat").substring(3);
                String AN = "" +(Integer.parseInt(kd_obat)+1);
                String Nol = "";
                if(AN.length()==1)
                {Nol="00";}
                else if(AN.length()==2)
                {Nol="0";}
                else if(AN.length()==3)
                {Nol="";}
                txtKdObat.setText("OB"+Nol+AN);
            }else{
                txtKdObat.setText("OB1");
                   }
            hasil.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    protected void datatable(){
        Object[] Baris={"Kode Obat","Status", "Nama Obat","Merk Obat","Tanggal","Jumlah","Harga"};
        tabmode = new DefaultTableModel(null,Baris);
        tabelDataObat.setModel(tabmode);
        String sql = "select * from dataobat";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String kd_obat = hasil.getString("kd_obat");
                String status = hasil.getString("status");
                String nm_obat = hasil.getString("nm_obat");
                String merk = hasil.getString("merk");
                String tanggal = hasil.getString("tanggal");
                String jml_obat = hasil.getString("jml_obat");
                String harga = hasil.getString("harga");
                String[] data = {kd_obat,status,nm_obat,merk,tanggal,jml_obat,harga};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
        }
    }
     private void cari() {
        Object header[] = {"Kode Obat","Status","Nama Obat","Merk Obat","Jumlah","Harga"};
        tabmode = new DefaultTableModel(null, header);
        tabelDataObat.setModel(tabmode);

        int baris = tabelDataObat.getRowCount();
        for (int i = 0; i < baris; i++) {
            tabmode.removeRow(i);
        }

        String sql_select = "select * from dataobat where kd_obat like '%"+txtCari.getText() +"%' or nm_obat like '%"+txtCari.getText()+"%'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql_select);
            while (rs.next()) {
                String kd_obat = rs.getString("kd_obat");
                String status = rs.getString("status");
                String nm_obat = rs.getString("nm_obat");
                String merk = rs.getString("merk");   
                String jml_obat = rs.getString("jml_obat");
                String harga = rs.getString("harga");
                String[] kolom = {kd_obat,status,nm_obat,merk,jml_obat,harga};
                tabmode.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtKdObat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNmObat = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        btnSegarkan = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDataObat = new javax.swing.JTable();
        cmdCetak1 = new javax.swing.JButton();
        cbJenis = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtMerkObat = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tanggal = new com.toedter.calendar.JDateChooser();

        setTitle("Aplikasi Stok Obat Klinik Tine - Data Obat");
        setBackground(new java.awt.Color(232, 241, 251));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("../img/icon.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(232, 241, 251));
        jPanel1.setPreferredSize(new java.awt.Dimension(701, 596));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(150, 182, 230));
        jLabel8.setText("Kode Obat");
        jLabel8.setToolTipText("");

        txtKdObat.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(150, 182, 230));
        jLabel9.setText("Nama Obat");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(150, 182, 230));
        jLabel10.setText("Jumlah");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(150, 182, 230));
        jLabel11.setText("Harga");

        btnSegarkan.setBackground(new java.awt.Color(255, 255, 255));
        btnSegarkan.setText("Segarkan");
        btnSegarkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSegarkanActionPerformed(evt);
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

        btnKeluar.setBackground(new java.awt.Color(255, 255, 255));
        btnKeluar.setText("Kembali");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(150, 182, 230));
        jLabel12.setText("Data Obat");

        btnCari.setBackground(new java.awt.Color(255, 255, 255));
        btnCari.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tabelDataObat.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelDataObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDataObatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelDataObat);

        cmdCetak1.setBackground(new java.awt.Color(255, 255, 255));
        cmdCetak1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmdCetak1.setText("Print");
        cmdCetak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCetak1ActionPerformed(evt);
            }
        });

        cbJenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Pilih Status -", "Obat Keras", "Obat Ringan" }));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(150, 182, 230));
        jLabel13.setText("Status");
        jLabel13.setToolTipText("");

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

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(150, 182, 230));
        jLabel14.setText("Merk Obat");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(150, 182, 230));
        jLabel15.setText("Kadaluarsa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCari, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                        .addGap(22, 22, 22)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdCetak1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnSegarkan)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSimpan)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnHapus))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtNmObat, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtKdObat, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(btnTambah))
                                                .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtMerkObat, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(63, 109, Short.MAX_VALUE)
                                .addComponent(btnKeluar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addComponent(jLabel12)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtNmObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKdObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(btnTambah)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMerkObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnUbah)
                            .addComponent(btnSegarkan)
                            .addComponent(btnHapus)
                            .addComponent(btnKeluar))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdCetak1))
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSegarkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSegarkanActionPerformed
        datatable();
    }//GEN-LAST:event_btnSegarkanActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String tampilan ="yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal1 = String.valueOf(fm.format(tanggal.getDate()));
        String sql = "insert into dataobat values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtKdObat.getText());
            stat.setString(2, (String)cbJenis.getSelectedItem());
            stat.setString(3, txtNmObat.getText());
            stat.setString(4, txtMerkObat.getText());
            stat.setString(5, tanggal1);
            stat.setString(6, txtJumlah.getText());
            stat.setString(7, txtHarga.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diSimpan");
            kosong();
            txtKdObat.requestFocus();
            datatable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal disimpan"+e);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
       String tampilan ="yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal1 = String.valueOf(fm.format(tanggal.getDate()));
        
        String sql = "update dataobat set status=?,nm_obat=?,merk=?,tanggal=?,jml_obat=?,harga=? where kd_obat='"+txtKdObat.getText()+"'";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, (String)cbJenis.getSelectedItem());
            stat.setString(2, txtNmObat.getText());
            stat.setString(3, txtMerkObat.getText());
            stat.setString(4, tanggal1);
            stat.setString(5, txtJumlah.getText());
            stat.setString(6, txtHarga.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diSimpan");
            kosong();
            txtKdObat.requestFocus();
            datatable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal disimpan"+e);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
   int ex= JOptionPane.showConfirmDialog(null,"Apakah Anda akan keluar? ","Anda yakin?",
            JOptionPane.YES_NO_OPTION);
        if(ex==0)
        {
            new menuutama().setVisible(true); 
                    dispose();
}
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        String sql = "delete from dataobat where kd_obat='"+txtKdObat.getText()+"'";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            int sukses = stat.executeUpdate();
            if(sukses>0){
                JOptionPane.showMessageDialog(null, "Data berhasil diHapus");
                kosong();
                txtKdObat.requestFocus();
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

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

    private void cmdCetak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCetak1ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Data Tabel Obat");
        MessageFormat footer = new MessageFormat("page (0, number,integer)");
        try {
            tabelDataObat.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        } catch(java.awt.print.PrinterException e) {
            System.err.format("tidak bisa di pritn",e.getMessage());
        }
    }//GEN-LAST:event_cmdCetak1ActionPerformed

    private void tabelDataObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataObatMouseClicked
       int bar = tabelDataObat.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        try {
            Date tgl=null;
            tgl = new SimpleDateFormat("yyyy-mm-dd").parse(b);
            tanggal.setDate(tgl);
        }catch (Exception ex){
            System.out.println(ex);
        }
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        
        txtKdObat.setText(a);
        cbJenis.setSelectedItem(b);
        txtNmObat.setText(c);
        txtMerkObat.setText(d);
        txtJumlah.setText(f);
        txtHarga.setText(g);
    }//GEN-LAST:event_tabelDataObatMouseClicked

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        no_obat();
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
            java.util.logging.Logger.getLogger(dataobat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dataobat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dataobat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dataobat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dataobat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSegarkan;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox cbJenis;
    private javax.swing.JButton cmdCetak1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelDataObat;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKdObat;
    private javax.swing.JTextField txtMerkObat;
    private javax.swing.JTextField txtNmObat;
    // End of variables declaration//GEN-END:variables
}
