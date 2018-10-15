package com.interview.hackerrank.basicPractice;

public class HappyLadybugs {

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        //String b = "RBY_YBR";
        //String b = "X_Y__X";
        String b = "AABBCCZZ";
        char[] arr = b.toCharArray();

        int count[] = new int[26];
        int underScores = 0;

        for (char c : arr) {
            int ascii = (int) c;

            if (ascii >= 65 && ascii <= 90) {
                count[ascii - 65]++;
            } else if (c == '_') {
                underScores++;
            }
        }

        //checking for unique (an Alphabet with single occurrence).........
        for (int aCount : count) {
            if (aCount == 1) {
                System.out.println("NO");
                return;
            }
        }


        //Checking if ladbug already happy...
        //This is checking if Current char is equals to next is string = "AABBCC"
        boolean isHappy = true; //if false means no consecutive chars
        for (int i = 0; i < b.length() - 1; i++) {

            if (i == 0 && b.charAt(i) != b.charAt(i + 1)) {

                isHappy = false;
                break;
                // System.out.println("false");

            } else if (b.charAt(i) != b.charAt(i + 1) && b.charAt(i) != b.charAt(i - 1)) {

                isHappy = false;
                break;
                // System.out.println("false");

            }
        }

        if (isHappy)
            System.out.println("YES");
        else if (underScores > 0) {

            //checking if it has _ underscore enough to swap the characters
           /* for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == '_') {
                    System.out.println("YES");
                }
            }*/

            System.out.println("YES");
        } else
            System.out.println("NO");
    }
}


