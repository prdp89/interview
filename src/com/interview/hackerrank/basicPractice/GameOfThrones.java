package com.interview.hackerrank.basicPractice;

import java.util.Scanner;

public class GameOfThrones {

    //https://www.hackerrank.com/challenges/game-of-thrones/problem

    /*
    If len(str) is even, count of each elemnt should be even.

    If len(str) is odd, count of ONLY one element should be odd,
    counts of all other elements should be even.
     */

    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        int[] chars = new int[26];

        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i) - 97]++;
        }

        if (str.length() % 2 == 0) {

            for (int i : chars) {
                if (i % 2 != 0) {
                    System.out.println("NO");
                    return;
                }
            }

            System.out.println("YES");
            // System.out.println(Arrays.toString(chars));

        } else {

            int oddCount = 0;
            for (int i : chars) {

                if (i % 2 != 0) {
                    oddCount++;
                }

                if(oddCount > 1){
                    System.out.println("NO");
                    return;
                }
            }

            System.out.println("YES");
        }
    }

    /* //Another Approach :

    Set<Character> set = new HashSet<Character>();
    for(Character ch : str.toCharArray()){
        if(set.contains(ch)){
            set.remove(ch);
        }else{
            set.add(ch);
        }
    }

    System.out.println((set.size()<=1)?"YES":"NO");

     */
}
