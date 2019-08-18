package com.interview.codechef.ccdsap_2.hackerrank.Trees.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    //https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(1, head);
        head = bt.addNode(2, head);
        head = bt.addNode(5, head);
        head = bt.addNode(3, head);
        head = bt.addNode(6, head);
        head = bt.addNode(4, head);

        levelOrder(head);

        System.out.println("BFS : ");
        printLevelOrderBFS(head);
    }

    private static void levelOrder( Node root ) {
        int height = height(root);

        //for each heightONOde level
        for (int i = 1; i <= height; i++) {
            //after each loop -> root points to level of that node
            printNodesAtLevel(root, i);
        }
    }

    private static void printNodesAtLevel( Node root, int level ) {
        if (root == null) {
            return;
        }

        //if each level turns '1', prints each left and right nodes
        if (level == 1) {
            System.out.print(root.data + " ");
        } else {
            printNodesAtLevel(root.left, level - 1);
            printNodesAtLevel(root.right, level - 1);
        }
    }

    private static int height( Node root ) {
        if (root == null)
            return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private static void printLevelOrderBFS( Node root ) {
        //queue is taken bcz each level children will be added at last this way
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
