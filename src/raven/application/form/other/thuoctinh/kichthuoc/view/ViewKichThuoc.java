package raven.application.form.other.thuoctinh.kichthuoc.view;

import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import raven.application.form.other.thuoctinh.kichthuoc.repository.RepositoryKichThuoc;
import raven.entity.KichThuoc;

/**
 *
 * @author Raven
 */
public class ViewKichThuoc extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel();
    RepositoryKichThuoc rp = new RepositoryKichThuoc();

    public ViewKichThuoc() {
        initComponents();
        model = (DefaultTableModel) tbl_kichthuoc.getModel();
        getAll(rp.getAll());
        txt_stt.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_kichthuoc = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        btl_add = new javax.swing.JButton();
        btl_update = new javax.swing.JButton();
        btl_remove = new javax.swing.JButton();
        btl_new = new javax.swing.JButton();
        txt_stt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_size = new javax.swing.JTextField();
        txt_rongao = new javax.swing.JTextField();
        txt_rongvai = new javax.swing.JTextField();
        txt_daiAo = new javax.swing.JTextField();
        txt_daitay = new javax.swing.JTextField();

        tbl_kichthuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Ma", "Size", "Rộng Áo", "Dài Tay", "Rộng Vai", "Dài Áo"
            }
        ));
        tbl_kichthuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_kichthuocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_kichthuoc);
        if (tbl_kichthuoc.getColumnModel().getColumnCount() > 0) {
            tbl_kichthuoc.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btl_add.setText("Add");
        btl_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_addActionPerformed(evt);
            }
        });

        btl_update.setText("Update");
        btl_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_updateActionPerformed(evt);
            }
        });

        btl_remove.setText("Remove");
        btl_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_removeActionPerformed(evt);
            }
        });

        btl_new.setText("new");
        btl_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_newActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btl_new)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btl_remove)
                        .addComponent(btl_add)
                        .addComponent(btl_update)))
                .addGap(14, 14, 14))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btl_add)
                .addGap(18, 18, 18)
                .addComponent(btl_update)
                .addGap(18, 18, 18)
                .addComponent(btl_remove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btl_new)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        txt_stt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sttActionPerformed(evt);
            }
        });

        jLabel1.setText("STT :");

        jLabel2.setText("Size : ");

        jLabel3.setText("Dài áo :");

        jLabel4.setText("Rộng áo :");

        jLabel5.setText("Rộng vai :");

        jLabel6.setText("Dài tay :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_stt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_rongao, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_size, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txt_daiAo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_rongvai, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txt_daitay, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_stt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(txt_rongao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_rongvai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(txt_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_daitay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_daiAo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btl_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_addActionPerformed
        // TODO add your handling code here:

        if (read() != null) {
            if (rp.addKichThuoc(read()) > 0) {
                JOptionPane.showMessageDialog(btl_new, "thêm thành công");
                System.out.println(read() + " eee");
                getAll(rp.getAll());

            } else {
                JOptionPane.showMessageDialog(btl_new, "thêm thất bại");
            }

        }
    }//GEN-LAST:event_btl_addActionPerformed

    private void btl_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_updateActionPerformed
        // TODO add your handling code here:
        int index = tbl_kichthuoc.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(btl_new, "Vui lòng chọn kích thước ");
        } else {
            String ma = tbl_kichthuoc.getValueAt(index, 1).toString();
            if (rp.update(ma, read()) > 0) {
                JOptionPane.showMessageDialog(btl_new, "update thành công");
                getAll(rp.getAll());
            }
        }
    }//GEN-LAST:event_btl_updateActionPerformed

    private void tbl_kichthuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kichthuocMouseClicked
        // TODO add your handling code here:

        int index = tbl_kichthuoc.getSelectedRow();
        txt_stt.setText(tbl_kichthuoc.getValueAt(index, 1).toString());
        txt_size.setText(tbl_kichthuoc.getValueAt(index, 2).toString());
        txt_rongao.setText(tbl_kichthuoc.getValueAt(index, 3).toString());
        txt_daitay.setText(tbl_kichthuoc.getValueAt(index, 4).toString());
        txt_rongvai.setText(tbl_kichthuoc.getValueAt(index, 5).toString());
        txt_daiAo.setText(tbl_kichthuoc.getValueAt(index, 6).toString());


    }//GEN-LAST:event_tbl_kichthuocMouseClicked

    private void btl_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_removeActionPerformed
        // TODO add your handling code here:

        int i = tbl_kichthuoc.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(btl_new, "Vui lòng chọn kích thước");
        } else {
            String index = tbl_kichthuoc.getValueAt(i, 1).toString();
            if (rp.removeSizeById(index) > 0) {
                JOptionPane.showMessageDialog(btl_new, "xóa thành công");
            } else {
                JOptionPane.showMessageDialog(btl_new, "xóa thất bại");
            }
            getAll(rp.getAll());
        }
    }//GEN-LAST:event_btl_removeActionPerformed

    private void btl_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_newActionPerformed
        // TODO add your handling code here:

        txt_daiAo.setText("");
        txt_daitay.setText("");
        txt_rongao.setText("");
        txt_rongvai.setText("");
        txt_size.setText("");
        txt_stt.setText("");
    }//GEN-LAST:event_btl_newActionPerformed

    private void txt_sttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sttActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sttActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btl_add;
    private javax.swing.JButton btl_new;
    private javax.swing.JButton btl_remove;
    private javax.swing.JButton btl_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_kichthuoc;
    private javax.swing.JTextField txt_daiAo;
    private javax.swing.JTextField txt_daitay;
    private javax.swing.JTextField txt_rongao;
    private javax.swing.JTextField txt_rongvai;
    private javax.swing.JTextField txt_size;
    private javax.swing.JTextField txt_stt;
    // End of variables declaration//GEN-END:variables

    public void getAll(List<KichThuoc> list) {
        model.setRowCount(0);
        int stt = 1;
        for (KichThuoc kichThuoc : list) {
            model.addRow(kichThuoc.toDaTaRow());
        }
    }

    KichThuoc read() {

        String ma, size;
        String rongAo, daiAo, rongVai, daiTay;

        UUID idMa = UUID.randomUUID();
        ma = idMa.toString();

        size = txt_size.getText().trim();
        if (size.isEmpty()) {
            JOptionPane.showMessageDialog(btl_new, "Vui lòng nhập size");
            txt_size.requestFocus();
            return null;
        }

        daiAo = txt_daiAo.getText().trim();
        if (daiAo.isEmpty()) {
            JOptionPane.showMessageDialog(btl_new, "Vui lòng nhập size");
            txt_daiAo.requestFocus();
            return null;
        }

        rongAo = txt_rongao.getText().trim();
        if (rongAo.isEmpty()) {
            JOptionPane.showMessageDialog(btl_new, "vui long nhập rong áo");
            txt_rongao.requestFocus();
            return null;
        }

        rongVai = txt_rongvai.getText().trim();
        if (rongVai.isEmpty()) {
            JOptionPane.showMessageDialog(btl_new, "vui long nhập rộng vai");
            txt_rongao.requestFocus();
            return null;
        }

        daiTay = txt_daitay.getText().trim();
        if (daiTay.isEmpty()) {
            JOptionPane.showMessageDialog(btl_new, "vui lòng nhâp độ dài tay");
            txt_daitay.requestFocus();
            return null;
        }

        if (!daiTay.matches("[0-9.0]+")) {
            JOptionPane.showMessageDialog(btl_new, "vui lòng nhâpj sô lớn hơn 0");
            txt_daitay.requestFocus();
            return null;
        }

        return new KichThuoc(ma, size, Double.valueOf(rongAo), Double.valueOf(daiAo),
                Double.valueOf(rongVai), Double.valueOf(daiTay), true);
    }
    
}
