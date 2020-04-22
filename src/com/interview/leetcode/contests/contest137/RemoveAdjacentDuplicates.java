package com.interview.leetcode.contests.contest137;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Stack;

public class RemoveAdjacentDuplicates {

    //https://leetcode.com/contest/weekly-contest-137/problems/remove-all-adjacent-duplicates-in-string
    public static void main( String[] args ) {
        String str = "abbaca";

        System.out.println(solve(str));
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
    public String removeDuplicates( String S ) {
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
}
