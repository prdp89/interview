package com.interview.hackerrank.InterviewPreprationKit;

public class CommonChild {

    //https://www.hackerrank.com/challenges/common-child/problem
    public static void main( String[] args ) {

       /* String s1 = "SHINCHAN";
        String s2 = "NOHARAAA";*/

      /* String s1 = "ABCDEF";
       String s2 = "FBDAMN";*/

        String s1 = "HARRY";
        String s2 = "SALLY";

        System.out.println(solve(s1.toCharArray(), s2.toCharArray()));
    }

    //This program is from Week-5 of Algo. toolbox package
    private static int solve( char[] str1, char[] str2 ) {

        int temp[][] = new int[str1.length + 1][str2.length + 1];

        int max = 0;

        for (int i = 1; i < temp.length; i++) {

            for (int j = 1; j < temp[i].length; j++) {

                if (str1[i - 1] == str2[j - 1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                } else {
                    temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]);
                }

                if (temp[i][j] > max) {
                    max = temp[i][j];
                }
            }
        }
        return max;
    }
}
