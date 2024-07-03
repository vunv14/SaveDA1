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
import lombok.val;
import raven.DBConnect.DBConnect;
public class RepositoryNhanVien {
    
    private Connection con = null;
    
    private PreparedStatement ps = null;
    
    private ResultSet rs = null;
    
    private String sql = null;
    
    public List<VaiTro> getAllLG(){
        sql = """
             select id,ho_ten,mat_khau,trang_thai,chuc_vu from vai_tro
              """;
        List<VaiTro> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                   
                list.add(new VaiTro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getBoolean(5)));
            } 
            
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        List<VaiTro> list = new RepositoryNhanVien().getAllLG();
        list.stream().forEach(a-> System.out.println(a.toString()));

        

    }
    
}
