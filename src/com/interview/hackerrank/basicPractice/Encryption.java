package com.interview.hackerrank.basicPractice;

public class Encryption {

    //https://www.hackerrank.com/challenges/encryption/problem
    private static void solve() {
        // String s = "if man was meant to stay on the ground god would have given us roots";
        //String s = "haveaniceday";
        //String s = "feedthedog";
        String s = "chillout";

        StringBuilder stringBuilder = new StringBuilder(s);

        for (int i = 0; i < stringBuilder.length(); i++) {

            if (stringBuilder.charAt(i) == ' ')
                stringBuilder.deleteCharAt(i);
        }

        int length = stringBuilder.length();
        double rootLength = Math.sqrt(length);

        int m = (int) Math.floor(rootLength);
        int n = (int) Math.ceil(rootLength);

        if (m * n < length)
            m++;

        int countChar = -1;
        char arr[][] = new char[m][n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (countChar < length - 1)
                    arr[i][j] = stringBuilder.charAt(++countChar);
                else
                    arr[i][j] = '_';
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (arr[j][i] != '_')
                    builder.append(arr[j][i]);
                //System.out.print(arr[j][i]);
            }
            builder.append(" ");
            //System.out.print(" ");
        }

        System.out.println(builder);
        //System.out.println(Arrays.deepToString(arr));
    }


    /*
    //Best Solution without using 2D array, c# code :

    class Solution {

    static void Main(String[] args) {
        string s = Console.ReadLine();
        Int32 Lmax = (Int32)Math.Ceiling(Math.Sqrt(s.Length));
        for(Int32 i = 0; i < Lmax; i++){
            Console.Write(s[i]);
            for(Int32 j = i+Lmax; j < s.Length; j+=Lmax){Console.Write(s[j]);}
            Console.Write(" ");
        }
    }
}
     */

    public static void main( String[] args ) {
        solve();
    }
}
