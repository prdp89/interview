package com.interview.hackerearth.augustcircuit2k18;

import com.interview.codingblocks.week7Greedy.DefenseOfAKingdom;

import java.util.*;

public class NoorAndHisPond {

    public static void main( String[] args ) {
        //solve();

        // solveAgain();

        solveDP();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();

        while (test-- > 0) {

            int n = scanner.nextInt();

            List<Pair<Integer, Integer>> pairs = new ArrayList<>();
            while (n-- > 0) {

                Pair<Integer, Integer> pair = new Pair<>();
                pair.setL(scanner.nextInt());
                pair.setR(scanner.nextInt());

                pairs.add(pair);
            }

            int total = 1;
            for (int i = 0; i < pairs.size() - 1; i++) {

                if (pairs.get(i).getR() > pairs.get(i + 1).getR() &&
                        pairs.get(i).getL() < pairs.get(i + 1).getL()) {

                    total++;
                }

            }

            System.out.println(total);
        }
    }

    private static void solveAgain() {

        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();

        while (test-- > 0) {

            int n = scanner.nextInt();

            List<Pair<Integer, Integer>> pairs = new ArrayList<>();
            while (n-- > 0) {

                Pair<Integer, Integer> pair = new Pair<>();
                pair.setL(scanner.nextInt());
                pair.setR(scanner.nextInt());

                pairs.add(pair);
            }

            int total = 1;
            for (int i = 0; i < pairs.size() - 1; i++) {

                for (int j = i + 1; j < pairs.size(); j++) {

                    if (pairs.get(i).getR() > pairs.get(j).getR() &&
                            pairs.get(i).getL() < pairs.get(j).getL()) {
                        total++;
                    }
                }
            }

            System.out.println(total);
        }
    }

    private static void solveDP() {

        Scanner scanner = new Scanner(System.in);

        int test = scanner.nextInt();

        while (test-- > 0) {

            int n = scanner.nextInt();
            int temp = n;

            List<Pair<Integer, Integer>> pairs = new ArrayList<>();
            while (n-- > 0) {

                Pair<Integer, Integer> pair = new Pair<>();
                pair.setL(scanner.nextInt());
                pair.setR(scanner.nextInt());

                pairs.add(pair);
            }

            //Sort the Points with X axis
            pairs.sort(Comparator.comparingInt(Pair::getR));

            if (temp != 1) {
                int count = 0;
                //int max = pairs.get(temp - 1).getR();
                for (int i = temp - 1; i > 0; i--) {
                    int c = 1;
                    int max = pairs.get(i).getR();
                    if (count - 1 >= i)
                        break;
                    for (int j = i - 1; j >= 0; j--) {
                        if (pairs.get(j).getL() > max) {
                            c++;
                        }
                        if (j < count - c)
                            break;
                    }
                    if (c > count)
                        count = c;

                }
                System.out.println(count);
            } else {
                System.out.println(1);
            }


        }
    }

    private static class Pair<L, R> {
        private L l;
        private R r;

        public Pair() {
        }

        public Pair( L l, R r ) {
            this.l = l;
            this.r = r;
        }

        public L getL() {
            return l;
        }

        public void setL( L l ) {
            this.l = l;
        }

        public R getR() {
            return r;
        }

        public void setR( R r ) {
            this.r = r;
        }
    }
}
