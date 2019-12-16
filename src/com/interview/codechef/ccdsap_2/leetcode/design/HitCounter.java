package com.interview.codechef.ccdsap_2.leetcode.design;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {

    /*
     Design a hit counter which counts the number of hits received in the past 5 minutes.

     Each function accepts a timestamp parameter (in seconds granularity) and you may assume
     that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing).
     You may assume that the earliest timestamp starts at 1.

    It is possible that several hits arrive roughly at the same time.
     */

    private Queue<Integer> q = null;

    private HitCounter() {
        q = new LinkedList<>();
    }

    //https://massivealgorithms.blogspot.com/2016/08/leetcode-362-design-hit-counter.html
    //qut : https://leetcode.com/problems/design-hit-counter
    public static void main( String[] args ) {
        HitCounter hitCounter = new HitCounter();

        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);

        System.out.println("At 3 : " + hitCounter.getHits(3));

        hitCounter.hit(300);

        System.out.println("At 3 again :" + hitCounter.getHits(3));
        System.out.println("At 300 :" + hitCounter.getHits(300));
    }

    private void hit( int timestamp ) {
        q.offer(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    private int getHits( int timestamp ) {
        while (!q.isEmpty() && timestamp - q.peek() >= 300) { //we can replace 300 with timestamp to get the hits at particular timestamp
            q.poll();
        }
        return q.size();
    }
}
