package com.interview.codingblocks.week6recursion;

public class LinearSearch {

    public static void main( String[] args ) {

        int a[] = {1, 3, 6, 34, 2, 0, 9};
        int keyItem = 9;
        System.out.println(linearSearch(a, 0, keyItem, a.length));
    }

    private static int linearSearch( int[] a, int i, int keyItem, int length ) {

        //if last element reached; -1 returned to previous stack frame and it propagates to first stack frame.
        if (i == length)
            return -1;

        if (a[i] == keyItem)
            return i;

        //Making an iterative call from Top to bottom, if an element index found then its value passes to next stack frame.
        return linearSearch(a, i + 1, keyItem, length);
    }
}
