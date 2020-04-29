package com.interview.companies.fb;

public class StreamOfCharacters {

    private StringBuilder sb = new StringBuilder();
    private TrieNode root = new TrieNode();

    private StreamOfCharacters( String[] words ) {
        createTrie(words);
    }

    //https://leetcode.com/problems/stream-of-characters/
    public static void main( String[] args ) {
        String[] words = {"cd", "f", "kl"};
        StreamOfCharacters streamChecker = new StreamOfCharacters(words);

        streamChecker.query('a');          // return false
        streamChecker.query('b');          // return false
        streamChecker.query('c');          // return false

        System.out.println(streamChecker.query('d'));   // return true, because 'cd' is in the wordlist

        streamChecker.query('e');                        // return false
        System.out.println(streamChecker.query('f'));   // return true,
    }

    public boolean query( char letter ) {
        sb.append(letter);
        TrieNode node = root;

        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {

            char c = sb.charAt(i);
            node = node.next[c - 'a'];

            //we found a complete word in TRIE
            if (node != null && node.isWord) {
                return true;
            }
        }
        return false;
    }

    private void createTrie( String[] words ) {
        for (String s : words) {

            TrieNode node = root;

            int len = s.length();

            for (int i = len - 1; i >= 0; i--) {

                char c = s.charAt(i);

                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }

                node = node.next[c - 'a'];
            }

            //end of loop means, we iterate over 1 word..
            node.isWord = true;
        }
    }

    class TrieNode {
        boolean isWord;
        TrieNode[] next = new TrieNode[26];
    }
}
