package com.interview.codechef.ccdsapfoundation_1.Maths;

import java.math.BigInteger;

public class PowerDigitSum {

    public static void main( String[] args ) {
        System.out.println(solveM1());

        System.out.println(solveMethod2());
    }

    private static int solveM1() {
        int a = 2;
        int b = 1000;

        // Converting Integer to BigInteger.
        BigInteger number = new BigInteger(String.valueOf(a));

        // Getting 2^1000.
        BigInteger power = number.pow(b);

        // Converting BigInteger to String.
        String powerInString = String.valueOf(power);

        int length = powerInString.length();
        int sum = 0;

        for (int i = 0; i < length; i++) {
            // Converting char to int.
            //temp = powerInString.charAt(i) - 48;
            sum += Character.getNumericValue(powerInString.charAt(i));
        }
        return sum;
        //System.out.println("The sum of the digits of the number 2^1000 is : " + sum);
    }

    private static int solveMethod2() {
        int a = 2;
        int b = 1000;

        // Calculate number of digits in 2^n.
        int length = (int) Math.floor(b / Math.log(10)) + 1;

        int sum = 0;

        int[] arr = new int[length];

        arr[0] = 2;
        int carry = 0;

        for (int j = 1; j < 1000; j++) {

            for (int i = 0; i < arr.length; i++) {

                int tempno = arr[i] * 2;

                if (tempno > 9) {
                    arr[i] = (tempno % 10) + carry;
                    carry = 1;
                } else {
                    arr[i] = tempno + carry;
                    carry = 0;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
