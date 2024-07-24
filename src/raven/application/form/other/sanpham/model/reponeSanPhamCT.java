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
public class reponeSanPhamCT {

    private int id;
    private int idKichThuoc;
    private int idThuongHieu;
    private int idXuatXu;
    private int idSp;
    private int idAnh;
    private int idMau;
    private int idChatLieu;
    private int idKieuAo;
    private String ma;
    private Float gia;
    private int soLuong;
    private String doDay;
    private Date createAt;
    private Date updateAt;
    private String createBy;

    private String updateBy;
    private int trangThai;

    public reponeSanPhamCT() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(int idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    public int getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(int idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public int getIdXuatXu() {
        return idXuatXu;
    }

    public void setIdXuatXu(int idXuatXu) {
        this.idXuatXu = idXuatXu;
    }

    public int getIdSp() {
        return idSp;
    }

    public void setIdSp(int idSp) {
        this.idSp = idSp;
    }

    public int getIdAnh() {
        return idAnh;
    }

    public void setIdAnh(int idAnh) {
        this.idAnh = idAnh;
    }

    public int getIdMau() {
        return idMau;
    }

    public void setIdMau(int idMau) {
        this.idMau = idMau;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public int getIdKieuAo() {
        return idKieuAo;
    }

    public void setIdKieuAo(int idKieuAo) {
        this.idKieuAo = idKieuAo;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public reponeSanPhamCT(int id, int idKichThuoc, int idThuongHieu, int idXuatXu, int idSp, int idAnh, int idMau, int idChatLieu, int idKieuAo, String ma, Float gia, int soLuong, String doDay, Date createAt, Date updateAt, String createBy, String updateBy, int trangThai) {
        this.id = id;
        this.idKichThuoc = idKichThuoc;
        this.idThuongHieu = idThuongHieu;
        this.idXuatXu = idXuatXu;
        this.idSp = idSp;
        this.idAnh = idAnh;
        this.idMau = idMau;
        this.idChatLieu = idChatLieu;
        this.idKieuAo = idKieuAo;
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

    public reponeSanPhamCT(int idKichThuoc, int idThuongHieu, int idXuatXu, int idSp, int idAnh, int idMau, int idChatLieu, int idKieuAo, String ma, Float gia, int soLuong, String doDay, Date createAt, Date updateAt, String createBy, String updateBy, int trangThai) {
        this.idKichThuoc = idKichThuoc;
        this.idThuongHieu = idThuongHieu;
        this.idXuatXu = idXuatXu;
        this.idSp = idSp;
        this.idAnh = idAnh;
        this.idMau = idMau;
        this.idChatLieu = idChatLieu;
        this.idKieuAo = idKieuAo;
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

}
