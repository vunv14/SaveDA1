/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;


import java.sql.Date;
public class HoaDon {

    private Integer id;

    private KhachHang kh;
    
//     public Double tt(){
//        return 
//    }

    private VaiTro nv;
   
    private PhieuGiamGiaHoaDon phieuGiamGiaHoaDon;
  
    private String maHd;
    
     private Date createAt;

    private Date updateAt;

    private Double tongTien;

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
