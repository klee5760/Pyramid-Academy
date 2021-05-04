package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final Random RANDOM = new Random();
    public static final int MAX_NUMBER = 20;


    public static void main(String[] args) {
        // write your code here


        boolean play = true;
        int numberToFind = RANDOM.nextInt(MAX_NUMBER) + 1;
        Scanner in = new Scanner(System.in);
        Scanner userInput = new Scanner(System.in);
        int numberTries = 6, userGuess = 0;

        while(userGuess !=numberToFind && numberTries >0) {
            System.out.println("Guess the number between 1 and " + MAX_NUMBER + " : ");
            userGuess = userInput.nextInt();
            numberTries--;

            if (userGuess < 1 || userGuess > MAX_NUMBER) {
                System.out.println("Make sure the number you enter is between 1 and 20");
            } else if (userGuess > numberToFind) {
                System.out.println("The number is lower than your guess.");
            } else if (userGuess < numberToFind) {
                System.out.println("The number is higher than your guess.");
            }

            if (numberTries <= 0) {
                System.out.println("You Lose! The number is: " + numberToFind + "\n" +
                        "\n" +
                        "Would you like to play again?(Y or N)\n");
                String input = in.nextLine();
                if (input.equals("N")) {
                    play = false;
                } else if (input.equals("Y")) {
                    numberTries = 6;
                    numberToFind = RANDOM.nextInt(MAX_NUMBER) + 1;
                }
            }

            if (userGuess == numberToFind) {
                System.out.println("You Win!\n" +
                        "\n" +
                        "Would you like to play again?(Y or N)\n");
                String input = in.nextLine();
                if (input.equals("N")) {
                    play = false;
                } else if (input.equals("Y")) {
                    numberTries = 6;
                    numberToFind = RANDOM.nextInt(MAX_NUMBER) + 1;
                }
            }
        }
    }
}
