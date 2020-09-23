package com.interview.leetcode.contests.biweekly.biweekely35a;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SumOddLengthArrays {

    //https://leetcode.com/contest/biweekly-contest-35/problems/sum-of-all-odd-length-subarrays/
    public static void main( String[] args ) {
        int[] arr = {1, 4, 2, 5, 3};
        System.out.println(sumOddLengthSubarrays(arr));
    }

    //TODO: Use sliding Window tech:https://leetcode.com/problems/sum-of-all-odd-length-subarrays/discuss/854400/Java-or-Sliding-Window
    private static int sumOddLengthSubarrays( int[] arr ) {
        Deque<Integer> q = new LinkedList<>();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            //System.out.println(sum);

            q.offer(arr[i]);

            if (q.size() == 3) {
                List<Integer> list = new ArrayList<>();
                int n = q.size();
                while (n-- > 0) {
                    sum += q.peek();

                    //System.out.println(sum);

                    list.add(q.poll());
                }
                q = new LinkedList<>(list);
                q.poll();
            }
        }

        while (!q.isEmpty())
            sum += q.poll();

        return sum;
    }
}
