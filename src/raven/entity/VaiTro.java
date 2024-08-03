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
    private String diaChi;
    private String hoTen;
    private Boolean chucVu;
    private String matKhau;
    private Boolean trangThai;
    private String email;
    public VaiTro() {
    }

    public VaiTro(Boolean gioiTinh, String sdt, Date ngaySinh, String cccd, String diaChi, String hoTen) {
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.diaChi = diaChi;
        this.hoTen = hoTen;
    }

    public VaiTro(Boolean gioiTinh, String sdt, Date ngaySinh, String cccd, String diaChi, String hoTen, String matKhau) {
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.diaChi = diaChi;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
    }

    public VaiTro(Integer id, String ma, Boolean gioiTinh, String sdt, Date ngaySinh, String cccd, String diaChi, String hoTen, Boolean chucVu, String matKhau, Boolean trangThai, String email) {
        this.id = id;
        this.ma = ma;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.diaChi = diaChi;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
        this.email = email;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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

    public VaiTro(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public VaiTro(Boolean gioiTinh, String sdt, Date ngaySinh, String cccd, String diaChi, String hoTen, String matKhau, String email) {
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.diaChi = diaChi;
        this.hoTen = hoTen;
        this.matKhau = matKhau;
        this.email = email;
    }
    
    
    
    
      
    
    
    
}
