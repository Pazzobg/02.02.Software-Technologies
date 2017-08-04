package Java_Basics_Exercise;

import java.util.Scanner;

public class E04_VowelOrDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char input = scanner.next().charAt(0);

        if (input == 'a' || input == 'o' || input == 'u' || input == 'e' || input == 'i') {
            System.out.println("vowel");
        } else {
            try {
                int num = Integer.parseInt(Character.toString(input));
                System.out.println("digit");
            } catch (Exception ex) {
                System.out.println("other");
            }
        }
    }
}
