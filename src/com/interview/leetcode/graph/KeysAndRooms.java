package com.interview.leetcode.graph;

import java.util.*;

public class KeysAndRooms {

    //https://leetcode.com/problems/keys-and-rooms/
    public static void main( String[] args ) {

        List<List<Integer>> listList = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        list.addAll(Arrays.asList(1, 3));
        listList.add(list);

        list = new ArrayList<>();
        list.addAll(Arrays.asList(3, 0, 1));
        listList.add(list);

        list = new ArrayList<>();
        list.addAll(Arrays.asList(2));
        listList.add(list);

        list = new ArrayList<>();
        list.addAll(Arrays.asList(0));
        listList.add(list);

        System.out.println(canVisitAllRooms(listList));
    }

    //similar to N way BFS algo
    private static boolean canVisitAllRooms( List<List<Integer>> rooms ) {

        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int room = queue.poll();
            for (int j : rooms.get(room)) {
                queue.offer(j);
                visited.add(j);

                //if we are able to visit all rooms
                if (visited.size() == rooms.size())
                    return true;
            }
        }

        return false;
    }
}
