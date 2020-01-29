package com.interview.codechef.ccdsap_2.leetcode.companies.amazon;

import com.interview.tree.Node;

import java.util.ArrayList;

public class BoundaryTraversal {

    /*
    Input:
                1
               / \
              2   3
             / \  / \
            4   5 6  7

     Output:
     [1, 2, 4, 5, 6, 7, 3]
     */
    private static ArrayList<Integer> bound;
    private static Node wholeRoot;

    //https://www.interviewbit.com/problems/boundary-traversal-of-binary-tree/#
    public static void main( String[] args ) {

        Node head = Node.newNode(1);

        head.left = Node.newNode(2);
        head.right = Node.newNode(3);

        head.left.left = Node.newNode(4);
        head.left.right = Node.newNode(5);

        head.right.left = Node.newNode(6);
        head.right.right = Node.newNode(7);

        solve(head);

        bound.forEach(System.out::println);
    }

    //Traversing in Order :
    //1. Fetch all Left nodes
    //1. Fetch all Leaf nodes
    //1. Fetch all Right nodes
    private static ArrayList<Integer> solve( Node A ) {

        wholeRoot = A;
        bound = new ArrayList<>();

        printLeft(A);
        printLeaves(A);
        printRight(A);

        return bound;
    }

    private static void printRight( Node root ) {
        if (root == null || (root.left == null && root.right == null))
            return;

        printRight(root.right);

        if (root != wholeRoot)
            bound.add(root.data);
    }

    private static void printLeft( Node root ) {
        if (root == null || (root.left == null && root.right == null))
            return;

        //getting the root here..
        bound.add(root.data);

        printLeft(root.left);
    }

    private static void printLeaves( Node root ) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            bound.add(root.data);
        }

        printLeaves(root.left);
        printLeaves(root.right);
    }
}
