package com.interview.array;

/**
 * http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
 * Test cases
 * input containg neg and pos values
 * val of k is neg 0 or pos
 * val of k is larger than size of input
 * val of k is same as size of input
 */

import java.util.*;

public class MaximumOfSubarrayOfSizeK {


    public static void main( String args[] ) {
       /* int input[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        MaximumOfSubarrayOfSizeK msa = new MaximumOfSubarrayOfSizeK();
        int max[] = msa.maxSubArray(input, 4);*/

        int input[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        MaximumOfSubarrayOfSizeK msa = new MaximumOfSubarrayOfSizeK();

        Integer max[] = msa.maxsInEveryWindows(input, 3);
        for (int i : max) {
            System.out.print(i + " ");
        }

        System.out.println("\nBrute Force:");
        msa.bruteForce(input, input.length, 3);
    }

    // Method to find the maximum for each and every contiguous subarray of size k.
    private void bruteForce( int arr[], int n, int k ) {
        int j, max;

        for (int i = 0; i <= n - k; i++) {

            max = arr[i];

            for (j = 1; j < k; j++) {

                if (arr[i + j] > max)
                    max = arr[i + j];
            }
            System.out.print(max + " ");
        }
    }

    /*
    Input :
    arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
    k = 3

    Output :
    3 3 4 5 5 5 6
     */
    //https://stackoverflow.com/questions/8031939/finding-maximum-for-every-window-of-size-k-in-an-array/17249084#17249084
    private Integer[] maxsInEveryWindows( int[] arr, int k ) {
        Deque<Integer> deque = new ArrayDeque<Integer>();

        /* Process first k (or first window) elements of array */
        for (int i = 0; i < k; i++) {
            // For very element, the previous smaller elements are useless so
            // remove them from deque
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast(); // Remove from rear
            }
            // Add new element at rear of queue
            deque.addLast(i);
        }
        List<Integer> result = new ArrayList<Integer>();

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (int i = k; i < arr.length; i++) {

            // The element at the front of the queue is the largest element of
            // previous window, so add to result.
            result.add(arr[deque.getFirst()]);

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }

            // Remove the elements which are out of this window
            while (!deque.isEmpty() && deque.getFirst() <= i - k) { //this same : i-k used in //https://www.geeksforgeeks.org/window-sliding-technique/
                deque.removeFirst();
            }

            // Add current element at the rear of deque
            deque.addLast(i);
        }

        // Print the maximum element of last window
        result.add(arr[deque.getFirst()]);

        return result.toArray(new Integer[0]);
    }

    public int[] maxSubArray( int input[], int k ) {
        Deque<Integer> queue = new LinkedList<Integer>();
        int max[] = new int[input.length - k + 1];
        int maxVal = Integer.MIN_VALUE;
        //first find max of first k values and make it 0th element of max array
        for (int i = 0; i < k; i++) {
            if (maxVal < input[i]) {
                maxVal = input[i];
            }
            if (queue.isEmpty()) {
                queue.offerLast(i);
            } else {
                while (!queue.isEmpty() && input[queue.peekLast()] <= input[i]) {
                    queue.pollLast();
                }
                queue.offerLast(i);
            }

        }
        max[0] = maxVal;
        int index = 1;
        //continue from k till end of the input array
        for (int i = k; i < input.length; i++) {

            //if index of peek is k distance from i then its no value to us.
            //throw it away
            if (i - k + 1 > queue.peekFirst()) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && input[queue.peekLast()] <= input[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            //Only reason first element survived was because it was biggest element.
            //make it the max value for this k
            max[index] = input[queue.peekFirst()];
            index++;
        }
        return max;
    }
}
