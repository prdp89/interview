package com.interview.leetcode.contests.contest139;

import java.util.Arrays;

//https://leetcode.com/contest/weekly-contest-139/problems/adding-two-negabinary-numbers/
public class AddingNegaBinaryNumbers {

    public static void main( String[] args ) {
        int[] a = {1, 1, 1, 1, 1};
        int[] b = {1, 0, 1};
/*
        int[] a = {1};
        int[] b = {1};
*/
        System.out.println(Arrays.toString(solve(a, b)));
    }

    //passing only 47/267 :(
    //read negative binary summation : https://en.wikipedia.org/wiki/Negative_base#Addition
    private static int[] solve( int[] a, int[] b ) {

        int num1 = convertToNegBinary(a);
        int num2 = convertToNegBinary(b);

        int sum = num1 + num2;

        return negBinaryToArray(Math.abs(sum), Math.max(a.length, b.length));
    }

    private static int[] negBinaryToArray( int sum, int max ) {
        int[] arr = new int[max];

        int i = 0;
        while (i < arr.length) {
            arr[i] = sum % 2;
            sum = sum / 2;
            i++;
        }

        if (sum == 1)
            arr[i - 1] = sum;

        int t;
        for (i = 0; i < arr.length / 2; i++) {
            t = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = t;
        }

        return arr;
    }

    private static int convertToNegBinary( int[] arr ) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                sum += Math.pow(-2, arr.length - (i + 1));
        }

        return sum;
    }
}
