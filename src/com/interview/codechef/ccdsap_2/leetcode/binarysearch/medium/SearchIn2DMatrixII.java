package com.interview.codechef.ccdsap_2.leetcode.binarysearch.medium;

import com.interview.codechef.ccdsap_2.leetcode.arrays.KWayMerge.KthSmallestSortedMatrix;

import java.util.PriorityQueue;

//https://leetcode.com/problems/search-a-2d-matrix-ii/
public class SearchIn2DMatrixII {

    public static void main( String[] args ) {
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

       // int[][] matrix = {{-1}, {-1}};

        if (matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 0))
            System.out.println(-1);

        // System.out.println(kthSmallest(matrix, 5)); //op: true
        //
        // System.out.println(kthSmallest(matrix, 20)); //op : false

        System.out.println(search2DMatrixOptimal(matrix, 5));
    }

    //Easy and Awesome logic...
    //https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66140/My-concise-O(m%2Bn)-Java-solution
    private static boolean search2DMatrixOptimal( int[][] matrix, int target ) {

        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int col = matrix[0].length - 1;
        int row = 0;

        while (col >= 0 && row <= matrix.length - 1) {

            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

    //Runs in 740MS very bad but accepted
    private static boolean kthSmallest( int[][] matrix, int k ) {
        int n = matrix.length;

        PriorityQueue<KthSmallestSortedMatrix.Tuple> pq = new PriorityQueue<KthSmallestSortedMatrix.Tuple>();

        //Insert Only First row in PQ ASC order
        for (int j = 0; j <= matrix[0].length - 1; j++)
            pq.offer(new KthSmallestSortedMatrix.Tuple(0, j, matrix[0][j]));

        while (!pq.isEmpty()) {

            //poll() : method in Java is used to retrieve or fetch and
            //         remove the first element of the Queue or the element present at the head of the Queue.
            KthSmallestSortedMatrix.Tuple t = pq.poll();

            if (t.val == k)
                return true;

            //IF row element end of Matrix continue.
            if (t.x == n - 1)
                continue;

            //We are moving in direction:
            // Column 0 : Row 1 -> Row 2 -> Row 3
            pq.offer(new KthSmallestSortedMatrix.Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }

        return false;
    }
}
