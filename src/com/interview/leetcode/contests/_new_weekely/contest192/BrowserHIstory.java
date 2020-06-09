package com.interview.leetcode.contests._new_weekely.contest192;

import java.util.ArrayList;
import java.util.List;

public class BrowserHIstory {

    private int index = 0;
    private List<String> list = new ArrayList<>();

    public BrowserHIstory( String homepage ) {
        list.add(homepage);
    }

    public static void main( String[] args ) {
        BrowserHIstory browserHistory = new BrowserHIstory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"

        System.out.println(browserHistory.back(1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"

        System.out.println(browserHistory.back(1));                   // You are in "facebook.com", move back to "google.com" return "google.com"

        System.out.println(browserHistory.forward(1));                // You are in "google.com", move forward to "facebook.com" return "facebook.com"

        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"

        browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.

        browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"

        browserHistory.back(7);
    }

    public void visit( String url ) {

        //THis code will execute when we visit "linkedin.com"
        //we are at index = 2 = facebook.com
        //below code removes youtube.com from history, bcz it is forward history
       /* while (index != list.size() - 1)
            list.remove(list.size() - 1);*/

        //or this code also works..
        list.subList(index + 1, list.size()).clear();

        list.add(url);
        index++;
    }

    public String back( int steps ) {
        index = Math.max(index - steps, 0);
        return list.get(index);
    }

    public String forward( int steps ) {
        index = Math.min(index + steps, list.size() - 1);
        return list.get(index);
    }
}
