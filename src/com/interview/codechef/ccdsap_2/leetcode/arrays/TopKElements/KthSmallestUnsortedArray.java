package com.interview.codechef.ccdsap_2.leetcode.arrays.TopKElements;

import java.util.*;

public class KthSmallestUnsortedArray {

    //Creation of heap has complexity of O(n)
    //each time there will be heapify(). It will have complexity of O(log n) for n element heap.
    //So, overall complexity would be O(n + k log n).
    public static void main( String[] args ) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 4, 3, 2));
        int k = 5;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        pq.addAll(list);

        while (k-- > 1) {
            pq.poll();
        }

        System.out.println(pq.poll());

        //------------or Using Quick Select------------------

        int[] arr = {2, 1, 4, 3, 2};
        int kth = 4;

        System.out.println("Using quick select: " + findKthSmallestElement(arr, 0, arr.length - 1, kth));
    }

    //-----------Using Quick Select of Quick Sort----------------

    //this algorithm still has complexity of O(n log n), but practically,
    //you do not need to sort the entire array before you find k smallest elements.
    private static int findKthSmallestElement( int a[], int start,
                                               int end, int k ) {
        if (start <= end) {
            int p = partition(a, start, end);

            //if element found at pivot index
            if (p == k - 1) {
                return a[p];
            }

            //if pivot index is greater than element index we are searching
            if (p > k - 1)
                return findKthSmallestElement(a, start, p, k);
            if (p < k - 1)
                return findKthSmallestElement(a, p + 1, end, k);
        }

        return start == end ? a[end] : -1;
    }

    private static void swap( int[] a, int i, int j ) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int partition( int[] a, int start, int end ) {
        int pivot = a[start];
        int i = start;
        int j = end;

        while (i <= j) {

            while (a[i] < pivot)
                i++;

            while (a[j] > pivot)
                j--;

            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }

        //swap(a, start, j);
        return j;
    }

    //-----------------------------------------------------------
}
