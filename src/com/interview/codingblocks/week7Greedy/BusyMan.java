package com.interview.codingblocks.week7Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class BusyMan {


    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> unsortMap ) {

        List<Map.Entry<K, V>> list =
                new LinkedList<>(unsortMap.entrySet());

        list.sort(Comparator.comparing(o -> (o.getValue())));

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    private static void solve() throws IOException {
        FastScanner scanner = new FastScanner(System.in);

        int testCases = scanner.br.read();

        while (testCases-- > 0) {

            int numOfActivities = scanner.nextInt();

            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < numOfActivities; i++) {

                int key = scanner.nextInt();
                int value = scanner.nextInt();

                hashMap.put(key, value);
            }

            hashMap = sortByValue(hashMap);

            System.out.println(Collections.singletonList(hashMap));

            int count = 1;

            Iterator<Map.Entry<Integer, Integer>> data = hashMap.entrySet().iterator();
            if (data.hasNext()) {

                Map.Entry<Integer, Integer> entry = data.next();

                int nextActivity = entry.getValue();

                while (data.hasNext()) {

                    if (data.hasNext())
                        data.next();

                    if (data.next().getKey() >= nextActivity) {
                        nextActivity = data.next().getValue();
                        count++;
                    }
                }
            }

            System.out.println(count);

            // System.out.println(Collections.singletonList(hashMap));

            // int count = 1, nextActivity = mapValues.get(0);


           /* int count = 1, nextActivity = activityList.get(0).endTime;
            for (int i = 1; i < activityList.size(); i++) {

                if (activityList.get(i).startTime >= nextActivity) {
                    nextActivity = activityList.get(i).endTime;
                    count++;
                }

            }*/

            //  System.out.println(count);
        }
    }

    //https://www.spoj.com/problems/BUSYMAN/
    //We are sorting the values according to ending time.
    //Then we are checking if that ending is overlap with other's starting time or not.
    public static void main( String[] args ) throws IOException {
        solve();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner( InputStream stream ) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static class Activity {
        int startTime;
        int endTime;
    }

    /*

import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{

	static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner( InputStream stream ) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        StringProblem next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

	static class Activity {
        int startTime;
        int endTime;
    }

	public static void main (StringProblem[] args) throws java.lang.Exception
	{

		FastScanner scanner = new FastScanner(System.in);

        int testCases = scanner.nextInt();

        while (testCases-- > 0){

            int numOfActivities = scanner.nextInt();

            List<Activity> activityList = new ArrayList<>();
            for (int i = 0; i < numOfActivities; i++) {

                Activity activity = new Activity();
                activity.startTime = scanner.nextInt();
                activity.endTime = scanner.nextInt();

                activityList.add(activity);
            }

            activityList.sort(Comparator.comparingInt(o -> o.endTime));

            int count = 1, nextActivity = activityList.get(0).endTime;
            for (int i = 1; i < activityList.size(); i++) {
                if (activityList.get(i).startTime >= nextActivity) {
                    nextActivity = activityList.get(i).endTime;
                    count++;
                }
            }

            System.out.println(count);
        }
	}
}
  */

}
