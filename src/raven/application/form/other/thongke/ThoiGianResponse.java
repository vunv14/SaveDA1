package raven.application.form.other.thongke;

import java.time.LocalDate;

public class ThoiGianResponse {

    private LocalDate ngayTao;
    private Double doanhThu;

    @Override
    public String toString() {
        return "ThoiGianResponse{" + "ngayTao=" + ngayTao + ", doanhThu=" + doanhThu + '}';
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(Double doanhThu) {
        this.doanhThu = doanhThu;
    }

    public ThoiGianResponse(LocalDate ngayTao, Double doanhThu) {
        this.ngayTao = ngayTao;
        this.doanhThu = doanhThu;
    }

    public ThoiGianResponse() {
    }

}
