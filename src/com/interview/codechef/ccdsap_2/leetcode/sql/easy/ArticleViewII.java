package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class ArticleViewII {

    /*
    Write an SQL query to find all the people who viewed more
    than one article on the same date, sorted in ascending order by their id.

        The query result format is in the following example:

        Views table:
        +------------+-----------+-----------+------------+
        | article_id | author_id | viewer_id | view_date  |
        +------------+-----------+-----------+------------+
        | 1          | 3         | 5         | 2019-08-01 |
        | 3          | 4         | 5         | 2019-08-01 |
        | 1          | 3         | 6         | 2019-08-02 |
        | 2          | 7         | 7         | 2019-08-01 |
        | 2          | 7         | 6         | 2019-08-02 |
        | 4          | 7         | 1         | 2019-07-22 |
        | 3          | 4         | 4         | 2019-07-21 |
        | 3          | 4         | 4         | 2019-07-21 |
        +------------+-----------+-----------+------------+

        Result table:
        +------+
        | id   |
        +------+
        | 5    |
        | 6    |
        +------+
     */

     /*
     ## https://code.dennyzhang.com/article-views-ii

        select distinct viewer_id as id
        from Views

        group by viewer_id, view_date

        having count(distinct article_id) > 1
      */
}
