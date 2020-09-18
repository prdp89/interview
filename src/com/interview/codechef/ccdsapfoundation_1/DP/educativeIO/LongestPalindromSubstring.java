package com.interview.codechef.ccdsapfoundation_1.DP.educativeIO;

public class LongestPalindromSubstring {

    // This function prints the longest palindrome substring
    // (LPS) of str[]. It also returns the length of the
    // longest palindrome
    private static int longestPalSubstr( String str ) {
        int maxLength = 1; // The result (length of LPS)

        int start = 0;
        int len = str.length();

        int low, high;

        // One by one consider every character as center
        // point of even and length palindromes
        for (int i = 1; i < len; ++i) {

            // Find the longest even length palindrome with
            // center points as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start++;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length palindrome with
            // center point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len
                    && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start++;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        //System.out.println("count:" + start);
        System.out.print("Longest palindrome substring is: ");

        return maxLength;
    }

    // Driver program to test above function
    public static void main( String[] args ) {

        String str = "forgeeksskeegfor";
        //String str = "abbaeae";
        System.out.println("Length is: " +
                longestPalSubstr(str));
    }

    //https://leetcode.com/problems/longest-palindromic-substring/
    //Runtime: 29 ms, faster than 49.50% of Java
    public String longestPalindrome(String s) {

        if(s.length() == 1)
            return s;

        if(s.length() == 0)
            return "";

        int low, high, maxLength = 0;
        String str = String.valueOf(s.charAt(0));

        for(int i=1; i<s.length(); i++) {

            low = i-1;
            high = i;

            //for even length string
            while(low >= 0 && high < s.length()
                    && s.charAt(low) == s.charAt(high)) {
                if(high - low + 1 > maxLength)
                {
                    maxLength = high - low + 1;
                    str = s.substring(low, high+1);
                }
                low--; high++;
            }


            low = i-1;
            high = i+1;
            //for even length string
            while(low >= 0 && high < s.length()
                    && s.charAt(low) == s.charAt(high)) {
                if(high - low + 1 > maxLength)
                {
                    maxLength = high - low + 1;
                    str = s.substring(low, high+1);
                }
                low--; high++;
            }
        }

        return str;
    }
}
