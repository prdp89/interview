package com.interview.codechef.ccdsapfoundation_1.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    //https://leetcode.com/problems/minimum-window-substring/
    public static void main( String[] args ) {
        //minWindow()
    }

    /*
   Sliding Window: Use 2 Pointers To Compose A Sliding Window
   This code passes all Leetcode test cases as of Feb. 21 2019
   Runtime*: 27 ms, faster than 44.99% of Java online submissions for Minimum Window Substring.
   Memory Usage: 35.8 MB, less than 96.11% of Java online submissions for Minimum Window Substring.
   * There is a tweak that we can make to make this run faster but it will not change asymptotic
   time complexity so I am satisfied with this for example's sake
 */
    private static String minWindow( String searchString, String t ) {

        // The characters a satisfiable window must cover mapped to their frequency
        Map<Character, Integer> requiredCharacters = buildMappingOfCharactersToOccurrences(t);

  /*
    For our window. Map all characters in the window to their occurrence count. You
    will see how we use this below.
  */
        Map<Character, Integer> windowCharacterMapping = new HashMap<>();

        int left = 0;
        int right = 0;

  /*
    'totalCharFrequenciesToMatch' is the total characters we need to match frequency for
    in the window. If I have 1 'a' in my window and I need 2 'a' chars...then the char
    frequencies don't match.
    'charFrequenciesInWindowThatMatch' is the count of frequencies that we have satisfied.
    When 'totalCharFrequenciesToMatch' == 'charFrequenciesInWindowThatMatch' then it can be
    said that the current window satisfies that property of having all characters with matching
    counts to the string t.
  */
        int totalCharFrequenciesToMatch = requiredCharacters.size();
        int charFrequenciesInWindowThatMatch = 0;

        int minWindowLengthSeenSoFar = Integer.MAX_VALUE;
        String minWindow = "";

        while (right < searchString.length()) {

    /*
      Add the character on the right pointer to the hashtable that maps the characters seen
      in the window to their occurrence count
    */
            char characterAtRightPointer = searchString.charAt(right);
            addCharacterToHashtableMapping(windowCharacterMapping, characterAtRightPointer);

            //goto:1
            //region If Character Frequency Matches
            boolean rightCharIsARequirement = requiredCharacters.containsKey(characterAtRightPointer);
            if (rightCharIsARequirement) {


                boolean requirementForCharacterMet = requiredCharacters.get(characterAtRightPointer).intValue() ==
                        windowCharacterMapping.get(characterAtRightPointer).intValue();

                if (requirementForCharacterMet) {
                    charFrequenciesInWindowThatMatch++;
                }
            }
            //endregion

    /*
      Does this window satisfy? Ok...if it does try contracting the left pointer inward until
      we go over the right pointer.
    */
            while (charFrequenciesInWindowThatMatch == totalCharFrequenciesToMatch && left <= right) {

                int windowSize = right - left + 1;

      /*
        Have we beat the best satisfiable window seen so far? Ok...if so then update
        the tracking variables
      */
                if (windowSize < minWindowLengthSeenSoFar) {
                    minWindowLengthSeenSoFar = windowSize;
                    minWindow = searchString.substring(left, right + 1);
                }


                //now we are shrinking window from left
                char characterAtLeftPointer = searchString.charAt(left);
                windowCharacterMapping.put(characterAtLeftPointer, windowCharacterMapping.get(characterAtLeftPointer) - 1);

                //region Checking if Removing Left character matches frequency in Required Window

                //same as outer logic , goto:1
                boolean leftCharIsARequirement = requiredCharacters.containsKey(characterAtLeftPointer);
                if (leftCharIsARequirement) {

                    boolean characterFailsRequirement = windowCharacterMapping.get(characterAtLeftPointer).intValue() <
                            requiredCharacters.get(characterAtLeftPointer).intValue();

                    if (characterFailsRequirement) {

                        charFrequenciesInWindowThatMatch--;
                    }
                }
                //endregion

                left++;
            }

    /*
      We have moved left as far as it could go. It either led to a window that no longer
      satisfied or left passed the right pointer. Either way...advance the right pointer.
    */
            right++;
        }

        return minWindow;
    }

    private static Map<Character, Integer> buildMappingOfCharactersToOccurrences( String s ) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int occurrencesOfCharacter = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), occurrencesOfCharacter + 1);
        }

        return map;
    }

    private static void addCharacterToHashtableMapping( Map<Character, Integer> map, Character c ) {
        int occurrences = map.getOrDefault(c, 0);
        map.put(c, occurrences + 1);
    }

    //Runtime: 4 ms, faster than 90.10%
    public static String minWindowShortTemplate( String s, String t ) {
        int[] arr = new int[128];

        for (Character ch : t.toCharArray()) {
            arr[ch]++;
        }

        int i = 0, j = 0, min = Integer.MAX_VALUE, totalCharsToMatch = t.length();
        String str = "";
        while (j < s.length()) {

            //step:1
            //if we found a character from T string
            if (arr[s.charAt(j++)]-- > 0)
                totalCharsToMatch--;

            while (totalCharsToMatch == 0) {

                //we find better  String length
                if (min > j - i) {
                    min = j - i;
                    str = s.substring(i, i + min);
                }

                //now shrink from left to check if we can
                arr[s.charAt(i)]++;

                // When char exists in t, increase counter.
                if (arr[s.charAt(i)] > 0) //this condition works bcz : At step 1, when we found the char condition is greater than zero only
                    //so now it will match with greater than zero if it exist in T
                    totalCharsToMatch++;

                i++;
            }
        }

        return str;
    }
}
