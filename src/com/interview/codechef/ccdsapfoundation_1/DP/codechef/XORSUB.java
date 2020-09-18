package com.interview.codechef.ccdsapfoundation_1.DP.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class XORSUB {

    //https://www.codechef.com/problems/XORSUB
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner( InputStream stream ) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    private static int max = 0;

    public static void main( String[] args ) {

        int[] arr = {1, 2, 3};
        int[] temp = new int[arr.length];
        int[] dp = new int[arr.length + 1];

        printArraySubsequences(arr, 0, temp);

        //Arrays.fill(dp, -1);

        //System.out.println(recurse(arr, arr.length, 0, 4, temp, dp));

       /* try {
            FastScanner scanner = new FastScanner(System.in);

            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();

                int[] arr = new int[n];

                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                }

                int[] temp = new int[n];

                int[] dp = new int[n + 1];

                max = 0;

                Arrays.fill(dp, -1);

                System.out.println(recurse(arr, arr.length, 0, k, temp, dp));
            }
        } catch (Exception e) {
            return;
        }*/
    }

    //Subsequence SubSequence
    //using inclusion-exclusion principle
    private static void printArraySubsequences( int[] arr, int index, int[] temp ) {

        if (index == arr.length) {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == 1)
                    result.append(arr[i]).append(" ");
            }

            if (Objects.equals(result.toString(), ""))
                result = new StringBuilder("{Empty Set}");

            System.out.println(result);
            return;
        }

        if (index >= arr.length)
            return;

        temp[index] = 1;
        printArraySubsequences(arr, index + 1, temp);

        //unset the current index bit and solve it recursively
        temp[index] = 0;
        printArraySubsequences(arr, index + 1, temp);
    }

    //using backtrack and recursion way
    static void printSubSequences( int[] arr, int start, List<Integer> chosen, String space ) {

        if (start > arr.length) {
            return;
        } else {

            for (int i = start; i < arr.length; i++) {

                //choose
                chosen.add(arr[i]);
                System.out.println(space + chosen);

                //explore
                printSubSequences(arr, i + 1, chosen, space + " ");

                //un-choose
                chosen.remove(chosen.size() - 1);
            }
        }
    }

    //passing 70% test cases..need bottom up DP here :P
    private static int recurse( int[] arr, int length, int index, int k, int[] temp, int dp[] ) {

        if (index == length) {

            int xor = 0;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == 1) {
                    xor ^= arr[i];
                }
            }

            xor ^= k;

            max = Math.max(xor, max);

            dp[index] = max;

            return max;
        }

        if (dp[index] != -1)
            return dp[index];

        temp[index] = 1;

        recurse(arr, length, index + 1, k, temp, dp);

        temp[index] = 0;

        recurse(arr, length, index + 1, k, temp, dp);

        return max;
    }
}
