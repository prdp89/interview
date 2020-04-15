package com.interview.codechef.ccdsap_2.leetcode.contests.contest181;

import java.util.*;

public class CheckIfValidPath {

    //https://leetcode.com/contest/weekly-contest-181/problems/check-if-there-is-a-valid-path-in-a-grid/
    public static void main( String[] args ) {
        int[][] arr = {
                {2, 4, 3},
                {6, 5, 2}
        };

        System.out.println(hasValidPath(arr));
    }

    private static boolean hasValidPath( int[][] grid ) {

        int rows = grid.length, cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        Map<Integer, Set<Character>> map = new HashMap<>();

        map.put(1, new HashSet<>(Arrays.asList('L', 'R')));
        map.put(2, new HashSet<>(Arrays.asList('U', 'D')));
        map.put(3, new HashSet<>(Arrays.asList('R', 'U')));
        map.put(4, new HashSet<>(Arrays.asList('L', 'U')));
        map.put(5, new HashSet<>(Arrays.asList('R', 'D')));
        map.put(6, new HashSet<>(Arrays.asList('L', 'D')));

        return dfs(grid, 0, 0, rows, cols, map, '~', vis);
    }

    private static boolean dfs( int[][] grid, int x, int y, int rows, int cols, Map<Integer, Set<Character>> map, char dir, boolean[][] vis ) {

        //this condition is required : !map.get(grid[x][y]).contains(dir)
        if (x == rows || x < 0 || y == cols || y < 0 || vis[x][y]
                || dir != '~' && !map.get(grid[x][y]).contains(dir))
            return false;

        if (x == rows - 1 && y == cols - 1)
            return true;

        vis[x][y] = true;

        if (map.get(grid[x][y]).contains('L') && dfs(grid, x, y + 1, rows, cols, map, 'R', vis))
            return true;

        if (map.get(grid[x][y]).contains('R') && dfs(grid, x, y - 1, rows, cols, map, 'L', vis))
            return true;

        if (map.get(grid[x][y]).contains('U') && dfs(grid, x + 1, y, rows, cols, map, 'D', vis))
            return true;

        if (map.get(grid[x][y]).contains('D') && dfs(grid, x - 1, y, rows, cols, map, 'U', vis))
            return true;

        return false;
    }
}
