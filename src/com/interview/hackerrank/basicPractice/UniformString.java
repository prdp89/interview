package com.interview.hackerrank.basicPractice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//https://www.hackerrank.com/challenges/weighted-uniform-string/problem
public class UniformString {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {

        Scanner in = new Scanner(System.in);

        String s = in.next();
        int n = in.nextInt();

        char[] charArray = s.toCharArray();

        int contigentString = 1;
        int lastAlphaNum = 0;

        Set<Integer> numList = new HashSet<>();

        for (int i = 0; i < charArray.length; i++) {

            int alphaNum = charArray[i] - 'a' + 1;

            if (alphaNum == lastAlphaNum) {
                contigentString++;
            } else {
                contigentString = 1;
                lastAlphaNum = alphaNum;
            }

            int num = (alphaNum) * contigentString;
            numList.add(num);
        }

        for (int a0 = 0; a0 < n; a0++) {

            int x = in.nextInt();

            if (numList.contains(x)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

}
