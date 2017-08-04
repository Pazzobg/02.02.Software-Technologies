package Java_Basics_Exercise;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E15_CensorEmailAdress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();
        String text = scanner.nextLine();

        String[] emailSplit = email.split("@");
        String username = emailSplit[0];
        String domain = emailSplit[1];

        username = username.replaceAll(".", "*");
        String censoredEmail = username + "@" + domain;

        text = text.replaceAll(email, censoredEmail);

        System.out.println(text);
    }
}
