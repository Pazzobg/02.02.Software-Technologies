package Java_Basics_Exercise;

import java.util.Scanner;

public class E14_FitStringIn20Chars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.length() < 20) {
            StringBuilder sb = new StringBuilder(input);
            int asterisksCount = 20 - input.length();

            for (int i = 0; i < asterisksCount; i++) {
                sb.append("*");
            }

            System.out.println(sb);
        } else {
            System.out.println(input.substring(0, 20));
        }
    }
}
