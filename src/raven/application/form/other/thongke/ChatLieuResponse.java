package raven.application.form.other.thongke;

public class ChatLieuResponse {
    
    private String ma;
    
    private String ten;

    @Override
    public String toString() {
        return "ChatLieuResponse{" + "ma=" + ma + ", ten=" + ten + '}';
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public ChatLieuResponse(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public ChatLieuResponse() {
    }

}
