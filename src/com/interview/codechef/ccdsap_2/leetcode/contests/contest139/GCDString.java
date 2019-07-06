package com.interview.codechef.ccdsap_2.leetcode.contests.contest139;

import java.util.HashMap;

//contest  : https://leetcode.com/contest/weekly-contest-139
public class GCDString {

    //https://leetcode.com/contest/weekly-contest-139/problems/greatest-common-divisor-of-strings/

    public static void main( String[] args ) {
        String s = "LEET", t = "CODE";

        System.out.println(solve(s, t));
    }

    //Brute force : Failing test cases..
    private static String solve( String s, String t ) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.compute(s.charAt(i), ( k, v ) -> {
                if (v == null)
                    return 1;
                else {
                    return v + 1;
                }
            });
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < t.length()) {

            if (hashMap.containsKey(t.charAt(i))) {
                hashMap.put(t.charAt(i), hashMap.get(t.charAt(i)) - 1);
                sb.append(t.charAt(i));
            }

            i++;
        }

        if (!sb.toString().equals(t)) {
            return "";
        }


        StringBuilder sb1 = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {

            if (hashMap.containsKey(s.charAt(j))) {
                int count = hashMap.get(s.charAt(j));

                hashMap.put(s.charAt(j), count - 1);

                for (int k = 0; k < count; k++) {
                    sb1.append(s.charAt(j));
                }
            }
        }


        return sb1.toString();
    }

    //This problem should solve by GCD concept...
    /*
     private static int euclideanGcd(int a, int b)
    {
        if(b==0)
            return a;
        else
        {
            int aComplement = a%b;
            return euclideanGcd(b, aComplement);
        }
    }
     */

    //ref : https://leetcode.com/problems/greatest-common-divisor-of-strings/discuss/303805/Java-Recursive-Solution
    private String GCD( String a, String b ) {
        if (a.length() == 0)
            return b;

        if (b.length() == 0)
            return a;

        if (a.equals(b))
            return a;

        if (a.length() > b.length()) {
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) != a.charAt(i)) {
                    return "";
                }
            }
            String temp = a.substring(b.length()); //equivalent to a%b
            return GCD(temp, b); //still a%b > b so passing temp as first param
        } else if (b.length() > a.length())
            return GCD(b, a);
        else
            return "";
    }
}
