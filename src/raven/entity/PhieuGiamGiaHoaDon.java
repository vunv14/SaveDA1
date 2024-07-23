/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;
import java.sql.Date;
public class PhieuGiamGiaHoaDon {
    private Integer id;
    private String maPhieuGiamGia;
    private String tenPhieuGiamGia;
    private Boolean kieuGiamGia;
    private Double giaTriToiThieu;
    private Double giaTriGiam;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private Integer soLuong;
    private String hoatDong;
    private Boolean trangThai;
    public PhieuGiamGiaHoaDon(Integer id, String maPhieuGiamGia, String tenPhieuGiamGia, Boolean kieuGiamGia, Double giaTriToiThieu, Double giaTriGiam, Date ngayBatDau, Date ngayKetThuc, Integer soLuong, String hoatDong, Boolean trangThai) {
        this.id = id;
        this.maPhieuGiamGia = maPhieuGiamGia;
        this.tenPhieuGiamGia = tenPhieuGiamGia;
        this.kieuGiamGia = kieuGiamGia;
        this.giaTriToiThieu = giaTriToiThieu;
        this.giaTriGiam = giaTriGiam;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.soLuong = soLuong;
        this.hoatDong = hoatDong;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaPhieuGiamGia() {
        return maPhieuGiamGia;
    }

    public void setMaPhieuGiamGia(String maPhieuGiamGia) {
        this.maPhieuGiamGia = maPhieuGiamGia;
    }

    public String getTenPhieuGiamGia() {
        return tenPhieuGiamGia;
    }

    public void setTenPhieuGiamGia(String tenPhieuGiamGia) {
        this.tenPhieuGiamGia = tenPhieuGiamGia;
    }

    public Boolean getKieuGiamGia() {
        return kieuGiamGia;
    }

    public void setKieuGiamGia(Boolean kieuGiamGia) {
        this.kieuGiamGia = kieuGiamGia;
    }

    public Double getGiaTriToiThieu() {
        return giaTriToiThieu;
    }

    public void setGiaTriToiThieu(Double giaTriToiThieu) {
        this.giaTriToiThieu = giaTriToiThieu;
    }

    public Double getGiaTriGiam() {
        return giaTriGiam;
    }

    public void setGiaTriGiam(Double giaTriGiam) {
        this.giaTriGiam = giaTriGiam;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getHoatDong() {
        return hoatDong;
    }

    public void setHoatDong(String hoatDong) {
        this.hoatDong = hoatDong;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    
    
}
