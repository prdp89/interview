package com.interview.companies.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SearchSuggestionSystem {

    //https://leetcode.com/problems/search-suggestions-system/
    public static void main( String[] args ) {

        String searchWord = "mouse", products[] = {
                "mobile", "mouse", "moneypot", "monitor", "mousepad"
        };

        suggestedProducts(products, searchWord).forEach(System.out::println);
    }

    //ref:
    private static List<List<String>> suggestedProducts( String[] products, String searchWord ) {

        PriorityQueue<String> pq = new PriorityQueue<>(3, ( a, b ) -> a.compareTo(b));
        List<List<String>> resultList = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) { //bcz in substring(0,i) second param is exclusive

            String temp = searchWord.substring(0, i);

            //this is maintaing lexo. order
            for (String str : products) {
                if (str.startsWith(temp))
                    pq.offer(str);
            }

            //this is inserting 3 items in list..
            List<String> strList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (null != pq.peek())
                    strList.add(pq.poll());
            }

            pq.clear();
            resultList.add(strList);
        }

        return resultList;
    }
}
