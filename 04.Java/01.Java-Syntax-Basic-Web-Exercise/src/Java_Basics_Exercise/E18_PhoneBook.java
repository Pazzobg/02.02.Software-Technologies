package Java_Basics_Exercise;

import java.util.*;

public class E18_PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, String> phonebook = new TreeMap<>();

        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("END")) {
            String command = input[0];

            switch (command) {
                case "A":
                    AddNumberToPhonebook(input, phonebook);
                    break;
                case "S":
                    SearchNumberInPhonebook(input, phonebook);
                    break;
            }

            input = scanner.nextLine().split(" ");
        }
    }

    public static void AddNumberToPhonebook(String[] input, TreeMap<String, String> phonebook) {
        String name = input[1];
        String number = input[2];

        /*if (!phonebook.containsKey(name))
        {
            phonebook.get(name).pu = "";
        }*/

        phonebook.put(name, number);
    }

    public static void SearchNumberInPhonebook(String[] input, TreeMap<String, String> phonebook) {
        String name = input[1];


        if (phonebook.containsKey(name)) {
            System.out.println(name + " -> " + phonebook.get(name));
        } else {
            System.out.printf("Contact %s does not exist.%n", name);
        }
    }
}

