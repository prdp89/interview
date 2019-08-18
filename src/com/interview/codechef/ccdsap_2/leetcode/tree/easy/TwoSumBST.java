package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TwoSumBST {

    //https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(5, head);
        head = bt.addNode(3, head);
        head = bt.addNode(6, head);
        head = bt.addNode(2, head);
        head = bt.addNode(4, head);
        head = bt.addNode(7, head);

        int k = 9;

        System.out.println(findTarget(head, 9));
    }

    //Runtime: 8 ms, faster than 12.19%
    private static boolean findTarget( Node root, int k ) {

        if (root == null)
            return false;

        HashSet<Integer> list = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node node = queue.poll();
            list.add(node.data);

            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);
        }

        //instead of map removal two pointers can be used like this :
        /*
         for(int i = 0, j = list.size()-1; i<j;){
            if(list.get(i) + list.get(j) == k)return true;
            if(list.get(i) + list.get(j) < k)i++;
            else j--;
        }
         */
        if (list.size() >= 2) {
            for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
                Integer element = it.next();
                int val = k - element;

                it.remove();

                if (list.contains(val))
                    return true;
            }
        }

        return false;
    }
}
