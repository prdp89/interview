package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class TriangleJudgement {

    /*
    Could you help Tim by writing a query to judge whether these three sides can form a triangle, assuming table triangle holds the length of the three sides x, y and z.


        | x  | y  | z  |
        |----|----|----|
        | 13 | 15 | 30 |
        | 10 | 20 | 15 |

        For the sample data above, your query should return the follow result:
        | x  | y  | z  | triangle |
        |----|----|----|----------|
        | 13 | 15 | 30 | No       |
        | 10 | 20 | 15 | Yes      |
     */

    /* SOLUTION:
    three segments can form a triangle only if the sum of any of the two segments is larger than the third one.

    SELECT
    x,
    y,
    z,
    CASE
        WHEN x + y > z AND x + z > y AND y + z > x THEN 'Yes'
        ELSE 'No'
    END
        AS 'triangle'
        FROM
            triangle;
     */

    /*
    SOLUTION : 2

    SELECT x, y, z,

    if(x > 0 and
        y > 0 and
        z > 0 and
        x + y > z and
        x + z > y and
        z + y > x, "Yes", "No")

        as triangle from triangle
     */
}
