/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.BanHang.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import raven.DBConnect.DBConnect;
import raven.entity.Anh;
import raven.entity.ChatLieu;
import raven.entity.HinhThucThanhToan;
import raven.entity.HoaDon;
import raven.entity.HoaDonChiTiet;
import raven.entity.KhachHang;
import raven.entity.KichThuoc;
import raven.entity.KieuAo;
import raven.entity.Mau;
import raven.entity.PhieuGiamGiaHoaDon;
import raven.entity.SanPham;
import raven.entity.SanPhamChiTiet;
import raven.entity.ThuongHieu;
import raven.entity.VaiTro;
import raven.entity.XuatXu;

/**
 *
 * @author Nguyen Nam Truong
 */
public class HoaDonRepositoryV1 {

    private Connection con = null;

    private PreparedStatement ps = null;

    private ResultSet rs = null;

    private String sql = null;
    
    
    
    
    public boolean isKhachHangExists(int idKhachHang) {
    String sqlCheck = "SELECT COUNT(*) FROM khach_hang WHERE id = ?";
    try {
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sqlCheck);
        ps.setInt(1, idKhachHang);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return false;
}
    
    
    public void addHDV2(HoaDon x, int idKhachHang) {
    if (!isKhachHangExists(idKhachHang)) {
        System.out.println("Khách hàng không tồn tại. Không thể thêm hóa đơn.");
        return;
    }

    String sql = "INSERT INTO hoa_don (ma_hd, id_nv, id_kh, trang_thai, tien_khach_dua, tien_chuyen_khoan) VALUES (?, 2, ?, 0, 0, 0)";
    try {
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setObject(1, x.getMaHd());
        ps.setObject(2, idKhachHang);
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    
    

    
//
//public void addHDV2(HoaDon x, int idKhachHang) {
//    sql = "INSERT INTO hoa_don (ma_hd,id_nv, id_kh, trang_thai, tien_khach_dua, tien_chuyen_khoan) VALUES (?,2, ?, 0, 0, 0)";
//    try {
//        con = DBConnect.getConnection();
//        ps = con.prepareStatement(sql);
//        ps.setObject(1, x.getMaHd());
//                ps.setObject(2, idKhachHang);
//        ps.executeUpdate();
//    } catch (Exception e) {
//        e.printStackTrace();
//    } finally {
//        try {
//            if (ps != null) ps.close();
//            if (con != null) con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}



public List<HoaDon> getAllHoaDon() {
    String sql = """
                 SELECT h.id, h.ma_hd, c.ho_ten, kh.id AS kh_id, kh.ten_kh, kh.sdt, h.create_at, h.trang_thai, 
                        h.tong_tien, p.ten_phieu_giam_gia, h.tien_khach_dua, h.tien_chuyen_khoan, h.tien_thua 
                 FROM hoa_don h
                 LEFT JOIN vai_tro c ON h.id_nv = c.id
                 LEFT JOIN khach_hang kh ON h.id_kh = kh.id
                 LEFT JOIN phieu_giam_gia_theo_hoa_don p ON h.id_phieu_gg = p.id
                 WHERE h.trang_thai = 0
                 """;

    List<HoaDon> hoaDonList = new ArrayList<>();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        // Connect to the database
        con = DBConnect.getConnection();

        // Create PreparedStatement object
        ps = con.prepareStatement(sql);

        // Execute query
        rs = ps.executeQuery();

        // Process query results
        while (rs.next()) {
            HoaDon hoaDon = new HoaDon();
            hoaDon.setId(rs.getInt("id"));
            hoaDon.setMaHd(rs.getString("ma_hd"));
            hoaDon.setCreateAt(rs.getDate("create_at"));
            hoaDon.setTrangThai(rs.getBoolean("trang_thai"));
            hoaDon.setTongTien(rs.getDouble("tong_tien"));
            hoaDon.setTienKhachDua(rs.getDouble("tien_khach_dua"));
            hoaDon.setTienChuyenKhoan(rs.getDouble("tien_chuyen_khoan"));
            hoaDon.setTienThua(rs.getDouble("tien_thua"));

            KhachHang khachHang = new KhachHang();
            khachHang.setId(rs.getInt("kh_id"));
            khachHang.setTenKh(rs.getString("ten_kh"));
            khachHang.setSdt(rs.getString("sdt"));
            hoaDon.setKh(khachHang);

            VaiTro vaiTro = new VaiTro();
            vaiTro.setHoTen(rs.getString("ho_ten"));
            hoaDon.setNv(vaiTro);

            PhieuGiamGiaHoaDon phieuGiamGiaHoaDon = new PhieuGiamGiaHoaDon();
            phieuGiamGiaHoaDon.setTen(rs.getString("ten_phieu_giam_gia"));
            hoaDon.setPhieuGiamGiaHoaDon(phieuGiamGiaHoaDon);

            hoaDonList.add(hoaDon);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Ensure connections are closed
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return hoaDonList;
}


        
        
        
    public void delete(Integer id) {
        sql = "update hoa_don set trang_thai = 1 where id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    



public boolean updateHoaDonAndInsertHTTT(HoaDon hoaDon, double tienKhachDua, double tienChuyenKhoan, int idHTTT, int idPhieuGG, double giaTriGiam, double tienThua) {
    String sqlUpdateHoaDon = "UPDATE hoa_don SET \n" +
                              "id_kh = ?, \n" +
                              "id_phieu_gg = ?, \n" +
                              "tien_khach_dua = ?, \n" +
                              "tien_chuyen_khoan = ?, \n" +
                              "giam_gia = ?, \n" +
                              "tien_thua = ? \n" +
                              "WHERE id = ?";
    
    String sqlInsertHTTT = "INSERT INTO httt_hoadon (id_hoadon, id_httt, trang_thai) VALUES (?, ?, ?)";
    
    String sqlUpdateTrangThai = "UPDATE hoa_don SET trang_thai = 1 WHERE id = ?";
    
    Connection con = null;
    PreparedStatement psUpdate = null;
    PreparedStatement psInsert = null;
    PreparedStatement psUpdateTrangThai = null;

    try {
        con = DBConnect.getConnection();
        con.setAutoCommit(false);
        
        psUpdate = con.prepareStatement(sqlUpdateHoaDon);
        psUpdate.setInt(1, hoaDon.getKh().getId()); 
        psUpdate.setInt(2, idPhieuGG); 
        psUpdate.setDouble(3, tienKhachDua); 
        psUpdate.setDouble(4, tienChuyenKhoan); 
        psUpdate.setDouble(5, giaTriGiam); 
        psUpdate.setDouble(6, tienThua); 
        psUpdate.setInt(7, hoaDon.getId()); 
        psUpdate.executeUpdate();

        psInsert = con.prepareStatement(sqlInsertHTTT);
        psInsert.setInt(1, hoaDon.getId()); 
        psInsert.setInt(2, idHTTT); 
        psInsert.setInt(3, 0); 
        psInsert.executeUpdate();
        

        psUpdateTrangThai = con.prepareStatement(sqlUpdateTrangThai);
        psUpdateTrangThai.setInt(1, hoaDon.getId()); 
        psUpdateTrangThai.executeUpdate();

 
        con.commit();
        return true; 
    } catch (Exception e) {
        e.printStackTrace();
        // Nếu có lỗi, rollback giao dịch
        if (con != null) {
            try {
                con.rollback();
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
        return false; // Cập nhật thất bại
    } finally {
        // Đảm bảo đóng kết nối
        try {
            if (psUpdate != null) psUpdate.close();
            if (psInsert != null) psInsert.close();
            if (psUpdateTrangThai != null) psUpdateTrangThai.close();
            if (con != null) con.close();
        } catch (Exception closeEx) {
            closeEx.printStackTrace();
        }
    }
}

public HoaDon findByIdHoaDon(int id) {
    String sql = "SELECT * FROM hoa_don WHERE id = ?";
    HoaDon hoaDon = null; // Khởi tạo là null và chỉ khởi tạo khi có dữ liệu hợp lệ
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        // Lấy kết nối cơ sở dữ liệu
        con = DBConnect.getConnection();
        // Tạo câu lệnh SQL
        ps = con.prepareStatement(sql);
        ps.setInt(1, id); // Đặt tham số ID vào câu lệnh SQL
        // Thực thi câu lệnh
        rs = ps.executeQuery();

        // Xử lý kết quả truy vấn
        if (rs.next()) { // Sử dụng if thay vì while vì ID là duy nhất
            hoaDon = new HoaDon();
            hoaDon.setId(rs.getInt("id"));
            hoaDon.setCreateAt(rs.getDate("create_at"));
            hoaDon.setTrangThai(rs.getBoolean("trang_thai"));
            hoaDon.setTongTien(rs.getDouble("tong_tien"));
            hoaDon.setTienKhachDua(rs.getDouble("tien_khach_dua"));
            hoaDon.setTienThua(rs.getDouble("tien_thua"));
            hoaDon.setTienChuyenKhoan(rs.getDouble("tien_chuyen_khoan"));
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Xử lý ngoại lệ
    } finally {
        // Đảm bảo đóng tài nguyên
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ
        }
    }

    return hoaDon; // Trả về hóa đơn hoặc null nếu không tìm thấy
}





}
