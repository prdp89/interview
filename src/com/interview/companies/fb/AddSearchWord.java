package com.interview.companies.fb;

import java.util.LinkedList;
import java.util.Queue;

public class AddSearchWord {

    private static TrieNode root = new TrieNode();

    //https://leetcode.com/problems/add-and-search-word-data-structure-design/

    //Runtime: 54 ms, faster than 21.84% of Java
    public static void main( String[] args ) {
        AddSearchWord addSearchWord = new AddSearchWord();
        addSearchWord.addWord("bad");
        addSearchWord.addWord("dad");
        addSearchWord.addWord("pad");

        System.out.println(addSearchWord.search("dad"));
        System.out.println(addSearchWord.search(".ad"));
        System.out.println(addSearchWord.search("b.."));
    }

    private static void createTrie( String word ) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (node.next[ch - 'a'] == null)
                node.next[ch - 'a'] = new TrieNode();

            node = node.next[ch - 'a'];
        }

        node.isWord = true;
        node.word = word;
    }

    public void addWord( String word ) {
        createTrie(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search( String word ) {
        TrieNode node = root;

        return bfs(word, node);
    }

    private boolean bfs( String word, TrieNode node ) {
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(node);

        int level = 0;

        while (!queue.isEmpty() && level <= word.length()) {

            int size = queue.size();
            while (size-- > 0) {
                TrieNode currentNode = queue.poll();

                if (null == currentNode)
                    continue;

                //really imp. condition..now you know WHY we need level in BFS
                if (level == word.length())
                    return currentNode.isWord;

                //finding next char in Trie tree
                char ch = word.charAt(level);
                if (ch == '.') { //then search all children, any next char can match
                    if (null != currentNode.next) {
                        for (TrieNode trieNode : currentNode.next) {
                            queue.offer(trieNode);
                        }
                    }
                } else {
                    if (null != currentNode.next && currentNode.next[ch - 'a'] != null) { //search for next char if present in TRIE
                        queue.offer(currentNode.next[ch - 'a']);
                    }
                }
            }

            level++;
        }

        return false;
    }

    private boolean search( String word, int i, TrieNode node ) {
        if (node == null) return false;
        if (i == word.length()) return node.isWord;

        char c = word.charAt(i);

        if (c == '.') {
            /* Do a recursive call for every child since the rest of the word can be found
            starting from any node child */
            for (TrieNode child : node.next) {
                if (search(word, i + 1, child))
                    return true;
            }
        } else {
            if (search(word, i + 1, node.next[c - 'a']))
                return true;
        }

        return false;
    }

    private static class TrieNode {
        boolean isWord;
        String word;
        TrieNode[] next = new TrieNode[26];
    }
}
