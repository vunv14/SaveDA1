/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.thuoctinh.thuonghieu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import raven.DBConnect.DBConnect;
import raven.entity.ThuongHieu;

/**
 *
 * @author Nguyễn Vũ
 */
public class RepositoryThuongHieu {

    Connection con = null;

    PreparedStatement ps = null;

    ResultSet rs = null;

    String sql = null;
    
     public List<ThuongHieu> getAllMau() {
        sql = "		select id,ma_thuong_hieu,ten_thuong_hieu,trang_thai from thuong_hieu where trang_thai = 1";
        List<ThuongHieu> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThuongHieu(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     
       public int addThuongHieu(ThuongHieu th) {
        sql = """
             insert into mau (ma_mau,loai_mau) values(?,?);
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, th.getMa());
            ps.setObject(2, th.getThuongHieu());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
