package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.ArrayList;

public class BeautifulArrangements {

    //https://leetcode.com/problems/beautiful-arrangement/
    public static void main( String[] args ) {

        System.out.println(countArrangement(2));
    }

    private static int countArrangement( int N ) {
        if (N == 0) return 0;

        int[] used = new int[N + 1];

        int[] total = {0};
        dfs(N, 1, total, used);

        //dfsTry(N, new ArrayList<>(), total, used);

        return total[0];
    }

    //Runtime: 62 ms, faster than 65.42% of Java
    //Working as Same PermutationTemplate logic
    private static void dfs( int n, int index, int[] total, int[] used ) {

        if (index > n) { //index == n not worked
            total[0] += 1;
            //return; //working with + without return as well
        } else {
            //Almost same as Permutations, since we have to fill 1..N elements in an Array so we do {1..N}
            for (int i = 1; i <= n; i++) {

                //used[] array: this is used in rearrangement problem,
                if (used[i] == 0 && (index % i == 0 || i % index == 0)) {
                    used[i] = 1;

                    dfs(n, index + 1, total, used);

                    //backtrack and set it to zero..
                    used[i] = 0;
                }
                //swap(nums, index, i);
            }
        }
    }

    //Not working, trying with Permutation template logic :(
    private static void dfsTry( int n, ArrayList<Integer> index, int[] total, int[] used ) {

        if (index.size() >= n) { //index >= n not worked
            total[0] += 1;
            return;
        }

        //Almost same as Permutations, since we have to fill 1..N elements in an Array so we do {1..N}
        for (int i = 1; i <= n; i++) {

            //used[] array: this is used in rearrangement problem,
            if (used[i] == 0 && (index.size() % i == 0 || i % index.size() == 0)) {
                used[i] = 1;

                index.add(i);

                dfsTry(n, index, total, used);

                index.remove(index.size() - 1);
                //backtrack and set it to zero..
                used[i] = 0;
            }
            //swap(nums, index, i);
        }
    }
}
