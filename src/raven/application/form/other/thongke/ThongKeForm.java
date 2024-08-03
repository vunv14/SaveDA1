package raven.application.form.other.thongke;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import raven.toast.Notifications;

public class ThongKeForm extends javax.swing.JPanel {

    DefaultTableModel modelSanPham = new DefaultTableModel();
    DefaultTableModel modelThoiGian = new DefaultTableModel();
    ThongKeRepository thongKeRepository = new ThongKeRepository();
    NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    public ThongKeForm() {
        initComponents();
        modelSanPham = (DefaultTableModel) ThongKeSPTable.getModel();
        modelThoiGian = (DefaultTableModel) ThongKeTheoMocTimeTable.getModel();
        this.setTitleCTSP();
        this.setTitle();
        fillCBBChatLieu(thongKeRepository.fillCBBChatLieu());
        fillCBBThuongHieu(thongKeRepository.fillCBBThuongHieu());
        fillCBBXuatXu(thongKeRepository.fillCBBXuatXu());
        fillCBBSize(thongKeRepository.fillCBBSize());
        lbSPDangKinhDoanh.setText(thongKeRepository.soSanPhamDangKinhDoanh() + "");
        lbSPHetHang.setText(thongKeRepository.soSanPhamHetHang() + "");
        lbSPSapHetHang.setText(thongKeRepository.soSanPhamSapHetHang() + "");
        lbSPNgungKinhDoanh.setText(thongKeRepository.soSanPhamNgungKinhDoanh() + "");
        this.showDoanhThuCaNam();
        this.showDoanhThuToDay();
        this.showDoanhThu7NgayGanNhat();
        this.showDoanhThuThangNay();
        txtDenNgay.setText("");
        txtNgayTu.setText("");
        this.fillCbbThongKe();
        this.jButton1MouseClicked(null);
    }

    public void fillCBBChatLieu(List<ChatLieuResponse> chatLieuResponses) {
        cboLoaiSP.removeAllItems();
        cboLoaiSP.addItem("");
        for (ChatLieuResponse chatLieuResponse : chatLieuResponses) {
            cboLoaiSP.addItem(chatLieuResponse.getTen());
        }
    }

    public void fillCBBThuongHieu(List<ThuongHieuResponse> chatLieuResponses) {
        cboThuongHieu.removeAllItems();
        cboThuongHieu.addItem("");
        for (ThuongHieuResponse chatLieuResponse : chatLieuResponses) {
            cboThuongHieu.addItem(chatLieuResponse.getThuongHieu());
        }
    }

    public void fillCBBXuatXu(List<XuatXuResponse> chatLieuResponses) {
        cboXuatXu.removeAllItems();
        cboXuatXu.addItem("");
        for (XuatXuResponse chatLieuResponse : chatLieuResponses) {
            cboXuatXu.addItem(chatLieuResponse.getXuatXu());
        }
    }

    public void fillCBBSize(List<SizeResponse> chatLieuResponses) {
        cboSize.removeAllItems();
        cboSize.addItem("");
        for (SizeResponse chatLieuResponse : chatLieuResponses) {
            cboSize.addItem(chatLieuResponse.getSize());
        }
    }

    private void setTitleCTSP() {
        String header[] = {"STT", "Mã SP", "Tên Sản Phẩm", "Thương Hiệu", "Chất Liệu", "Size", "Xuất Xứ", "Số Lượng Tồn", "Đơn Giá", "Số Lượng Bán Được", "Doanh Thu Từ Sản Phẩm"};
        modelSanPham.setColumnIdentifiers(header);
        ThongKeSPTable.setRowHeight(49);
    }

    private void setTitle() {
        String header[] = {"STT", "Ngày", "Doanh Thu"};
        modelThoiGian.setColumnIdentifiers(header);
        ThongKeTheoMocTimeTable.setRowHeight(49);
    }

    private void fillTableSanPham(List<SanPhamResponse> list) {
        int i = 1;
        for (SanPhamResponse a : list) {
            modelSanPham.addRow(new Object[]{i++, a.getMaSP(), a.getTenSP(), a.getThuongHieu(), a.getChatLieu(), a.getSize(), a.getXuatXu(), a.getSoLuongTon(), format.format(a.getDonGia()), a.getSoLuongBan(), format.format(a.getDoanhThu())});
        }
    }

    private void fillTableTheoTime(List<ThoiGianResponse> list) {
        int i = 1;
        modelThoiGian.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (ThoiGianResponse thoiGianResponse : list) {
            LocalDate localDate = thoiGianResponse.getNgayTao();
            String ngay = localDate.format(formatter);
            modelThoiGian.addRow(new Object[]{i++, ngay, format.format(thoiGianResponse.getDoanhThu())});
        }
    }

    private void showDoanhThuCaNam() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        Double doanhThuCaNam = thongKeRepository.getDoanhThuCaNam(year);
        lbDoanhThuNamNay.setText(format.format(doanhThuCaNam));
    }

    private void showDoanhThuToDay() {
        LocalDate toDay = LocalDate.now();
        Double doanhThuToDay = thongKeRepository.getDoanhThuToDay(toDay);
        lbDoanhThuHomNay.setText(format.format(doanhThuToDay));
    }

    private void showDoanhThu7NgayGanNhat() {
        Double doanhThu7NgayGanNhat = thongKeRepository.getDoanhThu7NgayGanNhat();
        lbDoanhThu7NgayGanNhat.setText(format.format(doanhThu7NgayGanNhat));
    }

    private void showDoanhThuThangNay() {
        LocalDate firstDayInMonth = LocalDate.now().withDayOfMonth(1);
        LocalDate toDay = LocalDate.now();
        Double doanhThuThangNay = thongKeRepository.getDoanhThuThangNay(firstDayInMonth, toDay);
        lbDoanhThuThangHienTai.setText(format.format(doanhThuThangNay));
    }

    private void fillCbbThongKe() {
        cbbYear.removeAllItems();
        for (Object[] row : thongKeRepository.listYear()) {
            cbbYear.addItem(row[0] + "");
        }
    }

    private ThongKeModel readForm() {
        String chatLieu = cboLoaiSP.getSelectedItem() != null ? cboLoaiSP.getSelectedItem().toString() : "";
        String thuongHieu = cboThuongHieu.getSelectedItem() != null ? cboThuongHieu.getSelectedItem().toString() : "";
        String xuatXu = cboXuatXu.getSelectedItem() != null ? cboXuatXu.getSelectedItem().toString() : "";
        String size = cboSize.getSelectedItem() != null ? cboSize.getSelectedItem().toString() : "";

        return new ThongKeModel(chatLieu, thuongHieu, xuatXu, size);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbSPDangKinhDoanh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbSPHetHang = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lbSPSapHetHang = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lbSPNgungKinhDoanh = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cboLoaiSP = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cboHTTK = new javax.swing.JComboBox<>();
        btnExport = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboThuongHieu = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboXuatXu = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cboSize = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ThongKeSPTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        lbDoanhThuNamNay = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lbDoanhThuHomNay = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        lbDoanhThu7NgayGanNhat = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lbDoanhThuThangHienTai = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtNgayTu = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtDenNgay = new javax.swing.JTextField();
        btnLoc = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ThongKeTheoMocTimeTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbbYear = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        chartPanel = new javax.swing.JPanel();

        dateChooser1.setTextRefernce(txtNgayTu);

        dateChooser2.setTextRefernce(txtDenNgay);

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setLayout(null);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBackground(new java.awt.Color(51, 204, 255));

        lbSPDangKinhDoanh.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbSPDangKinhDoanh.setForeground(new java.awt.Color(255, 255, 255));
        lbSPDangKinhDoanh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSPDangKinhDoanh.setText("0");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sản Phẩm Đang Kinh Doanh");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbSPDangKinhDoanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lbSPDangKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 153, 102));

        lbSPHetHang.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbSPHetHang.setForeground(new java.awt.Color(255, 255, 255));
        lbSPHetHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSPHetHang.setText("0");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sản Phẩm Hết Hàng");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSPHetHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(36, 36, 36))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lbSPHetHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(102, 255, 102));

        lbSPSapHetHang.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbSPSapHetHang.setForeground(new java.awt.Color(255, 255, 255));
        lbSPSapHetHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSPSapHetHang.setText("0");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sản Phẩm Sắp Hết Hàng");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbSPSapHetHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lbSPSapHetHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        lbSPNgungKinhDoanh.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbSPNgungKinhDoanh.setForeground(new java.awt.Color(255, 255, 255));
        lbSPNgungKinhDoanh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSPNgungKinhDoanh.setText("0");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sản Phẩm Ngừng Kinh Doanh");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbSPNgungKinhDoanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lbSPNgungKinhDoanh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 0, 1080, 160);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(null);

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Loại Chất Liệu:");

        cboLoaiSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiSPActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Hình Thức Thống Kê:");

        cboHTTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Sản Phẩm Doanh Thu Cao Nhất", "Sản Phẩm Doanh Thu Ít Nhất", "Sản Phẩm Bán Chạy Nhất", "Sản Phẩm Bán Ít Nhất" }));
        cboHTTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHTTKActionPerformed(evt);
            }
        });

        btnExport.setBackground(new java.awt.Color(51, 255, 255));
        btnExport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExport.setForeground(new java.awt.Color(0, 0, 0));
        btnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/thongke/icon/excel.png"))); // NOI18N
        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Thương Hiệu:");

        cboThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThuongHieuActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Xuất Xứ:");

        cboXuatXu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboXuatXu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboXuatXuActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Size:");

        cboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cboXuatXu, 0, 180, Short.MAX_VALUE)
                    .addComponent(cboLoaiSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboHTTK, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addGap(29, 29, 29))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cboHTTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cboThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExport))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel10);
        jPanel10.setBounds(7, 7, 1070, 150);

        ThongKeSPTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(ThongKeSPTable);

        jPanel9.add(jScrollPane1);
        jScrollPane1.setBounds(7, 162, 1066, 380);

        jPanel1.add(jPanel9);
        jPanel9.setBounds(0, 160, 1080, 550);

        jTabbedPane1.addTab("Thống Kê Theo Sản Phẩm", jPanel1);

        jPanel2.setLayout(null);

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel13.setBackground(new java.awt.Color(0, 102, 255));
        jPanel13.setForeground(new java.awt.Color(0, 51, 255));

        lbDoanhThuNamNay.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbDoanhThuNamNay.setForeground(new java.awt.Color(255, 255, 255));
        lbDoanhThuNamNay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoanhThuNamNay.setText("0");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Doanh Thu Cả Năm Nay");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbDoanhThuNamNay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lbDoanhThuNamNay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel14)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(204, 204, 0));
        jPanel14.setForeground(new java.awt.Color(0, 51, 255));

        lbDoanhThuHomNay.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbDoanhThuHomNay.setForeground(new java.awt.Color(255, 255, 255));
        lbDoanhThuHomNay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoanhThuHomNay.setText("0");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Doanh Thu Hôm Nay");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbDoanhThuHomNay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lbDoanhThuHomNay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(27, 27, 27))
        );

        jPanel15.setBackground(new java.awt.Color(255, 102, 0));
        jPanel15.setForeground(new java.awt.Color(0, 51, 255));

        lbDoanhThu7NgayGanNhat.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbDoanhThu7NgayGanNhat.setForeground(new java.awt.Color(255, 255, 255));
        lbDoanhThu7NgayGanNhat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoanhThu7NgayGanNhat.setText("0");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Doanh Thu 7 Ngày Gần Nhất");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbDoanhThu7NgayGanNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(lbDoanhThu7NgayGanNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(51, 255, 51));
        jPanel16.setForeground(new java.awt.Color(0, 51, 255));

        lbDoanhThuThangHienTai.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbDoanhThuThangHienTai.setForeground(new java.awt.Color(255, 255, 255));
        lbDoanhThuThangHienTai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDoanhThuThangHienTai.setText("0");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Doanh Thu Của Tháng Hiện Tại");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDoanhThuThangHienTai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lbDoanhThuThangHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel11);
        jPanel11.setBounds(0, 0, 1090, 187);

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 153));
        jLabel18.setText("Từ:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 153));
        jLabel19.setText("Đến:");

        btnLoc.setBackground(new java.awt.Color(255, 255, 255));
        btnLoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLoc.setForeground(new java.awt.Color(0, 153, 153));
        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel18)
                .addGap(47, 47, 47)
                .addComponent(txtNgayTu, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jLabel19)
                .addGap(62, 62, 62)
                .addComponent(txtDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtNgayTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(txtDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc))
                .addGap(19, 19, 19))
        );

        ThongKeTheoMocTimeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Ngày", "Doanh Thu"
            }
        ));
        jScrollPane2.setViewportView(ThongKeTheoMocTimeTable);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raven/application/form/other/thongke/icon/excel.png"))); // NOI18N
        jButton2.setText("Export");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(jButton2)
                        .addGap(0, 112, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel17);
        jPanel17.setBounds(0, 200, 1080, 510);

        jTabbedPane1.addTab("Thống Kê Theo Mốc Thời Gian", jPanel2);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("Lọc Theo:");

        cbbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbYearActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 255, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Lọc");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        chartPanelLayout.setVerticalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jButton1)
                        .addGap(0, 645, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Biểu Đồ", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1086, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiSPActionPerformed
        String maCL = (String) cboLoaiSP.getSelectedItem();
        if (maCL == "") {
            modelSanPham.setRowCount(0);
            this.fillTableSanPham(thongKeRepository.get(readForm()));
        } else {
            modelSanPham.setRowCount(0);
            fillTableSanPham(thongKeRepository.get(readForm()));
        }
    }//GEN-LAST:event_cboLoaiSPActionPerformed

    private void cboHTTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHTTKActionPerformed
        String httk = (String) cboHTTK.getSelectedItem();
        if (httk != null) {
            if (httk.equalsIgnoreCase("Sản Phẩm Doanh Thu Cao Nhất")) {
                modelSanPham.setRowCount(0);
                fillTableSanPham(thongKeRepository.SPDoanhThuCaoNhat());
            } else if (httk.equalsIgnoreCase("Sản Phẩm Doanh Thu Ít Nhất")) {
                modelSanPham.setRowCount(0);
                fillTableSanPham(thongKeRepository.SPDoanhThuThapNhat());
            } else if (httk.equalsIgnoreCase("Sản Phẩm Bán Chạy Nhất")) {
                modelSanPham.setRowCount(0);
                fillTableSanPham(thongKeRepository.SPBanChayNhat());
            } else if (httk.equalsIgnoreCase("Sản Phẩm Bán Ít Nhất")) {
                modelSanPham.setRowCount(0);
                fillTableSanPham(thongKeRepository.SPBanItNhat());
            } else {
                modelSanPham.setRowCount(0);
                this.fillTableSanPham(thongKeRepository.getSP());
                cboLoaiSP.setSelectedIndex(0);
                cboSize.setSelectedIndex(0);
                cboThuongHieu.setSelectedIndex(0);
                cboXuatXu.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_cboHTTKActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        String fromDate = txtNgayTu.getText();
        String toDate = txtDenNgay.getText();
        String format = "dd-MM-yyyy";

        String result = validateDates(fromDate, toDate, format);
        if (result != null) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, result);
        } else {
            String convertedFromDate = convertDateFormat(fromDate);
            String convertedToDate = convertDateFormat(toDate);

            fillTableTheoTime(thongKeRepository.LocDoanhThuTheoNgay(convertedFromDate, convertedToDate));
        }
    }//GEN-LAST:event_btnLocActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String year = (String) cbbYear.getSelectedItem();
        Integer nam = Integer.parseInt(year);
        ThongKeController tkc = new ThongKeController();
        tkc.setDateToChart(chartPanel, nam);
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        try {
            Workbook workbook = new XSSFWorkbook();

            Sheet sheet1 = workbook.createSheet("Thống Kê Theo Sản Phẩm");
            exportTableToSheet(ThongKeSPTable, sheet1);
            FileOutputStream outputStream = new FileOutputStream("SanPhamThongKe.xlsx");
            workbook.write(outputStream);
            workbook.close();

            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Export thành công!");
        } catch (IOException ex) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Export thất bại!");
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try {
            Workbook workbook = new XSSFWorkbook();

            Sheet sheet1 = workbook.createSheet("Thống Kê Theo Mốc Thời Gian");
            exportTableToSheet(ThongKeTheoMocTimeTable, sheet1);
            FileOutputStream outputStream = new FileOutputStream("ThongKe.xlsx");
            workbook.write(outputStream);
            workbook.close();

            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_RIGHT, "Export thành công!");
        } catch (IOException ex) {
            Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_RIGHT, "Export thất bại!");
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void cboThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboThuongHieuActionPerformed
        String maCL = (String) cboThuongHieu.getSelectedItem();
        if (maCL == "") {
            modelSanPham.setRowCount(0);
            this.fillTableSanPham(thongKeRepository.get(readForm()));
        } else {
            modelSanPham.setRowCount(0);
            fillTableSanPham(thongKeRepository.get(readForm()));
        }
    }//GEN-LAST:event_cboThuongHieuActionPerformed

    private void cboXuatXuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboXuatXuActionPerformed
        String maCL = (String) cboXuatXu.getSelectedItem();
        if (maCL == "") {
            modelSanPham.setRowCount(0);
            this.fillTableSanPham(thongKeRepository.get(readForm()));
        } else {
            modelSanPham.setRowCount(0);
            fillTableSanPham(thongKeRepository.get(readForm()));
        }
    }//GEN-LAST:event_cboXuatXuActionPerformed

    private void cboSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSizeActionPerformed
        String maCL = (String) cboSize.getSelectedItem();
        if (maCL == "") {
            modelSanPham.setRowCount(0);
            this.fillTableSanPham(thongKeRepository.get(readForm()));
        } else {
            modelSanPham.setRowCount(0);
            fillTableSanPham(thongKeRepository.get(readForm()));
        }
    }//GEN-LAST:event_cboSizeActionPerformed

    private void cbbYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbYearActionPerformed

    }//GEN-LAST:event_cbbYearActionPerformed

    public static String convertDateFormat(String dateStr) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate date = LocalDate.parse(dateStr, inputFormatter);
            return date.format(outputFormatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String validateDates(String fromDateStr, String toDateStr, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        if (!isValidDate(fromDateStr, formatter)) {
            return "Ngày bắt đầu không đúng định dạng dd-MM-yyyy.";
        }

        if (!isValidDate(toDateStr, formatter)) {
            return "Ngày kết thúc không đúng định dạng dd-MM-yyyy.";
        }

        LocalDate fromDate = LocalDate.parse(fromDateStr, formatter);
        LocalDate toDate = LocalDate.parse(toDateStr, formatter);
        LocalDate now = LocalDate.now();

        if (fromDate.isAfter(now)) {
            return "Ngày bắt đầu không được vượt quá thời gian hiện tại.";
        }

        if (toDate.isAfter(now)) {
            return "Ngày kết thúc không được vượt quá thời gian hiện tại.";
        }

        if (fromDate.isAfter(toDate)) {
            return "Ngày bắt đầu không được lớn hơn ngày kết thúc.";
        }

        return null;
    }

    private static boolean isValidDate(String dateStr, DateTimeFormatter formatter) {
        try {
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private void exportTableToSheet(JTable table, Sheet sheet) {
        int rowCount = table.getRowCount();
        int columnCount = table.getColumnCount();

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columnCount; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(table.getColumnName(i));
        }
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(table.getValueAt(i, j).toString());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ThongKeSPTable;
    private javax.swing.JTable ThongKeTheoMocTimeTable;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnLoc;
    private javax.swing.JComboBox<String> cbbYear;
    private javax.swing.JComboBox<String> cboHTTK;
    private javax.swing.JComboBox<String> cboLoaiSP;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JComboBox<String> cboThuongHieu;
    private javax.swing.JComboBox<String> cboXuatXu;
    private javax.swing.JPanel chartPanel;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbDoanhThu7NgayGanNhat;
    private javax.swing.JLabel lbDoanhThuHomNay;
    private javax.swing.JLabel lbDoanhThuNamNay;
    private javax.swing.JLabel lbDoanhThuThangHienTai;
    private javax.swing.JLabel lbSPDangKinhDoanh;
    private javax.swing.JLabel lbSPHetHang;
    private javax.swing.JLabel lbSPNgungKinhDoanh;
    private javax.swing.JLabel lbSPSapHetHang;
    private javax.swing.JTextField txtDenNgay;
    private javax.swing.JTextField txtNgayTu;
    // End of variables declaration//GEN-END:variables
}
