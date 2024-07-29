/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.thuoctinh.kichthuoc.repository;

/**
 *
 * @author Nguyễn Vũ
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import raven.DBConnect.DBConnect;
import raven.entity.KichThuoc;

public class RepositoryKichThuoc {

    Connection con = null;
    PreparedStatement ps = null;

    ResultSet rs = null;

    String sql = null;

    public List<KichThuoc> getAll() {

        sql = "select ma_kich_thuoc,size, rong_ao,rong_vai,dai_ao,dai_tay from kich_thuoc where trang_thai = 1";
        List<KichThuoc> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KichThuoc(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6)));
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int addKichThuoc(KichThuoc kt) {
        sql = """
              insert into kich_thuoc(ma_kich_thuoc,size,rong_ao,dai_ao,rong_vai,dai_tay,trang_thai) values(?,?,?,?,?,?,?)
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kt.getMaKichThuoc());
            ps.setObject(2, kt.getSize());
            ps.setObject(3, kt.getRongAo());
            ps.setObject(4, kt.getDaiAo());
            ps.setObject(5, kt.getRongVai());
            ps.setObject(6, kt.getDaiTay());
            ps.setObject(7, kt.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int removeSizeById(String id) {

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement("""
                                     UPDATE [dbo].[kich_thuoc]
                                         SET 
                                            [trang_thai] = 0
                                       WHERE ma_kich_thuoc = ?
                                      """);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(String id, KichThuoc kt) {
        sql = """
              UPDATE [dbo].[kich_thuoc]
                 SET 
              		size = ?, rong_ao = ?, rong_vai = ?, dai_ao = ?, dai_tay = ?
               WHERE ma_kich_thuoc = ?
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kt.getSize());
            ps.setObject(2, kt.getRongAo());
            ps.setObject(3, kt.getRongVai());
            ps.setObject(4, kt.getDaiAo());
            ps.setObject(5, kt.getDaiTay());
            ps.setObject(6, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
//
//    public static void main(String[] args) {
//
//        List<KichThuoc> list = new RepositoryKichThuoc().getAll();
//        list.stream().forEach(a -> System.out.println(a.toString()));
//
//        KichThuoc kt = new KichThuoc("23", "123", 12.3, 12.3, 12.3, 12.3);
//        Boolean check = new RepositoryKichThuoc().addKichThuoc(kt);
//        System.out.println(check);
//
//    }

}
