package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import java.util.Stack;

public class MinCostTreeLeafNode {

    //https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
    public static void main( String[] args ) {
        System.out.println(mctFromLeafValues(new int[]{6, 2, 4}));
    }

    //Read the detail first; WHY the logic is correct
    //https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/339959/One-Pass-O(N)-Time-and-Space
    private static int mctFromLeafValues( int[] A ) {
        int res = 0, n = A.length;

        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);

        //This logic is similar to NextGreaterNodeLinkedList
        for (int a : A) {

            while (stack.peek() <= a) {

                //The cost to remove a is a * min(left, right).
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }

            stack.push(a);
        }

        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }

        return res;
    }
}
