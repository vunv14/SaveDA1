package raven.application.form.other.thongke;

public class ThongKeModel {

    private String chatLieu;
    private String thuongHieu;
    private String xuatXu;
    private String Size;

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public ThongKeModel(String chatLieu, String thuongHieu, String xuatXu, String Size) {
        this.chatLieu = chatLieu;
        this.thuongHieu = thuongHieu;
        this.xuatXu = xuatXu;
        this.Size = Size;
    }

    public ThongKeModel() {
    }

}
