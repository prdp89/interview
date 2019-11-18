package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.Stack;

public class PathSum {

    //https://leetcode.com/problems/path-sum/
    private static int tempSum = -1;

    //Read Iterative apprach at end : it teaches backtracking with the stack.
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(5, head);
        head = bt.addNode(2, head);
        head = bt.addNode(13, head);
        head = bt.addNode(1, head);
        head = bt.addNode(3, head);
        head = bt.addNode(11, head);
        head = bt.addNode(15, head);

        //System.out.println(hasPathSum(head, 8));

        System.out.println(hasPathSum(head, 8)); // 5 -> 2 -> 1
    }

    //THis recursion is similar to Target sum recursion in coding-bat package.
    private static boolean hasPathSum( Node root, int sum ) {

        if (root == null)
            return false;

        if (root.left == null && root.right == null && sum - root.data == 0)
            return true;

        return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
    }

    private static boolean hasPathSumTry( Node root, int sum ) {

        if ((root.left == null && root.right == null) && tempSum != sum) {
            tempSum -= root.data;
            return false;
        }

        if (root.left == null && root.right == null) {
            int temp = tempSum;

            tempSum = 0;
            return sum == temp;
        }

        if (root.left != null) {
            tempSum += root.data;
            return hasPathSum(root.left, sum);
        }

        if (root.right != null) {
            tempSum += root.data;
            return hasPathSum(root.right, sum);
        }

        return false;
    }

    //Beautiful STACK implementation of BackTracking stack problem. :)
    private static boolean hasPathSumIterative( Node root, int sum ) {
        Stack<Node> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();

        stack.push(root);

        //same as Recursion above: storing sum and decrementing with every call
        sums.push(sum);

        while (!stack.isEmpty() && root != null) {

            int value = sums.pop();

            Node top = stack.pop();

            if (top.left == null && top.right == null && top.data == value) {
                return true;
            }

            if (top.right != null) {
                stack.push(top.right);

                //subtract sum from current node data
                sums.push(value - top.data);
            }

            if (top.left != null) {
                stack.push(top.left);

                //we need both the copies of current sum while traversing left or right
                sums.push(value - top.data);
            }
        }

        return false;
    }
}
