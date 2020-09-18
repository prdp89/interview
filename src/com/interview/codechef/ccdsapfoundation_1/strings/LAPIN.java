package com.interview.codechef.ccdsapfoundation_1.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class LAPIN {

    public static void main( String[] args ) {
        try {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt();

            while (t-- > 0) {
                char[] str = scanner.next().toCharArray();
                int halfPoint;

                if (str.length % 2 == 0) {
                    halfPoint = str.length / 2;
                } else {
                    halfPoint = str.length / 2 + 1;
                }

                HashMap<Character, Integer> map = new HashMap<>();
                HashMap<Character, Integer> map1 = new HashMap<>();
                for (int i = 0; i < str.length / 2; i++) {

                    if (map.containsKey(str[i])) {
                        map.put(str[i], map.get(str[i]) + 1);
                    } else {
                        map.put(str[i], 1);
                    }
                }

                for (int i = halfPoint; i < str.length; i++) {

                    if (map1.containsKey(str[i])) {
                        map1.put(str[i], map1.get(str[i]) + 1);
                    } else {
                        map1.put(str[i], 1);
                    }
                }

                boolean isFalse = true;

                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (!map1.containsKey(entry.getKey())
                            || !Objects.equals(map1.get(entry.getKey()), map.get(entry.getKey()))) {
                        System.out.println("NO");
                        isFalse = false;
                        break;
                    }
                }

                if (isFalse)
                    System.out.println("YES");
            }
        } catch (Exception e) {
            return;
        }
    }
}
