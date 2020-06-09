package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class ProductSalesAnalysisI {

    /*
    Write an SQL query that reports all product names
    of the products in the Sales table along with their selling year and price.
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
        +--------------+-------+-------+
        | product_name | year  | price |
        +--------------+-------+-------+
        | Nokia        | 2008  | 5000  |
        | Nokia        | 2009  | 5000  |
        | Apple        | 2011  | 9000  |
        +--------------+-------+-------+
     */

    /*
    Solution:
    # https://code.dennyzhang.com/product-sales-analysis-i

    select product_name, year, price
    from Sales inner join Product
    on Product.product_id = Sales.product_id
     */
}