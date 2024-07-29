/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.thuoctinh.xuatxu;

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
import raven.entity.XuatXu;

public class RepositoryXuatXu {

    Connection con = null;

    PreparedStatement ps = null;

    ResultSet rs = null;

    String sql = null;

    public List<XuatXu> getAllXuatXu() {
        sql = "select ma_xuat_xu,dia_chi from xuat_xu where trang_thai = 1";
        List<XuatXu> list = new ArrayList<>();

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new XuatXu(rs.getString(1), rs.getString(2)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();;
        }
        return null;
    }

    public int addXuatXu(XuatXu xx) {
        sql = """
              INSERT INTO [dbo].[xuat_xu]
                         ([ma_xuat_xu]
                         ,[dia_chi],
              trang_thai
                       
                   VALUES
                          ( ?,?,?
              
              			)
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, xx.getMaXuatXu());
            ps.setObject(2, xx.getDiaChia());
            ps.setObject(3, xx.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int removeByIdXuatXu(int id) {
        sql = "update xuat_xu set trang_thai = 0 where id = ?";
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

    public int updateXuatXuByID(int id, XuatXu xx) {
        sql = "update xuat_xu set dia_chi = ? where id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, xx.getDiaChia());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
