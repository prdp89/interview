package com.interview.codechef.ccdsap_2.atcoder.deiverta2019II;

import java.util.Scanner;

//https://www.hackerearth.com/codearena/ring/3d30d70/
public class MMDD {

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        while (n-- > 0) {
            String s1 = scanner.next(), s2 = scanner.next();

            if(s1.equals(s2)){
                System.out.println("No");
                continue;
            }

            int moves = Integer.parseInt(scanner.next());

            int countm1 = 0, countd1 = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == 'M')
                    countm1++;
                else
                    countd1++;
            }

            int countm2 = 0, countd2 = 0;
            for (int i = 0; i < s2.length(); i++) {
                if (s2.charAt(i) == 'M')
                    countm2++;
                else
                    countd2++;
            }

            int totalM = Math.abs(countm1 - countm2);
            int totalD = Math.abs(countd1 - countd2);

            if (moves >= totalD || moves >= totalM)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
