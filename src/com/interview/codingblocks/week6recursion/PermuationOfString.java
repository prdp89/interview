package com.interview.codingblocks.week6recursion;

import java.util.Scanner;

public class PermuationOfString {

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        //StringBuffer helps to replace ith char with jth char during recursion.
        StringBuffer stringBuffer = new StringBuffer(scanner.next());

        solve(stringBuffer, 0);
    }

    private static void solve( StringBuffer input, int i ) {

        //if 'i' reaches end of string; means nothing more to swap
        if (i >= input.length()) {
            System.out.println(input);
            return;
        }

        for (int j = i; j < input.length(); j++) {

            //For abc, i=0 ; for bac, i = 1; and so on..
            swap(input, i, j);
            solve(input, i + 1);

            //After first branch of tree finishes and value printed successfully; Our ABC string changed into ACB
            //So to restore the original string ABC we need to swap again.
            //This is also called backtracking....

            swap(input, i, j);
        }
    }

    private static void swap( StringBuffer str, int i, int j ) {
        char t1 = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, t1);
    }
}
