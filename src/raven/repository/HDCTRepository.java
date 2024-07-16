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
    
    private ResultSet rs = null;
    
    private String sql = null;
    
    
     public void addHDCT(HoaDonChiTiet x){
        sql = "insert into hoa_don_ct(id_spct,so_luong,gia) values (?,?,?)";
        try {
             con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, x.getSpct().getId());
            ps.setInt(2, x.getSoLuong());
            ps.setDouble(3, x.getGia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     //select * from hoa_don_ct
     
     
     public List<HoaDonChiTiet> getAllLG(){
        sql = "select h.id,p.ma_san_pham,p.ten_san_pham,h.so_luong,h.gia from hoa_don_ct h  join san_pham_chi_tiet s\n" +
"			on s.id = h.id_spct\n" +
"			join san_pham p \n" +
"			on s.id_sp = p.id";
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                   
                HoaDonChiTiet x = new HoaDonChiTiet();
                x.setId(rs.getInt("id"));
                SanPhamChiTiet spct = new SanPhamChiTiet();
                //spct.setId(rs.getInt("id_spct"));
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("ma_san_pham"));
                sp.setTenSanPham(rs.getString("ten_san_pham"));
               // spct.getSp().setMaSanPham(rs.getString("ma_san_pham"));
               // spct.getSp().setTenSanPham(rs.getString("ten_san_pham")); 
                spct.setSp(sp);
                x.setSpct(spct);    
                x.setSoLuong(rs.getInt("so_luong"));
                x.setGia(rs.getDouble("gia"));
                list.add(x);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
       return list;
    }
    
     
     
     
     
     
     
}
