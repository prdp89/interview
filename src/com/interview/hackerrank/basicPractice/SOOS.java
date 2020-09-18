package com.interview.hackerrank.basicPractice;

public class SOOS {

    public static void main( String[] args ) {



        /*long startTimeB = System.nanoTime();

        solve("SOSSOSSOS");

        long endTimeB = System.nanoTime();
        long totalTimeB = endTimeB - startTimeB;
        System.out.println("Time B : " + totalTimeB);*/

        long startTimeA = System.nanoTime();

       // solveAgain("SOSSOSSOS");
        countChanges("SOSSOSSOS");

        long endTimeA = System.nanoTime();
        long totalTimeA = endTimeA - startTimeA;
        System.out.println("Time A : " + totalTimeA);

    }

    private static void solve(String input) {
        int errorPacketCount = 0;
        int messagePacketCount = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'S' && messagePacketCount == 0) {
                messagePacketCount++;
            } else if (input.charAt(i) == 'O' && messagePacketCount == 1) {
                messagePacketCount++;
            } else if (input.charAt(i) == 'S' && messagePacketCount == 2) {
                messagePacketCount++;
            } else {
                errorPacketCount++;
                messagePacketCount++;
            }
            if (messagePacketCount == 3) {
                messagePacketCount = 0;
            }
        }
        System.out.println(errorPacketCount);
    }

    private static void solveANoop(String input) {
        int errorPacketCount = 0;
        for (int i = 0; i < input.length(); i++) {

            int temp = i % 3;
            switch (temp) {
                case 0:
                    if (input.charAt(i) != 'S')
                        errorPacketCount++;
                    break;
                case 1:
                    if (input.charAt(i) != 'O')
                        errorPacketCount++;
                    break;
                case 2:
                    if (input.charAt(i) != 'S')
                        errorPacketCount++;
                    break;
            }           /* if (!(input.charAt(i) == 'S') && !(input.charAt(i)=='O')) {
                messagePacketCount++;*/
        }
        System.out.println(errorPacketCount);
    }

    private static void countChanges( String message ) {
        String sos = "SOS";
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != sos.charAt(i % 3)) count++;
        }
        System.out.println(count);
    }

   private static void solveAgain( String s ) {
        int count = 0;

        for (int i = 0; i < s.length(); i += 3) {

            if (i + 2 < s.length() && !s.substring(i, Math.min(s.length(), i + 3)).equals("SOS")) {
                char[] str = s.substring(i, i + 3).toCharArray();
                if (str[0] != 'S')
                    count++;

                if (str[1] != 'O')
                    count++;

                if (str[2] != 'S')
                    count++;
            }

        }
        System.out.println(count);
    }
}
