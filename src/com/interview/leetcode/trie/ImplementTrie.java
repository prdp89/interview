package com.interview.leetcode.trie;

public class ImplementTrie {

    private TrieNode root;

    private ImplementTrie() {
        root = new TrieNode();
    }

    //https://leetcode.com/explore/learn/card/trie/147/basic-operations/1047/
    public static void main( String[] args ) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");

        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false

        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");

        System.out.println(trie.search("app"));     // returns true
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert( String word ) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);
            if (node.next[ch - 'a'] == null) {
                node.next[ch - 'a'] = new TrieNode();
            }

            node = node.next[ch - 'a'];
        }

        node.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search( String word ) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);
            if (null == node.next[ch - 'a'])
                return false;

            node = node.next[ch - 'a'];

        }

        return node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith( String prefix ) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++) {

            char ch = prefix.charAt(i);
            if (null == node.next[ch - 'a'])
                return false;

            node = node.next[ch - 'a'];

        }

        return true;
    }

    private class TrieNode {
        boolean isWord;
        TrieNode[] next = new TrieNode[26];
    }
}
