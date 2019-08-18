package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.LinkedList;

public class IncreasingOrderSearchTree {

    //https://leetcode.com/problems/increasing-order-search-tree/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(5, head);
        head = bt.addNode(3, head);
        head = bt.addNode(6, head);
        head = bt.addNode(2, head);
        head = bt.addNode(4, head);
        head = bt.addNode(8, head);
        head = bt.addNode(1, head);
        head = bt.addNode(7, head);
        head = bt.addNode(9, head);

        //Node node = increasingBST(head);
        Node node = increasingBSTOptimal(head);

        print("", node, false);
    }

    //tried but recurrence of this problem is difficult :(
    private static Node increasingBST( Node root ) {

        if (root == null)
            return null;

        if (root.left != null)
            return increasingBST(root.left);

        Node node = Node.newNode(root.data);
        node.right = increasingBST(root.right);

        return node;
    }

    //THis solution is same as Inorder Traversal of Tree
    private static Node increasingBSTOptimal( Node root ) {

        //same as LL dummy node
        Node dummy = Node.newNode(0);
        Node prev = dummy;

        LinkedList<Node> stack = new LinkedList<Node>();
        Node curr = root;

        while (!stack.isEmpty() || curr != null) {

            //going till leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            //pop out the leftmost node
            curr = stack.pop();
            curr.left = null;

            //appending curr node to the prev
            prev.right = curr;
            //assigning prev to the curr address
            prev = curr;

            //move curr to the right
            curr = curr.right;
        }
        return dummy.right;
    }

    private static void print( String prefix, Node n, boolean isLeft ) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }
}
