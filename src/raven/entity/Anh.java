/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

//import lombok.Data;


/**
 *
 * @author Nguyễn Vũ
 */

//@Data
public class Anh {

    private Integer id;
    
    private String ma;
    
    private String Anh;
    
    private Boolean trangThai;

    public Anh(Integer id, String ma, String Anh, Boolean trangThai) {
        this.id = id;
        this.ma = ma;
        this.Anh = Anh;
        this.trangThai = trangThai;
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

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Anh() {
    }
    

    
}
