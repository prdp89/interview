package com.interview.hackerrank.basicPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxOccuringChar {
    public static void main( String[] args ) {
        //solve();

        solveAgain();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.next().toCharArray();

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char value : s) {

            if (hashMap.containsKey(value)) {
                int count = hashMap.get(value);
                hashMap.put(value, count + 1);
            } else {
                hashMap.put(value, 1);
            }
        }


        int max = Integer.MIN_VALUE;
        char c = ' ';
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {

            max = Math.max(max, entry.getValue());
            c = entry.getKey();

            // System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }


        System.out.println(max);
    }

    private static void solveAgain() {

        int count[] = new int[256];
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        int len = str.length();
        for (int i = 0; i < len; i++)
            count[str.charAt(i)]++;

        int max = Integer.MIN_VALUE;
        char result = ' ';

        for (int i = 0; i < len; i++) {
            if (max < count[str.charAt(i)]) {
                max = count[str.charAt(i)];
                result = str.charAt(i);
            }
        }

        System.out.println(result);
    }
}
