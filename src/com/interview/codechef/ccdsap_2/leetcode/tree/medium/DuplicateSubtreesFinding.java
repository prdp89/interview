package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DuplicateSubtreesFinding {

    //https://leetcode.com/problems/find-duplicate-subtrees/
    public static void main( String[] args ) {
        Node head = Node.newNode(1);

        head.left = Node.newNode(2);
        head.right = Node.newNode(3);

        head.left.left = Node.newNode(4);

        head.right.left = Node.newNode(2);
        head.right.right = Node.newNode(4);

        head.right.left.left = Node.newNode(4);

        List<Node> res = findDuplicateSubtrees(head);
    }

    private static List<Node> findDuplicateSubtrees( Node root ) {

        List<Node> res = new LinkedList<>();

        //Hashmap stores all subtree of a Tree with it's occurrence
        HashMap<String, Integer> map = new HashMap<>();

        postorder(root, map, res);

        return res;
    }

    private static String postorder( Node cur, Map<String, Integer> map, List<Node> res ) {
        if (cur == null)
            return "#"; //# indicate NULL leaf

        //traversing like pre-order traversal
        String serial = cur.data + ","
                + postorder(cur.left, map, res) + ","
                + postorder(cur.right, map, res);

        //if Map already contain that Sub-Tree then add to the result List.
        if (map.getOrDefault(serial, 0) == 1)
            res.add(cur); //storing the curr node in list as Head of that list

        //storing each subtree occurrence
        map.put(serial, map.getOrDefault(serial, 0) + 1);

        return serial;
    }
}
