package com.interview.codingblocks.week2;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {

    public static void main( String[] args ) {
      //  solveUsingArray();
        solveUsingBigNumber();
    }

    private static void solveUsingBigNumber() {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        BigInteger big = new BigInteger("1");

        for (int i = 2; i <= number; i++) {
            big = big.multiply(BigInteger.valueOf(i));
        }

        System.out.println(big.toString());
    }

    private static void solveUsingArray() {
        Scanner scanner = new Scanner(System.in);

        //creating an array that stores
        int result[] = new int[500];
        result[0] = 1;

        int index = 1; //denotes index of array; why 1 bcz : when 1st number multiply by 1 it doesn't turn zero in other case if index=0.

        int number = scanner.nextInt();

        for (int i = 2; i <= number; i++) {
            index = factorial(result, index, i);
        }

        for (int i = index - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }
    }

    private static int factorial( int[] result, int index, int currentNumberToMultiply ) {

        int carry = 0, product, i = 0;

        //loop upto current index of array result[index] , index : is updated after each function call.
        for (; i < index; i++) {
            product = result[i] * currentNumberToMultiply + carry;
            result[i] = product % 10;
            carry = product / 10;
        }

        //inserting left out carry in result[]
        while (carry != 0) {
            result[i] = carry % 10;
            carry = carry / 10;
            i++;
        }
        return i;
    }
}
