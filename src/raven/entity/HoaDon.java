/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;


import java.sql.Date;
import raven.application.form.other.BanHang.KhachHangThemNhanh;
public class HoaDon {

   
    private Integer id;

    private KhachHang kh;
    
    private VaiTro nv;
   
    private PhieuGiamGiaHoaDon phieuGiamGiaHoaDon;
  
    private String maHd;
    
    private Double giamGia;

    private Double tienKhachDua;
    
    private Double  tienChuyenKhoan;
   
    private Double tienThua;
    
     private Double tongTien;
    
    private Date createAt;

    private Date updateAt;
    
    private Boolean trangThai;

    public HoaDon() {
    }

    public HoaDon(String maHd) {
        this.maHd = maHd;
    }

    public HoaDon(VaiTro nv) {
        this.nv = nv;
    }

    public HoaDon(VaiTro nv, Boolean trangThai) {
        this.nv = nv;
        this.trangThai = trangThai;
    }
    

    
    
    public HoaDon(Integer id, KhachHang kh, VaiTro nv, PhieuGiamGiaHoaDon phieuGiamGiaHoaDon, String maHd, Date createAt, Date updateAt, Double tongTien, Boolean trangThai) {
        this.id = id;
        this.kh = kh;
        this.nv = nv;
        this.phieuGiamGiaHoaDon = phieuGiamGiaHoaDon;
        this.maHd = maHd;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public VaiTro getNv() {
        return nv;
    }

    public void setNv(VaiTro nv) {
        this.nv = nv;
    }

    public PhieuGiamGiaHoaDon getPhieuGiamGiaHoaDon() {
        return phieuGiamGiaHoaDon;
    }

    public void setPhieuGiamGiaHoaDon(PhieuGiamGiaHoaDon phieuGiamGiaHoaDon) {
        this.phieuGiamGiaHoaDon = phieuGiamGiaHoaDon;
    }

    public String getMaHd() {
        return maHd;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
    }

    public Double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(Double giamGia) {
        this.giamGia = giamGia;
    }

    public Double getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(Double tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public Double getTienChuyenKhoan() {
        return tienChuyenKhoan;
    }

    public void setTienChuyenKhoan(Double tienChuyenKhoan) {
        this.tienChuyenKhoan = tienChuyenKhoan;
    }

    public Double getTienThua() {
        return tienThua;
    }

    public void setTienThua(Double tienThua) {
        this.tienThua = tienThua;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", kh=" + kh + ", nv=" + nv + ", phieuGiamGiaHoaDon=" + phieuGiamGiaHoaDon + ", maHd=" + maHd + ", giamGia=" + giamGia + ", tienKhachDua=" + tienKhachDua + ", tienChuyenKhoan=" + tienChuyenKhoan + ", tienThua=" + tienThua + ", tongTien=" + tongTien + ", createAt=" + createAt + ", updateAt=" + updateAt + ", trangThai=" + trangThai + '}';
    }



    
    
}
