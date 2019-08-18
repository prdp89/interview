package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.*;

public class ModeInBST {

    //https://leetcode.com/problems/find-mode-in-binary-search-tree/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(1, head);
        head = bt.addNode(2, head);
        head = bt.addNode(2, head);

        System.out.println(Arrays.toString(findMode(head)));
    }

    //optimal sol : https://leetcode.com/problems/find-mode-in-binary-search-tree/discuss/98100/Java-4ms-Beats-100-Extra-O(1)-solution-No-Map

    //Runtime: 9 ms, faster than 20.58% of Java
    private static int[] findMode( Node root ) {
        List<Integer> list = new ArrayList<>();

        getNodes(root, list);

        int[] arr;

        if (list.size() == 1) {
            arr = new int[1];
            arr[0] = list.get(0);
            return arr;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int occur = -1;
        for (int item : list) {
            map.put(item, map.getOrDefault(item, 0) + 1);
            occur = Math.max(occur, map.getOrDefault(item, 0));
        }

        list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() >= occur) {
                list.add(entry.getKey());
            }
        }

        arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    private static void getNodes( Node root, List<Integer> list ) {

        if (root == null)
            return;

        list.add(root.data);

        getNodes(root.left, list);
        getNodes(root.right, list);
    }
}
