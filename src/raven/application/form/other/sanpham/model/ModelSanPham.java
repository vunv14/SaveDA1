/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.sanpham.model;

/**
 *
 * @author Nguyễn Vũ
 */
public class ModelSanPham {

    private String maSanPham;

    private String tenSanPham;

    private String moTa;

    private int tongSoLuong;

    private boolean trangThai;

    public ModelSanPham(String maSanPham, String tenSanPham, String moTa, int tongSoLuong, boolean trangThai) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.tongSoLuong = tongSoLuong;
        this.trangThai = trangThai;
    }

    public ModelSanPham() {
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTongSoLuong() {
        return tongSoLuong;
    }

    public void setTongSoLuong(int tongSoLuong) {
        this.tongSoLuong = tongSoLuong;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ModelSanPham{" + "maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", moTa=" + moTa + ", tongSoLuong=" + tongSoLuong + ", trangThai=" + trangThai + '}';
    }
    
    

}
