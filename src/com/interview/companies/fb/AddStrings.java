package com.interview.companies.fb;

public class AddStrings {

    //https://leetcode.com/problems/add-strings/
    public static void main( String[] args ) {
        String str1 = "100", str2 = "200";

        System.out.println(addStrings(str1, str2));
    }

    private static String addStrings( String num1, String num2 ) {

        StringBuilder sb = new StringBuilder();

        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) {

            int sum = carry;
            if (i >= 0) { //doing i-- or --i here won't work; think why?
                sum += Character.getNumericValue(num1.charAt(i--));
            }

            if (j >= 0) {
                sum += Character.getNumericValue(num2.charAt(j--));
            }

            sb.append(sum % 10); //if sum is greater than 10, append its righmost digit
            carry = sum / 10; //if adding 2 nums create carry on num, we can get it by divide 10 operation.
        }

        //at last if carry is not empty
        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
