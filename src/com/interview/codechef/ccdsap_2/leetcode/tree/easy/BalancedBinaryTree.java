package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class BalancedBinaryTree {

    //https://leetcode.com/problems/balanced-binary-tree/

    //Read both versions of it..
    public static void main( String[] args ) {

        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(4, head);
        head = bt.addNode(7, head);
        head = bt.addNode(2, head);
        head = bt.addNode(1, head);
        head = bt.addNode(3, head);
        head = bt.addNode(6, head);

        //System.out.println(isBalanced(head));

        System.out.println(isBalancedOPtimal(head));
    }

    //207 / 227 test cases passed :)
    //At each level comparing depth of left and right subtree
    //This approach is ineficient bcz I am calculating height at each level, which leads to duplicate height calculation.
    private static boolean isBalanced( Node root ) {

        if (root == null)
            return true;

        Queue<Node> nodes = new ArrayDeque<>();

        if (root.left != null)
            nodes.offer(root.left);

        if (root.right != null)
            nodes.offer(root.right);

        while (!nodes.isEmpty()) {
            Node left = nodes.poll();
            Node right = nodes.poll();

            if (Math.abs(height(left) - height(right)) > 1)
                return false;

            if (left != null && left.left != null && left.right != null) {
                nodes.offer(left.left);
                nodes.offer(left.right);
            }

            if (right != null && right.left != null && right.right != null) {
                nodes.offer(right.left);
                nodes.offer(right.right);
            }
        }

        return true;
    }

    public static int height( Node root ) {
        if (root == null)
            return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }


    /*
     Kick off the recursion, the result will be what we return
   */
    //https://www.youtube.com/watch?v=LU4fGD-fgJQ
    private static boolean isBalancedOPtimal( Node root ) {
        return checkBalanced(root).isBalanced;
    }

    //This is really good example of recursion
    //IT teaches how to propagate result from bottom to top, that helps in avoid recalculation.
    private static BalanceStatusWithHeight checkBalanced( Node root ) {

  /*
    Base case, an empty subtree is balanced and has a height of -1 as
    we define it (since it is technically below "sea level", weird
    analogy)
  */
        if (root == null) {
            return new BalanceStatusWithHeight(true, -1); //bcz leaf has height -1
        }

  /*
    Go deep into the left subtree and get a result back
  */
        BalanceStatusWithHeight leftResult = checkBalanced(root.left);
        if (!leftResult.isBalanced) {
            return leftResult; // Left subtree is not balanced. Bubble up failure.
        }

  /*
    Go deep into the right subtree and get a result back
  */
        BalanceStatusWithHeight rightResult = checkBalanced(root.right);
        if (!rightResult.isBalanced) {
            return rightResult; // Right subtree is not balanced. Bubble up failure.
        }

  /*
    Our left and right subtrees are back and we have our results. Let us analyze
    them here and bubble up our own answer.
    1.) Check if the subtreesAreBalanced
    2.) Notate the height that this node sits at (which is 1 plus the height of the
    larger of the left and right subtrees coming off of this node)
  */
        boolean subtreesAreBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;

        //same of HeightOfTree
        int height = Math.max(leftResult.height, rightResult.height) + 1;

        return new BalanceStatusWithHeight(subtreesAreBalanced, height);
    }

    private static class BalanceStatusWithHeight {
        public int height;
        boolean isBalanced;

        BalanceStatusWithHeight( boolean isBalanced, int height ) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
