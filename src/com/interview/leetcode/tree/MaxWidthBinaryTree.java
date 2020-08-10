package com.interview.leetcode.tree;

import com.interview.tree.Node;

import java.util.Deque;
import java.util.LinkedList;

public class MaxWidthBinaryTree {

    //https://leetcode.com/problems/maximum-width-of-binary-tree/
    public static void main( String[] args ) {
        Node root = Node.newNode(1);

        root.left = Node.newNode(3);
        root.right = Node.newNode(2);

        root.left.left = Node.newNode(5);
        root.left.right = Node.newNode(3);

        root.right.right = Node.newNode(9);

        System.out.println(widthOfBinaryTree(root));
    }

    private static int widthOfBinaryTree( Node root ) {
        Deque<Node> nodeDeque = new LinkedList<>();
        nodeDeque.add(root);

        int maxWidth = 0;
        while (!nodeDeque.isEmpty()) {

            int size = nodeDeque.size();
            maxWidth = Math.max(maxWidth, size);

            while (size-- > 0) {
                Node node = nodeDeque.poll();

                if (null != node) {
                    nodeDeque.add(node.left);
                    nodeDeque.add(node.right);
                } else {
                    nodeDeque.add(null);
                    nodeDeque.add(null);
                }
            }

            //removing both ends NULL values {on start or on last}
            //bcz are only keeping MIDDLE null value and based on that calculating MAXWIDTH
            while (!nodeDeque.isEmpty() && nodeDeque.peekFirst() == null)
                nodeDeque.pollFirst();

            while (!nodeDeque.isEmpty() && nodeDeque.peekLast() == null)
                nodeDeque.pollLast();
        }

        return maxWidth;
    }
}
