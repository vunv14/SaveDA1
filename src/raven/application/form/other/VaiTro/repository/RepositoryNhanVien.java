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
                list.add(new VaiTro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getBoolean(5)));
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
       return list;
    }
    

    public List<VaiTro> getAll(){
        sql = "select id,gioi_tinh,ngay_sinh,cccd,"
                + "dia_chia,ho_ten,trang_thai,chuc_vu,"
                + "mat_khau from vai_tro where trang_thai = 0";
        List<VaiTro> arr = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            //ps.setBoolean(1, true);
            rs = ps.executeQuery();
            while (rs.next()) {                   
                     VaiTro x = new VaiTro();
                     x.setId(rs.getInt("id"));
                     x.setGioi_tinh(rs.getBoolean("gioi_tinh"));
                     x.setNgay_sinh(rs.getDate("ngay_sinh"));
                     x.setCccd(rs.getString("cccd"));
                     x.setDia_chia(rs.getString("dia_chia"));
                     x.setHo_ten(rs.getString("ho_ten"));
                     x.setTrang_thai(rs.getBoolean("trang_thai"));
                     x.setChuc_vu(rs.getBoolean("chuc_vu"));
                     x.setMat_khau(rs.getString("mat_khau"));
                     arr.add(x);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
       return arr;
    }
    
    public void addNV(VaiTro x){
        sql ="insert into vai_tro(gioi_tinh,ngay_sinh,cccd,dia_chia,"
                + "ho_ten,trang_thai,chuc_vu,mat_khau) values(?,?,?,?,?,?,?,?)";
        try {
             con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, x.getGioi_tinh());
            ps.setDate(2, x.getNgay_sinh());
            ps.setString(3, x.getCccd());
            ps.setString(4, x.getDia_chia());
            ps.setString(5, x.getHo_ten());
            ps.setBoolean(6, x.getTrang_thai());
            ps.setBoolean(7, x.getChuc_vu());
            ps.setString(8, x.getMat_khau());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        List<VaiTro> list = new RepositoryNhanVien().getAllLG();
//        list.stream().forEach(a-> System.out.println(a.toString()));
//
//      
//>>>>>>> origin/master
//    }
    
    public void update(VaiTro x){
         sql = "update vai_tro set gioi_tinh = ? , ngay_sinh = ?, cccd = ?,"
                 + " dia_chia = ?,\n" +
            "ho_ten = ?, trang_thai = ? , chuc_vu = ?, mat_khau = ? where id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, x.getGioi_tinh());
            ps.setDate(2, x.getNgay_sinh());
            ps.setString(3, x.getCccd());
            ps.setString(4, x.getDia_chia());
            ps.setString(5, x.getHo_ten());
            ps.setBoolean(6, x.getTrang_thai());
            ps.setBoolean(7, x.getChuc_vu());
            ps.setString(8, x.getMat_khau());
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
        sql = "select id,gioi_tinh,ngay_sinh,cccd,"
                + "dia_chia,ho_ten,trang_thai,chuc_vu,"
                + "mat_khau from vai_tro where trang_thai = 1";
        List<VaiTro> list1 = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            //ps.setBoolean(1, true);
            rs = ps.executeQuery();
            while (rs.next()) {                   
                     VaiTro x = new VaiTro();
                     x.setId(rs.getInt("id"));
                     x.setGioi_tinh(rs.getBoolean("gioi_tinh"));
                     x.setNgay_sinh(rs.getDate("ngay_sinh"));
                     x.setCccd(rs.getString("cccd"));
                     x.setDia_chia(rs.getString("dia_chia"));
                     x.setHo_ten(rs.getString("ho_ten"));
                     x.setTrang_thai(rs.getBoolean("trang_thai"));
                     x.setChuc_vu(rs.getBoolean("chuc_vu"));
                     x.setMat_khau(rs.getString("mat_khau"));
                     list1.add(x);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
       return list1;
    }
     
     
     public VaiTro finbyName(String name){
        return getAll().stream()
                .filter((t) -> t.getHo_ten().contains(name))
                .findFirst().orElse(null);
     }
}
    
    
    
    

 
    

