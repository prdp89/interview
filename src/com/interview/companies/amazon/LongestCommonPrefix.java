package com.interview.companies.amazon;

public class LongestCommonPrefix {

    //https://leetcode.com/problems/longest-common-prefix/
    public static void main( String[] args ) {
        String[] strings = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strings));
    }

    //Runtime: 1 ms, faster than 54.90% of Java
    //https://www.youtube.com/watch?v=1YQmI7F9dJ0&list=PLi9RQVmJD2fZgRyOunLyt94uVbJL43pZ_&index=35

    //Logic is to pick smallest or first String from list,
    //and compare each character with every other character of list item.
    private static String longestCommonPrefix( String[] strs ) {
        StringBuilder sb = new StringBuilder();

        if (strs == null || strs.length == 0) {
            return "";
        }

        int index = 0;
        //picking first String to compare with others
        for (Character ch : strs[0].toCharArray()) {

            //iterating every String from List
            for (int i = 1; i < strs.length; i++) {

                if (index >= strs[i].length() || ch != strs[i].charAt(index))
                    return sb.toString();
            }

            //this char exist in every list item 1..N
            sb.append(ch);
            index++;
        }

        return sb.toString();
    }
}
