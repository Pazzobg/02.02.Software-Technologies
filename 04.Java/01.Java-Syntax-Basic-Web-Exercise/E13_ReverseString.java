package Java_Basics_Exercise;

import java.util.Scanner;

public class E13_ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String result = new StringBuffer(input).reverse().toString();

        System.out.println(result);
    }
}
