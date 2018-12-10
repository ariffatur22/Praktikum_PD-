/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asuransi;
import java.sql.*;
import java.text.SimpleDateFormat;
import koneksi.DB_form;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Scarlet RaiN
 */
public class CekData extends javax.swing.JFrame {
    DB_form con;
    private Object[][] tblBiodata = null;
    private String[] label = {"id", "nama", "alamat", "ttl", "usia", "status", "pekerjaan", "agama", "telp"};
    
    public CekData() {
        initComponents();
        con = new DB_form();
        con.Class();
        BacaTabel();
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
            FTABELDATA2.setModel(new DefaultTableModel(tblBiodata, label));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void setTabel() {
        int row = FTABELDATA2.getSelectedRow();
        Fid.setText((String) FTABELDATA2.getValueAt(row, 0));
        Fnama.setText((String) FTABELDATA2.getValueAt(row, 1));
        Falamat.setText((String) FTABELDATA2.getValueAt(row, 2));
        Fttl.setText((String) FTABELDATA2.getValueAt(row, 3));
        Fusia.setText((String) FTABELDATA2.getValueAt(row, 4));
        Fstatus.setSelectedItem((String) FTABELDATA2.getValueAt(row, 5));
        Fpekerjaan.setText((String) FTABELDATA2.getValueAt(row, 6));
        Fagama.setSelectedItem((String) FTABELDATA2.getValueAt(row, 7));
        Ftelp.setText((String) FTABELDATA2.getValueAt(row, 8));
    }
    
    public final void tgl() {
        Date skrg = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd MMMMM yyyy ");
        String tgl = format.format(skrg);
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
     
     private void baru() {
        Fid.setText("");
        Fnama.setText("");
        Falamat.setText("");
        Fttl.setText("");
        Fusia.setText("");
        Fstatus.setSelectedItem(null);
        Fpekerjaan.setText("");
        Fagama.setSelectedItem(null);
        Ftelp.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        FTABELDATA2 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
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
        Fedit = new javax.swing.JButton();
        Frefresh = new javax.swing.JButton();
        Fexit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 0, 0));

        jLabel15.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel15.setText("UPDATE DATA ASURANSI");

        jLabel16.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel16.setText("ID");

        jLabel17.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel17.setText("NAMA");

        jLabel18.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel18.setText("ALAMAT");

        jLabel19.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel19.setText("TTL");

        jLabel20.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel20.setText("USIA");

        jLabel21.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel21.setText("STATUS");

        FTABELDATA2.setBackground(new java.awt.Color(0, 0, 0));
        FTABELDATA2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        FTABELDATA2.setForeground(new java.awt.Color(204, 0, 0));
        FTABELDATA2.setModel(new javax.swing.table.DefaultTableModel(
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
        FTABELDATA2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FTABELDATA2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(FTABELDATA2);

        jLabel22.setFont(new java.awt.Font("Tempus Sans ITC", 1, 10)); // NOI18N
        jLabel22.setText("PEKERJAAN");

        jLabel23.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel23.setText("AGAMA");

        jLabel24.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel24.setText("TELP");

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
        Fdelete.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        Fdelete.setForeground(new java.awt.Color(204, 0, 0));
        Fdelete.setText("DELETE");
        Fdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FdeleteActionPerformed(evt);
            }
        });

        Fedit.setBackground(new java.awt.Color(0, 0, 0));
        Fedit.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        Fedit.setForeground(new java.awt.Color(204, 0, 0));
        Fedit.setText("EDIT");
        Fedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeditActionPerformed(evt);
            }
        });

        Frefresh.setBackground(new java.awt.Color(0, 0, 0));
        Frefresh.setFont(new java.awt.Font("Tempus Sans ITC", 0, 10)); // NOI18N
        Frefresh.setForeground(new java.awt.Color(204, 0, 0));
        Frefresh.setText("REFRESH");
        Frefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Frefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrefreshActionPerformed(evt);
            }
        });

        Fexit.setBackground(new java.awt.Color(0, 0, 0));
        Fexit.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        Fexit.setForeground(new java.awt.Color(204, 0, 0));
        Fexit.setText("BACK");
        Fexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FexitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel15))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Ftelp, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Fid, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Fnama, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Falamat, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Fttl, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Fusia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Fstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Fpekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Fagama, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                                .addComponent(Fdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Fedit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Frefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Fexit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Fid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(Fnama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Falamat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fttl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(Fusia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Fstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fpekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Fagama, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Frefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Fedit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Fdelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ftelp, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(3, 3, 3))
                    .addComponent(Fexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FTABELDATA2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FTABELDATA2MouseClicked
        setTabel();
    }//GEN-LAST:event_FTABELDATA2MouseClicked

    private void FdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FdeleteActionPerformed
        hapus();
    }//GEN-LAST:event_FdeleteActionPerformed

    private void FeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeditActionPerformed
        edit();
    }//GEN-LAST:event_FeditActionPerformed

    private void FrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrefreshActionPerformed
        baru();
    }//GEN-LAST:event_FrefreshActionPerformed

    private void FexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FexitActionPerformed
        MenuUtama zz;
        zz = new MenuUtama();
        zz.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_FexitActionPerformed

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
            java.util.logging.Logger.getLogger(CekData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CekData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CekData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CekData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CekData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable FTABELDATA2;
    private javax.swing.JComboBox<String> Fagama;
    private javax.swing.JTextField Falamat;
    private javax.swing.JButton Fdelete;
    private javax.swing.JButton Fedit;
    private javax.swing.JButton Fexit;
    private javax.swing.JTextField Fid;
    private javax.swing.JTextField Fnama;
    private javax.swing.JTextField Fpekerjaan;
    private javax.swing.JButton Frefresh;
    private javax.swing.JComboBox<String> Fstatus;
    private javax.swing.JTextField Ftelp;
    private javax.swing.JTextField Fttl;
    private javax.swing.JTextField Fusia;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
