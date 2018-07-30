package com.interview.codingblocks.week6recursion;

import java.util.Arrays;

//In this we are generating subsequence with a different approach and return it.
public class SubsequencesPart2 {


    private static String[] findSubsequences( String str ) {
        if (str.length() == 0) {
            return new String[]{""};
        }

        //Step 1 : findSubsequences recursion will go down upto "" string and generates stack of {xyz, yz, z, ""} values
        // Step 2 : We are doi'n  str.charAt(0) : so while coming up from recursion : Str.char[0] = Z pairs with "" = {"" , Z}
        // Step 3 : str.charAt(0) = Y and smallAns = {"" , Z} so we generate 4 pairs of smallAns after appending str.char[0] = {"" , z, "y" , "yz"}
        // Step 4 : str.charAt(0) = X and smallAns = {"" , z, "y" , "yz"} , now generates 8 pairs while appending X :
        // {"", Z, "y" , "yz", "x", "XZ", "XY", "XYZ"}

        String smallAns[] = findSubsequences(str.substring(1));

        String ans[] = new String[2 * smallAns.length];

        for (int i = 0; i < smallAns.length; i++) {
            ans[i] = smallAns[i];
        }

        for (int i = 0; i < smallAns.length; i++) {
            ans[i + smallAns.length] = str.charAt(0) + smallAns[i];
        }

        return ans;
    }

    public static void main( String[] args ) {
       String [] ans = findSubsequences("xyz");

        System.out.println(Arrays.deepToString(ans));
    }
}
