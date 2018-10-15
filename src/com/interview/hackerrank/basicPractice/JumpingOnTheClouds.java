package com.interview.hackerrank.basicPractice;

public class JumpingOnTheClouds {

    //https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited
    private static void solve() {
        //int[] c = {0, 0, 1, 0, 0, 1, 1, 0};
        int[] c = {0, 0, 1, 0};

        int k = 2, totalEnergy = 100; //k for number of jumps

      /*  while (true) {

            if (index == 0)
                break;

            if (c[(index + k) % c.length] == 1)
                totalEnergy = totalEnergy - 1 - 2;
            else if (c[(index + k) % c.length] == 0)
                totalEnergy--;

            index = (index + k) % c.length;
        }*/

        for (int i = 0; i < c.length; ) {

            if (c[(i + k) % c.length] == 1)
                totalEnergy = totalEnergy - 1 - 2;

            else if (c[(i + k) % c.length] == 0)
                totalEnergy--;

            i = (i + k) % c.length;

            if (i == 0)
                break;
        }

        System.out.println(totalEnergy);
    }

    public static void main( String[] args ) {
        solve();
    }
}
