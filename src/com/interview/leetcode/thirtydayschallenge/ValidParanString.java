package com.interview.leetcode.thirtydayschallenge;

public class ValidParanString {

    //https://leetcode.com/problems/valid-parenthesis-string/
    public static void main( String[] args ) {
        System.out.println(checkValidString("(**)"));
    }

    /*
    if cmin<0, it means you have taken some extra '*' as ')'
    which has caused the current "state" to become invalid,
    i.e. no opening bracket is there to balance the closing bracket.

    Say, string is (**)
    1st iteration, character: (:
    cmin = 1, cmax = 1
    ( (

    2nd iteration, character: *:
    cmin = 0, cmax = 2
    () ((

    3rd iteration, character: *:
    cmin = -1, cmax = 3
    ()) (((

    You can see that there's no opening bracket to balance the last closing bracket
    (actually '*'). So we'll ignore the extra closing bracket we put in there,
    by resetting cmin back to 0, i.e. take it as an empty character.
    () (((
     */

    //https://leetcode.com/problems/valid-parenthesis-string/discuss/543521/Java-Count-Open-Parenthesis-O(n)-time-O(1)-space-Picture-Explain
    private static boolean checkValidString( String s ) {
        int cMin = 0, cMax = 0; // open parentheses count in range [cmin, cmax]

        for (char c : s.toCharArray()) {

            if (c == '(') {
                cMax++;
                cMin++;
            } else if (c == ')') {
                cMax--;
                cMin--;
            } else if (c == '*') {
                cMax++; // if `*` become `(` then openCount++
                cMin--; // if `*` become `)` then openCount--
            }

            if (cMax < 0)
                return false; // Currently, don't have enough open parentheses to match close parentheses-> Invalid

            // For example: (()))(
            cMin = Math.max(cMin, 0);   // It's invalid if open parentheses count < 0 that's why cmin can't be negative
        }

        return cMin == 0; // Return true if can found `openCount == 0` in range [cmin, cmax]
    }
}
