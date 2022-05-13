import java.util.Scanner;

/* tạo 1 abstract class */
public abstract class Staff {

    public Staff() {
    }


    private String mnv;
    private String name;
    private int old;
    private double hsSalary;
    private String date;
    private String bp;
    private int dayOff;


    public Staff(String mnv, String name, int old, double hsSalary, String date, String bp, int dayOff) {
        this.mnv = mnv;
        this.name = name;
        this.old = old;
        this.hsSalary = hsSalary;
        this.date = date;
        this.bp = bp;
        this.dayOff = dayOff;

    }

    /* hàm abstract displayInformation() để hiển thị*/
    public abstract void displayInformation();

    /*hàm nhap(Scanner input) để nhập thông tin cho dối tượng*/
    public void nhap(Scanner input) {
        System.out.println("mã nhân viên: ");
        this.mnv = input.nextLine();
        System.out.println("họ và tên: ");
        this.name = input.nextLine();
        System.out.println("tuổi: ");
        this.old = Integer.parseInt(input.nextLine());
        System.out.println("hệ số lương: ");
        this.hsSalary = Double.parseDouble(input.nextLine());
        System.out.println("ngày vào làm: ");
        this.date = input.nextLine();
        System.out.println("1.bảo vệ / 2.iT / 3. bán hàng");

        switch (Integer.parseInt(input.nextLine())) {
            case 1:
                this.bp = "bao ve";
                break;
            case 2:
                this.bp = "IT";
                break;
            case 3:
                this.bp = "ban hang";
                break;
        }
        System.out.println("số ngày nghỉ phép: ");
        this.dayOff = Integer.parseInt(input.nextLine());
    }

    @Override
    /* tạo ra chuỗi từ các trường thuộc tính của đối tượng bằng hàm toString*/
    public String toString() {
        return
                "mnv: " + mnv +
                        "   name: " + name +
                        "   old: " + old +
                        "   salary: " + hsSalary +
                        "   date: " + date +
                        "   bp: " + bp +
                        "   dayOff: " + dayOff;
    }

    /* các hàm geter and seter để đọc và ghi dũ liệu*/
    public String getMnv() {
        return mnv;
    }

    public void setMnv(String mnv) {
        this.mnv = mnv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public double getHsSalary() {
        return hsSalary;
    }

    public void setHsSalary(double hsSalary) {
        this.hsSalary = hsSalary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }


}
