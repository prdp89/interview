package com.interview.codingblocks.week6recursion;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class CrosswordPuzzle {

    //https://www.hackerrank.com/challenges/crossword-puzzle/problem
    //https://ide.codingblocks.com/s/3135
    public static void main( String[] args ) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        char[][] puzzle = new char[10][10];
        for(int r = 9; r >=0; r--)
        {
            String word = sc.nextLine();
            for(int c = 0; c< 10; c++)
                puzzle[r][c] = word.charAt(c);
        }
        String word = sc.nextLine();
        String[] cities = word.split(";");
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, cities);

        completeThePuzzle(puzzle, set);
    }

    private static class Cell {
        int row, col;
        Cell( int r, int c ) {
            this.row = r;
            this.col = c;
        }
    }
    private static void completeThePuzzle( char[][] puzzle, HashSet<String> set )
    {

        for(int r = 9; r >= 0; r--)
        {
            for(int c = 0; c < 10; c++)
            {
                if(puzzle[r][c] != '+')
                {
                    completeThePuzzleHelper(puzzle, set, r, c);
                    return;
                }
            }
        }
    }

    private static void completeThePuzzleHelper( char[][] puzzle, HashSet<String> set, int row, int col )
    {
        //System.out.println("row: "+row+" col: "+col);
        //printPuzzle(puzzle);
        //System.out.println("____________________");
        if(puzzle[row][col] == '-')
        {
            int rCount = getRHSEmptyCellsCount(puzzle, row, col);
            int lStart = getLeftStartCol(puzzle, row, col);
            int rSz = lStart == col ? rCount : rCount+(col-lStart);
            //System.out.println("row: "+row+" col: "+col+" rSz"+rSz+" lStart: "+lStart);
            if(rSz > 1)
            {
                for(String s: set)
                {
                    if(s.length() == rSz && canRightFit(puzzle, row, lStart, s))
                    {
                        char[][] puzzleCopy = copyPuzzle(puzzle);
                        HashSet<String> setCopy = copySet(set);
                        setCopy.remove(s);
                        rightFit(puzzleCopy, row, lStart, s);
                        Cell c = getNextCell(puzzleCopy, row, col);
                        // if(c != null)
                        //     System.out.println("row: "+row+" col: "+col+" nextRow: "+c.row+" nextCol: "+c.col);
                        if(c == null)
                        {
                            printPuzzle(puzzleCopy);
                            return;
                        }
                        else completeThePuzzleHelper(puzzleCopy, setCopy, c.row, c.col);
                    }
                }
            }
            else
            {
                int dCount = getDownEmptyCellsCount(puzzle, row, col);
                int uStart = getUpStartRow(puzzle, row, col);
                int dSz = uStart == row ? dCount : dCount+ uStart-row;
                //System.out.println("row: "+row+" col: "+col+" dSz: "+dSz+" uStart: "+uStart);
                for(String s: set)
                {
                    if(s.length() == dSz && canDownFit(puzzle, uStart, col, s))
                    {
                        char[][] puzzleCopy = copyPuzzle(puzzle);
                        HashSet<String> setCopy = copySet(set);
                        setCopy.remove(s);
                        downFit(puzzleCopy, uStart, col, s);
                        Cell c = getNextCell(puzzleCopy, row, col);
                        // if(c != null)
                        //    System.out.println("row: "+row+" col: "+col+" nextRow: "+c.row+" nextCol: "+c.col);
                        if(c == null)
                        {
                            printPuzzle(puzzleCopy);
                            return;
                        }
                        else completeThePuzzleHelper(puzzleCopy, setCopy, c.row, c.col);
                    }
                }
            }

        }
        //return false;
    }

    private static void printPuzzle( char[][] puzzle )
    {
        for(int r = 9; r>=0; r--)
        {
            for(int c = 0; c< 10; c++)
            {
                System.out.print(puzzle[r][c]);
            }
            System.out.println();
        }
    }

    private static void downFit( char[][] puzzle, int row, int col, String s ) {
        for(int r = row; r >=0 && row-r+1 <= s.length(); r--)
            puzzle[r][col] = s.charAt(row-r);
    }

    private static boolean canDownFit( char[][] puzzle, int row, int col, String s ) {
        for(int r = row; r >=0 && row-r+1 <= s.length(); r--)
        { if(puzzle[r][col] != '-' && puzzle[r][col] != s.charAt(row-r))
            return false;
        }
        return true;
    }

    private static Cell getNextCell( char[][] puzzle, int row, int col )
    {
        for(int r = row; r >=0; r--)
        {
            for(int c = 0; c< 10; c++)
            {
                if(r == row && c >= col && puzzle[r][c] == '-')
                    return new Cell(r,c);
                else if (r < row && puzzle[r][c] == '-')
                    return new Cell(r,c);
            }
        }
        return null;
    }

    private static void rightFit( char[][] puzzle, int row, int col, String s )
    {
        for(int c = col; c < 10 && c-col+1 <= s.length(); c++)
            puzzle[row][c] = s.charAt(c-col);
    }
    private static boolean canRightFit( char[][] puzzle, int row, int col, String s )
    {
        for(int c = col; c< 10 && c-col+1 <= s.length(); c++)
        {
            if(puzzle[row][c] != '-' && puzzle[row][c] != s.charAt(c-col))
                return false;

        }
        return true;
    }

    private static int getLeftStartCol( char[][] puzzle, int row, int col )
    {

        while(col >=0 && puzzle[row][col] != '+')
        {
            col--;
        }
        return col+1;
    }

    private static int getUpStartRow( char[][] puzzle, int row, int col )
    {
        while(row <10 && puzzle[row][col] != '+')
            row++;
        return row-1;
    }

    private static int getDownEmptyCellsCount( char[][] puzzle, int row, int col )
    {
        int count = 0;
        while(row >=0 && puzzle[row][col] != '+')
        {
            count++;
            row--;
        }
        return count;
    }

    private static int getRHSEmptyCellsCount( char[][] puzzle, int row, int col )
    {

        int count = 0;
        while(col < 10 && puzzle[row][col] != '+')
        {
            count++;
            col++;
        }
        return count;
    }

    private static HashSet<String> copySet( HashSet<String> set )
    {
        HashSet<String> setCopy = new HashSet<>();
        setCopy.addAll(set);
        return setCopy;
    }

    private static char[][] copyPuzzle( char[][] puzzle )
    {
        char[][] puzzleCopy = new char[10][10];
        for(int r = 9; r >=0; r--)
        {
            for(int c = 0; c < 10; c++)
            {
                puzzleCopy[r][c] = puzzle[r][c];
            }
        }
        return puzzleCopy;
    }
}
