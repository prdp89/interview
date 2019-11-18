package com.interview.codechef.ccdsap_2.leetcode.tree.medium;

import com.interview.tree.Node;

public class MaxDiffNodeAncestor {

    //https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
    public static void main( String[] args ) {

        maxAncestorDiff(null);
    }

    //ref:https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/discuss/274610/JavaC%2B%2BPython-Top-Down
    //Another easy idea : https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/discuss/284685/non-recursive-C%2B%2B-solution(beat-99.72)-concisely-explained
    private static int dfs( Node n, int max, int min ) {
        //it means we reach to the last node; so returning Current Max-Min difference
        if (n == null)
            return (max - min);

        max = Math.max(n.data, max); // update max.
        min = Math.min(n.data, min); // update min.

        int l = dfs(n.left, max, min); // recurse down.
        int r = dfs(n.right, max, min); // recurse down.

        return Math.max(l, r); // return Max from Left/right branching of Tree
    }

    private static int maxAncestorDiff( Node root ) {
        if (root == null)
            return 0;

        return dfs(root, root.data, root.data); // initialize both max and min with root.val.
    }
}
