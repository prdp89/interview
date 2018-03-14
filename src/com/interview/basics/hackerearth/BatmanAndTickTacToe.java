package com.interview.basics.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/batman-and-tick-tack-toe/

public class BatmanAndTickTacToe {

    private static final int[][][] diagonalSet = {
            {{0, 0}, {1, 1}, {2, 2}},
            {{1, 1}, {2, 2}, {3, 3}},
            {{0, 3}, {1, 2}, {2, 1}},
            {{1, 2}, {2, 1}, {3, 0}},
            {{1, 3}, {2, 2}, {3, 1}},
            {{1, 0}, {2, 1}, {3, 2}},
            {{0, 1}, {1, 2}, {2, 3}},
            {{0, 2}, {1, 1}, {2, 0}},
    };

    public void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCaseCount = Integer.valueOf(br.readLine());

            while (testCaseCount-- > 0) {
                char[][] matrix = new char[4][4];
                matrix[0] = br.readLine().toCharArray();
                matrix[1] = br.readLine().toCharArray();
                matrix[2] = br.readLine().toCharArray();
                matrix[3] = br.readLine().toCharArray();

                int countX = 0, countO = 0;

                for (int outer = 0; outer < 4; outer++) {
                    for (int inner = 0; inner < 4; inner++) {
                        if (matrix[outer][inner] == 'x') {
                            countX++;
                        } else if (matrix[outer][inner] == 'o') {
                            countO++;
                        }
                    }
                }

                char myChar = countX == countO ? 'x' : 'o';

                boolean wonFlag = false;
                // horizontal or row wise check
                int counter = 0;
                while (counter < 4) {
                    char[] rowsArr = matrix[counter++];

                    boolean flag = isWonScenarioAvailableForRowsAndColumns(myChar, rowsArr, 0, 3);
                    if (flag) {
                        System.out.println("YES");
                        wonFlag = true;
                        break;
                    } else {
                        flag = isWonScenarioAvailableForRowsAndColumns(myChar, rowsArr, 1, 4);
                        if (flag) {
                            System.out.println("YES");
                            wonFlag = true;
                            break;
                        }
                    }
                }

                if (wonFlag) continue;
                counter = 0; // resetting it to ZERO.
                // columns wise check
                while (counter < 4) {
                    char[] columnsArr = {matrix[0][counter], matrix[1][counter], matrix[2][counter], matrix[3][counter]};

                    boolean flag = isWonScenarioAvailableForRowsAndColumns(myChar, columnsArr, 0, 3);
                    if (flag) {
                        System.out.println("YES");
                        wonFlag = true;
                        break;
                    } else {
                        flag = isWonScenarioAvailableForRowsAndColumns(myChar, columnsArr, 1, 4);
                        if (flag) {
                            System.out.println("YES");
                            wonFlag = true;
                            break;
                        }
                    }
                    counter++;
                }

                if (wonFlag) continue;
                wonFlag = isWonScenarioAvailableForDiagonal(myChar, matrix);
                System.out.println(wonFlag ? "YES" : "NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isWonScenarioAvailableForRowsAndColumns( char myChar, char[] charArr, int startIndex, int endIndex ) {
        int myCharCount = 0, emptyCellCount = 0;

        for (int index = startIndex; index < endIndex; index++) {
            if (charArr[index] == myChar) myCharCount++;
            else if (charArr[index] == '.') emptyCellCount++;
        }

        return myCharCount == 2 && emptyCellCount == 1;

    }

    private static boolean isWonScenarioAvailableForDiagonal( char myChar, char[][] matrix ) {
        int myCharCount = 0, emptyCellCount = 0;

        for (int[][] eachSet : diagonalSet) {
            for (int[] set : eachSet) {
                char currentChar = matrix[set[0]][set[1]];
                if (currentChar == myChar) myCharCount++;
                else if (currentChar == '.') emptyCellCount++;
            }
            if (myCharCount == 2 && emptyCellCount == 1) {
                return true;
            }
            myCharCount = 0;
            emptyCellCount = 0;
        }

        return false;
    }

    public static void main( String[] args ) {
        BatmanAndTickTacToe batmanAndTickTacToe = new BatmanAndTickTacToe();
        batmanAndTickTacToe.solve();
    }
}
