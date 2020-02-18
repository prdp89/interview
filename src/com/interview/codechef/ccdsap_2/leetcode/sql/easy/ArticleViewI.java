package com.interview.codechef.ccdsap_2.leetcode.sql.easy;

public class ArticleViewI {

    /*
    Write an SQL query to find all the authors that viewed at least one of their own articles,
    sorted in ascending order by their id.

    Views table:
        +------------+-----------+-----------+------------+
        | article_id | author_id | viewer_id | view_date  |
        +------------+-----------+-----------+------------+
        | 1          | 3         | 5         | 2019-08-01 |
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
        | 4    |
        | 7    |
        +------+
     */


     /*
     ## https://code.dennyzhang.com/article-views-i

    select distinct author_id as id
    from Views
    where author_id = viewer_id
    order by author_id
      */
}
