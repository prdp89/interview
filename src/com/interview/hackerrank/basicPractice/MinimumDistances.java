package com.interview.hackerrank.basicPractice;

import java.util.HashMap;

public class MinimumDistances {

    //https://www.hackerrank.com/challenges/minimum-distances/
    private static void solve() {
        int arr[] = {7, 1, 3, 4, 1, 7};

        HashMap<Integer, Integer> minIndices = new HashMap<>();
        int minIndex = 0;
        boolean isFirstTime = false;

        for (int i = 0; i < arr.length; i++) {
            int lastMinIndex;
            if (minIndices.containsKey(arr[i])) {

                int value = minIndices.get(arr[i]);
                lastMinIndex = i - value;

                if (!isFirstTime) {
                    minIndex = lastMinIndex;
                    isFirstTime = true;
                }

                if (minIndex != 0 && lastMinIndex < minIndex)
                    minIndex = lastMinIndex;
            }

            minIndices.put(arr[i], i);
        }

        if (minIndex == 0)
            System.out.println(-1);
        else
            System.out.println(minIndex);
    }

    /*
    //----------------Almost similar code--------------------
    int minDist= Integer.MAX_VALUE;
    int n = in.nextInt();
    int[] arr = new int[n];
    for(int i=0; i < n; i++){
        arr[i] = in.nextInt();
        if(hm.containsKey(arr[i])) {
            int x=hm.get(arr[i]);
            int dist = i - x;
            if(dist < minDist) minDist = dist;
        }
        else hm.put(arr[i],i);
    }

     */

    public static void main( String[] args ) {
        solve();
    }
}
