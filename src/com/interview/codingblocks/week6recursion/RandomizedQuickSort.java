package com.interview.codingblocks.week6recursion;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedQuickSort {

    public static void main( String args[] ) {
        RandomizedQuickSort qs = new RandomizedQuickSort();
        int A[] = {11, 19, 0, -1, 5, 6, 16, -3, 6, 0, 14, 18, 7, 21, 18, -6, -8};
//      int A[] = {11,9,0,4,6,-1,13};

        //We are doing Randomized quick sort here:
        //If array elements are sorted, we will shuffle it randomly
        //Quick sort perfectly work on Random element in O(NLog N)
        //But in case of Sorted Array it takes worst case : O(n ^ 2)

        Random rnd = ThreadLocalRandom.current();
        for (int i = A.length - 1; i > 0; i--) {
            //this is somewhat equivalent to Rand() % (i+1) : where Rand() generates Random number less than i and,
            // Taking generated Rand() = 0 -- 16  % 16 always less than 16.
            //So we are swapping ith element with random generated index.
            //or basic formula is : r.nextInt((max - min) + 1) + min; to generate range of random numbers.
            int index = rnd.nextInt(i + 1);

            // Simple swap
            int a = A[index];
            A[index] = A[i];
            A[i] = a;
        }

        qs.sort(A, 0, A.length - 1);
        qs.printArray(A);

    }

    private void swap( int A[], int i, int j ) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private int split( int A[], int low, int high ) {
        int pivot = low;
        int i = low + 1;
        int j = high;
        while (i < j) {
            while (i <= j && A[pivot] >= A[i]) {
                i++;
            }
            while (j >= i && A[pivot] < A[j]) {
                j--;
            }
            if (i < j && A[i] > A[j]) {
                swap(A, i++, j--);
            }
        }
        if (A[pivot] > A[j]) {
            swap(A, j, pivot);
        }
        return j;
    }

    private int split1( int A[], int low, int high ) {

        int pivot = low;
        int i = low + 1;
        int j = high;
        while (i <= j) {

            if (A[i] <= A[pivot]) {
                i++;
                continue;
            }
            if (A[j] > A[pivot]) {
                j--;
                continue;
            }
            swap(A, i++, j--);
        }
        if (A[pivot] > A[j]) {
            swap(A, pivot, j);
            return j;
        }
        return pivot;

    }

    public void sort( int A[], int low, int high ) {
        if (low >= high) {
            return;
        }
        int pos = split1(A, low, high);
        sort(A, low, pos - 1);
        sort(A, pos + 1, high);
    }

    private void printArray( int arr[] ) {
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
