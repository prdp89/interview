package com.interview.hackerrank.InterviewPreprationKit;

import java.util.HashMap;
import java.util.Map;

public class SherlockAndTheValidString {

    public static void main( String[] args ) {
        solve();
    }

    //https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
    //Optimal at first shot : Good job pardeep :D :P
    private static void solve() {
        //String s = "aabbcd";
        String s = "abccc";

        //String s = "abcdefghhgfedecba";
        //String s = "aabbccddeefghi";

        // String s = "abcc";

       // String s = "xxxaabbccrry";

        char[] arr = s.toCharArray();

        int[] freq = new int[26];

        for (char c : arr) {
            freq[c - 'a']++;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int occur : freq) {

            if (occur != 0) {
                int value = map.getOrDefault(occur, 0);
                if (value > 0)
                    map.put(occur, value + 1);
                else
                    map.put(occur, 1);
            }
        }

        int maxOccurance = 0, maxOccuranceKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxOccurance = Math.max(maxOccurance, entry.getValue());
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() == maxOccurance)
                maxOccuranceKey = entry.getKey();
        }

        int reps = 0;
        for (int occur : freq) {

            if (occur != 0) {
                if (occur < maxOccuranceKey && reps == 1) {
                    System.out.println("NO");
                    return;
                } else if (occur < maxOccuranceKey)
                    reps++;
                else if(occur - maxOccuranceKey >= 1){
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }
}
