/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.thuoctinh.kieuao;

/**
 *
 * @author Nguyễn Vũ
 */

import java.sql.Connection;
import raven.DBConnect.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import raven.entity.KieuAo;
public class RepositoryKieuAo {
    
    Connection con = null;
    
    PreparedStatement ps = null;
    
    ResultSet rs = null;
    
    String sql = null;
    
    public List<KieuAo> getAllKieuAo(){
        sql = "select id,ma,ten,trang_thai from kieu_ao where trang_thai = 1";
        List<KieuAo> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               list.add(new KieuAo(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getBoolean(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int addKieuAo(KieuAo ka){
        sql = "INSERT INTO kieu_ao (ma, ten, trang_thai) VALUES (?,?,1)";
        try {
            con =DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1,ka.getMa() );
            ps.setObject(2, ka.getTen());
            ps.setObject(3, ka.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int removeKieuAo(int id){
        sql = "update kieu_ao set trang_thai = 0 where id =  ?";
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
    
    public int update(int id,KieuAo ka){
        sql = "update kieu_ao set ten = ? where id =  ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ka.getTen());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public static void main(String[] args) {
            UUID uuid = UUID.randomUUID();

        // Tạo đối tượng KieuAo với giá trị ma
        KieuAo ao = new KieuAo(1, uuid.toString(), "1111", true);

        // In giá trị của đối tượng KieuAo để kiểm tra
        System.out.println(ao.toString());
    }
    
    
}
