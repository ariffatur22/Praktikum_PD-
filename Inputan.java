/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asuransi;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.DB_form;
/**
 *
 * @author Scarlet RaiN
 */
public class Inputan extends javax.swing.JFrame {
    String id;
    DB_form con;
    DefaultTableModel table;
    private Node head = null;

    public Inputan() {
        initComponents();
        con = new DB_form();
        tampil();
        con.Class();
        Fsimpan.setVisible(true);
        Fid.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    public void LinkedListPush(String[] data1) {
        Node lastNode = getLastNode();
        if (lastNode == null) {
            head = new Node(data1);
        } else {
            boolean cekData = true;
            Node Current = head;
            while (Current != null && cekData) {
                if (Current.data[0].equalsIgnoreCase(data1[0])) {
                    cekData = false;
                }
                Current = Current.next;
            }
            if (cekData) {
                lastNode.next = new Node(data1);
            } else {
                Current.data = data1;
            }
        }
    }
    
    private Node getLastNode() {
        if (head == null) {
            return null;
        }
        Node tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }
    
    public void Delete(String id) {
        if (head == null) {
            return;
        }
        Node prevNode = null;
        Node Current = head;
        while (Current.next != null && Current.data[0] != id) {
            prevNode = Current;
            Current = Current.next;
        }
        if (prevNode == null) {
            head = head.next;
            return;
        }
        if (Current == null) {
            System.out.println("A Node With that value does not exit");
            return;
        }
        prevNode.next = Current.next;
    }
    
    public void tampil() {
        Object[] field = {"id", "nama", "alamat", "ttl", "usia","status","pekerjaan", "agama", "telp"};
        table = new DefaultTableModel(null, field);
        TABEL.setModel(table);
        if (head == null) {
            return;
        }
        Node tempNode = head;
        while (tempNode != null) {
            table.addRow(tempNode.data);

            tempNode = tempNode.next;

        }
    }
    
    private void insert() {
        String ID = Fid.getText();
        String NAMA = Fnama.getText();
        String ALAMAT = Falamat.getText();
        String TTL = Fttl.getText();
        String USIA = Fusia.getText();
        String STATUS = (String) this.Fstatus.getSelectedItem();
        String PEKERJAAN = Fpekerjaan.getText();
        String AGAMA = (String) this.Fagama.getSelectedItem();
        String TELP = Ftelp.getText();
        String[] row = {ID, NAMA, ALAMAT, TTL, USIA, STATUS, PEKERJAAN, AGAMA, TELP};
        LinkedListPush(row);
        tampil();
    }
    
    private void simpan() {
        try {
            if (head == null) {
                return;
            }
            Node tempNode = head;
            while (tempNode != null) {
                String id = tempNode.data[0];
                String nama = tempNode.data[1];
                String alamat = tempNode.data[2];
                String ttl = tempNode.data[3];
                String usia = tempNode.data[4];
                String status = tempNode.data[5];
                String pekerjaan = tempNode.data[6];
                String agama = tempNode.data[7];
                String telp = tempNode.data[8];
                String sql = ("insert into inputan values (?,?,?,?,?,?,?,?,?)");
                PreparedStatement p = (com.mysql.jdbc.PreparedStatement) con.cc.prepareStatement(sql);
                p.setString(1, id);
                p.setString(2, nama);
                p.setString(3, alamat);
                p.setString(4, ttl);
                p.setString(5, usia);
                p.setString(6, status);
                p.setString(7, pekerjaan);
                p.setString(8, agama);
                p.setString(9, telp);
                p.executeUpdate();
                tempNode = tempNode.next;
                tampil();
                JOptionPane.showMessageDialog(null, "DATA BERHASIL DI SIMPAN !!!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ADA KESALAHAN ! ! !");
        }
    }
    
    private void setTabel() {
        int row = TABEL.getSelectedRow();
        Fid.setText((String) TABEL.getValueAt(row, 0));
        Fnama.setText((String) TABEL.getValueAt(row, 1));
        Falamat.setText((String) TABEL.getValueAt(row, 2));
        Fttl.setText((String) TABEL.getValueAt(row, 3));
        Fusia.setText((String) TABEL.getValueAt(row, 4));
        Fstatus.setSelectedItem((String) TABEL.getValueAt(row, 5));
        Fpekerjaan.setText((String) TABEL.getValueAt(row, 6));
        Fagama.setSelectedItem((String) TABEL.getValueAt(row, 7));
        Ftelp.setText((String) TABEL.getValueAt(row, 8));
    }

     private void refresh() {
        Fid.setText("");
        Fnama.setText("");
        Falamat.setText(null);
        Fttl.setText(null);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABEL = new javax.swing.JTable();
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
        Finsert = new javax.swing.JButton();
        Fsimpan = new javax.swing.JButton();
        Frefresh = new javax.swing.JButton();
        Fback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 30)); // NOI18N
        jLabel1.setText("INPUT DATA ASURANSI");

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel3.setText("NAMA");

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel4.setText("ALAMAT");

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel5.setText("TTL");

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel6.setText("Asuransi");

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        jLabel7.setText("STATUS");

        TABEL.setBackground(new java.awt.Color(0, 0, 0));
        TABEL.setFont(new java.awt.Font("Tempus Sans ITC", 1, 11)); // NOI18N
        TABEL.setForeground(new java.awt.Color(204, 0, 0));
        TABEL.setModel(new javax.swing.table.DefaultTableModel(
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
        TABEL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABELMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABEL);

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

        Finsert.setBackground(new java.awt.Color(0, 0, 0));
        Finsert.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        Finsert.setForeground(new java.awt.Color(204, 0, 0));
        Finsert.setText("INSERT");
        Finsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinsertActionPerformed(evt);
            }
        });

        Fsimpan.setBackground(new java.awt.Color(0, 0, 0));
        Fsimpan.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        Fsimpan.setForeground(new java.awt.Color(204, 0, 0));
        Fsimpan.setText("SIMPAN");
        Fsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FsimpanActionPerformed(evt);
            }
        });

        Frefresh.setBackground(new java.awt.Color(0, 0, 0));
        Frefresh.setFont(new java.awt.Font("Tempus Sans ITC", 1, 12)); // NOI18N
        Frefresh.setForeground(new java.awt.Color(204, 0, 0));
        Frefresh.setText("REFRESH");
        Frefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrefreshActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Fid)
                                    .addComponent(Fnama)
                                    .addComponent(Falamat)
                                    .addComponent(Fttl, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                    .addComponent(Fusia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Fstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Fpekerjaan)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Ftelp, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Fagama, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(299, 411, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Finsert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fsimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Frefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fback, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Fid, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Fnama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Falamat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Fttl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Fusia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Fstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(Fpekerjaan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Fagama, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Ftelp, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Fback)
                    .addComponent(Frefresh)
                    .addComponent(Fsimpan)
                    .addComponent(Finsert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void FinsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinsertActionPerformed
        insert();
    }//GEN-LAST:event_FinsertActionPerformed

    private void FsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FsimpanActionPerformed
        simpan();
    }//GEN-LAST:event_FsimpanActionPerformed

    private void FrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrefreshActionPerformed
       refresh();
    }//GEN-LAST:event_FrefreshActionPerformed

    private void FbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FbackActionPerformed
        MenuUtama zz;
        zz = new MenuUtama();;
        zz.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_FbackActionPerformed

    private void TABELMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELMouseClicked
        setTabel();
    }//GEN-LAST:event_TABELMouseClicked

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
            java.util.logging.Logger.getLogger(Inputan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inputan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inputan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inputan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inputan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Fagama;
    private javax.swing.JTextField Falamat;
    private javax.swing.JButton Fback;
    private javax.swing.JTextField Fid;
    private javax.swing.JButton Finsert;
    private javax.swing.JTextField Fnama;
    private javax.swing.JTextField Fpekerjaan;
    private javax.swing.JButton Frefresh;
    private javax.swing.JButton Fsimpan;
    private javax.swing.JComboBox<String> Fstatus;
    private javax.swing.JTextField Ftelp;
    private javax.swing.JTextField Fttl;
    private javax.swing.JTextField Fusia;
    private javax.swing.JTable TABEL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
