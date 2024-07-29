package raven.application.form.other.hoadon;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import raven.toast.Notifications;

public class FormHoaDon extends javax.swing.JPanel {

    DefaultTableModel modelHD = new DefaultTableModel();
    DefaultTableModel modelHDCT = new DefaultTableModel();
    DefaultTableModel modelLSHD = new DefaultTableModel();
    DefaultTableModel modelSP = new DefaultTableModel();

    private ScanQRHoaDon scanQRCodeDialog;
    private ScanQRLSHD scanQRCode;

    HoaDonRepository donRepository = new HoaDonRepository();
    HoaDonResponseWrapper donResponseWrapper = new HoaDonResponseWrapper();
    int page = 0;
    private int totalRecords = donResponseWrapper.getTotalRecords();
    private int totalPages = (int) Math.ceil((double) totalRecords + 3) / 10;
    int displayPage = 1;
    NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    public FormHoaDon() {
        initComponents();
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tìm kiếm theo mã nhân viên, tên nhân viên, tên khách hàng, sdt khách hàng");
        txtSearchLSHD.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Tìm kiếm theo mã nhân viên, tên nhân viên, tên khách hàng, sdt khách hàng");
        txtGiaTu.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Từ");
        txtGiaDen.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Đến");
        modelHD = (DefaultTableModel) tblHoaDon.getModel();
        modelHDCT = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        modelLSHD = (DefaultTableModel) tblLSHD.getModel();
        modelSP = (DefaultTableModel) tblSPDaMua.getModel();
        setTitleHoaDon();
        setTitleHoaDonChiTiet();
        setTitleLichSuHoaDon();
        lbPhanTrang.setText(String.valueOf(displayPage));
        btnSearchHDActionPerformed(null);
        fillTableLSHD(donRepository.searchLSHD(""));
        if (totalRecords <= 3) {
            btnBack.setEnabled(false);
            btnNext.setEnabled(false);
        } else {
            btnBack.setEnabled(false);
            btnNext.setEnabled(true);
        }
    }

    public void fillTableHD(List<HoaDonResponse> donResponses) {
        modelHD.setRowCount(0);
        int i = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (HoaDonResponse donResponse : donResponses) {
            LocalDate ngayTao = donResponse.getNgayTao();
            String ngayTaoString = ngayTao.format(formatter);
            i += 1;
            modelHD.addRow(new Object[]{i, donResponse.getMaHD(), donResponse.getMaNV(), donResponse.getTenNV(), donResponse.getTenKH(), donResponse.getsDT(), format.format(donResponse.getTongTien()), ngayTaoString, donResponse.getTrangThai() == 1 ? "Đã thanh toán" : "Chưa thanh toán"});
        }
    }

    public void fillTableLSHD(List<HoaDonResponse> donResponses) {
        modelLSHD.setRowCount(0);
        int i = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (HoaDonResponse donResponse : donResponses) {
            LocalDate ngayTao = donResponse.getNgayTao();
            String ngayTaoString = ngayTao.format(formatter);
            i += 1;
            modelLSHD.addRow(new Object[]{i, donResponse.getMaHD(), donResponse.getMaNV(), donResponse.getTenNV(), donResponse.getTenKH(), donResponse.getsDT(), format.format(donResponse.getTongTien()), ngayTaoString, donResponse.getTrangThai() == 1 ? "Đã thanh toán" : "Chưa thanh toán"});
        }
    }

    public void fillTableSanPham(List<HoaDonResponse> hdrs) {
        modelSP.setRowCount(0);
        int i = 0;
        for (HoaDonResponse hdr : hdrs) {
            i += 1;
            modelSP.addRow(new Object[]{i, hdr.getMaSP(), hdr.getTenSP(), format.format(hdr.getTongTienHDCT()), hdr.getSoLuong(), format.format(hdr.getTongTien())});
        }
    }

    public void scanQRHD(String maHD) {
        if (donRepository.validateMaHD(maHD)) {
            modelHD.setRowCount(0);
            List<HoaDonResponse> list = donRepository.getHoaDon(maHD);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Tìm thấy hóa đơn với mã: " + maHD);
            fillTableHD(list);
            btnNext.setEnabled(false);
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Không tìm thấy hóa đơn với mã: " + maHD);
        }

    }

    public void scanQRLSHD(String maHD) {
        if (donRepository.validateLSHD(maHD)) {
            modelHD.setRowCount(0);
            List<HoaDonResponse> list = donRepository.getLSDH(maHD);
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Tìm thấy hóa đơn với mã: " + maHD);
            fillTableLSHD(list);
            fillTableSanPham(list);
            for (HoaDonResponse hoaDonResponse : list) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate ngayTao = hoaDonResponse.getNgayTao();
                String ngayTaoString = ngayTao.format(formatter);
                lbMaHD.setText(hoaDonResponse.getMaHD());
                lbGhiChu.setText("Không");
                lbGiaGiam.setText(String.valueOf(format.format(0)));
                lbHTTT.setText("Tiền mặt");
                lbSDTKH.setText(String.valueOf(hoaDonResponse.getsDT()));
                lbTTHD.setText(String.valueOf(hoaDonResponse.getTrangThai() == 1 ? "Đã thanh toán" : "Chệu"));
                lbTenKH.setText(hoaDonResponse.getTenKH());
                lbTenNhanVien.setText(hoaDonResponse.getTenNV());
                lbThoiGianTao.setText(ngayTaoString);
                lbTienKhachCK.setText(String.valueOf(format.format(0)));
                lbTienKhachDua.setText(String.valueOf(format.format(hoaDonResponse.getTongTien())));
                lbTienThua.setText(String.valueOf(format.format(0)));
                lbTongTien.setText(String.valueOf(format.format(hoaDonResponse.getTongTienHDCT())));

            }
            btnSearchHDActionPerformed(null);
        } else {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Không tìm thấy hóa đơn với mã: " + maHD);
        }

    }

    public void fillTableHDCT(List<HoaDonChiTietResponse> chiTietResponses) {
        int i = 1;
        for (HoaDonChiTietResponse chiTietResponse : chiTietResponses) {
            modelHDCT.addRow(new Object[]{i++, chiTietResponse.getMaHD(), chiTietResponse.getMaSP(), chiTietResponse.getTenSP(), chiTietResponse.getMau(), chiTietResponse.getKieuAo(), chiTietResponse.getThuongHieu(), chiTietResponse.getXuatXu(), chiTietResponse.getKichThuoc(), chiTietResponse.getChatLieu(), chiTietResponse.getSoLuong(), format.format(chiTietResponse.getTongTienHDCT())});
        }
    }

    private void setTitleHoaDon() {
        String header[] = {"STT", "Mã HĐ", "Mã Nhân Viên", "Tên Nhân Viên", "Tên Khách Hàng", "Số Điện Thoại", "Tổng Tiền", "Ngày Tạo", "Trạng Thái"};
        tblHoaDon.setRowHeight(49);
        modelHD.setColumnIdentifiers(header);
    }

    private void setTitleHoaDonChiTiet() {
        String header[] = {"STT", "Mã HĐ", "Mã Sản Phẩm", "Tên Sản Phẩm", "Màu", "Kiểu Áo", "Thương Hiệu", "Xuất Xứ", "Kích Thước", "Chất Liệu", "Số Lượng", "Giá"};
        tblHoaDonChiTiet.setRowHeight(49);
        modelHDCT.setColumnIdentifiers(header);
    }

    private void setTitleLichSuHoaDon() {
        String header[] = {"STT", "Mã HĐ", "Mã Nhân Viên", "Tên Nhân Viên", "Tên Khách Hàng", "Số Điện Thoại", "Tổng Tiền", "Ngày Tạo", "Trạng Thái"};
        tblLSHD.setRowHeight(50);
        modelLSHD.setColumnIdentifiers(header);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtGiaTu = new javax.swing.JTextField();
        txtGiaDen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        lbPhanTrang = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnSearchHD = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExportExcel = new javax.swing.JButton();
        btnScanQR = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLSHD = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtSearchLSHD = new javax.swing.JTextField();
        tbnSearchLSHD = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbMaHD = new javax.swing.JLabel();
        lbTenNhanVien = new javax.swing.JLabel();
        lbTenKH = new javax.swing.JLabel();
        lbSDTKH = new javax.swing.JLabel();
        lbGiaGiam = new javax.swing.JLabel();
        lbGhiChu = new javax.swing.JLabel();
        lbThoiGianTao = new javax.swing.JLabel();
        lbHTTT = new javax.swing.JLabel();
        lbTTHD = new javax.swing.JLabel();
        lbTienKhachDua = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        lbTienKhachCK = new javax.swing.JLabel();
        lbTienThua = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSPDaMua = new javax.swing.JTable();
        btnClear1 = new javax.swing.JButton();
        btnClearSearchLSHD = new javax.swing.JButton();
        btnQRLSHD = new javax.swing.JButton();

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tìm kiếm hóa đơn");

        txtSearch.setToolTipText("");
        txtSearch.setActionCommand("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Trạng thái hóa đơn");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đã thanh toán", "Chưa thanh toán" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Giá:");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        lbPhanTrang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbPhanTrang.setText("jLabel4");

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.setText("<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnSearchHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/hoadon/icon/search.png"))); // NOI18N
        btnSearchHD.setToolTipText("Search");
        btnSearchHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHDActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/hoadon/icon/clean.png"))); // NOI18N
        btnClear.setToolTipText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnExportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/hoadon/icon/excel.png"))); // NOI18N
        btnExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelActionPerformed(evt);
            }
        });

        btnScanQR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/hoadon/icon/qr.png"))); // NOI18N
        btnScanQR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnScanQRMouseClicked(evt);
            }
        });
        btnScanQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScanQRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtGiaTu, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGiaDen, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(btnSearchHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnExportExcel, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(btnScanQR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(553, 553, 553)
                .addComponent(btnBack)
                .addGap(16, 16, 16)
                .addComponent(lbPhanTrang)
                .addGap(16, 16, 16)
                .addComponent(btnNext)
                .addContainerGap(559, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSearchHD, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnExportExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtGiaTu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGiaDen, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnScanQR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPhanTrang)
                    .addComponent(btnBack)
                    .addComponent(btnNext))
                .addGap(13, 13, 13))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblHoaDonChiTiet);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hóa Đơn", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tblLSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLSHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLSHDMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblLSHD);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tìm kiếm hóa đơn");

        tbnSearchLSHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/hoadon/icon/search.png"))); // NOI18N
        tbnSearchLSHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSearchLSHDActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel5.setText("Mã Hóa Đơn:");

        jLabel6.setText("Tên Nhân Viên:");

        jLabel7.setText("SDT Khách Hàng:");

        jLabel8.setText("Tên Khách Hàng:");

        jLabel9.setText("Thời Gian Tạo:");

        jLabel10.setText("Giảm Giá: ");

        jLabel11.setText("Ghi Chú:");

        jLabel12.setText("Tiền Thừa:");

        jLabel14.setText("Tiền Khách CK:");

        jLabel15.setText("Tiền Khách Đưa:");

        jLabel16.setText("Tổng Tiền:");

        jLabel17.setText("Trạng Thái Hóa Đơn:");

        jLabel18.setText("Hình Thức Thanh Toán:");

        lbMaHD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbTenNhanVien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbTenKH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbSDTKH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbGiaGiam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbGhiChu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbThoiGianTao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbHTTT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbTTHD.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbTienKhachDua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbTongTien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbTienKhachCK.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbTienThua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbGiaGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbThoiGianTao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTienKhachCK, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addComponent(lbTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(23, 23, 23))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(lbHTTT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jLabel18)
                                                                .addComponent(lbMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(30, 30, 30)
                                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel17)
                                                                .addComponent(jLabel6))
                                                            .addComponent(lbTTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addComponent(lbTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel16))
                                                    .addComponent(lbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(lbTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel15))
                                            .addComponent(lbTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lbSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel14))
                                    .addComponent(lbTienKhachCK, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbGiaGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(lbThoiGianTao, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(lbGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        tblSPDaMua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Đơn Giá", "Số Lượng", "Thành Tiền"
            }
        ));
        jScrollPane4.setViewportView(tblSPDaMua);

        btnClear1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/hoadon/icon/clean.png"))); // NOI18N
        btnClear1.setToolTipText("Clear");

        btnClearSearchLSHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/hoadon/icon/clean.png"))); // NOI18N
        btnClearSearchLSHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSearchLSHDActionPerformed(evt);
            }
        });

        btnQRLSHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/hoadon/icon/qr.png"))); // NOI18N
        btnQRLSHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQRLSHDMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(46, 46, 46)
                        .addComponent(txtSearchLSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(tbnSearchLSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnClearSearchLSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnQRLSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnClear1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSearchLSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbnSearchLSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClearSearchLSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnQRLSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnClear1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Tìm kiếm hóa đơn", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int row = tblHoaDon.getSelectedRow();
        String maHD = (String) tblHoaDon.getValueAt(row, 1);
        List<HoaDonChiTietResponse> chiTietResponses = donRepository.getHoaDonCT(maHD);
        modelHDCT.setRowCount(0);
        fillTableHDCT(chiTietResponses);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnSearchHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHDActionPerformed
        String trangThai = null;
        double giaTu = 0;
        double giaDen = 0;
        int check = 0;
        if (cboTrangThai.getSelectedIndex() == 0) {
            trangThai = null;
        } else if (cboTrangThai.getSelectedIndex() == 1) {
            trangThai = "1";
        } else if (cboTrangThai.getSelectedIndex() == 2) {
            trangThai = "0";
        }
        if (!txtGiaTu.getText().trim().isEmpty()) {
            try {
                giaTu = Double.parseDouble(txtGiaTu.getText());
                if (giaTu < 0 || giaTu > 1000000000) {
                    Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Giá từ phải lớn hơn 0 và nhỏ hơn 1,000,000,000");
                    txtGiaTu.requestFocus();
                    check += 1;
                    return;
                }
            } catch (NumberFormatException e) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Giá từ phải là số hợp lệ");
                txtGiaTu.requestFocus();
                check += 1;
                return;
            }
        }

        if (!txtGiaDen.getText().trim().isEmpty()) {
            try {
                giaDen = Double.parseDouble(txtGiaDen.getText());
                if (giaDen < 0 || giaDen > 1000000000) {
                    Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Giá đến phải lớn hơn 0 và nhỏ hơn 1,000,000,000");
                    txtGiaDen.requestFocus();
                    check += 1;
                    return;
                }
            } catch (NumberFormatException e) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Giá đến phải là số hợp lệ");
                txtGiaDen.requestFocus();
                check += 1;
                return;
            }
        }

        if (giaTu > giaDen) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Giá từ không được lớn hơn giá đến");
            txtGiaTu.requestFocus();
            txtGiaDen.requestFocus();
            check += 1;
            return;
        }

        if (check == 0) {
            modelHD.setRowCount(0);
            HoaDonResponseWrapper responseWrapper = donRepository.searchHoaDon(txtSearch.getText(), trangThai, giaTu, giaDen, page, 3);
            List<HoaDonResponse> listNewSearch = responseWrapper.getHoaDonResponses();
            totalRecords = responseWrapper.getTotalRecords();
            totalPages = (int) Math.ceil((double) totalRecords / 3);

            fillTableHD(listNewSearch);

            if (totalRecords <= 3) {
                btnBack.setEnabled(false);
                btnNext.setEnabled(false);
            } else {
                btnBack.setEnabled(false);
                btnNext.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnSearchHDActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        page += 3;
        displayPage++;
        lbPhanTrang.setText(String.valueOf(displayPage));
        String trangThai = null;
        double giaTu = 0;
        double giaDen = 0;

        if (cboTrangThai.getSelectedIndex() == 0) {
            trangThai = null;
        } else if (cboTrangThai.getSelectedIndex() == 1) {
            trangThai = "1";
        } else if (cboTrangThai.getSelectedIndex() == 2) {
            trangThai = "0";
        }
        if (!txtGiaTu.getText().trim().isEmpty()) {
            try {
                giaTu = Double.parseDouble(txtGiaTu.getText());
                if (giaTu < 10000 || giaTu > 1000000000) {
                    Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Giá đến phải lớn hơn 10,000 và nhỏ hơn 1,000,000,000");
                    return;
                }
            } catch (NumberFormatException e) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Giá từ phải là số hợp lệ");
                return;
            }
        }

        if (!txtGiaDen.getText().trim().isEmpty()) {
            try {
                giaDen = Double.parseDouble(txtGiaDen.getText());
                if (giaDen < 10000 || giaDen > 1000000000) {
                    Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Giá đến phải lớn hơn 10,000 và nhỏ hơn 1,000,000,000");
                    return;
                }
            } catch (NumberFormatException e) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Giá đến phải là số hợp lệ");
                return;
            }
        }

        if (giaTu > giaDen) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Giá từ không được lớn hơn giá đến");
            return;
        }

        HoaDonResponseWrapper responseWrapper = donRepository.searchHoaDon(txtSearch.getText(), trangThai, giaTu, giaDen, page, 3);
        List<HoaDonResponse> hoaDonResponses = responseWrapper.getHoaDonResponses();
        fillTableHD(hoaDonResponses);
        btnBack.setEnabled(true);
        if (page >= totalPages - 1) {
            btnNext.setEnabled(false);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        page -= 3;
        displayPage--;
        lbPhanTrang.setText(String.valueOf(displayPage));
        String trangThai = null;
        double giaTu = 0;
        double giaDen = 0;

        if (cboTrangThai.getSelectedIndex() == 0) {
            trangThai = null;
        } else if (cboTrangThai.getSelectedIndex() == 1) {
            trangThai = "1";
        } else if (cboTrangThai.getSelectedIndex() == 2) {
            trangThai = "0";
        }
        if (!txtGiaTu.getText().trim().isEmpty()) {
            try {
                giaTu = Double.parseDouble(txtGiaTu.getText());
                if (giaTu < 10000 || giaTu > 1000000000) {
                    Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Giá đến phải lớn hơn 10,000 và nhỏ hơn 1,000,000,000");
                    return;
                }
            } catch (NumberFormatException e) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Giá từ phải là số hợp lệ");
                return;
            }
        }

        if (!txtGiaDen.getText().trim().isEmpty()) {
            try {
                giaDen = Double.parseDouble(txtGiaDen.getText());
                if (giaDen < 10000 || giaDen > 1000000000) {
                    Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Giá đến phải lớn hơn 10,000 và nhỏ hơn 1,000,000,000");
                    return;
                }
            } catch (NumberFormatException e) {
                Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Giá đến phải là số hợp lệ");
                return;
            }
        }

        if (giaTu > giaDen) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Giá từ không được lớn hơn giá đến");
            return;
        }
        HoaDonResponseWrapper responseWrapper = donRepository.searchHoaDon(txtSearch.getText(), trangThai, giaTu, giaDen, page, 3);
        List<HoaDonResponse> hoaDonResponses = responseWrapper.getHoaDonResponses();
        fillTableHD(hoaDonResponses);
        btnNext.setEnabled(true);
        if (page == 0) {
            btnBack.setEnabled(false);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtSearch.setText("");
        cboTrangThai.setSelectedIndex(0);
        txtGiaTu.setText("");
        txtGiaDen.setText("");
        btnSearchHDActionPerformed(null);
        modelHDCT.setRowCount(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelActionPerformed
        try {
            Workbook workbook = new XSSFWorkbook();

            Sheet sheet1 = workbook.createSheet("HoaDon");
            exportTableToSheet(tblHoaDon, sheet1);

            Sheet sheet2 = workbook.createSheet("HoaDonChiTiet");
            exportTableToSheet(tblHoaDonChiTiet, sheet2);

            FileOutputStream outputStream = new FileOutputStream("HoaDon.xlsx");
            workbook.write(outputStream);
            workbook.close();

            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Export thành công!");
        } catch (IOException ex) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Export thất bại!");
        }
    }//GEN-LAST:event_btnExportExcelActionPerformed

    private void btnScanQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScanQRActionPerformed

    }//GEN-LAST:event_btnScanQRActionPerformed

    private void btnScanQRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnScanQRMouseClicked
        new ScanQRHoaDon(true, this).setVisible(true);
    }//GEN-LAST:event_btnScanQRMouseClicked

    private void tblLSHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLSHDMouseClicked
        int row = tblLSHD.getSelectedRow();
        showDataCT(row);
        HoaDonResponse hdr = donRepository.searchLSHD(txtSearchLSHD.getText()).get(row);
        fillTableSanPham(donRepository.getSPDaMua(hdr.getMaHD()));
    }//GEN-LAST:event_tblLSHDMouseClicked

    private void btnClearSearchLSHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSearchLSHDActionPerformed
        txtSearchLSHD.setText("");
        modelSP.setRowCount(0);
        lbMaHD.setText("");
        lbGhiChu.setText("");
        lbGiaGiam.setText("");
        lbHTTT.setText("");
        lbSDTKH.setText("");
        lbTTHD.setText("");
        lbTenKH.setText("");
        lbTenNhanVien.setText("");
        lbThoiGianTao.setText("");
        lbTienKhachCK.setText("");
        lbTienKhachDua.setText("");
        lbTienThua.setText("");
        lbTongTien.setText("");
        fillTableLSHD(donRepository.searchLSHD(""));
    }//GEN-LAST:event_btnClearSearchLSHDActionPerformed

    private void tbnSearchLSHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSearchLSHDActionPerformed
        modelLSHD.setRowCount(0);
        fillTableLSHD(donRepository.searchLSHD(txtSearchLSHD.getText()));
    }//GEN-LAST:event_tbnSearchLSHDActionPerformed

    private void btnQRLSHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQRLSHDMouseClicked
        new ScanQRLSHD(true, this).setVisible(true);
    }//GEN-LAST:event_btnQRLSHDMouseClicked

    public void showDataCT(int index) {
        HoaDonResponse response = donRepository.searchLSHD(txtSearchLSHD.getText()).get(index);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngayTao = response.getNgayTao();
        String ngayTaoString = ngayTao.format(formatter);
        lbMaHD.setText(response.getMaHD());
        lbGhiChu.setText("Không");
        lbGiaGiam.setText(String.valueOf(format.format(0)));
        lbHTTT.setText("Tiền mặt");
        lbSDTKH.setText(String.valueOf(response.getsDT()));
        lbTTHD.setText(String.valueOf(response.getTrangThai() == 1 ? "Đã thanh toán" : "Chệu"));
        lbTenKH.setText(response.getTenKH());
        lbTenNhanVien.setText(response.getTenNV());
        lbThoiGianTao.setText(ngayTaoString);
        lbTienKhachCK.setText(String.valueOf(format.format(0)));
        lbTienKhachDua.setText(String.valueOf(format.format(response.getTongTien())));
        lbTienThua.setText(String.valueOf(format.format(0)));
        lbTongTien.setText(String.valueOf(format.format(response.getTongTienHDCT())));

    }

    private void exportTableToSheet(JTable table, Sheet sheet) {
        int rowCount = table.getRowCount();
        int columnCount = table.getColumnCount();

        // Create the header row
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columnCount; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(table.getColumnName(i));
        }
        // Create the data rows
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(table.getValueAt(i, j).toString());
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClear1;
    private javax.swing.JButton btnClearSearchLSHD;
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnQRLSHD;
    private javax.swing.JButton btnScanQR;
    private javax.swing.JButton btnSearchHD;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbGhiChu;
    private javax.swing.JLabel lbGiaGiam;
    private javax.swing.JLabel lbHTTT;
    private javax.swing.JLabel lbMaHD;
    private javax.swing.JLabel lbPhanTrang;
    private javax.swing.JLabel lbSDTKH;
    private javax.swing.JLabel lbTTHD;
    private javax.swing.JLabel lbTenKH;
    private javax.swing.JLabel lbTenNhanVien;
    private javax.swing.JLabel lbThoiGianTao;
    private javax.swing.JLabel lbTienKhachCK;
    private javax.swing.JLabel lbTienKhachDua;
    private javax.swing.JLabel lbTienThua;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTable tblLSHD;
    private javax.swing.JTable tblSPDaMua;
    private javax.swing.JButton tbnSearchLSHD;
    private javax.swing.JTextField txtGiaDen;
    private javax.swing.JTextField txtGiaTu;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchLSHD;
    // End of variables declaration//GEN-END:variables
}
