package com.interview.codechef.ccdsapfoundation_1.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MMPROD {

    //https://www.codechef.com/SNCKPB16/problems/MMPROD
    public static void main( String[] args ) {
        //  solves();
        solveOPtimal();
    }

    private static void solveOPtimal() {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();

                long[] arr = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextLong();
                }

                long mod = 1000000007;
                Arrays.sort(arr);

                long prod = 1;
                int j = 0;
                int i = n - 1;

                //if all numbers are negative and K elements are odd.
                if (arr[n - 1] < 0 && k % 2 != 0) {

                    int kj = n - 1;

                    while (k != 0) {
                        prod = (prod * arr[kj]) % mod;
                        kj--;
                        k--;
                    }
                }

                while (k != 0) {

                    //if atleast two elements to multiply
                    if (k > 1 && arr[j] * arr[j + 1] > arr[i] * arr[i - 1]) {

                        prod = ((((arr[j] * arr[j + 1]) % mod) * prod) % mod);

                        j += 2;
                        k -= 2;
                    } else {

                        prod = (prod * arr[i]) % mod;

                        i--;
                        k--;
                    }
                }

                prod = (prod + mod) % mod;
                System.out.println(prod);
            }
        } catch (Exception e) {
            return;
        }
    }

    //The logic is correct, pass some test cases..
    private static void solves() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        long mod = 1000000007;
        Arrays.sort(arr);

        long prod1, prod2 = 0;
        prod1 = arr[0] % mod;
        for (int i = 1; i < k; i++) {
            prod1 *= (arr[i]);
            prod1 %= mod;
        }

        prod2 = arr[n - 1] % mod;
        int i = n - 2;
        i--;
        for (; i >= k; i--) {
            prod2 *= (arr[i]);
            //prod2 %= mod;
        }

        long ans = Math.max(prod1, prod2) < 0 ? Math.max(prod1, prod2) + mod : Math.max(prod1, prod2);
        System.out.println(ans % mod);
    }
}
