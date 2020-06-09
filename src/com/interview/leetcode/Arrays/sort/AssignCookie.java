package com.interview.leetcode.Arrays.sort;

import java.util.Arrays;
import java.util.TreeMap;

public class AssignCookie {

    //https://leetcode.com/problems/assign-cookies/
    public static void main( String[] args ) {
        int[] g = {1, 2, 3};
        int[] c = {1, 1};

        System.out.println(findContentChildren(g, c));
    }

    //well done; solved it; Runtime: 52 ms, faster than 6.84% of Java
    public static int findContentChildren( int[] g, int[] s ) {
        //Arrays.sort(g); //now 49 MS

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int item : s) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        int res = 0;
        for (int greed : g) {
            Integer key = map.ceilingKey(greed);

            if (null != key) {
                res++;

                map.put(key, map.get(key) - 1);

                if (map.get(key) <= 0)
                    map.remove(key);
            }
        }

        return res;
    }

    public int findContentChildren_optimal( int[] g, int[] s ) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0, i = 0, j = 0, m = g.length, n = s.length;

        while (i < m && j < n) {
            if (g[i] > s[j])
                j++;  // find next larger cookie
            else {  // assign the min content to the min cookie;
                res++;
                i++;
                j++;
            }
        }
        return res;
    }
}
