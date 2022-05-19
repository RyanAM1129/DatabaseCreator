package view;

import controller.MultipleChoiceCreator;
import controller.ShortAnswerCreator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean keepGoing = true;
        final String myURL;
        int myChoice;
        Scanner keyboard = new Scanner(System.in);
        while (keepGoing) {
            Boolean myAddRow = true;
            System.out.println("1. Multiple Choice\n2. Short Answer\n3. Exit");
            myChoice = Integer.parseInt(keyboard.nextLine());
            switch(myChoice) {
                case 1:
                    MultipleChoiceCreator myMPCreator = new MultipleChoiceCreator();
                    do {
                        System.out.println("Would you like to add a row?");
                        System.out.println("1.Yes\n2.No");
                        myChoice = Integer.parseInt(keyboard.nextLine());
                        switch (myChoice) {
                            case 1:
                                System.out.println("Enter Question Text: ");
                                String myQuestion = keyboard.nextLine().strip();
                                System.out.println("Enter Answer Text: ");
                                String myAnswer = keyboard.nextLine().strip();
                                System.out.println("Enter Wrong1 Text: ");
                                String myWrong1 = keyboard.nextLine().strip();
                                System.out.println("Enter Wrong2 Text: ");
                                String myWrong2 = keyboard.nextLine().strip();
                                System.out.println("Enter Wrong3 Text: ");
                                String myWrong3 = keyboard.nextLine().strip();
                                myMPCreator.addRow(myQuestion, myAnswer,
                                        myWrong1, myWrong2, myWrong3);
                                break;
                            case 2:
                                myAddRow = false;
                        }
                    } while (myAddRow);
                    break;
                case 2:
                    ShortAnswerCreator mySACreator = new ShortAnswerCreator();
                    do {
                        System.out.println("Would you like to add a row?");
                        System.out.println("1.Yes\n2.No");
                        myChoice = Integer.parseInt(keyboard.nextLine());
                        switch (myChoice) {
                            case 1:
                                System.out.println("Enter Question Text: ");
                                String myQuestion = keyboard.nextLine().strip();
                                System.out.println("Enter Answer Text: ");
                                String myAnswer = keyboard.nextLine().strip();
                                mySACreator.addRow(myQuestion, myAnswer);
                                break;
                            case 2:
                                myAddRow = false;
                        }
                    } while (myAddRow);
                    break;
                case 3:
                    keepGoing = false;
            }
        }
    }
}
