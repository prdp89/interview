package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    //https://leetcode.com/problems/invert-binary-tree/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(4, head);
        head = bt.addNode(7, head);
        head = bt.addNode(2, head);
        head = bt.addNode(1, head);
        head = bt.addNode(3, head);
        head = bt.addNode(6, head);
        head = bt.addNode(9, head);

        Node inverted = invertTree(head);

        print("", inverted, false);
    }

    //same as LevelOrderTraversal of binary tree -> Hackerrank -> trees -> easy -> LevelOrderTraversal
    private static Node invertTree( Node root ) {

        if (root == null) {
            return null;
        }

        final Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final Node node = queue.poll();

            //preserving left node
            final Node left = node.left;

            //swap left and right node
            node.left = node.right;
            node.right = left;

            //same as Level order traversal of Binary Tree
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;
    }

    //interesting too .... :)
    private static Node invertTreeRecursive( Node root ) {

        if (root == null) {
            return null;
        }

        //preserving left and right nodes
        final Node left = root.left,
                right = root.right;

        //swap right and left then..
        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }

    private static void print( String prefix, Node n, boolean isLeft ) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
                print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }
}
