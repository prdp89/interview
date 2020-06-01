package com.interview.leetcode.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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



        return false;
    }
}
