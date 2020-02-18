package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class ProductSalesAnalysisII {

    /*
    Write an SQL query that reports the total quantity sold for every product id.
     */

    /*
    Sales table:
            +---------+------------+------+----------+-------+
            | sale_id | product_id | year | quantity | price |
            +---------+------------+------+----------+-------+
            | 1       | 100        | 2008 | 10       | 5000  |
            | 2       | 100        | 2009 | 12       | 5000  |
            | 7       | 200        | 2011 | 15       | 9000  |
            +---------+------------+------+----------+-------+

            Product table:
            +------------+--------------+
            | product_id | product_name |
            +------------+--------------+
            | 100        | Nokia        |
            | 200        | Apple        |
            | 300        | Samsung      |
            +------------+--------------+

            Result table:
            +--------------+----------------+
            | product_id   | total_quantity |
            +--------------+----------------+
            | 100          | 22             |
            | 200          | 15             |
            +--------------+----------------+
     */

    /*
    Solution:
    # https://code.dennyzhang.com/product-sales-analysis-ii

    select product_id, sum(quantity) as total_quantity
    from Sales
    group by product_id
     */
}
