/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.thuoctinh.anh;

/**
 *
 * @author Nguyễn Vũ
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import raven.DBConnect.DBConnect;
import raven.entity.Anh;



public class RepositoryAnh {
    
    Connection con = null;
    
    PreparedStatement ps = null;
    
    ResultSet rs = null;
    
    private String sql = "";
    
    public List<Anh> getAllimage(){
        sql = "select id,ma_anh,ten_anh,trang_thai from anh where id = 1";
        List<Anh> listImage = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                listImage.add(new Anh(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getBoolean(4)));
            }
            return listImage;
        } catch (Exception e) {
            e.printStackTrace();
        }
             return null;
    }
    
    
     public int addImage(Anh a){
        sql = "INSERT INTO anh (ma_anh, ten_anh, trang_thai) VALUES (?,?,1);";
        try {
            con =DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1,a.getMaAnh());
            ps.setObject(2, a.getTenAnh());
            ps.setObject(3, a.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int removeImage(int id){
        sql = "update anh set trang_thai = 0 where id =  ?";
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
    
    public int updateImage(int id,Anh a){
        sql = "update anh set ten = ? where id =  ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, a.getTenAnh());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
}
