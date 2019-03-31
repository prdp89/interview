package com.interview.codingblocks.week10DivideAndConquer;

import java.util.Scanner;

public class MaxSubArraySum {

    //https://www.youtube.com/watch?v=ohHWQf1HDfU
    //https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/
    //Time complexity: is Θ(nLogn)
    //It can be solved in O(N) using kadane algo.
    public static void main( String[] args ) {

        //int arr[] = new int[]{-2, -5, 6, -2, -3, 1, 5, -6};

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {

            int N = scanner.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++)
                arr[i] = scanner.nextInt();

            //int arr[] = new int[]{3, -2, 5, 1};
            System.out.println(maxSubArraySum(arr, 0, arr.length - 1));
        }
    }

    private static int maxSubArraySum( int arr[], int left, int right ) {
        int mid;

        if (left == right)
            return arr[left];

        mid = (right + left) / 2;

        //if arr[] = {3 , -2, 5, 1}
        int leftMaxSubArray = maxSubArraySum(arr, left, mid); //3
        int rightMaxSubArray = maxSubArraySum(arr, mid + 1, right); //5

        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE, sum = 0;

        //rightSum = {5, 1} => 5+1 => 6
        for (int i = mid; i < arr.length; i++) {
            sum += arr[i];
            rightSum = Math.max(sum, rightSum);
        }

        sum = 0; //leftSum = {3 , -2} => 3 + -2 = 1
        for (int i = mid - 1; i >= 0; i--) {
            sum += arr[i];
            leftSum = Math.max(sum, leftSum);
        }

        int ans = Math.max(leftMaxSubArray, rightMaxSubArray);// max(3, 5) => 5
        return Math.max(ans, leftSum + rightSum); //max(5, 1+6) //7 = ans
    }
}
