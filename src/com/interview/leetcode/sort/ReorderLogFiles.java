package com.interview.leetcode.sort;

import java.util.Arrays;
import java.util.Objects;

public class ReorderLogFiles {

    //https://leetcode.com/problems/reorder-data-in-log-files/
    public static void main( String[] args ) {
        String[] str = {
                "dig1 8 1 5 1",
                "let1 art can",
                "dig2 3 6",
                "let2 own kit dig",
                "let3 art zero"
        };

        System.out.println(Arrays.toString(reorderLogFiles(str)));

        String[] version = {"0.10", "0.2", "0.1", "0", "1.10", "1.2", "1.1", "1",
                "2.10", "2", "2.2", "2.1"};

        System.out.println(Arrays.toString(reorderVersionNums(version)));
    }

    private static String[] reorderLogFiles( String[] logs ) {

        Arrays.sort(logs, ( s1, s2 ) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                // both letter-logs.
                int comp = split1[1].compareTo(split2[1]);

                //using identifier first char in case of ties.
                if (comp == 0)
                    return split1[0].compareTo(split2[0]);

                else return comp;
            } else if (isDigit1 && isDigit2) {
                // both digit-logs. So keep them in original order
                return 0;
            } else if (isDigit1 && !isDigit2) {
                // first is digit, second is letter. bring letter to forward.
                return 1; //1 is for desc order
            } else {
                //first is letter, second is digit. keep them in this order.
                return -1;
            }
        });

        return logs;
    }

    private static String[] reorderVersionNums( String[] logs ) {
        Arrays.sort(logs, ( version1, version2 ) -> {

            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");

            Integer major1 = Integer.parseInt(v1[0]);
            Integer major2 = Integer.parseInt(v2[0]);

            if (Objects.equals(major1, major2)) {
                Integer minor1 = v1.length > 1 ? Integer.parseInt(v1[1]) : 0;
                Integer minor2 = v2.length > 1 ? Integer.parseInt(v2[1]) : 0;

                return minor1.compareTo(minor2);
            }

            return major1.compareTo(major2);
        });
        return logs;
    }
}
