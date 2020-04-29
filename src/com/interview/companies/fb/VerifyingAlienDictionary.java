package com.interview.companies.fb;

public class VerifyingAlienDictionary {

    //https://leetcode.com/problems/verifying-an-alien-dictionary/
    public static void main( String[] args ) {
        String[] words = {"hello", "leetcode"};

        //our language has: A-Z, but alien has h-z
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        System.out.println(isAlienSorted(words, order));
    }

    //Runtime: 0 ms, faster than 100.00% of Java

    //we need to check if acc. to alien dict. h-z order, the WORDS[] strings are in lexographically order {h-z}
    //means: in order array H comes first, so in Words array H should come first than L
    private static boolean isAlienSorted( String[] words, String order ) {

        //Normally we iterate A-Z for our alphabets but for Aliens,
        //we are mapping every alien char {order} to 1..26
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[order.charAt(i) - 'a'] = i; //with this we can get min index for every character;
            //H is mapped to value 'h' - 'a' == 3
            //L is mapped to value 'l' - 'a' == 9

            //so lexoc. H is smaller than L
        }

        for (int i = 1; i < words.length; i++) {
            if (isBigLexograph(words[i - 1], words[i], arr)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isBigLexograph( String word, String word1, int[] arr ) {
        int m = word.length(), n = word1.length();

        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            if (word.charAt(i) != word1.charAt(j))
                return arr[word.charAt(i) - 'a'] > arr[word1.charAt(j) - 'a']; //if first word index is greater, then not sorted
        }

        return m > n;//if first length is greater than second, then not sorted too..
    }
}
