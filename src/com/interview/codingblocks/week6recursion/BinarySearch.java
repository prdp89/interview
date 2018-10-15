package com.interview.codingblocks.week6recursion;

public class BinarySearch {

    public static void main( String[] args ) {

        int a[] = {1, 3, 6, 34, 2, 0, 9};

        int keyItem = 2;
        System.out.println(binarySearch(a, 0, keyItem, a.length - 1));
    }

    private static int binarySearch( int[] a, int i, int keyItem, int length ) {

       /* if (i >= length)
            return -1;*/

        if (i > length)
            return -1;

        //int mid = i + ((length - i) / 2);
        int mid = (i + length) >> 1;

        if (a[mid] == keyItem)
            return mid;
        else if (keyItem < a[mid])
            return binarySearch(a, i, keyItem, mid - 1);
        else
            return binarySearch(a, mid + 1, keyItem, length);
    }
}
