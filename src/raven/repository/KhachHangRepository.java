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
import raven.entity.Anh;
import raven.entity.ChatLieu;
import raven.entity.KhachHang;
import raven.entity.KichThuoc;
import raven.entity.KieuAo;
import raven.entity.Mau;
import raven.entity.SanPham;
import raven.entity.SanPhamChiTiet;
import raven.entity.ThuongHieu;
import raven.entity.XuatXu;

/**
 *
 * @author Nguyen Nam Truong
 */
public class KhachHangRepository {
     private Connection con = null;
    
    private PreparedStatement ps = null;
    
    private ResultSet rs = null;
    
    private String sql = null;
    

    

    public List<KhachHang> getAll(){
        sql = "select id,ten_kh,gioi_tinh,sdt,trang_thai from khach_hang";
        List<KhachHang> arr = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                   
                KhachHang p = new KhachHang();
                p.setId(rs.getInt("id"));
                p.setTenKh(rs.getString("ten_kh"));
                p.setGioiTinh(rs.getBoolean("gioi_tinh"));
                p.setSdt(rs.getString("sdt"));
                p.setTrangThai(rs.getBoolean("trang_thai"));
                arr.add(p);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
       return arr;
    }
}
