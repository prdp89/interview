package com.interview.codechef.ccdsapfoundation_1.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArrays {

    //https://leetcode.com/problems/intersection-of-two-arrays
    public static void main( String[] args ) {
        intersectionArrays(new Integer[]{4, 9, 5}, new Integer[]{9, 4, 9, 8, 4});
    }

    //region Method_1
    private static void intersectionArrays( Integer[] a, Integer[] b ) {

        //Integer[] boxedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Set<Integer> set = convertToSet(a);
        Set<Integer> set1 = convertToSet(b);

        set.retainAll(set1);

        System.out.println(Arrays.toString(set.toArray()));

        int[] arr = new int[set.size()];
        int i = 0;

        for (int item : set) {
            arr[i++] = item;
        }

        //return set.toArray(new Integer[0]);
    }

    private static Set<Integer> convertToSet( Integer[] s ) {

        Set<Integer> set = new HashSet<>(s.length);

        Collections.addAll(set, s);

        return set;
    }
    //endregion

    //region Method_2
    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int aNums1 : nums1) {
            set.add(aNums1);
        }

        for (int aNums2 : nums2) {
            if (set.contains(aNums2)) {
                intersect.add(aNums2);
            }
        }

        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
    //endregion
}
