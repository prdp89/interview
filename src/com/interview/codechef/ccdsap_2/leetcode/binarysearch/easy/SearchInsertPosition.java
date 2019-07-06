package com.interview.codechef.ccdsap_2.leetcode.binarysearch.easy;

public class SearchInsertPosition {

    //https://leetcode.com/problems/search-insert-position/
    public static void main( String[] args ) {

        int[] arr = {1, 3, 5, 6};
        int target = 0;

        method_1(arr, target);
    }

    private static void method_1( int[] arr, int target ) {

        int start = 0, end = arr.length - 1;

        while (start <= end) {

            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                System.out.println(mid);
                return;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else
                start = mid + 1;
        }

        // (1) At this point, low > high. That is, low >= high+1
        // (2) From the invariant, we know that the index is between [low, high+1], so low <= high+1. Follwing from (1), now we know low == high+1.
        // (3) Following from (2), the index is between [low, high+1] = [low, low], which means that low is the desired index
        //     Therefore, we return low as the answer. You can also return high+1 as the result, since low == high+1
        System.out.println(end >= 0 &&  arr[end] < target ? end + 1 : 0);

        //or we can return
        //return start;
    }
}
