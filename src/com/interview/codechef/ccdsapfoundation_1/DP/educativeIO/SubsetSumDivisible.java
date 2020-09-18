package com.interview.codechef.ccdsapfoundation_1.DP.educativeIO;

import java.util.Scanner;

public class SubsetSumDivisible {

    //https://www.geeksforgeeks.org/subset-sum-divisible-m/
    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int sum = 0;

            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = scanner.nextInt();

            int ans = 0;

            if (isSubsetSumDivisible(arr, n, 0, m))
                ans = 1;

            System.out.println(ans);
        }
    }

    private static boolean isSubsetSumDivisible( int set[],
                                                 int n, int sum, int m ) {
        if (sum % m == 0 && sum > 0)
            return true;

        if (n == 0)        // if no input is given then it is impossible
            return false;  //  to find any subset

        return isSubsetSumDivisible(set, n - 1, sum + set[n - 1], m)
                || isSubsetSumDivisible(set, n - 1, sum, m);
    }
}
