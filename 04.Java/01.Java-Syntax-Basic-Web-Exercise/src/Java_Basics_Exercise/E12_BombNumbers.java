package Java_Basics_Exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class E12_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        ArrayList<Integer> numbers = new ArrayList<>();

        for (String num : input) {
            numbers.add(Integer.parseInt(num));
        }

        String[] line = scanner.nextLine().split(" ");

        int bomb = Integer.parseInt(line[0]);
        int power = Integer.parseInt(line[1]);

        for (int j = 0; j < numbers.size(); j++) {
            if (numbers.get(j) == bomb) {
                int indexOfBomb = numbers.indexOf(bomb);

                int start = Math.max(0, indexOfBomb - power);
                int loopEnd = Math.min(
                        Math.min((power * 2) + 1, numbers.size() - start),
                        (indexOfBomb + power + 1));

                for (int i = 0; i < loopEnd; i++) {
                    numbers.remove(start);
                }

                j = -1;
            }
        }

        int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        System.out.println(sum);
    }
}
