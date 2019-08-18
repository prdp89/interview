package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class SubtreeOfAnotherTree {

    //https://leetcode.com/problems/subtree-of-another-tree/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(3, head);
        head = bt.addNode(4, head);
        head = bt.addNode(5, head);
        head = bt.addNode(1, head);
        head = bt.addNode(2, head);

        Node head1 = null;
        head1 = bt.addNode(4, head1);
        head1 = bt.addNode(1, head1);
        head1 = bt.addNode(2, head1);

        //System.out.println(isSubtree(head, head1));

        System.out.println(isSubtreeOptimal(head, head1));
    }

    //region Try approach
    private static boolean isSubtree( Node s, Node t ) {

        Node node = searchNode(s, t.data);

        return isSameTreeTry(node, t);
    }

    //trying to search a node then checking it value by value
    private static boolean isSameTreeTry( Node p, Node q ) {

        if (p == null && q == null)
            return true;

        if (p != null && q != null && p.data == q.data)
            return isSameTreeTry(p.left, q.left) && isSameTreeTry(p.right, q.right);
        return false;
    }

    private static Node searchNode( Node s, int data ) {

        if (s == null)
            return null;

        if (s.data == data)
            return s;

        return searchNode(s.left, data) == null ? searchNode(s.right, data) : null;
    }
    //endregion

    //region Optimal Approach : https://leetcode.com/problems/subtree-of-another-tree/discuss/102724/Java-Solution-tree-traversal

    //another interesting approach : https://leetcode.com/problems/subtree-of-another-tree/discuss/102736/Java-Concise-O(n%2Bm)-Time-O(n%2Bm)-Space
    private static boolean isSubtreeOptimal( Node s, Node t ) {
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.offer(s);

        while (!nodes.isEmpty()) {

            Node node = nodes.poll();

            //checking from each Node if that subtree matches with T tree
            if (isSameTreeOptimal(node, t)) {
                return true;
            }

            if (node.left != null) {
                nodes.offer(node.left);
            }

            if (node.right != null) {
                nodes.offer(node.right);
            }
        }

        return false;
    }

    private static boolean isSameTreeOptimal( Node s, Node t ) {

        //if both Tree reaches NULL tat means both subtree equals
        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        if (s.data != t.data) {
            return false;
        } else {
            return isSameTreeOptimal(s.left, t.left) && isSameTreeOptimal(s.right, t.right);
        }
    }
    //endregion
}
