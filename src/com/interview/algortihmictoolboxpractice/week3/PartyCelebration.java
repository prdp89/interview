package com.interview.algortihmictoolboxpractice.week3;

       /* Let's consider the following situation. You've invited a lot of children to a celebration party,
        and you want to entertain them and also teach them something in the process.

        You are going to hire a few teachers and divide the children into groups and assign a teacher to
        each of the groups. This teacher will work with this group through the whole party.
        But you know that for a teacher to work with a group of children efficiently children of that
        group should be of relatively the same age. More specifically age of any two children in the
        same group should differ by at most, one year.

        Also, you want to minimize the number of groups. Because you want to hire fewer teachers,
        and spend the money on presents and other kinds of entertainment for the children.
        So, you need to divide children into the minimum possible number of groups.
        Such that the age of any two children in any group differs by at most one year.*/

import java.util.Scanner;

public class PartyCelebration {

    static int getGroups( float[] children ) {

        int lastChild = children.length;
        int currentChild = 1;
        int startingPoint = 0;
        int groups = 0;

        while (currentChild < lastChild) {

            if (children[currentChild] - children[startingPoint] > 1) {
                startingPoint = currentChild;
                groups++;
            }

            if (currentChild == lastChild - 1) {
                groups++;
            }
            currentChild++;
        }


        return groups;
    }

    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);

       /* int n = in.nextInt();
        float[] children = new float[n];

        for (int i = 0; i < n; i++) {
            children[i] = in.nextFloat();
        }*/

        System.out.println(getGroups(new float[]{(float) 2.0, (float) 4.0, (float) 2.0, (float) 1.0}));
    }
}

