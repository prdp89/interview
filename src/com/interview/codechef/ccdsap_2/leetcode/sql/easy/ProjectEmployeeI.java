package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class ProjectEmployeeI {

    /*
    Table: Employee

        Write an SQL query that reports the average experience years
        of all the employees for each project, rounded to 2 digits.

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
        +-------------+---------------+
        | project_id  | average_years |
        +-------------+---------------+
        | 1           | 2.00          |
        | 2           | 2.50          |
        +-------------+---------------+

        The average experience years for the first project is (3 + 2 + 1) / 3 = 2.00
        and for the second project is (3 + 2) / 2 = 2.50
     */

    /*
    # https://code.dennyzhang.com/project-employees-i

        select project_id, round(avg(experience_years), 2) as average_years
        from Project

        inner join Employee

        on Project.employee_id = Employee.employee_id

        group by project_id
     */
}
