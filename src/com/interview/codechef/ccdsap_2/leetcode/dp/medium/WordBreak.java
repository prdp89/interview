package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    //https://leetcode.com/problems/word-break/
    public static void main( String[] args ) {
        String sb = "leetcode";

        List<String> listStr = new ArrayList<>();
        listStr.add("leet");
        listStr.add("code");

        Set<String> set = new HashSet<>(listStr);

        System.out.println(recurse(sb, set));
    }

    //ref: https://leetcode.com/problems/word-break/discuss/169383/The-Time-Complexity-of-The-Brute-Force-Method-Should-Be-O(2n)-and-Prove-It-Below
    private static boolean recurse( String s, Set<String> set ) {

        int len = s.length();

        if (len == 0) { //if input string reaches zero length means it match with all set values
            return true;
        }

        for (int i = 1; i <= len; ++i) { //recur for Input string for each substrings

            if (set.contains(s.substring(0, i)) && recurse(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
}
