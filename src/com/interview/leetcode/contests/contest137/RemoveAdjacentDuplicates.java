package com.interview.leetcode.contests.contest137;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Stack;

public class RemoveAdjacentDuplicates {

    //https://leetcode.com/contest/weekly-contest-137/problems/remove-all-adjacent-duplicates-in-string
    public static void main( String[] args ) {
        String str = "abbaca";

        //System.out.println(solve(str));

        System.out.println(removeDuplicates(str));
    }

    //don't know why HashSet Memory exceeds. Logic is correct
    private static String solve( String str ) {
        LinkedHashSet<Character> hashSet = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {

            if (hashSet.contains(str.charAt(i)))
                hashSet.remove(str.charAt(i));
            else
                hashSet.add(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (hashSet.iterator().hasNext()) {
            Iterator<Character> it = hashSet.iterator();
            sb.append(it.next());
        }
        return sb.toString();
    }

    //Another method; Instead of Set using Stack
    private static String removeDuplicates( String S ) {
        Stack<Character> stack = new Stack<>();

        for (char s : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == s)
                stack.pop();
            else
                stack.push(s);
        }

        StringBuilder sb = new StringBuilder();

        for (char s : stack)
          sb.append(s);

        return sb.toString();
    }

    public String removeDuplicatesTwoPOinters( String s ) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();

        for (int j = 0; j < n; ++j, ++i) {

            res[i] = res[j];

            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
        }
        return new String(res, 0, i);
    }
}
