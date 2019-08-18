package com.interview.codechef.ccdsap_2.leetcode.linkedlist.medium;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class BinaryTreeToDoublyLL {

    //global is maintain for single copy of this variable in different recursion calls.
    private Node prev = null;

    private Node head_1 = null;

    //qut:https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
    //nice video : https://www.youtube.com/watch?v=FsxTX7-yhOw
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();
        Node head = null;
        head = bt.addNode(10, head);
        head = bt.addNode(12, head);
        head = bt.addNode(15, head);
        head = bt.addNode(25, head);
        head = bt.addNode(30, head);
        head = bt.addNode(36, head);

        BinaryTreeToDoublyLL tree = new BinaryTreeToDoublyLL();

        tree.BinaryTree2DoubleLinkedList(head);

        tree.printList(tree.head_1);
    }

    private void printList( Node node ) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    //This is equals to Inorder traversal of tree
    private void BinaryTree2DoubleLinkedList( Node root ) {

        // Base case
        if (root == null)
            return;

        // Recursively convert left subtree
        BinaryTree2DoubleLinkedList(root.left);

        //This condition run only first time; to initialize head of Doubly LL
        if (prev == null)
            head_1 = root;
        else {
            //from recursion we get next node after left; setting next node left to prev to establish doubly LL relation
            root.left = prev;

            //setting prev or first node right to next; this helps in two way relation in doubly LL
            prev.right = root;
        }

        //setting prev: to find current node prev in doubly linked list
        prev = root;

        // Finally convert right subtree
        BinaryTree2DoubleLinkedList(root.right);
    }
}
