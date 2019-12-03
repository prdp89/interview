package com.interview.javabasics;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiExample {

    //https://www.java67.com/2018/06/java-8-streamcollect-example.html
    public static void main( String[] args ) {

        int sum = Arrays.stream(new int[]{1, 2, 3})
                .filter(i -> i >= 2)
                .sum();
        System.out.println(sum);

        //------------------------------------------------------
        int sum_1 = Arrays.stream(new int[]{1, 2, 3})
                .map(i -> i * 2)
                .sum();
        System.out.println(sum_1);

        //-------------------------------------------------------

        List<String> listOfString = Arrays.asList("Java", "C", "C", "C++", "Go", "JavaScript", "Python", "Scala");

        List<String> listOfStringStartsWithJ
                = listOfString
                .stream()
                .filter(s -> s.startsWith("J"))
                .collect(Collectors.toList());
        System.out.println(listOfStringStartsWithJ);

        //-------------------------------------------------------------

        Set<String> setOfStringStartsWithC
                = listOfString
                .stream()
                .filter(s -> s.startsWith("C"))
                .collect(Collectors.toSet());

        System.out.println("set of String starts with letter C: "
                + setOfStringStartsWithC);

        // Example 3 - converting Stream to Map--------------------------

        List<String> listOfStringUnique = Arrays.asList("Java", "C", "C++", "Go", "JavaScript", "Python", "Scala");
        Map<String, Integer> stringToLength
                = listOfStringUnique
                .stream()
                .collect(Collectors.toMap(Function.identity(),
                        String::length));
        System.out.println("map of string and their length: " + stringToLength);


        //-------------------------------------------------------------

        ArrayList<String> stringWithLengthGreaterThanTwo
                = listOfString.stream()
                .filter(s -> s.length() > 2)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("collection of String with length greather than 2: "
                + stringWithLengthGreaterThanTwo);

        //--------------------------------------------------------------

        //Throw exception at start
        Consumer<String> removeElement = s -> {
            System.out.println(s + " " + listOfString.size());
            if (s != null && s.equals("C++")) {
                listOfString.remove("C++");
            }
        };

        listOfString.forEach(removeElement);

        //throw exception at last
        listOfString.stream().forEach(removeElement);
    }
}
