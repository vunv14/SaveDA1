/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

public class ChatLieu {

    private Integer id;


    private String maChatLieu;

    private String tenLoaiVai;
    
    private Boolean trangThai;
    public ChatLieu() {
    }
    

    public ChatLieu(Integer id, String maChatLieu, String tenLoaiVai) {
        this.id = id;
        this.maChatLieu = maChatLieu;
        this.tenLoaiVai = tenLoaiVai;
    }
    
    

 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(String maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public String getTenLoaiVai() {
        return tenLoaiVai;
    }

    public void setTenLoaiVai(String tenLoaiVai) {
        this.tenLoaiVai = tenLoaiVai;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }
    
    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public ChatLieu(Integer id, String maChatLieu, String tenLoaiVai, Boolean trangThai) {
        this.id = id;
        this.maChatLieu = maChatLieu;
        this.tenLoaiVai = tenLoaiVai;
        this.trangThai = trangThai;
    }

    public ChatLieu(String maChatLieu, String tenLoaiVai, Boolean trangThai) {
        this.maChatLieu = maChatLieu;
        this.tenLoaiVai = tenLoaiVai;
        this.trangThai = trangThai;
    }

   
    
    
    
    
            
}
