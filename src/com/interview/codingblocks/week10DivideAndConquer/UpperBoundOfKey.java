package com.interview.codingblocks.week10DivideAndConquer;

public class UpperBoundOfKey {

    public static void main( String[] args ) {

        int[] a = {1, 1, 2, 2, 2, 4, 4};
        int n = 7, key = 4; //we need to find last occurance of 4 in array

        System.out.println(lastOccurance(a, n - 1, key));
    }

    private static int lastOccurance( int[] a, int n, int key ) {

        int resIndex = -1, start = 0, end = n;

        while (start <= end) {

            int midIndex = (start + end) / 2;

            //little change in this part, bcz we need to search in left part for first occurance
            if (a[midIndex] == key) {
                resIndex = midIndex;
                start = midIndex + 1; //compare this line with LowerBoundOfKey program, easily understood.
            } else if (a[midIndex] > key) {
                end = midIndex - 1;
            } else
                start = midIndex + 1;
        }
        return resIndex;
    }
}
