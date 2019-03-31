package com.interview.codingblocks.week10DivideAndConquer;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

    //https://www.youtube.com/watch?v=TC6snf6KPdE
    //https://www.spoj.com/problems/AGGRCOW/
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int numOfStalls = scanner.nextInt();
        int numOfCows = scanner.nextInt();

        int[] stalls = new int[numOfStalls];
        for (int i = 0; i < numOfStalls; i++)
            stalls[i] = scanner.nextInt();

        Arrays.sort(stalls);
        System.out.println(minCowDistance(stalls, numOfCows));
    }

    private static int minCowDistance( int[] stalls, int numOfCows ) {

        int start = 0, end = stalls[stalls.length - 1], ans = -1;

        while (end > start) {
            int mid = (start + end) / 2;

            if (isCowAdjustmentPossible(mid, stalls, numOfCows)) {

                if (mid > ans)
                    ans = mid;

                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return ans;
    }

    private static boolean isCowAdjustmentPossible( int mid, int[] stalls, int totalCows ) {
        int cows = 1, prevStall = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            //if next stall - prevstall >= mid : distance bw next and prev stall is atleast mid value
            if ((stalls[i] - prevStall) >= mid) {

                cows++;
                if (cows == totalCows)
                    return true;

                prevStall = stalls[i];
            }
        }
        return false;
    }
}
