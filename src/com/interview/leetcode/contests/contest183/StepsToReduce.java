package com.interview.leetcode.contests.contest183;

import java.math.BigInteger;

public class StepsToReduce {

    //https://leetcode.com/contest/weekly-contest-183/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
    public static void main( String[] args ) {
        String str = "1101";
        System.out.println(numSteps(str));
    }

    //TIME = 8 MS
    private static int numSteps( String s ) {

        BigInteger bi = new BigInteger(s, 2);

        int count = 0;
        while (bi.intValue() != 1) {

            if (bi.mod(new BigInteger("2")).equals(new BigInteger("0"))) {
                bi = bi.divide(new BigInteger("2"));
            } else {
                bi = bi.add(new BigInteger("1"));
            }

            count++;
        }

        return count;
    }

    private static int numStepsOptimal( String s ) {
        int ans = 0;
        while (s.length() > 1) {
            ans++;

            //equivalent to divide by 2
            if (s.charAt(s.length() - 1) == '0')
                s = s.substring(0, s.length() - 1);
            else {
                char[] ch = s.toCharArray();
                int curr = s.length() - 1;

                //setting last bit == 1 means add 1.
                while (curr >= 0 && ch[curr] == '1') {
                    ch[curr--] = '0';
                }

                //setting last char to 1
                if (curr >= 0) {
                    ch[curr] = '1';
                    s = new String(ch);
                } else { //equivalent to carry forward of 1
                    s = '1' + new String(ch);
                }
            }
        }
        return ans;
    }
}
