package raven.application.form.other.thongke;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import raven.DBConnect.DBConnect;

public class ThongKeRepository {

    public List<ChatLieuResponse> fillCBBChatLieu() {
        List<ChatLieuResponse> clrs = new ArrayList<>();
        String sql = "select * from chat_lieu";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieuResponse chatLieuResponse = new ChatLieuResponse();
                chatLieuResponse.setMa(rs.getString("ma_chat_lieu"));
                chatLieuResponse.setTen(rs.getString("ten_loai_vai"));
                clrs.add(chatLieuResponse);
            }
            return clrs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ThuongHieuResponse> fillCBBThuongHieu() {
        List<ThuongHieuResponse> clrs = new ArrayList<>();
        String sql = "select * from thuong_hieu";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuongHieuResponse hieuResponse = new ThuongHieuResponse();
                hieuResponse.setThuongHieu(rs.getString("ten_thuong_hieu"));
                clrs.add(hieuResponse);
            }
            return clrs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<XuatXuResponse> fillCBBXuatXu() {
        List<XuatXuResponse> clrs = new ArrayList<>();
        String sql = "select * from xuat_xu";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                XuatXuResponse response = new XuatXuResponse();
                response.setXuatXu(rs.getString("dia_chi"));
                clrs.add(response);
            }
            return clrs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SizeResponse> fillCBBSize() {
        List<SizeResponse> clrs = new ArrayList<>();
        String sql = "select * from kich_thuoc";
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SizeResponse response = new SizeResponse();
                response.setSize(rs.getString("size"));
                clrs.add(response);
            }
            return clrs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPhamResponse> getSP() {
        List<SanPhamResponse> clrs = new ArrayList<>();
        String sql = """
                    SELECT 
                        sp.ma_san_pham,
                        sp.ten_san_pham,
                        th.ten_thuong_hieu,
                        cl.ten_loai_vai,
                        kt.size,
                        xx.dia_chi,
                        spct.so_luong AS soluongton,
                        spct.gia AS dongia,
                        SUM(hdct.so_luong) AS soluongbanduoc,
                        SUM(hdct.so_luong * spct.gia) AS doanhthu
                    FROM 
                        dbo.hoa_don AS hd
                    INNER JOIN
                        dbo.hoa_don_ct AS hdct ON hd.id = hdct.id_hoa_don
                    INNER JOIN 
                        dbo.vai_tro AS vt ON hd.id_nv = vt.id
                    INNER JOIN 
                        dbo.khach_hang AS kh ON hd.id_kh = kh.id
                    INNER JOIN 
                        dbo.san_pham_chi_tiet AS spct ON hdct.id_spct = spct.id
                    INNER JOIN 
                        dbo.san_pham AS sp ON spct.id_sp = sp.id
                    INNER JOIN 
                        dbo.thuong_hieu AS th ON spct.id_thuong_hieu = th.id
                    INNER JOIN 
                        dbo.xuat_xu AS xx ON spct.id_xuat_xu = xx.id
                    INNER JOIN 
                        dbo.kich_thuoc AS kt ON spct.id_kich_thuoc = kt.id
                    INNER JOIN 
                        dbo.chat_lieu AS cl ON spct.id_chat_lieu = cl.id
                    WHERE 
                        hd.trang_thai = 1
                    GROUP BY 
                        sp.ma_san_pham, 
                        sp.ten_san_pham, 
                        th.ten_thuong_hieu, 
                        cl.ten_loai_vai, 
                        kt.size, 
                        xx.dia_chi, 
                        spct.so_luong, 
                        spct.gia;
                    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamResponse phamResponse = new SanPhamResponse();
                phamResponse.setMaSP(rs.getString(1));
                phamResponse.setTenSP(rs.getString(2));
                phamResponse.setThuongHieu(rs.getString(3));
                phamResponse.setChatLieu(rs.getString(4));
                phamResponse.setSize(rs.getString(5));
                phamResponse.setXuatXu(rs.getString(6));
                phamResponse.setSoLuongTon(rs.getInt(7));
                phamResponse.setDonGia(rs.getInt(8));
                phamResponse.setSoLuongBan(rs.getInt(9));
                phamResponse.setDoanhThu(rs.getInt(10));
                clrs.add(phamResponse);
            }
            return clrs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int soSanPhamDangKinhDoanh() {
        String sql = """
                   select COUNT(*) from san_pham_chi_tiet where trang_thai = 1
                   """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public int soSanPhamHetHang() {
        String sql = """
                    select COUNT(*) from san_pham_chi_tiet where so_luong = 0
                   """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public int soSanPhamSapHetHang() {
        String sql = """
                   select COUNT(*) from san_pham_chi_tiet where so_luong<=5 and so_luong>0
                   """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public int soSanPhamNgungKinhDoanh() {
        String sql = """
                   select COUNT(*) from san_pham_chi_tiet where trang_thai = 0
                   """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public List<SanPhamResponse> get(ThongKeModel thongKeModel) {
        List<SanPhamResponse> clrs = new ArrayList<>();
        String sql = """
                     SELECT 
                             sp.ma_san_pham,
                             sp.ten_san_pham,
                             th.ten_thuong_hieu,
                             cl.ten_loai_vai,
                             kt.size,
                             xx.dia_chi,
                             spct.so_luong AS soluongton,
                             spct.gia AS dongia,
                             SUM(hdct.so_luong) AS soluongbanduoc,
                             SUM(hdct.so_luong * spct.gia) AS doanhthu
                         FROM 
                             dbo.hoa_don AS hd
                         INNER JOIN
                             dbo.hoa_don_ct AS hdct ON hd.id = hdct.id_hoa_don
                         INNER JOIN 
                             dbo.vai_tro AS vt ON hd.id_nv = vt.id
                         INNER JOIN 
                             dbo.khach_hang AS kh ON hd.id_kh = kh.id
                         INNER JOIN 
                             dbo.san_pham_chi_tiet AS spct ON hdct.id_spct = spct.id
                         INNER JOIN 
                             dbo.san_pham AS sp ON spct.id_sp = sp.id
                         INNER JOIN 
                             dbo.thuong_hieu AS th ON spct.id_thuong_hieu = th.id
                         INNER JOIN 
                             dbo.xuat_xu AS xx ON spct.id_xuat_xu = xx.id
                         INNER JOIN 
                             dbo.kich_thuoc AS kt ON spct.id_kich_thuoc = kt.id
                         INNER JOIN 
                             dbo.chat_lieu AS cl ON spct.id_chat_lieu = cl.id
                         WHERE 
                             (cl.ten_loai_vai = ? OR ? IS NULL OR ? = '') AND
                             (th.ten_thuong_hieu = ? OR ? IS NULL OR ? = '') AND
                             (xx.dia_chi = ? OR ? IS NULL OR ? = '') AND 
                             (kt.size = ? OR ? IS NULL OR ? = '') AND 
                             hd.trang_thai = 1
                         GROUP BY 
                             sp.ma_san_pham,
                             sp.ten_san_pham,
                             th.ten_thuong_hieu,
                             cl.ten_loai_vai,
                             kt.size,
                             xx.dia_chi,
                             spct.so_luong,
                             spct.gia;
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, thongKeModel.getChatLieu());
            ps.setString(2, thongKeModel.getChatLieu());
            ps.setString(3, thongKeModel.getChatLieu());
            ps.setString(4, thongKeModel.getThuongHieu());
            ps.setString(5, thongKeModel.getThuongHieu());
            ps.setString(6, thongKeModel.getThuongHieu());
            ps.setString(7, thongKeModel.getXuatXu());
            ps.setString(8, thongKeModel.getXuatXu());
            ps.setString(9, thongKeModel.getXuatXu());
            ps.setString(10, thongKeModel.getSize());
            ps.setString(11, thongKeModel.getSize());
            ps.setString(12, thongKeModel.getSize());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamResponse phamResponse = new SanPhamResponse();
                phamResponse.setMaSP(rs.getString(1));
                phamResponse.setTenSP(rs.getString(2));
                phamResponse.setThuongHieu(rs.getString(3));
                phamResponse.setChatLieu(rs.getString(4));
                phamResponse.setSize(rs.getString(5));
                phamResponse.setXuatXu(rs.getString(6));
                phamResponse.setSoLuongTon(rs.getInt(7));
                phamResponse.setDonGia(rs.getInt(8));
                phamResponse.setSoLuongBan(rs.getInt(9));
                phamResponse.setDoanhThu(rs.getInt(10));
                clrs.add(phamResponse);
            }
            return clrs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPhamResponse> SPDoanhThuCaoNhat() {
        List<SanPhamResponse> clrs = new ArrayList<>();
        String sql = """
                     WITH ProductSales AS (
                             SELECT 
                                 sp.ma_san_pham,
                                 sp.ten_san_pham,
                                 th.ten_thuong_hieu,
                                 cl.ten_loai_vai,
                                 kt.size,
                                 xx.dia_chi,
                                 spct.so_luong AS soluongton,
                                 spct.gia AS dongia,
                                 SUM(hdct.so_luong) AS soluongbanduoc,
                                 SUM(hdct.so_luong * spct.gia) AS doanhthu
                             FROM 
                                 dbo.hoa_don AS hd
                             INNER JOIN
                                 dbo.hoa_don_ct AS hdct ON hd.id = hdct.id_hoa_don
                             INNER JOIN 
                                 dbo.vai_tro AS vt ON hd.id_nv = vt.id
                             INNER JOIN 
                                 dbo.khach_hang AS kh ON hd.id_kh = kh.id
                             INNER JOIN 
                                 dbo.san_pham_chi_tiet AS spct ON hdct.id_spct = spct.id
                             INNER JOIN 
                                 dbo.san_pham AS sp ON spct.id_sp = sp.id
                             INNER JOIN 
                                 dbo.thuong_hieu AS th ON spct.id_thuong_hieu = th.id
                             INNER JOIN 
                                 dbo.xuat_xu AS xx ON spct.id_xuat_xu = xx.id
                             INNER JOIN 
                                 dbo.kich_thuoc AS kt ON spct.id_kich_thuoc = kt.id
                             INNER JOIN 
                                 dbo.chat_lieu AS cl ON spct.id_chat_lieu = cl.id
                             WHERE 
                                 hd.trang_thai = 1
                             GROUP BY 
                                 sp.ma_san_pham,
                                 sp.ten_san_pham,
                                 th.ten_thuong_hieu,
                                 cl.ten_loai_vai,
                                 kt.size,
                                 xx.dia_chi,
                                 spct.so_luong,
                                 spct.gia
                         ),
                         MaxDoanhThu AS (
                             SELECT 
                                 MAX(doanhthu) AS maxDoanhThu
                             FROM 
                                 ProductSales
                         )
                         SELECT 
                             ps.ma_san_pham,
                             ps.ten_san_pham,
                             ps.ten_thuong_hieu,
                             ps.ten_loai_vai,
                             ps.size,
                             ps.dia_chi,
                             ps.soluongton,
                             ps.dongia,
                             ps.soluongbanduoc,
                             ps.doanhthu
                         FROM 
                             ProductSales ps
                         INNER JOIN 
                             MaxDoanhthu md ON ps.doanhthu = md.maxDoanhThu
                         ORDER BY 
                             ps.doanhthu desc;
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamResponse phamResponse = new SanPhamResponse();
                phamResponse.setMaSP(rs.getString(1));
                phamResponse.setTenSP(rs.getString(2));
                phamResponse.setThuongHieu(rs.getString(3));
                phamResponse.setChatLieu(rs.getString(4));
                phamResponse.setSize(rs.getString(5));
                phamResponse.setXuatXu(rs.getString(6));
                phamResponse.setSoLuongTon(rs.getInt(7));
                phamResponse.setDonGia(rs.getInt(8));
                phamResponse.setSoLuongBan(rs.getInt(9));
                phamResponse.setDoanhThu(rs.getInt(10));
                clrs.add(phamResponse);
            }
            return clrs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPhamResponse> SPDoanhThuThapNhat() {
        List<SanPhamResponse> clrs = new ArrayList<>();
        String sql = """
                 WITH ProductSales AS (
                     SELECT 
                         sp.ma_san_pham,
                         sp.ten_san_pham,
                         th.ten_thuong_hieu,
                         cl.ten_loai_vai,
                         kt.size,
                         xx.dia_chi,
                         spct.so_luong AS soluongton,
                         spct.gia AS dongia,
                         SUM(hdct.so_luong) AS soluongbanduoc,
                         SUM(hdct.so_luong * spct.gia) AS doanhthu
                     FROM 
                         dbo.hoa_don AS hd
                     INNER JOIN
                         dbo.hoa_don_ct AS hdct ON hd.id = hdct.id_hoa_don
                     INNER JOIN 
                         dbo.vai_tro AS vt ON hd.id_nv = vt.id
                     INNER JOIN 
                         dbo.khach_hang AS kh ON hd.id_kh = kh.id
                     INNER JOIN 
                         dbo.san_pham_chi_tiet AS spct ON hdct.id_spct = spct.id
                     INNER JOIN 
                         dbo.san_pham AS sp ON spct.id_sp = sp.id
                     INNER JOIN 
                         dbo.thuong_hieu AS th ON spct.id_thuong_hieu = th.id
                     INNER JOIN 
                         dbo.xuat_xu AS xx ON spct.id_xuat_xu = xx.id
                     INNER JOIN 
                         dbo.kich_thuoc AS kt ON spct.id_kich_thuoc = kt.id
                     INNER JOIN 
                         dbo.chat_lieu AS cl ON spct.id_chat_lieu = cl.id
                     WHERE 
                         hd.trang_thai = 1
                     GROUP BY 
                         sp.ma_san_pham,
                         sp.ten_san_pham,
                         th.ten_thuong_hieu,
                         cl.ten_loai_vai,
                         kt.size,
                         xx.dia_chi,
                         spct.so_luong,
                         spct.gia
                 ),
                 MinDoanhThu AS (
                     SELECT 
                         MIN(doanhthu) AS minDoanhThu
                     FROM 
                         ProductSales
                 )
                 SELECT 
                     ps.ma_san_pham,
                     ps.ten_san_pham,
                     ps.ten_thuong_hieu,
                     ps.ten_loai_vai,
                     ps.size,
                     ps.dia_chi,
                     ps.soluongton,
                     ps.dongia,
                     ps.soluongbanduoc,
                     ps.doanhthu
                 FROM 
                     ProductSales ps
                 INNER JOIN 
                     MinDoanhThu md ON ps.doanhthu = md.minDoanhThu
                 ORDER BY 
                     ps.doanhthu ASC;
                 """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamResponse phamResponse = new SanPhamResponse();
                phamResponse.setMaSP(rs.getString(1));
                phamResponse.setTenSP(rs.getString(2));
                phamResponse.setThuongHieu(rs.getString(3));
                phamResponse.setChatLieu(rs.getString(4));
                phamResponse.setSize(rs.getString(5));
                phamResponse.setXuatXu(rs.getString(6));
                phamResponse.setSoLuongTon(rs.getInt(7));
                phamResponse.setDonGia(rs.getInt(8));
                phamResponse.setSoLuongBan(rs.getInt(9));
                phamResponse.setDoanhThu(rs.getInt(10));
                clrs.add(phamResponse);
            }
            return clrs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPhamResponse> SPBanChayNhat() {
        List<SanPhamResponse> clrs = new ArrayList<>();
        String sql = """
                     WITH ProductSales AS (
                                          SELECT 
                                              sp.ma_san_pham,
                                              sp.ten_san_pham,
                                              th.ten_thuong_hieu,
                                              cl.ten_loai_vai,
                                              kt.size,
                                              xx.dia_chi,
                                              spct.so_luong AS soluongton,
                                              spct.gia AS dongia,
                                              SUM(hdct.so_luong) AS soluongbanduoc,
                                              SUM(hdct.so_luong * spct.gia) AS doanhthu
                                          FROM 
                                              dbo.hoa_don AS hd
                                          INNER JOIN
                                              dbo.hoa_don_ct AS hdct ON hd.id = hdct.id_hoa_don
                                          INNER JOIN 
                                              dbo.vai_tro AS vt ON hd.id_nv = vt.id
                                          INNER JOIN 
                                              dbo.khach_hang AS kh ON hd.id_kh = kh.id
                                          INNER JOIN 
                                              dbo.san_pham_chi_tiet AS spct ON hdct.id_spct = spct.id
                                          INNER JOIN 
                                              dbo.san_pham AS sp ON spct.id_sp = sp.id
                                          INNER JOIN 
                                              dbo.thuong_hieu AS th ON spct.id_thuong_hieu = th.id
                                          INNER JOIN 
                                              dbo.xuat_xu AS xx ON spct.id_xuat_xu = xx.id
                                          INNER JOIN 
                                              dbo.kich_thuoc AS kt ON spct.id_kich_thuoc = kt.id
                                          INNER JOIN 
                                              dbo.chat_lieu AS cl ON spct.id_chat_lieu = cl.id
                                          WHERE 
                                              hd.trang_thai = 1
                                          GROUP BY 
                                              sp.ma_san_pham,
                                              sp.ten_san_pham,
                                              th.ten_thuong_hieu,
                                              cl.ten_loai_vai,
                                              kt.size,
                                              xx.dia_chi,
                                              spct.so_luong,
                                              spct.gia
                                      ),
                                      MaxSoLuong AS (
                                          SELECT 
                                              MAX(soluongbanduoc) AS MaxSoLuong
                                          FROM 
                                              ProductSales
                                      )
                                      SELECT 
                                          ps.ma_san_pham,
                                          ps.ten_san_pham,
                                          ps.ten_thuong_hieu,
                                          ps.ten_loai_vai,
                                          ps.size,
                                          ps.dia_chi,
                                          ps.soluongton,
                                          ps.dongia,
                                          ps.soluongbanduoc,
                                          ps.doanhthu
                                      FROM 
                                          ProductSales ps
                                      INNER JOIN 
                                          MaxSoLuong ms ON ps.soluongbanduoc = ms.MaxSoLuong
                                      ORDER BY 
                                          ps.soluongbanduoc DESC;
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamResponse phamResponse = new SanPhamResponse();
                phamResponse.setMaSP(rs.getString(1));
                phamResponse.setTenSP(rs.getString(2));
                phamResponse.setThuongHieu(rs.getString(3));
                phamResponse.setChatLieu(rs.getString(4));
                phamResponse.setSize(rs.getString(5));
                phamResponse.setXuatXu(rs.getString(6));
                phamResponse.setSoLuongTon(rs.getInt(7));
                phamResponse.setDonGia(rs.getInt(8));
                phamResponse.setSoLuongBan(rs.getInt(9));
                phamResponse.setDoanhThu(rs.getInt(10));
                clrs.add(phamResponse);
            }
            return clrs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPhamResponse> SPBanItNhat() {
        List<SanPhamResponse> clrs = new ArrayList<>();
        String sql = """
                     WITH ProductSales AS (
                                          SELECT 
                                              sp.ma_san_pham,
                                              sp.ten_san_pham,
                                              th.ten_thuong_hieu,
                                              cl.ten_loai_vai,
                                              kt.size,
                                              xx.dia_chi,
                                              spct.so_luong AS soluongton,
                                              spct.gia AS dongia,
                                              SUM(hdct.so_luong) AS soluongbanduoc,
                                              SUM(hdct.so_luong * spct.gia) AS doanhthu
                                          FROM 
                                              dbo.hoa_don AS hd
                                          INNER JOIN
                                              dbo.hoa_don_ct AS hdct ON hd.id = hdct.id_hoa_don
                                          INNER JOIN 
                                              dbo.vai_tro AS vt ON hd.id_nv = vt.id
                                          INNER JOIN 
                                              dbo.khach_hang AS kh ON hd.id_kh = kh.id
                                          INNER JOIN 
                                              dbo.san_pham_chi_tiet AS spct ON hdct.id_spct = spct.id
                                          INNER JOIN 
                                              dbo.san_pham AS sp ON spct.id_sp = sp.id
                                          INNER JOIN 
                                              dbo.thuong_hieu AS th ON spct.id_thuong_hieu = th.id
                                          INNER JOIN 
                                              dbo.xuat_xu AS xx ON spct.id_xuat_xu = xx.id
                                          INNER JOIN 
                                              dbo.kich_thuoc AS kt ON spct.id_kich_thuoc = kt.id
                                          INNER JOIN 
                                              dbo.chat_lieu AS cl ON spct.id_chat_lieu = cl.id
                                          WHERE 
                                              hd.trang_thai = 1
                                          GROUP BY 
                                              sp.ma_san_pham,
                                              sp.ten_san_pham,
                                              th.ten_thuong_hieu,
                                              cl.ten_loai_vai,
                                              kt.size,
                                              xx.dia_chi,
                                              spct.so_luong,
                                              spct.gia
                                      ),
                                      MinSoLuong AS (
                                          SELECT 
                                              MIN(soluongbanduoc) AS MinSoLuong
                                          FROM 
                                              ProductSales
                                      )
                                      SELECT 
                                          ps.ma_san_pham,
                                          ps.ten_san_pham,
                                          ps.ten_thuong_hieu,
                                          ps.ten_loai_vai,
                                          ps.size,
                                          ps.dia_chi,
                                          ps.soluongton,
                                          ps.dongia,
                                          ps.soluongbanduoc,
                                          ps.doanhthu
                                      FROM 
                                          ProductSales ps
                                      INNER JOIN 
                                          MinSoLuong ms ON ps.soluongbanduoc = ms.MinSoLuong
                                      ORDER BY 
                                          ps.soluongbanduoc ASC;
                     """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamResponse phamResponse = new SanPhamResponse();
                phamResponse.setMaSP(rs.getString(1));
                phamResponse.setTenSP(rs.getString(2));
                phamResponse.setThuongHieu(rs.getString(3));
                phamResponse.setChatLieu(rs.getString(4));
                phamResponse.setSize(rs.getString(5));
                phamResponse.setXuatXu(rs.getString(6));
                phamResponse.setSoLuongTon(rs.getInt(7));
                phamResponse.setDonGia(rs.getInt(8));
                phamResponse.setSoLuongBan(rs.getInt(9));
                phamResponse.setDoanhThu(rs.getInt(10));
                clrs.add(phamResponse);
            }
            return clrs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public double getDoanhThuCaNam(int year) {
        String sql = """
        select SUM(hoa_don.tong_tien) 
        from hoa_don_ct 
        join hoa_don on hoa_don.id = hoa_don_ct.id_hoa_don 
        where YEAR(hoa_don_ct.create_at) = ? and hoa_don.trang_thai = 1
    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, year);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0.0;
    }

    public double getDoanhThuToDay(LocalDate toDay) {
        String sql = """
        SELECT SUM(hoa_don.tong_tien) AS doanhThu
        FROM hoa_don_ct
        JOIN hoa_don ON hoa_don.id = hoa_don_ct.id_hoa_don
        WHERE CAST(hoa_don_ct.create_at AS DATE) = ? AND hoa_don.trang_thai = 1;
    """;

        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            // Chuyển đổi LocalDate thành java.sql.Date
            ps.setDate(1, java.sql.Date.valueOf(toDay));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0.0;
    }

    public double getDoanhThu7NgayGanNhat() {
        String sql = """
        SELECT SUM(hoa_don.tong_tien) AS doanhThu
        FROM hoa_don_ct
        JOIN hoa_don ON hoa_don.id = hoa_don_ct.id_hoa_don
        WHERE CAST(hoa_don_ct.create_at AS DATE) >= CAST(DATEADD(DAY, -7, GETDATE()) AS DATE) 
          AND hoa_don.trang_thai = 1;
    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0.0;
    }

    public double getDoanhThuThangNay(LocalDate firstDayInMonth, LocalDate toDay) {
        String sql = """
        SELECT SUM(hoa_don.tong_tien) AS doanhThu
        FROM hoa_don_ct
        JOIN hoa_don ON hoa_don.id = hoa_don_ct.id_hoa_don
        WHERE CAST(hoa_don_ct.create_at AS DATE) BETWEEN ? AND ?
          AND hoa_don.trang_thai = 1;
    """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(firstDayInMonth));
            ps.setDate(2, java.sql.Date.valueOf(toDay));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0.0;
    }

    public List<ThoiGianResponse> LocDoanhThuTheoNgay(String from, String to) {
        String sql = """
                 	SELECT 
                            CAST(hoa_don_ct.create_at AS DATE) AS ngayTao,
                            SUM(hoa_don.tong_tien) AS doanhThu
                        FROM 
                            hoa_don_ct
                        JOIN 
                            hoa_don ON hoa_don.id = hoa_don_ct.id_hoa_don
                        WHERE 
                            CAST(hoa_don_ct.create_at AS DATE) BETWEEN ? AND ?
                            AND hoa_don.trang_thai = 1
                        GROUP BY 
                            CAST(hoa_don_ct.create_at AS DATE)
                   """;
        List<ThoiGianResponse> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, from);
            ps.setObject(2, to);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThoiGianResponse gianResponse = new ThoiGianResponse();
                gianResponse.setNgayTao(rs.getDate("ngayTao").toLocalDate());
                gianResponse.setDoanhThu(rs.getDouble("doanhThu"));
                list.add(gianResponse);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public ThongKe ThongKeChart(int month, int year) {
        String sql = """
                   select	SUM(hoa_don.tong_tien) tongTienHang,
                                      		MONTH(hoa_don_ct.create_at) thang
                                      from hoa_don_ct 
                           join hoa_don on hoa_don.id = hoa_don_ct.id_hoa_don 
                                      where MONTH(hoa_don_ct.create_at)=? and YEAR(hoa_don_ct.create_at)=?
                                      group by MONTH(hoa_don_ct.create_at)
                   """;
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, month);
            ps.setObject(2, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setTongTien(rs.getDouble(1));
                tk.setThang(rs.getInt(2));
                return tk;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Object[]> listYear() {
        String sql = """
                  	    select distinct YEAR(hoa_don_ct.create_at) ngayTao from hoa_don_ct
                   """;
        String cols[] = {"ngayTao"};
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<Object[]> list = new ArrayList<>();
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
