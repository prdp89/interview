package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import java.util.*;

public class NAryTreeLevelOrder {

    //https://leetcode.com/problems/n-ary-tree-level-order-traversal/
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

        // List<List<Integer>> outList = levelOrder(head);
        List<List<Integer>> outList = levelOrderOptimal(head);
        for (List<Integer> value : outList) {
            value.forEach(System.out::println);
        }
    }

    //20 / 36 test cases passed :(
    private static List<List<Integer>> levelOrder( NAryTreePreOrder.Node root ) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Stack<NAryTreePreOrder.Node> stack = new Stack<>();
        stack.add(root);

        List<Integer> child = new ArrayList<>();

        child.add(root.val);
        list.add(child);

        while (!stack.empty()) {
            child = new ArrayList<>();

            root = stack.pop();

            //looping reverse so that First Leftmost child will be on top
            if (null != root.children) {
                for (int i = root.children.size() - 1; i >= 0; i--) {

                    child.add(0, root.children.get(i).val);

                    stack.add(root.children.get(i));
                }

                if (!child.isEmpty())
                    list.add(child);
            }
        }

        return list;
    }

    private static List<List<Integer>> levelOrderOptimal( NAryTreePreOrder.Node root ) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<NAryTreePreOrder.Node> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> child = null;

        while (!queue.isEmpty()) {

            child = new ArrayList<>();
            int size = queue.size(); //getting each level size

            //for each level adding its children to the child list
            for (int i = 0; i < size; i++) {
                NAryTreePreOrder.Node popChild = queue.poll();
                child.add(popChild.val);

                //Now for each popped child get its children's;
                // this helps in getting each level children at one place
                if (null != popChild.children) {

                    //queue is needed here; when pop-child element adds it should be at last
                    for (int j = 0; j < popChild.children.size(); j++) {
                        queue.add(popChild.children.get(j));
                    }
                }
            }

            //finally we got each child level items.
            list.add(child);
        }

        return list;
    }
}