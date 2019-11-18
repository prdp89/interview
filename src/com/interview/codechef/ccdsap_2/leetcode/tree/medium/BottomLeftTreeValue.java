package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BottomLeftTreeValue {

    //https://leetcode.com/problems/find-bottom-left-tree-value/
    public static void main( String[] args ) {

        Node head = Node.newNode(1);

        head.left = Node.newNode(2);
        head.right = Node.newNode(3);

        head.left.left = Node.newNode(4);

        head.right.left = Node.newNode(5);
        head.right.right = Node.newNode(6);

        head.right.left.left = Node.newNode(7);

        //System.out.println(findBottomLeftValueLevelOrderTraversal(head)); //op : 7

        System.out.println(findBottomLeftValueRecursive(head));
    }


    //same as Height of Tree : https://leetcode.com/problems/find-bottom-left-tree-value/discuss/98806/C%2B%2B-Clean-Code-DFS-Recursion-with-Explanation
    private static int findBottomLeftValueRecursive( Node root ) {
        if (root == null)
            return 0;

        int[] res = {0, 0}; //stores height and res; index 0 = height; 1 = res
        dfs(root, 1, res);
        return res[1];
    }

    //I tried using separate variable for Height but it returns Wrong answer
    //So, using res[] array for both Height and result node->data
    private static void dfs( Node root, int depth, int[] res ) {

        if (root == null)
            return;

        //if current depth is bigger than required; this only happen when on First Left recursion
        if (res[0] < depth) {
            res[0] = depth;
            res[1] = root.data; // update res only when redefine the height
        }

        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }

    //LOgic same as LevelOrderTraversal
    private static int findBottomLeftValueLevelOrderTraversal( Node root ) {

        if (root == null)
            return 0;

        int result = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                //every time we poll; we keep first leftmost node as result
                if (i == 0)
                    result = node.data;

                //since we adding in order : Left then Right
                //POLL order is same as Left then Right.
                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
        }

        return result;
    }
}
