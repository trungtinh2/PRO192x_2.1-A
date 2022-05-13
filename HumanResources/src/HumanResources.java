import java.util.*;

public class HumanResources {
    public static void main(String[] args) {
        ArrayList<Staff> nhanVien = new ArrayList<>();//tạo mảng động
        Department baoVe = new Department("BPBV", "bao ve", 0);
        Department iT = new Department("BPIT", "IT", 0);
        Department banHang = new Department("BPBH", "ban hang", 0);
        Scanner input = new Scanner(System.in);
        // vòng lặp do while  tạo menu chon chức năng
        do {
            System.out.println("phím 1 để hiển thị danh sách nhân viên hiện có trong công ty");
            System.out.println("phím 2 để hiển thị các bộ phận trong công ty");
            System.out.println("phím 3 để hiển thị các nhân viên theo từng bộ phận");
            System.out.println("phím 4 để thêm nhân viên mới vào công ty");
            System.out.println("phím 5 để tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
            System.out.println("phím 6 để hiển thị bảng lương của nhân viên toàn công ty");
            System.out.println("phím 7 để hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
            System.out.println("phím 8 để hiển thị bảng lương của nhân viên theo thứ tự giảm dần");
            System.out.println("phím 0 để thoát");
            int luaChon = Integer.parseInt(input.nextLine());

            if (luaChon == 0) {
                break;
            }
            //switch case để tạo ra các lựa chọn
            switch (luaChon) {
                case 1: //hiển thị danh sách nhân viên hiện có trong công ty
                    System.out.println("danh sách nhân viên:");
                    for (Staff item : nhanVien) {
                        item.displayInformation();
                    }

                    System.out.println("------------------------");
                    break;
                case 2: //hiển thị các bộ phận trong công ty
                    System.out.println("danh sách bộ phận:");
                    System.out.println(baoVe.toString());
                    System.out.println(iT.toString());
                    System.out.println(banHang.toString());
                    System.out.println("------------------------");
                    break;
                case 3: //hiển thị các nhân viên theo từng bộ phận
                    System.out.println("danh sách sau khi sắp xếp");
                    System.out.println("bộ phân bảo vệ");
                    for (Staff item : nhanVien) {
                        if (item.getBp().equals(baoVe.getNameBp())) {
                            item.displayInformation();
                        }
                    }
                    System.out.println("bộ phận IT");
                    for (Staff item : nhanVien) {
                        if (item.getBp().equals(iT.getNameBp())) {
                            item.displayInformation();
                        }
                    }
                    System.out.println("bộ phận bán hàng");
                    for (Staff item : nhanVien) {
                        if (item.getBp().equals(banHang.getNameBp())) {
                            item.displayInformation();
                        }
                    }
                    System.out.println("------------------------");
                    break;
                case 4: //để thêm nhân viên mới vào công ty
                    System.out.println("phím 1 để thêm nhân viên thông thường");
                    System.out.println("phím 2 để thêm nhân viên là cấp quản lý (có thêm chức vụ)");
                    int chon = Integer.parseInt(input.nextLine());
                    switch (chon) {
                        case 1: //thêm nhân viên thông thường
                            Employee nhanVienTT = new Employee(); // tạo ra dối tượng nhân viên thông thường
                            nhanVienTT.nhap(input); // gọi hàm nhap(input) với tham số đầu vào để nhập thông tin cho đối tượng nhân viên thông thường
                            nhanVien.add(nhanVienTT); // add vào mảng

                            //cập nhật số lượng nhân viên của từng bộ phận
                            if (nhanVienTT.getBp().equals(baoVe.getNameBp())) {
                                baoVe.setSlnv(baoVe.getSlnv() + 1);
                            } else if (nhanVienTT.getBp().equals(iT.getNameBp())) {
                                iT.setSlnv(iT.getSlnv() + 1);
                            } else if (nhanVienTT.getBp().equals(banHang.getNameBp())) {
                                banHang.setSlnv(banHang.getSlnv() + 1);
                            }
                            break;
                        case 2://thêm nhân viên là cấp quản lý (có thêm chức vụ)
                            Manager qLy = new Manager(); //tạo ra đối tượng quản lý
                            qLy.nhap(input); //gọi hàm nhap(input) với tham số đầu vào để nhập thông tin cho đối tượng quản lý
                            nhanVien.add(qLy); // add vào mảng

                            //cập nhật số lượng nhân viên của từng bộ phận
                            if (qLy.getBp().equals(baoVe.getNameBp())) {
                                baoVe.setSlnv(baoVe.getSlnv() + 1);
                            } else if (qLy.getBp().equals(iT.getNameBp())) {
                                iT.setSlnv(iT.getSlnv() + 1);
                            } else if (qLy.getBp().equals(banHang.getNameBp())) {
                                banHang.setSlnv(banHang.getSlnv() + 1);
                            }
                            break;
                    }
                    System.out.println("------------------------");
                    break;
                case 5: //tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên
                    System.out.print("nhập tên or mnv: ");
                    String keyword = input.nextLine();
                    System.out.println("danh sách tìm kiếm:");
                    // for each để lặp qua mảng để so sánh giữa keyword và tên hoặc mã nhân viên rồi gọi hàm displayInformation để hiển thị
                    for (Staff item : nhanVien) {
                        if (keyword.equals(item.getName()) || keyword.equals(item.getMnv())) {
                            item.displayInformation();
                        }
                    }

                    System.out.println("------------------------");

                    break;
                case 6: //Hiển thị bảng lương của nhân viên toàn công ty
                    System.out.println("danh sách lương nhân viên");
                    // vòng lặp for each lặp qua mảng và gọi hàm calculateSalary() để tính lương
                    for (Staff item : nhanVien) {
                        System.out.println(item.toString() + "   luong: " + ((ICalculator) item).calculateSalary());
                    }
                    System.out.println("------------------------");
                    break;
                case 7: //Hiển thị bảng lương của nhân viên theo thứ tự tăng dần
                    System.out.println("danh sách sau khi sắp xếp");
                    //collections.sort để sắp xếp lại các đối tượng trong mảng
                    Collections.sort(nhanVien, (a, b) -> (int) (((ICalculator) a).calculateSalary() - ((ICalculator) b).calculateSalary()));
                    for (Staff item : nhanVien) {
                        System.out.println(item.toString() + "   luong: " + ((ICalculator) item).calculateSalary());
                    }
                    System.out.println("------------------------");
                    break;
                case 8: //Hiển thị bảng lương của nhân viên theo thứ tự giảm dần
                    System.out.println("danh sách sau khi sắp xếp");
                    //collections.sort để sắp xếp lại các đối tượng trong mảng
                    Collections.sort(nhanVien, (a, b) -> (int) (((ICalculator) b).calculateSalary() - ((ICalculator) a).calculateSalary()));
                    for (Staff item : nhanVien) {
                        System.out.println(item.toString() + "   luong: " + ((ICalculator) item).calculateSalary());
                    }
                    System.out.println("------------------------");
                    break;
            }
        } while (true);


    }
}
