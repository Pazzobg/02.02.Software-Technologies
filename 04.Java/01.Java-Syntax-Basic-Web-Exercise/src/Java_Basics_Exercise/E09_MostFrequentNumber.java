package Java_Basics_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E09_MostFrequentNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxFrequencyCount = 0;
        int mostFrequentNumber = 0;

        for (int i = 0; i < numbers.length; i++)
        {
            int currentFrequencyCount = 0;

            for (int j = 0; j < numbers.length; j++)
            {
                if (numbers[i] == numbers[j])
                {
                    currentFrequencyCount++;
                }
            }

            if (currentFrequencyCount > maxFrequencyCount)
            {
                maxFrequencyCount = currentFrequencyCount;
                mostFrequentNumber = numbers[i];
            }
        }

        System.out.println(mostFrequentNumber);
    }
}
