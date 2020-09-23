package com.interview.leetcode.contests._new_weekely.weekely207;

import java.util.HashSet;
import java.util.Set;

public class SplitStringMaxNumber {

    //https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
    //https://leetcode.com/contest/weekly-contest-207/problems/split-a-string-into-the-max-number-of-unique-substrings/
    public static void main( String[] args ) {
        String str = "aa";
        System.out.println(maxUniqueSplit(str));
        System.out.println(maxUniqueSplit_optimal(str));
    }

    //82 / 95 test cases passed.
    private static int maxUniqueSplit( String s ) {
        Set<String> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i) + "")) {
                set.add(s.charAt(i) + "");
            } else if (sb.length() > 0 && !set.contains(sb.toString())) {
                set.add(sb.toString());
                sb = new StringBuilder();
                sb.append(s.charAt(i));
            } else {
                sb.append(s.charAt(i));
            }
        }

        set.add(sb.toString());
        return set.size();
    }

    //https://www.youtube.com/watch?v=KAoRNDx-S8M&feature=youtu.be&t=0
    private static int maxUniqueSplit_optimal( String s ) {
        return dfs(s, new HashSet<>());
    }

    private static int dfs( String s, HashSet<String> set ) {
        int max = 0;

        for (int i = 1; i <= s.length(); i++) {
            String candidate = s.substring(0, i);

            if (!set.contains(candidate)) {
                set.add(candidate);
                max = Math.max(max, 1 + dfs(s.substring(i), set));

                //backtrack
                set.remove(candidate);
            }
        }

        return max;
    }
}
