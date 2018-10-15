package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

public class BeautifulBinaryString {

    //https://www.hackerrank.com/challenges/beautiful-binary-string/problem
    public static void main( String[] args ) {
      //  solve();
        solveOPtimal();
    }

    private static void solve() {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        String str = scanner.next();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            if (i + 2 < str.length() && str.substring(i, Math.min(str.length(), i + 3)).equals("010")) {
                count++;
                i+=2;
            }
        }

        System.out.println(count);
    }

    private static void solveOPtimal(){
        String B = "0101010";
        System.out.println(B.replaceAll("010", ""));

        // (7 - 1)/3 = 2
        System.out.println((B.length() - B.replaceAll("010", "").length())/3);
    }
}
