package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class FindCustomerRefree {

    //https://leetcode.com/articles/find-customer-referee/
    /*
    Given a table customer holding customers information and the referee.

    +------+------+-----------+
    | id   | name | referee_id|
    +------+------+-----------+
    |    1 | Will |      NULL |
    |    2 | Jane |      NULL |
    |    3 | Alex |         2 |
    |    4 | Bill |      NULL |
    |    5 | Zack |         1 |
    |    6 | Mark |         2 |
    +------+------+-----------+
    Write a query to return the list of customers NOT referred by the person with id '2'.

    For the sample data above, the result is:

    +------+
    | name |
    +------+
    | Will |
    | Jane |
    | Bill |
    | Zack |
    +------+
     */

    /* Wrong Solution:
    SELECT name FROM customer WHERE referee_id = NULL OR referee_id <> 2;

    The key is to always use IS NULL or IS NOT NULL operators to specifically check for NULL value.
     */

    /* Correct Solution:
    SELECT name FROM customer WHERE referee_id != 2 OR referee_id IS NULL;
     */
}
