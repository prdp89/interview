package com.interview.codechef.ccdsap_2.leetcode.contests.contest145;

import java.util.*;

public class RelativeSort {

    //https://leetcode.com/contest/weekly-contest-145/problems/relative-sort-array
    public static void main( String[] args ) {

        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};

        solveTry(arr1, arr2);

        System.out.println(Arrays.toString(solveOPtimal(arr1, arr2)));
    }

    private static int[] solveOPtimal( int[] arr1, int[] arr2 ) {
        Map<Integer, Integer> elementCount = new TreeMap<>();

        int[] result = new int[arr1.length];

        for (int item : arr1) {
            int count = elementCount.getOrDefault(item, 0);
            elementCount.put(item, count + 1);
        }

        int index = 0;
        for (int i = 0; i < arr2.length; i++) {

            //if map contain element of arr1
            if (elementCount.containsKey(arr2[i])) {

                int count = elementCount.get(arr2[i]);

                while (count > 0) {
                    result[index++] = arr2[i];
                    count--;
                }

                elementCount.remove(arr2[i]);
            }
        }

        //copying remaining elements from arr1
        for (int i : elementCount.keySet()) {

            int count = elementCount.get(i);

            while (count > 0) {
                result[index++] = i;
                count--;
            }
        }

        return result;
    }

    private static void solveTry( int[] arr1, int[] arr2 ) {
        int[] res = new int[arr1.length];
        res[0] = arr2[0];

        int l = 0;
        for (int i = 0; i < arr2.length; i++) {

            int count = 0;
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    count++;
                }
            }

            if (count > 0) {
                while (count-- > 0) {
                    res[l++] = arr2[i];
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {

            boolean isFound = false;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    isFound = true;
                    break;
                }
            }

            if (!isFound)
                list.add(arr1[i]);
        }

        list.sort(Comparator.comparingInt(a -> a));

        for (int i = 0; i < list.size(); i++) {
            res[l++] = list.get(i);
        }

        System.out.println(Arrays.toString(res));
    }
}
