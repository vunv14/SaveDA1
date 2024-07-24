/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

//import lombok.Data;


//@Data
public class ChatLieu {

    private Integer id;
    
    private String ma;
    
    private String loaivai;
    
    private Boolean trangThai;

    public ChatLieu(Integer id, String ma, String loaivai, Boolean trangThai) {
        this.id = id;
        this.ma = ma;
        this.loaivai = loaivai;
        this.trangThai = trangThai;
    }

    public ChatLieu() {
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

    public String getLoaivai() {
        return loaivai;
    }

    public void setLoaivai(String loaivai) {
        this.loaivai = loaivai;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
            
}
