package Java_Basics_Lab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        /*if (num1 == num2 + num3) {
            System.out.printf("%d + %d = %d", Math.min(num2, num3), Math.max(num2, num3), num1);
        } else if (num2 == num1 + num3) {
            System.out.printf("%d + %d = %d", Math.min(num1, num3), Math.max(num1, num3), num2);
        } else if (num3 == num1 + num2) {
            System.out.printf("%d + %d = %d", Math.min(num1, num2), Math.max(num1, num2), num3);
        } else {
            System.out.println("No");
        }*/

        if (!checkForSum(num1, num2, num3) && !checkForSum(num2, num3, num1) && !checkForSum(num3, num1, num2)) {
            System.out.println("No");
        }
    }

    public static boolean checkForSum (int first, int second, int sum) {
        if (first + second == sum) {
            if (first > second) {
                int temp = first;
                first = second;
                second = temp;
            }

            System.out.printf("%d + %d = %d", first, second, sum);
            return true;
        }

        return false;
    }
}
