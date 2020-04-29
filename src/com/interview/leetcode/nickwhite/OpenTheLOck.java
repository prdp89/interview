package com.interview.leetcode.nickwhite;

import java.util.*;

public class OpenTheLOck {

    //https://leetcode.com/problems/open-the-lock/
    public static void main( String[] args ) {
        String[] deadEnds = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        String target = "8888";

        System.out.println(openLock(deadEnds, target));
    }

    //almost similar to com.interview.leetcode.nickwhite.WordLadder
    private static int openLock( String[] deadends, String target ) {

        HashSet<String> wordList = new HashSet<>(Arrays.asList(deadends));

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        //visited set is necessary
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {

                String str = queue.poll();

                if (wordList.contains(str)) {
                    continue;
                }

                if (str.equals(target))
                    return level;

                for (String neighbour : findNeighbours(str, wordList, visited)) {
                    queue.offer(neighbour);
                }
            }

            level++;
        }

        return -1;
    }

    private static List<String> findNeighbours( String str, HashSet<String> wordList, Set<String> visited ) {
        List<String> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < 4; i++) {
            char c = sb.charAt(i);

            String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
            String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);

            if (!wordList.contains(s1) && !visited.contains(s1)) {
                res.add(s1);
                visited.add(s1);
            }

            if (!wordList.contains(s2) && !visited.contains(s2)) {
                res.add(s2);
                visited.add(s2);
            }
        }

        return res;
    }
}
