package com.interview.leetcode.contests.contest188;

import java.util.ArrayList;
import java.util.List;

public class BuildArray {

    public static void main( String[] args ) {
        int[] arr = {2, 3, 4};
        int n = 4;

        buildArray(arr, n).forEach(System.out::println);
    }

    //The key idea here is to find Missing number in an Array.
    //If we found a missing number, we have to simulate "Push - Pop" to show that number is removed from the list.
    private static List<String> buildArray( int[] target, int n ) {

        List<String> list = new ArrayList<>();

        int k = 1;

        for (int i = 0; i < target.length; i++) {

            if (target[i] == k) {
                list.add("Push");
            } else { //we found a missing number, simulate it to remove from list..

                //Eg {1, 3} //2 is missing, next time we need i for 3
                i--; //holding the index, so that last element can process
                list.add("Push");
                list.add("Pop");
            }
            k++;
        }
        return list;
    }
}
