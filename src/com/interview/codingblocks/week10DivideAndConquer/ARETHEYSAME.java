package com.interview.codingblocks.week10DivideAndConquer;

import java.util.Scanner;

public class ARETHEYSAME {

    /*
    This year when tourist visited India for snackdown 2017. He and Rajat started discussing few problems on divide
    and conquer. tourist asked Rajat that if you have 2 strings s1 and s2 can you find if they are equivalent.
    Rajat then asked the condition for being equivalent to which tourist replied

    Two strings a and b of equal length are called equivalent in one of the two cases:

    They are equal. 2 .If we split string a into two halves of the same size a1 and a2, and string b into two halves
    of the same size b1 and b2, then one of the following is correct: 1 . a1 is equivalent to b1, and a2 is
    equivalent to b2 2 . a1 is equivalent to b2, and a2 is equivalent to b1

    Input Format:
    First line is number of test cases t Then follow two strings each of same length

    Output Format
    print "YES" if they are "equivalent" and "NO" if they are not

    Sample Input:
    3
    ababa
    baaba
    ab
    ba
    abc
    abc

    Sample Output
    NO
    YES
    YES
     */
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String a = scanner.next();
            String b = scanner.next();


            if (a.length() == 1 && a.equals(b))
                System.out.println("YES");
            else if (a.length() == 1)
                System.out.println("NO");
            else {
                int mid = (a.length() / 2) - 1;
                if (a.substring(0, mid + 1).equals(b.substring(0, mid + 1))
                        && a.substring(mid + 1).equals(b.substring(mid + 1))) {
                    System.out.println("YES");
                } else if (a.substring(0, mid + 1).equals(b.substring(mid + 1))
                        && a.substring(mid).equals(b.substring(0, mid + 1))) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
