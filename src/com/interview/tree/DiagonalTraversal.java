package com.interview.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class DiagonalTraversal {
    // Tree node
    static class Node {
        int data;
        Node left;
        Node right;

        //constructor
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    /* root - root of the binary tree
       d -  distance of current line from rightmost
            -topmost slope.
       diagonalPrint - HashMap to store Diagonal
                       elements (Passed by Reference) */
    static void diagonalPrintUtil(Node root, int d,
                                  HashMap<Integer, Vector<Integer>> diagonalPrint) {

        // Base case
        if (root == null)
            return;

        // get the list at the particular d value
        Vector<Integer> k = diagonalPrint.get(d);

        // k is null then create a vector and store the data
        if (k == null) {
            k = new Vector<>();
            k.add(root.data);
        }

        // k is not null then update the list
        else {
            k.add(root.data);
        }

        // Store all nodes of same line together as a vector
        diagonalPrint.put(d, k);

        // Increase the vertical distance if left child
        diagonalPrintUtil(root.left, d + 1, diagonalPrint);

        // Vertical distance remains same for right child
        diagonalPrintUtil(root.right, d, diagonalPrint);
    }

    // Print diagonal traversal of given binary tree
    static void diagonalPrint(Node root) {
        // create a map of vectors to store Diagonal elements
        HashMap<Integer, Vector<Integer>> diagonalPrint = new HashMap<>();
        diagonalPrintUtil(root, 0, diagonalPrint);

        System.out.println("Diagonal Traversal of Binnary Tree");
        for (Map.Entry<Integer, Vector<Integer>> entry : diagonalPrint.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    // Driver program
    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        diagonalPrint(root);
    }
}
