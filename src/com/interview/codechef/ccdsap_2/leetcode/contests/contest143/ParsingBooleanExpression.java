package com.interview.codechef.ccdsap_2.leetcode.contests.contest143;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParsingBooleanExpression {

    //https://leetcode.com/contest/weekly-contest-143/problems/parsing-a-boolean-expression/
    /*
    Return the result of evaluating a given boolean expression, represented as a string.

    An expression can either be:

    "t", evaluating to True;
    "f", evaluating to False;
    "!(expr)", evaluating to the logical NOT of the inner expression expr;
    "&(expr1,expr2,...)", evaluating to the logical AND of 2 or more inner expressions expr1, expr2, ...;
    "|(expr1,expr2,...)", evaluating to the logical OR of 2 or more inner expressions expr1, expr2, ...

     */

    /*
    Example 1:

    Input: expression = "!(f)"
    Output: true
    Example 2:

    Input: expression = "|(f,t)"
    Output: true
    Example 3:

    Input: expression = "&(t,f)"
    Output: false
     */
    public static void main( String[] args ) {
        System.out.println(parseBoolExpr("|(f,t)"));
    }


    //ref : https://leetcode.com/problems/parsing-a-boolean-expression/discuss/323532/Java-Iterative-and-recursive-solutions-w-explanation-and-analysis.
    private static boolean parseBoolExpr( String expression ) {

        Deque<Character> stk = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); ++i) {

            char c = expression.charAt(i);

            if (c != ',' && c != ')') {
                stk.push(c);
            } else if (c == ')') {

                char and = 't', or = 'f', not = 0; // &, | and ! expression results.

                while (stk.peek() != '(') {

                    char d = stk.pop();

                    if (d == 'f')
                        and = 'f'; // if there is any 'f', & expression results to 'f'

                    if (d == 't')
                        or = 't'; // if there is any 't', | expression results to 't'

                    not = d == 't' ? 'f' : 't'; // Logical NOT flips d.

                }

                stk.pop(); // pop out '('.

                char operator = stk.pop(); // get operator for current expression.

                if (operator == '&') { // & expression.
                    stk.push(and);
                } else if (operator == '|') { // | expression.
                    stk.push(or);
                } else { // ! expression.
                    stk.push(not);
                }
            }
        }
        return stk.pop() == 't';
    }
}
