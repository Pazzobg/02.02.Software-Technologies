package Java_Basics_Exercise;

import java.util.Scanner;

public class E17_ChangeToUppercase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder(text);

        int openTagIndex = sb.indexOf("<upcase>");

        while (openTagIndex > -1) {

            int closeTagIndex = sb.indexOf("</upcase>");

            String fragment = sb.substring(openTagIndex + 8, closeTagIndex);
            String fragmentToUpper = fragment.toUpperCase();

            sb.replace(openTagIndex, closeTagIndex + 9, fragmentToUpper);

            openTagIndex = sb.indexOf("<upcase>");
        }

        System.out.println(sb);
    }
}
