package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class ProductSalesAnalysisIII {

    /*
    Write an SQL query that selects the product id, year, quantity,
    and price for the first year of every product sold.
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
            +------------+------------+----------+-------+
            | product_id | first_year | quantity | price |
            +------------+------------+----------+-------+
            | 100        | 2008       | 10       | 5000  |
            | 200        | 2011       | 15       | 9000  |
            +------------+------------+----------+-------+
     */

    /*
    Solution:
    # https://code.dennyzhang.com/product-sales-analysis-iii
    #https://code.dennyzhang.com/game-play-analysis-i

    select product_id,
        min(year) as first_year,
        quantity,
        price
        from sales
        group by product_id

     */
}
