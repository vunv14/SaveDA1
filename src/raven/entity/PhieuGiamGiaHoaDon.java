/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

public class PhieuGiamGiaHoaDon {

  
    private Integer id;


    private String maPhieuGiamGia;


    private Double thanhToan;


    private Double giaTriToiDa;


    private Double giaTriToiThieu;

    private Boolean trangThai;

    public PhieuGiamGiaHoaDon() {
    }

    
    public PhieuGiamGiaHoaDon(Integer id, String maPhieuGiamGia, Double thanhToan, Double giaTriToiDa, Double giaTriToiThieu, Boolean trangThai) {
        this.id = id;
        this.maPhieuGiamGia = maPhieuGiamGia;
        this.thanhToan = thanhToan;
        this.giaTriToiDa = giaTriToiDa;
        this.giaTriToiThieu = giaTriToiThieu;
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

    public Double getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(Double thanhToan) {
        this.thanhToan = thanhToan;
    }

    public Double getGiaTriToiDa() {
        return giaTriToiDa;
    }

    public void setGiaTriToiDa(Double giaTriToiDa) {
        this.giaTriToiDa = giaTriToiDa;
    }

    public Double getGiaTriToiThieu() {
        return giaTriToiThieu;
    }

    public void setGiaTriToiThieu(Double giaTriToiThieu) {
        this.giaTriToiThieu = giaTriToiThieu;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
