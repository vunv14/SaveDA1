/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

//import lombok.Data;


//@Data

public class HoaDon {

    private Integer id;

    private KhachHang kh;

    private VaiTro nv;
   
    private PhieuGiamGiaHoaDon phieuGiamGiaHoaDon;
  
    private String maHd;

    private Double tongTien;

    private Boolean trangThai;

    public HoaDon() {
    }

    public HoaDon(Integer id, KhachHang kh, VaiTro nv, PhieuGiamGiaHoaDon phieuGiamGiaHoaDon, String maHd, Double tongTien, Boolean trangThai) {
        this.id = id;
        this.kh = kh;
        this.nv = nv;
        this.phieuGiamGiaHoaDon = phieuGiamGiaHoaDon;
        this.maHd = maHd;
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

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

  
    
    
}
