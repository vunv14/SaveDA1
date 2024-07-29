/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

import java.sql.Date;


/**
 *
 * @author Nguyen Nam Truong
 */

public class SanPhamChiTiet {
 
    private Integer id;

    private int  IdKichThuoc;

    private int  IdThuongHieu;

    private int IdXuatXu ;

    private int IdSp;

    private int IdAnh;

    private int IdMau;

    private int IdChatLieu;

    private int IdKieuAo;
    
    private String ma;
    
       private Float gia;
       
         private Integer soLuong;
         
             private String doDay;

    private Date createAt;

    private Date updateAt;

    private Integer createBy;

    private Integer updateBy;

    private Boolean trangThai;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdKichThuoc() {
        return IdKichThuoc;
    }

    public void setIdKichThuoc(int IdKichThuoc) {
        this.IdKichThuoc = IdKichThuoc;
    }

    public int getIdThuongHieu() {
        return IdThuongHieu;
    }

    public void setIdThuongHieu(int IdThuongHieu) {
        this.IdThuongHieu = IdThuongHieu;
    }

    public int getIdXuatXu() {
        return IdXuatXu;
    }

    public void setIdXuatXu(int IdXuatXu) {
        this.IdXuatXu = IdXuatXu;
    }

    public int getIdSp() {
        return IdSp;
    }

    public void setIdSp(int IdSp) {
        this.IdSp = IdSp;
    }

    public int getIdAnh() {
        return IdAnh;
    }

    public void setIdAnh(int IdAnh) {
        this.IdAnh = IdAnh;
    }

    public int getIdMau() {
        return IdMau;
    }

    public void setIdMau(int IdMau) {
        this.IdMau = IdMau;
    }

    public int getIdChatLieu() {
        return IdChatLieu;
    }

    public void setIdChatLieu(int IdChatLieu) {
        this.IdChatLieu = IdChatLieu;
    }

    public int getIdKieuAo() {
        return IdKieuAo;
    }

    public void setIdKieuAo(int IdKieuAo) {
        this.IdKieuAo = IdKieuAo;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getDoDay() {
        return doDay;
    }

    public void setDoDay(String doDay) {
        this.doDay = doDay;
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

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

public Boolean getTrangThai() {
    return trangThai != null ? trangThai : false; // Hoặc giá trị mặc định khác
}

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(int IdKichThuoc, int IdThuongHieu, int IdXuatXu, int IdSp, int IdAnh, int IdMau, int IdChatLieu, int IdKieuAo, String ma, Float gia, Integer soLuong, String doDay, Date createAt, Date updateAt, Integer createBy, Integer updateBy, Boolean trangThai) {
        this.IdKichThuoc = IdKichThuoc;
        this.IdThuongHieu = IdThuongHieu;
        this.IdXuatXu = IdXuatXu;
        this.IdSp = IdSp;
        this.IdAnh = IdAnh;
        this.IdMau = IdMau;
        this.IdChatLieu = IdChatLieu;
        this.IdKieuAo = IdKieuAo;
        this.ma = ma;
        this.gia = gia;
        this.soLuong = soLuong;
        this.doDay = doDay;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.trangThai = trangThai;
    }

    public SanPhamChiTiet(Integer id, int IdKichThuoc, int IdThuongHieu, int IdXuatXu, int IdSp, int IdAnh, int IdMau, int IdChatLieu, int IdKieuAo, String ma, Float gia, Integer soLuong, String doDay, Date createAt, Date updateAt, Integer createBy, Integer updateBy, Boolean trangThai) {
        this.id = id;
        this.IdKichThuoc = IdKichThuoc;
        this.IdThuongHieu = IdThuongHieu;
        this.IdXuatXu = IdXuatXu;
        this.IdSp = IdSp;
        this.IdAnh = IdAnh;
        this.IdMau = IdMau;
        this.IdChatLieu = IdChatLieu;
        this.IdKieuAo = IdKieuAo;
        this.ma = ma;
        this.gia = gia;
        this.soLuong = soLuong;
        this.doDay = doDay;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.trangThai = trangThai;
    }

    public SanPhamChiTiet(int IdKichThuoc, int IdThuongHieu, int IdXuatXu, int IdSp, int IdAnh, int IdMau, int IdChatLieu, int IdKieuAo, String ma, Float gia, Integer soLuong, String doDay, Date createAt, Date updateAt, Integer createBy, Integer updateBy) {
        this.IdKichThuoc = IdKichThuoc;
        this.IdThuongHieu = IdThuongHieu;
        this.IdXuatXu = IdXuatXu;
        this.IdSp = IdSp;
        this.IdAnh = IdAnh;
        this.IdMau = IdMau;
        this.IdChatLieu = IdChatLieu;
        this.IdKieuAo = IdKieuAo;
        this.ma = ma;
        this.gia = gia;
        this.soLuong = soLuong;
        this.doDay = doDay;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
    }
    
    

    
    
    
    
}
