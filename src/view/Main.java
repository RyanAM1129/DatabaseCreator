package view;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String myURL;
        try(Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Enter database URL: ");
            myURL = keyboard.nextLine();

        }
    }
}
