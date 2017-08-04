package Java_Basics_Exercise;

import java.util.Random;
import java.util.Scanner;

public class E21_AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phrase = new String[]
                {
                        "Excellent product.",
                        "Such a great product.",
                        "I always use that product.",
                        "Best product of its category.",
                        "Exceptional product.",
                        "I can’t live without this product."
                };

        String[] events = new String[]
                {
                        "Now I feel good",
                        "I have succeeded with this product.",
                        "Makes miracles. I am happy of the results!",
                        "I cannot believe but now I feel awesome.",
                        "Try it yourself, I am very satisfied.",
                        "I feel great!"
                };

        String[] author = new String[]
                {
                        "Diana",
                        "Petya",
                        "Stella",
                        "Elena",
                        "Katya",
                        "Iva",
                        "Annie",
                        "Eva"
                };

        String[] city = new String[]
                {
                        "Sofia",
                        "Plovdiv",
                        "Varna",
                        "Burgas",
                        "Ruse"
                };

        int numberOfMessages = Integer.parseInt(scanner.nextLine());

        Random randomNum = new Random();

        for (int i = 0; i < numberOfMessages; i++)
        {
            String randomPhrase = phrase[randomNum.nextInt(phrase.length)];
            String randomEvent = events[randomNum.nextInt(events.length)];
            String randomAuthor = author[randomNum.nextInt(author.length)];
            String randomCity = city[randomNum.nextInt(city.length)];

            System.out.printf("%s %s %s – %s%n",
                    randomPhrase,
                    randomEvent,
                    randomAuthor,
                    randomCity);
        }
    }
}
