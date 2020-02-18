package com.interview.codechef.ccdsap_2.leetcode.sql.medium;

public class RunningTotalDiffGenders {

    //https://code.dennyzhang.com/running-total-for-different-genders
    /*

    Write an SQL query to find the total score for each gender at each day.

    Order the result table by gender and day

    The query result format is in the following example:

    Scores table:
        +-------------+--------+------------+--------------+
        | player_name | gender | day        | score_points |
        +-------------+--------+------------+--------------+
        | Aron        | F      | 2020-01-01 | 17           |
        | Alice       | F      | 2020-01-07 | 23           |
        | Bajrang     | M      | 2020-01-07 | 7            |
        | Khali       | M      | 2019-12-25 | 11           |
        | Slaman      | M      | 2019-12-30 | 13           |
        | Joe         | M      | 2019-12-31 | 3            |
        | Jose        | M      | 2019-12-18 | 2            |
        | Priya       | F      | 2019-12-31 | 23           |
        | Priyanka    | F      | 2019-12-30 | 17           |
        +-------------+--------+------------+--------------+
        Result table:
        +--------+------------+-------+
        | gender | day        | total |
        +--------+------------+-------+
        | F      | 2019-12-30 | 17    |
        | F      | 2019-12-31 | 40    |
        | F      | 2020-01-01 | 57    |
        | F      | 2020-01-07 | 80    |
        | M      | 2019-12-18 | 2     |
        | M      | 2019-12-25 | 13    |
        | M      | 2019-12-30 | 26    |
        | M      | 2019-12-31 | 29    |
        | M      | 2020-01-07 | 36    |
        +--------+------------+-------+
     */

    /*
        Solution:

        ## https://code.dennyzhang.com/running-total-for-different-genders
        # Get accumulated value

        select t1.gender, t1.day, sum(t1.score_points) as total

        from Scores as t1 inner join Scores as t2

        on t1.gender = t2.gender

        and t1.day>=t2.day

        group by t1.gender, t1.day
     */
}
