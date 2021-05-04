package com.company;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        File directory = new File("/Users/klee5/kevin_lee_hangman1/movie.txt");

        Scanner textScanner = new Scanner(directory);
        Scanner input = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>();
        while (textScanner.hasNextLine()) {
            words.add(textScanner.nextLine());
        }

        String hidden_text = words.get((int) (Math.random()*words.size()));
        char[] textArray = hidden_text.toCharArray();

        char[] myAnswers = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            myAnswers[i] = '?';
        }

        boolean finished = false;
        int lives = 7;

        while (finished == false) {
            System.out.println("****************************************");

            String letter = input.next();

            while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                System.out.println("Error Input - Try Again");
                letter = input.next();

            }

            boolean found = false;
            for (int i = 0; i < textArray.length; i++) {
                if (letter.charAt(0) == textArray[i]) {
                    myAnswers[i] = textArray[i];
                    found = true;
                }
            }

            if (!found) {
                lives--;

                System.out.println("Wrong Letter");
            }

            boolean done = true;
            for (int i = 0; i < myAnswers.length; i++) {
                if (myAnswers[i] == '?') {
                    System.out.print(" _");
                    done = false;
                } else {
                    System.out.println(" " + myAnswers[i]);
                }
            }

            System.out.println("\n" + "Lives Left: " + lives);
            drawHangman(lives);

            if (done) {

                System.out.println("You found a movie title! You are saved!");
                finished = true;
            }

            if (lives <= 0) {
                System.out.println("Game Over! Maybe you are not a movie fan.");
                finished = true;
            }

        }

        System.out.println(hidden_text);

    }

    public static void drawHangman(int l) {
        if (l == 7) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 6) {
            System.out.println("|----------");
            System.out.println("|     |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 5) {
            System.out.println("|----------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 4) {
            System.out.println("|----------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|     |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 3) {
            System.out.println("|----------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|    -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 2) {
            System.out.println("|----------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|    -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 1) {
            System.out.println("|----------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|    -|-");
            System.out.println("|    /");
            System.out.println("|");
            System.out.println("|");
        } else {
            System.out.println("|----------");
            System.out.println("|     |");
            System.out.println("|     O");
            System.out.println("|    -|-");
            System.out.println("|    /|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}
