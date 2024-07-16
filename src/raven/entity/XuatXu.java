/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;


public class XuatXu {


    private Integer id;

    private String maXuatXu;


    private String diaChia;

    private Boolean trangThai;

    public XuatXu() {
    }
    

    public XuatXu(Integer id, String maXuatXu, String diaChia, Boolean trangThai) {
        this.id = id;
        this.maXuatXu = maXuatXu;
        this.diaChia = diaChia;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaXuatXu() {
        return maXuatXu;
    }

    public void setMaXuatXu(String maXuatXu) {
        this.maXuatXu = maXuatXu;
    }

    public String getDiaChia() {
        return diaChia;
    }

    public void setDiaChia(String diaChia) {
        this.diaChia = diaChia;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
   
    
    
}

