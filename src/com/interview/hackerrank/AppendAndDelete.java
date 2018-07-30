package com.interview.hackerrank;

public class AppendAndDelete {

    //https://www.hackerrank.com/challenges/append-and-delete/problem
    private static void solve() {
        String s = "aba", t = "aba"; //convert String s into t with K operations
        int k = 3;

        if (s.length() == t.length() && s.length() * 2 <= k * 2) {
            System.out.println("YES");
        } else {

            int i = 0;
            for (; i < t.length(); i++) {
                if (s.charAt(i) != t.charAt(i))
                    break;
            }

            int remChar = t.substring(i).length();
            if (i < k && remChar * 2 <= k * 2)
                System.out.println("YES");
            else
                System.out.println("NO");

            //System.out.println(s.substring(i));
        }
    }

    public static void main( String[] args ) {
        solve();
    }
}
