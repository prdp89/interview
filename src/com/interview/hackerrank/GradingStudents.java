package com.interview.hackerrank;

//https://www.hackerrank.com/challenges/grading/problem
public class GradingStudents {

    private static void solve() {
        int[] arr = {73,
                67,
                38,
                33};

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < 38) {
                System.out.println(arr[i]);
            } else {

                int modValue = 5 - (arr[i] % 5);
                int nextMultiple = arr[i] + modValue;

                if (nextMultiple - arr[i] < 3)
                    System.out.println(nextMultiple);
                else
                    System.out.println(arr[i]);
            }
        }
    }

    public static void main( String[] args ) {
        solve();
    }
}
