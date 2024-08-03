package raven.application.form.other.thongke;

public class SizeResponse {

    private String size;

    @Override
    public String toString() {
        return "SizeResponse{" + "size=" + size + '}';
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public SizeResponse(String size) {
        this.size = size;
    }

    public SizeResponse() {
    }
}
