import java.util.Scanner;
class LuckyNumber {
    static Scanner sc = new Scanner(System.in);
    static int totalGames = 0;
    static int totalGuess = 0;
    static int bestGame = 100;
    public static void main(String[] args) {
        System.out.println("tôi đang nghĩ một số trong khoảng 0 đến 100...");

        play(Number());
    }

    //tạo số ngẫu nhiên
    public static int Number() {
        int randomNumber = (int) ((Math.random() * 100) + 1);
        return randomNumber;
    }
    //tạo hàm play() để thực hiện trò chơi
    public static void play(int num) {
        int a = 0;
        int i = 0;
        totalGames++;
        //vòng lặp đến khi doán đúng thì thoát ra
        do {
            System.out.print("bạn đoán?");
            a = sc.nextInt();
            i++;
            //so sánh kết quả dự doán và số ngãu nhiên
            if (a < num) {
                System.out.println("số may mắn lớn hơn số bạn đoán");

            } else if (a > num) {
                System.out.println("số may mắn nhỏ hơn số bạn đoán");

            } else {
                System.out.println("chúc mừng bạn đoán đúng số may mắn sau " + i + " lần dự đoán");
            }
        }
        while (a != num);
        if (i<bestGame){
            bestGame = i;
        }
        totalGuess = totalGuess + i;
        nex();
    }
    //tạo hàm xử lí lụa chọn chơi tiếp hay không
    public static void nex() {
        System.out.print("bạn có muốn tiếp tục chơi không?");
        String yesOrNo = sc.next();
        yesOrNo = yesOrNo.toLowerCase();// đưa chuỗi về kiểu viết thường
        if (yesOrNo.equals("yes") || yesOrNo.equals("y")) {
            System.out.println("---------------------***********************---------------------");
            System.out.println("tôi đang nghĩ một số trong khoảng 0 đến 100...");
            play(Number());
        } else if (yesOrNo.equals("no") || yesOrNo.equals("n")) {
            report();
        } else {
            nex();
        }
    }
    //đưa ra các thông báo sau khi kết thúc trò chơi
    public static void report() {
        System.out.println("---------------------***********************---------------------");
        System.out.println("kết quả tổng quát trò chơi:");
        System.out.println("tổng số lượt chơi = " + totalGames);
        System.out.println("tổng số lượt dự đoán = " + totalGuess);
        double guessAvg =  (totalGuess / totalGames);
        System.out.println("số lượt dự đoán trung bình mỗi lượt = " + guessAvg);
        System.out.println("số lượt dự đoán ít nhất = " + bestGame);
        System.out.println("---------------------***********************---------------------");

    }
}
