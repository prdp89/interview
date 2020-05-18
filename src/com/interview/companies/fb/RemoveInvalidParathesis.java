package com.interview.companies.fb;

import java.util.*;

public class RemoveInvalidParathesis {

    //https://leetcode.com/problems/remove-invalid-parentheses/
    public static void main( String[] args ) {
        String str = "()())()";
        removeInvalidParentheses(str).forEach(System.out::println);

        System.out.println("states:");
        List<String> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != '(' && str.charAt(i) != ')')
                continue;

            String comb = str.substring(0, i) + str.substring(i + 1);
            list.add(comb);
        }

        list.forEach(System.out::println);
    }

    //https://leetcode.com/problems/remove-invalid-parentheses/discuss/75032/Share-my-Java-BFS-solution
    //Runtime: 50 ms, faster than 36.72% of Java
    private static List<String> removeInvalidParentheses( String s ) {

        List<String> res = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(s);

        HashSet<String> set = new HashSet<>();
        set.add(s);

        boolean isFound = false;

        while (!queue.isEmpty()) {

            String str = queue.poll();

            if (isValid(str)) {
                res.add(str);
                set.add(str);

                isFound = true;
            }

            if (isFound)
                continue;

            //NOw generate all possible string combinations
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) != '(' && str.charAt(i) != ')')
                    continue;

                String comb = str.substring(0, i) + str.substring(i + 1);
                if (!set.contains(comb)) {
                    set.add(comb);
                    queue.add(comb);
                }
            }
        }

        return res;
    }

    static boolean isValid( String s ) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}
