package com.company;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("What is your name?");
        String name = scan.next();
        System.out.println("Hello," + name);

        int myNum = rand.nextInt(100) + 1;
        System.out.println("Cheat: " + myNum);

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter your number");
            int userNum = scan.nextInt();

            if (myNum == userNum) {
                System.out.println("You win");
                break;
            }

            if (myNum < userNum) {
                System.out.println("Go lower");
            }

            if (myNum > userNum) {
                System.out.println("Go higher");
            }

        }
    }
}
