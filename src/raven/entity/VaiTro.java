/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.entity;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VaiTro {

    private Integer id;

    private Boolean gioi_tinh;

    private Date ngay_sinh;

    private String cccd;

    private String dia_chia;

    private String ho_ten;

    private String ma_khau;

    private Boolean trang_thai;

    private Boolean chuc_vu;

    public VaiTro(Integer id, String ho_ten, String ma_khau, Boolean trang_thai, Boolean chuc_vu) {
        this.id = id;
        this.ho_ten = ho_ten;
        this.ma_khau = ma_khau;
        this.trang_thai = trang_thai;
        this.chuc_vu = chuc_vu;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getGioi_tinh() {
        return gioi_tinh;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public String getCccd() {
        return cccd;
    }

    public String getDia_chia() {
        return dia_chia;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public String getMa_khau() {
        return ma_khau;
    }

    public Boolean getTrang_thai() {
        return trang_thai;
    }

    public Boolean getChuc_vu() {
        return chuc_vu;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGioi_tinh(Boolean gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setDia_chia(String dia_chia) {
        this.dia_chia = dia_chia;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public void setMa_khau(String ma_khau) {
        this.ma_khau = ma_khau;
    }

    public void setTrang_thai(Boolean trang_thai) {
        this.trang_thai = trang_thai;
    }

    public void setChuc_vu(Boolean chuc_vu) {
        this.chuc_vu = chuc_vu;
    }

    @Override
    public String toString() {
        return "VaiTro{" + "id=" + id + ", gioi_tinh=" + gioi_tinh + ", ngay_sinh=" + ngay_sinh + ", cccd=" + cccd + ", dia_chia=" + dia_chia + ", ho_ten=" + ho_ten + ", ma_khau=" + ma_khau + ", trang_thai=" + trang_thai + ", chuc_vu=" + chuc_vu + '}';
    }

}
