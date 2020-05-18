package com.interview.codechef.ccdsap_2.leetcode.bfs;

import java.util.*;

public class JumpGameIV {

    //https://leetcode.com/problems/jump-game-iv/

    //read JumpGameII first,, to continue
    public static void main( String[] args ) {
        System.out.println(minJumps(new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13}));
    }

    //Runtime: 56 ms, faster than 41.28% of Java
    //Modified and re-solve by me :)
    private static int minJumps( int[] arr ) {
        if (arr.length <= 1) {
            return 0;
        }

        //only this MAP is different from JumpGameIII
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited.add(0);

        int count = 0;

        int linit = queue.size();

        //same template like Rotten Oranges
        //Whenever we need to find in Min steps, increase the count only when one BFS level completed..

        while (!queue.isEmpty()) {

            //int size = queue.size();
            linit--;

            //for (int i = 0; i < size; i++) {
            int pop = queue.poll();

            if (pop == arr.length - 1) {
                return count;
            }

            if (pop > 0 && visited.add(pop - 1)) {
                queue.add(pop - 1);
            }

            if (pop < arr.length - 1 && visited.add(pop + 1)) {
                queue.add(pop + 1);
            }

            if (map.containsKey(arr[pop])) {

                //retrieving all the other indexes of arr[pop] value..
                //ex : if 100 is present in array, then fetching all indexes of 100's
                for (int index : map.get(arr[pop])) {
                    if (visited.add(index)) {
                        queue.add(index);
                    }
                }

                //value already added to the queue so no need to preserve the old value..
                map.remove(arr[pop]); // Since we have already taken all indexes into account, we don't need to traverse them again.
            }
            //}

            if (linit == 0) {
                count++;
                linit = queue.size();
            }
        }

        return -1;
    }
}
