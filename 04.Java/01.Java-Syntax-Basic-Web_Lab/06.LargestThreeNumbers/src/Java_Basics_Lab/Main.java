package Java_Basics_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numStrings = scanner.nextLine().split("\\s");

        int[] numbers = new int[numStrings.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numStrings[i]);
        }

        Arrays.sort(numbers);

        int count = Math.min(numbers.length, 3);

        for (int i = 0; i < count; i++) {
            System.out.println(numbers[numbers.length - 1 - i] + " ");
        }
    }
}
