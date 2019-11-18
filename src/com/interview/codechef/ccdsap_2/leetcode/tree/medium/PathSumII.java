package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    static List<List<Integer>> res = new ArrayList<>();

    //https://leetcode.com/problems/path-sum-ii/
    public static void main( String[] args ) {
        Node head = Node.newNode(5);

        head.left = Node.newNode(4);
        head.right = Node.newNode(8);

        head.left.left = Node.newNode(11);

        head.left.left.left = Node.newNode(7);
        head.left.left.right = Node.newNode(2);

        head.right.left = Node.newNode(13);
        head.right.right = Node.newNode(4);

        head.right.right.left = Node.newNode(5);
        head.right.right.right = Node.newNode(1);

        pathSum(head, 22);

        System.out.println("kutta...");
    }

    //Runtime: 1 ms, faster than 100.00% of Java
    private static List<List<Integer>> pathSum( Node root, int sum ) {

        List<Integer> list = new ArrayList<>();
        pathSum(root, sum, list);


        return res;
    }

    //Recursion almost similar to PathSum

    //Only need to take case of is backtracking part : when a branch finishes or we found the sum item has to be removed from List.
    private static void pathSum( Node root, int sum, List<Integer> list ) {

        if (root == null)
            return;

        if (root.left == null && root.right == null && sum - root.data == 0) {
            list.add(root.data);

            //this will not work; has to use with new instance in res list
            //res.add(list);

            res.add(new ArrayList<>(list));

            list.remove(list.size() - 1);
            return;
        }

        list.add(root.data);
        pathSum(root.left, sum - root.data, list);

        //i tried removing last item of list here when left recursion finishes,
        //but it should be done when both branches completed
        //list.remove(list.size() - 1);

        pathSum(root.right, sum - root.data, list);

        list.remove(list.size() - 1);
    }
}
