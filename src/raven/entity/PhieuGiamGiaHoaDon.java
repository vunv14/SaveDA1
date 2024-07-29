package raven.entity;


import java.util.Date;
public class PhieuGiamGiaHoaDon {

    private Integer id;

    private String maGiamGia;

    private String ten;

    private Boolean kieuGiamGia;

    private Double giaTriGiam;

    private Double giaTriToiThieu;

    private Date ngayBatDau;

    private Date ngayKetThuc;

    private int soLuong;

    private int trang_thai;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaGiamGia() {
        return maGiamGia;
    }

    public void setMaGiamGia(String maGiamGia) {
        this.maGiamGia = maGiamGia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Boolean getKieuGiamGia() {
        return kieuGiamGia;
    }

    public void setKieuGiamGia(Boolean kieuGiamGia) {
        this.kieuGiamGia = kieuGiamGia;
    }

    public Double getGiaTriGiam() {
        return giaTriGiam;
    }

    public void setGiaTriGiam(Double giaTriGiam) {
        this.giaTriGiam = giaTriGiam;
    }

    public Double getGiaTriToiThieu() {
        return giaTriToiThieu;
    }

    public void setGiaTriToiThieu(Double giaTriToiThieu) {
        this.giaTriToiThieu = giaTriToiThieu;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(int trang_thai) {
        this.trang_thai = trang_thai;
    }

    public PhieuGiamGiaHoaDon() {
    }

    public PhieuGiamGiaHoaDon(Integer id, String maGiamGia, String ten, Boolean kieuGiamGia, Double giaTriGiam, Double giaTriToiThieu, Date ngayBatDau, Date ngayKetThuc, int soLuong, int trang_thai) {
        this.id = id;
        this.maGiamGia = maGiamGia;
        this.ten = ten;
        this.kieuGiamGia = kieuGiamGia;
        this.giaTriGiam = giaTriGiam;
        this.giaTriToiThieu = giaTriToiThieu;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.soLuong = soLuong;
        this.trang_thai = trang_thai;
    }
    
    
}