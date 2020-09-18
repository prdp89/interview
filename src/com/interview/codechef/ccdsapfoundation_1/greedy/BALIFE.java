package com.interview.codechef.ccdsapfoundation_1.greedy;

import java.util.Scanner;

public class BALIFE {

    //https://www.spoj.com/problems/BALIFE/
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        try {
            Scanner scanner = new Scanner(System.in);

            for (; ; ) {
                int n = scanner.nextInt();

                if (n == -1)
                    break;

                long sum = 0, avg;

                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                    sum += arr[i];
                }

                avg = sum / n;
                if (avg * n != sum) {
                    System.out.println("-1");
                    continue;
                }

        /*
        from each job a[i] do a[i] - avg. if a[i] is +ve it means it has to export this many jobs
        to neighbors and -ve means it has to import this may jobs from neighbors .
         */

                //step 1:
                for (int i = 0; i < n; i++) {
                    arr[i] -= avg;
                }

        /*

        lets say a[i] after performing step 1 is: [ 2 ,-5, 7, -4]

        after performing step 2 array will become [2, -3, 4, 0]

        what it means is that first processor has 2 extra jobs and it can export it in 2 round.

        2nd processor has 5 jobs to import. It can take 2 from 1st processor, it has still 3
        more to import. and it can be done in 3 rounds.

        3rd processor has 7 jobs to export. It can export 3 to previous processor in 3 round and it
        has remaining 4 jobs, which can be exported in 4 rounds to the next processor.

        4th processor has to import 4 jobs and it can import it from previous processor in 4 rounds.
        Hence max rounds is the max absolute value from a[i].

        */
                for (int i = 1; i < n; i++) {
                    arr[i] += arr[i - 1];
                }

                long max = 0;
                for (int i = 0; i < n; i++) {

                    if (max < Math.abs((arr[i]))) {
                        max = Math.abs(arr[i]);
                    }
                }

                System.out.println(max);
            }
        } catch (Exception e) {
            return;
        }
    }
}
