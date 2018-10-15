package com.interview.hackerrank.InterviewPreprationKit;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountTriplets {

    //https://www.hackerrank.com/challenges/count-triplets-1/problem
    public static void main( String[] args ) {
        solve();
    }

    //This passed 11 out of 15 test cases.
    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); //array length

        int r = scanner.nextInt(); //ration

        //int[] arr = {1, 2, 2, 4};
        //int[] arr = {1, 3, 9, 9, 27, 81};
        int[] arr = {1, 5, 5, 25, 125};

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int num = arr[i];

            if (hashMap.containsKey(num)) {
                int value = hashMap.get(num);
                hashMap.put(num, value + 1);
            } else
                hashMap.put(num, 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {

            if (hashMap.containsKey(entry.getKey() * r) &&
                    hashMap.containsKey(entry.getKey() * r * r)) {

                int value = hashMap.get(entry.getKey());

                int value1 = hashMap.get(entry.getKey() * r);

                int value2 = hashMap.get(entry.getKey() * r * r);

                count += (value > 1 ? value : 0) + (value1 > 1 ? value1 : 0)
                        + (value2 > 1 ? value2 : 0);
            }
        }

        System.out.println(count);
    }
}