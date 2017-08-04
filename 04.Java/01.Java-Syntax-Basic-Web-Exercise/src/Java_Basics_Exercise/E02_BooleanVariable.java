package Java_Basics_Exercise;

import java.util.Scanner;

public class E02_BooleanVariable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Boolean isTrue = Boolean.valueOf(input);

        if (isTrue) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
