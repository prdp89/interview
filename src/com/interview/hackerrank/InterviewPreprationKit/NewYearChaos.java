package com.interview.hackerrank.InterviewPreprationKit;

public class NewYearChaos {

    //solution: https://www.hackerrank.com/challenges/new-year-chaos/forum
    //Question:  https://www.hackerrank.com/challenges/new-year-chaos/problem
    private static void optimalSolve() {

        int q[] = {2, 1, 5, 3, 4};

        int ans = 0;
        for (int i = q.length - 1; i >= 0; i--) {

            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            //this loop is just like bubble sort inner loop.
            for (int j = Math.max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i]) ans++;
        }

        System.out.println(ans);
    }

    public static void main( String[] args ) {
        optimalSolve();
    }
}
