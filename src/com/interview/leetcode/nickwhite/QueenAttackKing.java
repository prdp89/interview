package com.interview.leetcode.nickwhite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueenAttackKing {

    //https://leetcode.com/problems/queens-that-can-attack-the-king/
    public static void main( String[] args ) {
        int[][] queen = {
                {0, 1},
                {1, 0},
                {4, 0},
                {0, 4},
                {3, 3},
                {2, 4}
        };

        int[] king = {0, 0};
        queensAttacktheKing(queen, king).forEach(System.out::println);
    }

    private static List<List<Integer>> queensAttacktheKing( int[][] queens, int[] king ) {
        List<List<Integer>> list = new ArrayList<>();

        //filing king and queen
        boolean[][] chess = new boolean[8][8];
        for (int i = 0; i < queens.length; i++) {
            chess[queens[i][0]][queens[i][1]] = true;
        }

        //chess[king[0]][king[1]] = true;

        //this generates 3*3 direction a king may get hit
        int[] dirs = {-1, 0, 1};

        //moving in directions like MaxAreaOfIsland or FloodFill
        for (int dirX : dirs) {

            for (int dirY : dirs) {

                //this direction is 9th one, so invalid
                if (dirX == 0 && dirY == 0) continue;

                int kingX = king[0], kingY = king[1];
                while (checkBounds(kingX, kingY, dirX, dirY)) {

                    //actual direction we are travelling from King's current direction..
                    kingX += dirX;
                    kingY += dirY;

                    if (chess[kingX][kingY]) //this queen has hit the King first
                    {
                        list.add(Arrays.asList(kingX, kingY));
                        //break so that no other queen got chance to hit King :P
                        break;
                    }
                }
            }
        }


        return list;
    }

    private static boolean checkBounds( int kingX, int kingY, int dirX, int dirY ) {
        return kingX + dirX >= 0 && kingX + dirX < 8 && kingY + dirY >= 0 && kingY + dirY < 8;
    }
}
