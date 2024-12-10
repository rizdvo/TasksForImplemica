package org.example.task1;

import org.example.task1.exception.InvalidBracketCountException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of pairs of brackets: ");
        int countBrackets = scanner.nextInt();

        scanner.close();

        if (countBrackets < 0) {
            throw new InvalidBracketCountException("The number of parentheses must not be negative!");
        }

        BracketCounter bracketCounter = new BracketCounter(countBrackets);
        int result = bracketCounter.calculateValidCombinations();

        System.out.println("For the number " + countBrackets + ": " + " Valid values " + result);

    }
}