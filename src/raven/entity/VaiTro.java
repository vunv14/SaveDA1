/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

import java.sql.Date;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

//@ToString
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor

public class VaiTro {

    private Integer id;
    
    private Boolean gioi_tinh;
    
    private Date ngay_sinh;
    
    private String cccd;
    
    private String dia_chia;
    
    private String ho_ten;
    
    private String mat_khau;
    
    private Boolean trang_thai;
    
    private Boolean chuc_vu;

    public VaiTro(Integer id, String ho_ten, String mat_khau, Boolean trang_thai, Boolean chuc_vu) {
        this.id = id;
        this.ho_ten = ho_ten;
        this.mat_khau = mat_khau;
        this.trang_thai = trang_thai;
        this.chuc_vu = chuc_vu;
    }

    public VaiTro(Boolean gioi_tinh, Date ngay_sinh, String cccd, String dia_chia, String ho_ten, String mat_khau, Boolean trang_thai, Boolean chuc_vu) {
        this.gioi_tinh = gioi_tinh;
        this.ngay_sinh = ngay_sinh;
        this.cccd = cccd;
        this.dia_chia = dia_chia;
        this.ho_ten = ho_ten;
        this.mat_khau = mat_khau;
        this.trang_thai = trang_thai;
        this.chuc_vu = chuc_vu;
    }
    
    
    

    public VaiTro(Integer id, Boolean gioi_tinh, Date ngay_sinh, String cccd, String dia_chia, String ho_ten, String mat_khau, Boolean trang_thai, Boolean chuc_vu) {
        this.id = id;
        this.gioi_tinh = gioi_tinh;
        this.ngay_sinh = ngay_sinh;
        this.cccd = cccd;
        this.dia_chia = dia_chia;
        this.ho_ten = ho_ten;
        this.mat_khau = mat_khau;
        this.trang_thai = trang_thai;
        this.chuc_vu = chuc_vu;
    }

    public VaiTro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(Boolean gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDia_chia() {
        return dia_chia;
    }

    public void setDia_chia(String dia_chia) {
        this.dia_chia = dia_chia;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    public Boolean getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(Boolean trang_thai) {
        this.trang_thai = trang_thai;
    }

    public Boolean getChuc_vu() {
        return chuc_vu;
    }

    public void setChuc_vu(Boolean chuc_vu) {
        this.chuc_vu = chuc_vu;
    }

   
    
    
}
