package com.interview.codechef.ccdsap_2.leetcode.contests.contest143;

public class FillingBookcaseShelves {

    //https://leetcode.com/contest/weekly-contest-143/problems/filling-bookcase-shelves/
    /*
    We have a sequence of books: the i-th book has thickness books[i][0] and height books[i][1].

    We want to place these books in order onto bookcase shelves that have total width shelf_width.

    We choose some of the books to place on this shelf (such that the sum of their thickness is <= shelf_width), then build another level of shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down.  We repeat this process until there are no more books to place.

    Note again that at each step of the above process, the order of the books we place is the same order as the given sequence of books.  For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.

    Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.
     */

    /*
    Input: books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
    Output: 6
    Explanation:
    The sum of the heights of the 3 shelves are 1 + 3 + 2 = 6.
    Notice that book number 2 does not have to be on the first shelf.
     */

    private static int[][] memo;

    //https://leetcode.com/problems/filling-bookcase-shelves/discuss/323372/Java-Recursion-with-memo

    public static void main( String[] args ) {
        int[][] books = {{1, 1}
                , {2, 3}
                , {2, 3}
                , {1, 1}
                , {1, 1}
                , {1, 1}
                , {1, 2}};

        int shelf_width = 4;

        System.out.println(minHeightShelves(books, shelf_width));
    }

    private static int minHeightShelves( int[][] books, int shelf_width ) {

        memo = new int[books.length + 1][shelf_width + 1];

        return minHeight(books, 0, shelf_width, 0, shelf_width);
    }

    private static int minHeight( int[][] books, int cur, int widthLeft, int curHeight, int shelf_width ) {
        if (cur == books.length) {
            return curHeight;
        }

        if (memo[cur][widthLeft] != 0) return memo[cur][widthLeft];

        int height = Integer.MAX_VALUE;

        //including the book in shelf bcz current book width is less than shelf width left
        if (widthLeft >= books[cur][0]) {
            height = Math.min(minHeight(books, cur + 1, widthLeft - books[cur][0], Math.max(curHeight, books[cur][1]), shelf_width)
                    , height);
        }

        height = Math.min(height
                , curHeight + minHeight(books, cur + 1, shelf_width - books[cur][0], books[cur][1], shelf_width));

        memo[cur][widthLeft] = height;

        return memo[cur][widthLeft];
    }

}