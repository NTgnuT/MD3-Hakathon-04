package Exam_Advance_2;

import java.util.*;

public class stack {
    static Scanner scanner = new Scanner(System.in);

    static Stack<String> stack = new Stack<>();

    static String string;
    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************");
            System.out.println("1. Nhập câu\n" +
                    "2. Đảo ngược câu\n" +
                    "3. Thoát");
            System.out.println("***************************");
            System.out.println("Nhập lựa chọn của bạn (1-3)");
            int choice = Integer.parseInt(scanner.nextLine());
            handleChoice(choice);
        }
    }

    public static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Nhập câu bạn muốn đảo ngược: ");
                string = scanner.nextLine();
                break;
            case 2:
                stack.addAll(Arrays.asList(string.trim().split(" ")));
                for (int i = stack.size() - 1; i >= 0; i--) {
                    System.out.print(stack.get(i) + " ");
                }
                System.out.println("\n");
                break;
            case 3:
               System.exit(1);
            default:
                System.out.println("Không có lựa chọn này!!!");
                break;
        }
    }
}
