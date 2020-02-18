package com.interview.codechef.ccdsap_2.leetcode.sql.medium;

public class PeopleReportToManager {

    //https://code.dennyzhang.com/all-people-report-to-the-given-manager
    /*
        Write an SQL query to find employee_id of all employees that directly or indirectly report
         their work to the head of the company.

         The indirect relation between managers will not exceed 3 managers as the company is small.

        Return result table in any order without duplicates.

        The query result format is in the following example:

        Employees table:
        +-------------+---------------+------------+
        | employee_id | employee_name | manager_id |
        +-------------+---------------+------------+
        | 1           | Boss          | 1          |
        | 3           | Alice         | 3          |
        | 2           | Bob           | 1          |
        | 4           | Daniel        | 2          |
        | 7           | Luis          | 4          |
        | 8           | Jhon          | 3          |
        | 9           | Angela        | 8          |
        | 77          | Robert        | 1          |
        +-------------+---------------+------------+

        Result table:
        +-------------+
        | employee_id |
        +-------------+
        | 2           |
        | 77          |
        | 4           |
        | 7           |
        +-------------+

        The head of the company is the employee with employee_id 1.
        The employees with employee_id 2 and 77 report their work directly to the head of the company.
        The employee with employee_id 4 report his work indirectly to the head of the company 4 --> 2 --> 1.
        The employee with employee_id 7 report his work indirectly to the head of the company 7 --> 4 --> 2 --> 1.
        The employees with employee_id 3, 8 and 9 don't report their work to head of company directly or indirectly
     */

    /*

    Solution :

    ## https://code.dennyzhang.com/all-people-report-to-the-given-manager
    ## t3: directly report to employee_id 1
    ## t2: directly report to t3
    ## t1: directly report to t2

    select t1.employee_id

    from Employees as t1 inner join Employees as t2

    on t1.manager_id = t2.employee_id

    join Employees as t3

    on t2.manager_id = t3.employee_id

    where t3.manager_id = 1 and t1.employee_id != 1

     */
}
