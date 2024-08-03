/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package raven.application.form.other.thuoctinh.kieuao;

import com.formdev.flatlaf.FlatClientProperties;
import java.util.List;
import java.util.UUID;
import javax.swing.table.DefaultTableModel;
import raven.entity.KieuAo;
import raven.toast.Notifications;

/**
 *
 * @author Nguyễn Vũ
 */
public class ViewKieuAo extends javax.swing.JPanel {

    /**
     * Creates new form ViewKieuAo
     */
    RepositoryKieuAo rp = new RepositoryKieuAo();
    DefaultTableModel model = new DefaultTableModel();

    public ViewKieuAo() {
        initComponents();
        model = (DefaultTableModel) tbl_kieuao.getModel();
        getAll(rp.getAllKieuAo());
        txt_nameKieuAo.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nhập tên kiểu áo");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_kieuao = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btl_xoa = new javax.swing.JButton();
        btl_lammoi = new javax.swing.JButton();
        btl_sua = new javax.swing.JButton();
        btl_them = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_nameKieuAo = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbl_kieuao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã", "Kiểu Áo"
            }
        ));
        tbl_kieuao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_kieuaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_kieuao);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btl_xoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btl_xoa.setText("Xóa");
        btl_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_xoaActionPerformed(evt);
            }
        });

        btl_lammoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btl_lammoi.setText("Làm mới");

        btl_sua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btl_sua.setText("Sửa");
        btl_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_suaActionPerformed(evt);
            }
        });

        btl_them.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btl_them.setText("Thêm");
        btl_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_themActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tên");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txt_nameKieuAo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btl_xoa)
                    .addComponent(btl_lammoi)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btl_them)
                        .addComponent(btl_sua)))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btl_them)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btl_sua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(btl_xoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btl_lammoi)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nameKieuAo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btl_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_themActionPerformed
        // TODO add your handling code here:

        if (read() != null) {
            if (rp.addKieuAo(read()) > 0) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Thêm thành công");
                getAll(rp.getAllKieuAo());
            } else {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Thêm thất bại");
            }
        }
    }//GEN-LAST:event_btl_themActionPerformed

    private void btl_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_suaActionPerformed
        // TODO add your handling code here:
        int index = tbl_kieuao.getSelectedRow();
        if (index == -1) {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Vui lòng chọn");
        } else {
            if (read() != null) {
                
               String ma = tbl_kieuao.getValueAt(index, 1).toString();
                if (rp.update(ma, read()) > 0) {
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Update thành công");
                    getAll(rp.getAllKieuAo());
                } else {
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Update thất bại");
                }
            }
        }


    }//GEN-LAST:event_btl_suaActionPerformed

    private void tbl_kieuaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kieuaoMouseClicked
        // TODO add your handling code here:

        int i = tbl_kieuao.getSelectedRow();
        txt_nameKieuAo.setText(tbl_kieuao.getValueAt(i, 2).toString());
    }//GEN-LAST:event_tbl_kieuaoMouseClicked

    private void btl_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_xoaActionPerformed
        // TODO add your handling code here:
        
        int index= tbl_kieuao.getSelectedRow();
        
        if(index == -1 ){
              Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Vui lòng chọn");
        }else{
            
            String ma = tbl_kieuao.getValueAt(index, 1).toString();
        if(rp.removeKieuAo(ma) > 0){
             Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Xóa thành công");
             getAll(rp.getAllKieuAo());
        }else{
                         Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Xóa thất bại");
        }
    }
    }//GEN-LAST:event_btl_xoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btl_lammoi;
    private javax.swing.JButton btl_sua;
    private javax.swing.JButton btl_them;
    private javax.swing.JButton btl_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_kieuao;
    private javax.swing.JTextField txt_nameKieuAo;
    // End of variables declaration//GEN-END:variables

    public void getAll(List<KieuAo> list) {
        model.setRowCount(0);
        int stt = 1;
        for (KieuAo ka : list) {
            model.addRow(new Object[]{
                stt++,
                ka.getMa(), ka.getTen()

            });
        }
    }

    KieuAo read() {

        String tenCoAo;
        tenCoAo = txt_nameKieuAo.getText().trim();
        if (tenCoAo.isEmpty()) {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Vui lòng nhập tên tên ");
            txt_nameKieuAo.requestFocus();
            return null;
        }

        if (tenCoAo.matches("[0-9.0]")) {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Vui lòng không nhập số");
            txt_nameKieuAo.requestFocus();
            return null;
        }

        List<KieuAo> list = rp.getAllKieuAo();
        for (KieuAo kieuAo : list) {
            if (tenCoAo.equalsIgnoreCase(kieuAo.getTen())) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Đã có tên này");
                txt_nameKieuAo.requestFocus();
                return null;
            }
        }

        UUID uuid = UUID.randomUUID();
        String ma = uuid.toString();

        return new KieuAo(ma, tenCoAo, true);
    }

}