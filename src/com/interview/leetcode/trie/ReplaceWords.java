package com.interview.leetcode.trie;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {

    private static TrieNode root = new TrieNode();

    //https://leetcode.com/problems/replace-words/
    public static void main( String[] args ) {
        List<String> list = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";

        System.out.println(replaceWords(list, sentence));
    }

    //Runtime: 7 ms, faster than 90.72% of Java
    private static String replaceWords( List<String> dict, String sentence ) {
        TrieNode node = root;

        for (String str : dict) {
            createTrie(root, str);
        }

        String[] strs = sentence.split(" ");
        int i = 0;

        for (String str : strs) {
            strs[i++] = search(str, node);
        }

        return String.join(" ", strs);
    }

    //in comparison with AddSearchWord: In this problem we don't need BFS bcz we are searching for Min. string from
    //                                  the sentence in dict.(Trie).
    private static String search( String str, TrieNode node ) {

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            //if character we are searching not present in TRIE, return the complete word. eg: 'the'
            if (node.next[ch - 'a'] == null)
                return str;

            //return Min. prefix of searching STR
            if (node.next[ch - 'a'].isWord)
                return str.substring(0, i + 1);

            node = node.next[ch - 'a'];
        }

        return str;
    }

    private static void createTrie( TrieNode node, String str ) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (node.next[ch - 'a'] == null)
                node.next[ch - 'a'] = new TrieNode();

            node = node.next[ch - 'a'];
        }

        node.isWord = true;
        node.word = str;
    }

    private static class TrieNode {
        boolean isWord;
        String word;
        TrieNode[] next = new TrieNode[26];
    }
}
