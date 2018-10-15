package com.interview.hackerrank.basicPractice;

public class CavityMap {

    //https://www.hackerrank.com/challenges/cavity-map/problem
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
       /* String grid[] = {"1112",
                "1912",
                "1892",
                "1234"};*/

        String grid[] = {"12", "12"};

        int[][] arr = new int[grid.length][grid.length];

        //Instead of cArr[j] - '0' : use Character.getNumericValue();
        for (int i = 0; i < grid.length; i++) {
            char[] cArr = grid[i].toCharArray();
            for (int j = 0; j < cArr.length; j++) {
                arr[i][j] = cArr[j] - '0';
            }
        }


        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - 1; j++) {

                if (arr[i][j] > arr[i - 1][j] &&
                        arr[i][j] > arr[i][j - 1] &&
                        arr[i][j] > arr[i][j + 1] &&
                        arr[i][j] > arr[i + 1][j])
                    arr[i][j] = Integer.MAX_VALUE;
            }
        }


        //char[][] charArr = new char[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] != Integer.MAX_VALUE ? arr[i][j] : 'X');
                //charArr[i][j] = arr[i][j] != -1 ? (char) (arr[i][j] + '0') : 'X';
            }
            System.out.print("\n");
        }

        // System.out.println(Arrays.deepToString(charArr));

    }
}
