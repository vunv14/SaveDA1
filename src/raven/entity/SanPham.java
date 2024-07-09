/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

import java.sql.Date;
//import lombok.Data;

//@Data

public class SanPham {

    private Integer id;

    private String ma_san_pham;

    private String ten_san_pham;

    private Integer so_luong;

    private String mo_ta;

    private Date create_at;

    private Date update_at;

    private Integer create_by;

    private Integer update_by;

    private Boolean trang_thai;

    public SanPham() {
    }

    public SanPham(Integer id, String ma_san_pham, String ten_san_pham, Integer so_luong, String mo_ta, Date create_at, Date update_at, Integer create_by, Integer update_by, Boolean trang_thai) {
        this.id = id;
        this.ma_san_pham = ma_san_pham;
        this.ten_san_pham = ten_san_pham;
        this.so_luong = so_luong;
        this.mo_ta = mo_ta;
        this.create_at = create_at;
        this.update_at = update_at;
        this.create_by = create_by;
        this.update_by = update_by;
        this.trang_thai = trang_thai;
    }

    public SanPham(String ma_san_pham, String ten_san_pham, Integer so_luong, String mo_ta, Date create_at, Date update_at, Integer create_by, Integer update_by, Boolean trang_thai) {
        this.ma_san_pham = ma_san_pham;
        this.ten_san_pham = ten_san_pham;
        this.so_luong = so_luong;
        this.mo_ta = mo_ta;
        this.create_at = create_at;
        this.update_at = update_at;
        this.create_by = create_by;
        this.update_by = update_by;
        this.trang_thai = trang_thai;
    }

    public SanPham(String ma_san_pham, String ten_san_pham, Integer so_luong, String mo_ta) {
        this.ma_san_pham = ma_san_pham;
        this.ten_san_pham = ten_san_pham;
        this.so_luong = so_luong;
        this.mo_ta = mo_ta;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa_san_pham() {
        return ma_san_pham;
    }

    public void setMa_san_pham(String ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
    }

    public String getTen_san_pham() {
        return ten_san_pham;
    }

    public void setTen_san_pham(String ten_san_pham) {
        this.ten_san_pham = ten_san_pham;
    }

    public Integer getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(Integer so_luong) {
        this.so_luong = so_luong;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public Integer getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Integer create_by) {
        this.create_by = create_by;
    }

    public Integer getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(Integer update_by) {
        this.update_by = update_by;
    }

    public Boolean getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(Boolean trang_thai) {
        this.trang_thai = trang_thai;
    }
    
}
