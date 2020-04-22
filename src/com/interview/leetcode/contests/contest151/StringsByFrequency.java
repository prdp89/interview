package com.interview.leetcode.contests.contest151;

import java.util.Arrays;

public class StringsByFrequency {

    //https://leetcode.com/contest/weekly-contest-151/problems/compare-strings-by-frequency-of-the-smallest-character/
    public static void main( String[] args ) {
        /*String[] query = {"bbb", "cc"};
        String[] freq = {"a", "aa", "aaa", "aaaa"};*/

        String[] query = {"cbd"};
        String[] freq = {"zaaaz"};

        System.out.println(Arrays.toString(numSmallerByFrequency(query, freq)));
    }

    private static int freq( String str ) {
        int minChar = Integer.MAX_VALUE, freq = -1;
        for (int i = 0; i < str.length(); i++) {
            minChar = Math.min(minChar, str.charAt(i));
        }

        Character ch = (char) minChar;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch)
                freq++;
        }

        return freq;
    }

    private static int[] numSmallerByFrequency( String[] queries, String[] words ) {

        int[] qFreq = new int[queries.length];
        int i = 0;
        for (String str : queries) {
            qFreq[i++] = freq(str);
        }

        int[] wFreq = new int[words.length];
        i = 0;
        for (String str : words) {
            wFreq[i++] = freq(str);
        }

        int[] res = new int[queries.length];
        for (int j = 0; j < qFreq.length; j++) {

            int total = 0;
            for (int k = 0; k < words.length; k++) {
                if (qFreq[j] < wFreq[k])
                    total++;
            }

            res[j] = total;
        }

        return res;
    }
}
