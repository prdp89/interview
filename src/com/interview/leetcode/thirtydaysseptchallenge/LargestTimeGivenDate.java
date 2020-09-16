package com.interview.leetcode.thirtydaysseptchallenge;

import java.util.ArrayList;
import java.util.List;

public class LargestTimeGivenDate {

    //https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3445/
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 4};

        System.out.println(largestTimeFromDigits_bruteforce(arr));
        System.out.println(largestTimeFromDigits_optimal(arr));

        System.out.println(largestTimeFromDigits_permutation(arr));
    }

    //Runtime: 15 ms, faster than 49.13% of Java
    //region Permutation
    private static String largestTimeFromDigits_permutation( int[] A ) {
        List<String> permutations = permutations(A);

        String res = "";

        for (String p : permutations) {
            String HH = p.substring(0, 2); //2 is exclusive
            String MM = p.substring(2);

            if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && res.compareTo(HH + ":" + MM) < 0)
                res = HH + ":" + MM;
        }

        return res;
    }

    private static List<String> permutations( int[] A ) {
        String s = "";

        for (int a : A)
            s += a;

        List<String> list = new ArrayList<>();

        permutations(s, "", list);
        return list;
    }

    private static void permutations( String s, String sofar, List<String> list ) {
        if (s.isEmpty())
            list.add(sofar);

        for (int i = 0; i < s.length(); i++) {
            permutations(s.substring(0, i) + s.substring(i + 1), sofar + s.charAt(i), list);
        }
    }

    //endregion

    //Runtime: 15 ms, faster than 49.13% of Java
    private static String largestTimeFromDigits_optimal( int[] A ) {
        String res = "";

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                for (int k = 0; k < 4; k++) {

                    if (i == j || j == k || i == k)
                        continue;

                    String HH = A[i] + "" + A[j];

                    //Now we know indexes of 3 elements i, j, k hence the 4th one is 6 -i-j-k
                    //Eg: iF i=0, j=1, k = 2 then A[6 - 0 - 1 - 2] => so element will be : A[3]
                    String MM = A[k] + "" + A[6 - i - j - k];

                    String TIME = HH + ":" + MM;

                    //Hour should less than 24, minute should less than 60
                    //and last time is smaller than current then update with bigger time.
                    if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && res.compareTo(TIME) < 0)
                        res = TIME;
                }
            }
        }
        return res;
    }

    //Runtime: 9 ms, faster than 76.18% of Java
    private static String largestTimeFromDigits_bruteforce( int[] A ) {
        Integer time = null;
        String s = null;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                if (i == j) continue;

                for (int k = 0; k < 4; k++) {

                    if (k == i || k == j) continue;

                    for (int m = 0; m < 4; m++) {

                        if (m == i || m == j || m == k)
                            continue;

                        sb.append(A[i]).append(A[j]).append(A[k]).append(A[m]);

                        if (Integer.valueOf(sb.substring(0, 2)) < 24 && Integer.valueOf(sb.substring(2, 4)) < 60) {

                            if (time == null) {
                                time = Integer.valueOf(sb.toString());
                                s = sb.substring(0, 2) + ":" + sb.substring(2, 4);
                            } else {
                                if (time < Integer.valueOf(sb.toString())) {
                                    time = Integer.valueOf(sb.toString());
                                    s = sb.substring(0, 2) + ":" + sb.substring(2, 4);
                                }
                            }
                        }

                        sb = new StringBuilder();
                    }
                }
            }
        }

        if (time == null)
            return "";

        if (time == 0)
            return "00:00";

        return s;
    }
}
