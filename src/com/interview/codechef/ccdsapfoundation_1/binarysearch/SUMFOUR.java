package com.interview.codechef.ccdsapfoundation_1.binarysearch;

import java.util.HashMap;
import java.util.Scanner;

public class SUMFOUR {

    private static int[] e = new int[10000001];
    private static int[] f = new int[10000001];

    //passing 11 test cases :(
    public static void main( String[] args ) {

        try {
            //https://www.spoj.com/problems/SUMFOUR/

        /*
        The brute force solution is:
        count = 0
        for a in A:
          for b in B:
            for c in C:
              for d in D:
                if a + b + c + d == 0: count += 1
         */

            Scanner scanner = new Scanner(System.in);

            int[] a = new int[4000];
            int[] b = new int[4000];
            int[] c = new int[4000];
            int[] d = new int[4000];

            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                b[i] = scanner.nextInt();
                c[i] = scanner.nextInt();
                d[i] = scanner.nextInt();
            }

            int k = 0;
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    e[k++] = a[i] + b[j];
                }
            }

            // Arrays.sort(e);

            int l = 0;
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    f[l++] = (c[i] + d[j]) * -1;
                }
            }

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < l; i++) {
                //if (f[i] != 0)
                {
                    map.compute(f[i], ( key, val ) -> {
                        if (val == null) {
                            return 1;
                        } else {
                            return val + 1;
                        }
                    });
                }
            }

            long count = 0;
            for (int i = 0; i < k; i++) {

                if (map.containsKey(e[i])) {
                    count += map.get(e[i]);
                }
            }

            //  Arrays.sort(f);

        /*int size1, size2, temp, count = 0;
        for (int i = 0; i < l; ) {

            size1 = 0;
            temp = f[i];

            //checking repeated element in second array
            while (f[i] == temp && i < l) {
                size1++;
                i++;
            }

            //checking ith element repetition on first array.
            size2 = Arrays.binarySearch(e, temp);

            //total will max. arrangement of both
            count += size1 * size2;
        }*/

            System.out.println(count);
        } catch (Exception e) {
            return;
        }
    }
}
