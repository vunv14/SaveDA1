/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package raven.application.form.other.sanpham.view;

import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.Frame;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import raven.application.Application;
import raven.application.form.other.sanpham.model.ModelSanPham;
import raven.application.form.other.sanpham.repository.RepositorySanPham;
import raven.entity.SanPham;
import raven.entity.VaiTro;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import raven.application.form.other.sanpham.QR.QuetQR;
import raven.application.form.other.sanpham.QR.ThemNhanSP;
import raven.application.form.other.sanpham.formThemNhanh.ThemKichThuocNhanh;
import raven.application.form.other.sanpham.formThemNhanh.ThemNhanhChatLieu;
import raven.application.form.other.sanpham.formThemNhanh.ThemNhanhCoAo;
import raven.application.form.other.sanpham.formThemNhanh.ThemNhanhMauSac;
import raven.application.form.other.sanpham.formThemNhanh.ThemNhanhThuongHieu;
import raven.application.form.other.sanpham.formThemNhanh.ThemNhanhXuatXu;
import raven.application.form.other.sanpham.model.ModelSanPhamCT;
import raven.application.form.other.sanpham.repository.RepositorySanPhamCT;
import raven.application.form.other.thuoctinh.chatlieu.RepositoryChatLieu;
import raven.application.form.other.thuoctinh.kichthuoc.repository.RepositoryKichThuoc;
import raven.application.form.other.thuoctinh.kieuao.RepositoryKieuAo;
import raven.application.form.other.thuoctinh.mau.RepositoryMau;
import raven.application.form.other.thuoctinh.thuonghieu.RepositoryThuongHieu;
import raven.application.form.other.thuoctinh.xuatxu.RepositoryXuatXu;
import raven.entity.ChatLieu;
import raven.entity.KichThuoc;
import raven.entity.KieuAo;
import raven.entity.Mau;
import raven.entity.SanPhamChiTiet;
import raven.entity.ThuongHieu;
import raven.entity.XuatXu;
import raven.toast.Notifications;
     
/**
 *
 *
 * @author Nguyễn Vũ
 */
public class Viewsanpham extends javax.swing.JPanel {

    /**
     * Creates new form Viewsanpham
     */
    

    DefaultTableModel modelSanPham = new DefaultTableModel();
    DefaultTableModel modelSPCT = new DefaultTableModel();
    RepositorySanPham rp = new RepositorySanPham();
    RepositorySanPhamCT rpct = new RepositorySanPhamCT();
    RepositoryChatLieu repositoryChatLieu = new RepositoryChatLieu();
    RepositoryKichThuoc repositoryKichThuoc = new RepositoryKichThuoc();
    RepositoryKieuAo repositoryKieuAo = new RepositoryKieuAo();
    RepositoryMau repositoryMau = new RepositoryMau();
    RepositoryXuatXu repositoryXuatXu = new RepositoryXuatXu();
    RepositoryThuongHieu repositoryThuongHieu = new RepositoryThuongHieu();
    int idSanPham = 0;
    private static final int ITEMS_PER_PAGE = 5;
    private int currentPage = 1;
    private Boolean check = true;
    private boolean isAllSelected = false;
    private List<ModelSanPhamCT> listSelected = new ArrayList<>();
    public Viewsanpham() {
        initComponents();
        modelSanPham = (DefaultTableModel) tbl_sanpham.getModel();
        modelSPCT = (DefaultTableModel) tbl_spct.getModel();
        getAllSanPham(rp.getAllSanPham());
        sp.setVisible(true);
        txt_masanpham.setEditable(false);
//        GetAllSPCT(rpct.getAll());
        chuyen.setVisible(false);
        loadFirstPage(check);
        valueComBoBox();
        getAllSPCT();
        System.out.println(idSanPham + " cccc");
    }

    public void yourMethod() {

        int index = tbl_sanpham.getSelectedRow();
        String ma = tbl_sanpham.getValueAt(index, 1).toString();;

        List<SanPham> list = new RepositorySanPham().sanphambyMa(ma);
        SanPham sanPham = list.get(0);
        idSanPham = sanPham.getId(); // Gán giá trị cho thuộc tính lớp
        System.out.println(idSanPham + "bbbbbb");
        chuyen.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel3 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenuBar6 = new javax.swing.JMenuBar();
        jMenu14 = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();
        jMenuBar7 = new javax.swing.JMenuBar();
        jMenu16 = new javax.swing.JMenu();
        jMenu17 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuBar8 = new javax.swing.JMenuBar();
        jMenu18 = new javax.swing.JMenu();
        jMenu19 = new javax.swing.JMenu();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        spct = new javax.swing.JTabbedPane();
        sp = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_loaisanpham = new javax.swing.JTextField();
        txt_masanpham = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sanpham = new javax.swing.JTable();
        txt_mota = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btl_file = new javax.swing.JButton();
        chuyen = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        sanphamct = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_soluong = new javax.swing.JTextField();
        txt_gia = new javax.swing.JTextField();
        rdo_chatlieu = new javax.swing.JComboBox<>();
        rdo_kichthuoc = new javax.swing.JComboBox<>();
        btl_add = new javax.swing.JButton();
        btl_update = new javax.swing.JButton();
        btl_xoa = new javax.swing.JButton();
        btl_exelspct = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btl_getAllSPCT = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txt_search = new javax.swing.JTextField();
        btl_search = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        rdo_chatLieuFindAll = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        rdo_kichThuocFindAll = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        rdo_thuonghieuFA = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        rdo_mausacFA = new javax.swing.JComboBox<>();
        btl_findAll = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_spct = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        rdo_coao = new javax.swing.JComboBox<>();
        rdo_xuatxu = new javax.swing.JComboBox<>();
        txt_dogiay = new javax.swing.JTextField();
        btl_qr = new javax.swing.JButton();
        btl_quetQR = new javax.swing.JButton();
        btl_dautrang = new javax.swing.JButton();
        btl_trangtruoc = new javax.swing.JButton();
        lbl_trang = new javax.swing.JLabel();
        btl_trangsau = new javax.swing.JButton();
        btl_trangcuoi = new javax.swing.JButton();
        rdo_thuonghieu1 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        rdo_mausac1 = new javax.swing.JComboBox<>();
        cbo_loaisp = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("jMenu5");

        jMenu6.setText("jMenu6");

        jMenu7.setText("File");
        jMenuBar3.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar3.add(jMenu8);

        jMenu9.setText("File");
        jMenuBar4.add(jMenu9);

        jMenu10.setText("Edit");
        jMenuBar4.add(jMenu10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu11.setText("File");
        jMenuBar5.add(jMenu11);

        jMenu12.setText("Edit");
        jMenuBar5.add(jMenu12);

        jMenu13.setText("jMenu13");

        jMenu14.setText("File");
        jMenuBar6.add(jMenu14);

        jMenu15.setText("Edit");
        jMenuBar6.add(jMenu15);

        jMenu16.setText("File");
        jMenuBar7.add(jMenu16);

        jMenu17.setText("Edit");
        jMenuBar7.add(jMenu17);

        jMenu18.setText("File");
        jMenuBar8.add(jMenu18);

        jMenu19.setText("Edit");
        jMenuBar8.add(jMenu19);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Ma sản phẩm");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Loại sản phẩm");

        txt_loaisanpham.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txt_masanpham.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        tbl_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Ma Sản Phẩm", "Loại Sản Phẩm", "Mô Tả", "Số Lượng", "Trạng Thái"
            }
        ));
        tbl_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sanphamMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_sanphamMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sanpham);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Mô tả");

        btl_file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/xlsx.png"))); // NOI18N
        btl_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_fileActionPerformed(evt);
            }
        });

        chuyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/document (1).png"))); // NOI18N
        chuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chuyenActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/new.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/add.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/updated.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/remove (1).png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout spLayout = new javax.swing.GroupLayout(sp);
        sp.setLayout(spLayout);
        spLayout.setHorizontalGroup(
            spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spLayout.createSequentialGroup()
                .addGroup(spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(spLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(spLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_masanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_loaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(spLayout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(spLayout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(spLayout.createSequentialGroup()
                                        .addGap(244, 244, 244)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(85, 85, 85)
                                        .addComponent(btl_file, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(100, 100, 100)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(83, 83, 83)
                                        .addComponent(chuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        spLayout.setVerticalGroup(
            spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_loaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txt_masanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(39, 39, 39)
                .addGroup(spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(spLayout.createSequentialGroup()
                        .addGroup(spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(chuyen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(241, Short.MAX_VALUE))
                    .addGroup(spLayout.createSequentialGroup()
                        .addComponent(btl_file, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        spct.addTab("Sản Phẩm", sp);

        sanphamct.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tên SP");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Số Lượng");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Giá");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Chất liệu");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Kích thước");

        txt_soluong.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txt_gia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_gia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_giaActionPerformed(evt);
            }
        });

        btl_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/add.png"))); // NOI18N
        btl_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_addActionPerformed(evt);
            }
        });

        btl_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/updated.png"))); // NOI18N
        btl_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_updateActionPerformed(evt);
            }
        });

        btl_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/remove (1).png"))); // NOI18N
        btl_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_xoaActionPerformed(evt);
            }
        });

        btl_exelspct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/xlsx.png"))); // NOI18N
        btl_exelspct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_exelspctActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/new.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        btl_getAllSPCT.setText("All SPCT");
        btl_getAllSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_getAllSPCTActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btl_search.setText("search");
        btl_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btl_search)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btl_search))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Chất liệu");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Kích thước");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Thương Hiệu");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Màu sắc");

        btl_findAll.setText("FindAll");
        btl_findAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_findAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdo_kichThuocFindAll, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(rdo_chatLieuFindAll, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rdo_thuonghieuFA, 0, 84, Short.MAX_VALUE)
                    .addComponent(rdo_mausacFA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btl_findAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(rdo_chatLieuFindAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(rdo_thuonghieuFA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(rdo_kichThuocFindAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(rdo_mausacFA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btl_findAll)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tbl_spct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Số Lượng", "Giá", "Tên SP", "Chất Liệu", "Kích Thước", "Thương Hiệu", "Địa Chỉ", "Màu", "Độ Dày Vải", "Loại Cổ Áo", "Trạng Thái", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_spct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_spctMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_spct);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Thương Hiệu");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Xuất Xứ");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Cổ áo");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Độ Dày");

        txt_dogiay.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        btl_qr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/hoadon/icon/qr.png"))); // NOI18N
        btl_qr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_qrActionPerformed(evt);
            }
        });

        btl_quetQR.setBackground(new java.awt.Color(0, 204, 0));
        btl_quetQR.setText("QR");
        btl_quetQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_quetQRActionPerformed(evt);
            }
        });

        btl_dautrang.setText("<<");
        btl_dautrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_dautrangActionPerformed(evt);
            }
        });

        btl_trangtruoc.setText("<");
        btl_trangtruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_trangtruocActionPerformed(evt);
            }
        });

        lbl_trang.setText("1");

        btl_trangsau.setText(">");
        btl_trangsau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_trangsauActionPerformed(evt);
            }
        });

        btl_trangcuoi.setText(">>");
        btl_trangcuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btl_trangcuoiActionPerformed(evt);
            }
        });

        rdo_thuonghieu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_thuonghieu1ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Màu sắc");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/list.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/plus.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/plus.png"))); // NOI18N
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/plus.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/plus.png"))); // NOI18N
        jButton9.setBorder(null);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/plus.png"))); // NOI18N
        jButton11.setBorder(null);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/plus.png"))); // NOI18N
        jButton12.setBorder(null);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/sanpham/iconSanPham/plus.png"))); // NOI18N
        jButton13.setBorder(null);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sanphamctLayout = new javax.swing.GroupLayout(sanphamct);
        sanphamct.setLayout(sanphamctLayout);
        sanphamctLayout.setHorizontalGroup(
            sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sanphamctLayout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(btl_dautrang)
                .addGap(18, 18, 18)
                .addComponent(btl_trangtruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_trang)
                .addGap(18, 18, 18)
                .addComponent(btl_trangsau)
                .addGap(18, 18, 18)
                .addComponent(btl_trangcuoi)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(sanphamctLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sanphamctLayout.createSequentialGroup()
                        .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(229, Short.MAX_VALUE))
                    .addGroup(sanphamctLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btl_add, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btl_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(btl_update, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btl_exelspct, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btl_getAllSPCT)
                        .addGap(48, 48, 48)
                        .addComponent(btl_qr, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(339, 339, 339))))
            .addGroup(sanphamctLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sanphamctLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(sanphamctLayout.createSequentialGroup()
                            .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addGap(20, 20, 20))
                        .addGroup(sanphamctLayout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_soluong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(txt_gia, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dogiay, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdo_thuonghieu1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_loaisp, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addGap(29, 29, 29)
                .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14)
                    .addComponent(jLabel20)
                    .addComponent(jLabel13))
                .addGap(12, 12, 12)
                .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sanphamctLayout.createSequentialGroup()
                        .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sanphamctLayout.createSequentialGroup()
                                .addComponent(rdo_chatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton12))
                            .addGroup(sanphamctLayout.createSequentialGroup()
                                .addComponent(rdo_kichthuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton13))
                            .addGroup(sanphamctLayout.createSequentialGroup()
                                .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(sanphamctLayout.createSequentialGroup()
                                        .addComponent(rdo_mausac1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton9))
                                    .addGroup(sanphamctLayout.createSequentialGroup()
                                        .addComponent(rdo_xuatxu, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton8)))
                                .addGap(22, 22, 22)
                                .addComponent(btl_quetQR, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(sanphamctLayout.createSequentialGroup()
                        .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(sanphamctLayout.createSequentialGroup()
                                .addComponent(rdo_coao, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        sanphamctLayout.setVerticalGroup(
            sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sanphamctLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel8)
                        .addComponent(rdo_chatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbo_loaisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton12))
                .addGap(18, 18, 18)
                .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sanphamctLayout.createSequentialGroup()
                        .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sanphamctLayout.createSequentialGroup()
                                .addComponent(btl_quetQR, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sanphamctLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(sanphamctLayout.createSequentialGroup()
                                        .addComponent(jButton13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton9))
                                    .addGroup(sanphamctLayout.createSequentialGroup()
                                        .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)
                                            .addComponent(rdo_kichthuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 23, Short.MAX_VALUE)
                                        .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(txt_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20)
                                            .addComponent(rdo_mausac1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(29, 29, 29)
                                .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_dogiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel13)
                                        .addComponent(rdo_xuatxu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(27, 27, 27)))
                        .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(rdo_coao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdo_thuonghieu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sanphamctLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(29, 29, 29)
                .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btl_add, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btl_xoa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btl_update)
                    .addComponent(jButton10)
                    .addComponent(btl_qr)
                    .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btl_exelspct)
                        .addComponent(btl_getAllSPCT)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sanphamctLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btl_trangcuoi)
                    .addComponent(btl_trangsau)
                    .addComponent(lbl_trang)
                    .addComponent(btl_dautrang)
                    .addComponent(btl_trangtruoc))
                .addGap(36, 36, 36))
        );

        spct.addTab("Sản Phẩm Chi tiết", sanphamct);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spct, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(spct)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btl_exelspctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_exelspctActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("customer");
                Row rowCol = sheet.createRow(0);

                // Determine which list to use
                List<ModelSanPhamCT> listToExport = listSelected.isEmpty()
                        ? rpct.getAllSPCTById(idSanPham, WIDTH, HEIGHT)
                        : listSelected;

                if (listSelected.isEmpty()) {
                    listToExport.clear();
                } 
                
                
                if(isAllSelected){
                    listSelected.clear();
                }
                    if(isAllSelected){
                          List<ModelSanPhamCT> allData = rpct.getAllSPCTById(idSanPham);
                    for (ModelSanPhamCT spct : allData) {
                        listToExport.add(spct);
                    }
                    }
                System.out.println(listToExport.toString() + "YYYYYYY");
                System.out.println(listToExport.size() + "DỘ Daiiiiiiiiiiiiiiiii");

                if (!listToExport.isEmpty()) {
                    // Use the first object in the selected list to get field names
                    ModelSanPhamCT firstObject = listToExport.get(0);
                    Field[] fields = firstObject.getClass().getDeclaredFields();

                    // Create header row based on field names
                    for (int i = 0; i < fields.length; i++) {
                        Cell cell = rowCol.createCell(i);
                        cell.setCellValue(fields[i].getName());
                    }

                    // Iterate over the listToExport to create rows
                    for (int i = 0; i < listToExport.size(); i++) {
                        ModelSanPhamCT item = listToExport.get(i);
                        Row row = sheet.createRow(i + 1);

                        for (int j = 0; j < fields.length; j++) {
                            fields[j].setAccessible(true);
                            Cell cell = row.createCell(j);
                            Object value = fields[j].get(item);  // Get the value of the field for the current item
                            if (value != null) {
                                cell.setCellValue(value.toString());
                            } else {
                                cell.setCellValue("");  // Ensure empty cells are handled
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Danh sách xuất trống");
                }
                FileOutputStream out = new FileOutputStream(saveFile);
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());

                
//                listToExport.clear();
            } else {
                JOptionPane.showMessageDialog(this, "Xuất excel thất bại");
            }

                    
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Viewsanpham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Viewsanpham.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_btl_exelspctActionPerformed

    private void btl_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_addActionPerformed
        // TODO add your handling code here:
        if (readSPCT(idSanPham) != null) {
            if (rpct.addSanPhamCT(readSPCT(idSanPham)) > 0) {
                JOptionPane.showMessageDialog(null, "thêm thành công");
                if (check) {
                    int totalCount = rpct.getTotalCount(idSanPham);
                    int offset = (currentPage - 1) * ITEMS_PER_PAGE;
                    List<ModelSanPhamCT> list = rpct.getAllSPCTById(idSanPham, ITEMS_PER_PAGE, offset);
                    if (tbl_sanpham.getRowCount() > 0) {
                        tbl_sanpham.setRowSelectionInterval(0, 0);
                        yourMethod();
                        updateTable(totalCount, list);
                    } else {
                        System.out.println("Bảng không có dữ liệu.");
                    }
                } else {

                }

//                System.out.println(idSanPham+ "aaaaaaaaa");
            }
        }
    }//GEN-LAST:event_btl_addActionPerformed

    private void btl_getAllSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_getAllSPCTActionPerformed
        int offset = (currentPage - 1) * ITEMS_PER_PAGE;
        if (offset < 0) {
            offset = 0;
        }

        int totalCount = rpct.getTotalCountAll();
        List<ModelSanPhamCT> list = rpct.getAll(ITEMS_PER_PAGE, offset);
        updateTable(totalCount, list);
    }//GEN-LAST:event_btl_getAllSPCTActionPerformed

    private void btl_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_xoaActionPerformed
        // TODO add your handling code here:
        int index = tbl_spct.getSelectedRow();
        String ma = tbl_spct.getValueAt(index, 1).toString();
        System.out.println(ma + "nvv");
        if (rpct.removeSanPhamCT(ma) > 0) {
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            if (check) {
                int totalCount = rpct.getTotalCount(idSanPham);
                int offset = (currentPage - 1) * ITEMS_PER_PAGE;
                List<ModelSanPhamCT> list = rpct.getAllSPCTById(idSanPham, ITEMS_PER_PAGE, offset);
                if (tbl_sanpham.getRowCount() > 0) {
                    tbl_sanpham.setRowSelectionInterval(0, 0);
                    yourMethod();
                    updateTable(totalCount, list);
                } else {
                    System.out.println("Bảng không có dữ liệu.");
                }
            } 

        } else {
            JOptionPane.showMessageDialog(null, "xóa thất bại");
        }
    }//GEN-LAST:event_btl_xoaActionPerformed

    private void tbl_spctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_spctMouseClicked
        // TODO add your handling code here:
        int index = tbl_spct.getSelectedRow();
        txt_soluong.setText(tbl_spct.getValueAt(index, 2).toString());
        txt_gia.setText(tbl_spct.getValueAt(index, 3).toString());
        txt_dogiay.setText(tbl_spct.getValueAt(index, 10).toString());

        String cbthuongHieu = tbl_spct.getValueAt(index, 7).toString();
        for (int i = 0; i < rdo_thuonghieuFA.getItemCount(); i++) {
            String item = rdo_thuonghieuFA.getItemAt(i).toString();
            if (item.equalsIgnoreCase(cbthuongHieu)) {
                rdo_thuonghieuFA.setSelectedIndex(i);
                break;
            }
        }

        String cbChatLieu = tbl_spct.getValueAt(index, 5).toString();
        for (int i = 0; i < rdo_chatlieu.getItemCount(); i++) {
            String item = rdo_chatlieu.getItemAt(i).toString();
            if (item.equalsIgnoreCase(cbChatLieu)) {
                rdo_chatlieu.setSelectedIndex(i);
                break;
            }
        }

        String cbkichThuoc = tbl_spct.getValueAt(index, 6).toString();
        for (int i = 0; i < rdo_kichthuoc.getItemCount(); i++) {
            String item = rdo_kichthuoc.getItemAt(i).toString();
            if (item.equalsIgnoreCase(cbkichThuoc)) {
                rdo_kichthuoc.setSelectedIndex(i);
                break;
            }
        }

        String cbMauSac = tbl_spct.getValueAt(index, 9).toString();
        for (int i = 0; i < rdo_mausacFA.getItemCount(); i++) {
            String item = rdo_mausacFA.getItemAt(i).toString();
            if (item.equalsIgnoreCase(cbMauSac)) {
                rdo_mausacFA.setSelectedIndex(i);
                break;
            }
        }

        String cbXuatXu = tbl_spct.getValueAt(index, 8).toString();
        for (int i = 0; i < rdo_xuatxu.getItemCount(); i++) {
            String item = rdo_xuatxu.getItemAt(i).toString();
            if (item.equalsIgnoreCase(cbXuatXu)) {
                rdo_xuatxu.setSelectedIndex(i);
                break;
            }
        }

        String cbCoAo = tbl_spct.getValueAt(index, 11).toString();
        for (int i = 0; i < rdo_coao.getItemCount(); i++) {
            String item = rdo_coao.getItemAt(i).toString();
            if (item.equalsIgnoreCase(cbCoAo)) {
                rdo_coao.setSelectedIndex(i);
                break;
            }
        }

        String cbSP = tbl_spct.getValueAt(index, 4).toString();
        for (int i = 0; i < cbo_loaisp.getItemCount(); i++) {
            String item = cbo_loaisp.getItemAt(i).toString();
            if (item.equalsIgnoreCase(cbSP)) {
                cbo_loaisp.setSelectedIndex(i);
                break;
            }
        }

        // Handle checkbox selection
        handleRowSelection(index);
    }//GEN-LAST:event_tbl_spctMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        txt_soluong.setText("");
        txt_gia.setText("");
        txt_dogiay.setText("");
        rdo_chatlieu.setSelectedIndex(0);
        rdo_coao.setSelectedIndex(0);
        rdo_kichthuoc.setSelectedIndex(0);
        rdo_mausacFA.setSelectedIndex(0);
        rdo_thuonghieuFA.setSelectedIndex(0);
        rdo_xuatxu.setSelectedIndex(0);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btl_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_updateActionPerformed
        int index = tbl_spct.getSelectedRow();
        String ma = tbl_spct.getValueAt(index, 1).toString();
        if (rpct.updateSanPhamCT(ma, readSPCT(idSanPham)) > 0) {
            JOptionPane.showMessageDialog(null, "Update thành công");
            if (check) {
                int totalCount = rpct.getTotalCount(idSanPham);
                int offset = (currentPage - 1) * ITEMS_PER_PAGE;
                List<ModelSanPhamCT> list = rpct.getAllSPCTById(idSanPham, ITEMS_PER_PAGE, offset);
                if (tbl_sanpham.getRowCount() > 0) {
                    tbl_sanpham.setRowSelectionInterval(0, 0);
                    yourMethod();
                    updateTable(totalCount, list);
                } else {
                    System.out.println("Bảng không có dữ liệu.");
                }
            } else {

            }

        } else {
            JOptionPane.showMessageDialog(null, "Update thất bại");
        }
    }//GEN-LAST:event_btl_updateActionPerformed

    private void btl_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_searchActionPerformed
        // TODO add your handling code here:

        String ten = txt_search.getText().trim();
        if (rpct.search(ten, idSanPham).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy thu cung ban muon tim");
        } else {
            JOptionPane.showMessageDialog(null, "tìm thấy");
            GetAllSPCT(rpct.search(ten, idSanPham));
        }
    }//GEN-LAST:event_btl_searchActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int i = tbl_sanpham.getSelectedRow();
        String ma = tbl_sanpham.getValueAt(i, 1).toString();
        if (rp.removeProductById(ma) > 0) {
            JOptionPane.showMessageDialog(null, "Xóa Thành Công");
            getAllSanPham(rp.getAllSanPham());
        } else {
            JOptionPane.showConfirmDialog(null, "Xóa Thất bại");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        int i = tbl_sanpham.getSelectedRow();
        String ma = tbl_sanpham.getValueAt(i, 1).toString();
        if (rp.updateProductById(ma, read()) > 0) {
            JOptionPane.showMessageDialog(null, "update thành công");
            getAllSanPham(rp.getAllSanPham());
        } else {
            JOptionPane.showMessageDialog(null, "update thất bại");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (read() != null) {
            if (rp.addProduct(read()) > 0) {
                JOptionPane.showMessageDialog(null, "thêm thành công");
                getAllSanPham(rp.getAllSanPham());
            } else {
                JOptionPane.showMessageDialog(null, "thêm thất bại ");
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void chuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chuyenActionPerformed
        // TODO add your handling code here:
//        spct.addTab("san pham chi tiet", sanphamct);
//        sanphamct.setVisible(true);
//        int offset = (currentPage - 1) * ITEMS_PER_PAGE;
//        GetAllSPCT(rpct.getAllSPCTById(idSanPham, ITEMS_PER_PAGE, offset));

// spct.remove(sp);
        sp.setVisible(false);
        spct.setVisible(true);
        spct.addTab("san pham chi tiet", sanphamct);
        sanphamct.setVisible(true);

        int offset = (currentPage - 1) * ITEMS_PER_PAGE;
        GetAllSPCT(rpct.getAllSPCTById(idSanPham, ITEMS_PER_PAGE, offset));

        // Optionally update the GetAllSPCT call if necessary
        // GetAllSPCT(rpct.getAll());
        // Ensure the container is updated
        spct.revalidate();
        spct.repaint();

    }//GEN-LAST:event_chuyenActionPerformed

    private void btl_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_fileActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("customer");
                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tbl_sanpham.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tbl_sanpham.getColumnName(i));
                }

                for (int i = 0; i < tbl_sanpham.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < tbl_sanpham.getColumnCount(); j++) {
                        Cell cell = row.createCell(j);
                        if (tbl_sanpham.getValueAt(i, j) != null) {
                            cell.setCellValue(tbl_sanpham.getValueAt(i, j).toString());
                        }
                    }
                }

                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());

            } else {
                JOptionPane.showMessageDialog(null, " Xuất file exle thất bại");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }//GEN-LAST:event_btl_fileActionPerformed

    private void tbl_sanphamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanphamMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_sanphamMouseEntered

    private void tbl_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanphamMouseClicked
        // TODO add your handling code here:

        int index = tbl_sanpham.getSelectedRow();
        txt_masanpham.setText(tbl_sanpham.getValueAt(index, 1).toString());
        txt_loaisanpham.setText(tbl_sanpham.getValueAt(index, 2).toString());
        txt_mota.setText(tbl_sanpham.getValueAt(index, 4).toString());
     

        String ma = tbl_sanpham.getValueAt(index, 1).toString();

        List<SanPham> list = new RepositorySanPham().sanphambyMa(ma);
        SanPham sanPham = list.get(0);
        idSanPham = sanPham.getId();

        chuyen.setVisible(true);
    }//GEN-LAST:event_tbl_sanphamMouseClicked

    private void btl_qrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_qrActionPerformed
        // TODO add your handling code here:

int row = tbl_spct.getSelectedRow();

String qrContent = tbl_spct.getValueAt(row, 1).toString();

try {
    System.out.println("Generating QR code for content: " + qrContent);

    ByteArrayOutputStream out = QRCode.from(qrContent)
            .to(ImageType.PNG)
            .withSize(250, 250) // Điều chỉnh kích thước nếu cần
            .stream();

    String f_name = tbl_spct.getValueAt(row, 4).toString();
    // Loại bỏ ký tự không hợp lệ trong tên tệp
    f_name = f_name.replaceAll("[<>:\"/\\|?*]", "_");
    String Path_name = "D:\\ThuVien\\qrCode\\"; // Thêm dấu gạch chéo ngược ở cuối
    File outputFile = new File(Path_name + f_name + ".PNG");

    // Kiểm tra và xử lý nếu tệp tin đã tồn tại
    if (outputFile.exists()) {
        int count = 1;
        String newFileName;
        do {
            newFileName = Path_name + f_name + "_" + count + ".PNG";
            outputFile = new File(newFileName);
            count++;
        } while (outputFile.exists());
    }

    // Kiểm tra xem thư mục có tồn tại không, nếu không thì tạo mới
    File directory = new File(Path_name);
    if (!directory.exists()) {
        if (!directory.mkdirs()) {
            throw new IOException("Unable to create directory: " + Path_name);
        }
    }

    try (FileOutputStream fout = new FileOutputStream(outputFile)) {
        fout.write(out.toByteArray());
        fout.flush();
    }

    System.out.println("QR code generated and saved to: " + outputFile.getAbsolutePath());

} catch (Exception e) {
    System.err.println("Error generating QR code: " + e.getMessage());
    e.printStackTrace();
}
JOptionPane.showMessageDialog(null, "Tải thành công!");


    }//GEN-LAST:event_btl_qrActionPerformed

    private void btl_quetQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_quetQRActionPerformed
        // TODO add your handling code here:

        QuetQR dialog = new QuetQR(this, true);
        dialog.setVisible(true);
        
        
    }//GEN-LAST:event_btl_quetQRActionPerformed

    private void rdo_thuonghieu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_thuonghieu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_thuonghieu1ActionPerformed

    private void btl_findAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_findAllActionPerformed
        // TODO add your handling code here:

        String selectedSize = (String) rdo_kichThuocFindAll.getSelectedItem();
        String selectedBrand = (String) rdo_thuonghieuFA.getSelectedItem();
        String selectedColor = (String) rdo_mausacFA.getSelectedItem();
        String selectedMaterial = (String) rdo_chatLieuFindAll.getSelectedItem();
        modelSPCT.setNumRows(0);
        List<ModelSanPhamCT> list = rpct.findAll(selectedSize, selectedBrand, selectedColor, selectedMaterial);
        int stt = 1;
        for (ModelSanPhamCT spct : list) {
            int soLuong = spct.getSoLuong();
            String trangThaiText = soLuong > 0 ? "còn hàng" : "hết hàng";
            modelSPCT.addRow(new Object[]{stt++,
                spct.getMa(), spct.getSoLuong(), spct.getGia(), spct.getTenSP(),
                spct.getChatLieu(), spct.getKichThuoc(), spct.getThuongHieu(), spct.getDiaChi(), spct.getMau(), spct.getDoDay(),
                spct.getKieuAo(), trangThaiText
            });
        }

    }//GEN-LAST:event_btl_findAllActionPerformed

    private void btl_trangtruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_trangtruocActionPerformed
        // TODO add your handling code here:
        if (currentPage > 1) {
            currentPage--;
            if (check) {
                int totalCount = rpct.getTotalCount(idSanPham);
                int offset = (currentPage - 1) * ITEMS_PER_PAGE;
                List<ModelSanPhamCT> list = rpct.getAllSPCTById(idSanPham, ITEMS_PER_PAGE, offset);
                if (tbl_sanpham.getRowCount() > 0) {
                    tbl_sanpham.setRowSelectionInterval(0, 0);
                    yourMethod();
                    updateTable(totalCount, list);
                } else {
                    System.out.println("Bảng không có dữ liệu.");
                }
            } else {
                int totalCount = rpct.getTotalCountAll();
                int offset = (currentPage - 1) * ITEMS_PER_PAGE;
                List<ModelSanPhamCT> list = rpct.getAll(ITEMS_PER_PAGE, offset);
                if (tbl_sanpham.getRowCount() > 0) {
                    tbl_sanpham.setRowSelectionInterval(0, 0);
                    yourMethod();
                    updateTable(totalCount, list);
                } else {
                    System.out.println("Bảng không có dữ liệu.");
                }
            }

        }
        refreshTable();

    }//GEN-LAST:event_btl_trangtruocActionPerformed

    private void btl_trangsauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_trangsauActionPerformed
        // TODO add your handling code here:
        int totalCount = check ? rpct.getTotalCount(idSanPham) : rpct.getTotalCountAll();
        int totalPages = (int) Math.ceil((double) totalCount / ITEMS_PER_PAGE);

        if (currentPage < totalPages) {
            currentPage++;
            int offset = (currentPage - 1) * ITEMS_PER_PAGE;
            List<ModelSanPhamCT> list = check
                    ? rpct.getAllSPCTById(idSanPham, ITEMS_PER_PAGE, offset)
                    : rpct.getAll(ITEMS_PER_PAGE, offset);

            if (list != null && !list.isEmpty()) {
                updateTable(totalCount, list);
            } else {
                System.out.println("Không có dữ liệu cho trang này.");
            }
        }
        refreshTable();

    }//GEN-LAST:event_btl_trangsauActionPerformed

    private void btl_dautrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_dautrangActionPerformed
        currentPage = 1;
        if (check) {
            int totalCount = rpct.getTotalCount(idSanPham);
            int offset = (currentPage - 1) * ITEMS_PER_PAGE;
            List<ModelSanPhamCT> list = rpct.getAllSPCTById(idSanPham, ITEMS_PER_PAGE, offset);
            if (tbl_sanpham.getRowCount() > 0) {
                tbl_sanpham.setRowSelectionInterval(0, 0);
                yourMethod();
                updateTable(totalCount, list);
            } else {
                System.out.println("Bảng không có dữ liệu.");
            }
        } else {
            int totalCount = rpct.getTotalCountAll();
            int offset = (currentPage - 1) * ITEMS_PER_PAGE;
            List<ModelSanPhamCT> list = rpct.getAll(ITEMS_PER_PAGE, offset);
            if (tbl_sanpham.getRowCount() > 0) {
                tbl_sanpham.setRowSelectionInterval(0, 0);
                yourMethod();
                updateTable(totalCount, list);
            } else {
                System.out.println("Bảng không có dữ liệu.");
            }
        }
        refreshTable(); // Chắc chắn gọi refreshTable sau khi cập nhật bảng dữ liệu
    }//GEN-LAST:event_btl_dautrangActionPerformed

    private void btl_trangcuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btl_trangcuoiActionPerformed

            int totalCount = check ? rpct.getTotalCount(idSanPham) : rpct.getTotalCountAll();
            int totalPages = (int) Math.ceil((double) totalCount / ITEMS_PER_PAGE);

            currentPage = totalPages;
            int offset = (currentPage - 1) * ITEMS_PER_PAGE;
            List<ModelSanPhamCT> list = check
                    ? rpct.getAllSPCTById(idSanPham, ITEMS_PER_PAGE, offset)
                    : rpct.getAll(ITEMS_PER_PAGE, offset);

            if (list != null && !list.isEmpty()) {
                updateTable(totalCount, list);
            } else {
                System.out.println("Bảng không có dữ liệu.");
            }
        refreshTable();

    }//GEN-LAST:event_btl_trangcuoiActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        toggleSelectAllCheckboxes();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txt_giaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_giaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_giaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
//        aDDNhanhSP1.setVisible(true);
            
        ThemNhanSP dialog = new ThemNhanSP(new javax.swing.JFrame(), true);
dialog.setVisible(true);
cbo_loaisp.removeAllItems();
        coboboxLoaiSp(rp.getAllSanPham());


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        ThemNhanhThuongHieu hieu = new ThemNhanhThuongHieu(new javax.swing.JFrame(), true);
        hieu.setVisible(true);
        rdo_thuonghieu1.removeAllItems();
        coboboxThuongHieu(repositoryThuongHieu.getAllMau());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        ThemNhanhXuatXu nhanhXuatXu = new ThemNhanhXuatXu(new javax.swing.JFrame(), true);
        nhanhXuatXu.setVisible(true);
        rdo_xuatxu.removeAllItems();
        coboboxXuatXu(repositoryXuatXu.getAllXuatXu());
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        
        ThemNhanhMauSac mauSac = new ThemNhanhMauSac(new javax.swing.JFrame(), true);
        mauSac.setVisible(true);
        rdo_mausac1.removeAllItems();
        coboboxMau(repositoryMau.getAllMau());
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        ThemNhanhCoAo nhanhCoAo = new ThemNhanhCoAo(new javax.swing.JFrame(), true);
        nhanhCoAo.setVisible(true);
        rdo_coao.removeAllItems();
        coboboxKieuAo(repositoryKieuAo.getAllKieuAo());
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        ThemNhanhChatLieu tn = new ThemNhanhChatLieu(new javax.swing.JFrame(), true);
        tn.setVisible(true);
        rdo_chatlieu.removeAllItems();
        coboboxChatLieu(repositoryChatLieu.getAllChatLieu());
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:\
        
        ThemKichThuocNhanh kichThuocNhanh = new ThemKichThuocNhanh(new javax.swing.JFrame(), true);
        kichThuocNhanh.setVisible(true);
        rdo_kichthuoc.removeAllItems();
        coboboxKichThuoc(repositoryKichThuoc.getAll());
    }//GEN-LAST:event_jButton13ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btl_add;
    private javax.swing.JButton btl_dautrang;
    private javax.swing.JButton btl_exelspct;
    private javax.swing.JButton btl_file;
    private javax.swing.JButton btl_findAll;
    private javax.swing.JButton btl_getAllSPCT;
    private javax.swing.JButton btl_qr;
    private javax.swing.JButton btl_quetQR;
    private javax.swing.JButton btl_search;
    private javax.swing.JButton btl_trangcuoi;
    private javax.swing.JButton btl_trangsau;
    private javax.swing.JButton btl_trangtruoc;
    private javax.swing.JButton btl_update;
    private javax.swing.JButton btl_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cbo_loaisp;
    private javax.swing.JButton chuyen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuBar jMenuBar6;
    private javax.swing.JMenuBar jMenuBar7;
    private javax.swing.JMenuBar jMenuBar8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_trang;
    private javax.swing.JComboBox<String> rdo_chatLieuFindAll;
    private javax.swing.JComboBox<String> rdo_chatlieu;
    private javax.swing.JComboBox<String> rdo_coao;
    private javax.swing.JComboBox<String> rdo_kichThuocFindAll;
    private javax.swing.JComboBox<String> rdo_kichthuoc;
    private javax.swing.JComboBox<String> rdo_mausac1;
    private javax.swing.JComboBox<String> rdo_mausacFA;
    private javax.swing.JComboBox<String> rdo_thuonghieu1;
    private javax.swing.JComboBox<String> rdo_thuonghieuFA;
    private javax.swing.JComboBox<String> rdo_xuatxu;
    private javax.swing.JPanel sanphamct;
    private javax.swing.JPanel sp;
    private javax.swing.JTabbedPane spct;
    private javax.swing.JTable tbl_sanpham;
    private javax.swing.JTable tbl_spct;
    private javax.swing.JTextField txt_dogiay;
    private javax.swing.JTextField txt_gia;
    private javax.swing.JTextField txt_loaisanpham;
    private javax.swing.JTextField txt_masanpham;
    private javax.swing.JTextField txt_mota;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_soluong;
    // End of variables declaration//GEN-END:variables

    // COde Phần sản phẩm
    public void getAllSanPham(List<ModelSanPham> list) {
        modelSanPham.setRowCount(0);
        int stt = 1;
        for (ModelSanPham sp : list) {
            modelSanPham.addRow(new Object[]{stt++, sp.getMaSanPham(),
                sp.getTenSanPham(), sp.getMoTa(), sp.getTongSoLuong(),
               sp.getTongSoLuong() > 0  ? "Còn hàng" : "Hết hàng"});
        }
    }

    public SanPham read() {
        String ma, loaiSanPham, moTa;
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        VaiTro currentUser = Application.getCurrentUser();
        
        UUID uuid = UUID.randomUUID();
        ma = uuid.toString();

        loaiSanPham = txt_loaisanpham.getText().trim();

        moTa = txt_mota.getText().trim();
        if (moTa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mô tả");
            txt_mota.requestFocus();
            return null;
        }

        if (loaiSanPham.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập ");
            return null;
        }
        
        
        
        List<ModelSanPham> list  = rp.getAllSanPham();
        for (ModelSanPham modelSanPham1 : list) {
            if(loaiSanPham.equalsIgnoreCase(modelSanPham1.getTenSanPham())){
                 Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Đã có sản phẩm này!");
                 txt_loaisanpham.requestFocus();
                 return null;
            }
        }
        
        

        boolean trangThai;
   

Date date = new Date();

//        return new SanPham(ma, loaiSanPham, moTa,null, null, currentUser.getId(), 1,1);
return new SanPham(ma, loaiSanPham, moTa, null, null, currentUser.getId(), 1, true);
    }

    public void openFile(String flie) {
        try {
            File path = new File(flie);
            Desktop.getDesktop().open(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   

    // Code sản phẩm chi tiết
    private void GetAllSPCT(List<ModelSanPhamCT> list) {
        modelSPCT.setRowCount(0); 

        int stt = (currentPage - 1) * ITEMS_PER_PAGE + 1; // Đánh số thứ tự đúng
        for (ModelSanPhamCT spct : list) {
            int soLuong = spct.getSoLuong();
            String trangThaiText = soLuong > 0 ? "còn hàng" : "hết hàng";
            modelSPCT.addRow(new Object[]{
                stt++,
                spct.getMa(), spct.getSoLuong(), spct.getGia(), spct.getTenSP(),
                spct.getChatLieu(), spct.getKichThuoc(), spct.getThuongHieu(), spct.getDiaChi(), spct.getMau(), spct.getDoDay(),
                spct.getKieuAo(), trangThaiText
            });
        }
    }

    // getAllSPCT by id SP
    // dữ liệu lên cobobox
    public void coboboxChatLieu(List<ChatLieu> list) {
        for (ChatLieu chatLieu : list) {
            // Thêm vào ComboBox với ComboBoxItem chứa ID và mô tả
            rdo_chatlieu.addItem(chatLieu.getTenLoaiVai());
        }
    }

    public void coboboxKichThuoc(List<KichThuoc> list) {
        for (KichThuoc kichThuoc : list) {
            // Thêm vào ComboBox với ComboBoxItem chứa ID và mô tả
            rdo_kichthuoc.addItem(kichThuoc.getSize());
        }
    }

    public void coboboxKieuAo(List<KieuAo> list) {
        for (KieuAo kieuAo : list) {
            // Thêm vào ComboBox với ComboBoxItem chứa ID và mô tả
            rdo_coao.addItem(kieuAo.getTen());
        }
    }

    public void coboboxMau(List<Mau> list) {
        for (Mau mau : list) {
            // Thêm vào ComboBox với ComboBoxItem chứa ID và mô tả
            rdo_mausac1.addItem(mau.getLoaiMau());
        }
    }

    public void coboboxXuatXu(List<XuatXu> list) {
        for (XuatXu xuatXu : list) {
            // Thêm vào ComboBox với ComboBoxItem chứa ID và mô tả
            rdo_xuatxu.addItem(xuatXu.getDiaChia());
        }
    }

    public void coboboxThuongHieu(List<ThuongHieu> list) {
        for (ThuongHieu thuongHieu : list) {
            // Thêm vào ComboBox với ComboBoxItem chứa ID và mô tả
            rdo_thuonghieu1.addItem(thuongHieu.getTenThuongHieu());
        }
    }

    // add spct 
    public SanPhamChiTiet readSPCT(int id) {
        String soLuong, gia, doday, ma;
        int idThuongHieu, idChatLieu, idKichThuoc, idMauSac, idXuatXu, idCoCao;
        List<SanPham> list = new RepositorySanPham().sanpham(idSanPham);
        SanPham sanPham = list.get(0);
        int tensp = sanPham.getId();
        Boolean trangThai;
        UUID idMa = UUID.randomUUID();
        ma = idMa.toString();

        soLuong = txt_soluong.getText().trim();
        if (soLuong.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng");
            return null;
        }

        if (!soLuong.matches("[0-9.0]+")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số lớn hơn 0");
            return null;
        }

        gia = txt_gia.getText().trim();
        if (gia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng giá tiền");
            return null;
        }

        if (!gia.matches("[0-9.0]+")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số lớn hơn 0");
            return null;
        }

        doday = txt_dogiay.getText().trim();
        
        
        
        if (doday.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng đọ dày");
            return null;
        }

       
        
        if (!doday.matches("[0-2.0]+")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số lớn hơn 0 và nhỏ hơn 2");
            return null;
        }

  
        idChatLieu = rdo_chatlieu.getSelectedIndex();
        idThuongHieu = rdo_thuonghieuFA.getSelectedIndex();
        idKichThuoc = rdo_kichthuoc.getSelectedIndex();
        idMauSac = rdo_mausacFA.getSelectedIndex();
        idXuatXu = rdo_chatlieu.getSelectedIndex();
        idCoCao = rdo_chatlieu.getSelectedIndex();
//        return new SanPhamChiTiet(idKichThuoc + 1, idThuongHieu + 1,
//                idXuatXu + 1, tensp, 1, idMauSac + 1,
//                idChatLieu + 1, idCoCao + 1, ma,
//                Float.valueOf(gia), Integer.valueOf(soLuong), doday, null, null,
//                0, 0);
return new SanPhamChiTiet(idKichThuoc + 1, idThuongHieu + 1, idXuatXu +1, tensp,
        1, idMauSac  + 1 , idChatLieu + 1, idCoCao + 1, ma,   Float.valueOf(gia),
      Integer.valueOf(soLuong), doday, null, null, 0, 0,true);
    }
    
    
    

    public int getIdSanPham() {
        int index = tbl_sanpham.getSelectedRow();

        // Kiểm tra xem có hàng nào được chọn không
        if (index == -1) {
            throw new IllegalStateException("Không có hàng nào được chọn trong bảng.");
        }

        // Lấy giá trị mã sản phẩm từ bảng
        String ma = tbl_sanpham.getValueAt(index, 1).toString();

        // Lấy danh sách sản phẩm dựa trên mã
        List<SanPham> list = new RepositorySanPham().sanphambyMa(ma);

        // Kiểm tra xem danh sách có trống không
        if (list.isEmpty()) {
            throw new IllegalStateException("Không tìm thấy sản phẩm với mã: " + ma);
        }

        // Lấy sản phẩm đầu tiên trong danh sách
        SanPham sanPham = list.get(0);
        return sanPham.getId(); // Trả giá trị ID
    }

    public void coboboxChatLieuFA(List<ChatLieu> list) {
        rdo_chatLieuFindAll.addItem("Tất Cả");
        for (ChatLieu chatLieu : list) {
            rdo_chatLieuFindAll.addItem(chatLieu.getTenLoaiVai());
        }
    }

    public void coboboxKichThuocFA(List<KichThuoc> list) {
        rdo_kichThuocFindAll.addItem("Tất Cả");
        for (KichThuoc kichThuoc : list) {
            rdo_kichThuocFindAll.addItem(kichThuoc.getSize());
        }
    }

    public void coboboxMauFA(List<Mau> list) {
        rdo_mausacFA.addItem("Tất Cả");
        for (Mau mau : list) {
            rdo_mausacFA.addItem(mau.getLoaiMau());
        }

    }

    public void coboboxThuongHieuFA(List<ThuongHieu> list) {
        rdo_thuonghieuFA.addItem("Tất Cả");
        for (ThuongHieu thuongHieu : list) {
            rdo_thuonghieuFA.addItem(thuongHieu.getTenThuongHieu());
        }
    }

    public void coboboxLoaiSp(List<ModelSanPham> list) {
        
        for (ModelSanPham sp : list) {
            // Thêm vào ComboBox với ComboBoxItem chứa ID và mô tả
            cbo_loaisp.addItem(sp.getTenSanPham());
        }
        
        
    }

    public void valueComBoBox() {
        
      
        coboboxLoaiSp(rp.getAllSanPham());
        coboboxChatLieu(repositoryChatLieu.getAllChatLieu());
        coboboxKichThuoc(repositoryKichThuoc.getAll());
        coboboxMau(repositoryMau.getAllMau());
        coboboxKieuAo(repositoryKieuAo.getAllKieuAo());
        coboboxXuatXu(repositoryXuatXu.getAllXuatXu());
        coboboxThuongHieu(repositoryThuongHieu.getAllMau());
        coboboxThuongHieuFA(repositoryThuongHieu.getAllMau());
        coboboxChatLieuFA(repositoryChatLieu.getAllChatLieu());
        coboboxKichThuocFA(repositoryKichThuoc.getAll());
        coboboxMauFA(repositoryMau.getAllMau());
    }

    // CHECK BOXXXXXXXXXXXXXXXXXXXXX
    private Map<String, Boolean> checkboxStateMap = new HashMap<>();

    private void removeFromListSelected(String ma) {
        listSelected.removeIf(item -> item.getMa().equals(ma));
    }

private void handleRowSelection(int index) {
    String ma = tbl_spct.getValueAt(index, 1).toString(); // Giả sử 'ma' ở cột thứ hai
   Object value = tbl_spct.getValueAt(index, 13);
boolean isSelected = (value != null) ? (Boolean) value : false; // Hoặc giá trị mặc định khác


    checkboxStateMap.put(ma, isSelected);

    if (isSelected) {
        if (!listSelected.stream().anyMatch(item -> item.getMa().equals(ma))) {
            listSelected.add(rpct.getAllSPCTByMa(ma));
        }
    } else {
        removeFromListSelected(ma);
    }
    System.out.println(listSelected.toString() + " DANH SÁCH ĐÃ CẬP NHẬT");
}

private void refreshTable() {
    for (int i = 0; i < tbl_spct.getRowCount(); i++) {
        // Lấy giá trị tại ô hiện tại
        Object value = tbl_spct.getValueAt(i, 1);

        // Kiểm tra nếu giá trị không phải là null
        String ma = value != null ? value.toString() : "";

        // Cập nhật trạng thái của ô kiểm tra
        if (checkboxStateMap.containsKey(ma)) {
            tbl_spct.setValueAt(checkboxStateMap.get(ma), i, 13);
        } else {
            tbl_spct.setValueAt(false, i, 13);
        }
    }
}

private void loadFirstPage(boolean check) {
    currentPage = 1;
    List<ModelSanPhamCT> list;
    int totalCount;
    
    if (check) {
        totalCount = rpct.getTotalCount(idSanPham);
        list = rpct.getAllSPCTById(idSanPham, ITEMS_PER_PAGE, (currentPage - 1) * ITEMS_PER_PAGE);
    } else {
        totalCount = rpct.getTotalCountAll();
        list = rpct.getAll(ITEMS_PER_PAGE, (currentPage - 1) * ITEMS_PER_PAGE);
    }

    if (tbl_sanpham.getRowCount() > 0) {
        tbl_sanpham.setRowSelectionInterval(0, 0);
        yourMethod();
        updateTable(totalCount, list);
    } else {
        System.out.println("Bảng không có dữ liệu.");
    }

    refreshTable(); // Khôi phục trạng thái checkbox sau khi tải trang đầu tiên
}

// xuất EXELLLLLLL
    private void exportToExcel() {
        if (isAnyCheckboxSelected()) {
            // Xuất các dữ liệu đã chọn
            exportSelectedDataToExcel();
        } else {
            // Xuất toàn bộ dữ liệu
            exportAllDataToExcel();
        }
    }

    private void exportSelectedDataToExcel() {
        List<ModelSanPhamCT> selectedData = new ArrayList<>(listSelected);
        exportDataToExcel(selectedData);
    }

    private void exportAllDataToExcel() {
        List<ModelSanPhamCT> allData = rpct.getAllSPCTById(idSanPham, WIDTH, HEIGHT); // Giả sử getAll() trả về tất cả dữ liệu
        exportDataToExcel(allData);
    }

    private void exportDataToExcel(List<ModelSanPhamCT> data) {
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Data");
                Row headerRow = sheet.createRow(0);

                if (data.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No data to export.");
                    return;
                }

                // Create header row
                ModelSanPhamCT firstObject = data.get(0);
                Field[] fields = firstObject.getClass().getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(fields[i].getName());
                }

                // Create data rows
                for (int i = 0; i < data.size(); i++) {
                    ModelSanPhamCT item = data.get(i);
                    Row row = sheet.createRow(i + 1);

                    for (int j = 0; j < fields.length; j++) {
                        fields[j].setAccessible(true);
                        Cell cell = row.createCell(j);
                        Object value = fields[j].get(item);
                        if (value != null) {
                            cell.setCellValue(value.toString());
                        }
                    }
                }

                try (FileOutputStream out = new FileOutputStream(saveFile)) {
                    wb.write(out);
                }
                wb.close();
                openFile(saveFile.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Export failed.");
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error exporting data: " + e.getMessage());
        }
    }

// Method to check if any checkbox is selected
    private boolean isAnyCheckboxSelected() {
        for (int i = 0; i < tbl_spct.getRowCount(); i++) {
            boolean isSelected = (boolean) tbl_spct.getValueAt(i, 13);
            if (isSelected) {
                return true;
            }
        }
        return false;
    }

 private void updateTable(int totalCount, List<ModelSanPhamCT> list) {
        modelSPCT.setNumRows(0);
        int stt = (currentPage - 1) * ITEMS_PER_PAGE + 1;

        for (ModelSanPhamCT spct : list) {
            int soLuong = spct.getSoLuong();
            String trangThaiText = soLuong > 0 ? "còn hàng" : "hết hàng";
            modelSPCT.addRow(new Object[]{
                stt++,
                spct.getMa(), spct.getSoLuong(), spct.getGia(), spct.getTenSP(),
                spct.getChatLieu(), spct.getKichThuoc(), spct.getThuongHieu(), spct.getDiaChi(), spct.getMau(), spct.getDoDay(),
                spct.getKieuAo(), trangThaiText, checkboxStateMap.getOrDefault(spct.getMa(), false)
            });
        }

        int totalPages = (int) Math.ceil((double) totalCount / ITEMS_PER_PAGE); // Tính tổng số trang
        lbl_trang.setText("Page " + currentPage + " of " + totalPages); // Hiển thị thông tin trang hiện tại

        refreshTable();
    }
 
 
 
    // code trang thái ô select 



 
private void toggleSelectAllCheckboxes() {
    isAllSelected = !isAllSelected;

    // Cập nhật trạng thái cho tất cả các mục trong checkboxStateMap

 List<ModelSanPhamCT> allData = rpct.getAllSPCTById(idSanPham);
    updateAllCheckboxStates(allData);

    // Làm mới bảng để phản ánh trạng thái mới
    refreshTable();
    
    System.out.println(idSanPham+"IDDDDDDDDDDDD");
    System.out.println(allData.size()+ "Kich thuoc mang");
}


 
 private void updateAllCheckboxStates(List<ModelSanPhamCT> allData) {
    for (ModelSanPhamCT spct : allData) {
        checkboxStateMap.put(spct.getMa(), isAllSelected);
    }
}
 
 
 
 public void getAllSPCT(){
       int offset = (currentPage - 1) * ITEMS_PER_PAGE;
        if (offset < 0) {
            offset = 0;
        }

        int totalCount = rpct.getTotalCountAll();
        List<ModelSanPhamCT> list = rpct.getAll(ITEMS_PER_PAGE, offset);
        updateTable(totalCount, list);
 }
 
 
}
