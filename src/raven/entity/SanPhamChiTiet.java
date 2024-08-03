/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

import java.sql.Date;

/**
 *
 * @author Nguyễn Vũ
 */

public class SanPhamChiTiet {

    private Integer id;

    private KichThuoc kt;

    private ThuongHieu th;

    private XuatXu xx;

    private SanPham sp;

    private Anh a;

    private Mau m;

    private ChatLieu cl;

    private KieuAo ka;
    
    private String ma;

    private Date createAt;

    private Date updateAt;

    private Integer createBy;

    private Integer updateBy;

    private Double gia;

    private Integer soLuong;

    private String doDay;

    private Boolean trangThai;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(SanPham sp) {
        this.sp = sp;
    }

    public SanPhamChiTiet(SanPham sp, KieuAo ka) {
        this.sp = sp;
        this.ka = ka;
    }
    
    

    public SanPhamChiTiet(Integer id, KichThuoc kt, ThuongHieu th, XuatXu xx, SanPham sp, Anh a, Mau m, ChatLieu cl, KieuAo ka, Date createAt, Date updateAt, Integer createBy, Integer updateBy, Double gia, Integer soLuong, String doDay, Boolean trangThai) {
        this.id = id;
        this.kt = kt;
        this.th = th;
        this.xx = xx;
        this.sp = sp;
        this.a = a;
        this.m = m;
        this.cl = cl;
        this.ka = ka;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.gia = gia;
        this.soLuong = soLuong;
        this.doDay = doDay;
        this.trangThai = trangThai;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public KichThuoc getKt() {
        return kt;
    }

    public void setKt(KichThuoc kt) {
        this.kt = kt;
    }

    public ThuongHieu getTh() {
        return th;
    }

    public void setTh(ThuongHieu th) {
        this.th = th;
    }

    public XuatXu getXx() {
        return xx;
    }

    public void setXx(XuatXu xx) {
        this.xx = xx;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public Anh getA() {
        return a;
    }

    public void setA(Anh a) {
        this.a = a;
    }

    public Mau getM() {
        return m;
    }

    public void setM(Mau m) {
        this.m = m;
    }

    public ChatLieu getCl() {
        return cl;
    }

    public void setCl(ChatLieu cl) {
        this.cl = cl;
    }

    public KieuAo getKa() {
        return ka;
    }

    public void setKa(KieuAo ka) {
        this.ka = ka;
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

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
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

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public SanPhamChiTiet(String ma) {
        this.ma = ma;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public SanPhamChiTiet(Integer id, String ma) {
        this.id = id;
        this.ma = ma;
    }

    
    

    
}
