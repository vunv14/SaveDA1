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
    
    public String ma;
    
    private String tenSanPham;
    
    private String moTa;
    
    private Date createAt;
    
    private Date updateAt;
    
    private Integer createBy;
    
    private Integer updateby;
    
    private Boolean trangThai;

    public SanPham(Integer id, String ma, String tenSanPham, String moTa, Date createAt, Date updateAt, Integer createBy, Integer updateby, Boolean trangThai) {
        this.id = id;
        this.ma = ma;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateby = updateby;
        this.trangThai = trangThai;
    }

    public SanPham() {
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

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getUpdateby() {
        return updateby;
    }

    public void setUpdateby(Integer updateby) {
        this.updateby = updateby;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    
public SanPham(String ma, String tenSanPham, String moTa, Date createAt, Date updateAt, Integer createBy, Integer updateBy, Boolean trangThai) {
        this.ma = ma;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateby = updateBy;
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPham{" + "id=" + id + ", ma=" + ma + ", tenSanPham=" + tenSanPham + ", moTa=" + moTa + ", createAt=" + createAt + ", updateAt=" + updateAt + ", createBy=" + createBy + ", updateby=" + updateby + ", trangThai=" + trangThai + '}';
    }


    
    
    
}
