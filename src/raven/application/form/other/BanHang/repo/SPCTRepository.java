/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.BanHang.repo;

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
    
public List<SanPhamChiTiet> getAll() {
    String sql = """
          SELECT x.ma, 
                 x.id, 
                 k.size, 
                 t.ten_thuong_hieu, 
                 v.dia_chi, 
                 a.ten_anh, 
                 m.loai_mau, 
                 c.ten_loai_vai, 
                 ka.ten, 
                 x.so_luong, 
                 s.ten_san_pham, 
                 x.gia, 
                 x.trang_thai
          FROM san_pham_chi_tiet x 
          LEFT JOIN kich_thuoc k ON x.id_kich_thuoc = k.id
          LEFT JOIN thuong_hieu t ON x.id_thuong_hieu = t.id
          LEFT JOIN xuat_xu v ON x.id_xuat_xu = v.id
          LEFT JOIN san_pham s ON x.id_sp = s.id
          LEFT JOIN anh a ON x.id_anh = a.id
          LEFT JOIN mau m ON x.id_mau = m.id
          LEFT JOIN chat_lieu c ON x.id_chat_lieu = c.id
          LEFT JOIN kieu_ao ka ON x.id_kieu_ao = ka.id;
          """;
    List<SanPhamChiTiet> arr = new ArrayList<>();
    try (Connection con = DBConnect.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {                   
            SanPhamChiTiet sp = new SanPhamChiTiet();
            sp.setMa(rs.getString("ma"));  // Gán giá trị mã sản phẩm
            sp.setId(rs.getInt("id"));
            sp.setTrangThai(rs.getBoolean("trang_thai"));

            KichThuoc k = new KichThuoc();
            k.setSize(rs.getString("size"));
            sp.setKt(k);

            ThuongHieu t = new ThuongHieu();
            t.setTenThuongHieu(rs.getString("ten_thuong_hieu"));
            sp.setTh(t);

            XuatXu x = new XuatXu();
            x.setDiaChi(rs.getString("dia_chi"));
            sp.setXx(x);

            Anh a = new Anh();
            a.setTenAnh(rs.getString("ten_anh"));
            sp.setA(a);

            Mau m = new Mau();
            m.setLoaiMau(rs.getString("loai_mau"));
            sp.setM(m);

            ChatLieu c = new ChatLieu();
            c.setTenLoaiVai(rs.getString("ten_loai_vai"));
            sp.setCl(c);

            sp.setSoLuong(rs.getInt("so_luong"));

            SanPham s = new SanPham();
            s.setTenSanPham(rs.getString("ten_san_pham"));
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


// public List<SanPhamChiTiet> findby(String key){
//       return getAll().stream().filter((t) -> t.)
// }   
    
    
    
   public List<SanPhamChiTiet> findAll(String tenSanPham, String chatLieu, String kichThuoc, String mau) {
    StringBuilder sql = new StringBuilder("""
          SELECT x.ma, 
                 x.id, 
                 k.size, 
                 t.ten_thuong_hieu, 
                 v.dia_chi, 
                 a.ten_anh, 
                 m.loai_mau, 
                 c.ten_loai_vai, 
                 ka.ten, 
                 x.so_luong, 
                 s.ten_san_pham, 
                 x.gia, 
                 x.trang_thai
          FROM san_pham_chi_tiet x 
          LEFT JOIN kich_thuoc k ON x.id_kich_thuoc = k.id
          LEFT JOIN thuong_hieu t ON x.id_thuong_hieu = t.id
          LEFT JOIN xuat_xu v ON x.id_xuat_xu = v.id
          LEFT JOIN san_pham s ON x.id_sp = s.id
          LEFT JOIN anh a ON x.id_anh = a.id
          LEFT JOIN mau m ON x.id_mau = m.id
          LEFT JOIN chat_lieu c ON x.id_chat_lieu = c.id
          LEFT JOIN kieu_ao ka ON x.id_kieu_ao = ka.id
          WHERE 1=1
          """);

    // Kiểm tra từng tham số và chỉ thêm điều kiện nếu giá trị không phải là "tất cả" hoặc không rỗng
    if (tenSanPham != null && !tenSanPham.isEmpty() && !tenSanPham.equalsIgnoreCase("tất cả")) {
        sql.append(" AND s.ten_san_pham LIKE ?");
    }
    if (chatLieu != null && !chatLieu.isEmpty() && !chatLieu.equalsIgnoreCase("tất cả")) {
        sql.append(" AND c.ten_loai_vai = ?");
    }
    if (kichThuoc != null && !kichThuoc.isEmpty() && !kichThuoc.equalsIgnoreCase("tất cả")) {
        sql.append(" AND k.size = ?");
    }
    if (mau != null && !mau.isEmpty() && !mau.equalsIgnoreCase("tất cả")) {
        sql.append(" AND m.loai_mau = ?");
    }

    List<SanPhamChiTiet> arr = new ArrayList<>();
    try (Connection con = DBConnect.getConnection();
         PreparedStatement ps = con.prepareStatement(sql.toString())) {

        int index = 1;
        if (tenSanPham != null && !tenSanPham.isEmpty() && !tenSanPham.equalsIgnoreCase("tất cả")) {
            ps.setString(index++, "%" + tenSanPham + "%");
        }
        if (chatLieu != null && !chatLieu.isEmpty() && !chatLieu.equalsIgnoreCase("tất cả")) {
            ps.setString(index++, chatLieu);
        }
        if (kichThuoc != null && !kichThuoc.isEmpty() && !kichThuoc.equalsIgnoreCase("tất cả")) {
            ps.setString(index++, kichThuoc);
        }
        if (mau != null && !mau.isEmpty() && !mau.equalsIgnoreCase("tất cả")) {
            ps.setString(index++, mau);
        }

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            SanPhamChiTiet sp = new SanPhamChiTiet();
            sp.setId(rs.getInt("id"));
            sp.setTrangThai(rs.getBoolean("trang_thai"));

            KichThuoc k = new KichThuoc();
            k.setSize(rs.getString("size"));
            sp.setKt(k);

            ThuongHieu t = new ThuongHieu();
            t.setTenThuongHieu(rs.getString("ten_thuong_hieu"));
            sp.setTh(t);

            XuatXu x = new XuatXu();
            x.setDiaChi(rs.getString("dia_chi"));
            sp.setXx(x);

            Anh a = new Anh();
            a.setTenAnh(rs.getString("ten_anh"));
            sp.setA(a);

            Mau m = new Mau();
            m.setLoaiMau(rs.getString("loai_mau"));
            sp.setM(m);

            ChatLieu c = new ChatLieu();
            c.setTenLoaiVai(rs.getString("ten_loai_vai"));
            sp.setCl(c);

            sp.setSoLuong(rs.getInt("so_luong"));

            SanPham s = new SanPham();
            s.setTenSanPham(rs.getString("ten_san_pham"));
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

    
    
public Integer findByMa(String ma) {
    String sql = "SELECT hd.id_kh FROM hoa_don hd WHERE hd.ma_hd = ?";
    Integer khachHangId = null;

    try {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, ma);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            khachHangId = rs.getInt("id_kh");
        }

        rs.close();
        ps.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return khachHangId;
}

    
public SanPhamChiTiet findByMaSP(String ma) {
    String sql = """
          select spct.id, spct.ma
          from san_pham_chi_tiet spct 
          where ma like ?
          """;
    SanPhamChiTiet sanPhamChiTiet = null;

    try {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "%" + ma + "%");
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String maSP = rs.getString("ma");
            sanPhamChiTiet = new SanPhamChiTiet(id, maSP);
        }

        rs.close();
        ps.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return sanPhamChiTiet;
}
public HoaDon findByMaHoaDon(String ma) {
    String sql = "SELECT id, id_kh, id_nv, id_phieu_gg, ma_hd, tong_tien, trang_thai FROM hoa_don WHERE ma_hd LIKE ?";
    HoaDon hoaDon = null;

    try (Connection con = DBConnect.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, ma);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                // Tạo đối tượng HoaDon và gán các thuộc tính từ ResultSet
                hoaDon = new HoaDon();
                hoaDon.setId(rs.getInt("id")); // Gán giá trị id từ ResultSet
                hoaDon.setMaHd(rs.getString("ma_hd")); // Gán giá trị ma_hd từ ResultSet
                hoaDon.setTongTien(rs.getDouble("tong_tien")); // Gán giá trị tong_tien từ ResultSet
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return hoaDon;
}

    
}
