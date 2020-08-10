package com.interview.codechef.ccdsap_2.leetcode.companies.amazon;

public class ReverseWordsStringII {

    //https://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java
    //https://leetcode.com/articles/reverse-words-in-a-string-ii/

    //https://leetcode.com/submissions/detail/366936980/?from=/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3391/
    public static void main( String[] args ) {
        String s = "a good   example";

        s = reverse(s, 0, s.length() - 1);

        String[] strings = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String st : strings) {
            if (st.isEmpty())
                continue;

            sb.append(reverse(st, 0, st.length() - 1)).append(" ");
            //Arrays.toString(arr)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    private static String reverse( String s, int left, int right ) {
        char[] arr = s.toCharArray();

        while (left < right) {
            char tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }

        return new String(arr);
    }

    private static void reverseEachWord( char[] s ) {
        int n = s.length;
        int start = 0, end = 0;

        while (start < n) {
            // go to the end of the word
            while (end < n && s[end] != ' ')
                ++end;

            // reverse the word
            //reverse(s, start, end - 1);

            // move to the next word
            start = end + 1;
            ++end;
        }
    }

    private static void reverseWords( char[] s ) {
        // reverse the whole string
        //reverse(s, 0, s.length - 1);

        // reverse each word
        reverseEachWord(s);
    }
}
