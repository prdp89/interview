package com.interview.hackerrank.basicPractice;

import java.util.HashMap;
import java.util.Map;

//https://www.hackerrank.com/challenges/equality-in-a-array/
public class EqualizeTheArray {

    //this just failed 3 test cases..
    private static void solve() {
        //int[] arr = {3, 3, 2, 1, 3, 11, 15};
        int[] arr = {1, 2, 3, 2};

        int temp[] = new int[arr.length];

        //calculating occurrence of elements
        for (int anArr1 : arr) {
            temp[anArr1 % arr.length]++;
        }

       /* for (int i : temp) {
            System.out.print(i + " ");
        }*/

        //largest occurring element  = MAX
        int max = temp[0];
        for (int i = 1; i < temp.length; i++) {

            if (temp[i] > max)
                max = temp[i];
        }

       /* int count = 0;
        for (int anArr : temp) {
            if (anArr != max && anArr != 0)
                count += anArr;
        }*/

        System.out.println(arr.length - max);
    }

    //this is the most optimized solution................
    public static int minDeletions( int[] a ) {
        int max = 1;

        Map<Integer, Integer> nums = new HashMap<>();

        for (int i : a)

            if (!nums.containsKey(i))
                nums.put(i, 1);

            else {

                nums.put(i, nums.get(i) + 1);

                if (max < nums.get(i))
                    max = nums.get(i);
            }

        return a.length - max;
    }

    public static void main( String[] args ) {
        solve();
    }

}
