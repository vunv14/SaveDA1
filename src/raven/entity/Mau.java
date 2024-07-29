/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

//import lombok.Data;



//@Data


public class Mau {



    private Integer id;


    private String maMau;

    private String loaiMau;

    private Boolean trangThai;

    public Mau(Integer id, String maMau, String loaiMau, Boolean trangThai) {
        this.id = id;
        this.maMau = maMau;
        this.loaiMau = loaiMau;
        this.trangThai = trangThai;
    }
    
    
    public Mau() {
    }

    public Mau(String maMau, String loaiMau) {
        this.maMau = maMau;
        this.loaiMau = loaiMau;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaMau() {
        return maMau;
    }

    public void setMaMau(String maMau) {
        this.maMau = maMau;
    }

    public String getLoaiMau() {
        return loaiMau;
    }

    public void setLoaiMau(String loaiMau) {
        this.loaiMau = loaiMau;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Mau(String maMau, String loaiMau, Boolean trangThai) {
        this.maMau = maMau;
        this.loaiMau = loaiMau;
        this.trangThai = trangThai;
    }
    
    

   
    
}

