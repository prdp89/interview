package com.interview.array;

import java.util.Arrays;

/**
 * Kth largest element in an array.
 * Use quickselect of quicksort to find the solution in hopefully O(nlogn) time.
 * Test cases
 * Sorted array
 * Reverse sorted array
 */

//Also read k largest : https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/

// or read Kth largest or smallest : https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/

//This program runs in O(N) due to quickselect approach and limited traversal on right/left array.

public class KthElementInArray {

    public static void main( String args[] ) {
        int arr[] = {2, 3, 1, 5, 7, 6, 10, 9}; //{6, 2, 1, 6, 8, 9, 6};
        KthElementInArray kthElement = new KthElementInArray();
        //System.out.print(kthElement.kthElement(arr, arr.length/2));
        System.out.print(kthElement.kthElement(arr, 3));
        System.out.print(Arrays.toString(arr));
    }

    int kthElement( int arr[], int k ) {
        int low = 0;
        int high = arr.length - 1;
        int pos;
        while (true) {
            pos = quickSelect(arr, low, high);
            if (pos == (k + low)) {
                return arr[pos];
            }
            if (pos > k + low) {
                high = pos - 1;
            } else {
                k = k - (pos - low + 1);
                low = pos + 1;
            }
        }
    }

    private int quickSelect( int arr[], int low, int high ) {
        int pivot = low;
        low++;
        while (low <= high) {
            if (arr[pivot] > arr[low]) {
                low++;
                continue;
            }
            if (arr[pivot] <= arr[high]) {
                high--;
                continue;
            }
            swap(arr, low, high);
        }
        if (arr[high] < arr[pivot]) { //high should be greater than pivot; if not then swap
            swap(arr, pivot, high);
        }
        return high;
    }

    private void swap( int arr[], int low, int high ) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

}
