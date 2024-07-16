/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

/**
 *
 * @author Nguyen Nam Truong
 */
public class KieuAo {
 
    private Integer id;

    private String ten;

    private Boolean trangThai;

    public KieuAo(Integer id, String ten, Boolean trangThai) {
        this.id = id;
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
    
    
}
