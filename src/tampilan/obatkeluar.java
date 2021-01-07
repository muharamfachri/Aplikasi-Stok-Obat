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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

/**
 *
 * @author user
 */
public class obatkeluar extends javax.swing.JFrame {
private Connection conn = koneksi.connect();
    private DefaultTableModel tabmode;
    private String tgl;
    int     stok_awal;
    String  ubah;
        
    protected void aktif(){
        txtNmCust.setEnabled(false);
        txtNamaObat.setEnabled(false);
        txtJmlObat.setEnabled(false);
        txtTotalObat.setEnabled(false);
        txtObatKeluar.setEnabled(true);
        txtTotalObat.setEnabled(false);
    }
    protected void kosong(){
        txtNoTransaksi.setText("");
        tanggal.setDate(null);
        cbCustomer.setSelectedItem(null);
        txtNmCust.setText("");
        cbKdObat.setSelectedItem(null);
        txtNamaObat.setText("");
        txtJmlObat.setText("");
        txtObatKeluar.setText("");
        txtTotalObat.setText("");
        txtNoTransaksi.requestFocus();
        cbNmKaryawan.setSelectedItem(null);
    }
    private void no_transaksi(){
     try {
            java.sql.Statement stat = conn.createStatement();
            String sql = "select * from dataobatkeluar order by id desc";
            ResultSet hasil = stat.executeQuery(sql);
            if(hasil.next()){
                String no_trans = hasil.getString("id").substring(2);
                String AN = "" +(Integer.parseInt(no_trans)+1);
                String Nol = "";
                if(AN.length()==1)
                {Nol="000";}
                else if(AN.length()==2)
                {Nol="00";}
                else if(AN.length()==3)
                {Nol="0";}
                else if(AN.length()==4)
                {Nol="";}
                txtNoTransaksi.setText("BK"+Nol+AN);
            }else{
                txtNoTransaksi.setText("BK0001");
                   }
            hasil.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * Creates new form FormDataObatKeluar
     */
     protected void datatable(){
        Object[] baris ={"No Transaksi","Tanggal","Kode Customer","Nama Customer","Kode Obat", "Nama Obat","Jumlah Obat","Obat Keluar","Total Obat","Nama Staff"};
        tabmode = new DefaultTableModel(null,baris);
        tabelDataObatKeluar.setModel(tabmode);
        String sql = "select * from dataobatkeluar";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String id = hasil.getString("id");
                String tgl = hasil.getString("tgl");
                String kd_cust = hasil.getString("kd_cust");
                String nm_cust = hasil.getString("nm_cust");
                String kd_obat = hasil.getString("kd_obat");
                String nm_obat = hasil.getString("nm_obat");
                String jml_stok = hasil.getString("jml_stok");
                String jml_keluar = hasil.getString("jml_keluar");
                String stok_akhir = hasil.getString("stok_akhir");
                String nm_karyawan = hasil.getString("nm_karyawan");
                String[] data = {id,tgl,kd_cust,nm_cust,kd_obat,nm_obat,jml_stok,jml_keluar,stok_akhir,nm_karyawan};
                tabmode.addRow(data);
            }
        } catch (Exception e) {
        }
     }
    public void tampilcombo1(){
        String sql="SELECT * FROM datacustomer";
        try {
            //koneksi();//panggil method koneksidatabase
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
            //Untuk menampilkan Data dari dalam Table di database kedalam ComboBo
            cbCustomer.addItem(hasil.getString("kd_cust"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
        }
    }
    public void tampilcombo2(){
        String sql="SELECT * FROM dataobat";//tampilkan tb_jurusan
        try {
            //koneksi();//panggil method koneksidatabase
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
            //Untuk menampilkan Data dari dalam Table di database kedalam ComboBo
            cbKdObat.addItem(hasil.getString("kd_obat"));
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
        }
    }
    public void tampilcombo3(){
        String sql="SELECT * FROM datakaryawan";//tampilkan tb_jurusan
        try {
            //koneksi();//panggil method koneksidatabase
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
            //Untuk menampilkan Data dari dalam Table di database kedalam ComboBo
            cbNmKaryawan.addItem(hasil.getString("nama"));
            }
            stat.close();
            hasil.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan" +e);
        }
    }
     private void cari() {
        Object header[] = {"No Transaksi","Tanggal","Kode Supplier","Nama Customer","Kode Obat", "Nama Obat","Jumlah Obat","Obat Keluar","Total Stok","Nama Staff"};
        tabmode = new DefaultTableModel(null, header);
        tabelDataObatKeluar.setModel(tabmode);

        int baris = tabelDataObatKeluar.getRowCount();
        for (int i = 0; i < baris; i++) {
            tabmode.removeRow(i);
        }
        String sql_select = "select * from dataobatkeluar where id like '%"+txtCari.getText()
                 +"%' or kd_cust like '%"+txtCari.getText()
                 +"%' or nm_cust like '%"+txtCari.getText()
                 +"%' or kd_obat like '%"+txtCari.getText()
                 +"%' or nm_obat like '%"+txtCari.getText()
                +"%' or nm_karyawan like '%"+txtCari.getText()+"%'";

        
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql_select);
            while (rs.next()) {
                String id = rs.getString("id");
                String tgl = rs.getString("tgl");
                String kd_cust = rs.getString("kd_cust");
                String nm_cust = rs.getString("nm_cust");
                String kd_obat = rs.getString("kd_obat");
                String nm_obat = rs.getString("nm_obat");
                String jml_stok = rs.getString("jml_stok");
                String jml_keluar = rs.getString("jml_keluar");
                String stok_akhir = rs.getString("stok_akhir");
                String nm_karyawan = rs.getString("nm_karyawan");
                String[] kolom = {id,tgl,kd_cust,nm_cust,kd_obat,nm_obat,jml_stok,jml_keluar,stok_akhir,nm_karyawan};
                tabmode.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
     private int cekStok() {
        int stok = 0;
        String total = "SELECT jml_obat from dataobat where kd_obat ='" + cbKdObat.getSelectedItem() + "'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(total);
            while (rs.next()) {
                stok = Integer.parseInt(rs.getString(1));
        }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("" + e.getMessage());
        }
        return stok;
    }
    private void UpdateStok(String ubah) {
        int stokBaru = 0;
        try {
            switch (ubah) {
                case "insert":
                    stokBaru = cekStok()- Integer.parseInt(txtObatKeluar.getText());
                    break;
                case "delete":
                    stokBaru = cekStok() + Integer.parseInt(txtObatKeluar.getText());;
                    break;
            }
            java.sql.Statement stat = conn.createStatement();
            String total = "UPDATE dataobat set jml_obat ='" + stokBaru + "' where kd_obat = '" + cbKdObat.getSelectedItem() + "'";
            stat.executeUpdate(total);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("" + e.getMessage());
        }
    }
    
    
    public obatkeluar() {
        initComponents();
        datatable();
         aktif();
        kosong();
        tampilcombo1();
        tampilcombo2();
        tampilcombo3();
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) /2,
        (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight())/2);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDataObatKeluar = new javax.swing.JTable();
        btnCari = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        cmdCetak1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblKdObat = new javax.swing.JLabel();
        lblTgl = new javax.swing.JLabel();
        lblKdCust = new javax.swing.JLabel();
        lblNmCust = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbNmKaryawan = new javax.swing.JComboBox();
        txtNmCust = new javax.swing.JTextField();
        cbCustomer = new javax.swing.JComboBox();
        txtNoTransaksi = new javax.swing.JTextField();
        cbKdObat = new javax.swing.JComboBox();
        txtNamaObat = new javax.swing.JTextField();
        txtJmlObat = new javax.swing.JTextField();
        txtObatKeluar = new javax.swing.JTextField();
        txtTotalObat = new javax.swing.JTextField();
        btnProses = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblKeluarKdObat = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        tanggal = new com.toedter.calendar.JDateChooser();
        btnKeluar = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Stok Obat Klinik Tine - Data Obat Keluar");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("../img/icon.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(232, 241, 251));

        tabelDataObatKeluar.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelDataObatKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDataObatKeluarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelDataObatKeluar);

        btnCari.setBackground(new java.awt.Color(255, 255, 255));
        btnCari.setText("Cari");
        btnCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCariMouseClicked(evt);
            }
        });
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        cmdCetak1.setBackground(new java.awt.Color(255, 255, 255));
        cmdCetak1.setText("Print");
        cmdCetak1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCetak1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(150, 182, 230));
        jLabel5.setText("Data Obat Keluar");

        lblKdObat.setText("Nomor Transaksi");

        lblTgl.setText("Tanggal");

        lblKdCust.setText("Kode Customer");

        lblNmCust.setText("Nama Customer");

        jLabel1.setText("Nama Karyawan");

        cbNmKaryawan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Staff...." }));
        cbNmKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNmKaryawanActionPerformed(evt);
            }
        });

        txtNmCust.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        cbCustomer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Kode ..." }));
        cbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCustomerActionPerformed(evt);
            }
        });

        txtNoTransaksi.setEditable(false);
        txtNoTransaksi.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        cbKdObat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih Kode Obat" }));
        cbKdObat.setToolTipText("");
        cbKdObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKdObatActionPerformed(evt);
            }
        });

        txtNamaObat.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        txtJmlObat.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        txtObatKeluar.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        txtTotalObat.setDisabledTextColor(new java.awt.Color(102, 102, 102));

        btnProses.setBackground(new java.awt.Color(255, 255, 255));
        btnProses.setText("Proses");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        jLabel6.setText("Total Obat");

        jLabel4.setText("Obat Keluar");

        jLabel3.setText("Jumlah Obat");

        jLabel2.setText("Nama Obat");

        lblKeluarKdObat.setText("Kode Obat");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKdCust)
                            .addComponent(jLabel1)
                            .addComponent(lblNmCust)
                            .addComponent(lblTgl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNmCust, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbNmKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKeluarKdObat)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProses)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNamaObat)
                                .addComponent(txtJmlObat)
                                .addComponent(txtTotalObat)
                                .addComponent(cbKdObat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtObatKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUbah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKeluar)
                                .addGap(204, 204, 204))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(122, 122, 122))))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnCari)
                                    .addGap(31, 31, 31)
                                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmdCetak1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(252, 252, 252)
                            .addComponent(jLabel5))
                        .addComponent(lblKdObat))
                    .addContainerGap(41, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKeluarKdObat)
                    .addComponent(cbKdObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNamaObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtJmlObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtObatKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtTotalObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnProses))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNmCust)
                                    .addComponent(txtNmCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbNmKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTgl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKdCust))))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnKeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5)
                    .addGap(24, 24, 24)
                    .addComponent(lblKdObat)
                    .addGap(265, 265, 265)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cmdCetak1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(85, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void tabelDataObatKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataObatKeluarMouseClicked
        int bar = tabelDataObatKeluar.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        try {
            Date tgl=null;
            tgl = new SimpleDateFormat("yyyy-mm-dd").parse(b);
            tanggal.setDate(tgl);
        }catch (Exception ex){
            System.out.println(ex);
        }
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
        String i = tabmode.getValueAt(bar, 8).toString();
        String j = tabmode.getValueAt(bar, 9).toString();

        txtNoTransaksi.setText(a);
        cbCustomer.setSelectedItem(c);
        txtNmCust.setText(d);
        cbKdObat.setSelectedItem(e);
        txtNamaObat.setText(f);
        txtJmlObat.setText(g);
        txtObatKeluar.setText(h);
        txtTotalObat.setText(i);
        cbNmKaryawan.setSelectedItem(j);
    }//GEN-LAST:event_tabelDataObatKeluarMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cari();
    }//GEN-LAST:event_btnCariActionPerformed

        
    private void cmdCetak1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCetak1ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Data Tabel Obat Keluar");
        MessageFormat footer = new MessageFormat("page (0, number,integer)");
        try {
            tabelDataObatKeluar.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        } catch(java.awt.print.PrinterException e) {
            System.err.format("tidak bisa di pritn",e.getMessage());
        }
    }//GEN-LAST:event_cmdCetak1ActionPerformed

    private void cbNmKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNmKaryawanActionPerformed
        cbNmKaryawan.getSelectedItem();
    }//GEN-LAST:event_cbNmKaryawanActionPerformed

    private void cbKdObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKdObatActionPerformed
        int i = cbKdObat.getSelectedIndex();
        if (i==-1){
            return;
        }
        try {
            String kd = (String) cbKdObat.getSelectedItem();
            java.sql.Statement stat = conn.createStatement();
            String sql = "select * from dataobat where kd_obat=?";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, kd);
            ResultSet rs = ps.executeQuery();
            rs.next();
            txtNamaObat.setText(rs.getString("nm_obat"));
            txtJmlObat.setText(rs.getString("jml_obat"));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cbKdObatActionPerformed

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
       int stok,jmlkeluar,total;
        //baca nilai nilai float dari komponen texttugas
        stok = Integer.parseInt(txtJmlObat.getText().trim());
        //baca nilai float dari komponen txtuts
        jmlkeluar = Integer.parseInt(txtObatKeluar.getText().trim());
        //jumlahkan
        total =  stok - jmlkeluar;
        //tampilkan hasil ke komponen hasil
        txtTotalObat.setText(String.valueOf(total));
    }//GEN-LAST:event_btnProsesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tampilcombo1();
        tampilcombo2();
        tampilcombo3();
        datatable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String tampilan ="yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal1 = String.valueOf(fm.format(tanggal.getDate()));
        ubah = "insert";
        String sql = "insert into dataobatkeluar values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtNoTransaksi.getText());
            stat.setString(2, tanggal1);
            stat.setString(3, (String) cbCustomer.getSelectedItem());
            stat.setString(4, txtNmCust.getText());
            stat.setString(5, (String) cbKdObat.getSelectedItem());
            if cbKdObat ="Pilih Kode Obat"
            JOptionPane.showMessageDialog(null, "Data Gagal disimpan");
            stat.setString(6, txtNamaObat.getText());
            stat.setString(7, txtJmlObat.getText());
            stat.setString(8, txtObatKeluar.getText());
            stat.setString(9, txtTotalObat.getText());
            stat.setString(10, (String) cbNmKaryawan.getSelectedItem());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diSimpan");
            UpdateStok(ubah);
            kosong();
            txtNoTransaksi.requestFocus();
            datatable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal disimpan"+e);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        String tampilan ="yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal1 = String.valueOf(fm.format(tanggal.getDate()));
        
        String sql = "update dataobatkeluar set tgl=?,kd_cust=?,nm_cust=?,kd_obat=?,nm_obat=?,jml_stok=?,jml_keluar=?,stok_akhir=?,nm_karyawan=? where id='"+txtNoTransaksi.getText()+"'";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tanggal1);
            stat.setString(2, (String) cbCustomer.getSelectedItem());
            stat.setString(3, txtNmCust.getText());
            stat.setString(4, (String) cbKdObat.getSelectedItem());
            stat.setString(5, txtNamaObat.getText());
            stat.setString(6, txtJmlObat.getText());
            stat.setString(7, txtObatKeluar.getText());
            stat.setString(8, txtTotalObat.getText());
            stat.setString(9, (String) cbNmKaryawan.getSelectedItem());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diSimpan");
            kosong();
            txtNoTransaksi.requestFocus();
            datatable();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal disimpan"+e);
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        ubah = "delete";
        int ok = JOptionPane.showConfirmDialog(null,"Apakah anda yakin ingin menghapus data?",""
            +"konfirmasi Dialog",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String sql = "delete from dataobatkeluar where id='"+txtNoTransaksi.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                UpdateStok(ubah);
                kosong();
                txtNoTransaksi.requestFocus();
                datatable();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus"+e);
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        int ex= JOptionPane.showConfirmDialog(null,"Apakah Anda akan keluar? ","Anda yakin?",
            JOptionPane.YES_NO_OPTION);
        if(ex==0)
        {
            dispose();
            new menuutama().setVisible(true); }
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        no_transaksi();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahActionPerformed

    private void cbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCustomerActionPerformed
        int i = cbCustomer.getSelectedIndex();
        if (i==-1){
            return;
        }
        try {
            String kd = (String) cbCustomer.getSelectedItem();
            java.sql.Statement stat = conn.createStatement();
            String sql = "select * from datacustomer where kd_cust=?";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, kd);
            ResultSet rs = ps.executeQuery();
            rs.next();
            txtNmCust.setText(rs.getString("nm_cust"));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_cbCustomerActionPerformed

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
            java.util.logging.Logger.getLogger(obatkeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(obatkeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(obatkeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(obatkeluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new obatkeluar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox cbCustomer;
    private javax.swing.JComboBox cbKdObat;
    private javax.swing.JComboBox cbNmKaryawan;
    private javax.swing.JButton cmdCetak1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKdCust;
    private javax.swing.JLabel lblKdObat;
    private javax.swing.JLabel lblKeluarKdObat;
    private javax.swing.JLabel lblNmCust;
    private javax.swing.JLabel lblTgl;
    private javax.swing.JTable tabelDataObatKeluar;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtJmlObat;
    private javax.swing.JTextField txtNamaObat;
    private javax.swing.JTextField txtNmCust;
    private javax.swing.JTextField txtNoTransaksi;
    private javax.swing.JTextField txtObatKeluar;
    private javax.swing.JTextField txtTotalObat;
    // End of variables declaration//GEN-END:variables
}
