package com.interview.leetcode.contests.biweekly.biweekely17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecompressList {

    //https://leetcode.com/contest/biweekly-contest-17/problems/decompress-run-length-encoded-list/
    public static void main( String[] args ) {
        int[] num = {42, 39};
        System.out.println(Arrays.toString(decompressRLElist(num)));
    }

    /*
    Runtime: 3 ms
    Memory Usage: 40.4 MB
     */
    private static int[] decompressRLElist( int[] nums ) {
        List<Integer> list = new ArrayList<>();

        int j = 0;
        while (j + 1 < nums.length) {

            int freq = nums[j];
            int val = nums[j + 1];

            while (freq-- > 0) {
                list.add(val);
            }

            j += 2;
        }

        int[] temp = new int[list.size()];
        for (int k = 0; k < list.size(); k++)
            temp[k] = list.get(k);

        return temp;
    }
}
