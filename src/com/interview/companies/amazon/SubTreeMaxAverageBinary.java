package com.interview.companies.amazon;

import com.interview.tree.Node;

public class SubTreeMaxAverageBinary {

    //https://mrleonhuang.gitbooks.io/lintcode/binary-tree-and-divide-conquer/subtree-with-maximum-average.html

    private Node maxSubtree;
    private ResultType maxResult;

    /* Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
     Notice
     LintCode will print the subtree which root is your return node.
             It's guaranteed that there is only one subtree with maximum average.
     Example
     Given a binary tree:
               1
             /   \
           -5     11
           / \   /  \
          1   2 4    -2
             return the node : 11.
    */
    public static void main( String[] args ) {

    }

    public Node findSubtree2( Node root ) {
        // Write your code here
        helper(root);
        return maxSubtree;
    }

    private ResultType helper( Node node ) {
        if (node == null) {
            return new ResultType(0, 0);
        }

        ResultType leftResult = helper(node.left);
        ResultType rightResult = helper(node.right);

        int sum = leftResult.sum + rightResult.sum + node.data;
        int count = leftResult.count + rightResult.count + 1;

        ResultType result = new ResultType(sum, count);

        if (maxSubtree == null || maxResult.sum * count < sum * maxResult.count) {
            maxSubtree = node;
            maxResult = result;
        }

        return result;
    }

    class ResultType {
        int sum;
        int count;

        ResultType( int sum, int count ) {
            this.sum = sum;
            this.count = count;
        }
    }
}
