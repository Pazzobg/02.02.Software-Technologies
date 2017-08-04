package Java_Basics_Exercise;

import java.util.Scanner;

public class E07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");
        int[] numbers = new int[line.length];
        for (int i = 0; i < line.length; i++)
        {
            numbers[i] = Integer.parseInt(line[i]);
        }

        int countCurrentSequence = 1;
        int longestSequence = 1;
        int valueLongestSequence = 0;

        for (int i = 0; i < numbers.length - 1; i++)
        {
            if (numbers[i + 1] == numbers[i])
            {
                countCurrentSequence++;

                if (countCurrentSequence > longestSequence)
                {
                    longestSequence = countCurrentSequence;
                    valueLongestSequence = numbers[i];
                }
            }

            if (numbers[i + 1] != numbers[i])
            {
                countCurrentSequence = 1;
            }
        }

        for (int i = 0; i < longestSequence; i++)
        {
            System.out.print(valueLongestSequence + " ");
        }

        System.out.println();
    }
}
