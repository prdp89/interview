package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NAryTreePreOrder {

    //https://leetcode.com/problems/n-ary-tree-preorder-traversal/
    public static void main( String[] args ) {
        NAryTreePreOrder nAryTree = new NAryTreePreOrder();

        //region N-Ary INIT
        Node head;
        List<Node> child = new ArrayList<>();

        List<Node> smallChild = new ArrayList<>();

        smallChild.add(new Node(5, null));
        smallChild.add(new Node(6, null));

        child.add(new Node(3, smallChild));

        child.add(new Node(2, null));
        child.add(new Node(4, null));
        //endregion

        head = new Node(1, child);

        List<Integer> outList = preorder(head);
        for (int value : outList) {
            System.out.print(value + " ");
        }
    }

    private static List<Integer> preorder( Node root ) {

        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();

            //adding to the list the order we are getting the root
            list.add(root.val);

            //looping reverse so that First Leftmost child will be on top
            if (null != root.children)
                for (int i = root.children.size() - 1; i >= 0; i--)
                    stack.add(root.children.get(i));
        }

        return list;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node( int _val, List<Node> _children ) {
            val = _val;
            children = _children;
        }
    }
}
