package com.interview.algortihmictoolboxpractice.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ThreeWayQuickSort {

    public static void main( String[] args ) {
        /*int arr[] = {4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4};
        printArray(arr);
        sort(arr, 0, arr.length-1);
        System.out.println("\nAfter sorting");
        printArray(arr);*/

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        sort(a, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

    }

    static void printArray( int[] arr ) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    static void swap( int[] arr, int i, int j ) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //sort using 3 way partition
    static void sort( int[] arr, int lowIndex, int highIndex ) {

        if (highIndex <= lowIndex) {
            return;
        }

        int start = lowIndex;
        int end = highIndex;
        int i = lowIndex;
        int pivot = arr[lowIndex];

        //the difference in 3-way sort is majorly this loop and comparision inside it.
        while (i <= end) {
            if (arr[i] < pivot) {
                swap(arr, i, start);
                i++;
                start++;
            } else if (arr[i] > pivot) {
                swap(arr, i, end);
                end--;
            } else {
                i++;
            }
        }

        sort(arr, lowIndex, start - 1);
        sort(arr, end + 1, highIndex);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner( InputStream stream ) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
