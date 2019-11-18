package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

public class WordSearch {

    //This solution is similar to RatInMaze problem..
    private boolean[][] visited;

    //https://leetcode.com/problems/word-search/
    public static void main( String[] args ) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCB";
        System.out.println(exist(board, word));
    }

    private static boolean exist( char[][] board, String word ) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        /* ensure all the nodes will be searched as the beginning point */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, board, word, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs( int row, int col, int index, char[][] board, String word, boolean[][] visited ) {
        /*  1. out of bound
            2. already visited
            3. not match    */
        if (!checkBound(row, col, board) ||
                visited[row][col] ||
                word.charAt(index) != board[row][col]) {
            return false;
        }

        /* find one matched character, mark the current node as visited */
        visited[row][col] = true;

        /* find the whole word! */
        if (index == word.length() - 1) {
            return true;
        }

        /* continue searching the next char by extending the index of string
        note that the current char may not belong to the word in the final
        even though it matches until now */
        index++;

        /* down, right, up, left search */
        if (dfs(row + 1, col, index, board, word, visited) ||
                dfs(row, col + 1, index, board, word, visited) ||
                dfs(row - 1, col, index, board, word, visited) ||
                dfs(row, col - 1, index, board, word, visited)) {
            return true;
        }

        /* current position is wrong, backtracking */
        visited[row][col] = false;
        return false;
    }

    private static boolean checkBound( int row, int col, char[][] board ) {
        if (row == -1 || row == board.length || col == -1 || col == board[0].length) {
            return false;
        }
        return true;
    }
}
