package Java_Basics_Exercise;

import java.util.Scanner;

public class E05_IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        String hex = Integer.toHexString(num).toUpperCase();
        String binary = Integer.toBinaryString(num);

        System.out.println(hex + System.lineSeparator() + binary);
    }
}
