package Java_Basics_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E11_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean found = false;

        for (int i = 0; i < numbers.length; i++)
        {
            int sumLeft = 0;

            for (int j = i - 1; j >= 0; j--)
            {
                sumLeft += numbers[j];
            }

            int sumRight = 0;

            for (int k = i + 1; k < numbers.length; k++)
            {
                sumRight += numbers[k];
            }

            if (sumLeft == sumRight)
            {
                found = true;
                System.out.println(i);
            }
        }

        if (!found)
        {
            System.out.println("no");
        }
    }
}
