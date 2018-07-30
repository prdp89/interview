package com.interview.hackerrank;

public class SockMerchant {

    //https://www.hackerrank.com/challenges/sock-merchant/problem?h_r=next-challenge&h_v=zen
    private static void solve() {
        int ar[] = {10, 20, 20, 10, 10, 30, 50, 10, 20};

        int n = ar.length;
        int[] freq = new int[n + 1];

        for (int i = 0; i < n; i++) {
            freq[ar[i] % n]++;
        }

        int socksCount = 0;
        for (int i = 0; i < freq.length; i++) {

            if (freq[i] != 0) {
               // socksCount += freq[i] / 2; or
                socksCount += freq[i] >> 1;
            }
        }

        System.out.println(socksCount);
    }

    public static void main( String[] args ) {
        solve();
    }
}
