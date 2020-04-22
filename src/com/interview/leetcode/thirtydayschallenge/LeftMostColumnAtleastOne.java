package com.interview.leetcode.thirtydayschallenge;

import java.util.ArrayList;
import java.util.List;

public class LeftMostColumnAtleastOne {

    //An interactive problem..

    //https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/
    public static void main( String[] args ) {
        BinaryMatrixImpl binaryMatrix = new BinaryMatrixImpl();

        System.out.println(leftMostColumnWithOne(binaryMatrix));
        System.out.println(leftMostColumnWithOne_MoreOptimal(binaryMatrix));
    }

    //TIME: O( H . Log W )
    private static int leftMostColumnWithOne( BinaryMatrix binaryMatrix ) {
        List<Integer> list = binaryMatrix.dimensions();
        int height = list.get(0), width = list.get(1);

        int answer = width; //at worst MAX column length

        //doing binary search on each row
        for (int row = 0; row < height; row++) {
            int low = 0, high = width - 1;
            while (low <= high) {
                int mid = (high + low) / 2;

                //we can't access Array, so we have to Array as:
                //if we found 1 then we are looking for better 1.
                if (binaryMatrix.get(row, mid) == 1) {
                    answer = Math.min(answer, mid);
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return answer == width ? -1 : answer;
    }

    //TIME: O(H + W) bcz we finish the inner binary search loop..
    //https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3306/discuss/590828/Java-Binary-Search-and-Linear-Solutions-with-Picture-Explain-Clean-Code
    private static int leftMostColumnWithOne_MoreOptimal( BinaryMatrix binaryMatrix ) {
        List<Integer> list = binaryMatrix.dimensions();

        int height = list.get(0), width = list.get(1) - 1; //starts with width - 1

        int answer = -1; //at worst 1 exist at last..

        //doing binary search on each row
        for (int row = 0, col = width; row < height && col >= 0; ) {

            //instead of doing binary search on each row, check if next row (width - 1 == 1)
            //Then decrease the column index and search on that row.

            //we can't access Array, so we have to Array as:
            //if we found 1 then we are looking for better 1.
            if (binaryMatrix.get(row, col) == 1) {
                answer = col;
                col--;
            } else {
                row++;
            }

        }

        return answer;
    }

    interface BinaryMatrix {
        List<Integer> dimensions();

        int get( int x, int y );
    }

    private static class BinaryMatrixImpl implements BinaryMatrix {

        int[][] arr = {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 1}
        };

        @Override
        public List<Integer> dimensions() {
            List<Integer> intArr = new ArrayList<>();
            intArr.add(3);
            intArr.add(4);
            return intArr;
        }

        @Override
        public int get( int x, int y ) {
            return arr[x][y];
        }
    }
}
