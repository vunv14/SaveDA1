package raven.application.form.other.thongke;

public class ThongKe {

    private double tongTien;
    private int thang;

    public ThongKe() {
    }

    public ThongKe(double tongTien, int thang) {
        this.tongTien = tongTien;
        this.thang = thang;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

}
