package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class ShortestDistanceInLine {

    /*
    Table point holds the x coordinate of some points on x-axis in a plane, which are all integers.
        Write a query to find the shortest distance between two points in these points.

        | x   |
        |-----|
        | -1  |
        | 0   |
        | 2   |
        The shortest distance is ‘1’ obviously, which is from point ‘-1’ to ‘0’. So the output is as below:

        | shortest|
        |---------|
        | 1       |
     */

    /*
    ## https://code.dennyzhang.com/shortest-distance-in-a-line

        select t1.x-t2.x as shortest
        from point as t1 join point as t2
        where t1.x>t2.x
        order by (t1.x-t2.x) asc
        limit 1
     */
}
