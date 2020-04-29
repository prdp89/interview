package com.interview.companies.fb;

public class AddBinary {

    //https://leetcode.com/problems/add-binary/
    public static void main( String[] args ) {
        System.out.println(addBinary("11", "1"));

        System.out.println(addStringsOptimal("11", "1"));
    }

    //194 / 294 test cases passed.
    private static String addBinary( String a, String b ) {
        return Long.toBinaryString(Long.parseLong(a, 2) + Long.parseLong(b, 2));
    }

    //Runtime: 1 ms, faster than 100.00% of Java
    private static String addStringsOptimal( String num1, String num2 ) {

        StringBuilder sb = new StringBuilder();

        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) {

            int sum = carry;
            if (i >= 0) { //doing i-- or --i here won't work; think why?
                sum += (num1.charAt(i--)) - '0';
            }

            if (j >= 0) {
                sum += (num2.charAt(j--)) - '0';
            }

            sb.append(sum % 2); //if sum is greater than 10, append its righmost digit
            carry = sum / 2; //if adding 2 nums create carry on num, we can get it by divide 10 operation.
        }

        //at last if carry is not empty
        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
