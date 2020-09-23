package com.interview.leetcode.contests.biweekly.biweekely35a;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumDivisibleByK {

    //https://leetcode.com/problems/subarray-sums-divisible-by-k/
    public static void main( String[] args ) {
        int[] A = {4, 5, 0, -2, -3, 1};
        int k = 5;

        System.out.println(subarraysDivByK_way1(A, k));
        System.out.println(subarraysDivByK_way2(A, k));
    }

    //map[sum % k] exist then there are n*(n-1)/ 2 ways to group that subarray
    private static int subarraysDivByK_way1( int[] A, int K ) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0, sum = 0;

        for (int a : A) {
            sum = (sum + a) % K;

            if (sum < 0)
                sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4

            count += map.getOrDefault(sum, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    //https://leetcode.com/problems/subarray-sums-divisible-by-k/discuss/217962/Java-Clean-O(n)-Number-Theory-%2B-Prefix-Sums
    private static int subarraysDivByK_way2( int[] A, int K ) {
        int N = A.length;

        int[] modGroups = new int[K];

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += A[i];
            int group = sum % K;

            if (group < 0)
                group += K; //Java has negative modulus so correct it

            modGroups[group]++;
        }

        int total = 0;

        //each group num if exist more than once then n*(n-1)/2 ways to group the sub-array
        for (int x : modGroups) {
            if (x > 1) total += (x * (x - 1)) / 2;
        }

        //Dont forget all numbers that divide K
        return total + modGroups[0];
    }
}
