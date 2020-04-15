package com.interview.codechef.ccdsap_2.leetcode.strings;

import java.util.*;

public class GroupShiftStrings {

    //https://www.programcreek.com/2014/05/leetcode-group-shifted-strings-java/


    /*
    Given an array of strings (all lowercase letters), the task is to group them in such a way
    that all strings in a group are shifted versions of each other. Two string S and T are called shifted if,

    S.length = T.length
    and
    S[i] = T[i] + K for
    1 <= i <= S.length  for a constant integer K

    Input  : str[] = {"acd", "dfg", "wyz", "yab", "mop",
                 "bdfh", "a", "x", "moqs"};

    Output : a x
             acd dfg wyz yab mop
             bdfh moqs
    All shifted strings are grouped together.
     */
    public static void main( String[] args ) {
        String str[] = {"acd", "dfg", "wyz", "yab", "mop",
                "bdfh", "a", "x", "moqs"};

        groupStrings(str).forEach(System.out::println);
    }

    private static List<List<String>> groupStrings( String[] strings ) {
        List<List<String>> result = new ArrayList<>();

        HashMap<String, ArrayList<String>> map
                = new HashMap<>();

        for (String s : strings) {

            char[] arr = s.toCharArray();

            if (arr.length > 0) {
                int diff = arr[0] - 'a';

                //This loop convert each character of String subtract to 'a' char.
                //Example : DFG --> D - 'a' => 3 == a
                //              --> F - 3 => c
                //              --> G - 3 => d

                //So, DFG -> will group with ACD
                for (int i = 0; i < arr.length; i++) {

                    if (arr[i] - diff < 'a') {
                        arr[i] = (char) (arr[i] - diff + 26);
                    } else {
                        arr[i] = (char) (arr[i] - diff);
                    }
                }
            }

            String ns = new String(arr);

            if (map.containsKey(ns)) {
                map.get(ns).add(s);
            } else {
                ArrayList<String> al = new ArrayList<>();
                al.add(s);
                map.put(ns, al);
            }
        }

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }

        result.addAll(map.values());
        return result;
    }
}
