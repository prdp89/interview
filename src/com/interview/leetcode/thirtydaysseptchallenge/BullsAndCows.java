package com.interview.leetcode.thirtydaysseptchallenge;

public class BullsAndCows {

    //https://leetcode.com/problems/bulls-and-cows/
    public static void main( String[] args ) {
        String secret = "1807", guess = "7810";
        System.out.println(getHint(secret, guess));
    }

    //Runtime: 4 ms, faster than 89.53% of Java
    private static String getHint( String secret, String guess ) {
        int len = secret.length();

        int cows = 0, bull = 0;

        int[] sec = new int[10];
        int[] gue = new int[10];

        for (int i = 0; i < len; i++) {

            if (secret.charAt(i) == guess.charAt(i))
                bull++;
            else {
                ++sec[secret.charAt(i) - '0'];
                ++gue[guess.charAt(i) - '0'];
            }
        }

        for (int i = 0; i < 10; i++) {
            cows += Math.min(sec[i], gue[i]);
        }

        return bull + "A" + cows + "B";
    }
}
