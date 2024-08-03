/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.thuoctinh.mau;

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
import raven.entity.Mau;

public class RepositoryMau {

    Connection con = null;

    PreparedStatement ps = null;

    ResultSet rs = null;

    String sql = null;

    public List<Mau> getAllMau() {
        sql = "select  ma_mau,loai_mau from mau where trang_thai = 1";
        List<Mau> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Mau(rs.getString(1), rs.getString(2)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int addMau(Mau m) {
        sql = """
             insert into mau (ma_mau,loai_mau,trang_thai) values(?,?,1);
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getMaMau());
            ps.setObject(2, m.getLoaiMau());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int removeByIdMau(String id) {
        sql = "update mau set trang_thai = 0 where ma_mau = ?";
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
    
     public int updateXuatXuByID(String id, Mau m){
        sql = "update mau set loai_mau = ? where ma_mau = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getLoaiMau());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
