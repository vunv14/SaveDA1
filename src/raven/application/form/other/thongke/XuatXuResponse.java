package raven.application.form.other.thongke;

public class XuatXuResponse {

    private String xuatXu;

    @Override
    public String toString() {
        return "XuatXuResponse{" + "xuatXu=" + xuatXu + '}';
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public XuatXuResponse(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public XuatXuResponse() {
    }
}
