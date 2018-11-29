package com.interview.hackerrank.basicPractice;


//https://www.hackerrank.com/challenges/bigger-is-greater/problem
public class BiggerIsGreater {

    //https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
    private static String nextPermutation( String str ) {
        char[] array = str.toCharArray();
        // Find longest non-increasing suffix
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        // Now i is the head index of the suffix

        // Are we at the last factorial already?
        if (i <= 0)
            return "no answer";

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

        // Successfully computed the next factorial
        return String.valueOf(array);
    }

    public static void main( String[] args ) {
        String str = "ab";
        System.out.println(nextPermutation(str));
    }
}
