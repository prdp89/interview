package com.interview.leetcode.contests.biweekly.contest28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class OverlappingSubArray {

    //https://leetcode.com/contest/biweekly-contest-28/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
    public static void main( String[] args ) {
        int[] arr = {3,1,1,1,5,1,2,1};
        int target = 3;

        System.out.println(minSumOfLengths(arr, target));
    }

    private static int minSumOfLengths( int[] arr, int target ) {
        int j = 0, i = 0, sum = 0;

        List<Integer> list = new ArrayList<>();

        PriorityQueue<int[]> listList = new PriorityQueue<int[]>(( a, b ) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        HashMap<Integer, Integer> map = new HashMap<>();

        while (j < arr.length) {

            sum += arr[j];
            list.add(j);

            while (sum == target) {

                sum -= arr[i];
                i++;

                map.put(list.size(), map.getOrDefault(list.size(), 0) + 1);

                listList.add(new int[]{list.size(), map.get(list.size())});

                list.clear();
                list = new ArrayList<>();

            }

            if (sum > target)
                sum = 0;

            j++;
        }

        if (listList.size() == 0)
            return -1;

        int count = 1;
        int[] item = listList.poll();

        int freq = item[1];

        while (!listList.isEmpty() && listList.poll()[1] == freq) {
            count++;
            //listList.poll();
        }
        return count;
    }
}
