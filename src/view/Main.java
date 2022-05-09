package view;

import controller.MultipleChoiceCreator;
import controller.ShortAnswerCreator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String myURL;
        final int myChoice;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1. Multiple Choice\n2. Short Answer");
        myChoice = Integer.parseInt(keyboard.nextLine());
        System.out.println("Please enter URL: ");
        myURL = keyboard.nextLine();
        switch(myChoice) {
            case 1:
                MultipleChoiceCreator myMPCreator = new MultipleChoiceCreator(myURL);
            case 2:
                ShortAnswerCreator mySACreator = new ShortAnswerCreator(myURL);
        }
    }
}
