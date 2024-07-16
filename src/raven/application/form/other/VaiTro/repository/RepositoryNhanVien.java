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

//import lombok.val;


import raven.DBConnect.DBConnect;
public class RepositoryNhanVien {
    
    private Connection con = null;
    
    private PreparedStatement ps = null;
    
    private ResultSet rs = null;
    
    private String sql = null;
    
    public List<VaiTro> getAllLG(){
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
    

    public List<VaiTro> getAll(){
       sql ="select id,ma,gioi_tinh,sdt,ngay_sinh,cccd,\n" +
"                 dia_chia,ho_ten,chuc_vu,\n" +
"                 mat_khau,trang_thai from vai_tro where trang_thai = 0";
        List<VaiTro> arr = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                   
                     VaiTro x = new VaiTro();
                       x.setId(rs.getInt("id"));
                       x.setMa(rs.getString("ma"));
                       x.setGioiTinh(rs.getBoolean("gioi_tinh"));
                       x.setSdt(rs.getString("sdt"));
                       x.setNgaySinh(rs.getDate("ngay_sinh"));
                       x.setCccd(rs.getString("cccd"));
                       x.setDiaChia(rs.getString("dia_chia"));
                       x.setHoTen(rs.getString("ho_ten"));
                       x.setChucVu(rs.getBoolean("chuc_vu"));
                       x.setMatKhau(rs.getString("mat_khau"));
                       x.setTrangThai(rs.getBoolean("trang_thai"));
                     arr.add(x);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
       return arr;
    }
    
    public void addNV(VaiTro x){
        sql = "insert into vai_tro(ma,gioi_tinh,sdt,"
                + "ngay_sinh,cccd,dia_chia,ho_ten,chuc_vu,"
                + "mat_khau,trang_thai)\n" +
                "values(?,?,?,?,?,?,?,0,?,0)";
        try {
             con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, x.getMa());
            ps.setBoolean(2, x.getGioiTinh());
            ps.setString(3, x.getSdt());
            ps.setDate(4, x.getNgaySinh());
            ps.setString(5, x.getCccd());
            ps.setString(6, x.getDiaChia());
            ps.setString(7, x.getHoTen());
            ps.setString(8, x.getMatKhau());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void update(VaiTro x){
        sql = "update vai_tro set ma = ? , gioi_tinh = ?, sdt = ?, ngay_sinh = ?, cccd = ?, dia_chia = ?,\n" +
        "ho_ten = ? , mat_khau = ? where id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
           ps = con.prepareStatement(sql);
            ps.setString(1, x.getMa());
            ps.setBoolean(2, x.getGioiTinh());
            ps.setString(3, x.getSdt());
            ps.setDate(4, x.getNgaySinh());
            ps.setString(5, x.getCccd());
            ps.setString(6, x.getDiaChia());
            ps.setString(7, x.getHoTen());
            //ps.setBoolean(8, x.getChucVu());
            ps.setString(8, x.getMatKhau());
            ///ps.setBoolean(10, x.getTrangThai());
            ps.setInt(9, x.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(Integer id){
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
    
     public void deleteV2(Integer id){
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
    
     public List<VaiTro> getAllV2(){
        sql ="select id,ma,gioi_tinh,sdt,ngay_sinh,cccd,\n" +
"                 dia_chia,ho_ten,chuc_vu,\n" +
"                 mat_khau,trang_thai from vai_tro where trang_thai = 1";
        List<VaiTro> list1 = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                   
                     VaiTro x = new VaiTro();
                       x.setId(rs.getInt("id"));
                       x.setMa(rs.getString("ma"));
                       x.setGioiTinh(rs.getBoolean("gioi_tinh"));
                       x.setSdt(rs.getString("sdt"));
                       x.setNgaySinh(rs.getDate("ngay_sinh"));
                       x.setCccd(rs.getString("cccd"));
                       x.setDiaChia(rs.getString("dia_chia"));
                       x.setHoTen(rs.getString("ho_ten"));
                       x.setChucVu(rs.getBoolean("chuc_vu"));
                       x.setMatKhau(rs.getString("mat_khau"));
                       x.setTrangThai(rs.getBoolean("trang_thai"));
                     list1.add(x);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
       return list1;
    }
     
     
     public VaiTro finbyName(String name){
        return getAll().stream()
                .filter((t) -> t.getHoTen().contains(name))
                .findFirst().orElse(null);
     }
}
    
    
    
    

 
    

