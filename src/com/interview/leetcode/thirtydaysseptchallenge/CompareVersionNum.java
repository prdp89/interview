package com.interview.leetcode.thirtydaysseptchallenge;

public class CompareVersionNum {

    //https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/555/week-2-september-8th-september-14th/3454/
    public static void main( String[] args ) {
        String v1 = "0.1";
        String v2 = "1.1";

        /*String v1 = "0.9.9.9.9.9.9.9.9.9.9.9.9";
        String v2 = "1.0";
*/
        System.out.println(compareVersion(v1, v2));

        System.out.println(compareVersion_optimal(v1, v2));
    }

    //80 / 81 test cases passed.
    private static int compareVersion( String version1, String version2 ) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");

        float num = 0, num1 = 0, temp = 1f;
        for (String str : strs1) {
            num += (float) Integer.parseInt(str) * temp;
            temp /= 10;
        }

        temp = 1f;
        for (String str : strs2) {
            num1 += (float) Integer.parseInt(str) * temp;
            temp /= 10;
        }

        return Float.compare(num, num1);
    }

    //Runtime: 1 ms, faster than 91.56% of Java
    private static int compareVersion_optimal( String version1, String version2 ) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++) {
            //if i is less than v1 length then only parse else that will be smaller
            Integer v1_part = i < v1.length ? Integer.parseInt(v1[i]) : 0;

            Integer v2_part = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            //if not equal
            int notEquals = v1_part.compareTo(v2_part);
            if (notEquals != 0)
                return notEquals;
        }

        return 0;
    }
}
