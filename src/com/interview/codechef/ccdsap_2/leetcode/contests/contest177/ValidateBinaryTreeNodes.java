package com.interview.codechef.ccdsap_2.leetcode.contests.contest177;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValidateBinaryTreeNodes {

    //https://leetcode.com/problems/validate-binary-tree-nodes/
    public static void main( String[] args ) {
        int[] leftChild = {1, -1, 3, -1};
        int[] rightChild = {2, -1, -1, -1};

        System.out.println(validateBinaryTreeNodes(4, leftChild, rightChild));
    }

    //ref: https://leetcode.com/problems/validate-binary-tree-nodes/discuss/517598/Java-check-in-degree-and-root-O(n)-code-w-analysis-.
    private static boolean validateBinaryTreeNodes( int n, int[] left, int[] right ) {
        //bcz we have n binary tree nodes numbered from 0 to n - 1
        Set<Integer> nodes = IntStream.range(0, n).boxed().collect(Collectors.toCollection(HashSet::new));

        int[] inDegree = new int[n];

        for (int i = 0; i < n; ++i) {

            for (int j : new int[]{left[i], right[i]}) {

                if (j >= 0) {

                    //in a tree every node has indegree of 1
                    if (++inDegree[j] > 1)
                        return false;

                    nodes.remove(j);
                }
            }
        }
        return nodes.size() == 1;
    }
}
