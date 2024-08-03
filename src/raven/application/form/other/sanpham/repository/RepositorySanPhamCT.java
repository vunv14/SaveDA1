/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.sanpham.repository;

/**
 *
 * @author Nguyễn Vũ
 */
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import raven.DBConnect.DBConnect;
import raven.application.form.other.sanpham.model.ModelSanPhamCT;
import raven.application.form.other.sanpham.model.reponeSanPhamCT;
import raven.entity.Anh;
import raven.entity.ChatLieu;
import raven.entity.KichThuoc;
import raven.entity.KieuAo;
import raven.entity.Mau;
import raven.entity.SanPham;
import raven.entity.SanPhamChiTiet;
import raven.entity.SanPhamChiTietSP;
import raven.entity.ThuongHieu;
import raven.entity.XuatXu;

public class RepositorySanPhamCT {

    Connection con = null;

    PreparedStatement ps = null;

    ResultSet rs = null;

    String sql = "";

    public List<ModelSanPhamCT> getAll(int itemsPerPage, int offset) {
        String sql = """
        SELECT spct.ma, spct.so_luong, spct.gia, sp.ten_san_pham, 
               cl.ten_loai_vai, kt.size, th.ten_thuong_hieu,
               xx.dia_chi, m.loai_mau, spct.do_day, ka.ten
        FROM san_pham_chi_tiet spct
        LEFT JOIN san_pham sp ON spct.id_sp = sp.id
        LEFT JOIN chat_lieu cl ON spct.id_chat_lieu = cl.id
        LEFT JOIN thuong_hieu th ON spct.id_thuong_hieu = th.id
        LEFT JOIN kieu_ao ka ON spct.id_kieu_ao = ka.id
        LEFT JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id
        LEFT JOIN xuat_xu xx ON spct.id_xuat_xu = xx.id
        LEFT JOIN mau m ON spct.id_mau = m.id
        WHERE spct.trang_thai = 1
        ORDER BY spct.ma
        OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
    """;

        List<ModelSanPhamCT> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, offset);         // Đổi thứ tự tham số OFFSET và LIMIT
            ps.setInt(2, itemsPerPage);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ModelSanPhamCT(rs.getString(1), rs.getInt(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ModelSanPhamCT> getAllSPCTById(int id, int limit, int offset) {
        String sql = """
            SELECT spct.ma, spct.so_luong, spct.gia, sp.ten_san_pham, 
                   cl.ten_loai_vai, kt.size, th.ten_thuong_hieu,
                   xx.dia_chi, m.loai_mau, spct.do_day, ka.ten
            FROM san_pham_chi_tiet spct
            LEFT JOIN san_pham sp ON spct.id_sp = sp.id
            LEFT JOIN chat_lieu cl ON spct.id_chat_lieu = cl.id
            LEFT JOIN thuong_hieu th ON spct.id_thuong_hieu = th.id
            LEFT JOIN kieu_ao ka ON spct.id_kieu_ao = ka.id
            LEFT JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id
            LEFT JOIN xuat_xu xx ON spct.id_xuat_xu = xx.id
            LEFT JOIN mau m ON spct.id_mau = m.id
            WHERE spct.trang_thai = 1 and spct.id_sp = ?
            ORDER BY spct.ma 
            OFFSET ? ROWS
            FETCH NEXT ? ROWS ONLY
    """;
        List<ModelSanPhamCT> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, offset);    // Offset: Bỏ qua số hàng
            ps.setInt(3, limit);     // Limit: Số lượng hàng lấy

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ModelSanPhamCT(rs.getString(1), rs.getInt(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int removeSanPhamCT(String ma) {
        sql = """
              DELETE FROM san_pham_chi_tiet
                    WHERE ma = ?
              """;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateSanPhamCT(String ma, SanPhamChiTietSP spct) {
        sql = """
            UPDATE [dbo].[san_pham_chi_tiet]
                 SET [id_kich_thuoc] = ?
                    ,[id_thuong_hieu] = ?
                    ,[id_xuat_xu] =?
                    ,[id_sp] = ?
                  
                    ,[id_mau] = ?
                    ,[id_chat_lieu] = ?
                    ,[id_kieu_ao] = ?
                    ,[create_at] = ?
                    ,[update_at] = ?
                    ,[create_by] = ?
                    ,[update_by] = ?
                    ,[gia] = ?
                    ,[so_luong] =?
                    ,[do_day] =?
                    ,[trang_thai] = ?
                  
               WHERE ma = ?
              
              """;
        List<ModelSanPhamCT> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, spct.getIdKichThuoc());
            ps.setObject(2, spct.getIdThuongHieu());
            ps.setObject(3, spct.getIdXuatXu());
            ps.setObject(4, spct.getIdSp());
            ps.setObject(5, spct.getIdMau());
            ps.setObject(6, spct.getIdChatLieu());
            ps.setObject(7, spct.getIdKieuAo());
            ps.setObject(8, (Date) spct.getCreateAt());
            ps.setObject(9, (Date) spct.getUpdateAt());
            ps.setObject(10, spct.getCreateBy());
            ps.setObject(11, spct.getUpdateBy());
            ps.setObject(12, spct.getGia());
            ps.setObject(13, spct.getSoLuong());
            ps.setObject(14, spct.getDoDay());
            ps.setObject(15, spct.getTrangThai());
            ps.setObject(16, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int addSanPhamCT(SanPhamChiTietSP spct) {
        sql = """
        INSERT INTO [dbo].[san_pham_chi_tiet]
                   ([id_kich_thuoc]
                   ,[id_thuong_hieu]
                   ,[id_xuat_xu]
                   ,[id_sp]
                   ,[id_anh]
                   ,[id_mau]
                   ,[id_chat_lieu]
                   ,[id_kieu_ao]
        		   ,[ma]
        		   ,[gia]
        
        		    ,[so_luong]
        			 ,[do_day]
                   ,[create_at]
                   ,[update_at]
                   ,[create_by]
                   ,[update_by]
                   
                  
                  
                   ,[trang_thai]
                   )
             VALUES
                   (?,
        		   ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
        """;

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, spct.getIdKichThuoc());
            ps.setInt(2, spct.getIdThuongHieu());
            ps.setInt(3, spct.getIdXuatXu());
            ps.setInt(4, spct.getIdSp());
            ps.setInt(5, spct.getIdAnh());
            ps.setInt(6, spct.getIdMau());
            ps.setInt(7, spct.getIdChatLieu());
            ps.setInt(8, spct.getIdKieuAo());
            ps.setString(9, spct.getMa());
            ps.setFloat(10, spct.getGia());
            ps.setInt(11, spct.getSoLuong());
            ps.setString(12, spct.getDoDay());
            ps.setDate(13, (Date) spct.getCreateAt());
            ps.setDate(14, (Date) spct.getUpdateAt());
            ps.setInt(15, spct.getCreateBy());
            ps.setInt(16, spct.getUpdateBy());
            ps.setBoolean(17, spct.getTrangThai());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // Trả về false nếu có lỗi xảy ra
    }

    public List<ModelSanPhamCT> search(String ten, int id) {
        String sql = """
       SELECT spct.ma, spct.so_luong, spct.gia, sp.ten_san_pham, 
              cl.ten_loai_vai, kt.size, th.ten_thuong_hieu,
              xx.dia_chi, m.loai_mau, spct.do_day, ka.ten
       FROM san_pham_chi_tiet spct
       LEFT JOIN san_pham sp ON spct.id_sp = sp.id
       LEFT JOIN chat_lieu cl ON spct.id_chat_lieu = cl.id
       LEFT JOIN thuong_hieu th ON spct.id_thuong_hieu = th.id
       LEFT JOIN kieu_ao ka ON spct.id_kieu_ao = ka.id
       LEFT JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id
       LEFT JOIN xuat_xu xx ON spct.id_xuat_xu = xx.id
       LEFT JOIN mau m ON spct.id_mau = m.id
       WHERE (spct.trang_thai = 1 OR spct.trang_thai = 2) AND ka.ten LIKE ? AND spct.id_sp = ?
      """;

        List<ModelSanPhamCT> list = new ArrayList<>();
        try (Connection con = DBConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + ten + "%");
            ps.setInt(2, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new ModelSanPhamCT(rs.getString(1), rs.getInt(2), rs.getFloat(3),
                            rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                            rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ModelSanPhamCT getAllSPCTByMa(String id) {
        String sql = """
           SELECT spct.ma, spct.so_luong, spct.gia, sp.ten_san_pham, 
                  cl.ten_loai_vai, kt.size, th.ten_thuong_hieu,
                  xx.dia_chi, m.loai_mau, spct.do_day, ka.ten
           FROM san_pham_chi_tiet spct
           LEFT JOIN san_pham sp ON spct.id_sp = sp.id
           LEFT JOIN chat_lieu cl ON spct.id_chat_lieu = cl.id
           LEFT JOIN thuong_hieu th ON spct.id_thuong_hieu = th.id
           LEFT JOIN kieu_ao ka ON spct.id_kieu_ao = ka.id
           LEFT JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id
           LEFT JOIN xuat_xu xx ON spct.id_xuat_xu = xx.id
           LEFT JOIN mau m ON spct.id_mau = m.id
           WHERE (spct.trang_thai = 1 OR spct.trang_thai = 2) AND spct.ma LIKE ?
    """;

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new ModelSanPhamCT(
                        rs.getString(1), rs.getInt(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Trả về null nếu không có dữ liệu
    }

    public List<ModelSanPhamCT> findAll(String size, String brand, String color, String material) {
        // Xây dựng câu lệnh SQL
        String sql = """
        SELECT spct.ma, spct.so_luong, spct.gia, sp.ten_san_pham, 
               cl.ten_loai_vai, kt.size, th.ten_thuong_hieu,
               xx.dia_chi, m.loai_mau, spct.do_day, ka.ten
        FROM san_pham_chi_tiet spct
        LEFT JOIN san_pham sp ON spct.id_sp = sp.id
        LEFT JOIN chat_lieu cl ON spct.id_chat_lieu = cl.id
        LEFT JOIN thuong_hieu th ON spct.id_thuong_hieu = th.id
        LEFT JOIN kieu_ao ka ON spct.id_kieu_ao = ka.id
        LEFT JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id
        LEFT JOIN xuat_xu xx ON spct.id_xuat_xu = xx.id
        LEFT JOIN mau m ON spct.id_mau = m.id
        WHERE (spct.trang_thai = 1 OR spct.trang_thai = 2)
    """;
        StringBuilder sb = new StringBuilder(sql);

        if (size != null && !size.equals("Tất Cả")) {
            sb.append(" AND kt.size = ?");
        }
        if (brand != null && !brand.equals("Tất Cả")) {
            sb.append(" AND th.ten_thuong_hieu = ?");
        }
        if (color != null && !color.equals("Tất Cả")) {
            sb.append(" AND m.loai_mau = ?");
        }

        List<ModelSanPhamCT> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sb.toString());

            int index = 1;
            if (size != null && !size.equals("Tất Cả")) {
                ps.setString(index++, size);
            }
            if (brand != null && !brand.equals("Tất Cả")) {
                ps.setString(index++, brand);
            }
            if (color != null && !color.equals("Tất Cả")) {
                ps.setString(index++, color);
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ModelSanPhamCT(rs.getString(1), rs.getInt(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getTotalCount(int id) {
        String sql = "SELECT COUNT(*) FROM san_pham_chi_tiet WHERE (trang_thai = 1 OR trang_thai = 2) AND id_sp = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1); // Số lượng bản ghi tổng cộng
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTotalCountAll() {
        String sql = "SELECT COUNT(*) FROM san_pham_chi_tiet WHERE (trang_thai = 1 OR trang_thai = 2) ";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1); // Số lượng bản ghi tổng cộng
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
  public List<ModelSanPhamCT> getAllSPCTById(int id) {
        String sql = """
            SELECT spct.ma, spct.so_luong, spct.gia, sp.ten_san_pham, 
                   cl.ten_loai_vai, kt.size, th.ten_thuong_hieu,
                   xx.dia_chi, m.loai_mau, spct.do_day, ka.ten
            FROM san_pham_chi_tiet spct
            LEFT JOIN san_pham sp ON spct.id_sp = sp.id
            LEFT JOIN chat_lieu cl ON spct.id_chat_lieu = cl.id
            LEFT JOIN thuong_hieu th ON spct.id_thuong_hieu = th.id
            LEFT JOIN kieu_ao ka ON spct.id_kieu_ao = ka.id
            LEFT JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id
            LEFT JOIN xuat_xu xx ON spct.id_xuat_xu = xx.id
            LEFT JOIN mau m ON spct.id_mau = m.id
            WHERE (spct.trang_thai = 1 OR spct.trang_thai = 2) AND spct.id_sp = ?
            ORDER BY spct.ma 
        
    """;
        List<ModelSanPhamCT> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ModelSanPhamCT(rs.getString(1), rs.getInt(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
  
  
  
  
  
  public List<ModelSanPhamCT> findAllBanHang(String tenSp, String size, String material, String color) {
    // Xây dựng câu lệnh SQL
    String sql = """
    SELECT spct.ma, spct.so_luong, spct.gia, sp.ten_san_pham, 
           cl.ten_loai_vai, kt.size, th.ten_thuong_hieu,
           xx.dia_chi, m.loai_mau, spct.do_day, ka.ten
    FROM san_pham_chi_tiet spct
    LEFT JOIN san_pham sp ON spct.id_sp = sp.id
    LEFT JOIN chat_lieu cl ON spct.id_chat_lieu = cl.id
    LEFT JOIN thuong_hieu th ON spct.id_thuong_hieu = th.id
    LEFT JOIN kieu_ao ka ON spct.id_kieu_ao = ka.id
    LEFT JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id
    LEFT JOIN xuat_xu xx ON spct.id_xuat_xu = xx.id
    LEFT JOIN mau m ON spct.id_mau = m.id
    WHERE (spct.trang_thai = 1 OR spct.trang_thai = 2)
    """;
    StringBuilder sb = new StringBuilder(sql);

    if (tenSp != null && !tenSp.isEmpty()) {
        sb.append(" AND sp.ten_san_pham LIKE ?");
    }
    if (size != null && !size.equals("Tất Cả")) {
        sb.append(" AND kt.size = ?");
    }
    if (material != null && !material.equals("Tất Cả")) {
        sb.append(" AND cl.ten_loai_vai = ?");
    }
    if (color != null && !color.equals("Tất Cả")) {
        sb.append(" AND m.loai_mau = ?");
    }

    List<ModelSanPhamCT> list = new ArrayList<>();
    try (Connection con = DBConnect.getConnection();
         PreparedStatement ps = con.prepareStatement(sb.toString())) {

        int index = 1;
        if (tenSp != null && !tenSp.isEmpty()) {
            ps.setString(index++, "%" + tenSp + "%");
        }
        if (size != null && !size.equals("Tất Cả")) {
            ps.setString(index++, size);
        }
        if (material != null && !material.equals("Tất Cả")) {
            ps.setString(index++, material);
        }
        if (color != null && !color.equals("Tất Cả")) {
            ps.setString(index++, color);
        }

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new ModelSanPhamCT(rs.getString(1), rs.getInt(2), rs.getFloat(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
  
  
  
  
  

    
public List<SanPhamChiTiet> getAllByMa(String ma) {
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
          LEFT JOIN kieu_ao ka ON x.id_kieu_ao = ka.id 
          WHERE x.ma LIKE ?
          """;
    List<SanPhamChiTiet> arr = new ArrayList<>();
    try (Connection con = DBConnect.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, "%" + ma + "%");
        try (ResultSet rs = ps.executeQuery()) {
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
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return arr;
}


}
