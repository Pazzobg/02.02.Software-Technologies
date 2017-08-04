package Java_Basics_Exercise;

import java.util.Scanner;

public class E16_URLParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String protocol = "";
        String server = "";
        String resource = "";

        int delimiter = input.indexOf("://");

        if (delimiter > -1) {
            String[] tokens = input.split("://");

            protocol = tokens[0];
            String serverAndResource = tokens[1];

            int serverDelimiter = serverAndResource.indexOf("/");

            if (serverDelimiter > -1) {
                server = serverAndResource.substring(0, serverDelimiter);
                resource = serverAndResource.substring(serverDelimiter + 1);
            } else {
                server = serverAndResource;
            }
        } else {
            int serverDelimiter = input.indexOf("/");

            String[] inputSplit = new String[2];

            if (serverDelimiter > -1) {
                inputSplit = input.split("/");
                server = inputSplit[0];
                resource = inputSplit[1];
            } else {
                server = input;
            }
        }

        String newLine = System.getProperty("line.separator");

        System.out.printf("[protocol] = \"%s\"%s", protocol.trim(), newLine);
        System.out.printf("[server] = \"%s\"%s", server.trim(), newLine);
        System.out.printf("[resource] = \"%s\"%s", resource.trim(), newLine);
    }
}
