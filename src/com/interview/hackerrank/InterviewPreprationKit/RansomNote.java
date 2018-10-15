package com.interview.hackerrank.InterviewPreprationKit;

import java.util.HashMap;

public class RansomNote {

    public static void main( String[] args ) {
        solve();
    }

    //https://www.hackerrank.com/challenges/ctci-ransom-note/problem
    //check if note can formed using magazin string
    private static void solve() {
      /*  StringProblem[] magazine = {"give", "me", "one", "grand", "today", "night"};
        StringProblem[] note = {"give", "one", "grand", "today"};
        */

        String[] magazine = {"two", "times", "three", "is", "not", "four"};
        String[] note = {"two", "times", "two", "is", "four"};

       /* StringProblem[] magazine = {"ive", "got", "a", "lovely", "bunch", "of", "coconuts"};
        StringProblem[] note = {"ive", "got", "some", "coconuts"};*/

        HashMap<String, Integer> hashMapMagazine = new HashMap<>();

        for (String aMagazine : magazine) {
            if (hashMapMagazine.containsKey(aMagazine)) {
                int value = hashMapMagazine.get(aMagazine);
                hashMapMagazine.put(aMagazine, value + 1);
            } else
                hashMapMagazine.put(aMagazine, 1);
        }


        for (int i = 0; i < note.length; i++) {

            if(!hashMapMagazine.containsKey(note[i]))
            {
                System.out.println("No");
                return;
            }

            int value = hashMapMagazine.get(note[i]) - 1;
            if(value == 0)
                hashMapMagazine.remove(note[i]);
            else
                hashMapMagazine.put(note[i], value);
        }

        System.out.println("Yes");
    }
}
