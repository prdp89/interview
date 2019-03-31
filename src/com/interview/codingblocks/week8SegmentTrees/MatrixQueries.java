package com.interview.codingblocks.week8SegmentTrees;

public class MatrixQueries {

    /*
    Mike has N 2*2 matrices, M1, M2, …, Mn. Elements of matrices are in range [0,r-1],
    where r is an integer.

    Mike considers an operation, o, such that A2x2 o B2x2 = (A2x2 * B2x2)%r
    (each value in the product of 2 matrices is stored modulo r).

    Mike gives you q queries, each of the form L,R. For each query, you have to find ML o ML+1 o … o MR.

    Note that it is not necessary, that all the input matrices are invertible.

    For eg. a matrix, A2x2=[[0,0],[0,0]] can be present in input.

    Input Format:
    The first line of the input file contains r, n and q.
    Next n blocks of two lines, containing two integer numbers ranging from 0 to r.
    Blocks are separated with blank lines.
    They are followed by q pairs of integers L and R.

    Output Format:
    Print q blocks containing two lines each. Each line should contain two integer numbers ranging from 0 to r.

    Sample Input:
    3 4 4
    0 1
    0 0

    2 1
    1 2

    0 0
    0 2

    1 0
    0 2

    1 4
    2 3
    1 3
    2 2

    Sample Output:
    0 2
    0 0

    0 2
    0 1

    0 1
    0 0

    2 1
    1 2
     */

    //https://online.codingblocks.com/player/3880/content/965?s=1915
    public static void main( String[] args ) {

    }
}
