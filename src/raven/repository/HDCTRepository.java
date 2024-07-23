/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import raven.DBConnect.DBConnect;
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
    
    
     public void addHDCT(HoaDonChiTiet x){
        sql = "insert into hoa_don_ct(id_spct,id_hoa_don,so_luong,gia,trang_thai) values (?,?,?,?,0)";
  
       String sqlUpdate = "UPDATE san_pham_chi_tiet SET so_luong = so_luong - ? WHERE id = ?";
        
//         String sqlUpdateV2 = "      UPDATE hoa_don\n" +
//                "SET tong_tien = (\n" +
//                "    SELECT SUM(c.so_luong * c.gia)\n" +
//                "    FROM hoa_don_ct c\n" +
//                "    WHERE hoa_don.id = c.id_hoa_don\n" +
//                ")"; 
        try {
             con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            psv = con.prepareStatement(sqlUpdate);
            System.out.println(x.getHd().getId());
            ps.setInt(1, x.getSpct().getId());
            ps.setInt(2, x.getHd().getId());
            ps.setInt(3, x.getSoLuong());
            ps.setDouble(4, x.getGia());
            //ps.setBoolean(5, x.getTrangThai());
            ps.executeUpdate();
            
            psv.setInt(1, x.getSoLuong());
             psv.setInt(2, x.getSpct().getId());
            psv.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public void addHDCTV2(HoaDonChiTiet x) {
    String sqlInsert = "insert into hoa_don_ct(id_spct, id_hoa_don, so_luong, gia, trang_thai) values (?, ?, ?, ?, 0)";
    String sqlUpdate = "UPDATE san_pham_chi_tiet SET so_luong = so_luong - ? WHERE id = ?";
    String sqlUpdateV2 = "UPDATE hoa_don " +
                         "SET tong_tien = ( " +
                         "    SELECT SUM(c.so_luong * c.gia) " +
                         "    FROM hoa_don_ct c " +
                         "    WHERE hoa_don.id = c.id_hoa_don " +
                         ") " +
                         "WHERE hoa_don.id = ?";

    try {
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sqlInsert);
        ps.setInt(1, x.getSpct().getId());
        ps.setInt(2, x.getHd().getId());
        ps.setInt(3, x.getSoLuong());
        ps.setDouble(4, x.getGia());
        ps.executeUpdate();

        psv = con.prepareStatement(sqlUpdate);
        psv.setInt(1, x.getSoLuong());
        psv.setInt(2, x.getSpct().getId());
        psv.executeUpdate();

        ps = con.prepareStatement(sqlUpdateV2);
        ps.setInt(1, x.getHd().getId());
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
        
     public void delete(Integer id) {
    String selectSql = "SELECT id_spct, so_luong FROM hoa_don_ct WHERE id = ?";
    String updateStatusSql = "UPDATE hoa_don_ct SET trang_thai = 1 WHERE id = ?";
    String updateQuantitySql = "UPDATE san_pham_chi_tiet SET so_luong = so_luong + ? WHERE id = ?";

    try {
        con = DBConnect.getConnection();        
        // Bước 1: Lấy thông tin chi tiết của hoa_don_ct
        ps = con.prepareStatement(selectSql);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            int idSpct = rs.getInt("id_spct");
            int soLuong = rs.getInt("so_luong");
            // Bước 2: Cập nhật trạng thái của hoa_don_ct
            ps = con.prepareStatement(updateStatusSql);
            ps.setInt(1, id);
            ps.executeUpdate();           
            // Bước 3: Cập nhật số lượng sản phẩm trong san_pham_chi_tiet
            psv = con.prepareStatement(updateQuantitySql);
            psv.setInt(1, soLuong); // Khôi phục số lượng sản phẩm
            psv.setInt(2, idSpct);
            psv.executeUpdate();
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    } 
}
     
     
     
     
     
     
    
     
     
     
     
     
     
}
