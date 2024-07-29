/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

/**
 *
 * @author Nguyen Nam Truong
 */
public class GiamGiaSPCT {

    private Integer id;

    private Integer idSpct;

    private Integer idDotGiamGia;

    private Integer soTienGiam;

    private Boolean trangThai;

    public GiamGiaSPCT(Integer id, Integer idSpct, Integer idDotGiamGia, Integer soTienGiam, Boolean trangThai) {
        this.id = id;
        this.idSpct = idSpct;
        this.idDotGiamGia = idDotGiamGia;
        this.soTienGiam = soTienGiam;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdSpct() {
        return idSpct;
    }

    public void setIdSpct(Integer idSpct) {
        this.idSpct = idSpct;
    }

    public Integer getIdDotGiamGia() {
        return idDotGiamGia;
    }

    public void setIdDotGiamGia(Integer idDotGiamGia) {
        this.idDotGiamGia = idDotGiamGia;
    }

    public Integer getSoTienGiam() {
        return soTienGiam;
    }

    public void setSoTienGiam(Integer soTienGiam) {
        this.soTienGiam = soTienGiam;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
