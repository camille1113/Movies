package cs126.demos.jsonapi.starwars;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        readEvaluatePrintLoop(scanner);
    }
    /** A simple, interactive REPL. */

    public static void readEvaluatePrintLoop(Scanner scanner) {
        StarWarsSource source = new StarWarsSource();

        printHelp();

        while (true) {
            String requestLine = scanner.nextLine();
            if (requestLine.equals("quit")) {
                break;
            }

            int spacePosition = requestLine.indexOf(' ');

            if (spacePosition < 0) {
                printHelp();
                continue;
            }

            String type = requestLine.substring(0,spacePosition).toLowerCase();
            int index = Integer.parseInt( requestLine.substring(spacePosition+1).trim());

            if (type.equals("film")) {

                Film film = source.getFilm(index);
                System.out.println(film.toString());

            } else if (type.equals("person")) {

                Person person = source.getPerson(index);

                System.out.println(person.toString());

            } else {
                printHelp();
            }
        }
    }
    /* Prints a useful help message */
    private static void printHelp() {

        System.out.println("\nExample use:\nfilm 1  - prints information about the first film\nperson 1  - prints information about the first character\nquit  - quits the program\n");
    }


}
