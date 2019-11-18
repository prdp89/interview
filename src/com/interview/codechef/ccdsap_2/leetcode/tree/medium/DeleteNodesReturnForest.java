package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesReturnForest {

    //https://leetcode.com/problems/delete-nodes-and-return-forest/
    public static void main( String[] args ) {
        Node head = Node.newNode(1);

        head.left = Node.newNode(2);
        head.right = Node.newNode(3);

        head.left.left = Node.newNode(4);
        head.left.right = Node.newNode(5);

        head.right.left = Node.newNode(6);
        head.right.right = Node.newNode(7);

        List<Node> nodeList = delNodes(head, new int[]{3, 5}); //op : [[1,2,null,4],[6],[7]]
    }

    private static List<Node> delNodes( Node root, int[] to_delete ) {
        List<Node> forest = new ArrayList<>();

        if (root == null)
            return forest;

        Set<Integer> set = new HashSet<>();

        for (int i : to_delete) {
            set.add(i);
        }

        deleteNodes(root, set, forest);

        //At last if Root node is present in Set then we have to add this node to forest too.
        if (!set.contains(root.data)) {
            forest.add(root);
        }

        return forest;
    }

    //This recursion Pattern is same as 'BinaryTreePruning'
    private static Node deleteNodes( Node node, Set<Integer> set, List<Node> forest ) {
        if (node == null)
            return null;

        node.left = deleteNodes(node.left, set, forest);
        node.right = deleteNodes(node.right, set, forest);

        //If we found any node from to_delete set then add both the child into the Forest
        //bcz if parent got deleted then both Nodes are stranded.
        if (set.contains(node.data)) {

            if (node.left != null)
                forest.add(node.left);
            if (node.right != null)
                forest.add(node.right);

            //return null to indicate that Node doesn't need to traverse further
            //same BInaryTreePruning
            return null;
        }

        return node;
    }
}
