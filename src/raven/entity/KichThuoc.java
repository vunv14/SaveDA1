/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

//import lombok.Data;


//@Data
public class KichThuoc {


    private Integer id;


    private String maKichThuoc;


    private String size;


    private Double rongAo;

 
    private  Double daiAo;


    private  Double rongVai;

 
    private  Double daiTay;

 
    private Boolean trangThai;

    public KichThuoc() {
    }
    
    

    public KichThuoc(Integer id, String maKichThuoc, String size, Double rongAo, Double daiAo, Double rongVai, Double daiTay, Boolean trangThai) {
        this.id = id;
        this.maKichThuoc = maKichThuoc;
        this.size = size;
        this.rongAo = rongAo;
        this.daiAo = daiAo;
        this.rongVai = rongVai;
        this.daiTay = daiTay;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaKichThuoc() {
        return maKichThuoc;
    }

    public void setMaKichThuoc(String maKichThuoc) {
        this.maKichThuoc = maKichThuoc;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getRongAo() {
        return rongAo;
    }

    public void setRongAo(Double rongAo) {
        this.rongAo = rongAo;
    }

    public Double getDaiAo() {
        return daiAo;
    }

    public void setDaiAo(Double daiAo) {
        this.daiAo = daiAo;
    }

    public Double getRongVai() {
        return rongVai;
    }

    public void setRongVai(Double rongVai) {
        this.rongVai = rongVai;
    }

    public Double getDaiTay() {
        return daiTay;
    }

    public void setDaiTay(Double daiTay) {
        this.daiTay = daiTay;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public KichThuoc(String maKichThuoc, String size, Double rongAo, Double daiAo, Double rongVai, Double daiTay) {
        this.maKichThuoc = maKichThuoc;
        this.size = size;
        this.rongAo = rongAo;
        this.daiAo = daiAo;
        this.rongVai = rongVai;
        this.daiTay = daiTay;
  
    }
    
    public Object[] toDaTaRow(){
        return new Object[]{maKichThuoc,size,rongAo,daiAo,rongVai,daiTay};
    }

    public KichThuoc(String maKichThuoc, String size, Double rongAo, Double daiAo, Double rongVai, Double daiTay, Boolean trangThai) {
        this.maKichThuoc = maKichThuoc;
        this.size = size;
        this.rongAo = rongAo;
        this.daiAo = daiAo;
        this.rongVai = rongVai;
        this.daiTay = daiTay;
        this.trangThai = trangThai;
    }

   
}
