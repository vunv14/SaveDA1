/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.SanPham;

import java.util.ArrayList;
import raven.entity.SanPham;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import raven.DBConnect.DBConnect;

/**
 *
 * @author DELL
 */
public class SanPhamRepository {

    public ArrayList<SanPham> getAll() {
        String sql = """
                     SELECT [id]
                           ,[ma_sp]
                           ,[ten_san_pham]
                           ,[so_luong]
                           ,[mo_ta]
                           ,[create_at]
                           ,[update_at]
                           ,[create_by]
                           ,[update_by]
                           ,[trang_thai]
                       FROM [dbo].[san_pham]
                     where trang_thai=1
                     """;
        ArrayList<SanPham> dsSP = new ArrayList<>();
        try (Connection con = DBConnect.getConnection();PreparedStatement ps = con.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                SanPham sp = new SanPham();
                sp.setId(rs.getInt(1));
                sp.setMa_san_pham(rs.getString(2));
                sp.setTen_san_pham(rs.getString(3));
                sp.setSo_luong(rs.getInt(4));
                sp.setMo_ta(rs.getString(5));
                sp.setCreate_at(rs.getDate(6));
                sp.setUpdate_at(rs.getDate(7));
                sp.setCreate_by(rs.getInt(8));
                sp.setCreate_by(rs.getInt(9));
                sp.setTrang_thai(rs.getBoolean(10));
                dsSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return dsSP;
    }
    
    public boolean add(SanPham sp) {
        String sql = """
                     INSERT INTO [dbo].[san_pham]
                                ([ma_sp]
                                ,[ten_san_pham]
                                ,[so_luong]
                                ,[mo_ta]
                                ,[trang_thai])
                          VALUES
                                (?,?,?,?,1)
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection();PreparedStatement ps = con.prepareCall(sql)){
            ps.setObject(1, sp.getMa_san_pham());
            ps.setObject(2, sp.getTen_san_pham());
            ps.setObject(3, sp.getSo_luong());
            ps.setObject(4, sp.getMo_ta());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }
    
    public boolean update(SanPham sp,Integer id) {
        String sql = """
                     UPDATE [dbo].[san_pham]
                        SET   [ma_sp] = ?
                           ,[ten_san_pham] = ?
                           ,[so_luong] = ?
                           ,[mo_ta] = ?
                      WHERE id = ?
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection();PreparedStatement ps = con.prepareCall(sql)){
            ps.setObject(1, sp.getMa_san_pham());
            ps.setObject(2, sp.getTen_san_pham());
            ps.setObject(3, sp.getSo_luong());
            ps.setObject(4, sp.getMo_ta());
            ps.setObject(5, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }
    
    public boolean delete (Integer id){
        String sql = """
                     UPDATE [dbo].[san_pham]
                                             SET   trang_thai = 0
                                           WHERE id = ?
                     """;
        int check = 0;
        try (Connection con = DBConnect.getConnection();PreparedStatement ps = con.prepareCall(sql)){
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check>0;
    }
    public static void main(String[] args) {
        System.out.println(new SanPhamRepository().getAll());
    }

}
