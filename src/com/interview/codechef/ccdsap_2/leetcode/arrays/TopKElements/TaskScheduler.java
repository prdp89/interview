package com.interview.codechef.ccdsap_2.leetcode.arrays.TopKElements;

import java.util.*;

public class TaskScheduler {

    //https://leetcode.com/problems/task-scheduler/

    //This question is similar to: ccdsap_2.leetcode.arrays.mergeintervals -> ReorganizeKDistance
    public static void main( String[] args ) {
        char[] tasks = "AAABBB".toCharArray();
        int n = 2;

        System.out.println(leastInterval(tasks, n));
    }

    //You need to return the least number of intervals the CPU will take to finish all the given tasks.
    private static int leastInterval( char[] tasks, int n ) {
        if (tasks == null || tasks.length == 0)
            return -1;

        //build map to sum the amount of each task
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // build queue, sort from descending
        PriorityQueue<Map.Entry<Character, Integer>> queue =
                new PriorityQueue<>(( a, b ) -> (b.getValue() - a.getValue()));

        queue.addAll(map.entrySet());

        int cnt = 0;

        // when queue is not empty, there are remaining tasks
        while (!queue.isEmpty()) {

            // for each interval
            int interval = n + 1;

            // list used to update queue
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();

            // fill the intervals with the next high freq task
            while (interval > 0 && !queue.isEmpty()) {

                Map.Entry<Character, Integer> entry = queue.poll();

                entry.setValue(entry.getValue() - 1);

                if (entry.getValue() > 0)
                    list.add(entry);

                // interval shrinks: total length decrement
                interval--;

                // one slot is taken
                cnt++;
            }

            // update the value in the map
            queue.addAll(list);

          /*  for (Map.Entry<Character, Integer> entry : list) {
                // when there is left task
                if (entry.getValue() > 0)
                    queue.offer(entry);
            }*/

            // job done
            if (queue.isEmpty())
                break;

            // if interval is > 0, then the machine can only be idle: we need idle time too
            cnt += interval;
        }

        return cnt;
    }
}
