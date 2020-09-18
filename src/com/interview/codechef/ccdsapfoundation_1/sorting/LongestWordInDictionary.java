package com.interview.codechef.ccdsapfoundation_1.sorting;

import java.util.ArrayList;
import java.util.List;

public class LongestWordInDictionary {

    //https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
    public static void main( String[] args ) {
        List<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");

        System.out.println(findLongestWord("abpcplea", list));
    }

    //region Method_1
    private static String findLongestWord( String s, List<String> d ) {

        //if Length is not same than sort acc to length else Order by smallest lexicographical order.
        d.sort(( a, b ) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) : a.compareTo(b));

        for (String dictWord : d) {
            int i = 0;

            //Now Dictionary is order by Length and lexico.
            //Any String that matches first will be the answer
            for (char c : s.toCharArray())
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;

            if (i == dictWord.length()) return dictWord;
        }
        return "";
    }
    //endregion

    //region Method_2

    //This method doesn't require sorting
    private static String findLongestWordOptimized( String s, List<String> d ) {
        String res = "";

        for (String w : d) {

            //if s matches current word of dictionary
            if (isSubsequence(w, s)) {

                if (w.length() > res.length())
                    res = w;

                //if length matches then compare lexico. order
                if (w.length() == res.length() && w.compareTo(res) < 0) res = w;
            }
        }
        return res;
    }

    private static boolean isSubsequence( String w, String s ) {
        char[] wc = w.toCharArray();
        char[] sc = s.toCharArray();

        int i = 0, j = 0;

        while (i < wc.length && j < sc.length) {
            if (wc[i] == sc[j]) i++;
            j++;
        }
        return i == wc.length;
    }
    //endregion
}
