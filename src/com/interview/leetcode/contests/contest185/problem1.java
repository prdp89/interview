package com.interview.leetcode.contests.contest185;

import javafx.util.Pair;

import java.util.*;

public class problem1 {

    //https://leetcode.com/contest/weekly-contest-185/problems/display-table-of-food-orders-in-a-restaurant/
    public static void main( String[] args ) {
        System.out.println(reformat("j"));

        List<List<String>> list = new ArrayList<>();

        List<String> a = new ArrayList<>();
        a.add("Corina");
        a.add("10");
        a.add("Beef Burrito");
        list.add(a);

        a = new ArrayList<>();
        a.add("David");
        a.add("3");
        a.add("Ceviche");

        list.add(a);

        a = new ArrayList<>();
        a.add("Rous");
        a.add("3");
        a.add("Ceviche");

        list.add(a);

        displayTable(list);
    }

    private static String reformat( String s ) {

        if (s.length() == 0)
            return "";

        if (s.length() == 1)
            return s;

        int digitCount = 0, stringCount = 0;

        List<Integer> intList = new ArrayList<>();
        List<Character> strList = new ArrayList<>();

        for (Character character : s.toCharArray()) {
            if (Character.isDigit(character)) {
                digitCount++;
                intList.add(Character.getNumericValue(character));
            } else {
                strList.add(character);
                stringCount++;
            }
        }

        if (Math.abs(digitCount - stringCount) > 2 || (stringCount == 0 && digitCount > 0) || (digitCount == 0 && stringCount > 0))
            return "";

        StringBuilder sb = new StringBuilder();
        if (strList.size() >= intList.size()) {
            int i = 0;
            for (int j = 0;
                 i < strList.size() && j < intList.size(); i++, j++) {
                sb.append(strList.get(i)).append("").append(intList.get(j));
            }

            if (i < strList.size())
                sb.append(strList.get(i));
        } else {
            int i = 0;
            for (int j = 0;
                 i < intList.size() && j < strList.size(); i++, j++) {
                sb.append(intList.get(i)).append("").append(strList.get(j));
            }

            if (i < intList.size())
                sb.append(intList.get(i));
        }

        return sb.toString();
    }

    private static List<List<String>> displayTable( List<List<String>> orders ) {

        PriorityQueue<List<String>> pq = new PriorityQueue<List<String>>(( a, b ) -> b.get(1).compareTo(a.get(1)));

        for (List<String> o : orders)
            pq.offer(o);

        HashMap<String, List<Pair<String, Integer>>> map = new HashMap<>();
        while (!pq.isEmpty()) {

            List<String> list = pq.poll();

            if (map.containsKey(list.get(1))) {
                List<Pair<String, Integer>> par = map.get(list.get(1));
                // par.contains(new Pair<>)
            }

            // map.put(list.get(1), );
        }

        return orders;
    }

    private static List<List<String>> displayTableSolved( List<List<String>> orders ) {
        List<Integer> tableList = new ArrayList<>();
        Set<String> dishSet = new HashSet<>();
        HashMap<Integer, HashMap<String, Integer>> table = new HashMap<>();

        for (List<String> order : orders) {
            int tableNo = Integer.parseInt(order.get(1));
            String dish = order.get(2);
            dishSet.add(dish);

            if (table.containsKey(tableNo)) {
                HashMap<String, Integer> orderMap = table.get(tableNo);
                orderMap.put(dish, orderMap.getOrDefault(dish, 0) + 1);
            } else {
                HashMap<String, Integer> orderMap = new HashMap<>();
                orderMap.put(dish, 1);
                table.put(tableNo, orderMap);
                tableList.add(tableNo);
            }
        }
        table.forEach(( k, v ) -> System.out.println(k + " -> " + v));
        Collections.sort(tableList);
        List<String> dishList = new ArrayList<>(dishSet);
        Collections.sort(dishList);
        dishList.add(0, "Table");

        System.out.println(tableList);
        System.out.println(dishList);
        List<List<String>> ans = new ArrayList<>();
        ans.add(dishList);
        for (int i = 0; i < tableList.size(); i++) {
            List<String> row = new ArrayList<>();
            int tableNo = tableList.get(i);
            row.add("" + tableNo);
            HashMap<String, Integer> orderMap = table.get(tableNo);
            for (int j = 1; j < dishList.size(); j++) {
                String dish = dishList.get(j);
                if (orderMap.containsKey(dish)) {
                    row.add(orderMap.get(dish).toString());
                } else {
                    row.add("0");
                }
            }
            ans.add(row);
        }
        return ans;
    }
}
