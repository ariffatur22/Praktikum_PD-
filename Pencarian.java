/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asuransi;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.DB_form;

/**
 *
 * @author Scarlet RaiN
 */
public class Pencarian extends javax.swing.JFrame {
    DB_form con;
    private Object[][] tblBiodata = null;
    private String[] label = {"id", "nama", "alamat", "ttl", "usia", "status", "pekerjaan", "agama", "telp"};
    /**
     * Creates new form Pencarian
     */
    public Pencarian() {
        initComponents();
         con = new DB_form();
        con.Class();
        BacaTabel();
        Fcari.setVisible(true);
        Fid.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    private void BacaTabel() {
        try {
            con.ss = (Statement) con.cc.createStatement();
            String sql = "Select * from inputan order By id ";
            con.rs = con.ss.executeQuery(sql);
            ResultSetMetaData m = con.rs.getMetaData();
            int kolom = m.getColumnCount();
            int baris = 0;
            while (con.rs.next()) {
                baris = con.rs.getRow();
            }
            tblBiodata = new Object[baris][kolom];
            int x = 0;
            con.rs.beforeFirst();
            while (con.rs.next()) {
                tblBiodata[x][0] = con.rs.getString("id");
                tblBiodata[x][1] = con.rs.getString("nama");
                tblBiodata[x][2] = con.rs.getString("alamat");
                tblBiodata[x][3] = con.rs.getString("ttl");
                tblBiodata[x][4] = con.rs.getString("usia");
                tblBiodata[x][5] = con.rs.getString("status");
                tblBiodata[x][6] = con.rs.getString("pekerjaan");
                tblBiodata[x][7] = con.rs.getString("agama");
                tblBiodata[x][8] = con.rs.getString("telp");
                x++;
            }
            FTABELDATA.setModel(new DefaultTableModel(tblBiodata, label));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void setTabel() {
        int row = FTABELDATA.getSelectedRow();
        Fid.setText((String) FTABELDATA.getValueAt(row, 0));
        Fnama.setText((String) FTABELDATA.getValueAt(row, 1));
        Falamat.setText((String) FTABELDATA.getValueAt(row, 2));
        Fttl.setText((String) FTABELDATA.getValueAt(row, 3));
        Fusia.setText((String) FTABELDATA.getValueAt(row, 4));
        Fstatus.setSelectedItem((String) FTABELDATA.getValueAt(row, 5));
        Fpekerjaan.setText((String) FTABELDATA.getValueAt(row, 6));
        Fagama.setSelectedItem((String) FTABELDATA.getValueAt(row, 7));
        Ftelp.setText((String) FTABELDATA.getValueAt(row, 8));
    }
    
    private void edit() {
        String id = this.Fid.getText();
        String nama = this.Fnama.getText();
        String alamat = this.Falamat.getText();
        String ttl = this.Fttl.getText();
        String usia = this.Fusia.getText();        
        String status = (String) this.Fstatus.getSelectedItem();
        String pekerjaan = this.Fpekerjaan.getText();
        String agama = (String) this.Fagama.getSelectedItem();
        String telp = this.Ftelp.getText();
        try {
            String sql = "update inputan set nama=?, alamat=?, ttl=?, usia=?, status=?, pekerjaan=?, agama=?, telp=? where id=?";
            PreparedStatement p = (com.mysql.jdbc.PreparedStatement) con.cc.prepareStatement(sql);
            p.setString(9, id);
            p.setString(1, nama);
            p.setString(2, alamat);
            p.setString(3, ttl);
            p.setString(4, usia);
            p.setString(5, status);
            p.setString(6, pekerjaan);
            p.setString(7, agama);
            p.setString(8, telp);
            p.executeUpdate();
            BacaTabel();
            JOptionPane.showMessageDialog(this, "Data berhasil di Edit !!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
     private void hapus() {
        try {
            String sql = "Delete from inputan Where id='" + Fid.getText() + "'";
            con.ss.executeUpdate(sql);
            con.ss.close();

            JOptionPane.showMessageDialog(null, "Data berhasil di Hapus !!");
            BacaTabel();
            Fid.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
       private void cari() {
        try {
            con.ss = con.cc.createStatement();
            String sql = "Select * from inputan Where id like '%" + Fcari.getText() + "%'" + "or nama like '%" + Fcari.getText() + "%'" + "or alamat like '%" + Fcari.getText() + "%'";
            con.rs = con.ss.executeQuery(sql);
            ResultSetMetaData m = con.rs.getMetaData();
            int kolom = m.getColumnCount();
            int baris = 0;
            while (con.rs.next()) {
                baris = con.rs.getRow();
            }
            tblBiodata = new Object[baris][kolom];
            int x = 0;
            con.rs.beforeFirst();
            while (con.rs.next()) {
                tblBiodata[x][0] = con.rs.getString("id");
                tblBiodata[x][1] = con.rs.getString("nama");
                tblBiodata[x][2] = con.rs.getString("alamat");
                tblBiodata[x][3] = con.rs.getString("ttl");
                tblBiodata[x][4] = con.rs.getString("usia");
                tblBiodata[x][5] = con.rs.getString("status");
                tblBiodata[x][6] = con.rs.getString("pekerjaan");
                tblBiodata[x][7] = con.rs.getString("agama");
                tblBiodata[x][8] = con.rs.getString("telp");
                x++;
            }
            FTABELDATA.setModel(new DefaultTableModel(tblBiodata, label));
        } catch (Exception e) {
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        FTABELDATA = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Fid = new javax.swing.JTextField();
        Fnama = new javax.swing.JTextField();
        Falamat = new javax.swing.JTextField();
        Fttl = new javax.swing.JTextField();
        Fusia = new javax.swing.JTextField();
        Fstatus = new javax.swing.JComboBox<>();
        Fpekerjaan = new javax.swing.JTextField();
        Fagama = new javax.swing.JComboBox<>();
        Ftelp = new javax.swing.JTextField();
        Fdelete = new javax.swing.JButton();
        Fback = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Fcari = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel1.setText("PENCARIAN DATA ASURANSI");

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel3.setText("NAMA");

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel4.setText("ALAMAT");

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel5.setText("TTL");

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel6.setText("USIA");

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel7.setText("STATUS");

        FTABELDATA.setBackground(new java.awt.Color(0, 0, 0));
        FTABELDATA.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        FTABELDATA.setForeground(new java.awt.Color(204, 0, 0));
        FTABELDATA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        FTABELDATA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FTABELDATAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(FTABELDATA);

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 10)); // NOI18N
        jLabel8.setText("PEKERJAAN");

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel9.setText("AGAMA");

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel10.setText("TELP");

        Fid.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N

        Fnama.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N

        Falamat.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N

        Fttl.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N

        Fusia.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N

        Fstatus.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        Fstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KAWIN", "BELUM KAWIN", "DUDA", "JANDA" }));

        Fpekerjaan.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N

        Fagama.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        Fagama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ISLAM", "PROTESTAN", "KHATOLIK", "HINDU", "BUDHA" }));

        Ftelp.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N

        Fdelete.setBackground(new java.awt.Color(0, 0, 0));
        Fdelete.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        Fdelete.setForeground(new java.awt.Color(204, 0, 0));
        Fdelete.setText("DELETE");
        Fdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FdeleteActionPerformed(evt);
            }
        });

        Fback.setBackground(new java.awt.Color(0, 0, 0));
        Fback.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        Fback.setForeground(new java.awt.Color(204, 0, 0));
        Fback.setText("BACK");
        Fback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FbackActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("EDIT");

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel11.setText("CARI");

        Fcari.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        Fcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FcariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Fagama, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Ftelp, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)
                                        .addComponent(Fback, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Fdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Fstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Fpekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Fusia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Fttl, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Falamat, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Fnama, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Fid, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Fcari, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap())))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fcari, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Fid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Fnama, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Falamat, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Fttl, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Fusia, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Fstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Fpekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Fagama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Fdelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Ftelp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Fback, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FTABELDATAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FTABELDATAMouseClicked
        setTabel();
    }//GEN-LAST:event_FTABELDATAMouseClicked

    private void FdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FdeleteActionPerformed
        hapus();
    }//GEN-LAST:event_FdeleteActionPerformed

    private void FbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FbackActionPerformed
        MenuUtama zz;
        zz = new MenuUtama();;
        zz.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_FbackActionPerformed

    private void FcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FcariActionPerformed
        cari();
    }//GEN-LAST:event_FcariActionPerformed

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
            java.util.logging.Logger.getLogger(Pencarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pencarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pencarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pencarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pencarian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable FTABELDATA;
    private javax.swing.JComboBox<String> Fagama;
    private javax.swing.JTextField Falamat;
    private javax.swing.JButton Fback;
    private javax.swing.JTextField Fcari;
    private javax.swing.JButton Fdelete;
    private javax.swing.JTextField Fid;
    private javax.swing.JTextField Fnama;
    private javax.swing.JTextField Fpekerjaan;
    private javax.swing.JComboBox<String> Fstatus;
    private javax.swing.JTextField Ftelp;
    private javax.swing.JTextField Fttl;
    private javax.swing.JTextField Fusia;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
