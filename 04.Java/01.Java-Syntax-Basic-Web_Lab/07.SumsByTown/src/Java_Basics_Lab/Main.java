package Java_Basics_Lab;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Double> townsIncome = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String town = input[0].trim();
            double currentIncome = Double.parseDouble(input[1].trim());

            if (!townsIncome.containsKey(town)) {
                townsIncome.put(town, 0.0);
            }

            townsIncome.put(town, townsIncome.get(town) + currentIncome);
        }

        for (String key : townsIncome.keySet()) {
            System.out.println(key + " -> " + townsIncome.get(key));
        }
    }
}
