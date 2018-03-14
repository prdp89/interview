package com.interview.tree;

/**
 * Date 04/27/2016
 * @author Tushar Roy
 *
 * Find lowest common ancestor in binary tree.
 *
 * Time complexity O(n)
 * Space complexity O(h)
 */
public class LowestCommonAncestorInBinaryTree {

    static class Node
    {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    // Root of the Binary Tree
    Node root;

    public Node lca(Node root, Node n1, Node n2){
        if(root == null){
            return null;
        }

        //if a key
        // is ancestor of other, then the ancestor key becomes LCA)
        if(root == n1 || root == n2){
            return root;
        }
        
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if(left != null && right != null){
            return root;
        }

        //This condition runs at last..............
        // Otherwise check if left subtree or right subtree is LCA
        return left != null ? left : right;
    }

    public static void main(String args[])
    {
        LowestCommonAncestorInBinaryTree tree = new LowestCommonAncestorInBinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node lca = tree.lca(tree.root, tree.root.left.left, tree.root.left.right);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.data);

        //lowestCommonAncestorInBinaryTree.lca(root, )
    }
}
