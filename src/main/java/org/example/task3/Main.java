package org.example.task3;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = 1; i <= 100; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String factorialStr = factorial.toString();

        int digitSum = 0;
        for (char digit : factorialStr.toCharArray()) {
            digitSum += Character.getNumericValue(digit);
        }

        System.out.println("The sum of the digits in 100! is: " + digitSum);
    }
}
