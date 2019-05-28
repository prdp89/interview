package com.interview.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that determines whether a array contains duplicate
 * characters within k indices of each other
 */
public class DuplicateWithinkIndices {

    public static void main( String args[] ) {
        int arr[] = {1, 2, 3, 11, 2, 5, 6};
        DuplicateWithinkIndices dk = new DuplicateWithinkIndices();
        System.out.println(dk.duplicate(arr, 3));
    }

    public boolean duplicate( int arr[], int k ) {
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (visited.contains(arr[i])) {
                return true;
            }
            if (i >= k) {
                visited.remove(arr[i - k]);
            }
            visited.add(arr[i]);
        }
        return false;
    }

    private boolean checkDuplicate( int arr[], int k ) {
        // Creates an empty hashset
        HashMap<Integer, Integer> set = new HashMap<>();

        // Traverse the input array
        for (Integer i = 0; i < arr.length; i++) {

            if (set.containsKey(arr[i])) {

                int j = set.get(arr[i]);

                if (i - j <= k) //distanve within the K range or nto
                    return true;
            } else {
                set.put(arr[i], i);
            }
        }
        return false;
    }
}
