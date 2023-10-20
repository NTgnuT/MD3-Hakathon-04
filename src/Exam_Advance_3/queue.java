package Exam_Advance_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class queue {
    static Scanner scanner = new Scanner(System.in);

    static Queue<String> stringQueue = new LinkedList<>();
    public static void main(String[] args) {

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập tên phụ huynh nộp hồ sơ\n" +
                    "2. Phụ huynh tiếp theo\n" +
                    "3. Thoát");
            System.out.println("*************************************");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            handleChoice(choice);
        }
    }

    public static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Nhập tên phụ huynh nộp hồ sơ");
                String string = scanner.nextLine();
                stringQueue.add(string);
                break;
            case 2:
                if (!stringQueue.isEmpty()) {
                    System.out.println("Phụ huynh đầu tiên trong danh sách là: " + stringQueue.poll());
                } else {
                    System.out.println("Danh sách trống!!!");
                }
                break;
            case 3:
//                System.out.println(stringQueue);
                System.exit(1);
            default:
                System.out.println("Không có lựa chọn này!!!");
        }
    }
}
