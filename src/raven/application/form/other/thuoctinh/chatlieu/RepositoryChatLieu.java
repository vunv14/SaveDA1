/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.thuoctinh.chatlieu;

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
import raven.entity.ChatLieu;

public class RepositoryChatLieu {
        Connection con = null;
        
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        
        private String sql = null;
        
      public List<ChatLieu> getAllChatLieu(){
        sql = "select id,ma_chat_lieu,ten_loai_vai,trang_thai  from chat_lieu ";
        List<ChatLieu> list = new ArrayList<>();
        
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new ChatLieu(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getBoolean(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
             return null;
    }
    
    
     public int addChatLieu(ChatLieu cl){
        sql = "INSERT INTO chat_lieu(ma_chat_lieu,ten_loai_vai, trang_thai) VALUES (?,?,?);";
        try {
            con =DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1,cl.getMaChatLieu());
            ps.setObject(2, cl.getTenLoaiVai());
            ps.setObject(3, cl.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int removeImage(int id){
        sql = "update chat_lieu  set trang_thai = 0 where id =  ?";
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
    
    public int updateImage(int id,ChatLieu cl){
        sql = "update anh set ten = ? where id =  ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, cl.getTenLoaiVai());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public static void main(String[] args) {
        List<ChatLieu > list =  new RepositoryChatLieu().getAllChatLieu();
        list.stream().forEach(a-> System.out.println(a.toString()));
    }
    
}
