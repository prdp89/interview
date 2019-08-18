package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.*;

public class ConvertBSTtoGreaterTree {

    //https://leetcode.com/problems/convert-bst-to-greater-tree/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(5, head);
        head = bt.addNode(2, head);
        head = bt.addNode(13, head);

        Node node = convertBSTOptimal(head);
        print("", node, false);
    }

    //tried but couldn't think of logic
    private static Node convertBST( Node root ) {

        List<List<Integer>> data = new ArrayList<>();
        printLevelOrderBFS(root, data);

        return null;
    }

    private static void printLevelOrderBFS( Node root, List<List<Integer>> data ) {
        //queue is taken bcz each level children will be added at last this way
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {

                Node node = queue.poll();

                list.add(node.data);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
            data.add(list);
        }
    }

    //One thing need to understand: Element greater than node always on right; so traverse to node.right
    //Instead of creating a sum of new tree we can update the values of existing tree.
    //This method is also called reversed inorder traversal : right -> root -> left
    private static Node convertBSTOptimal( Node root ) {
        Node node = root;
        Stack<Node> stack = new Stack<>();

        int sum = 0;

        while (node != null || stack.size() > 0) {

            //moving right direction in search of greater element
            if (node != null) {

                //element on rightmost will be popped out first
                stack.push(node);
                node = node.right;
            } else {

                //if reach to the rightmost then popout and assign it a sum value
                node = stack.pop();
                sum += node.data;
                node.data = sum;

                //move to left in search of more elements
                //left is always smaller than right so it's sum is : node.data + sum
                node = node.left;
            }
        }

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