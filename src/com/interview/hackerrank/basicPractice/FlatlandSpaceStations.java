package com.interview.hackerrank.basicPractice;

import java.util.Arrays;
import java.util.HashSet;

public class FlatlandSpaceStations {

    //https://www.hackerrank.com/challenges/flatland-space-stations/problem
    public static void main( String[] args ) {
        solve();
    }

    /*

    I have considered distance between cities with space station only.

    Steps:

    1) Sort all space stations in asc order.
    2) Find distance between first city and first space station city. Lets call it max distance.
    3) Find middle distance between each space stations. i.e. (City2-City1)/2 ...City1 and City2 space stations
    4) Compare max and above found distance between each station. Mark it as max if it is greater than existing max value.
    5) Finally, find distance between last city to last city with station.
    7) If it is greater than existing max distance. Consider it as final max distance.

     */

    //This is an optimal solution :

    private static int optimalSolution( int[] arr, int n ) {
        Arrays.sort(arr);

        int maxDistance = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //step3:
            int distance = (arr[i] - arr[i - 1]) / 2;

            //step4:
            if (maxDistance < distance) maxDistance = distance;
        }

        //step5:
        int lastGap = (n - 1) - arr[arr.length - 1];

        //step6:
        return (lastGap < maxDistance) ? maxDistance : lastGap;
    }

    //------------only passing 10 test case--------------------
    private static void solve() {

       /* int n = 5, m = 2;
        int[] arr = {0, 4};*/

        int n = 6, m = 6;
        int[] arr = {0, 1, 2, 4, 3, 5};

        Arrays.sort(arr);
        HashSet<Integer> hashSet = new HashSet<>();

        for (int anArr : arr) {
            hashSet.add(anArr);
        }

        int dist[] = new int[n];
        int nearest = -1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            if (hashSet.contains(i)) {
                dist[i] = 0;
                nearest = i;
            } else if (!hashSet.contains(i + 1)) {
                dist[i] = i - nearest;
            } else {
                dist[i] = 1;
            }

            max = Math.max(max, dist[i]);
        }

        System.out.println(Arrays.toString(dist));
        System.out.println(max);
    }
}
