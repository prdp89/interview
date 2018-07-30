package com.interview.codingblocks.week6recursion;

import java.util.Scanner;

public class PowerFunction {

    //Recursive formula is : Power(a, b) = a * power(a, b - 1)
    //Complexity : O(B)
    private static int power( int a, int b ) {
        if (b == 1)
            return a;

        int power = a * power(a, b - 1);
        return power;
    }

    //Complexity: O(Log b)
    private static int fastPower( int a, int b ) {

        if (b == 0)
            return 1;

        int smallAns = fastPower(a, b / 2);
        smallAns *= smallAns;

        //if b is odd
        if ((b & 1) != 0) {
            return a * smallAns;
        }
        return smallAns;

        //IF B is odd : 2 ^ 9 => 2 * (2 ^ 4) ^ 2
        // If b is even : (2  ^ 4) ^ 2
    }

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        //  System.out.println(power(a, b));

        System.out.println(fastPower(a, b));
    }
}
