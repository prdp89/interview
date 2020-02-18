package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class ConsecutiveAvailSeats {

    //https://leetcode.com/articles/consecutive-available-seats/

    /*
    Can you help to query all the consecutive available seats
    order by the seat_id using the following cinema table?

        | seat_id | free |
        |---------|------|
        | 1       | 1    |
        | 2       | 0    |
        | 3       | 1    |
        | 4       | 1    |
        | 5       | 1    |


        Your query should return the following result for the sample case above.


        | seat_id |
        |---------|
        | 3       |
        | 4       |
        | 5       |
     */

    /*
    Solution-1:

    select distinct a.seat_id
        from cinema a inner join cinema b

        on a.seat_id = b.seat_id + 1

        or a.seat_id = b.seat_id-1

        where a.free = 1 and b.free = 1

        order by a.seat_id;


        ---------OR----------

        SELECT distinct seat_id
            FROM cinema
            WHERE free = 1 AND
            (seat_id - 1 in (select seat_id FROM cinema WHERE free = 1) OR
            seat_id + 1 in (select seat_id FROM cinema WHERE free = 1))
            ORDER BY seat_id;
     */
}
