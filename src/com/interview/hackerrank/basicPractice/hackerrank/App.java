package com.interview.hackerrank.basicPractice.hackerrank;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.println(diverseDeputation(m, n));
    }

    public static int diverseDeputation( int m, int w ) {
        // Write your code here
        if (m == 0 || w == 0) {
            return 0;
        }
        /*if (m < 0 || w < 0) {
            return 0;
        }
        if (m >= 1000 || w >= 1000) {
            return 0;
        }*/
        
        return ((combination(m, 1)) * combination(w, 2)) + ((combination(m, 2)) * combination(w, 1));
    }

    public static int combination( int number1, int number2 ) {
        if (number1 == number2) {
            return 1;
        }
        if (number2 > number1) {
            return 0;
        }
        int fact1 = factorial(number1);
        int fact2 = factorial(number2);
        int fact3 = factorial(number1 - number2);
        int fact4 = fact2 * fact3;

        return fact1 / fact4;

    }

    public static int factorial( int i ) {
        if (i == 1) {
            return 1;
        }
        return i * factorial(i - 1);
    }
}
