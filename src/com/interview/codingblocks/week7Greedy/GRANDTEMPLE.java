package com.interview.codingblocks.week7Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GRANDTEMPLE {

    //https://hack.codingblocks.com/contests/c/452/975
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        int coordinates = scanner.nextInt();

        List<Pair<Integer, Integer>> list = new ArrayList<>();

        for (int i = 0; i < coordinates; i++) {

            Pair<Integer, Integer> pair = new Pair<>();

            //X coordinate
            pair.setL(scanner.nextInt());

            //Y coordinate
            pair.setR(scanner.nextInt());

            list.add(pair);
        }

        //Sort the Points with X axis
        list.sort(Comparator.comparingInt(Pair::getL));

        //Now we first calculate delta X by Subtracting each X with another, starts with Subtracting first element with zero.
        int maxX = Math.max(0, list.get(0).getL());
        for (int i = 1; i < list.size(); i++) {

            int diff = list.get(i).getL() - list.get(i - 1).getL() - 1;
            maxX = Math.max(maxX, diff);
        }


        //Sort the points with Y axis
        list.sort(Comparator.comparingInt(Pair::getR));

        //Now we first calculate delta Y by Subtracting each Y with another, starts with Subtracting first element with zero.
        //Then finding Max of those subtracted values.
        int maxY = Math.max(0, list.get(0).getR());
        for (int i = 1; i < list.size(); i++) {

            int diff = list.get(i).getR() - list.get(i - 1).getR() - 1;
            maxY = Math.max(maxY, diff);
        }

        System.out.println(maxX * maxY);
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
