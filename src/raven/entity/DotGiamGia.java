/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

import java.util.Date;


/**
 *
 * @author Nguyen Nam Truong
 */
public class DotGiamGia {

    private Integer id;
    private String maDotGiamGia;
    private String tenDotGiamGia;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String hinhThucGiamGia;
    private int trangThai;

    public DotGiamGia() {
    }

    public DotGiamGia(String maDotGiamGia, String tenDotGiamGia, Date ngayBatDau, Date ngayKetThuc, String hinhThucGiamGia, int trangThai) {
        this.maDotGiamGia = maDotGiamGia;
        this.tenDotGiamGia = tenDotGiamGia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.hinhThucGiamGia = hinhThucGiamGia;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaDotGiamGia() {
        return maDotGiamGia;
    }

    public void setMaDotGiamGia(String maDotGiamGia) {
        this.maDotGiamGia = maDotGiamGia;
    }

    public String getTenDotGiamGia() {
        return tenDotGiamGia;
    }

    public void setTenDotGiamGia(String tenDotGiamGia) {
        this.tenDotGiamGia = tenDotGiamGia;
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

    public String getHinhThucGiamGia() {
        return hinhThucGiamGia;
    }

    public void setHinhThucGiamGia(String hinhThucGiamGia) {
        this.hinhThucGiamGia = hinhThucGiamGia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}