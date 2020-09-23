package com.interview.leetcode.contests._new_weekely.weekely207;

public class ReArrangeSpaceWords {

    //https://leetcode.com/contest/weekly-contest-207/problems/rearrange-spaces-between-words/
    public static void main( String[] args ) {
        String str = "  this   is  a sentence ";
        System.out.println(reorderSpaces(str));
    }

    //88 / 88 test cases passed.
    //Status: Accepted
    //Runtime: 2 ms
    private static String reorderSpaces( String text ) {
        if (text.isEmpty())
            return text;

        String[] strs = text.split(" ");
        int len = 0;

        for (String str : strs)
            if (!str.isEmpty())
                len++;

        int spaceCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        if (spaceCount == 0)
            return text;

        int div = spaceCount / (len - 1);
        int mod = spaceCount % (len - 1);

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < strs.length - 1; i++) {
            if (!strs[i].isEmpty()) {
                sb.append(strs[i]);

                int t = div;
                while (t-- > 0) {
                    sb.append(" ");
                }
            }
        }

        sb.append(strs[i]);

        while (mod-- > 0) {
            sb.append(" ");
        }

        return sb.toString();
    }
}
