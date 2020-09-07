package com.interview.leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumWithSameConseDiff {

    //https://leetcode.com/problems/numbers-with-same-consecutive-differences/
    public static void main( String[] args ) {
        int N = 3, K = 7;

        System.out.println(Arrays.toString(numsSameConsecDiff(N, K)));
    }

    //Runtime: 5 ms, faster than 45.28% of Java
    private static int[] numsSameConsecDiff( int N, int K ) {
        Queue<Integer> q = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        //loop until we get 3 digit nums
        while (N-- > 1) {

            int size = q.size();
            //we are looping until each queue element turns into 3 digit nums
            while (size-- > 0) {
                int num = q.poll();

                //only traverse when we have +ve num
                if (num > 0) {
                    //traversing in two direction at each level
                    int digit1 = num % 10 - K; //num = 9 then 9 % 10 - 7 => 2, so 92 has diff. of 7
                    int digit2 = num % 10 + K; //num = 2 then 2 % 10 + 7 ==> 9, so 29 has diff. of 7

                    if (digit1 >= 0) {
                        q.offer(num * 10 + digit1); //9*10 + 2 => 92
                    }

                    if (digit2 < 10 && digit1 != digit2) {
                        q.offer(num * 10 + digit2);
                    }
                }
            }
        }

        return q.stream().mapToInt(i -> i).toArray();
    }
}
