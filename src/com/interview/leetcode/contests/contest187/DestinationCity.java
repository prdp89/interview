package com.interview.leetcode.contests.contest187;

import java.util.*;

public class DestinationCity {

    public static void main( String[] args ) {
        List<List<String>> listList = new ArrayList<>();

        List<String> list = new ArrayList<>();

        list.addAll(Arrays.asList("London", "New York"));
        listList.add(list);

        list = new ArrayList<>();
        list.addAll(Arrays.asList("New York", "Lima"));
        listList.add(list);

        list = new ArrayList<>();
        list.addAll(Arrays.asList("Lima", "Sao Paulo"));
        listList.add(list);

        System.out.println(destCity(listList));
    }

    private static String destCity( List<List<String>> paths ) {
        HashMap<String, Set<String>> map = new HashMap<>();

        for (int i = 0; i < paths.size(); i++) {
            map.put(paths.get(i).get(0), new HashSet<>());
        }

        //Adding the Edges
        for (List<String> edge : paths) {
            //Undirected graph
            map.get(edge.get(0)).add(edge.get(1));
            map.get(edge.get(0)).add(edge.get(1));
        }

        for (int i = 0; i < paths.size(); i++) {

            if (!map.containsKey(paths.get(i).get(0))) {
                return paths.get(i).get(0);
            } else if (!map.containsKey(paths.get(i).get(1))) {
                return paths.get(i).get(1);
            }
        }

        return "";
    }
}
