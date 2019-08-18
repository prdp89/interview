package com.interview.codechef.ccdsap_2.leetcode.contests.contest147;

public class AlphabetBoardPath {

    //https://leetcode.com/contest/weekly-contest-147/problems/alphabet-board-path/

    /*
    On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].

    Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.

    We may make the following moves:

    'U' moves our position up one row, if the position exists on the board;
    'D' moves our position down one row, if the position exists on the board;
    'L' moves our position left one column, if the position exists on the board;
    'R' moves our position right one column, if the position exists on the board;
    '!' adds the character board[r][c] at our current position (r, c) to the answer.
    (Here, the only positions that exist on the board are positions with letters on them.)

    Return a sequence of moves that makes our answer equal to target in the minimum number of moves.
    You may return any path that does so.

    Input: target = "leet"
    Output: "DDR!UURRR!!DDD!"
     */
    public static void main( String[] args ) {
        System.out.println(alphabetBoardPath("leet"));
    }

    private static String alphabetBoardPath( String target ) {
        StringBuilder sb = new StringBuilder();
        int prex = 0, prey = 0;

        for (int j = 0; j < target.length(); j++) {

            //for eg: if char  = c then X = (67-65) / 5 = 0, Y = (67-65) % 5 = 2 => {0,2}
            //That means from {prevX, prevY} = {0,0} it will take 2 steps to reach {0,2}
            int curX = (target.charAt(j) - 'a') / 5, curY = (target.charAt(j) - 'a') % 5;

            // the order is very important.
            while (prex > curX) {
                prex--;
                sb.append('U');
            }

            while (prey < curY) {
                prey++;
                sb.append('R');
            }

            while (prey > curY) {
                prey--;
                sb.append('L');
            }

            while (prex < curX) {
                prex++;
                sb.append('D');
            }

            sb.append('!');
        }

        return sb.toString();
    }
}
