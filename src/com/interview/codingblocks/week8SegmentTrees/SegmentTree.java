package com.interview.codingblocks.week8SegmentTrees;

import java.util.Arrays;
import java.util.Scanner;

public class SegmentTree {

    //source : https://www.youtube.com/watch?v=FR5d4V7Z9SE
    //Check Axis bank diary for notes on: 8/16/18
    public static void main( String[] args ) {

        //int arr[] = {1, 2, 0, 3};
        int arr[] = {1, -2, 0, 3};

        //TO store all elements in tree form : 2 * N - 1 [this doesn't include empty node]

        //If we count tree as complete binary tree then tree length will be :
        //2 * (2 ^ (Log Base2 N)) - 1 => 4 * N + 1
        int[] tree = new int[4 * arr.length + 1];

        buildTree(tree, arr, 1, 0, arr.length - 1);

        //printing the new Tree Array
        System.out.println(Arrays.toString(tree));

        //Taking input of number of queries:
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Arr[index] Arr[value] to update:");
        int updatedIndex = scanner.nextInt();
        int updatedValue = scanner.nextInt();

        //calling update Node function....
        updateNode(tree, 1, 0, arr.length - 1, updatedIndex, updatedValue);

        System.out.println("Enter Arr[StartRange] Arr[EndRange] & IncrementedValue to update:");
        int startIndexRange = scanner.nextInt();
        int endIndexRange = scanner.nextInt();
        int incrementedValue = scanner.nextInt();

        //calling range update queries function..
        updateRangeOfNodes(tree, 1, 0, arr.length - 1, startIndexRange, endIndexRange, incrementedValue);

        System.out.println("Enter number of queries in an array:");
        int numberOfQueries = scanner.nextInt();

        while (numberOfQueries-- > 0) {

            System.out.println(Arrays.toString(arr));
            System.out.println("Enter Arr[start] and Arr[End] index to find min. in a range:");

            int queryStart = scanner.nextInt();
            int queryEnd = scanner.nextInt();

            System.out.printf("Min value between Arr[%S, %S] : \n", String.valueOf(queryStart), String.valueOf(queryEnd));

            //calling Minimum query function in a range.
            System.out.println(query(tree, 1, 0, arr.length - 1, queryStart, queryEnd));

            System.out.println(Arrays.toString(arr));
        }
    }


    //If array = {1 ,2, 0 , 3}
    //Then Minimum element tree will be :
    //                                      0
    //                                     [0-3]
    //                                    /    \
    //                                   1      0
    //                                  [0-2]  [2-3]
    //                                  /  \    /  \
    //                                 1    2   0   3
    //                              [0-0] [1-1] [2-2]  [3-3]  == This is the base case

    //Root node 0 indicate that zero is the Minimum element of array
    //Left Node 1 of [0-2] indicates : 1 is minimum of subtree 1 & 2 and so on..
    //At each level array divide into two parts : Left = 0 .. Length / 2 and Right = (Length / 2) + 1 .. Length

    //After converting an array to tree array = { 0 , 0 , 1, 0 , 1, 2, 0 , 3, 0 , 0 , 0 ,0..}
    //Time complexity to build a tree : O ( N )
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


    //Now we want to query the tree we build above :
    // An array give is : array = {1 ,2, 0 , 3}
    //                                      0
    //                                     [0-3]
    //                                    /    \
    //                                   1      0
    //                                  [0-2]  [2-3]
    //                                  /  \    /  \
    //                                 1    2   0   3
    //                              [0-0] [1-1] [2-2]  [3-3]

    //Query case 1 : If we want min. element between array index [L,R] : {0,3} => 0 => Root node
    //         In this case, value [L , R] lies between [S , E]. So this is called COMPLETE OVERLAP.
    //         In this case Query Range [L,R] = {0,3} >= [S , E]

    //Query case 2 : If we want min. element between array index [L,R] : {0, 2} ; [L , R] is smaller than [S , E] so,
    //               In this case, we make two calls from Root node : 1. [0 - 2]  2. [2 - 3]
    //               1. For [0, 2] : Now [L, R] >= [S , E]. This is the case of PARTIAL OVERLAP. So we return value = 1 to root node from this point.
    //               2. For [2, 3] : Now our original query [0 , 2] doesn't come in range of [3, 5]. THis is the case of NO OVERLAP.
    //                               So we returns INFINITY from this point.
    //               NOw take Min(1, INFINITY) = 1 = Answer to query [0 ,2]

    //THis method returns minimum element in a TREE lies in a range [quesryS , queryE]
    //TIme complexity for each query : O (Log N)
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


    //Now we want to update the tree node we build above :
    // An array give is : array = {1 ,-2, 0 , 3}
    //                                      -2
    //                                     [0-3]
    //                                    /    \
    //                                   -2      0
    //                                  [0-2]  [2-3]
    //                                  /  \    /  \
    //                                 1   -2   0   3
    //                              [0-0] [1-1] [2-2]  [3-3]

    //Query 1 : A query to update 1st index of an array {1, -2 , 0 ,3} to 4 : a[1] = 4 => {1, 4, 0, 3}
    //          1 lies between  [0 - 3] so we make two calls from root : left and right
    //          Left Level-1 [0 - 2]: query "1st" index lies between [0 - 2] so again two calls: left and right
    //                                Left Index [0-0] : query "1st" index doesn't lie here, so return empty.
    //                                Right Index [1-1] : query "1st" index lies here so update 2 to 4
    //                                                    NOw return Min(1, 4) to root of [0 - 2]
    //          Left Level-1 [0 - 2]: Now becomes 1 : Min(1,4)
    //          Right Level-1 [2-3] : This doesn't change its value, but Min(0, 1) returned to root node
    //          Root node[0 - 3]: This root node is Min(0,1) = 0, So root also change from -2 to 0.
    //          New tree becomes :
    //                                       0
    //                                     [0-3]
    //                                    /    \
    //                                   1      0
    //                                  [0-2]  [2-3]
    //                                  /  \    /  \
    //                                 1    4   0   3  ==> This node [1-1] updated to 4 from -2
    //                              [0-0] [1-1] [2-2]  [3-3]

    //Time complexity to update : O (Log N)
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

    //Now we have update a Range of values between Range Start RS and Range End RE
    //Given : RU[1, 2] = 4 : means increment 4 between the values in range of [1, 2]
    //Time complexity to update a range : O ( N )
    private static void updateRangeOfNodes( int[] tree, int index, int start, int end, int rangeStart, int rangeEnd, int incrementValue ) {


        // Case 1. No Overlap: If query Start is greater than Array range OR Query End is less than Start range
        if (rangeEnd < start || rangeStart > end) {
            return;
        }

        // Case 2. Reached Leaf Node
        if (start == end) {
            tree[index] += incrementValue;
            return;
        }

        //Case 3. If value lies in a Range : Call both sides
        int mid = (start + end) / 2;

        //calling left side
        updateRangeOfNodes(tree, 2 * index, start, mid, rangeStart, rangeEnd, incrementValue);

        //calling right side
        updateRangeOfNodes(tree, 2 * index + 1, mid + 1, end, rangeStart, rangeEnd, incrementValue);

        //updating Tree root node after left and right calls.
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }
}

