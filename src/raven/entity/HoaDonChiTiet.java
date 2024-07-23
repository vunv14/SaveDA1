/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

//import lombok.Data;
import java.sql.Date;

public class HoaDonChiTiet {

    private Integer id;

    private SanPhamChiTiet spct;

    private HoaDon hd;
    
   

    private Integer soLuong;

    private Double gia;

    private Date createAt;

    private Date updateAt;

    private Integer createBy;

    private Integer updateBy;

    private Boolean trangThai;
    
    public Double tongTien(){
        return gia * soLuong;
    }

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(SanPhamChiTiet spct, HoaDon hd, Integer soLuong) {
        this.spct = spct;
        this.hd = hd;
        this.soLuong = soLuong;
    }
    
    

    public HoaDonChiTiet(SanPhamChiTiet spct, HoaDon hd, Integer soLuong, Double gia) {
        this.spct = spct;
        this.hd = hd;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public HoaDonChiTiet(SanPhamChiTiet spct, Integer soLuong, Double gia, Boolean trangThai) {
        this.spct = spct;
        this.soLuong = soLuong;
        this.gia = gia;
        this.trangThai = trangThai;
    }
    
    
    
    

    public HoaDonChiTiet(SanPhamChiTiet spct, Integer soLuong, Double gia) {
        this.spct = spct;
        this.soLuong = soLuong;
        this.gia = gia;
    }
    
    

    public HoaDonChiTiet(Integer id, SanPhamChiTiet spct, HoaDon hd, Integer soLuong, Double gia, Date createAt, Date updateAt, Integer createBy, Integer updateBy, Boolean trangThai) {
        this.id = id;
        this.spct = spct;
        this.hd = hd;
        this.soLuong = soLuong;
        this.gia = gia;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SanPhamChiTiet getSpct() {
        return spct;
    }

    public void setSpct(SanPhamChiTiet spct) {
        this.spct = spct;
    }

    public HoaDon getHd() {
        return hd;
    }

    public void setHd(HoaDon hd) {
        this.hd = hd;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
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
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
    

  
    
  
    
}
