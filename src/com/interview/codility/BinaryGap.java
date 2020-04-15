package com.interview.codility;

public class BinaryGap {

    //https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
    public static void main( String[] args ) {

        int n = 1041;

        String str = Integer.toBinaryString(n);

        int maxCount = Integer.MIN_VALUE, count = 0;

        int i = str.indexOf('1');
        for (; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                count++;
            else {
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }

        System.out.println(maxCount != Integer.MIN_VALUE ? maxCount : 0);
    }
}
