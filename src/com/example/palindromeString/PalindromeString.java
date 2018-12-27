package com.example.palindromeString;

import java.util.Scanner;

public class PalindromeString {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello says the program!!");

        int size = scanner.nextInt();
        scanner.nextLine();
        String inputString = scanner.nextLine();

        Calculator calculator = new Calculator();
        calculator.calculatePalindromeThroughTree(size,inputString);

        calculator.calculatePalindromeThroughList(size,inputString);
    }
}
