package com.interview.codechef.ccdsap_2.leetcode.dp.medium;

public class UniqueBST {

    //https://leetcode.com/problems/unique-binary-search-trees/

    //THis problem is same as : CatalanNumbers : com.interview.codingblocks.week2;
    public static void main( String[] args ) {
        System.out.println(numTrees(3));
    }

    /*
    Given a sequence 1…n, we pick a number i out of the sequence as the root,
    then the number of unique BST with the specified root F(i), is the cartesian product of the number of BST
    for its left and right subtrees.

    For example, F(3, 7): the number of unique BST tree with number 3 as its root.
    To construct an unique BST out of the entire sequence [1, 2, 3, 4, 5, 6, 7] with 3 as the root,
    which is to say, we need to construct an unique BST out of its left subsequence [1, 2] and another BST
    out of the right subsequence [4, 5, 6, 7], and then combine them together (i.e. cartesian product).
     */

    //My Explanation:
    //              G( 3 )
    //           /      \       \
    //        F(1,3)   F(2,3)   F(3,3)  choosing {1,2,3} aS ROOT in diff. branches
    //         /   \    /    \   /     \
    //    G(0) * G(2) G(1)*G(1)  G(2)   G(0)

    //For leaf Nodes : If We take 1 as root F(1 , 3) :
    //Left Subtree of 1 will be zero {no less than}
    //Right Subtree of 1 will be :  1 -> 2  or 1 -> 3 .So Two ways here

    //Then formula derive as F(i, N) : G(i - 1) * G(N - i)
    //Finally, we need to Construct tree for 1...N. Therefore outer loop go from 1..N
    //Inner loop calculates for each i {1..N} and does G(j-1) * G(i -1) {here i is N and j is i}


    //ref: https://www.youtube.com/watch?v=GgP75HAvrlY
    private static int numTrees( int n ) {

        int[] G = new int[n + 1];

  /*
    The answer to the subproblem when n = 0 is 0.
  */
        G[0] = 1;

        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
    /*
      The answer to the ith subproblem will be the summation
      of F(i, n) for i = 0 to i = n (we plant every number we
      have available at the root)
      Remember that we expressed:
      F(i, n) = G(i - 1) * G(n - i)

      The answer to the total unique BST's we can construct with
      values from 1...n with i representing what is rooted at the
      root of the tree is F(i, n).

      We attain this value by taking the Cartesian Product (fancy
      word meaning all possible cross products) between all possible
      unique left BST's and unique right BST's.
      All possible unique left BST's count is G[j - 1] if we plant
      at i.
      All possible unique right BST's count is G[i - j] if we plant
      at i.
      Taking a product is the same as taking all pairing between the
      two sets of possibilities.
      If still confused, watch the video above, take your time to let
      it sink in.
    */
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
