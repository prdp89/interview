package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    //https://leetcode.com/problems/binary-tree-paths/
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(1, head);
        head = bt.addNode(2, head);
        head = bt.addNode(3, head);
        head = bt.addNode(5, head);

        //op: 1-> 2 -> 3 -> 5 bcz all nodes greater than root
        binaryTreePaths(head).forEach(System.out::println);
    }

    // Every node is visited indeed once. But the string concatenation operation becomes more expensive
    // when going deeper. So in my opinion, the total time complexity is O ( n logn ).
    private static List<String> binaryTreePaths( Node root ) {

        if (root == null)
            return null;

        List<String> list = new ArrayList<>();

        searchBT(root, "", list);

        return list;
    }

    //this recursion pattern is simple searching of a tree
    private static void searchBT( Node root, String path, List<String> answer ) {
        if (root.left == null && root.right == null)
            answer.add(path + root.data);

        if (root.left != null)
            searchBT(root.left, path + root.data + "->", answer);

        if (root.right != null)
            searchBT(root.right, path + root.data + "->", answer);
    }
}
