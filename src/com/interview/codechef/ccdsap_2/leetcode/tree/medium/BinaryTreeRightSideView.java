package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    //https://leetcode.com/problems/binary-tree-right-side-view/
    public static void main( String[] args ) {
        Node head = Node.newNode(1);

        head.left = Node.newNode(2);
        head.right = Node.newNode(3);

        head.left.right = Node.newNode(5);

        head.right.right = Node.newNode(4);

        rightSideView(head);
    }

    //Both Recursive and iterative are pretty easy.
    private static List<Integer> rightSideView( Node root ) {
        List<Integer> list = new ArrayList<>();

        if (root == null)
            return null;

        //rightSideViewTry(root, list);

        rightSideViewBFS(root, list);

        rightSideViewRecursive(root, 0, list);

        return list;
    }

    //Runtime: 1 ms, faster than 98.73% of Java
    //same as LevelOrderTraversal
    private static void rightSideViewBFS( Node root, List<Integer> list ) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Node node = queue.poll();
                if (i == size - 1)
                    list.add(node.data);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
        }
    }

    private static void rightSideViewRecursive( Node root, int level, List<Integer> list ) {
        if (root == null)
            return;

        //Step 1 : First time list.size is 0, then we add root.data
        //when Level == 1 , from Step 1 list.size is also 1, so we add right side data
        if (list.size() == level)
            list.add(root.data);

        //Step2 : We traverse to Right side first, to find right view;
        //        Level + 1 helps to increase the Level to match list.size
        rightSideViewRecursive(root.right, level + 1, list);

        //traverse to Left when Right found NULL and return from Base case.
        rightSideViewRecursive(root.left, level + 1, list);
    }

    private static void rightSideViewTry( Node root, List<Integer> list ) {

        if (root == null)
            return;

        list.add(root.data);

        if (root.right != null) {
            rightSideViewTry(root.right, list);
        }
    }
}