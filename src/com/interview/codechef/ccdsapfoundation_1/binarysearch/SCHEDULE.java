package com.interview.codechef.ccdsapfoundation_1.binarysearch;

import java.util.Scanner;

public class SCHEDULE {

    //totally copied from : https://www.codechef.com/viewsolution/19050484
    public static void main( String[] args ) {

        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t > 0) {
            int n = scn.nextInt();
            int k = scn.nextInt();
            String str = scn.next();

            char[] arr = str.toCharArray();

            int ans;
            //if this k==0 return longest length present
            if (k == 0) {
                ans = longest(arr, n);
            }

            // that only k is enough to alternate everyone and give answer 1 as maximum block
            if (check(arr, k, n)) {
                ans = 1;
            } else {

                int low = 2;
                int high = n;
                int mid;
                ans = Integer.MAX_VALUE;

                while (low <= high) {
                    mid = (low + high) / 2;

                    if (solve(arr, mid, k, n)) {
                        ans = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }    //while
            }

            System.out.println(ans);
            t--;
        }
    }

    //didn't understood this method really well
    public static boolean solve( char[] arr, int mid, int k, int n ) {

        // assume swap required to maximium value as this is swap
        int swap = 0;
        int temp = 1;
        //for arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                temp++;

            } else {
                //swap between element is needed when prev and next are not same
                swap = swap + (temp / (mid + 1));
                temp = 1;// for this not matching new start
            }

        }

        swap = swap + (temp / (mid + 1));

        if (swap <= k) {
            return true;
        } else {
            return false;
        }
    }

    //here we are just flipping 1's or 0's acc to array index
    private static boolean check( char str[], int K, int N ) {

        int swaps1 = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                if (str[i] == '1')
                    swaps1++;
            } else {
                if (str[i] == '0')
                    swaps1++;
            }
        }

        //optimal solution : 101010101
        int swaps2 = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) { //it should be 0 else swap
                if (str[i] == '0')
                    swaps2++;
            } else {
                if (str[i] == '1')
                    swaps2++;
            }
        }

        int swaps = Math.min(swaps1, swaps2);
        if (swaps <= K)
            return true;
        else
            return false;
    }

    private static int longest( char[] input, int n ) {
        int len = 1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (input[i] == input[i - 1]) {
                len++;
            } else {
                max = Math.max(max, len);
                len = 1;
            }
        }
        return max;
    }
}
