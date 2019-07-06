package com.interview.codechef.ccdsap_2.leetcode.contests.contest142;

public class StatFromLargeData {

    public static void main( String[] args ) {
        int[] count = {0, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println(count); //op : {1.00000,3.00000,2.37500,2.50000,3.00000}
    }

    //https://leetcode.com/contest/weekly-contest-142/problems/statistics-from-a-large-sample/
    private static double[] sampleStats( int[] count ) {
        int total = 0, mode = 0;
        double median = 0, min = -1, max = 0, avg = 0, sum = 0;

        for (int i = 0; i < 256; ++i) {

            if (count[i] > 0) {
                //total count of items
                total += count[i];

                if (min < 0)
                    min = i;

                max = i;

                //current number multiply by number of times it occur
                sum += i * count[i];

                //MOD is that Number which occurs Max. number of times.
                if (count[i] > count[mode])
                    mode = i;
            }

        }

        avg = sum / total;

        if (total == 1) median = sum; // single element.

        int m1 = (total + 1) / 2, m2 = total / 2 + 1; // m1-th and m2-th items are medians.

        //didn't get the Median part from Count array
        for (int i = 0, cnt = 0; total > 1 && i < 256; ++i) { // more than 1 elements.
            if (cnt < m1 && cnt + count[i] >= m1) // find m1-th item.
                median += i / 2.0d; // add its half.
            if (cnt < m2 && cnt + count[i] >= m2) // find m2-th item.
                median += i / 2.0d; // add its half.
            cnt += count[i];
        }

        return new double[]{min, max, avg, median, mode};
    }
}