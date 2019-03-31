package com.interview.codingblocks.week6recursion;

import java.util.*;

public class DistinctPermutationWithDuplicates {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.next().toCharArray();

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char value : s) {

            if (hashMap.containsKey(value)) {
                int count = hashMap.get(value);
                hashMap.put(value, count + 1);
            } else {
                hashMap.put(value, 1);
            }
        }

        int[] counts = new int[hashMap.size()];
        char[] chars = new char[hashMap.size()];

        int i = 0;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {

            counts[i] = entry.getValue();
            chars[i] = entry.getKey();
            i++;
        }

       /* System.out.println(Arrays.toString(counts));
        System.out.println(Arrays.toString(chars));
*/
       // List<Character> result = new ArrayList<>(s.length);
        char [] result = new char[3];

        permute(chars, counts, 0, result);
    }

    private static void permute( char[] chars, int[] count, int level, char[] result ) {

        if (result.length == level) {

            for (Character c : result) {
                System.out.print(c);
            }

            System.out.println();
        }

        for (int i = 0; i < chars.length; i++) {

            if (count[i] != 0) {

                result[level] = chars[i];
                count[i]--;

                permute(chars, count, level + 1, result);
                count[i]++;
            }
        }
    }
}
