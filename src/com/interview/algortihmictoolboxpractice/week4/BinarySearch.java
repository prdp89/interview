package com.interview.algortihmictoolboxpractice.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

Input Format. The first line of the input contains an integer n and a sequence
 a0 < a1 < ... < an−1 of n pairwise distinct positive integers in increasing order.
 The next line contains an integer k and k positive integers b0,b1,...,bk−1. Constraints.
 1 ≤ n,k ≤ 104; 1 ≤ ai ≤ 109 for all 0 ≤ i < n; 1 ≤ bj ≤ 109 for all 0 ≤ j < k;

 Output Format:
 For all i from 0 to k−1, output an index 0 ≤ j ≤ n−1 such that aj = bi or −1 if there is no such index.

Sample :
Input: 5 1 5 8 12 13 5 8 1 23 1 11
Output: 2 0 -1 0 -1

 */

public class BinarySearch {

    // Like public version, but without range checks.
    private static int binarySearch( int[] a,
                                     int key ) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)//element to search is greater than than mid value; Move the START index
                low = mid + 1;
            else if (midVal > key) //element to search is less than than mid value; Move the END index
                high = mid - 1;
            else
                return mid; // key found
        }
        return -1;  // key not found.
    }

    /*
    Time complexity : At each step we divide array into half as : n, n/2, n/4, n/8 .....  1

    To be generic : n/2^1 , n/2^2 , n/2^3 ..... n/2^k

    n / 2 ^ k = 1
    n = 2 ^ k
    Log 2 (n) = Log 2 (2 ^ k) {take log on both sides}
    K = Log 2 (n) which is: O ( Log N )

     */

    public static void main( String[] args ) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }

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
}
