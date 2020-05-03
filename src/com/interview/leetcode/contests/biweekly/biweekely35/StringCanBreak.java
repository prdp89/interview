package com.interview.leetcode.contests.biweekly.biweekely35;

import java.util.HashMap;
import java.util.Map;

public class StringCanBreak {

    public static void main( String[] args ) {
        String s1 = "abc", s2 = "xya";

        System.out.println((checkIfCanBreak(s1, s2) || checkIfCanBreak(s2, s1)));
    }

    //solved it,..yeah
    //128 ms	69.6 MB
    private static boolean checkIfCanBreak( String s1, String s2 ) {

        if (s1.length() != s2.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s2.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : s1.toCharArray()) {

            char c = ch;
            while ((int) (c) <= 122 && !map.containsKey(c)) {
                c++;
            }

            if (map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) - 1);

                if (map.get(c) <= 0)
                    map.remove(c);
            }
        }

        return map.size() == 0;
    }

    //https://leetcode.com/problems/check-if-a-string-can-break-another-string/discuss/608728/Java-Maintain-a-count-array
    public boolean checkIfCanBreakOptimal( String s1, String s2 ) {
        int n = s1.length();
        int[] arr = new int[26], brr = new int[26];

        for (int i = 0; i < n; i++)
            arr[s1.charAt(i) - 97]++;

        for (int i = 0; i < n; i++)
            brr[s2.charAt(i) - 97]++;

        int count1 = 0, count2 = 0;

        boolean f1 = false, f2 = false;

        for (int i = 0; i < 26; i++) {
            count1 += arr[i];
            count2 += brr[i];

            if (count1 > count2) {
                if (f2) return false;
                f1 = true;
            } else if (count2 > count1) {
                if (f1) return false;
                f2 = true;
            }
        }
        return true;
    }
}
