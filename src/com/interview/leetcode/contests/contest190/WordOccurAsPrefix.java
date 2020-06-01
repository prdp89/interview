package com.interview.leetcode.contests.contest190;

public class WordOccurAsPrefix {

    //https://leetcode.com/contest/weekly-contest-190/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence
    public static void main( String[] args ) {
        String sentence = "corona dream", searchWord = "d";

        System.out.println(isPrefixOfWord(sentence, searchWord));
    }

    private static int isPrefixOfWord( String sentence, String searchWord ) {
        String strs[] = sentence.split(" ");

        int count = 1;
        for (String str : strs) {

            if (str.length() >= searchWord.length()) {

                int len = 0;
                boolean isFound = true;

                for (char ch : str.toCharArray()) {
                    if (len < searchWord.length() && ch != searchWord.charAt(len++)) {
                        isFound = false;
                        break;
                    }
                }

                if (isFound && len == searchWord.length())
                    return count;
            }

            count++;
        }

        return -1;
    }
}
