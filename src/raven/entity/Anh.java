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
    
    private String ten_anh;

    public Anh() {
    }

    public Anh(Integer id, String ten_anh, Boolean trang_thai) {
        this.id = id;
        this.ten_anh = ten_anh;
        this.trang_thai = trang_thai;
    }
    
    private Boolean trang_thai;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen_anh() {
        return ten_anh;
    }

    public void setTen_anh(String ten_anh) {
        this.ten_anh = ten_anh;
    }

    public Boolean getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(Boolean trang_thai) {
        this.trang_thai = trang_thai;
    }
    
    
}
