package com.interview.leetcode.contests._new_weekely.contest205;

public class ReplaceAllQuestionMark {

    //https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
    //https://leetcode.com/contest/weekly-contest-205/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
    public static void main( String[] args ) {
        String str = "??";

        System.out.println(modifyString(str));
        System.out.println(modifyStringOptimal(str));
    }

    private static String modifyStringOptimal( String s ) {

        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; ++i) {

            if (s.charAt(i) == '?') {

                for (int j = 0; j < 26; ++j) {
                    boolean valid = true;

                    // test left
                    if (i > 0 && j + 'a' == str[i - 1])
                        valid = false;

                    // test right
                    if (i < str.length - 1 && str[i + 1] != '?' && j + 'a' == str[i + 1])
                        valid = false;

                    if (valid) {
                        str[i] = (char) (j + 'a');
                        break;
                    }
                }
            }
        }

        return new String(str);
    }

    //56 / 100 test cases passed :(
    private static String modifyString( String s ) {

        //int[] arr = new int[26];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '?')
                sb.append(s.charAt(i));
            else {
                char prev = ' ', next = ' ';
                if (i > 0) {
                    prev = s.charAt(i - 1);
                }

                if (i + 1 < s.length()) {
                    next = s.charAt(i + 1);
                }

                if (prev == ' ' && next != ' ') {
                    sb.append(next == 'z' ? 'a' : next == '?' ? 'a' : (char) (next + 1));
                } else if (prev != ' ' && next == ' ') {
                    sb.append(prev == 'z' ? 'a' : prev == '?' ? (char) (sb.charAt(i - 1) + 1) : (char) (prev + 1));
                } else if (prev != ' ' && next != ' ') {
                    int diff = Math.abs(Character.getNumericValue(prev) - Character.getNumericValue(next));

                    if (diff == 1 && Character.getNumericValue(prev) > Character.getNumericValue(next)) {
                        sb.append(prev == 'z' ? 'a' : (char) (prev + 1));
                    } else if (diff == 1 && Character.getNumericValue(next) > Character.getNumericValue(prev)) {
                        sb.append(next == 'z' ? 'a' : (char) (next + 1));
                    } else
                        sb.append(prev == 'z' ? 'a' : (char) (prev + 1));
                }
            }
        }
        return sb.toString();
    }
}
