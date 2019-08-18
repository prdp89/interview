package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class PathSumIII {

    private static int count = 0;

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

    //ref : https://leetcode.com/problems/path-sum-iii/discuss/91889/Simple-Java-DFS
    private static int pathSum( Node root, int sum ) {
        if (root == null)
            return 0;

        int pathImLeading = count(root, sum);

        //since sum can exist on any path; so checking each node's left/right
        int leftPathSum = pathSum(root.left, sum);

        int rightPathSum = pathSum(root.right, sum);

        return leftPathSum + rightPathSum + pathImLeading;
    }

    private static int count( Node node, int sum ) {
        if (node == null)
            return 0;

        //similar to try logic above
        int isMe = (node.data == sum) ? 1 : 0;

        //we need to add left and right as well; they can also contribute in sum
        int leftBrother = count(node.left, sum - node.data);

        int rightBrother = count(node.right, sum - node.data);

        return isMe + leftBrother + rightBrother;
    }
}