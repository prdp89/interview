package com.interview.codechef.ccdsapfoundation_1.greedy;


import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

//https://www.codechef.com/problems/STICKS
public class STICKS {

    public static void main( String[] args ) {
        solve();
        solveOtpimal();
    }

    private static void solveOtpimal() {

        try {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();

                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                }

                Arrays.sort(arr);

                int i = arr.length - 1;

                while (i - 1 >= 0 && arr[i] != arr[i - 1])
                    i--;

                if (i == 0) {
                    System.out.println(-1);
                    continue;
                }

                int max = arr[i];
                i -= 2;

                while (i - 1 >= 0 && arr[i] != arr[i - 1])
                    i--;

                if (i <= 0) {
                    System.out.println(-1);
                    continue;
                }

                int max2 = arr[i];
                System.out.println(max * max2);
            }
        } catch (Exception e) {
            return;
        }
    }

    //logic is correct, not passing all test cases
    private static void solve() {
        try {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();

                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                }

                TreeMap<Integer, Integer> map = new TreeMap<>();
                for (int i = 0; i < n; i++) {
                    map.compute(arr[i], ( key, value ) -> {

                        if (value == null)
                            return 1;
                        else {
                            return value + 1;
                        }

                    });
                }

                int max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

                int area1 = 0, area2 = 0;

                for (int i = n - 1; i >= 0; i--) {

                    if (map.get(arr[i]) > 1 && map.get(arr[i]) > max) {
                        max = map.get(arr[i]);

                        map.put(arr[i], -1);

                        area2 = area1;
                        area1 = arr[i];

                    } else if (map.get(arr[i]) > 1) {
                        max2 = map.get(arr[i]);

                        map.put(arr[i], -1);

                        area2 = arr[i];
                    }
                }


                int ans = -1;
                if (area1 * area2 > 0)
                    ans = area1 * area2;

                System.out.println(ans);
            }
        } catch (Exception w) {
            return;
        }
    }
}
