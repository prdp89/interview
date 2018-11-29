package com.interview.codingblocks.week6recursion;

import java.util.HashSet;
import java.util.Scanner;

public class Subsequences {

    private static HashSet<String> st = new HashSet<>();

    private static void solve( String str ) {

        for (int i = str.length() - 1; i >= 0; i--) {

            int j = i, k = 0;
            while (j <= str.length() - 1) {
                System.out.println(str.substring(k, str.length()));
                j++;
                k++;
            }
        }
    }

    // It computes all the subsequence of an string
    static void subsequence( String str ) {
        // iterate over the entire string
        for (int i = 0; i < str.length(); i++) {

            // iterate from the end of the string
            // to generate substrings
            for (int j = str.length(); j > i; j--) {
                String sub_str = str.substring(i, j);

                if (!st.contains(sub_str))
                    st.add(sub_str);

                // drop kth character in the substring
                // and if its not in the set then recur
                for (int k = 1; k < sub_str.length() - 1; k++) {
                    StringBuffer sb = new StringBuffer(sub_str);

                    // drop character from the string
                    sb.deleteCharAt(k);
                    if (!st.contains(sb))
                        ;
                    subsequence(sb.toString());
                }
            }
        }
    }


    //Awesome video : https://www.youtube.com/watch?v=KCEPvdLqlYI&t=478s
    private static void printSubsequences( String input, String outputSoFar ) {
        if (input.length() == 0) {

            System.out.println(outputSoFar+ " ");
            return;
        }

        // Decision 1 :we choose not to include first char
        printSubsequences(input.substring(1), outputSoFar);

        //Decision 2 : we choose to include first char in outputsofar
       // printSubsequences(input.substring(1), outputSoFar + input.charAt(0));
    }

    public static void main( String[] args ) {
        // solve("ab");

        /*subsequence("abc");
        for (String str : st) {
            System.out.println(str);
        }*/

        //printSubsequences("ab", "");

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {

            printSubsequences(scanner.next(), "");
        }

    }
}
