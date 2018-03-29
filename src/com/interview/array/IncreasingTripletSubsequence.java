package com.interview.array;

/**
 * Date 03/06/2016
 * @author Tushar Roy
 *
 * Find if there exists an increasing triplet subsequence.
 * Similar method to longest increasing subsequence in nlogn time.
 *
 * Time complexity is O(n)
 * Space complexity is O(1)
 *
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */

//Read LongestIncreasingSubsequence program in the package for full understanding..

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int T[] = new int[3];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean found = false;
            for (int j = 0; j < len; j++) {
                if (T[j] >= nums[i]) {
                    T[j] = nums[i];
                    found = true;
                    break;
                }
            }
            if (!found) {
                T[len++] = nums[i];
            }
            if (len == 3) {
                return true;
            }
        }
        return false;
    }

    //solution from geeksforgeeks
    // A function to find a sorted subsequence of size 3
    public void find3Numbers(int arr[])
    {
        int n = arr.length;
        int max = n-1; //Index of maximum element from right side
        int min = 0; //Index of minimum element from left side
        int i;

        // Create an array that will store index of a smaller
        // element on left side. If there is no smaller element
        // on left side, then smaller[i] will be -1.
        int[] smaller = new int[n];
        smaller[0] = -1;  // first entry will always be -1
        for (i = 1; i < n; i++)
        {
            if (arr[i] <= arr[min])
            {
                min = i;
                smaller[i] = -1;
            }
            else
                smaller[i] = min;
        }

        // Create another array that will store index of a
        // greater element on right side. If there is no greater
        // element on right side, then greater[i] will be -1.
        int[] greater = new int[n];
        greater[n-1] = -1;  // last entry will always be -1
        for (i = n-2; i >= 0; i--)
        {
            if (arr[i] >= arr[max])
            {
                max = i;
                greater[i] = -1;
            }
            else
                greater[i] = max;
        }

        // Now find a number which has both a greater number
        // on right side and smaller number on left side
        for (i = 0; i < n; i++)
        {
            if (smaller[i] != -1 && greater[i] != -1)
            {
                System.out.print(arr[smaller[i]]+" "+
                        arr[i]+" "+ arr[greater[i]]);
                return;
            }
        }

        // If we reach number, then there are no such 3 numbers
        System.out.println("No such triplet found");
        return;
    }

    public static void main(String args[]) {
        IncreasingTripletSubsequence tripletSubsequence = new IncreasingTripletSubsequence();
        int input[] = {9, 10, -2, 12, 6, 7, -1};
       // System.out.print(tripletSubsequence.increasingTriplet(input));

        tripletSubsequence.find3Numbers(input);
    }
}
