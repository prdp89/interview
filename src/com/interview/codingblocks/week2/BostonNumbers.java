package com.interview.codingblocks.week2;

import java.util.Random;
import java.util.Scanner;

public class BostonNumbers {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (primeFactors(n) == sumOfDigits(n))
            System.out.println(1);
        else
            System.out.println(0);

        // stressTest();
    }

    private static void stressTest() {
        int test = 20;
        while (test-- > 0) {

            Random random = new Random();
            int n = random.nextInt(1000) + 2; // Math.abs(random.nextInt() % 10 + 2); //this generates number in range of 0-10

            if (primeFactors(n) == sumOfDigits(n))
                System.out.println(" Test number : " + n + " answer :" + 1);
            else
                System.out.println(" Test number : " + n + " answer :" + 0);
        }
    }

    private static int sumOfDigits( int n ) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // A function to print all prime factors of a given number n
    private static int primeFactors( int n ) {

        int sum = 0;
        // firstly calculate the number of 2s that divide n
        //System.out.print("Prime factors :");
        while (n % 2 == 0) {
            sum += 2;
            // System.out.print(" " + 2 + " * ");
            n = n / 2;
        }

        // n must be odd at this point.  So we can skip
        // one element (Note i = i +2)
        int temp = (int) Math.sqrt(n) + 1;
        for (int i = 3; i <= temp; i = i + 2) {

            // While i divides n, SUM i and divide n
            while (n % i == 0) {
                if (i > 10)
                    sum += sumOfDigits(i);
                else
                    sum += i;
                // System.out.print(" " + i + " * ");
                n = n / i;
            }
        }

        // This condition is to handle the case when n
        // is a prime number greater than 2
        if (n > 2) {
            if (n > 10)
                return sum + sumOfDigits(n);
            else
                return sum + n;
            //System.out.print(" * " + n);
        } else return sum;
    }
}
