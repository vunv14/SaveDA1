/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;


/**
 *
 * @author Nguyễn Vũ
 */

//@Data
public class Anh {
    private Integer id;

    private String maAnh;
  
    private String tenAnh;

    private Boolean trangThai;

    public Anh() {
    }
    

    public Anh(Integer id, String maAnh, String tenAnh, Boolean trangThai) {
        this.id = id;
        this.maAnh = maAnh;
        this.tenAnh = tenAnh;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaAnh() {
        return maAnh;
    }

    public void setMaAnh(String maAnh) {
        this.maAnh = maAnh;
    }

    public String getTenAnh() {
        return tenAnh;
    }

    public void setTenAnh(String tenAnh) {
        this.tenAnh = tenAnh;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
