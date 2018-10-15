package com.interview.codingblocks.week3;

import java.util.Arrays;

public class NextLexicographicalPermutation {

    private static boolean nextPermutation( char[] array ) {
        // Find longest non-increasing suffix
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        // Now i is the head index of the suffix

        // Are we at the last permutation already?
        if (i <= 0)
            return false;

        // Let array[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;

        // Now the value array[j] will become the new pivot
        // Assertion: j >= i

        // Swap the pivot with j
        char temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        // Successfully computed the next permutation
        return true;
    }

    //https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
    public static void main( String[] args ) {

       /* int a[] = {0, 1, 2, 5, 3, 3, 0};
        nextPermutation(a);

        for (int num : a) {
            System.out.print(num + " ");
        }*/

        //generating all permutations
        //int[] array = {0, 1, 1, 1, 4};

        char[] array = {'A', 'B', 'A'};

        do {  // Must start at lowest permutation
            //System.out.println(Arrays.toString(array));

            for (char c: array) {
                System.out.print(c);
            }

            System.out.print("\n");

        } while (nextPermutation(array));
    }

    //previous lexicographical permutations
    boolean previousPermutation( int[] array ) {
        // Find longest non-decreasing suffix
        int i = array.length - 1;
        while (i > 0 && array[i - 1] <= array[i])
            i--;
        // Now i is the head index of the suffix

        // Are we at the first permutation already?
        if (i <= 0)
            return false;

        // Let array[i - 1] be the pivot
        // Find rightmost element that is below the pivot
        int j = array.length - 1;
        while (array[j] >= array[i - 1])
            j--;
        // Now the value array[j] will become the new pivot
        // Assertion: j >= i

        // Swap the pivot with j
        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        // Successfully computed the previous permutation
        return true;
    }
}
