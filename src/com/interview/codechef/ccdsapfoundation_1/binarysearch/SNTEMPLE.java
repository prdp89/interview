package com.interview.codechef.ccdsapfoundation_1.binarysearch;

import java.util.Scanner;

public class SNTEMPLE {
    //https://www.codechef.com/problems/SNTEMPLE

    public static void main( String[] args ) {
        // bruteForce();
        optimalSolution();
    }

    private static void optimalSolution() {
        try {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();
                int[] arr = new int[n];

                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                }

                int[] left = new int[n];
                left[0] = Math.min(1, arr[0]); //temple heightONOde should start from less than or equals to 1

                // Now, for each index i calculate the maximum heightONOde of a left-triangle whose highest point is i
                for (int i = 1; i < n; i++) {

                    //so next block heightONOde should one one greater than previous or current; whatever is less
                    left[i] = Math.min(left[i - 1] + 1, arr[i]);
                }

                int[] right = new int[n];
                right[n - 1] = Math.min(1, arr[n - 1]);

                // Now, for each index i calculate the maximum heightONOde of a right-triangle whose highest point is i
                for (int j = n - 2; j > 0; j--) {

                    //so next block heightONOde should one one greater than previous or current; whatever is less
                    right[j] = Math.min(right[j + 1] + 1, arr[j]);
                }

                int maxHeight = 0, sum = 0;
                //Then for each index i, the largest temple that has its peak at i is Min(L[i], R[i])
                //Math.Max : Max. value among all indices in complete array.
                for (int i = 0; i < n; i++) {
                    maxHeight = Math.max(maxHeight, Math.min(left[i], right[i]));
                    sum += arr[i];
                }

                //maxheight  : is the largest temple heightONOde

                System.out.println(sum - (maxHeight * maxHeight));

            }
        } catch (Exception e) {
            return;
        }
    }

    //fail most of the test cases
    private static void bruteForce() {
        //1 2 1  shape :  _/\_                 /\
        //1 2 6 2 1 : 1 2 3 2 1      shape : _/  \_

        try {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();

            while (t-- > 0) {

                int n = scanner.nextInt();
                int[] arr = new int[n];

                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                }

                int prev = arr[0];
                long total = 0;
                for (int i = 1; i < n; i++) {
                    if (arr[i] - prev > 1) {
                        total += prev + 1;
                        prev = prev + 1;
                    }
                    if (arr[i] - prev == 0) {
                        total++;
                        prev = arr[i];
                    } else
                        prev = arr[i];
                }

                System.out.println(total);
            }
        } catch (Exception e) {
            return;
        }
    }
}
