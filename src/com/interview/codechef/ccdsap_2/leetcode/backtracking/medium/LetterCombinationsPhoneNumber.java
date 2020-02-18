package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsPhoneNumber {

    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    public static void main( String[] args ) {
        letterCombinations("23").forEach(System.out::println);
    }

    private static List<String> letterCombinations( String digits ) {
        List<String> list = new LinkedList<>();

        if (digits == null || digits.length() == 0)
            return list;

        char[][] map = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

        letterCombinationsDFS(digits, list, map, new StringBuilder(), 0);

        return list;
    }

    //This logic is similar to BraceExpansion recurrence.
    //If input is : 2 3 => abc def
    //For each digit : 2 we are picking ith element and then jump to second digit to pick its ith digit.
    //So this recurrence is similar to Permutation/BraceExpansion.
    private static void letterCombinationsDFS( String digits, List<String> list, char[][] map, StringBuilder sb, int start ) {

        if (start == digits.length()) {
            list.add(new String(sb));
            return;
        }

        //Compare this logic with BraceExpansion :)
        int num = digits.charAt(start) - '0';

        for (int i = 0; i < map[num].length; i++) {
            sb.append(map[num][i]);
            letterCombinationsDFS(digits, list, map, sb, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
