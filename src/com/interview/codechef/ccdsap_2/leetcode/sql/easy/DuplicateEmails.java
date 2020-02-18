package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class DuplicateEmails {

    //https://leetcode.com/articles/duplicate-emails/
    /*

    Write a SQL query to find all duplicate emails in a table named Person.

        +----+---------+
        | Id | Email   |
        +----+---------+
        | 1  | a@b.com |
        | 2  | c@d.com |
        | 3  | a@b.com |
        +----+---------+
        For example, your query should return the following for the above table:

        +---------+
        | Email   |
        +---------+
        | a@b.com |
        +---------+

     */

    /*
    Solution 1 :

    select Email
        from Person
        group by Email
        having count(Email) > 1;


    Solution 2 : Using Self Join

    SELECT DISTINCT p1.Email
        FROM Person p1, Person p2
        WHERE p1.Email = p2.Email and p1.id != p2.id;


     */
}
