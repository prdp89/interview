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

    //Runtime: 8 ms, faster than 99.06% of Java
    private static List<String> findWords( char[][] board, String[] words ) {

        List<String> resList = new ArrayList<>();

        for (String item : words) {
            createTrie(item);
        }

        TrieNode node = root;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                //bfs: passing 18/36 test cases..
                //searchTrie_bfs(board, i, j, resList);

                dfs(board, i, j, node, resList);
            }
        }

        return resList;
    }

    private static void dfs( char[][] board, int i, int j, TrieNode node, List<String> resList ) {
        char c = board[i][j]; // get the current character from the board at i, j

        if (c == '*' || node.next[c - 'a'] == null)
            return;

        node = node.next[c - 'a'];

        if (node.word != null) {   // found one words add in the result list
            resList.add(node.word);
            node.word = null;     // de-duplicate remove the word from trie
        }

        board[i][j] = '*'; // update the character of at i , j no need for visited array

        if (i > 0)
            dfs(board, i - 1, j, node, resList); // up
        if (j > 0)
            dfs(board, i, j - 1, node, resList); // left
        if (i < board.length - 1)
            dfs(board, i + 1, j, node, resList); // down
        if (j < board[0].length - 1)
            dfs(board, i, j + 1, node, resList); // right

        board[i][j] = c; // backtrack the character
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

    //16 / 36 test cases passed.
    private static void searchTrie_bfs( char[][] board, int i, int j, List<String> resList ) {

        TrieNode trieNode = root;

        boolean[][] visited = new boolean[board.length][board[0].length];

        char chars = board[i][j];

        Queue<Wrapper> queue = new LinkedList<>();
        queue.offer(new Wrapper(trieNode, i, j));

        visited[i][j] = true;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                Wrapper node = queue.poll();

                for (int[] dir : dirs) {

                    int posx = node.x + dir[0];
                    int posy = node.y + dir[1];

                    TrieNode temp = node.node;

                    if (posx < 0 || posy < 0 || posx >= board.length
                            || posy >= board[0].length
                            || visited[posx][posy])
                        continue;

                    char ch = board[posx][posy];

                    if (temp != null && temp.next[ch - 'a'] != null) {

                        if (temp.next[ch - 'a'].isWord) {
                            if (!resList.contains(temp.next[ch - 'a'].word))
                                resList.add(temp.next[ch - 'a'].word);

                            temp.word = null;
                            visited[posx][posy] = true;
                        } else {
                            temp = temp.next[ch - 'a'];
                            queue.offer(new Wrapper(temp, posx, posy));
                        }
                    }
                }
            }
        }

        board[i][j] = chars;
    }

    private static class Wrapper {
        TrieNode node;
        int x, y;

        Wrapper( TrieNode node, int x, int y ) {
            this.x = x;
            this.y = y;
            this.node = node;
        }
    }

    private static class TrieNode {
        boolean isWord;
        String word;
        TrieNode[] next = new TrieNode[26];
    }
}
