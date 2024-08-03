package raven.application.form.other.thongke;

public class ThuongHieuResponse {

    private String thuongHieu;

    @Override
    public String toString() {
        return "ThuongHieuResponse{" + "thuongHieu=" + thuongHieu + '}';
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public ThuongHieuResponse(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public ThuongHieuResponse() {
    }

}
