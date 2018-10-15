package com.interview.codingblocks.week7Greedy;

import java.util.*;

public class MaximumCircles {

    //https://hack.codingblocks.com/contests/c/452/563
    //This is similar to Busy man problem. We just need to find :
    // starting point of circle using: c + r
    // ending point using : c - r
    //Then we can get overlapping circles easily.
    public static void main( String[] args ) {
        solve();
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);

        List<Circle> circles = new ArrayList<>();

        int points = scanner.nextInt();
        for (int i = 0; i < points; i++) {
            int center = scanner.nextInt();
            int radius = scanner.nextInt();

            Circle circle = new Circle();
            circle.startPoint = center - radius;
            circle.endPoint = center + radius;

            circles.add(circle);
        }

        //sorting circles according to its endpoints
        circles.sort(Comparator.comparingInt(o -> o.endPoint));

        int firstCircleEndPoint = circles.get(0).endPoint, count = 1;

        //count returns non-overlapping circles
        for (int i = 1; i < circles.size(); i++) {
            if(circles.get(i).startPoint >= firstCircleEndPoint){
                firstCircleEndPoint = circles.get(i).endPoint;
                count++;
            }
        }

        //total - non_overlapping  = overlapping circles.
        System.out.println(circles.size() - count);
    }

    private static class Circle {
        int startPoint;
        int endPoint;
    }
}
