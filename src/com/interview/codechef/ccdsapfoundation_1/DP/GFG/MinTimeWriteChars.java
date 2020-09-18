package com.interview.codechef.ccdsapfoundation_1.DP.GFG;

public class MinTimeWriteChars {

    //https://www.geeksforgeeks.org/minimum-time-write-characters-using-insert-delete-copy-operation/
    public static void main( String[] args ) {
        System.out.println(recurse(9, 1, 2, 1, 1));
    }

    //not working.......
    private static int recurse( int N, int insert, int remove, int copy, int index ) {

        if (index >= N)
            return 1;

        if (index % 2 == 0) {
            return Math.min(recurse(N, insert, remove, copy, index + 1 + insert)
                    , recurse(N, insert, remove, copy, (index * 2) + copy));
        } else {
            return Math.min(recurse(N, insert, remove, copy, index + 1 + insert)
                    , recurse(N, insert, remove, copy, ((index + 1) * 2) + copy + remove));
        }
    }
}
