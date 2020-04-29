package com.interview.companies.fb;

import java.util.Arrays;

public class PlusOne {

    //https://leetcode.com/problems/plus-one/
    public static void main( String[] args ) {
        int[] arr = {9};

        System.out.println(Arrays.toString(plusOne(arr)));
    }

    //Runtime: 1 ms, faster than 9.91% of Java
    private static int[] plusOne( int[] digits ) {

        StringBuilder sb = new StringBuilder();
        StringBuilder sbSum = new StringBuilder();

        for (int i = 0; i < digits.length; i++) {
            sb.append(digits[i]);
        }

        int i = sb.length() - 1, carry = 0, j = 0;

        String str = "1";

        while (i >= 0 || j == 0) {

            int sum = carry;

            if (i >= 0)
                sum += Character.getNumericValue(sb.charAt(i--));

            if (j == 0) {
                sum += Character.getNumericValue(str.charAt(j--));
            }

            sbSum.append(sum % 10);

            carry = sum / 10;
        }

        if (carry != 0) {
            sbSum.append(carry);
        }

        sb = new StringBuilder();
        for (int l = 0; l < sbSum.length(); l++)
            sb.insert(0, sbSum.charAt(l));

        int[] arr = new int[sb.length()];
        for (int m = 0; m < arr.length; m++)
            arr[m] = sb.charAt(m) - '0';

        return arr;
    }

    public int[] plusOneOptimal( int[] digits ) {

        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        /* This  part of code is only for the case that the whole input array is 9s.
        For example : 99999-----> 100000
        Any other case would return in the loop.*/

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }
}
