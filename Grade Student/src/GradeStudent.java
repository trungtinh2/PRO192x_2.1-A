
import java.util.Scanner;

public class GradeStudent {
    //biến toàn cục
    static Scanner input = new Scanner(System.in);
    static int weight1;
    static int weight2;
    static double mid;
    static double fina;
    static double home;

    /* gọi lần lượt các hàm */
    public static void main(String[] args) {
        begin();
        mid = midTerm();
        fina = finalTerm();
        home = homeWork();
        report();
    }

    public static void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
        System.out.println("-------------*****************-------------");
    }

    /* tạo hàm midTerm() có giá trị trả về là midtermScore */
    public static double midTerm() {
        System.out.println("Midterm:");
        // vòng lặp do while lặp khi weight weight1 <0 || weight1 > 100
        do {
            System.out.print("Weight (0-100)?");
            weight1 = input.nextInt();
        } while (weight1 < 0 || weight1 > 100);
        // midtermScore được gán bằng giá trị trả về của hàm Data với tham số đầu và là  weight1
        double midTermScore = data(weight1);
        return midTermScore;
    }

    /* tạo hàm finalTerm() có giá trị trả về là finalScore */
    public static double finalTerm() {
        System.out.println("Final:");
        // vòng lặp do while lặp khi weight weight2 <0 || weight2 > 100
        do {
            System.out.print("Weight (0-100)?");
            weight2 = input.nextInt();
        } while (weight2 < 0 || weight2 > 100);
        // finalScore được gán bằng giá trị trả về của hàm Data với tham số đầu và là  weight2
        double finalScore = data(weight2);
        return finalScore;
    }

    /*tạo hàm homework() có giá trị trả về là weightScore */
    public static double homeWork() {
        int weight;
        int numAsm;
        double point;
        int num = 0;
        int num1 = 0;
        int max = 0;
        int score = 0;

        System.out.println("Homework:");
        // vòng lặp do while lặp khi weight != 100 - (weight1+weight2) và thông báo lỗi
        do {
            System.out.print("Weight (0-100)?");
            weight = input.nextInt();
            if (weight != 100 - (weight1 + weight2)) {
                System.out.println("err: vui lòng nhập đúng");
            }
        } while (weight != 100 - (weight1 + weight2));

        System.out.print("Number of assignments?");
        numAsm = input.nextInt();
        // vong lặp for tạo ra các số Assignment
        for (int i = 1; i < (numAsm + 1); i++) {
            // vòng lặp do while lặp khi num < 0 || num > num1 để kiểm tra giá trị nhập vào và thông báo khi có lỗi
            do {
                System.out.print("Assignment " + i + " score and max?");
                num = input.nextInt();
                num1 = input.nextInt();
                if (num < 0 || num > num1) {
                    System.out.println("err: vui lòng nhập đúng");
                }
            } while (num < 0 || num > num1);
            score = score + num;
            max = max + num1;
        }
        if (score > 150) {
            score = 150;
            max = 150;
        }
        point = score;
        System.out.print("How many sections did you attend?");
        int attend = input.nextInt();
        int sectionPoints = attend * 5;
        if (sectionPoints > 30) {
            sectionPoints = 30;
        }
        double weightScore = Math.round(((point + sectionPoints) / (max + 30) * weight)*10)/10.0;
        System.out.println("sectionPoints =" + sectionPoints + "/" +  30);
        System.out.println("Total points = " + (score + sectionPoints) + "/" + (max + 30));
        System.out.println("weightScore = " + weightScore + "/" + weight);
        return weightScore;
    }

    /*tạo hàm report để xư lí tính toán và đưa ra các thông số nhận xét tương ứng*/
    public static void report() {
        double grade;
        double gpa = 0;
        grade = Math.round((mid + fina + home)*10)/10.0;
        System.out.println("-------------*****************-------------");
        System.out.println("Overall percentage: " + grade);
        if (grade >= 85.0) {
            gpa = 3.0;
        } else if (grade >= 75.0) {
            gpa = 2.0;
        } else if (grade >= 60.0) {
            gpa = 1.0;
        } else {
            gpa = 0.0;
        }
        System.out.println("your grade will be at least:" + gpa);
        // điều kiện để in ra nhận xét tương ứng
        if (gpa == 3.0) {
            System.out.println("đạt loại giỏi");
        } else if (gpa == 2.0) {
            System.out.println("đạt loại khá");
        } else if (gpa == 1.0) {
            System.out.println("đạt loại trung bình, cần cố gắng");
        } else {
            System.out.println("đạt loại yếu, cố gắng nhiều hơn vào lần tới. Chúc bạn may mắn lần sau");
        }
    }

    /* Vì hàm miterm và final giống nhau về phần nhập và xử lí dữ liệu nên tạo hàm hàm data
     xử lí phần dữ liệu nhập vào và tính toán cho hàm miterm và final với tham số đầu vào là weight
      được truyền vào khi gọi hàm data lên*/
    public static double data(int weight) {
        int shiftScore = 0;
        int scoreEarned;
        int wereScoresShifted;
        int totalPoints;
        double point;
        double weightedScore;
        // vòng lặp do while đảm bảo giá trị nhập vào nàm trong khoảng 0- 100
        do {
            System.out.print("Score earned?");
            scoreEarned = input.nextInt();
        } while (scoreEarned < 0 || scoreEarned > 100);
        System.out.print("Were scores shifted (1 = yes, 2=no)?");
        wereScoresShifted = input.nextInt();
        // xác định lựa chọn cộng điểm hay không

        if (wereScoresShifted == 1) {
            System.out.print("Shift amount:?");
            shiftScore = input.nextInt();
        }
        // tính điểm sau khi được cộng
        totalPoints = shiftScore + scoreEarned;

        // đảm bảo điểm tối đa là 100
        if (totalPoints > 100) {
            totalPoints = 100;
        }
        point = totalPoints;
        System.out.println("totalPoints = " + totalPoints + "/" +100);
        weightedScore = Math.round(((point / 100) * weight)*10)/10.0;
        System.out.println("weightedScore = " + weightedScore + "/" + weight);

        System.out.println("-------------*****************-------------");
        return weightedScore;
    }

}
