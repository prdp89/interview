package com.interview.leetcode.bfs;

import java.util.*;

public class WordBreak {

    //https://leetcode.com/problems/word-break/
    public static void main( String[] args ) {
        String str = "leetcode";

        List<String> list = new ArrayList<>(Arrays.asList("leet", "code"));


        System.out.println(wordBreak(str, list));
    }

    //one approach DP : com.interview.codechef.ccdsap_2.leetcode.dp.medium.WordBreak
    //https://leetcode.com/problems/word-break/discuss/43797/A-solution-using-BFS

    //Read solution of : vegito2002

    private static boolean wordBreak( String s, List<String> wordDict ) {
        int max_len = -1;

        for (String word : wordDict)
            max_len = Math.max(max_len, word.length());

        Set<String> wordDictSet = new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[s.length()];

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {

            int start = queue.remove();

            for (int end = start + 1; end <= s.length() && end - start <= max_len; end++) {

                if (wordDictSet.contains(s.substring(start, end)) && !(end < s.length() && visited[end])) {
                    if (end == s.length()) {
                        return true;
                    }

                    queue.add(end);
                    visited[end] = true;
                }
            }
        }

        return false;
    }
}
