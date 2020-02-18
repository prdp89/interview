package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class AverageSellingPrice {

    /*
    Write an SQL query to find the average selling price for each product.

     */

    /*
    Prices table:

        +------------+------------+------------+--------+
        | product_id | start_date | end_date   | price  |
        +------------+------------+------------+--------+
        | 1          | 2019-02-17 | 2019-02-28 | 5      |
        | 1          | 2019-03-01 | 2019-03-22 | 20     |
        | 2          | 2019-02-01 | 2019-02-20 | 15     |
        | 2          | 2019-02-21 | 2019-03-31 | 30     |
        +------------+------------+------------+--------+
        UnitsSold table:

        +------------+---------------+-------+
        | product_id | purchase_date | units |
        +------------+---------------+-------+
        | 1          | 2019-02-25    | 100   |
        | 1          | 2019-03-01    | 15    |
        | 2          | 2019-02-10    | 200   |
        | 2          | 2019-03-22    | 30    |
        +------------+---------------+-------+
        Result table:

        +------------+---------------+
        | product_id | average_price |
        +------------+---------------+
        | 1          | 6.96          |
        | 2          | 16.96         |
        +------------+---------------+
        Average selling price = Total Price of Product / Number of products sold.
        Average selling price for product 1 = ((100 * 5) + (15 * 20)) / 115 = 6.96
        Average selling price for product 2 = ((200 * 15) + (30 * 30)) / 230 = 16.96
     */

    /*
    ## https://code.dennyzhang.com/average-selling-price

        select UnitsSold.product_id, round(sum(units*price) / sum(units), 2) as average_price

        from UnitsSold inner join Prices

        on UnitsSold.product_id = Prices.product_id

        and UnitsSold.purchase_date between Prices.start_date and Prices.end_date

        group by UnitsSold.product_id
     */
}
