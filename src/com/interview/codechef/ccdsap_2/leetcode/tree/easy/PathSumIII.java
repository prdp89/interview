package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class PathSumIII {

    private static int count = 0;
    private static int cnt;

    //https://leetcode.com/problems/path-sum-iii/
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(5, head);
        head = bt.addNode(2, head);
        head = bt.addNode(13, head);
        head = bt.addNode(1, head);
        head = bt.addNode(3, head);
        head = bt.addNode(11, head);
        head = bt.addNode(15, head);

        //pathSumTry(head, 8);

        System.out.println(pathSum(head, 8));
    }

    private static int pathSumTry( Node root, int sum ) {

        if (root == null)
            return 0;

        if (sum - root.data == 0)
            return count++;

        pathSumTry(root.left, sum - root.data);
        pathSumTry(root.right, sum - root.data);

        return 0;
    }

    //https://leetcode.com/problems/path-sum-iii/discuss/268961/Java-DFS-easy-understanding
    private static int pathSum( Node root, int sum ) {
        cnt = 0;

        find(root, sum);

        return cnt;
    }

    private static void find( Node root, int sum ) {
        if (root == null)
            return;

        path(root, sum);

        find(root.left, sum);
        find(root.right, sum);
    }

    private static void path( Node root, int sum ) {
        if (root == null)
            return;

        if (sum - root.data == 0)
            cnt++;

        path(root.left, sum - root.data);
        path(root.right, sum - root.data);
    }
}