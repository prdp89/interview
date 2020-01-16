package com.interview.codechef.ccdsap_2.leetcode.arrays.KWayMerge;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
public class KthSmallestSortedMatrix {

    /*
    1. Build a minHeap of elements from the first row.
        Do the following operations k-1 times :
    2. Every time when you poll out the root(Top Element in Heap), you need to know the row number and column number
        of that element(so we can create a tuple class here), replace that root with the next element from the same column.
     */
    public static void main( String[] args ) {
        int[][] matrix = {{1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}};

        int kThSmallest = 4; //op = 4

        System.out.println(kthSmallest(matrix, kThSmallest));
    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
    private static int kthSmallest( int[][] matrix, int k ) {
        int n = matrix.length;

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();

        //Insert Only First row in PQ ASC order
        for (int j = 0; j <= n - 1; j++)
            pq.offer(new Tuple(0, j, matrix[0][j]));

        for (int i = 0; i < k - 1; i++) {

            //poll() : method in Java is used to retrieve or fetch and
            //         remove the first element of the Queue or the element present at the head of the Queue.
            Tuple t = pq.poll();

            //IF row element end of Matrix continue.
            if (t.x == n - 1)
                continue;

            //We are moving in direction:
            // Column 0 : Row 1 -> Row 2 -> Row 3
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }

        //PQ maintain smallest at root
        return pq.poll().val;
    }

    public static class Tuple implements Comparable<Tuple> {
        public int x, y, val;

        public Tuple( int x, int y, int val ) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo( Tuple that ) {
            return this.val - that.val; //sorting acc. to ASC value
        }
    }
}
