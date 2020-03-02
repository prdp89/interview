package com.interview.companies.MSFT;

public class StringWithout3ConseLetters {

    //https://leetcode.com/discuss/interview-question/398039/

    //Return a String without 3 consecutive letter as identical..
    public static void main( String[] args ) {
        System.out.println(getString("xxxtxxx"));
    }

    private static String getString( String str ) {

        StringBuilder sb = new StringBuilder();

        //imp line..
        sb.append(str.charAt(0));

        int count = 1;

        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i - 1) == str.charAt(i))
                count++;
            else {
                count = 1;
            }

            if (count < 3)
                sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}
