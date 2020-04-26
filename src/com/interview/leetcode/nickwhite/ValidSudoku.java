package com.interview.leetcode.nickwhite;

import java.util.HashSet;
import java.util.Objects;

public class ValidSudoku {

    //https://leetcode.com/problems/valid-sudoku/
    public static void main( String[] args ) {
        String[][] board = {
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };

        System.out.println(isValidSudoku(board));
    }

    //Runtime: 17 ms, faster than 8.78% of Java
    private static boolean isValidSudoku( String[][] board ) {

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                String currVal = board[i][j];

                if (!Objects.equals(currVal, ".")) {
                    if (!set.add(currVal + "found in row" + i) ||
                            !set.add(currVal + "found in col" + j) ||
                            !set.add(currVal + "found in box" + i / 3 + "-" + j / 3))
                        return false;
                }
            }
        }

        return true;
    }
}
