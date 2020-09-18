package com.interview.codechef.ccdsapfoundation_1.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class DIVSET {

    public static void main( String[] args ) {
        optimalSolution();
    }

    //based on editorial : https://discuss.codechef.com/t/divset-editorial/15796
    private static void optimalSolution() {
        try {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();

            while (t-- > 0) {
                  /*
                6 3 2
                4 1 2 2 3 1
                 */
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                int c = scanner.nextInt();

                long[] arr = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextLong();
                }

                Arrays.sort(arr);

                int start = 0, end = n / k + 1; //we have to choose K element from N size array;
                // max times we can choose is ; N=6 , k = 3; end = 6/3 +1 => 3

                while (end - start > 1) {

                    int mid = (start + end) / 2;

                    //This logic is somewhat similar to PIE problem in SPOJ
                    //if isPossible(mid) returns true then it is possible to make atleast 'mid' steps
                    if (isPossible(arr, mid, k, c)) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                }

                System.out.println(start);
            }
        } catch (Exception e){
            return;
        }
    }

    private static boolean isPossible( long[] arr, int mid, int k, int c ) {
        long[] range = new long[mid];

        int start = 0;
        int len = 1;

        //we need : a(i+1) >= ai * c or
        // a(i+1) / ai >= c
        for (long v : arr) {

            //arr : {1,1,2,2,3,4}
            //if range[0] = 1 then "v/range[start] >= c" check if next element is : ai*c atleast
            if (range[start] == 0 || v / range[start] >= c) {
                range[start++] = v;

                //start >= mid identify we successfully found one element out of K needed
                //so start start to zero : will find next valid element in next iteration
                //len++ : maintains valid K elements needed count
                if (start >= mid) {
                    start = 0;
                    len++;

                    //length greater than K length needed
                    if (len > k)
                        return true;
                }
            }
        }
        return false;
    }
}
