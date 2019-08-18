package com.interview.codechef.ccdsap_2.leetcode.stack.medium;

import java.util.Stack;

public class DecodedStringIndex {

    //https://leetcode.com/problems/decoded-string-at-index
    public static void main( String[] args ) {
        String str = "ha22";
        int k = 5;

        // System.out.println(solveTry(str, k));

        System.out.println(decodeAtIndex(str, k));
    }

    //33 / 45 test cases passed.
    private static String solveTry( String str, int k ) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (Character.isAlphabetic(str.charAt(i))) {
                stack.push(str.charAt(i) + "");
            } else {
                StringBuilder sb;

                String val = "";
                while (!stack.isEmpty()) {
                    val = stack.pop() + val;
                }

                sb = new StringBuilder();

                int num = Character.getNumericValue(str.charAt(i));
                while (num-- > 0) {
                    sb.append(val);
                }

                stack.push(sb.toString());

                if (stack.size() > 0 && stack.get(0).length() > k) {
                    return stack.get(0).charAt(k - 1) + "";
                }
            }
        }

        String sb = "";
        while (!stack.isEmpty()) {
            sb = stack.pop() + sb;
        }

        System.out.println(sb);

        return sb.charAt(k - 1) + "";
    }

    //didn't understand it properly
    //ref : https://leetcode.com/problems/decoded-string-at-index/discuss/156747/C%2B%2BPython-O(N)-Time-O(1)-Space
    private static String decodeAtIndex( String S, int K ) {

        long N = 0L;
        int i;

        char[] chs = S.toCharArray();

        for (i = 0; N < K; i++) {

            N = Character.isDigit(chs[i]) ? N * (Character.getNumericValue(chs[i])) : N + 1;
        }

        i--;

        while (true) {

            if (Character.isDigit(chs[i])) {

                N /= Character.getNumericValue(chs[i]);

                K %= N;

            } else if (K % N == 0) {

                return "" + chs[i];

            } else {

                N--;
            }

            i--;
        }
    }
}