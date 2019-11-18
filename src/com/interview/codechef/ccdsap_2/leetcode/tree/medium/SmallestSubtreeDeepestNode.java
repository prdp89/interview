package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class SmallestSubtreeDeepestNode {

    //https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
    public static void main( String[] args ) {

        Node head = Node.newNode(3);

        head.left = Node.newNode(5);
        head.right = Node.newNode(1);

        head.left.left = Node.newNode(6);
        head.left.right = Node.newNode(2);

        head.right.left = Node.newNode(0);
        head.right.right = Node.newNode(8);

        head.left.right.left = Node.newNode(7);
        head.left.right.right = Node.newNode(4);


        Node res = subtreeWithAllDeepest(head);

    }

    //passing all test case; idea from below link
    //ref : https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/discuss/146765/C++-Simple-O(n)-Solution-with-BFS+LCA-with-thought-process-explained
    private static Node subtreeWithAllDeepest( Node root ) {

        if (root == null)
            return null;

        Node leftMost = null, rightMost = null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        //Doing level-order Traversal and finding LeftMost/Rightmost node in a tree.
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Node node = queue.poll();

                if (i == 0)
                    leftMost = node;

                if (i == size - 1)
                    rightMost = node;

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
        }

        return LCA(root, leftMost, rightMost);
    }

    //refer LCABinaryTree for more Clarity on this.
    //LCABST is not working here..so trying Modified LCA for a Binary Tree
    private static Node LCA( Node root, Node leftNode, Node rightNode ) {

        //Base Case : Checking if root reaches leftMost/rightMost
        if (root == null || leftNode == root || rightNode == root) {
            return root;
        }

        Node left = LCA(root.left, leftNode, rightNode);
        Node right = LCA(root.right, leftNode, rightNode);

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else //both left and right pointers are not NULL; equals to left != null && right != null
            return root;
    }

}
