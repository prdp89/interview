package com.interview.leetcode.nickwhite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinTimeDifference {

    //https://leetcode.com/problems/minimum-time-difference/
    public static void main( String[] args ) {
        List<String> list = new ArrayList<>(Arrays.asList("10:00am", "11:45pm", "5:00am", "12:01am"));
        System.out.println(findMinDifference(list));
    }

    private static int findMinDifference( List<String> timePoints ) {


        boolean[] mark = new boolean[24 * 60]; //24 hour * 60 minutes

        List<Integer> timeList = new ArrayList<>();

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (String time : timePoints) {
            String[] t = time.split(":");

            int h = Integer.parseInt(t[0]);

            int m = Integer.parseInt(t[1].substring(0, 2));//Integer.parseInt(t[1]);

           /* boolean isPM = t[1].substring(2).equalsIgnoreCase("pm");

            if (isPM) {
                h += 12;
            }*/

            if (mark[h * 60 + m]) {
                return 0;
            }

            min = Math.min(min, h * 60 + m);
            max = Math.max(max, h * 60 + m);

            mark[h * 60 + m] = true;

            //timeList.add(h * 60 + m);
        }

        int minDiff = Integer.MAX_VALUE, prev = 0;

        for (int i = min; i <= max; i++) {   //set the range from min to max as an optimization.

            if (mark[i]) {

                if (i == min) {
                    //the min and max is the special case, it looks like :
                    //0---min----max-----1440, so we have two directions to calculate the distance
                    minDiff = Math.min(minDiff, Math.min(max - min, 1440 - max + min));
                } else {
                    //normal case: just one direction.
                    minDiff = Math.min(minDiff, i - prev);
                }

                prev = i;
            }
        }

        return minDiff;
    }
}
