package com.interview.codechef.ccdsap_2.leetcode.contests.contest181;

public class SumOfDivisors {

    //https://leetcode.com/contest/weekly-contest-181/problems/four-divisors/
    public static void main( String[] args ) {
        int[] arr = {21, 4, 7};
        solve(arr);
    }

    //15/18 test cases passed
    private static void solve( int[] arr ) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            int j = 2, count = 1;
            int temp = 1;
            while (j <= (arr[i])) {

                if (arr[i] % j == 0) {

                    temp += j;
                    count++;
                }

                j++;
            }

            if (count == 4)
                sum += temp;
        }

        System.out.println(sum);
    }

    private static void solveOptimal( int[] arr ) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            int j = 2, count = 0;
            int temp = 1, lastDivisor = 0;
            while (j * j <= (arr[i])) {

                if (arr[i] % j == 0) {

                    temp += j;
                    count++;
                    lastDivisor = j;
                }

                //this number will surely have greater than 4 divisors
                if (count > 1)
                    break;

                j++;
            }

            //found excatly 4 divisors, if arr[i] : 21 then {1, 3} is computed above now,
            //arr[i] / lastDivisor = 7 is the third
            //arr[i] is the fourth :)
            if (count == 1 && lastDivisor != arr[i] / lastDivisor)
                sum += arr[i] / lastDivisor + arr[i] + temp;
        }

        System.out.println(sum);
    }
}
