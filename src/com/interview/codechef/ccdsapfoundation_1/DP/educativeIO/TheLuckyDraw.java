package com.interview.codechef.ccdsapfoundation_1.DP.educativeIO;

import java.util.Arrays;
import java.util.Scanner;

public class TheLuckyDraw {

    private static int memo[] = new int[1000000];

    //https://www.codechef.com/problems/D2/
    public static void main( String[] args ) {
        try {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();

                int[] arr = new int[2 * n];

                for (int i = 0; i < n; i++)
                    arr[i] = arr[i + n] = scanner.nextInt();

                System.out.println(LIS(arr, arr.length));
            }
        } catch (Exception e){
            return;
        }
    }

    //pass test cases but not an optimal solution
    private static int LIS( int arr[], int n ) {
        int temp, m = 0;

        Arrays.fill(memo, -1);

        for (int i = 0; i < n; i++) {

            temp = _lisRecursive(arr, i);

            if (temp > m)
                m = temp;
        }
        return m;
    }

    private static int _lisRecursive( int arr[], int n ) {
        if (n == 0) return 1;

        if (memo[n] != -1)
            return memo[n];

        int m = 1;

        for (int i = 0; i < n; i++) {

            //we just need to think for one case, rest recursion will come up with.
            if (arr[i] < arr[n]) {
                int temp = 1 + _lisRecursive(arr, i);

                if (temp > m)
                    m = temp;    //   m = max(m, 1 + _lisRecursive(arr, i));
            }
        }

        memo[n] = m;

        return m;
    }
}
