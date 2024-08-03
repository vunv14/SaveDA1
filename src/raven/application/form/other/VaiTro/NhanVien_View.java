/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package raven.application.form.other.VaiTro;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import javax.swing.table.DefaultTableModel;
import raven.application.form.other.VaiTro.repository.RepositoryNhanVien;
import raven.entity.VaiTro;
import raven.toast.Notifications;

import java.text.SimpleDateFormat;
import java.sql.Date;

import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import raven.application.form.other.QR.View_QR;
import utils.EmailService;
import utils.ExcelHelper;

/**
 *
 * @author Nguyen Nam Truong
 */
public class NhanVien_View extends javax.swing.JPanel {

    private RepositoryNhanVien p = new RepositoryNhanVien();
    private EmailService e = new EmailService();
                
    private  Integer idNVL;
    private Integer idNVN;
    /**
     * Creates new form NhanVien_View
     */
    public NhanVien_View() {
        initComponents();
        loadData(p.getAll());
       // loadDataV2();
        loadData();
        setPlaceholderForTxt6();
    }

    public void loadData() {
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.setRowCount(0);
        int count = 1;
        for (VaiTro x : p.getAll()) {
            dtm.addRow(new Object[]{
                ++count,
               "NV"+ x.getId(),
                x.getHoTen(),
                x.getSdt(),
                x.getDiaChi(),
                //x.getCccd(),
                 x.getEmail(),
                x.getGioiTinh() ? "Nữ" : "Nam",
                x.getNgaySinh(),
                x.getChucVu() ? "ADMIN" : "Nhân Viên",
                x.getTrangThai() ? "Nghỉ Làm" : "Đang Làm"
            });
        }

    }

   public Boolean check() {
    if (txt1.getText().equals("")) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Chưa nhập họ tên!");
        return false;
    }
    if (txt2.getText().equals("")) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Chưa nhập số điện thoại!");
        return false;
    }
    if (!txt2.getText().matches("^09\\d{8}$")) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Số điện thoại phải bắt đầu bằng 09 và có 10 chữ số!");
        return false;
    }
    if (txt3.getText().equals("")) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Bạn chưa nhập địa chỉ!");
        return false;
    }
    if (txt4.getText().equals("")) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Bạn chưa nhập số căn cước!");
        return false;
    }
    if (txt4.getText().length() != 11) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Số căn cước phải có 11 chữ số!");
        return false;
    }
    if (!(jRadioButton1.isSelected() || jRadioButton2.isSelected())) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Chưa chọn giới tính!");
        return false;
    }
 if (txt5.getDate() == null) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Chưa nhập năm sinh!");
        return false;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String formattedDate = dateFormat.format(txt5.getDate());
    if (!formattedDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Bạn phải nhập đúng định dạng yyyy-mm-dd!");
        return false;
    }
    if (!txt8.getText().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Bạn phải nhập đúng định dạng email!");
    return false;
    }
    if (txt8.getText().equals("")) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Bạn chưa nhập email!");
        return false;
    }

    return true;
}
   
      public Boolean checkV2() {
    if (txt1.getText().equals("")) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Chưa nhập họ tên!");
        return false;
    }
    if (txt2.getText().equals("")) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Chưa nhập số điện thoại!");
        return false;
    }
    if (!txt2.getText().matches("^09\\d{8}$")) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Số điện thoại phải bắt đầu bằng 09 và có 10 chữ số!");
        return false;
    }
    if (txt3.getText().equals("")) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Bạn chưa nhập địa chỉ!");
        return false;
    }
    if (!(jRadioButton1.isSelected() || jRadioButton2.isSelected())) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Chưa chọn giới tính!");
        return false;
    }
 if (txt5.getDate() == null) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Chưa nhập năm sinh!");
        return false;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String formattedDate = dateFormat.format(txt5.getDate());
    if (!formattedDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Bạn phải nhập đúng định dạng yyyy-mm-dd!");
        return false;
    }
    if (!txt8.getText().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
    Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Bạn phải nhập đúng định dạng email!");
    return false;
    }
    if (txt8.getText().equals("")) {
        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Bạn chưa nhập email!");
        return false;
    }

    return true;
}
   
   
   

    public void clear() {
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        buttonGroup3.clearSelection();
        txt5.setDateFormatString("");
        txt6.setText("Tìm theo SDT, CCCD, Họ tên");
        txt6.setForeground(Color.GRAY); // Đặt màu chữ placeholder
        txt8.setText("");
    // Thêm sự kiện focus listener cho txt6
    txt6.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent evt) {
            if (txt6.getText().equals("Tìm theo SDT, CCCD, Họ tên")) {
                txt6.setText("");
                txt6.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent evt) {
            if (txt6.getText().isEmpty()) {
                txt6.setText("Tìm theo SDT, CCCD, Họ tên");
                txt6.setForeground(Color.GRAY);
            }
        }
    });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        txt4 = new javax.swing.JTextField();
        txt2 = new javax.swing.JTextField();
        txt3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt7 = new javax.swing.JPasswordField();
        txt5 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        txt8 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt6 = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();

        jButton1.setText("Xoá");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("xuất Excel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Làm mới");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã NV", "Họ Tên", " SDT", "Địa Chỉ", " Email", "Giới Tính", " Ngày Sinh", " Chức Vụ ", "Trạng Thái "
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1087, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh Sách Nhân Viên ", jPanel1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setText("      Quản Lý Nhân Viên");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Nữ");

        jLabel6.setText("Giới Tính");

        jLabel3.setText("SDT");

        jLabel8.setText("Địa Chỉ");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Nam");

        jLabel2.setText("Ho Ten");

        jLabel7.setText("Ngày Sinh");

        jLabel12.setText("Mật Khẩu");

        txt5.setDateFormatString("yyyy-MM-dd");

        jLabel13.setText("email");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt8)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        jTabbedPane3.addTab("Thông Tin Nhân Viên", jPanel4);

        jLabel10.setText("Tìm kiếm");

        jLabel9.setText("Giới Tính");

        txt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt6ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Nam");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Nữ");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Tất Cả");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jLabel11.setText("Chức Vụ");

        buttonGroup3.add(jRadioButton6);
        jRadioButton6.setText("Admin");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton7);
        jRadioButton7.setText("Nhân Viên");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton8);
        jRadioButton8.setText("Tất Cả");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jRadioButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton8))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton4)
                        .addComponent(jRadioButton5))
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton8))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );

        jButton7.setText("Quét");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(172, 172, 172)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1093, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(379, 379, 379))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(495, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int i = jTable2.getSelectedRow();
if (i != -1) {
    // Hiển thị hộp thoại xác nhận cho người dùng trước khi xóa
    int confirmation = JOptionPane.showConfirmDialog(
            this,
            "Bạn có chắc chắn muốn xóa mục này không?",
            "Xác nhận xóa",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
    );

    if (confirmation == JOptionPane.YES_OPTION) {
        try {
            VaiTro x = p.getAll().get(i);
            p.delete(x.getId());
            loadData();
//            loadDataV2();
            
            Notifications.getInstance()
                    .show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Xóa thành công!");
        } catch (Exception e) {
            Notifications.getInstance()
                    .show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Xóa thất bại: " + e.getMessage());
        }
    } else {
        Notifications.getInstance()
                .show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Thao tác xóa đã bị hủy.");
    }
} else {
    Notifications.getInstance()
            .show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Vui lòng chọn mục để xóa.");
}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      if (check()) {
    int confirmation = JOptionPane.showConfirmDialog(
            this,
            "Bạn có chắc chắn muốn thêm dữ liệu này không?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
    );

    if (confirmation == JOptionPane.YES_OPTION) {
        try {
            String hoTen = txt1.getText();
            String sdt = txt2.getText();
            String diaChia = txt3.getText();
            String cccd = txt4.getText();
            Boolean gioiTinh = jRadioButton1.isSelected() ? false : true;
           // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
              java.util.Date utilDate = txt5.getDate();
            java.sql.Date ngaySinh = new java.sql.Date(utilDate.getTime());
            String matKhau = txt7.getText();
            String email = txt8.getText();
          //  VaiTro x = new VaiTro(gioiTinh, sdt, (java.sql.Date) ngaySinh, cccd, diaChia, hoTen, matKhau,email);
            VaiTro x = new VaiTro(gioiTinh, sdt, ngaySinh, cccd, diaChia, hoTen, email, matKhau);
          p.addNV(x);
            e.sendEmail(email, matKhau);
            loadData();
            clear();
            Notifications.getInstance()
                    .show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Thêm thành công!");
        } catch (Exception e) {
            Notifications.getInstance()
                    .show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Thêm thất bại: " + e.getMessage());
        }
    } else {
        Notifications.getInstance()
                .show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Thao tác thêm đã bị hủy.");
    }
}



    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    if (checkV2()) {
    // Hiển thị hộp thoại xác nhận cho người dùng trước khi cập nhật
    int confirmation = JOptionPane.showConfirmDialog(
            this,
            "Bạn có chắc chắn muốn cập nhật dữ liệu này không?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
    );

    if (confirmation == JOptionPane.YES_OPTION) {
        try {
            int i = jTable2.getSelectedRow();
            VaiTro x = p.getAll().get(i);
            x.setHoTen(txt1.getText());
            x.setSdt(txt2.getText());
            x.setDiaChi(txt3.getText());
            x.setGioiTinh(jRadioButton1.isSelected() ? false : true);
            java.util.Date utilDate = txt5.getDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            x.setNgaySinh(sqlDate);
            x.setEmail(txt8.getText());
            p.update(x);
            loadData();
            clear();
            Notifications.getInstance()
                    .show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Cập nhật thành công!");
        } catch (Exception e) {
            Notifications.getInstance()
                    .show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Cập nhật thất bại: " + e.getMessage());
        }
    } else {
        Notifications.getInstance()
                .show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Thao tác cập nhật đã bị hủy.");
    }
}



    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       clear();
    }//GEN-LAST:event_jButton5ActionPerformed

    public void loadData(List<VaiTro> vaiTroList) {
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.setRowCount(0);
        int count = 1;
        for (VaiTro x : vaiTroList) {
            dtm.addRow(new Object[]{
                ++count,
               "NV"+ x.getId(),
                x.getHoTen(),
                x.getSdt(),
                x.getDiaChi(),
                //x.getCccd(),
                x.getEmail(),
                x.getGioiTinh() ? "Nữ" : "Nam",
                x.getNgaySinh(),
                x.getChucVu() ? "ADMIN" : "Nhân Viên",
                x.getTrangThai() ? "Nghỉ Làm" : "Đang Làm"
            });
            count++;
        }
    }
    
    private void setPlaceholderForTxt6() {
    txt6.setText("Tìm theo SDT, CCCD, Họ tên");
    txt6.setForeground(Color.GRAY); // Đặt màu chữ placeholder

    txt6.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent evt) {
            if (txt6.getText().equals("Tìm theo SDT, CCCD, Họ tên")) {
                txt6.setText("");
                txt6.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent evt) {
            if (txt6.getText().isEmpty()) {
                txt6.setText("Tìm theo SDT, CCCD, Họ tên");
                txt6.setForeground(Color.GRAY);
            }
        }
    });
}

    
    
    private void txt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt6ActionPerformed

        String keyword = txt6.getText().trim();
    // Kiểm tra nếu keyword là placeholder thì không tìm kiếm
    if(keyword.equals("Tìm theo SDT, CCCD, Họ tên") || keyword.isEmpty()){
        Notifications.getInstance()
                .show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Bạn chưa nhập từ khóa tìm kiếm!");
        return;
    } 

    List<VaiTro> results = p.searchVaiTro(keyword);
    if(!results.isEmpty()){
        loadData(results);
        Notifications.getInstance()
                .show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Đã tìm thấy trong danh sách!");
    } else {
        Notifications.getInstance()
                .show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Không tìm thấy trong danh sách!");
    }
             
           
    }//GEN-LAST:event_txt6ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
      
        List<VaiTro> result;
        if (jRadioButton3.isSelected()) {
            result = p.getAll().stream()
                    .filter(vaiTro -> !vaiTro.getGioiTinh())
                    .collect(Collectors.toList());
        loadData(result);
              Notifications.getInstance()
             .show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "có trong danh sách!");
        }else{
             Notifications.getInstance()
                        .show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "k có ai trong danh sách!");
        }
       
        
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
          List<VaiTro> result;
        if (jRadioButton4.isSelected()) {
            result = p.getAll().stream()
                    .filter(vaiTro -> vaiTro.getGioiTinh())
                    .collect(Collectors.toList());
              loadData(result);
                Notifications.getInstance()
             .show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "có trong danh sách!");
        } else{
             Notifications.getInstance()
                        .show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "k có ai trong danh sách!");
        }

      
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
       List<VaiTro> list;
       if((!jRadioButton3.isSelected()) && (!jRadioButton4.isSelected())){
//           list = p.getAll().stream().filter((t) -> !t.getGioiTinh() && t.getGioiTinh())
//                   .collect(Collectors.toList());
//           loadData(list);
                list = p.getAll();
                loadData(list);
            Notifications.getInstance()
                        .show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "danh sách nam và nữ!");
       }else{
              Notifications.getInstance()
                        .show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "k có ai trong danh sách!");
       }
        
        
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            ExcelHelper.fillData(jTable2, new File("D:\\demo.xls"), jTable2.getColumnCount() - 1, jTable2.getRowCount());
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Xuất file excel thành công");
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Data saved at "
                    + "'D:\\demo.xls' successfully");
        } catch (HeadlessException ex) {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Xuất file excel thất bại");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
       List<VaiTro> list;
       if(jRadioButton6.isSelected()){
           list = p.getAll().stream().filter((t) -> t.getChucVu()).collect(Collectors.toList());
           loadData(list);
           Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "đã tìm thấy");
       }else{
           Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Không Tìm Thấy");
       }
        
        
        
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
       List<VaiTro> list;
       if(jRadioButton7.isSelected()){
           list = p.getAll().stream().filter((t) -> !t.getChucVu()).collect(Collectors.toList());
           loadData(list);
           Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "đã tìm thấy");
       }else{
           Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Không Tìm Thấy");
       }
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
       List<VaiTro> list;
       if(!(jRadioButton7.isSelected() && jRadioButton6.isSelected())){
           list = p.getAll();
           loadData(list);
           Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "đã tìm thấy");
       }else{
           Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_RIGHT, "Không Tìm Thấy");
       }
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int i = jTable2.getSelectedRow();
        VaiTro x = p.getAll().get(i);
        idNVL = x.getId();
        txt1.setText(x.getHoTen());
        txt2.setText(x.getSdt());
        txt3.setText(x.getDiaChi());
        txt4.setText(x.getCccd());
        jRadioButton1.setSelected(x.getGioiTinh() ? false : true);
        jRadioButton2.setSelected(x.getGioiTinh() ? true : false);
        txt5.setDate(x.getNgaySinh());
        txt8.setText(x.getEmail());
        txt7.setText(x.getMatKhau());
    }//GEN-LAST:event_jTable2MouseClicked

    public void show(VaiTro x){
        idNVL = x.getId();
        txt1.setText(x.getHoTen());
        txt2.setText(x.getSdt());
        txt3.setText(x.getDiaChi());
        txt4.setText(x.getCccd());
        jRadioButton1.setSelected(x.getGioiTinh() ? false : true);
        jRadioButton2.setSelected(x.getGioiTinh() ? true : false);
        txt5.setDate(x.getNgaySinh());
    }
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    View_QR viewQR = new View_QR();
    viewQR.setVisible(true);

    new Thread(() -> {
        while (viewQR.isVisible()) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String cccd = txt4.getText();
        cccd = viewQR.getResultText();
        
        if (cccd != null && !cccd.isEmpty()) {
            System.out.println("CCCD quét được: " + cccd);
            VaiTro employee = p.findby(cccd); // p là đối tượng của lớp chứa phương thức findby
            if (employee != null) {
                JOptionPane.showMessageDialog(this, "Nhân viên đã được tìm thấy.");
                viewQR.stopCamera(); // Đảm bảo camera được dừng
                show(employee); // Cập nhật giao diện với thông tin nhân viên
            } else {
                JOptionPane.showMessageDialog(null, "Nhân viên với CCCD này không được tìm thấy.");
            }
        }
    }).start();
        
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private com.toedter.calendar.JDateChooser txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JPasswordField txt7;
    private javax.swing.JTextField txt8;
    // End of variables declaration//GEN-END:variables
}
