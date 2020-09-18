package com.interview.codechef.ccdsapfoundation_1.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class NOTATRI {

    //https://www.spoj.com/problems/NOTATRI/

    public static void main( String[] args ) {
        solve();
        solveAgain();
    }

    //using upper bound
    private static void solveAgain() {
        try {
            Scanner scanner = new Scanner(System.in);
            for (; ; ) {
                int n = scanner.nextInt();

                if (n == 0)
                    break;

                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                }

                Arrays.sort(arr);

                int ans = 0;
                for (int i = 0; i < n - 2; i++) {

                    for (int j = i + 1; j < n - 1; j++) {

                        ans += arr.length - bs_upper_bound(arr, arr.length, arr[i] + arr[j]);
                    }
                }

                System.out.println(ans);
            }
        } catch (Exception e) {
            return;
        }
    }

    //upper bound is last occurance of element x in an array
    private static int bs_upper_bound( int a[], int n, int x ) {
        int l = 0;
        int h = n; // Not n - 1
        while (l < h) {
            int mid = (l + h) / 2;
            if (x >= a[mid]) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }

   /*  private static int firstOccurance( int[] a, int n, int key ) {

        int resIndex = -1, start = 0, end = n;

        while (start <= end) {

            int midIndex = (start + end) / 2;

            //little change in this part, bcz we need to search in left part for first occurance
            if(a[midIndex] == key){
                resIndex = midIndex;
                end = midIndex - 1;
            }
            else if (a[midIndex] > key) { //key <= a[midIndex]
                end = midIndex - 1;
            }else
                start = midIndex + 1;
            }
        return resIndex;
    }*/

    //using plain binary search //easy one
    private static void solve() {
        try {
            Scanner scanner = new Scanner(System.in);
            for (; ; ) {
                int n = scanner.nextInt();

                if (n == 0)
                    break;

                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                }

                Arrays.sort(arr);

                int first, end, ans = 0;
                for (int i = n - 1; i >= 2; i--) {

                    first = 0;
                    end = i - 1;
                    //Comparing : Arr[0] + Arr[n-2] < Arr[n-1]
                    //{2, 5, 6, 9}
                    //if 2 + 6 < 9 then ans = 2 - 0 = 2
                    while (first < end) {

                        if (arr[first] + arr[end] < arr[i]) {
                            ans += end - first;
                            first++;
                        } else {
                            end--;
                        }
                    }
                    System.out.println(ans);
                }
            }
        } catch (Exception e) {
            return;
        }
    }
}
