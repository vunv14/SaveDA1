/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.sanpham.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import raven.DBConnect.DBConnect;
import raven.application.form.other.sanpham.model.ModelSanPham;
import raven.entity.ChatLieu;
import raven.entity.SanPham;

/**
 *
 * @author Nguyễn Vũ
 */
public class RepositorySanPham {

    Connection con = null;

    PreparedStatement ps = null;

    ResultSet rs = null;

    private String sql = null;

    public List<ModelSanPham> getAllSanPham() {
        String sql = """
       SELECT 
                     sp.ma_san_pham,
                     sp.ten_san_pham,
                     sp.mo_ta,
                     SUM(spct.so_luong) AS tong_so_luong,
                     sp.trang_thai
                 FROM 
                     san_pham sp 
                 left JOIN 
                     san_pham_chi_tiet spct 
                 ON 
                     sp.id = spct.id_sp
       			  where sp.trang_thai =1
                 GROUP BY 
                     sp.ma_san_pham,
                     sp.ten_san_pham,
                     sp.mo_ta,
                     sp.trang_thai;
          """;
        List<ModelSanPham> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new ModelSanPham(
                        rs.getString("ma_san_pham"),
                        rs.getString("ten_san_pham"),
                        rs.getString("mo_ta"),
                        rs.getInt("tong_so_luong"),
                        rs.getBoolean("trang_thai")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int addProduct(SanPham sp) {
        sql = """
           insert into san_pham(ma_san_pham,ten_san_pham,mo_ta
              ,create_at,update_at,create_by,update_by,trang_thai ) values(
              	?,?,?,?,?,?,?,?
              )
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMaSanPham());
            ps.setObject(2, sp.getTenSanPham());
            ps.setObject(3, sp.getMoTa());
            ps.setObject(4, sp.getCreateAt());
            ps.setObject(5, sp.getUpdateAt());
            ps.setObject(6, sp.getCreateBy());
            ps.setObject(7, sp.getUpdateBy());
            ps.setObject(8, sp.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int removeProductById(String id) {
        sql = "update san_pham set trang_thai = 0 where ma_san_pham = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int updateProductById(String id, SanPham sp) {
        sql = """
              update san_pham set 
              ten_san_pham = ?, 
              mo_ta = ? , 
              create_at = ?,
              update_at = ? ,
              create_by = ?,
              update_by = ?
              where ma_san_pham = ?
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getTenSanPham());
            ps.setObject(2, sp.getMoTa());
            ps.setObject(3, sp.getCreateAt());
            ps.setObject(4, sp.getCreateAt());
            ps.setObject(5, sp.getCreateBy());
            ps.setObject(6, sp.getUpdateBy());
            ps.setObject(7, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<SanPham> sanpham(int id) {
        String sql = """
     		 SELECT 
                     		 sp.id,
                                          sp.ma_san_pham,
                                          sp.ten_san_pham,
                                          sp.mo_ta,
                                          sp.trang_thai
                                      FROM 
                                          san_pham sp where sp.id = ?
          """;
        List<SanPham> list = new ArrayList<>();
        try  {
                con = DBConnect.getConnection();
                ps = con.prepareStatement(sql);
            // Set the id parameter
            ps.setInt(1, id);
                rs = ps.executeQuery();

                while (rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setId(rs.getInt(1));
                    sp.setMaSanPham(rs.getString(2));
                    sp.setTenSanPham(rs.getString(3));
                    sp.setMoTa(rs.getString(4));
                    sp.setTrangThai(rs.getBoolean(5));

                    // Add the SanPham object to the list
                    list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
 public List<SanPham> sanphambyMa(String id) {
    String sql = """
        SELECT 
            sp.id,
            sp.ma_san_pham,
            sp.ten_san_pham,
            sp.mo_ta,
            sp.trang_thai
        FROM 
            san_pham sp
        WHERE 
            sp.ma_san_pham = ? 
        """;
    List<SanPham> list = new ArrayList<>();
    try {
        con = DBConnect.getConnection();
        ps = con.prepareStatement(sql);
        // Set the id parameter
        ps.setString(1, id); // Chuyển sang setString nếu id là chuỗi
        rs = ps.executeQuery();
        while (rs.next()) {
            SanPham sp = new SanPham();
            sp.setId(rs.getInt(1));
            sp.setMaSanPham(rs.getString(2));
            sp.setTenSanPham(rs.getString(3));
            sp.setMoTa(rs.getString(4));
            sp.setTrangThai(rs.getBoolean(5));

            // Add the SanPham object to the list
            list.add(sp);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
 
 
    public static void main(String[] args) {
        List<SanPham> list = new RepositorySanPham().sanpham(1);
        list.stream().forEach(a->System.out.println(a.toString()));
    }
    
    
    

}
