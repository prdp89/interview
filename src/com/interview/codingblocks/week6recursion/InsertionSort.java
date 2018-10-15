package com.interview.codingblocks.week6recursion;

public class InsertionSort {

    private static int count = 0;

    private static void sortIterative( int arr[] ) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;

                count++;

            }
            arr[j + 1] = key;

        }
    }

    //this is working
    private static void sortRecursive( int a[], int i, int j, int n ) {

        if (i == n)
            return;

        int key = a[i];
        while (j >= 0 && a[j] > key) {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = key;

        int temp = i + 1; //this is needed since J value should be updated I value -1

        //this call is equivalent to outer loop of insertion sort.
        sortRecursive(a, temp, temp - 1, n);
    }

    //this is not working, need more thinking.. :(
    private static void sortRecursiveV2( int a[], int i, int j, int n ) {

        if (i == n)
            return;

        if (i < n && j < 0) {
            int temp = i + 1; //this is needed since J value should be updated I value -1

            //this call is equivalent to outer loop of insertion sort.
            sortRecursiveV2(a, temp, temp - 1, n);
            return;
        }

        if (a[j] > a[i]) {
            a[j + 1] = a[j];

            //this call is equivalent to inner loop of insertion sort.
            sortRecursiveV2(a, i, j - 1, n);
            return;
        }

        a[j + 1] = a[i];
    }

    public static void main( String[] args ) {
        //int a[] = {3, 11, 1, 0, 5, 2};

        int a[] = {2, 1, 3, 1, 2};

        sortIterative(a);

        //sortRecursive(a, 1, 0, a.length);

        // sortRecursiveV2(a, 1, 0, a.length);

        for (int item : a) {

            System.out.print(item + " ");
        }

        System.out.println("\nCount :" + count);
    }
}
