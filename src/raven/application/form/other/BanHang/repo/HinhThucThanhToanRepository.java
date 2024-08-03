/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.BanHang.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import raven.DBConnect.DBConnect;
import raven.entity.HinhThucThanhToan;
import raven.entity.HinhThucThanhToanHoaDon;
import raven.entity.PhieuGiamGiaHoaDon;

/**
 *
 * @author Nguyen Nam Truong
 */
public class HinhThucThanhToanRepository {
    
    
      private Connection con = null;

      private PreparedStatement ps = null;
 
      private ResultSet rs = null;

      private String sql = null;
    
      public List<HinhThucThanhToan> getAllHTTT(){
          sql = "select id,hinh_thuc_thanh_toan,trang_thai from hinh_thuc_thanh_toan";
            List<HinhThucThanhToan> arr = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                   
              HinhThucThanhToan x = new HinhThucThanhToan();
              x.setId(rs.getInt("id"));
              x.setHinhThucThanhToan(rs.getString("hinh_thuc_thanh_toan"));
              x.setTrangThai(rs.getBoolean("trang_thai"));
              arr.add(x);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
       return arr;
      }
      
      
      public List<PhieuGiamGiaHoaDon> getAllHTTTHD(){
          sql = "select id,ten_phieu_giam_gia,kieu_giam_gia,gia_tri_toi_thieu,gia_tri_giam,ngay_bat_dau,ngay_ket_thuc,so_luong,trang_thai from phieu_giam_gia_theo_hoa_don";
            List<PhieuGiamGiaHoaDon> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                   
            PhieuGiamGiaHoaDon x = new PhieuGiamGiaHoaDon();
              x.setId(rs.getInt("id"));
            x.setTen(rs.getString("ten_phieu_giam_gia"));
            x.setKieuGiamGia(rs.getBoolean("kieu_giam_gia"));
            x.setGiaTriToiThieu(rs.getDouble("gia_tri_toi_thieu"));
            x.setGiaTriGiam(rs.getDouble("gia_tri_giam"));
            x.setNgayBatDau(rs.getDate("ngay_bat_dau"));
            x.setNgayKetThuc(rs.getDate("ngay_ket_thuc"));
            x.setSoLuong(rs.getInt("so_luong"));
            x.setTrang_thai(rs.getInt("trang_thai"));
              list.add(x);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
       return list;
      }
      
      
    public void updateSoLuong(PhieuGiamGiaHoaDon x) {
    String sql = "UPDATE phieu_giam_gia_theo_hoa_don SET so_luong = ? WHERE id = ?";
    try {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, x.getSoLuong());  
        ps.setInt(2, x.getId());  
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    
}
