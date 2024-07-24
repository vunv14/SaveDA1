/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;



/**
 *
 * @author Nguyễn Vũ
 */


public class KieuAo {
    private Integer id;
    
    private String ma;
    
    private String ten;
    
    private Boolean trangThai;

    public KieuAo(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public KieuAo(Integer id, String ma, String ten, Boolean trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public KieuAo() {
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public KieuAo(String ma, String ten, Boolean trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    
    @Override
    public String toString() {
        return "KieuAo{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", trangThai=" + trangThai + '}';
    }


    
}
