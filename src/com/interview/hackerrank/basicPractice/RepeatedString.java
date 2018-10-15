package com.interview.hackerrank.basicPractice;

public class RepeatedString {

    //https://www.hackerrank.com/challenges/repeated-string/problem

    //this passes 13 out of 26 test case
    private static void solve() {
        String s = "aba";
        //long n = Long.parseLong("1000000000000");
        long n = 10;
        int aCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a')
                aCount++;
        }

        long rem = n % s.length();
        long div = n / s.length();

        long result = div * aCount;

        /*if(rem == 1 && s.charAt(0) == 'a')
            result++;*/
        if (rem > 0) {
            String remString = s.substring(0, (int) rem);
            for (int i = 0; i < remString.length(); i++) {
                if (remString.charAt(i) == 'a')
                    result++;
            }
        }

        System.out.println(result);
    }

    //This code is almost same as mine; Help in solving test cases.
    private static void solveOptimal() {
        String s = "aba";
        long n = Long.parseLong("1000000000000");
        // long n = 10;

        long count = 0;
        for (char c : s.toCharArray())
            if (c == 'a')
                count++;

        long factor = (n / s.length());

        long rem = (n % s.length());

        count = factor * count;

        for (int i = 0; i < rem; i++)
            if (s.charAt(i) == 'a')
                count++;

        System.out.println(count);
    }

    //https://www.hackerrank.com/challenges/repeated-string/problem
    public static void main( String[] args ) {
        solve();

        //   solveOptimal();
    }
}
