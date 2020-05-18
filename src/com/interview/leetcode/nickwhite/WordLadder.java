package com.interview.leetcode.nickwhite;

import java.util.*;

//Really classic N-way BFS traversal problem..
public class WordLadder {

    //https://leetcode.com/problems/word-ladder/
    public static void main( String[] args ) {
        String beginWord = "hit", endWord = "cog";

        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    //Runtime: 57 ms, faster than 61.26% of Java

    //After little modification by me: Runtime: 56 ms, faster than 63.31% of Java
    private static int ladderLength( String beginWord, String endWord, List<String> wordList ) {

        int levelLen = 1;
        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        int size = queue.size();

        while (!queue.isEmpty()) {

            //in RottenOranges example we do BFS in 4 directions
            // but here we can traverse in N direction like tree LevelOrderTraversal

            size--;
            // while (size-- > 0) {

            //For every string in Queue we have to find its match in Dictionary(wordlist)
            String str = queue.poll();
            if (str.equals(endWord))
                return levelLen;

            //For string STR we are finding its possible neighbours in WordList
            for (String neighbour : neighbour(str, set)) {
                queue.offer(neighbour);
            }
            // }

            if (size == 0) {
                levelLen++;
                size = queue.size();
            }
        }

        return 0;
    }

    private static List<String> neighbour( String str, HashSet<String> wordList ) {
        List<String> possibleStrings = new ArrayList<>();

        //for STR of length N : we are try'n to replace its each i'th char and finding in WordList
        //If that str exists in wordList we can do BFS with it later on..
        for (int i = 0; i < str.length(); i++) {

            char[] replaceIthChar = str.toCharArray();
            //looking for possible 26 chars we can replace
            for (char ch = 'a'; ch <= 'z'; ch++) {

                replaceIthChar[i] = ch;
                String replacedSTR = String.valueOf(replaceIthChar);

                //if word list contain this String then we do not want to revisit it..
                if (wordList.remove(replacedSTR))
                    possibleStrings.add(replacedSTR);
            }
        }

        return possibleStrings;
    }
}
