package raven.application.form.other.thongke;

public class SanPhamResponse {

    private String maSP;
    private String tenSP;
    private String thuongHieu;
    private String chatLieu;
    private String size;
    private String xuatXu;
    private int soLuongTon;
    private int donGia;
    private int soLuongBan;
    private int doanhThu;

    @Override
    public String toString() {
        return "SanPhamResponse{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", thuongHieu=" + thuongHieu + ", chatLieu=" + chatLieu + ", size=" + size + ", xuatXu=" + xuatXu + ", soLuongTon=" + soLuongTon + ", donGia=" + donGia + ", soLuongBan=" + soLuongBan + ", doanhThu=" + doanhThu + '}';
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public SanPhamResponse(String maSP, String tenSP, String thuongHieu, String chatLieu, String size, String xuatXu, int soLuongTon, int donGia, int soLuongBan, int doanhThu) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.thuongHieu = thuongHieu;
        this.chatLieu = chatLieu;
        this.size = size;
        this.xuatXu = xuatXu;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.soLuongBan = soLuongBan;
        this.doanhThu = doanhThu;
    }


    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public int getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(int doanhThu) {
        this.doanhThu = doanhThu;
    }

    public SanPhamResponse(String maSP, String tenSP, String thuongHieu, String chatLieu, String xuatXu, int soLuongTon, int donGia, int soLuongBan, int doanhThu) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.thuongHieu = thuongHieu;
        this.chatLieu = chatLieu;
        this.xuatXu = xuatXu;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.soLuongBan = soLuongBan;
        this.doanhThu = doanhThu;
    }

    public SanPhamResponse() {
    }

}
