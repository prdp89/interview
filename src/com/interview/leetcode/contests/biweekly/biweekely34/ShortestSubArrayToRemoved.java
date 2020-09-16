package com.interview.leetcode.contests.biweekly.biweekely34;

public class ShortestSubArrayToRemoved {

    //https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 10, 4, 2, 3, 5};
        System.out.println(findLengthOfShortestSubarray(arr));
    }

    private static int findLengthOfShortestSubarray( int[] arr ) {
        int n = arr.length;

        int start = 0, end = n - 1;

        //scan from start for increasing sequence
        while (start < n - 1 && arr[start] <= arr[start + 1])
            start++;

        //if all array is strictly increasing
        if (start == n - 1)
            return 0;

        //scan from last for decreasing sequence
        while (end >= start && arr[end] >= arr[end - 1])
            end--;

        //works without this too..
        //if all array is strictly decreasing
        //if(end == 0)
          //  return n - 1;

        // {1, 2, 3, 10, 4, 2, 3, 5 }
        //start = 3, end = 5
        int min = Math.min(n - 1 - start, end); //Min(4, 5) => 4

        int i = 0, j = end;

        //Now we have to compare starting and last violated element
        //if we can get min. sequence between i & J
        while (i <= start && j < n) {

            //if jth element still equal or greater than ith element
            //Then we can re-calculate i&J range
            if (arr[j] >= arr[i]) {
                min = Math.min(min, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return min;
    }
}
