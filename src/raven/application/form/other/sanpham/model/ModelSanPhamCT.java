/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.sanpham.model;

import java.util.Date;

/**
 *
 * @author Nguyễn Vũ
 */
public class ModelSanPhamCT {

    private String ma;

    private int soLuong;

    private Float gia;

    private String tenSP;

    private String chatLieu;

    private String kichThuoc;

    private String thuongHieu;

    private String diaChi;

    private String anh;

    private String mau;

    private String doDay;

    public ModelSanPhamCT(String ma, int soLuong, Float gia, String tenSP, String chatLieu, String kichThuoc, String thuongHieu, String diaChi, String mau, String doDay, String kieuAo) {
        this.ma = ma;
        this.soLuong = soLuong;
        this.gia = gia;
        this.tenSP = tenSP;
        this.chatLieu = chatLieu;
        this.kichThuoc = kichThuoc;
        this.thuongHieu = thuongHieu;
        this.diaChi = diaChi;
        this.mau = mau;
        this.doDay = doDay;
        this.kieuAo = kieuAo;
    }

    private String kieuAo;

    private Date createAt;

    private Date updateAt;

    private String createBy;

    private String updateBy;

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getKieuAo() {
        return kieuAo;
    }

    public void setKieuAo(String kieuAo) {
        this.kieuAo = kieuAo;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDoDay() {
        return doDay;
    }

    public void setDoDay(String doDay) {
        this.doDay = doDay;
    }

    public ModelSanPhamCT() {
    }

    public ModelSanPhamCT(String ma, String kichThuoc, String thuongHieu, String diaChi, String tenSP, String anh, String mau, String chatLieu, String kieuAo, Date createAt, Date updateAt, String createBy, String updateBy, Float gia, int soLuong, String doDay) {
        this.ma = ma;
        this.kichThuoc = kichThuoc;
        this.thuongHieu = thuongHieu;
        this.diaChi = diaChi;
        this.tenSP = tenSP;
        this.anh = anh;
        this.mau = mau;
        this.chatLieu = chatLieu;
        this.kieuAo = kieuAo;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.gia = gia;
        this.soLuong = soLuong;
        this.doDay = doDay;

    }

}
