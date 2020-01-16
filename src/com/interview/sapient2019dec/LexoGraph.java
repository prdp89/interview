package com.interview.sapient2019dec;

import java.util.*;

public class LexoGraph {

    public static void main( String[] args ) {
       /* String str = "ab", str1 = "ac", str2 = "aa";

        System.out.println(compareStrings(str, str1, str2));*/

        Integer[] arr = {8, 5, 11, 4, 6};

        //System.out.println(maximumSum(Arrays.asList(arr)));

        //System.out.println(moves(Arrays.asList(arr)));

        System.out.println(shortestSubstring("asdfkjeghfalawefhaef"));
    }

    //finding smallest lexographical strings
    private static String compareStrings( String firstString, String secondString, String thirdString ) {

        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.naturalOrder());

        pq.offer(firstString);
        pq.offer(secondString);
        pq.offer(thirdString);

        return pq.poll() + pq.poll() + pq.poll();
    }

    //maximum subset array sum
    //https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
    private static long maximumSum( List<Integer> arr ) {

        if (arr == null || arr.isEmpty())
            return 0;

        int n = arr.size();
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = arr.get(0);
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = arr.get(i) + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    //number of moves to rearange even on left and odd on right of the array
    public static int moves( List<Integer> a ) {

        int lo = 0;

        int hi = a.size() - 1;
        int temp, moves = 0;

        while (lo <= hi) {

            int val = a.get(lo);

            if (val % 2 != 0) {

                temp = a.get(lo);
                a.set(lo, a.get(hi));
                a.set(hi, temp);
                lo++;
                hi--;

                moves++;

            }

            lo++;
        }

        return moves;
    }

    //shortest substring containing all chars of a string
    //https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
    private static int shortestSubstring( String s ) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        int count = 0;

        int chars[] = new int[26];

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            if (entry.getValue() >= 1) {
                count++;
                chars[entry.getKey() - 'a'] = 1;
            }
        }

        for (int i = 0; i < s.length(); i++) {

            int val = Math.max(count, s.substring(i, s.length()).length());
            while (val-- > 0) {

            }
        }

        return count;
    }
}
