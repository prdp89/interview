package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeafSimilarTrees {

    //https://leetcode.com/problems/leaf-similar-trees/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(5, head);
        head = bt.addNode(6, head);
        head = bt.addNode(2, head);
        head = bt.addNode(7, head);
        head = bt.addNode(4, head);

        //print("", head, false);

        Node head1 = null;
        head1 = bt.addNode(1, head1);
        head1 = bt.addNode(9, head1);
        head1 = bt.addNode(8, head1);

        System.out.println(leafSimilar(head, head1));
    }

    //solved in one attempt :)
    private static boolean leafSimilar( Node root1, Node root2 ) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        getLeafNode(root1, list);
        getLeafNode(root2, list1);

        if (list.size() != list1.size())
            return false;

        for (int i = 0; i < list.size(); i++) {
            if (!Objects.equals(list.get(i), list1.get(i)))
                return false;
        }

        return true;
    }

    private static void getLeafNode( Node root, List<Integer> list ) {

        if (root.left == null && root.right == null) {
            list.add(root.data);
        }

        if (root.left != null)
            getLeafNode(root.left, list);

        if (root.right != null)
            getLeafNode(root.right, list);
    }

    private static void print( String prefix, Node n, boolean isLeft ) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }
}
