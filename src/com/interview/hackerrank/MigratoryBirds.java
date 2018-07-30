package com.interview.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class MigratoryBirds {

    private static void solve() {
        int[] ar = {1, 4, 4, 4, 5, 3};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < ar.length; i++) {

            if (map.containsKey(ar[i])) {
                map.put(ar[i], map.get(ar[i]) + 1);
            } else
                map.put(ar[i], 1);
        }

        int maxValue = 0, maxKey = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (value > maxValue){
                maxValue = value;
                maxKey = key;
            }
        }

        if(maxKey != 0)
        System.out.println(maxKey);
    }

    //instead of HashMap just maintain a frequecy array
    /*
    int[] types = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            types[arr_i] = in.nextInt();
        }
        int[] frequencies = new int[6]; //A
        for (int i = 0; i < types.length; i++) { //B
            frequencies[types[i]] += 1; //C
        }
        int mostCommon = 0;
        for (int i = 1; i < frequencies.length; i++) { //D
            if (frequencies[mostCommon] < frequencies[i]) {
                mostCommon = i; //E
            }
        }
        System.out.println(mostCommon);
     */

    //https://www.hackerrank.com/challenges/migratory-birds/problem
    public static void main( String[] args ) {
        solve();
    }
}
