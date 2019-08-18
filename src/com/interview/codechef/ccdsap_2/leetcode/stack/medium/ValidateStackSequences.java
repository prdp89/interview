package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

import java.util.Stack;

public class ValidateStackSequences {

    //https://leetcode.com/problems/validate-stack-sequences/submissions/
    public static void main( String[] args ) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};

       /* int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 3, 5, 1, 2};*/

        System.out.println(solveTry(push, pop));
    }

    //solved in one attempt
    private static boolean solveTry( int[] push, int[] pop ) {

        Stack<Integer> stackPush = new Stack<>();

        int j = 0;
        for (int i = 0; i < push.length; i++) {

            if (pop[j] != push[i])
                stackPush.push(push[i]);
            else {
                stackPush.push(push[i]);
                while (!stackPush.isEmpty() && pop[j] == stackPush.peek()) {
                    stackPush.pop();
                    j++;
                }
            }
        }

        return stackPush.isEmpty();
    }
}
