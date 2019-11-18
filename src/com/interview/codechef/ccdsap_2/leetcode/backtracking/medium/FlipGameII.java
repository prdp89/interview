package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

public class FlipGameII {

    /*
    You are playing the following Flip Game with your friend:
    Given a string that contains only these two characters: + and -,
    you and your friend take turns to flip twoconsecutive "++" into "--".
    The game ends when a person can no longer make a move and therefore the other person will be the winner.

    Write a function to determine if the starting player can guarantee a win.
    For example, given s = "++++", return true. The starting player can guarantee a win
    by flipping the middle "++" to become "+--+".
     */

    //Asked in Google:
    //https://www.youtube.com/watch?v=rjOTv7dzqC8
    public static void main( String[] args ) {
        System.out.println(canWin("++++"));
    }

    //Roughly, the time is n*n*...n, which is O(n^n).
    //The reason is each recursion takes O(n) and there are totally n recursions.
    private static boolean canWin( String s ) {
        if (s == null)
            return false;

        return canWin(s.toCharArray());
    }

    private static boolean canWin( char[] chars ) {

        for (int i = 0; i < chars.length - 1; i++) {

            //checking if curr and next chars are +
            if (chars[i] == '+' && chars[i + 1] == '+') {

                //replacing it with -
                chars[i] = chars[i + 1] = '-';

                //giving it to opponent; if opponent returns false, means we won
                boolean win = !canWin(chars);

                chars[i] = chars[i + 1] = '+'; //backtrack to original string.

                if (win)
                    return true;
            }
        }
        return false;
    }
}
