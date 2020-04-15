package com.interview.leetcode.thirtydayschallenge;

import java.util.*;

public class GroupAnagrams {

    //https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3288/
    public static void main( String[] args ) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};

        groupAnagramsOptimal(str);
    }

    //Time: O(N K LOG K)
    private static List<List<String>> groupAnagramsOptimal( String[] strs ) {
        List<List<String>> list = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] copy = str.toCharArray();

            Arrays.sort(copy);

            List<String> stringList = map.getOrDefault(Arrays.toString(copy), null);
            if (stringList == null)
                stringList = new ArrayList<>();

            stringList.add(str);

            map.put(Arrays.toString(copy), stringList);
        }

        map.forEach(( k, v ) ->
                list.add(v));

        return list;
    }

    private static List<List<String>> groupAnagrams( String[] strs ) {
        List<List<String>> list = new ArrayList<>();

        HashMap<Integer, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] arr = str.toCharArray();
            int index = 0;
            for (Character character : arr) {
                index += Character.getNumericValue(character);
            }

            List<String> stringList = map.getOrDefault(index, null);
            if (stringList == null)
                stringList = new ArrayList<>();
            stringList.add(str);
            map.put(index, stringList);
        }

        map.forEach(( k, v ) ->
                list.add(v));

        return list;
    }

    //TIME : O( N K )
    private List<List<String>> groupAnagramsMostOptimal( String[] strs ) {
        if (strs.length == 0)
            return new ArrayList();

        Map<String, List> ans = new HashMap<String, List>();

        int[] count = new int[26];

        for (String s : strs) {

            Arrays.fill(count, 0);

            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }

            String key = sb.toString();

            if (!ans.containsKey(key))
                ans.put(key, new ArrayList());

            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
