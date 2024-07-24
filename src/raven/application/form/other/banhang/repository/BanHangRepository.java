/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.banhang.repository;

import java.util.List;
import raven.application.form.other.banhang.Model.ModelSPCT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import raven.DBConnect.DBConnect;

/**
 *
 * @author Nguyễn Vũ
 */
public class BanHangRepository {

    private Connection con = null;

    private PreparedStatement ps = null;

    private ResultSet rs = null;

    private String sql = null;

    public List<ModelSPCT> getAll() {
        sql = """
              SELECT 
                  spct.id AS san_pham_chi_tiet_id,
                  sp.ten_san_pham,
                  kt.size AS kich_thuoc,
                  th.ten_thuong_hieu,
                  xx.dia_chia AS xuat_xu,
                  a.ten_anh,
                  m.loai_mau,
                  cl.ten_loai_vai,
                  spct.gia,
                  spct.so_luong,
                  spct.do_day,
                  spct.trang_thai
              FROM 
                  san_pham_chi_tiet spct
              INNER JOIN 
                  san_pham sp ON spct.id_sp = sp.id
              INNER JOIN 
                  kich_thuoc kt ON spct.id_kich_thuoc = kt.id
              INNER JOIN 
                  thuong_hieu th ON spct.id_thuong_hieu = th.id
              INNER JOIN 
                  xuat_xu xx ON spct.id_xuat_xu = xx.id
              INNER JOIN 
                  anh a ON spct.id_anh = a.id
              INNER JOIN 
                  mau m ON spct.id_mau = m.id
              INNER JOIN 
                  chat_lieu cl ON spct.id_chat_lieu = cl.id;
              """;

        List<ModelSPCT> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ModelSPCT(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getInt(10),
                        rs.getString(11), rs.getBoolean(12)));
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    
    public static void main(String[] args) {
    List<ModelSPCT> list = new BanHangRepository().getAll();
    list.stream().forEach(a -> System.out.println(a.toString()));
        System.out.println();
    }

}
