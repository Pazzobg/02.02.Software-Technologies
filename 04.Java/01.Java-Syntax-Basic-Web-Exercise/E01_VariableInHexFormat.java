package Java_Basics_Exercise;

import java.util.Scanner;

public class E01_VariableInHexFormat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String hex = scanner.nextLine();

        int n = (int) Long.parseLong(hex, 16);

        System.out.println(n);
    }
}
