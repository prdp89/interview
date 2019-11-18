package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BraceExpansion {

    //https://www.youtube.com/watch?v=tJPpHxPEXX0
    //https://leetcode.com/discuss/interview-question/175553/Google%3A-Print-all-possible-outputs-of-given-string/

    //Input : "{a, b}c{d, e}f"
    //output: ["acdf", "acef", "bcdf", "bcef"] //op should be in lexo. order
    public static void main( String[] args ) {

        String str = "{a,b}c{d,e}f";
        braceExpansion(str);
    }

    private static String[] braceExpansion( String str ) {

        //Step1 : Finding char inside string in form => ab, c, de, f
        //Step2 : DFS
        //Step3 : list => array sort

        List<String> list = new ArrayList<>();
        int n = str.length();

        //Step1 :
        for (int i = 0; i < n; i++) {

            if (str.charAt(i) == '{') {
                int j = i + 1;
                StringBuilder sb = new StringBuilder();

                while (j < n && str.charAt(j) != '}') {

                    if (str.charAt(j) == ',') {
                        j++;
                        continue;
                    }

                    sb.append(str.charAt(j++));
                }

                list.add(sb.toString());
                i = j; //i reach to J at this point
            } else {
                list.add(String.valueOf(str.charAt(i)));
            }
        }

        //list = {ab, c, de, f}
        // list.forEach(System.out::println);

        //Step 2 :

        List<String> res = new ArrayList<>();
        dfs(list, res, new StringBuilder(), 0);

        int size = res.size();
        int index = 0;
        String[] result = new String[size];

        for (String s : res) {
            result[index++] = s;
        }

        Arrays.sort(result);

        return result;
    }


    //list = {ab, c, de, f}
    //This dfd logic is same as : Permutations :)
    private static void dfs( List<String> list, List<String> res, StringBuilder sb, int index ) {

        if (sb.length() == list.size()) { //we have generated 4 required chars
            res.add(sb.toString());
            return;
        }

        //for each character in List branch out in different direction.
        for (Character c : list.get(index).toCharArray()) {
            sb.append(c);
            dfs(list, res, sb, index + 1);

            //backtrack to remove last append char
            sb.setLength(sb.length() - 1);
        }
    }
}
