package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumOfLeftLeaves {

    private static int sum = 0;

    //https://leetcode.com/problems/sum-of-left-leaves/
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

        //sumOfLeftLeaves(head);
        //System.out.println(sum);

        List<Integer> list = preorderTraversal_method2(head);

        final int[] sum = {0};
        list.forEach(it -> sum[0] += it);

        System.out.println(sum[0]);
    }

    //53 / 102 test cases passed.
    //For correct recursion : https://leetcode.com/problems/sum-of-left-leaves/discuss/88950/Java-iterative-and-recursive-solutions
    private static int sumOfLeftLeaves( Node root ) {
        if (root == null)
            return 0;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.data;
            sumOfLeftLeaves(root.left);
        }

        if (root.right != null)
            sumOfLeftLeaves(root.right);

        return 0;
    }

    //Runtime: 32 ms, faster than 16.90% of Java
    //FOllow this for good BFS : https://leetcode.com/problems/sum-of-left-leaves/discuss/89060/Java-Solution-using-BFS
    private static List<Integer> preorderTraversal_method2( Node root ) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        Stack<Node> stack = new Stack<>();

        //provide root first and iterate on Root and its Left
        pushAllLeft(root, stack, res);

        while (!stack.isEmpty()) {

            Node cur = stack.pop();

            //iterate on root and its Right
            pushAllLeft(cur.right, stack, res);
        }

        return res;
    }

    private static void pushAllLeft( Node node, Stack stack, List res ) {
        while (node != null) {

            if (node.left != null && node.left.left == null && node.left.right == null)
                res.add(node.left.data); //data - > left -> right

            stack.add(node);
            node = node.left;
        }
    }

}
