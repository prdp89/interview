//package com.interview.algortihmictoolboxpractice.week4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ClosestPairPoint {

    // A utility function to find the distance between two points
    static Double dist( Point p1, Point p2 ) {
        return  Math.sqrt((p1.x - p2.x) * (p1.x - p2.x)
                + (p1.y - p2.y) * (p1.y - p2.y)
        );
    }

    // A Brute Force method to return the smallest distance between two points
    // in P[] of size n
    static Double bruteForce( Point P[], int n ) {
        Double min = Double.MAX_VALUE;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                if (dist(P[i], P[j]) < min)
                    min = dist(P[i], P[j]);
        return min;
    }

    private static Double closestPoint( Point[] points, int n ) {

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare( Point o1, Point o2 ) {
                return Double.compare(o1.x, o2.x);
            }
        });

        return closestPointUtil(points, points.length);
    }

    // A utility function to find the distance between the closest points of
// strip of given size. All points in strip[] are sorted according to
// y coordinate. They all have an upper bound on minimum distance as d.
// Note that this method seems to be a O(n^2) method, but it's a O(n)
// method as the inner loop runs at most 6 times
    private static Double stripClosest( Point strip[], int size, Double d ) {
       Double min = d;  // Initialize the minimum distance as d

        Arrays.sort(strip, new Comparator<Point>() {
            @Override
            public int compare( Point o1, Point o2 ) {
                if (o1 == null || o2 == null)
                    return 0;
                else
                    return Double.compare(o1.y, o2.y);
            }
        });

        // Pick all points one by one and try the next points till the difference
        // between y coordinates is smaller than d.
        // This is a proven fact that this loop runs at most 6 times
        for (int i = 0; i < size; ++i)
            for (int j = i + 1; j < size && Math.abs(strip[j].y - strip[i].y) < min; ++j)
                if (dist(strip[i], strip[j]) < min)
                    min = dist(strip[i], strip[j]);

        return min;
    }

    private static Double closestPointUtil( Point[] points, int n ) {

        // If there are 2 or 3 points, then use brute force
        if (n <= 3)
            return stripClosest(points, n, Double.MAX_VALUE);

        // Find the middle point
        int mid = n / 2;
        Point midPoint = points[mid];

        // Consider the vertical line passing through the middle point
        // calculate the smallest distance dl on left of middle point and
        // dr on right side
        double dl = closestPointUtil(points, mid);
        double dr = closestPointUtil(points, n - mid);

        // Find the smaller of two distances
        Double d = Math.min(dl, dr);

        // Build an array strip[] that contains points close (closer than d)
        // to the line passing through the middle point
        Point strip[] = new Point[n];
        int j = 0;
        for (int i = 0; i < n; i++)
            if (Math.abs(points[i].x - midPoint.x) < d) {
                strip[j++] = points[i];
            }

        // Find the closest points in strip.  Return the minimum of d and closest
        // distance is strip[]
       // if (strip.length > 0)
            return Math.min(d, stripClosest(strip, j, d));
       // return d;
    }

    // The main functin that finds the smallest distance
   // This method mainly uses closestUtil()
    private static Double closestONLogN(Point P[], int n)
    {
        Point Px[] = new Point[n];
        Point Py[] = new Point[n];

        for (int i = 0; i < n; i++)
        {
            Px[i] = P[i];
            Py[i] = P[i];
        }

        Arrays.sort(Px, new Comparator<Point>() {
            @Override
            public int compare( Point o1, Point o2 ) {
                return Double.compare(o1.x, o2.x);
            }
        });

        Arrays.sort(Py, new Comparator<Point>() {
            @Override
            public int compare( Point o1, Point o2 ) {
                return Double.compare(o1.y, o2.y);
            }
        });

        // Use recursive function closestUtil() to find the smallest distance
        return closestUtilONLogN(Px, Py, n);
    }

    private static Double closestUtilONLogN( Point[] Px, Point[] Py, int n) {
        // If there are 2 or 3 points, then use brute force
        if (n <= 3)
            return stripClosest(Px, n, Double.MAX_VALUE);

        // Find the middle point
        int mid = n/2;
        Point midPoint = Px[mid];

        // Divide points in y sorted array around the vertical line.
        // Assumption: All x coordinates are distinct.
        Point Pyl[]= new Point[n];   // y sorted points on left of vertical line
        Point Pyr[] = new Point[n];  // y sorted points on right of vertical line

        int li = 0, ri = 0;  // indexes of left and right subArrays

        for (int i = 0; i < n; i++)
        {
            if (Py[i].x <= midPoint.x)
                Pyl[li++] = Py[i];
            else
                Pyr[ri++] = Py[i];
        }

        // Consider the vertical line passing through the middle point
        // calculate the smallest distance dl on left of middle point and
        // dr on right side
        Double dl = closestUtilONLogN(Px, Pyl, mid);

        Point [] pointsArray = Arrays.copyOfRange(Px,mid,n);
        Double dr = closestUtilONLogN( pointsArray, Pyr, n);

        // Find the smaller of two distances
        Double d = Math.min(dl, dr);

        // Build an array strip[] that contains points close (closer than d)
        // to the line passing through the middle point
        Point strip[] = new Point[n];
        int j = 0;
        for (int i = 0; i < n; i++)
            if (Math.abs(Py[i].x - midPoint.x) < d)
                strip[j++] = Py[i];

        // Find the closest points in strip.  Return the minimum of d and closest
        // distance is strip[]
        return Math.min(d, stripClosest(strip, j, d) );
    }

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            Point point = new Point(scanner.nextDouble(), scanner.nextDouble());
            points[i] = point;
        }

       // Point[] points = new Point[]{new Point(2, 3), new Point(12, 30), new Point(40, 50), new Point(5, 1), new Point(12, 10), new Point(3, 4)};
       // System.out.println(closestPoint(points, points.length));

        System.out.println(closestONLogN(points, points.length));
    }

    static class Point {
        Double x;
        Double y;

        Point( Double x, Double y ) {
            this.x = x;
            this.y = y;
        }
    }
}
