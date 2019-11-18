package com.interview.codechef.ccdsap_2.leetcode.contests.contest156;

import java.util.Stack;

public class RemoveAllAdjacentDuplicates {

    //https://leetcode.com/contest/weekly-contest-156/problems/remove-all-adjacent-duplicates-in-string-ii/
    public static void main( String[] args ) {
        String s = "deeedbbcccbdaa";
        int k = 3;

        System.out.println(removeDuplicatesOptimal(s, k));
    }

    //https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/discuss/392939/Java-Simple-Stack-O(N)-~-30ms-Clean-code-easy-to-understand
    //This problem pattern is similar to: DailyTemperature
    private static String removeDuplicatesOptimal( String s, int k ) {
        Stack<Character> stackChar = new Stack<>();
        Stack<Integer> stackAdjCnt = new Stack<>();

        for (char x : s.toCharArray()) {

            //if top item of stack equals to current String char; then increase its occurrance count
            if (!stackChar.isEmpty() && stackChar.peek() == x) {
                stackAdjCnt.push(stackAdjCnt.peek() + 1);
            } else {
                //else add all unique count in the stack.
                stackAdjCnt.push(1);
            }

            stackChar.push(x);

            //if at any point Adjacent count == k; then remove those element from Char stack.
            if (stackAdjCnt.peek() == k) {
                for (int i = 0; i < k; i++) { // pop k adjacent equal chars
                    stackChar.pop();
                    stackAdjCnt.pop();
                }
            }
        }

        // Convert stack to string
        StringBuilder builder = new StringBuilder();
        while (!stackChar.empty()) {
            builder.append(stackChar.pop());
        }

        //reverse to get original string..
        return builder.reverse().toString();
    }
}