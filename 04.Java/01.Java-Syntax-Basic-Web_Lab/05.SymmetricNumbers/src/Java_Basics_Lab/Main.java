package Java_Basics_Lab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            String currentNumAsStr = "" + i;

            boolean isSymmetric = true;

            for (int j = 0; j < currentNumAsStr.length() / 2; j++) {
                if (currentNumAsStr.charAt(j) != currentNumAsStr.charAt(currentNumAsStr.length() - 1 - j)) {
                    isSymmetric = false;
                    break;
                }
            }

            if (isSymmetric) {
                System.out.printf("%d ", i);
            }
        }
    }
}
