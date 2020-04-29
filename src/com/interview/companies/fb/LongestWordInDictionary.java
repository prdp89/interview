package com.interview.companies.fb;

import java.util.LinkedList;
import java.util.Queue;

public class LongestWordInDictionary {

    private static TrieNode root = new TrieNode();

    //https://leetcode.com/problems/longest-word-in-dictionary/
    public static void main( String[] args ) {
        String[] str = {"w", "wo", "wor", "worl", "world"};

        System.out.println(longestWord(str));
    }

    //REad StreamOfCharacters first to understand TRIE
    //Runtime: 6 ms, faster than 90.25% of Java
    private static String longestWord( String[] words ) {
        for (String str : words) {
            createTrie(str);
        }

        return bfs();
    }

    //BFS like N way search
    private static String bfs() {
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(root);

        String res = "";

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {

                TrieNode node = queue.poll();

                //consider NODE level may have 26 different children..
                //we have to start from 25th level, reason:
                //1. It is optimal to start from deepest node of ROOT
                //2. Anyways we are covering by level, if anything doesn't match, we can level up later on.
                for (int i = 25; i >= 0; i--) {

                    //here we cannot search like StreamOfCharacters, bcz in that program we know what ? to search
                    //and in this we are searching each level by level.

                    if (node.next[i] != null && node.next[i].isWord) {
                        //if (node.next[i].word.length() > res.length()) //no need of this condition..
                        {
                            res = node.next[i].word;
                            queue.offer(node.next[i]);
                        }
                    }
                }
            }
        }

        return res;
    }

    private static void createTrie( String word ) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (node.next[ch - 'a'] == null) {
                node.next[ch - 'a'] = new TrieNode();
            }

            node = node.next[ch - 'a'];
        }
        node.word = word;
        node.isWord = true;
    }

    private static class TrieNode {
        boolean isWord;
        String word;
        TrieNode[] next = new TrieNode[26];
    }
}
