package com.interview.leetcode.thirtydayschallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SingleDuplicateNum {

    //https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3283/
    public static void main( String[] args ) {
        int[] arr = {2, 2, 1};
        System.out.println(solve(arr));

        /*Scanner in = new Scanner(System.in);
        String S1 = in.next();
        String S2 = in.next();

        if (S1.length() != S2.length())
            System.out.println(0);
        else {
            HashMap<Character, Integer> set = new HashMap<>();
            for (Character character : S1.toCharArray()) {
                set.put(character, set.getOrDefault(character, 0) + 1);
            }

            for (Character character : S2.toCharArray()) {
                if (!set.containsKey(character) && set.get(character) == 0) {
                    System.out.println(0);
                    return;
                } else {
                    set.put(character, set.get(character) - 1);
                }
            }

            System.out.println(1);

        }*/
    }


    //beat 21% of java submissio
    private static int solve( int[] arr ) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int anArr : arr) {
            map.put(anArr, map.getOrDefault(anArr, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() == 1)
                return entry.getKey();
        }

        return -1;
    }

    /*
    Concept

    a XOR a = 0
    a XOR 0 = a
    a XOR a XOR b => 0 XOR b => b
     */

    private int singleNumberOptimal( int[] nums ) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
