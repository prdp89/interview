package com.interview.hackerrank.InterviewPreprationKit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoStrings {

    //https://www.hackerrank.com/challenges/two-strings/problem
    public static void main( String[] args ) {
        //solve();

        //solveAgain();

        solveOptimal();
    }

    private static Set<Character> toCharSet(String word) {
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            charSet.add(word.charAt(i));
        }

        return charSet;
    }

    private static void solveOptimal(){

        //String s1 = "hello", s2 = "world";
        String s1 = "hi", s2 = "world";

        Set<Character> charSet1 = toCharSet(s1);
        Set<Character> charSet2 = toCharSet(s2);

        //this will do the intersection of two sets, or similarity between two strings
        charSet1.retainAll(charSet2);

        if(charSet1.size() > 0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    //2 test case failed
    private static void solveAgain(){

        //String s1 = "hello", s2 = "world";
         String s1 = "hi", s2 = "world";

        boolean isFound = false;
        char [] arr = s2.toCharArray();
        for (char c: arr ) {

            if(s1.contains(String.valueOf(c))){
                isFound = true;
                break;
            }
        }

        if(isFound)
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    //4 test case failed
    private static void solve() {

       String s1 = "hello", s2 = "world";


       // String s1 = "hi", s2 = "world";

        List<Character> listS1 = s1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        HashMap<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < listS1.size(); i++) {
            map.put(i, listS1.get(i));
        }

        char[] arr2 = s2.toCharArray();
        boolean isFound = false;

        for (int i = 0; i < map.size(); i++) {

            if (i < arr2.length) {

                if (map.containsValue(arr2[i])) {
                    isFound = true;
                    break;
                }
            } else {
                System.out.println("NO");
                return;
            }
        }

        if (isFound)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
