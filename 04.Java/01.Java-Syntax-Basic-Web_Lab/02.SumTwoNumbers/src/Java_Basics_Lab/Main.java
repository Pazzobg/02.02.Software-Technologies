package Java_Basics_Lab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = Double.parseDouble(scanner.nextLine());
        double secondNum = Double.parseDouble(scanner.nextLine());

        double result = firstNum + secondNum;

        System.out.printf("Sum = %.2f", result);
    }
}
