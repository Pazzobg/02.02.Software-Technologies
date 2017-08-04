package Java_Basics_Exercise;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.Scanner;

public class E06_CompareCharArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLineLetters = scanner.nextLine().split("\\s");
        String[] secondLineLetters = scanner.nextLine().split("\\s");

        char[] firstCharArray = new char[firstLineLetters.length];
        char[] secondCharArray = new char[secondLineLetters.length];

        for (int i = 0; i < firstCharArray.length; i++) {
            firstCharArray[i] = firstLineLetters[i].charAt(0);
        }

        for (int i = 0; i < secondLineLetters.length; i++) {
            secondCharArray[i] = secondLineLetters[i].charAt(0);
        }

        boolean equal = true;
        String printWinner = "";
        int shorterArrLength = Math.min(firstCharArray.length, secondCharArray.length);

        for (int i = 0; i < shorterArrLength; i++) {
            if (firstCharArray[i] != secondCharArray[i]) {
                printWinner = firstCharArray[i] < secondCharArray[i] ? "first" : "second";

                equal = false;
                break;
            }
        }

        String firstStr = new String(firstCharArray);
        String secondStr = new String(secondCharArray);

        if (!equal) {
            if (printWinner.equals("first")) {
                System.out.println(firstStr);
                System.out.println(secondStr);
            } else {
                System.out.println(secondStr);
                System.out.println(firstStr);
            }
        } else {
            if (firstCharArray.length < secondCharArray.length) {
                System.out.println(firstStr);
                System.out.println(secondStr);
            } else {
                System.out.println(secondStr);
                System.out.println(firstStr);
            }
        }
    }
}
