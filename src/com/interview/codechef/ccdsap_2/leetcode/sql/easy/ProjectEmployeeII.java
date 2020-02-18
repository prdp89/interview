package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class ProjectEmployeeII {

    //Almost similar to Second solution of : LargestOrderCustomer
    /*
        Write an SQL query that reports all the projects that have the most employees.

        The query result format is in the following example:

        Project table:
        +-------------+-------------+
        | project_id  | employee_id |
        +-------------+-------------+
        | 1           | 1           |
        | 1           | 2           |
        | 1           | 3           |
        | 2           | 1           |
        | 2           | 4           |
        +-------------+-------------+

        Employee table:
        +-------------+--------+------------------+
        | employee_id | name   | experience_years |
        +-------------+--------+------------------+
        | 1           | Khaled | 3                |
        | 2           | Ali    | 2                |
        | 3           | John   | 1                |
        | 4           | Doe    | 2                |
        +-------------+--------+------------------+

        Result table:
        +-------------+
        | project_id  |
        +-------------+
        | 1           |
        +-------------+
        The first project has 3 employees while the second one has 2.

     */

    /*
    Solution :

    # https://code.dennyzhang.com/project-employees-ii

    select project_id
    from Project

    group by project_id

    having count(*) = (
        select count(*)
        from Project

        group by project_id

        order by count(*) desc
        limit 1)

     */
}
