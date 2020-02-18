package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class ReformatDeptTable {

    //https://leetcode.com/problems/reformat-department-table/

    /*
    Write an SQL query to reformat the table such that
    there is a department id column and a revenue column for each month.

    The query result format is in the following example:

    Department table:
    +------+---------+-------+
    | id   | revenue | month |
    +------+---------+-------+
    | 1    | 8000    | Jan   |
    | 2    | 9000    | Jan   |
    | 3    | 10000   | Feb   |
    | 1    | 7000    | Feb   |
    | 1    | 6000    | Mar   |
    +------+---------+-------+
     */

    /*
    Result table:
        +------+-------------+-------------+-------------+-----+-------------+
        | id   | Jan_Revenue | Feb_Revenue | Mar_Revenue | ... | Dec_Revenue |
        +------+-------------+-------------+-------------+-----+-------------+
        | 1    | 8000        | 7000        | 6000        | ... | null        |
        | 2    | 9000        | null        | null        | ... | null        |
        | 3    | null        | 10000       | null        | ... | null        |
        +------+-------------+-------------+-------------+-----+-------------+
     */


    /*
        Solution:

        select id,

	sum(case when month = 'jan' then revenue else null end) as Jan_Revenue,
	sum(case when month = 'feb' then revenue else null end) as Feb_Revenue,
	sum(case when month = 'mar' then revenue else null end) as Mar_Revenue,
	sum(case when month = 'apr' then revenue else null end) as Apr_Revenue,
	sum(case when month = 'may' then revenue else null end) as May_Revenue,
	sum(case when month = 'jun' then revenue else null end) as Jun_Revenue,
	sum(case when month = 'jul' then revenue else null end) as Jul_Revenue,
	sum(case when month = 'aug' then revenue else null end) as Aug_Revenue,
	sum(case when month = 'sep' then revenue else null end) as Sep_Revenue,
	sum(case when month = 'oct' then revenue else null end) as Oct_Revenue,
	sum(case when month = 'nov' then revenue else null end) as Nov_Revenue,
	sum(case when month = 'dec' then revenue else null end) as Dec_Revenue

    from department
    group by id
    order by id


     */
}
