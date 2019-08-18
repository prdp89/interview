package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthBinaryTree {

    private static int min = Integer.MIN_VALUE;

    //https://leetcode.com/problems/minimum-depth-of-binary-tree/
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(1, head);
        head = bt.addNode(2, head);

       /* maxDepthRecursiveTry(head, -1);

        System.out.println(min);*/

        System.out.println(minDepth(head));
    }

    //19 / 41 test cases passed :(
    private static void maxDepthRecursiveTry( Node node, int depth ) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {

            if (depth > min) {
                min = depth;
            }

            min = Math.min(min, depth);
            //  min = Math.min(min, depth);

        }

        maxDepthRecursiveTry(node.left, depth + 1);
        maxDepthRecursiveTry(node.right, depth + 1);
    }

    //THis logic is similar to LevelOrderTraversal
    private static int minDepth( Node root ) {
        if (root == null)
            return 0;

        Queue<Node> que = new LinkedList();

        int level = 1;
        que.add(root);

        while (!que.isEmpty()) {

            //traversing each level's all node
            int size = que.size();
            while (size > 0) {

                Node node = que.poll();

                //if any node found first with both left/right that is Answer
                if (node.left == null && node.right == null)
                    return level;

                if (node.left != null)
                    que.add(node.left);

                if (node.right != null)
                    que.add(node.right);

                size--;
            }

            level++;
        }

        return level;
    }
}
