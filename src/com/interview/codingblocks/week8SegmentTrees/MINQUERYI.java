package com.interview.codingblocks.week8SegmentTrees;

import java.util.Scanner;

//https://hack.codingblocks.com/contests/c/473/309
public class MINQUERYI {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int arrSize = scanner.nextInt();
        int queries = scanner.nextInt();

        int[] arr = new int[arrSize];

        for (int i = 0; i < arrSize; i++) {
            arr[i] = scanner.nextInt();
        }


        //If we count tree as complete binary tree then tree length will be :
        //2 * (2 ^ (Log Base2 N)) - 1 => 4 * N + 1
        int[] tree = new int[4 * arr.length + 1];

        buildTree(tree, arr, 1, 0, arr.length - 1);

        while (queries-- > 0) {
            int operation = scanner.nextInt();
            int input_1 = scanner.nextInt();
            int input_2 = scanner.nextInt();


            if (operation == 1)
                //calling Minimum query function in a range.
                System.out.println(query(tree, 1, 0, arr.length - 1, input_1 - 1, input_2 - 1));
            else
                //calling update Node function....
                updateNode(tree, 1, 0, arr.length - 1, input_1 - 1, input_2);
        }
    }

    private static void buildTree( int[] tree, int[] arr, int index, int s, int e ) {

        //Base case
        if (s > e) {
            return;
        }

        //Base case : Leaf node : bcz at leaf node Start and end will be equal
        // And we start to fill 'tree' array from 'arr; array
        if (s == e) {
            tree[index] = arr[s];

            //after assigning left and right element to tree.
            //The callback will reach to Step 3, where we assign value to its parent by Comparing Min(Left, Right).
            return;
        }

        //Recursive case
        int mid = (s + e) / 2;

        //Step1 : Build left subtree
        buildTree(tree, arr, 2 * index, s, mid);

        //Step2 : Build right subtree
        buildTree(tree, arr, 2 * index + 1, mid + 1, e);

        //Step 3 : Fill the Parent node with Minimum element
        int left = tree[2 * index];
        int right = tree[2 * index + 1];

        tree[index] = Math.min(left, right);
    }

    private static int query( int[] tree, int index, int s, int e, int queryS, int queryE ) {

        //3 cases :

        //1. No Overlap: If query Start is greater than Array range OR Query End is less than Start range
        if (queryS > e || queryE < s) {
            return Integer.MAX_VALUE;
        }

        //2. Complete Overlap: If element lies in a range.
        if (s >= queryS && e <= queryE)
            return tree[index];

        //3. Partial Overlap: We have to call both sides :
        int mid = (s + e) / 2;

        //query in left part :
        int leftAns = query(tree, 2 * index, s, mid, queryS, queryE);

        //query in right part :
        int rightAns = query(tree, 2 * index + 1, mid + 1, e, queryS, queryE);

        return Math.min(leftAns, rightAns);
    }

    private static void updateNode( int[] tree, int index, int start, int end, int updateIndex, int updatedValue ) {

        //Base case: No overlap
        if (updateIndex < start || updateIndex > end)
            return;

        //Case: If we reach the leaf node, then assign the Updated Value to that node.
        if (start == end) {
            tree[index] = updatedValue;
            return;
        }

        //Case: Partial overlap: UpdatedIndex lies in [s, e]
        // Means we didn't reach to the target node. Make two calls :
        int mid = (start + end) / 2;

        //call to left part of tree
        updateNode(tree, 2 * index, start, mid, updateIndex, updatedValue);

        //call to right part of tree
        updateNode(tree, 2 * index + 1, mid + 1, end, updateIndex, updatedValue);

        //updated the root node after left and right calls
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
        // return;
    }

}
