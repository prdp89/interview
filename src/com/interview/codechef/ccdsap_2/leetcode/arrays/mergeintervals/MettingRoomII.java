package com.interview.codechef.ccdsap_2.leetcode.arrays.mergeintervals;

import com.interview.array.MeetingRooms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MettingRoomII {

    //https://leetcode.com/problems/meeting-rooms-ii/

    public static void main( String[] args ) {
        int[][] arr = {{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}};
        MeetingRooms.Interval[] intervals = new MeetingRooms.Interval[5];

        for (int i = 0; i < 5; i++) {
            MeetingRooms.Interval interval = new MeetingRooms.Interval(arr[i][0], arr[i][1]);
            intervals[i] = interval;
        }

        System.out.println(minMeetingRooms(intervals));
    }

    //explanation : https://www.programcreek.com/2014/05/leetcode-meeting-rooms-ii-java/
    private static int minMeetingRooms( MeetingRooms.Interval[] intervals ) {
        if (intervals.length == 0) {
            return 0;
        }

        //sorting acc. to meeting time start
        Arrays.sort(intervals, ( a, b ) -> a.start - b.start);

        //add in PQ acc. to meeting end interval
        PriorityQueue<MeetingRooms.Interval> pq = new PriorityQueue<>(( a, b ) -> a.end - b.end);
        pq.offer(intervals[0]);

        int rooms = 1;

        for (int i = 1; i < intervals.length; i++) {

            MeetingRooms.Interval it = pq.poll();

            //Whenever an old meeting ends before a new meeting starts, we remove the old meeting.
            if (it.end <= intervals[i].start) {
                it = new MeetingRooms.Interval(it.start, intervals[i].end);
            } else { //Otherwise, we need an extra room
                rooms++;
                pq.offer(intervals[i]);
            }

            pq.offer(it);
        }
        return rooms;
    }
}