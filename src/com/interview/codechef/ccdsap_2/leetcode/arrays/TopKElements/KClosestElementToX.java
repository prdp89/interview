package com.interview.codechef.ccdsap_2.leetcode.arrays.TopKElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElementToX {

    //question is same as : ccdsap_2.leetcode.binarysearch.medium.KClosestElements
    //Trying PQ approach in this part

    //https://leetcode.com/problems/find-k-closest-elements/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4, x = 3;

        findClosestElement(arr, k, x).forEach(System.out::println);
    }

    private static List<Integer> findClosestElement( int[] arr, int k, int x ) {

        int size = arr.length;

        if (x < arr[0]) {
            return getElements(arr, 0, k - 1);
        }

        if (x > arr[size - 1]) {
            return getElements(arr, size - k, size - 1);
        }

        return usingPriorityQueue(arr, k, x);
    }

    private static List<Integer> usingPriorityQueue( int[] arr, int k, int x ) {

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();

        //rank is calculate How much closest that number from this number
        for (int i = 0; i < arr.length; i++) {
            maxHeap.offer(new Pair(Math.abs(x - arr[i]), arr[i]));
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll().num);
        }

        Collections.sort(result);
        return result;
    }

    private static List<Integer> getElements( int[] arr, int beg, int end ) {
        List<Integer> list = new ArrayList<>();

        while (beg <= end) {
            list.add(arr[beg]);
            beg++;
        }

        return list;
    }

    static class Pair implements Comparable<Pair> {
        int rank;
        int num;

        public Pair( int rank, int num ) {
            this.rank = rank;
            this.num = num;
        }

        public int compareTo( Pair that ) {
            //if rank is equal then sort acc. to num
            if (this.rank == that.rank) {
                return this.num - that.num;
            }

            return this.rank - that.rank;
        }
    }
}
