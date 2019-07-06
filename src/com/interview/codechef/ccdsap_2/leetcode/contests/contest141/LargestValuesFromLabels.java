package com.interview.codechef.ccdsap_2.leetcode.contests.contest141;

import java.util.*;

public class LargestValuesFromLabels {

    //https://leetcode.com/contest/weekly-contest-141/problems/largest-values-from-labels/
    /*
    Actually what we need to figure out is the meaning of num_wanted and use_limit.
    Num_wanted means the number of elements you can use in List.
    Use_limit means the number of elements you can you use with the the same label such as 1,
     */

    public static void main( String[] args ) {
        int[] values = {5, 4, 3, 2, 1};
        int[] labels = {1, 1, 2, 2, 3};

        int numWanted = 3, uselimit = 1;

        System.out.println(largestValsFromLabels(values, labels, numWanted, uselimit));
    }

    //I am trying to prevent labels repeat acc. to useLimit;
    //but problem is I have taken labels[i] as key which means when limit increase we have to repeat labels, so this strategy won't work
    private static void method_1( int[] labels, int[] values, int numWanted, int uselimit ) {
        HashMap<Integer, LabeleValues> hashMap = new HashMap<>();
        for (int i = 0; i < labels.length; i++) {

            if (!hashMap.containsKey(labels[i]) || hashMap.get(labels[i]).labelsCount < uselimit) {
                hashMap.put(labels[i], hashMap.getOrDefault(labels[i], new LabeleValues(hashMap.get(labels[i]) == null ? 0 : hashMap.get(labels[i]).labelsCount + 1, values[i])));
            }
        }
    }

    //logic is somewhat similar to ReorganizeString
    private static int largestValsFromLabels( int[] values, int[] labels, int num_wanted, int use_limit ) {

        List<int[]> pairs = new ArrayList<>();

        // Labels and their corresponding number of items.
        Map<Integer, Integer> limits = new HashMap<>();

        for (int i = 0; i < labels.length; i++) {

            //storing every label in to the hashmap with zero as limit
            if (!limits.containsKey(labels[i])) {
                limits.put(labels[i], 0);
            }

            //pairs store each label with adjacent value
            pairs.add(new int[]{values[i], labels[i]});
        }

        //sorting acc. to values {high to low}
        PriorityQueue<int[]> pq = new PriorityQueue<>(( o1, o2 ) -> o2[0] - o1[0]);

        int max = 0;

        pq.addAll(pairs);

        // The number of items in the set may less than num_wanted.
        for (int i = 0; i < num_wanted && !pq.isEmpty(); ) {

            //getting highest value from PQ
            int[] pair = pq.remove();

            //if limit doesn't reaches for that labels use it and increase it usage
            if (limits.get(pair[1]) < use_limit) {

                max += pair[0];

                limits.put(pair[1], limits.get(pair[1]) + 1);

                i++;
            }
        }
        return max;
    }

    static class LabeleValues {

        private int labelsCount;
        private int values;

        LabeleValues( int labelsCount, int values ) {
            this.labelsCount = labelsCount;
            this.values = values;
        }
    }
}
