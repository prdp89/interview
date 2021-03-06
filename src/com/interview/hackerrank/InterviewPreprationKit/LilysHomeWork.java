package com.interview.hackerrank.InterviewPreprationKit;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
public class LilysHomeWork {

    public static void main( String[] args ) {
        //int[] a = {2, 5, 3, 1};

        //int[] a = {1,1,1,2,2};
        int [] a = {2,1,3,1,2};
        GfG g = new GfG();
        System.out.println(GfG.minSwaps(a));
    }

    static class GfG {
        // Function returns the minimum number of swaps
        // required to sort the array
        static int minSwaps( int[] arr ) {
            int n = arr.length;

            // Create two arrays and use as pairs where first
            // array is element and second array
            // is position of first element
            ArrayList<Pair> arrpos =
                    new ArrayList<Pair>();
            for (int i = 0; i < n; i++)
                arrpos.add(new Pair(arr[i], i));

            // Sort the array by array element values to
            // get right position of every element as the
            // elements of second array.
            arrpos.sort(( o1, o2 ) -> {
                // We can change this to make it then look at the
                // words alphabetical order
                // We can change this to make it then look at the
                // words alphabetical order
                return Integer.compare(o1.getKey(), o2.getKey());
            });

            // To keep track of visited elements. Initialize
            // all elements as not visited or false.
            Boolean[] vis = new Boolean[n];
            Arrays.fill(vis, false);

            // Initialize result
            int ans = 0;

            // Traverse array elements
            for (int i = 0; i < n; i++) {
                // already swapped and corrected or
                // already present at correct pos
                if (vis[i] || arrpos.get(i).getValue() == i)
                    continue;

                // find out the number of  node in
                // this cycle and add in ans
                int cycle_size = 0;
                int j = i;
                while (!vis[j]) {
                    vis[j] = true;

                    // move to next node
                    j = arrpos.get(j).getValue();

                    cycle_size++;
                }

                // Update answer by adding current cycle.
                if (cycle_size > 0) {
                    ans += (cycle_size - 1);
                }
            }

            // Return result
            return ans;
        }
    }

    static class Pair {
        int key;
        int value;

        public Pair( int key, int value ) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }
}
