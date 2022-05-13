import java.util.Scanner;

public class Employee extends Staff implements ICalculator {

    private int hour;


    public Employee() {

    }

    /* được override từ staff và  nhập thông tin cho trường mới*/
    public void nhap(Scanner input) {
        super.nhap(input);
        System.out.println("số giờ làm thêm: ");
        this.hour = Integer.parseInt(input.nextLine());
    }

    public Employee(String mnv, String name, int old, double hsSalary, String date, String bp, int dayOff, int hour) {
        super(mnv, name, old, hsSalary, date, bp, dayOff);
        this.hour = hour;


    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    /* được override từ staff và thêm vào doạn chuổi mới*/
    public String toString() {
        return super.toString() +
                "   hour: " + hour;
    }

    @Override
    /* được override từ staff và thêm vào câu lệnh print*/
    public void displayInformation() {
        System.out.println(toString());
    }

    @Override
    /* được override từ ICalculator vaf thêm cào các câu lệnh để tính lương*/
    public double calculateSalary() {
        double luong = getHsSalary() * 3000000 + getHour() * 200000;
        return luong;
    }


}
