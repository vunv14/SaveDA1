/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

/**
 *
 * @author Nguyen Nam Truong
 */
public class HinhThucThanhToanHoaDon {
    private Integer id;

    private Integer idHoadon;

    private Integer idHttt;

    private Boolean trangThai;

    public HinhThucThanhToanHoaDon() {
    }
    

    public HinhThucThanhToanHoaDon(Integer id, Integer idHoadon, Integer idHttt, Boolean trangThai) {
        this.id = id;
        this.idHoadon = idHoadon;
        this.idHttt = idHttt;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdHoadon() {
        return idHoadon;
    }

    public void setIdHoadon(Integer idHoadon) {
        this.idHoadon = idHoadon;
    }

    public Integer getIdHttt() {
        return idHttt;
    }

    public void setIdHttt(Integer idHttt) {
        this.idHttt = idHttt;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
