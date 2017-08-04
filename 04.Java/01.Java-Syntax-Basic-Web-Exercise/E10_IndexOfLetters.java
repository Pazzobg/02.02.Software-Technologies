package Java_Basics_Exercise;

import java.util.Scanner;

public class E10_IndexOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] lettersArr = new char[26];
        for (int i = 0; i < lettersArr.length; i++)
        {
            lettersArr[i] = (char)(97 + i);
        }

        String word = scanner.nextLine();

        for (int i = 0; i < word.length(); i++)
        {
            char currentChar = word.charAt(i);

            for (int j = 0; j < lettersArr.length; j++)
            {
                if (currentChar == lettersArr[j])
                {
                    System.out.println(currentChar + " -> " + j);
                }
            }
        }
    }
}
