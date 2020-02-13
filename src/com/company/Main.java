package com.company;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Random rand = new Random();
        boolean answer;
        String anotherString;
        do {
            System.out.println("What is your name?");
            String name = scan.next();
            System.out.println("Hello," + name);
            int myNum = rand.nextInt(100) + 1;
            System.out.println("Cheat: " + myNum);
            for (int i = 0; i < 10; i++) {
                int userNum = askGuess();
                if (myNum == userNum) {
                    System.out.println("You win");
                    break;
                }
                if (i == 9) {
                    System.out.println("Game over!! You loose!! My number was " + myNum);
                    break;
                }
                if (myNum < userNum) {
                    System.out.println("Go lower");
                }
                if (myNum > userNum) {
                    System.out.println("Go higher");
                }
            }
        } while (askAnotherGame());
        System.out.println("Goodbye");
    }
    static boolean askAnotherGame() {
        for (; ; ) {
            System.out.println("do you want to play again?");
            String answer = scan.next();
            if (answer.equalsIgnoreCase("yes")) {
                return true;
            } else if (answer.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("you have to answer yes or no");
            }
        }
    }
    static int askGuess() {
        for (; ; ) {
            try {
                System.out.println("Enter your number");
                int num = scan.nextInt();
                if (num <= 1 || num >= 100) {
                    System.out.println("Please enter number from 1 to 100 ");
                } else {
                    return num;
                }
            } catch (InputMismatchException e) {
                String str = scan.next();
                System.out.println(str + " is not a number!!!");
            }
        }
    }
}