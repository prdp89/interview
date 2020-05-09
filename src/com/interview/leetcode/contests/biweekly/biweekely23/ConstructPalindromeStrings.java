package com.interview.leetcode.contests.biweekly.biweekely23;

public class ConstructPalindromeStrings {

    //https://leetcode.com/contest/biweekly-contest-23/problems/construct-k-palindrome-strings/
    public static void main( String[] args ) {
        String str = "annabelle";
        int k = 2;

        System.out.println(canConstruct(str, k));
    }

    //Logic is: If there are even occurrence of Chars in String we can form atmost N palindrome strings out of it
    //Eg:
    /*
    aabb, k=1| abba
    aabb, k=2 | aa, bb
    aabb, k=3 | a, a, bb,
    aabb, k=4 | a,a,b,b
     */

    //If we have 1 odd occur of Char then we can use that char in Middle or separately to form atmost N string length
    //Eg:
    /*
    aabbc, k=1 | aacbb
    aabbc, k=2 | aca, bb
    aabbc, k=3 | a,a, bcb
    aabbc, k=4 | a, a, c ,bb
    aabbc, k=5 | a, a, c, b, b
     */

    //If we have 2 odd occur of Char then we can also form atmost N string length
    //Eg:
    /*
    aabc, K=1 | aabc
    aabc, K=2 | aba, c
    aabc, K=3 | aa, b, c
    aabc, K=4 | a, a, b, c
     */

    //conclusion: ODD occur of chars should be less than K to form K palindromic strings
    private static boolean canConstruct( String s, int k ) {

        int[] arr = new int[26];

        for (Character ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }

        int odd = 0;
        for (int i = 0; i < 26; i++) {
            odd += arr[i] % 2 == 0 ? 0 : 1;
        }

        return odd <= k && k <= s.length();
    }
}
