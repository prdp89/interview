package com.interview.hackerrank.basicPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GemStones {

    //https://www.hackerrank.com/challenges/gem-stones/problem
    public static void main( String[] args ) {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        Set<Character> set = convertToSet(scan.next());

        for (int i = 1; i < t; i++) {

            //retain get the Intersection point of array (element which is common in other arrays)
            set.retainAll(convertToSet(scan.next()));
        }

        System.out.println("common in all arrays : " + Arrays.toString(set.toArray()));

        System.out.print(set.size());
    }

    private static Set<Character> convertToSet( String s ) {

        Set<Character> set = new HashSet<>(26);

        for (char c : s.toCharArray())
            set.add(c);

        return set;
    }
}
