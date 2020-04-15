package com.interview.leetcode.thirtydayschallenge;

public class CountingElements {

    //https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/
    public static void main( String[] args ) {
        int[] arr = {1, 1, 2};

        System.out.println(countElements(arr));
    }

    private static int countElements( int[] arr ) {
        int[] count = new int[1001];

        for (int anArr : arr) {
            count[anArr]++;
        }

        int sum = 0;
        for (int i = 1; i < count.length; i++) {
          /*  if (count[i - 1] <= count[i] && count[i - 1] >= 1 && count[i] >= 1)
                sum += count[i - 1];
            else if (count[i - 1] > count[i] && count[i - 1] >= 1 && count[i] >= 1) {
                sum += (count[i - 1]);
            }*/

            if (count[i - 1] >= 1 && count[i] >= 1)
                sum += count[i - 1];
        }

        return sum;
    }
}
