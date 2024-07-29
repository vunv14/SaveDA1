/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import raven.DBConnect.DBConnect;
import raven.entity.Anh;
import raven.entity.ChatLieu;
import raven.entity.HoaDon;
import raven.entity.HoaDonChiTiet;
import raven.entity.KhachHang;
import raven.entity.KichThuoc;
import raven.entity.KieuAo;
import raven.entity.Mau;
import raven.entity.PhieuGiamGiaHoaDon;
import raven.entity.SanPham;
import raven.entity.SanPhamChiTiet;
import raven.entity.ThuongHieu;
import raven.entity.VaiTro;
import raven.entity.XuatXu;

/**
 *
 * @author Nguyen Nam Truong
 */
public class HoaDonRepositoryV1 {

    private Connection con = null;

    private PreparedStatement ps = null;

    private ResultSet rs = null;

    private String sql = null;

    public void addHD(HoaDon x) {
        sql = "insert into hoa_don(id_nv,id_kh,trang_thai) values(2,4,0)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<HoaDon> getAll() {
//        sql = "select h.id,x.ho_ten,h.create_at,h.trang_thai from hoa_don h left join vai_tro x\n"
//                + "				on h.id_nv = x.id";
    sql = "select h.id,x.ho_ten,h.create_at,h.trang_thai from hoa_don h left join vai_tro x\n" +
"             				on h.id_nv = x.id\n" +
"			where h.trang_thai = 0";
        List<HoaDon> arr = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getInt("id"));
                VaiTro x = new VaiTro();
                x.setHoTen(rs.getString("ho_ten"));
                hd.setNv(x);
                hd.setCreateAt(rs.getDate("create_at"));
                hd.setTrangThai(rs.getBoolean("trang_thai"));
                arr.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
    
    
        public List<HoaDon> getAllV2() {
            sql = "select h.id,c.ho_ten,kh.id,kh.ten_kh,kh.sdt,h.create_at,h.trang_thai from hoa_don h left join vai_tro c\n" +
"				on h.id_nv = c.id\n" +
"				left join khach_hang kh\n" +
"				on h.id_kh = kh.id where h.trang_thai = 0";                   
                    List<HoaDon> arr = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getInt("id"));
                VaiTro x = new VaiTro();
                x.setHoTen(rs.getString("ho_ten"));
                KhachHang kh = new KhachHang();
                kh.setId(rs.getInt("id"));
                kh.setTenKh(rs.getString("ten_kh"));
                kh.setSdt(rs.getString("sdt"));
                hd.setKh(kh);
                hd.setNv(x);
                hd.setCreateAt(rs.getDate("create_at"));
                hd.setTrangThai(rs.getBoolean("trang_thai"));
                arr.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
        
public List<HoaDon> getAllV3() {
               sql = "select h.id,c.ho_ten,kh.id,kh.ten_kh,kh.sdt,h.create_at,h.trang_thai,h.tong_tien from hoa_don h left join vai_tro c\n" +
"		      on h.id_nv = c.id\n" +
"		      left join khach_hang kh\n" +
"		      on h.id_kh = kh.id where h.trang_thai = 0";  
        List<HoaDon> arr = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getInt("id"));
                VaiTro x = new VaiTro();
                x.setHoTen(rs.getString("ho_ten"));
                KhachHang kh = new KhachHang();
                kh.setId(rs.getInt("id"));
                kh.setTenKh(rs.getString("ten_kh"));
                kh.setSdt(rs.getString("sdt"));
                hd.setKh(kh);
                hd.setNv(x);
                hd.setTongTien(rs.getDouble("tong_tien"));
                hd.setCreateAt(rs.getDate("create_at"));
                hd.setTrangThai(rs.getBoolean("trang_thai"));
                arr.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }


        
        
        
    public void delete(Integer id) {
        sql = "update hoa_don set trang_thai = 1 where id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
