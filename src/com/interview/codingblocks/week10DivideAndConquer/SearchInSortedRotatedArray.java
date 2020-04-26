package com.interview.codingblocks.week10DivideAndConquer;

import java.util.Scanner;

public class SearchInSortedRotatedArray {

    //https://www.youtube.com/watch?v=ctW9Q6Y_Z8k

    public static void main( String[] args ) {

        int[] a = {5, 6, 7, 1, 2, 3, 4};
        Scanner scanner = new Scanner(System.in);
        int keyToSearch = scanner.nextInt();

        System.out.println("Index of " + keyToSearch + " is " + searchInSortedAndRotatedArray(a, keyToSearch, 0, a.length - 1));
    }

    private static int searchInSortedAndRotatedArray( int[] a, int keyToSearch, int start, int end ) {

        //Base case
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        //if key found
        if (a[mid] == keyToSearch)
            return mid;

        //If Mid lies in first line of Rotated array graph or we can say :
        //If a[start...mid] is sorted
        if (a[start] <= a[mid]) {

            //If Mid lies in Left side of Array
            if (keyToSearch >= a[start] && keyToSearch <= a[mid])
                return searchInSortedAndRotatedArray(a, keyToSearch, start, mid - 1);
            else //or right side of array
                return searchInSortedAndRotatedArray(a, keyToSearch, mid + 1, end);
        }

        //else if Mid lies in second line of Rotated array graph
        if (keyToSearch >= a[mid] && keyToSearch <= a[end])
            return searchInSortedAndRotatedArray(a, keyToSearch, mid + 1, end); //search in right part of array

        //otherwise search in left part of the array
        return searchInSortedAndRotatedArray(a, keyToSearch, start, mid - 1);
    }
}
