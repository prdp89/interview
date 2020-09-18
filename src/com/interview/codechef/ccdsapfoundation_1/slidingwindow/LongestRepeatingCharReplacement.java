package com.interview.codechef.ccdsapfoundation_1.slidingwindow;

public class LongestRepeatingCharReplacement {

    //https://leetcode.com/problems/longest-repeating-character-replacement/
    public static void main( String[] args ) {
        //System.out.println(characterReplacement("ABAB", 2)); //op:4
        System.out.println(characterReplacement("AABABBA", 1));
    }

    /*
    https://leetcode.com/problems/longest-repeating-character-replacement/discuss/208284/C%2B%2B-Sliding-Window-With-Detailed-Explanation-and-Thinking-Process

    If we want to replace the characters in a substring and make it into the longest repeating,
    then we definitely want to find the character with maximum frequency and then replace all the
    other characters by this one, hence in this way, we can minimize the number of replacement.

    Hence, with such idea within mind, when we build a sliding window [start, end], we want this
    window to have this property: (the length of the window) - (the maximum frequency of the character
    in this window) > k. Then we can see that [start, end-1] can be fit into k replacement.
     */

    //This problem is similar as MinimumWindowSliding; maintain 2 pointers Left and Right
    //If right reaches the K characters needed then slide the window by moving Left pointer.
    //If Sliding the window by incrementing Left pointer increase the MaxLen then update it with max size window.
    private static int characterReplacement( String s, int k ) {
        int len = s.length();

        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;

        for (int end = 0; end < len; end++) {

            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);

            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
