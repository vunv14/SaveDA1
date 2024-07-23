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
import raven.entity.HoaDonChiTiet;
import raven.entity.KichThuoc;
import raven.entity.KieuAo;
import raven.entity.Mau;
import raven.entity.SanPham;
import raven.entity.SanPhamChiTiet;
import raven.entity.ThuongHieu;
import raven.entity.VaiTro;
import raven.entity.XuatXu;

/**
 *
 * @author Nguyen Nam Truong
 */
public class SPCTRepository {
    
     private Connection con = null;
    
    private PreparedStatement ps = null;
    
    private ResultSet rs = null;
    
    private String sql = null;
    
    
        public List<SanPhamChiTiet> getAll(){
           sql = "select x.id,k.id,t.ten_thuong_hieu,v.dia_chia,a.ma_anh,m.loai_mau,c.ten_loai_vai\n" +
"				,x.so_luong,s.ten_san_pham,x.gia,ka.ten,s.trang_thai\n" +
"from san_pham_chi_tiet x left join kich_thuoc k\n" +
"						on x.id_kich_thuoc = k.id\n" +
"						left join thuong_hieu t \n" +
"						on x.id_thuong_hieu = t.id\n" +
"						left join xuat_xu v\n" +
"						on x.id_xuat_xu = v.id\n" +
"						left join san_pham s \n" +
"						on x.id_sp = s.id\n" +
"						left join anh a \n" +
"						on x.id_anh = a.id\n" +
"						left join mau m \n" +
"						on x.id_mau = m.id\n" +
"						left join chat_lieu c \n" +
"						on x.id_chat_lieu = c.id\n" +
"						left join kieu_ao ka \n" +
"						on x.id_kieu_ao = ka.id";
        List<SanPhamChiTiet> arr = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                   
                SanPhamChiTiet sp = new SanPhamChiTiet();
                sp.setId(rs.getInt("id"));
                KichThuoc k = new KichThuoc();
                k.setId(rs.getInt("id"));
                sp.setKt(k);
                
                ThuongHieu t = new ThuongHieu();
                t.setTenThuongHieu(rs.getString("ten_thuong_hieu"));
                sp.setTh(t);
                
                XuatXu x = new XuatXu();
                x.setDiaChia(rs.getString("dia_chia"));
                sp.setXx(x);
                Anh a = new Anh();
                a.setMaAnh(rs.getString("ma_anh"));
                sp.setA(a);
                
                 Mau m = new Mau();
                m.setLoaiMau(rs.getString("loai_mau"));
                sp.setM(m);
                
                ChatLieu c = new ChatLieu();
                c.setTenLoaiVai(rs.getString("ten_loai_vai"));
                sp.setCl(c);
                sp.setSoLuong(rs.getInt("so_luong"));
                
                SanPham s = new SanPham();
//                s.setMaSanPham(rs.getString("ma_san_pham"));
//                //s.setSoLuong(rs.getInt("so_luong"));
                s.setTenSanPham(rs.getString("ten_san_pham"));
                s.setTrangThai(rs.getBoolean("trang_thai"));
                sp.setSp(s);
                
                KieuAo y = new KieuAo();
                y.setTen(rs.getString("ten"));
                sp.setKa(y);
                sp.setGia(rs.getDouble("gia"));
                arr.add(sp);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
       return arr;
    }
    
    
    
    
    
    
    
    public void add(){
        
    }
    
    
    
    
    
    
    

    
    
    
}
