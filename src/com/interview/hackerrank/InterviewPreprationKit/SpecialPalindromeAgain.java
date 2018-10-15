package com.interview.hackerrank.InterviewPreprationKit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SpecialPalindromeAgain {

    //https://www.hackerrank.com/challenges/special-palindrome-again/
    public static void main( String[] args ) {
        //solve();

        System.out.println(substrCount(6, "asasd"));
    }

    private static void solve() {
       // String s = "aaaa";
        String s = "asasd";

        //String s = new Scanner(System.in).next();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j <= s.length(); j++) {

                String currentSubString = s.substring(i, j);

                if (currentSubString.length() > 1 && isPalindrome(currentSubString.toCharArray())) {
                    count++;
                }
            }
        }

        System.out.println(count + s.length());
    }

    //https://www.hackerrank.com/challenges/special-palindrome-again/problem
    private static boolean isPalindrome( char str[] ) {
        int l = 0;
        int h = str.length - 1;

        char c = str[0];
        while (h > l) {

            if (c != str[h--]) {
                return false;
            }

            l++;
        }

        return true;
    }

    //THis is the optimal solution of other dev
    /*
    Since we only need to count special palindromic strings which has:
     1. all same characters OR
     2. all same characters except for the middle one.

    We can use one pass(loop) to transform the string to a List<Pair>,
    where Pair is used to store the character and the count.

    Afterwards, we can loop this List<Pair> to calculate
    special palindromic strings for each case.

    For case 2: we only calculate it when we find a single
    character(which means the count in Pair is 1), and the previous and next pairs have the same character.

    Below is a Java solution. The time complexity is O(N) and Space O(N). We can further improve it to one pass
    and Space O(1) since we only need to know previous, current and next pair. But I think the solution below is
    good for now.
     */
    private static long substrCount( int n, String s ) {
        long count = 0;

        //generating a string in Pairs. This store character occurrence in List of pairs count.
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int j = i + 1;

            //checking for continuous 'aaaaa'
            while (j < s.length() && s.charAt(j) == s.charAt(i)) j++;

            list.add(new Pair(s.charAt(i), j - i));

            //store next index when 'J' repeats
            i = j - 1;
        }

        for (int i = 0; i < list.size(); i++) {
            Pair pair = list.get(i);

            // e.g. for "aaa" we have (1 + 3) * 3 / 2 = 6 special palindromic strings here for case 1
            count += (1 + pair.cnt) * pair.cnt / 2; // (n*(n+1)) / 2

            //checking if in 'aadaa' : d is in middle : d repetition should be 1.
            if (pair.cnt == 1 && i > 0 && i < list.size() - 1) {

                //checking next and previous char of 'D'
                Pair pre = list.get(i - 1);
                Pair next = list.get(i + 1);

                //if 'A' in both sides match.
                if (pre.c == next.c) {
                    //AAADAA : we are checking Min(3, 2) : bcz 2 A's only can make palindrome with D , e.g : AADAA
                    count += Math.min(pre.cnt, next.cnt);
                }
            }
        }

        return count;
    }

    private static class Pair {
        char c;
        long cnt;

        public Pair( char c, long cnt ) {
            this.c = c;
            this.cnt = cnt;
        }
    }
}
