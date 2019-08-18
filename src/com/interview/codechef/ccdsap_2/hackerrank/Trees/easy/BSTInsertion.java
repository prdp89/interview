package com.interview.codechef.ccdsap_2.hackerrank.Trees.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class BSTInsertion {

    //https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(4, head);
        head = bt.addNode(2, head);
        head = bt.addNode(7, head);
        head = bt.addNode(1, head);
        head = bt.addNode(3, head);

        insert(head, 6);

        print("", head, false);
    }

    public static Node insert( Node root, int data ) {

        Node temp = root;

        return traverseNode(temp, data);

        //return traverseNodeWorking(temp, data);

        //previoulsly I was inserting after getting the correct point; it fails some tests.
        /*Node newNode = Node.newNode(data);

        if (data > i.data)
            i.right = newNode;
        else
            i.left = newNode;*/
    }

    //logic is correct but instead of returning we should insert there itself.
    private static Node traverseNode( Node root, int data ) {

        if (root.left == null || root.right == null)
            return root;

        if (data > root.data)
            return traverseNode(root.right, data);
        else
            return traverseNode(root.left, data);
    }

    private static Node traverseNodeWorking( Node root, int data ) {

        if (root == null) {
            Node node = Node.newNode(data);
            //node.data=data;
            node.left = null;
            node.right = null;
            root = node;
            return root;
        } else if (data > root.data)
            root.right = traverseNodeWorking(root.right, data);
        else
            root.left = traverseNodeWorking(root.left, data);

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
