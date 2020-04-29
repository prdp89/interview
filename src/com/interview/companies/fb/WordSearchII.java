package com.interview.companies.fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordSearchII {

    private static TrieNode root = new TrieNode();

    //https://leetcode.com/problems/word-search-ii/
    public static void main( String[] args ) {
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'},
        };

        findWords(board, words).forEach(System.out::println);
    }

    private static List<String> findWords( char[][] board, String[] words ) {

        List<String> resList = new ArrayList<>();
        // boolean[][] visited = new boolean[board.length][board[0].length];

        for (String item : words) {
            createTrie(item);
        }

        TrieNode trieNode = root;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trieNode.next[board[i][j] - 'a'] != null)
                    searchTrie(trieNode, resList, board, i, j);
            }
        }

        return resList;
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

    private static void searchTrie( TrieNode trieNode, List<String> resList, char[][] board, int i, int j ) {

        char chars = board[i][j];

        board[i][j] = '$';

        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(trieNode.next[chars - 'a']);

        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while (!queue.isEmpty()) {

            TrieNode node = queue.poll();

            if (node != null && node.isWord) {
                resList.add(node.word);
                node.word = null;
            }

            for (int[] dir : dirs) {
                int posx = i + dir[0];
                int posy = j + dir[1];

                if (posx < 0 || posy < 0 || posx >= board.length || posy >= board[0].length)
                    continue;

                char ch = board[posx][posy];

                if (node != null && node.next[ch - 'a'] != null)
                    queue.offer(node.next[ch - 'a']);
            }
        }

        board[i][j] = chars;
    }

    private static class TrieNode {
        boolean isWord;
        String word;
        TrieNode[] next = new TrieNode[26];
    }
}
