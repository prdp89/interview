package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class ImmediateFoodDeliveryI {

    /*
    If the preferred delivery date of the customer is the same as the order date then
    the order is called immediate otherwise it’s called scheduled.

    Write an SQL query to find the percentage of immediate orders in the table, rounded to 2 decimal places.

    The query result format is in the following example:

    Delivery table:
     */

    /*
        +-------------+-------------+------------+-----------------------------+
        | delivery_id | customer_id | order_date | customer_pref_delivery_date |
        +-------------+-------------+------------+-----------------------------+
        | 1           | 1           | 2019-08-01 | 2019-08-02                  |
        | 2           | 5           | 2019-08-02 | 2019-08-02                  |
        | 3           | 1           | 2019-08-11 | 2019-08-11                  |
        | 4           | 3           | 2019-08-24 | 2019-08-26                  |
        | 5           | 4           | 2019-08-21 | 2019-08-22                  |
        | 6           | 2           | 2019-08-11 | 2019-08-13                  |
        +-------------+-------------+------------+-----------------------------+
        Result table:

        +----------------------+
        | immediate_percentage |
        +----------------------+
        | 33.33                |
        +----------------------+
        The orders with delivery id 2 and 3 are immediate while the others are scheduled.

     */

    /*
    Solution:

        # Time:  O(n)
        # Space: O(1)

        SELECT Round(100 * Sum(order_date = customer_pref_delivery_date) / Count(*), 2)
               AS
               immediate_percentage
        FROM   delivery;
     */
}
