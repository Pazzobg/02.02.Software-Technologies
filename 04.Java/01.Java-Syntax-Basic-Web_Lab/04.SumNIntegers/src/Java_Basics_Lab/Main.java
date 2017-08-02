package Java_Basics_Lab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int currentNum = scanner.nextInt();

            sum += currentNum;
        }

        System.out.printf("Sum = %d", sum);
    }
}
