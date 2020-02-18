package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class LargestOrderCustomer {

    /*
    Query the customer_number from the orders table
     for the customer who has placed the largest number of orders.
     */

    /*
    Sample Input

        | order_number | customer_number | order_date | required_date | shipped_date | status | comment |
        |--------------|-----------------|------------|---------------|--------------|--------|---------|
        | 1            | 1               | 2017-04-09 | 2017-04-13    | 2017-04-12   | Closed |         |
        | 2            | 2               | 2017-04-15 | 2017-04-20    | 2017-04-18   | Closed |         |
        | 3            | 3               | 2017-04-16 | 2017-04-25    | 2017-04-20   | Closed |         |
        | 4            | 3               | 2017-04-18 | 2017-04-28    | 2017-04-25   | Closed |         |
        Sample Output

        | customer_number |
        |-----------------|
        | 3               |
     */

    /*
    Solution:

    SELECT customer_number
        FROM
            orders
        GROUP BY customer_number
        ORDER BY COUNT(*) DESC
        LIMIT 1
        ;
     */


    /*
    Follow up: What if more than one customer have the largest number of orders,
    can you find all the customer_number in this case?
     */

    /*
    Solution:

    SELECT customer_number
        FROM orders
        GROUP BY customer_number

        HAVING count(order_number) = (

            SELECT count(order_number)
            FROM orders
            GROUP BY customer_number
            ORDER BY count(order_number) DESC LIMIT 1
)
     */
}
