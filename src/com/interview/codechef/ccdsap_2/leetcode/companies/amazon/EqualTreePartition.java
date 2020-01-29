package com.interview.codechef.ccdsap_2.leetcode.companies.amazon;

import com.interview.tree.Node;

import java.util.Stack;

public class EqualTreePartition {

    private static Stack<Integer> seen = new Stack();

    //https://leetcode.com/articles/equal-tree-partition/
    public static void main( String[] args ) {
        Node head = Node.newNode(5);

        head.left = Node.newNode(10);
        head.right = Node.newNode(10);

        head.right.left = Node.newNode(2);
        head.right.right = Node.newNode(3);

        System.out.println(solve(head));
    }

    private static boolean solve( Node head ) {
        int total = sum(head);

        seen.pop();

        if (total % 2 == 0)
            for (int s : seen)
                if (s == total / 2)
                    return true;

        return false;
    }

    private static int sum( Node node ) {
        if (node == null)
            return 0;

        seen.push(sum(node.left) + sum(node.right) + node.data);

        return seen.peek();
    }
}
