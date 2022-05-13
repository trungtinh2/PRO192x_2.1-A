import java.util.Scanner;

public class Manager extends Staff implements ICalculator {
    private String chucDanh;

    public Manager() {
    }

    /* được override từ staff và thêm vào switch case để nhập thông tin cho trường mới*/
    public void nhap(Scanner input) {
        super.nhap(input);

        System.out.println("chọn chức danh: 1.Business Leader/ 2.Project Leader/ 3.Technical Leader ");
        int chon = Integer.parseInt(input.nextLine());
        switch (chon) {
            case 1:
                this.chucDanh = "Business Leader";
                break;
            case 2:
                this.chucDanh = "Project Leader";
                break;
            case 3:
                this.chucDanh = "Technical Leader";
                break;
        }


    }

    public Manager(String mnv, String name, int old, double hsSalary, String date, String bp, int dayOff, String chucDanh) {
        super(mnv, name, old, hsSalary, date, bp, dayOff);
        this.chucDanh = chucDanh;

    }

    public String getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    @Override
    /* được override từ staff và thêm vào doạn chuổi mới*/
    public String toString() {
        return super.toString() +
                "   chucDanh: " + chucDanh;
    }

    @Override
    /* được override từ ICalculator vaf thêm cào các câu lệnh để tính lương*/
    public double calculateSalary() {
        double luong = 0;
        if (getChucDanh().equals("Business Leader")) {
            luong = getHsSalary() * 5000000 + 8000000;
        } else if (getChucDanh().equals("Project Leader")) {
            luong = getHsSalary() * 5000000 + 5000000;
        } else if (getChucDanh().equals("Technical Leader")) {
            luong = getHsSalary() * 5000000 + 6000000;
        }
        return luong;
    }

    @Override
    /* được override từ staff và thêm vào câu lệnh print*/
    public void displayInformation() {
        System.out.println(toString());
    }


}
