package com.interview.codechef.ccdsapfoundation_1.greedy;

import java.util.Scanner;

public class MANYCHEF {

    //https://www.codechef.com/problems/MANYCHEF

    public static void main( String[] args ) {
        solve();
    }

    //nice editorial : https://discuss.codechef.com/t/manychef-editorial/1410
    private static void solve() {
        try {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();

            while (t-- > 0) {
                char[] str = scanner.next().toCharArray();

                //trying to fill CHEF from end
                for (int j = str.length - 1; j >= 3; j--) {

                    if ((str[j] == 'F' || str[j] == '?')
                            && (str[j - 1] == 'E' || str[j - 1] == '?')
                            && (str[j - 2] == 'H' || str[j - 2] == '?')
                            && (str[j - 3] == 'C' || str[j - 3] == '?')) {
                        str[j] = 'F';
                        str[j - 1] = 'E';
                        str[j - 2] = 'H';
                        str[j - 3] = 'C';
                    }
                }

                for (int i = 0; i < str.length; i++) {
                    if (str[i] == '?')
                        str[i] = 'A';
                }

                System.out.println(str);
            }
        } catch (Exception e) {
            return;
        }
    }
}
