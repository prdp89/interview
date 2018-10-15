package com.interview.codingblocks.week6recursion;

public class BubbleSort {

    private static void bubbleSort( int[] a, int n ) {

        //if whole array is sorted
        if (n == 1)
            return;

        //this is an internal loop of bubble sort; By end of this loop 1 largest element adjust at last
        for (int j = 0; j <= n - 2; j++) {

            if (a[j] > a[j + 1]) {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }

        //Recursion to enumerate on n-1 after 1 element adjust at last
        bubbleSort(a, n - 1);
    }

    private static void bubbleSortV2( int[] a, int j, int n ) {

        //if whole array is sorted
        if (n == 1)
            return;

        //if J reaches end, 1 pass is over, ist largest is set to the last; then reset J to start over
        if (j == n - 1) {
            bubbleSortV2(a, 0, n - 1);
            return; //return is necessary here.
        }

        if (a[j] > a[j + 1]) {
            int temp = a[j];
            a[j] = a[j + 1];
            a[j + 1] = temp;
        }

        //THis method call is equivalent to inner loop of Bubble sort
       // if (j <= n - 2) {
            bubbleSortV2(a, j + 1, n);
        //}
    }

    public static void main( String[] args ) {

        int a[] = {3, 11, 1, 0, 5, 2};
        //bubbleSort(a, a.length);

        bubbleSortV2(a, 0, a.length);

        for (int item : a) {

            System.out.print(item + " ");
        }

    }
}
