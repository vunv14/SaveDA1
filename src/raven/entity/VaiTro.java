/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

import java.sql.Date;
import java.util.logging.Logger;

public class VaiTro {

    private Integer id;
    private String ma;
    private Boolean gioiTinh;
    private String sdt;
    private Date ngaySinh;
    private String cccd;
    private String diaChia;
    private String hoTen;
    private Boolean chucVu;
    private String matKhau;
    private Boolean trangThai;
    public VaiTro() {
    }

    public VaiTro(Boolean gioiTinh, String sdt, Date ngaySinh, String cccd, String diaChia, String hoTen) {
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.diaChia = diaChia;
        this.hoTen = hoTen;
    }
    

   
    



    public VaiTro(Integer id, String hoTen, Boolean chucVu, String matKhau, Boolean trangThai) {
        this.id = id;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDiaChia() {
        return diaChia;
    }

    public void setDiaChia(String diaChia) {
        this.diaChia = diaChia;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Boolean getChucVu() {
        return chucVu;
    }

    public void setChucVu(Boolean chucVu) {
        this.chucVu = chucVu;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
    
}
