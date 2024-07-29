/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

public class KhachHang {

 
    private Integer id;


    private String maKhachHang;


    private String tenKh;


    private Boolean gioiTinh;

 
    private String sdt;

    private Boolean trangThai;

    public KhachHang() {
    }
    
    

    public KhachHang(Integer id, String maKhachHang, String tenKh, Boolean gioiTinh, String sdt, Boolean trangThai) {
        this.id = id;
        this.maKhachHang = maKhachHang;
        this.tenKh = tenKh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public KhachHang(String maKhachHang, String tenKh, Boolean gioiTinh, String sdt) {
        this.maKhachHang = maKhachHang;
        this.tenKh = tenKh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
    }
    
    
}
