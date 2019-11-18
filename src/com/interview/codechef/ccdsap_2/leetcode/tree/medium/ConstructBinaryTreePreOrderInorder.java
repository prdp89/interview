package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

public class ConstructBinaryTreePreOrderInorder {

    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

    //video : https://www.youtube.com/watch?v=PoBGyrIWisE
    //Desc : is at axis bank diary 2017
    public static void main( String[] args ) {

        //picking root from prerder
        int[] preOrder = {3, 9, 20, 15, 7};

        //left right node from inorder
        int[] inOrder = {9, 3, 15, 20, 7};

        Node node = build(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    //little tricky implementation; but easy to understand
    //check Diary Tree Diagram if confused; easy...peasy :)
    private static Node build( int[] preorder, int preOrderLow, int preOrderHigh, int[] inorder, int inOrderLow, int inOrderHigh ) {

        if (preOrderLow > preOrderHigh || inOrderLow > inOrderHigh)
            return null;

        Node root = Node.newNode(preorder[preOrderLow]);

        //we are trying to find root.data means preOrder[preOrderLow] element in InOrder array.
        //From inOrderLow....inorderRoot - 1 will be the Left subtree of Root
        //why inOrderRoot - 1 : bcz inorderRoot will be the root element :)
        int inorderRoot = inOrderLow;
        for (int i = inOrderLow; i <= inOrderHigh; i++) {
            if (inorder[i] == root.data) {
                inorderRoot = i;
                break;
            }
        }

        //leftTreeLen  : helps to pick left /Right subtree for Recursion.
        int leftTreeLen = inorderRoot - inOrderLow;

        //preOrderLow + 1 : to pick new Root node as Preorder array's next element
        //preOrderLow + leftTreeLen : for Left Sub Tree we'll only pick this much Node's from Pre-order Array.
        //inOrderLow : for Left Sub Tree inorderLow will be the starting point
        //inorderRoot - 1 : for Left Sub Tree of Root this will be the endpoint point

        root.left = build(preorder, preOrderLow + 1, preOrderLow + leftTreeLen, inorder, inOrderLow, inorderRoot - 1);

        //vice-versa for right sub tree
        root.right = build(preorder, preOrderLow + leftTreeLen + 1, preOrderHigh, inorder, inorderRoot + 1, inOrderHigh);

        return root;
    }
}
