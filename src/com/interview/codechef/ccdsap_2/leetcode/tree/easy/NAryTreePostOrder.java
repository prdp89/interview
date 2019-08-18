package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NAryTreePostOrder {

    //https://leetcode.com/problems/n-ary-tree-postorder-traversal/
    public static void main( String[] args ) {

        NAryTreePostOrder nAryTree = new NAryTreePostOrder();

        //region N-Ary INIT
        NAryTreePreOrder.Node head;
        List<NAryTreePreOrder.Node> child = new ArrayList<>();

        List<NAryTreePreOrder.Node> smallChild = new ArrayList<>();

        smallChild.add(new NAryTreePreOrder.Node(5, null));
        smallChild.add(new NAryTreePreOrder.Node(6, null));

        child.add(new NAryTreePreOrder.Node(3, smallChild));

        child.add(new NAryTreePreOrder.Node(2, null));
        child.add(new NAryTreePreOrder.Node(4, null));
        //endregion

        head = new NAryTreePreOrder.Node(1, child);

        List<Integer> outList = postorder(head);
        for (int value : outList) {
            System.out.print(value + " ");
        }
    }

    //solved in one attempt
    private static List<Integer> postorder( NAryTreePreOrder.Node root ) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<NAryTreePreOrder.Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();

            list.add(0, root.val);

            if (null != root.children) {
                for (int i = 0; i <= root.children.size() - 1; i++)
                    stack.add(root.children.get(i));
            } else {
                list.add(0, stack.pop().val);
            }
        }

        return list;
    }
}
