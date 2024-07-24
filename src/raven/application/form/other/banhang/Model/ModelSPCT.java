/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.banhang.Model;

import raven.entity.ThuongHieu;

/**
 *
 * @author Nguyễn Vũ
 */
public class ModelSPCT {
    
    private int idSPCT;
    
    private String tenSP;
    
    private String kichThuoc;
    
    private String tenThuongHieu;
    
    private String xuatXu;
    
    private String anh;
    
    private String mau;
    
    private String loaiVai;
    
    private double gia;
    
    private int soLuong;
    
    private String doDay;
    
    private boolean status;

    public ModelSPCT(int idSPCT, String tenSP, String kichThuoc, String tenThuongHieu, String xuatXu, String anh, String mau, String loaiVai, double gia, int soLuong, String doDay, boolean status) {
        this.idSPCT = idSPCT;
        this.tenSP = tenSP;
        this.kichThuoc = kichThuoc;
        this.tenThuongHieu = tenThuongHieu;
        this.xuatXu = xuatXu;
        this.anh = anh;
        this.mau = mau;
        this.loaiVai = loaiVai;
        this.gia = gia;
        this.soLuong = soLuong;
        this.doDay = doDay;
        this.status = status;
    }

    public ModelSPCT() {
    }

    public int getIdSPCT() {
        return idSPCT;
    }

    public void setIdSPCT(int idSPCT) {
        this.idSPCT = idSPCT;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getLoaiVai() {
        return loaiVai;
    }

    public void setLoaiVai(String loaiVai) {
        this.loaiVai = loaiVai;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDoDay() {
        return doDay;
    }

    public void setDoDay(String doDay) {
        this.doDay = doDay;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

 
    
    Object toDaTaRow(){
        return new Object[]{idSPCT,tenSP,kichThuoc,tenThuongHieu,xuatXu,anh,mau,loaiVai,gia,soLuong,doDay, soLuong != 0 ? "còn hàng" : " hết hàng"};
    }

    @Override
    public String toString() {
        return "ModelSPCT{" + "idSPCT=" + idSPCT + ", tenSP=" + tenSP + ", kichThuoc=" + kichThuoc + ", tenThuongHieu=" + tenThuongHieu + ", xuatXu=" + xuatXu + ", anh=" + anh + ", mau=" + mau + ", loaiVai=" + loaiVai + ", gia=" + gia + ", soLuong=" + soLuong + ", doDay=" + doDay + ", status=" + status + '}';
    }
    
}
