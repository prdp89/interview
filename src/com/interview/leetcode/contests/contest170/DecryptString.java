package com.interview.leetcode.contests.contest170;

import java.util.HashMap;

public class DecryptString {

    //https://leetcode.com/contest/weekly-contest-170/problems/decrypt-string-from-alphabet-to-integer-mapping/#
    public static void main( String[] args ) {
        String str = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        System.out.println(freqAlphabets(str));
    }

    //put alot of hardwork..accepted
    /*
    40 / 40 test cases passed.
    Status: Accepted
    Runtime: 3 ms
     */
    private static String freqAlphabets( String s ) {
        HashMap<String, String> map = new HashMap<>();

        for (int i = 1; i <= 9; i++) {
            map.put(String.valueOf(i), String.valueOf((char) ('a' + i - 1)));
        }

        for (int i = 10; i <= 26; i++) {
            map.put(String.valueOf(i) + "#", String.valueOf((char) ('j' + i - 10)));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' || map.containsKey(String.valueOf(s.charAt(i)))) {
                if (s.charAt(i) == '0')
                    sb.append('0');
                else
                    sb.append(map.get(String.valueOf(s.charAt(i))));
            } else if (s.charAt(i) == '#') {
                String temp = s.substring(i - 2, i);
                sb.delete(sb.length() - 2, sb.length());
                sb.append(map.get(String.valueOf(temp + '#')));
            }
        }

        return sb.toString();
    }
}
