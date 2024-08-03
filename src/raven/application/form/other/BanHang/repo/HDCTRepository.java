/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.BanHang.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import raven.DBConnect.DBConnect;
import raven.entity.HoaDon;
import raven.entity.HoaDonChiTiet;
import raven.entity.SanPham;
import raven.entity.SanPhamChiTiet;
import raven.entity.VaiTro;

/**
 *
 * @author Nguyen Nam Truong
 */
public class HDCTRepository {
     private Connection con = null;
    
    private PreparedStatement ps = null;
    private PreparedStatement psv = null;
    
    private ResultSet rs = null;
    
    private String sql = null;
    
    

//     
//     public void addHDCTV2(HoaDonChiTiet x) {
//            String sqlInsert = "insert into hoa_don_ct(id_spct, id_hoa_don, so_luong, gia, trang_thai) values (?, ?, ?, ?, 0)";
//            String sqlUpdate = "UPDATE san_pham_chi_tiet SET so_luong = so_luong - ? WHERE id = ?";
//            String sqlUpdateV2 = "UPDATE hoa_don " +
//                                 "SET tong_tien = ( " +
//                                 "    SELECT SUM(c.so_luong * c.gia) " +
//                                 "    FROM hoa_don_ct c " +
//                                 "    WHERE hoa_don.id = c.id_hoa_don " +
//                                 ") " +
//                                 "WHERE hoa_don.id = ?";
//
//    try {
//        con = DBConnect.getConnection();
//        ps = con.prepareStatement(sqlInsert);
//        ps.setInt(1, x.getSpct().getId());
//        ps.setInt(2, x.getHd().getId());
//        ps.setInt(3, x.getSoLuong());
//        ps.setDouble(4, x.getGia());
//        ps.executeUpdate();
//
//        psv = con.prepareStatement(sqlUpdate);
//        psv.setInt(1, x.getSoLuong());
//        psv.setInt(2, x.getSpct().getId());
//        psv.executeUpdate();
//
//        ps = con.prepareStatement(sqlUpdateV2);
//        ps.setInt(1, x.getHd().getId());
//        ps.executeUpdate();
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    } finally {
//        try {
//            if (ps != null) ps.close();
//            if (psv != null) psv.close();
//            if (con != null) con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
     
    
    
    
    public void addHDCTV2(HoaDonChiTiet x) {
    String sqlInsert = "insert into hoa_don_ct(id_spct, id_hoa_don, so_luong, gia, trang_thai) values (?, ?, ?, ?, 0)";
    String sqlUpdate = "UPDATE san_pham_chi_tiet SET so_luong = so_luong - ? WHERE id = ?";
    String sqlGetTotalAmount = "SELECT tong_tien FROM hoa_don WHERE id = ?";
    String sqlUpdateTotalAmount = "UPDATE hoa_don SET tong_tien = ? WHERE id = ?";

    Connection con = null;
    PreparedStatement ps = null;
    PreparedStatement psv = null;
    ResultSet rs = null;

    try {
        con = DBConnect.getConnection();
        con.setAutoCommit(false); // Bắt đầu transaction

        // Bước 1: Thêm sản phẩm vào bảng hoa_don_ct
        ps = con.prepareStatement(sqlInsert);
        ps.setInt(1, x.getSpct().getId());
        ps.setInt(2, x.getHd().getId());
        ps.setInt(3, x.getSoLuong());
        ps.setDouble(4, x.getGia());
        ps.executeUpdate();

        // Bước 2: Cập nhật số lượng sản phẩm trong san_pham_chi_tiet
        psv = con.prepareStatement(sqlUpdate);
        psv.setInt(1, x.getSoLuong());
        psv.setInt(2, x.getSpct().getId());
        psv.executeUpdate();

        // Bước 3: Lấy tổng tiền hiện tại của hóa đơn
        ps = con.prepareStatement(sqlGetTotalAmount);
        ps.setInt(1, x.getHd().getId());
        rs = ps.executeQuery();
        
        double currentTotal = 0.0;
        if (rs.next()) {
            currentTotal = rs.getDouble("tong_tien");
        }

        // Bước 4: Tính tổng tiền mới sau khi thêm sản phẩm
        double newTotal = currentTotal + (x.getSoLuong() * x.getGia());

        // Bước 5: Cập nhật tổng tiền mới của hóa đơn
        ps = con.prepareStatement(sqlUpdateTotalAmount);
        ps.setDouble(1, newTotal);
        ps.setInt(2, x.getHd().getId());
        ps.executeUpdate();

        // Commit transaction
        con.commit();

    } catch (Exception e) {
        e.printStackTrace();
        // Rollback transaction if there is an exception
        if (con != null) {
            try {
                con.rollback();
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
    } finally {
        // Ensure that resources are closed
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (psv != null) psv.close();
            if (con != null) con.close();
        } catch (Exception closeEx) {
            closeEx.printStackTrace();
        }
    }
}

     
     
  public void addHDCTV23(HoaDonChiTiet x, int idHoaDon) {
    String sqlInsert = "INSERT INTO hoa_don_ct (id_spct, id_hoa_don, so_luong, gia, trang_thai) VALUES (?, ?, ?, ?, 0)";
    String sqlUpdate = "UPDATE san_pham_chi_tiet SET so_luong = so_luong - ? WHERE id = ?";
    String sqlUpdateV2 = "UPDATE hoa_don " +
                         "SET tong_tien = ( " +
                         "    SELECT SUM(c.so_luong * c.gia) " +
                         "    FROM hoa_don_ct c " +
                         "    WHERE c.id_hoa_don = hoa_don.id " +
                         ") " +
                         "WHERE hoa_don.id = ?";

    Connection con = null;
    PreparedStatement ps = null;
    PreparedStatement psv = null;
    
    try {
        con = DBConnect.getConnection();
        
        // Chèn chi tiết hóa đơn vào cơ sở dữ liệu
        ps = con.prepareStatement(sqlInsert);
        ps.setInt(1, x.getSpct().getId()); // id_spct
        ps.setInt(2, idHoaDon);           // id_hoa_don (truyền vào từ tham số)
        ps.setInt(3, x.getSoLuong());      // so_luong
        ps.setDouble(4, x.getGia());       // gia
        ps.executeUpdate();
        
        // Cập nhật số lượng sản phẩm trong bảng san_pham_chi_tiet
        psv = con.prepareStatement(sqlUpdate);
        psv.setInt(1, x.getSoLuong());    // Giảm số lượng
        psv.setInt(2, x.getSpct().getId()); // id_spct
        psv.executeUpdate();
        
        // Cập nhật tổng tiền trong hóa đơn
        ps = con.prepareStatement(sqlUpdateV2);
        ps.setInt(1, idHoaDon); // id_hoa_don
        ps.executeUpdate();
        
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (ps != null) ps.close();
            if (psv != null) psv.close();
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



     

   
//        
//     public void delete(Integer id) {
//    String selectSql = "SELECT id_spct, so_luong FROM hoa_don_ct WHERE id = ?";
//    String updateStatusSql = "UPDATE hoa_don_ct SET trang_thai = 1 WHERE id = ?";
//    String updateQuantitySql = "UPDATE san_pham_chi_tiet SET so_luong = so_luong + ? WHERE id = ?";
//
//    try {
//        con = DBConnect.getConnection();        
//        // Bước 1: Lấy thông tin chi tiết của hoa_don_ct
//        ps = con.prepareStatement(selectSql);
//        ps.setInt(1, id);
//        rs = ps.executeQuery();
//        if (rs.next()) {
//            int idSpct = rs.getInt("id_spct");
//            int soLuong = rs.getInt("so_luong");
//            // Bước 2: Cập nhật trạng thái của hoa_don_ct
//            ps = con.prepareStatement(updateStatusSql);
//            ps.setInt(1, id);
//            ps.executeUpdate();           
//            // Bước 3: Cập nhật số lượng sản phẩm trong san_pham_chi_tiet
//            psv = con.prepareStatement(updateQuantitySql);
//            psv.setInt(1, soLuong); // Khôi phục số lượng sản phẩm
//            psv.setInt(2, idSpct);
//            psv.executeUpdate();
//        }
//        
//    } catch (Exception e) {
//        e.printStackTrace();
//    } 
    
    
    public void delete(Integer id) {
    String selectSql = "SELECT id_spct, so_luong, id_hoa_don FROM hoa_don_ct WHERE id = ?";
    String updateStatusSql = "UPDATE hoa_don_ct SET trang_thai = 1 WHERE id = ?";
    String updateQuantitySql = "UPDATE san_pham_chi_tiet SET so_luong = so_luong + ? WHERE id = ?";
    String updateTotalSql = "UPDATE hoa_don SET tong_tien = (SELECT SUM(gia * so_luong) FROM hoa_don_ct WHERE id = ?) WHERE id = ?";

    try {
        con = DBConnect.getConnection();        
        // Bước 1: Lấy thông tin chi tiết của hoa_don_ct
        ps = con.prepareStatement(selectSql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            int idSpct = rs.getInt("id_spct");
            int soLuong = rs.getInt("so_luong");
            int idHd = rs.getInt("id_hoa_don");

            // Bước 2: Cập nhật trạng thái của hoa_don_ct
            ps = con.prepareStatement(updateStatusSql);
            ps.setInt(1, id);
            ps.executeUpdate();

            // Bước 3: Cập nhật số lượng sản phẩm trong san_pham_chi_tiet
            psv = con.prepareStatement(updateQuantitySql);
            psv.setInt(1, soLuong); // Khôi phục số lượng sản phẩm
            psv.setInt(2, idSpct);
            psv.executeUpdate();

            // Bước 4: Cập nhật giá thành 0
       

            // Bước 5: Cập nhật tổng tiền của hóa đơn
            ps = con.prepareStatement(updateTotalSql);
            ps.setInt(1, id);
            ps.setInt(2, idHd);
            ps.executeUpdate();
        }
    } catch (Exception e) {
        e.printStackTrace();
    } 
}  
    
    
public List<HoaDonChiTiet> getAllByInvoiceCode(String maHoaDon) {
    String sql = """
            SELECT h.id, 
                   p.ma_san_pham, 
                   p.ten_san_pham, 
                   h.so_luong, 
                   h.gia, 
                   h.trang_thai 
            FROM hoa_don_ct h
            JOIN san_pham_chi_tiet s ON s.id = h.id_spct
            JOIN san_pham p ON s.id_sp = p.id
            JOIN hoa_don hd ON hd.id = h.id_hoa_don
            WHERE h.trang_thai = 0 
              AND hd.ma_hd LIKE ?
            """;

    List<HoaDonChiTiet> arr = new ArrayList<>();
    try (Connection con = DBConnect.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, "%" + maHoaDon + "%"); // Sử dụng '%' để tìm kiếm theo mẫu
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                HoaDonChiTiet x = new HoaDonChiTiet();
                x.setId(rs.getInt("id"));
                
                SanPhamChiTiet spct = new SanPhamChiTiet();
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("ma_san_pham"));
                sp.setTenSanPham(rs.getString("ten_san_pham"));
                spct.setSp(sp);
                x.setSpct(spct);
                
                x.setSoLuong(rs.getInt("so_luong"));
                x.setGia(rs.getDouble("gia"));
                x.setTrangThai(rs.getBoolean("trang_thai"));
                
                arr.add(x);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return arr;
}

 
   
     public List<HoaDonChiTiet> getAll(){
          sql = "select h.id,p.ma_san_pham,p.ten_san_pham,h.so_luong,h.gia,h.trang_thai from hoa_don_ct h  join san_pham_chi_tiet s\n" +
"			on s.id = h.id_spct\n" +
"			join san_pham p \n" +
"			on s.id_sp = p.id\n" +
"			where h.trang_thai = 0";
        List<HoaDonChiTiet> arr = new ArrayList<>(); 
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                   
                HoaDonChiTiet x = new HoaDonChiTiet();
                x.setId(rs.getInt("id"));
                SanPhamChiTiet spct = new SanPhamChiTiet();
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("ma_san_pham"));
                sp.setTenSanPham(rs.getString("ten_san_pham"));
                spct.setSp(sp);
                x.setSpct(spct);    
                x.setSoLuong(rs.getInt("so_luong"));
                x.setGia(rs.getDouble("gia"));
                x.setTrangThai(rs.getBoolean("trang_thai"));
                arr.add(x);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
       return arr;
     }




     
     
     
     
     
     
     
     
     public double deleteV2(Integer id) {
    String selectSql = "SELECT id_spct, so_luong, gia, id_hoa_don FROM hoa_don_ct WHERE id = ?";
    String updateStatusSql = "UPDATE hoa_don_ct SET trang_thai = 1 WHERE id = ?";
    String updateQuantitySql = "UPDATE san_pham_chi_tiet SET so_luong = so_luong + ? WHERE id = ?";
    String getTotalAmountSql = "SELECT tong_tien FROM hoa_don WHERE id = ?";
    String updateTotalAmountSql = "UPDATE hoa_don SET tong_tien = ? WHERE id = ?";
    
    Connection con = null;
    PreparedStatement ps = null;
    PreparedStatement psv = null;
    ResultSet rs = null;
    double newTotal = 0.0;

    try {
        con = DBConnect.getConnection();
        con.setAutoCommit(false); // Bắt đầu transaction

        // Bước 1: Lấy thông tin chi tiết của hoa_don_ct
        ps = con.prepareStatement(selectSql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        
        int idSpct = 0;
        int soLuong = 0;
        double gia = 0.0;
        int idHoaDon = 0;
        
        if (rs.next()) {
            idSpct = rs.getInt("id_spct");
            soLuong = rs.getInt("so_luong");
            gia = rs.getDouble("gia");
            idHoaDon = rs.getInt("id_hoa_don");
            
            // Bước 2: Cập nhật trạng thái của hoa_don_ct
            ps = con.prepareStatement(updateStatusSql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            // Bước 3: Cập nhật số lượng sản phẩm trong san_pham_chi_tiet
            psv = con.prepareStatement(updateQuantitySql);
            psv.setInt(1, soLuong); // Khôi phục số lượng sản phẩm
            psv.setInt(2, idSpct);
            psv.executeUpdate();
            
            // Bước 4: Tính toán lại tổng tiền của hóa đơn
            ps = con.prepareStatement(getTotalAmountSql);
            ps.setInt(1, idHoaDon);
            rs = ps.executeQuery();
            
            double currentTotal = 0.0;
            if (rs.next()) {
                currentTotal = rs.getDouble("tong_tien");
            }
            
            // Cập nhật tổng tiền của hóa đơn sau khi xóa sản phẩm
            newTotal = currentTotal - (soLuong * gia);
            ps = con.prepareStatement(updateTotalAmountSql);
            ps.setDouble(1, newTotal);
            ps.setInt(2, idHoaDon);
            ps.executeUpdate();
        }
        
        // Commit transaction
        con.commit();
        
    } catch (Exception e) {
        e.printStackTrace();
        // Rollback transaction if there is an exception
        if (con != null) {
            try {
                con.rollback();
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
    } finally {
        // Ensure that resources are closed
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
     
     
     
     if (psv != null) psv.close();
            if (con != null) con.close();
        } catch (Exception closeEx) {
            closeEx.printStackTrace();
        }
    }

    return newTotal;
}
     
     
     
     
    
}
     
     
    
     
    
     
     
     
     
     
     

