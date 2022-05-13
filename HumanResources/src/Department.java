public class Department {
    private String mbp;
    private String nameBp;
    private int slnv;

    public Department() {
    }

    public Department(String mbp, String nameBp, int slnv) {
        this.mbp = mbp;
        this.nameBp = nameBp;
        this.slnv = slnv;
    }

    /* các hàm geter and seter để đọc và ghi dũ liệu*/
    public String getMbp() {
        return mbp;
    }

    public void setMbp(String mbp) {
        this.mbp = mbp;
    }

    public String getNameBp() {
        return nameBp;
    }

    public void setNameBp(String nameBp) {
        this.nameBp = nameBp;
    }

    public int getSlnv() {
        return slnv;
    }

    public void setSlnv(int slnv) {
        this.slnv = slnv;
    }

    @Override
    /* tạo ra chuỗi  bằng hằm toString*/
    public String toString() {
        return
                "  mbp: " + mbp +
                        "  nameBp: " + nameBp +
                        "  slnv: " + slnv;
    }
}
