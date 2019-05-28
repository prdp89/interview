package com.interview.string;

/**
 * Date 04/09/2016
 * @author Tushar Roy
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public static void main( String[] args ) {
        isPalindromeEasy("A man, a plan, a canal: Panama");
        //isPalindromeEasy("race a car");
    }

    public static boolean isPalindromeEasy(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            //if start or end char is not alphanumeric then move to next index from Start or End
            if (!isAlphaNum(s.charAt(start))) {
                start++;
            } else if (!isAlphaNum(s.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isAlphaNum(char ch) {
        if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        }
        return false;
    }
}