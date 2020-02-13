package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<GameResult> leaders = new ArrayList<>();
        boolean answer;
        String anotherString;
        do {
            System.out.println("What is your name?");
            String name = scan.next();
            System.out.println("Hello," + name);
            long start = System.currentTimeMillis();
            int myNum = rand.nextInt(100) + 1;
            System.out.println("Cheat: " + myNum);
            for (int i = 0; i < 10; i++) {
                int userNum = askGuess();
                if (myNum == userNum) {
                    GameResult r = new GameResult();
                    long end = System.currentTimeMillis();
                    r.name = name;
                    r.triesCount = i + 1;
                    r.time = end - start;
                    leaders.add(r);
                    System.out.println((end - start)/1000);
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
        for (GameResult r : leaders) {
            System.out.printf("user:%s tries:%d time:%.1f %n" , r.name , r.triesCount , r.time/1000.0);
        }
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