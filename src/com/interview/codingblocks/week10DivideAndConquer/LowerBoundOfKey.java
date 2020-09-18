package com.interview.codingblocks.week10DivideAndConquer;

public class LowerBoundOfKey {

    //lower bound of key is: First occurance of the number from left

    public static void main( String[] args ) {
        int[] a = {1, 1, 2, 2, 2, 4, 4};
        int n = 7, key = 2; //we need to find first occurance of 2 in array

        System.out.println(firstOccurance(a, n-1, key));
    }

    private static int firstOccurance( int[] a, int n, int key ) {

        int resIndex = -1, start = 0, end = n;

        while (start <= end) {

            int midIndex = (start + end) / 2;

            //little change in this part, bcz we need to search in left part for first occurance
            if(a[midIndex] == key){
                resIndex = midIndex;
                end = midIndex - 1;
            }
            else if (a[midIndex] > key) {
                end = midIndex - 1;
            }else
                start = midIndex + 1;
            }
        return resIndex;
    }
}
