package com.interview.codechef.ccdsapfoundation_1.greedy;

import java.util.Scanner;

public class CHEFST {

    public static void main( String[] args ) {
        //  solve();
        optimal();
    }

    //good editorial : https://discuss.codechef.com/t/chefst-editorial/11978
    private static void optimal() {
        try {
            Scanner scanner = new Scanner(System.in);

            int t = scanner.nextInt();

            while (t-- > 0) {
                long n1 = scanner.nextLong(); //4
                long n2 = scanner.nextLong(); //5
                long m = scanner.nextLong(); //2

                //m is limit of stones to be removed from each piles n1 & n2
                //if n1 = 4 n2 = 5 m = 2
                //then n1 = {1, 2, 3, 4}
                //then n2 = {1, 2, 3, 4, 5}
                //At first step we can remove 1 stone from both list
                //At second step we can remove 2 stones from both list
                //So we have 1 + 2 + .......m {stone removed}

        /*
        At any point in the game, the number of stones we have removed from both piles are always equal.
        Suppose we remove X stones from both piles. Then there are n1 - X stonesleft in pile_1 and n2-X left in pile_2.
         */

        /*
        (n1- x) + (n2 - x ) => n1 + n2 - 2x
        where X is removed stones and that is : (m (m + 1))/2
        Therefore : n1 + n2 - 2 ( (m (m + 1))/2 )
         */

        /*
        But above condition only holds when n1 and n2 are atleast : (m (m + 1))/2
        Which also means : sum <= Math.min(n1, n2)
         */

                //To summarize

                long possible = (m * (m + 1)) / 2; //all possible remove stone

                possible = Math.min(possible, Math.min(n1, n2)); //to hold n1+n2-2x it should be atleast this possible

                long ans = n1 + n2 - 2 * possible;
                System.out.println(ans);
            }
        } catch (Exception e) {
            return;
        }
    }

    private static void solve() {
        // try {
        Scanner scanner = new Scanner(System.in);

           /* int t = scanner.nextInt();

            while (t-- > 0){*/
        long n1 = scanner.nextLong();
        long n2 = scanner.nextLong();
        long m = scanner.nextLong();

        long moves = (int) Math.min(n1, n2);
        long start = 1;
        while (true) {

            if (n1 >= start && n2 >= start && start <= m) {
                n1 = n1 - start;
                n2 = n2 - start;

                start++;
            } else {
                break;
            }
        }

        System.out.println(n1 + n2);
        //  }
      /*  } catch (Exception e){
            return;
        }*/
    }
}
