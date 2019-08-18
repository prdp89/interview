package com.interview.codechef.ccdsap_2.leetcode.tree.easy;

import com.interview.tree.BinaryTree;
import com.interview.tree.Node;

public class CousinsBinaryTree {

    static int heightGlobal = -1;

    //https://leetcode.com/problems/cousins-in-binary-tree/
    public static void main( String[] args ) {
        BinaryTree bt = new BinaryTree();

        Node head = null;
        head = bt.addNode(4, head);
        head = bt.addNode(2, head);
        head = bt.addNode(7, head);
        head = bt.addNode(1, head);
        head = bt.addNode(3, head);
        head = bt.addNode(8, head);

        print("", head, false);

        System.out.println(isCousins(head, 1, 8));
    }

    //Almost solved it...
    private static boolean isCousins( Node root, int x, int y ) {

        Node first = Node.newNode(0);
        Node second = Node.newNode(0);

        heightGlobal = -1;
        /*int depth1 = heightOfNode(root, x, -1, first);
        int depth2 = heightOfNode(root, y, -1, second);*/

        heightOfNodeCorrect(root, x, -1, first);
        int depth1 = heightGlobal;
        heightGlobal = -1;
        heightOfNodeCorrect(root, y, -1, second);
        int depth2 = heightGlobal;

        return depth1 == depth2 && first != second;
    }

    //still not passing all test cases;
    //follow : https://leetcode.com/problems/cousins-in-binary-tree/discuss/240081/Java-easy-to-understand-and-clean-solution
    //this user assign global parent node directly; that help in getting correct parent address.
    private static void heightOfNodeCorrect( Node root, int xOrYHeight, int height, Node parent ) {
        if (root == null)
            return;

        if (root.data == xOrYHeight) {
            heightGlobal = height;
            // return;
        }

        //traversing each level for searching a node with height + 1
        heightOfNodeCorrect(root.left, xOrYHeight, height + 1, root); //passing root to keep parent
        heightOfNodeCorrect(root.right, xOrYHeight, height + 1, root);
    }

    //85 / 103 test cases passed.
    //due to Math.max it returns incorrect height sometimes
    private static int heightOfNode( Node root, int xOrYHeight, int height, Node parent ) {
        if (root == null)
            return 0;

        if (root.data == xOrYHeight)
            return height;

        return Math.max(heightOfNode(root.left, xOrYHeight, height + 1, root) //passing root to keep parent
                , heightOfNode(root.right, xOrYHeight, height + 1, root));

    }

    private static void print( String prefix, Node n, boolean isLeft ) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

}
