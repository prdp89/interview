package com.interview.codechef.ccdsapfoundation.arrays;

import java.util.Scanner;

public class SALARY {

    //https://www.codechef.com/problems/SALARY

    //Explaination of strategy:
    /*
    I did what the question said by increasing 1 to get all the salaries equal in an O(N) solution for each case.

    1.) Sort the list of salaries in increasing order.

    2.) In each step and starting from the last term I need to make seq[i - 1] = seq*. Each step needs
    (N - i) * (seq* - seq[i - 1]).

    The final answer becomes (seq[N - 1] - seq[N - 2]) + (2 * (seq[N - 2] - seq[N - 3]) + … + (N - 1) * (seq[1] - seq[0]).
     */
    public static void main( String[] args ) {

        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();

            while (t-- > 0) {
                //String[] parts = br.readLine().trim().split("\\s+"); // split on whitespace

                int n = scanner.nextInt();
                int arr[] = new int[n];
                int sum = 0, min = Integer.MAX_VALUE;

                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                    min = Math.min(min, arr[i]);

                    sum += arr[i];
                }

                System.out.println(sum - (n * min));
            }
        } catch (Exception e) {
            return;
        }
    }
}
