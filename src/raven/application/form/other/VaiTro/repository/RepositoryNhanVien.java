/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.VaiTro.repository;

import java.util.List;
import raven.entity.VaiTro;

/**
 *
 * @author Nguyễn Vũ
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.stream.Collectors;

//import lombok.val;
import raven.DBConnect.DBConnect;

public class RepositoryNhanVien {

    private Connection con = null;

    private PreparedStatement ps = null;

    private ResultSet rs = null;

    private String sql = null;

    public List<VaiTro> getAllLG() {
        sql = "select id,ho_ten,mat_khau,trang_thai,chuc_vu from vai_tro";
        List<VaiTro> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                VaiTro x = new VaiTro();
                x.setId(rs.getInt("id"));
                x.setHoTen(rs.getString("ho_ten"));
                x.setMatKhau(rs.getString("mat_khau"));
                x.setTrangThai(rs.getBoolean("trang_thai"));
                x.setChucVu(rs.getBoolean("chuc_vu"));
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<VaiTro> getAll() {
        sql = "select id,ho_ten,sdt,dia_chi,gioi_tinh,email,ngay_sinh,chuc_vu,trang_thai from vai_tro\n" +
"              where trang_thai = 0";
        List<VaiTro> arr = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                VaiTro x = new VaiTro();
                x.setId(rs.getInt("id"));
                x.setHoTen(rs.getString("ho_ten"));
                x.setSdt(rs.getString("sdt"));
                x.setDiaChi(rs.getString("dia_chi"));
                //x.setCccd(rs.getString("cccd"));
                x.setGioiTinh(rs.getBoolean("gioi_tinh"));
                x.setEmail(rs.getString("email"));
                x.setNgaySinh(rs.getDate("ngay_sinh"));
                 x.setChucVu(rs.getBoolean("chuc_vu"));
                x.setTrangThai(rs.getBoolean("trang_thai")); 
                arr.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public void addNV(VaiTro x) {
        sql = "insert into vai_tro(ho_ten,sdt,dia_chi,cccd,email,gioi_tinh,ngay_sinh,mat_khau,chuc_vu,trang_thai)\n" +
" values(?,?,?,?,?,?,?,?,0,0)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, x.getHoTen());
            ps.setString(2, x.getSdt());
            ps.setString(3, x.getDiaChi());
            ps.setString(4, x.getCccd());
             ps.setString(5, x.getEmail());
            ps.setBoolean(6, x.getGioiTinh());
            ps.setDate(7,  x.getNgaySinh());
            ps.setString(8, x.getMatKhau());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(VaiTro x) {
        sql = "update vai_tro set ho_ten = ? , sdt = ? , dia_chi = ? , email = ?\n" +
"                 , gioi_tinh = ?, ngay_sinh = ? where id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, x.getHoTen());
            ps.setString(2, x.getSdt());
            ps.setString(3, x.getDiaChi());
            ps.setString(4, x.getEmail());
            ps.setBoolean(5, x.getGioiTinh());
            ps.setDate(6, x.getNgaySinh());
            ps.setInt(7, x.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        sql = "update vai_tro set trang_thai = 1 where id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteV2(Integer id) {
        sql = "update vai_tro set trang_thai = 0 where id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   


    
    public List<VaiTro> searchVaiTro(String keyword) {
    if (keyword == null || keyword.isEmpty()) {
        return getAll();
    }
    return getAllV2().stream()
            .filter(vaiTro -> 
                vaiTro.getSdt().contains(keyword) ||
               (vaiTro.getNgaySinh() != null && vaiTro.getNgaySinh().toString().contains(keyword)) ||
                vaiTro.getCccd().contains(keyword) ||
                vaiTro.getDiaChi().contains(keyword) ||
                vaiTro.getHoTen().contains(keyword)
            )
            .collect(Collectors.toList());
}
    
    public VaiTro findby(String cccd){
          return getAllV2().stream().filter((t) -> t.getCccd().contains(cccd)).findFirst().orElse(null);
    }

    
       public List<VaiTro> getAllV2() {
 sql = "select id,ho_ten,sdt,dia_chi,cccd,gioi_tinh,email,ngay_sinh,chuc_vu,trang_thai from vai_tro\n" +
"              where trang_thai = 0";
        List<VaiTro> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                VaiTro x = new VaiTro();
                x.setId(rs.getInt("id"));
                x.setHoTen(rs.getString("ho_ten"));
                x.setSdt(rs.getString("sdt"));
                x.setDiaChi(rs.getString("dia_chi"));
                x.setCccd(rs.getString("cccd"));
                x.setGioiTinh(rs.getBoolean("gioi_tinh"));
                x.setEmail(rs.getString("email"));
                x.setNgaySinh(rs.getDate("ngay_sinh"));
                 x.setChucVu(rs.getBoolean("chuc_vu"));
                x.setTrangThai(rs.getBoolean("trang_thai")); 
                list.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    
    
}
