package com.interview.leetcode.thirtydayschallenge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueNumber {

    /*
    Runtime: 116 ms
    Memory Usage: 84.1 MB
     */
    private Queue<Integer> queue;
    private HashMap<Integer, Integer> map = new HashMap<>();

    private FirstUniqueNumber( int[] nums ) {
        queue = new LinkedList<>();

        for (int item : nums) {
            add(item);
        }
    }

    //https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/
    public static void main( String[] args ) {
        FirstUniqueNumber firstUnique = new FirstUniqueNumber(new int[]{2, 3, 5});
        System.out.println(firstUnique.showFirstUnique()); // return 2

        firstUnique.add(5);            // the queue is now [2,3,5,5]

        System.out.println(firstUnique.showFirstUnique()); // return 2

        firstUnique.add(2);            // the queue is now [2,3,5,5,2]

        System.out.println(firstUnique.showFirstUnique()); // return 3

        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // return -1
    }

    private int showFirstUnique() {
        if (queue.isEmpty())
            return -1;

        if (map.get(queue.peek()) > 1) {
            return -1;
        }

        return queue.peek();
    }

    //queue only maintaining the unique numbers
    public void add( int value ) {
        if (map.get(value) == null) {
            queue.offer(value);
            map.put(value, 1);
        } else {
            map.put(value, map.getOrDefault(value, 0) + 1);

            //if top element is duplicate then remove it..
            if (!queue.isEmpty() && queue.peek() == value)
                queue.poll();
        }
    }
}
