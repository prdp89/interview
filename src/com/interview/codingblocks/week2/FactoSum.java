package com.interview.codingblocks.week2;

import java.util.Scanner;

//source: https://hack.codingblocks.com/contests/c/452/56
public class FactoSum {

    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int range = scanner.nextInt();

        long sum = 0;
        while (range-- > 0) {
            sum += solveUsingArray(scanner.nextInt());
        }

        System.out.println(sum % 107);
    }

    private static long solveUsingArray(int number) {
//        Scanner scanner = new Scanner(System.in);

        //creating an array that stores
        int result[] = new int[500];
        result[0] = 1;

        int index = 1; //denotes index of array; why 1 bcz : when 1st number multiply by 1 it doesn't turn zero in other case if index=0.

//        int number = scanner.nextInt();

        for (int i = 2; i <= number; i++) {
            index = factorial(result, index, i);
        }

        long finalResult =0 ;
        long mult = 1;
        for (int i = 0; i <= index-1; i++) {
            finalResult += result[i] * mult;
            mult = mult * 10;
        }

        return finalResult;
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

    public static void main( String[] args ) {
        solve();
    }
}
