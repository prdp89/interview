package com.interview.hackerrank.basicPractice;

public class ClimbingTheLeaderboard {

    private static void solve() {
        int[] scores = {100, 100, 50, 40, 40, 20, 10};
        int[] alice = {5, 25, 50, 120};

        int[] temp = new int[scores.length];

        int k = 0;
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] != scores[i + 1])
                temp[k++] = scores[i];
        }
        temp[k++] = scores[scores.length - 1];

        int lastFoundId = temp.length;
        for (int i = 0; i < alice.length; i++) {

            int j = 0, zeroCount = 0;
            for (; j < temp.length; j++) {

                if (temp[j] != 0 && alice[i] >= temp[j])
                    break;
                else if (temp[j] == 0)
                    zeroCount++;
            }

            if (j == temp.length)
                System.out.println((j - zeroCount) + 1);
            else
                System.out.println(j + 1);
        }
    }

    public static void main( String[] args ) {
        solve();
    }
}
