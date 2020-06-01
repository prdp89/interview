package com.interview.leetcode.graph.unionfind;

import java.util.*;

public class AccountsMerge {

    //https://leetcode.com/problems/accounts-merge/
    public static void main( String[] args ) {
        List<List<String>> list = new ArrayList<>();

        List<String> tempList = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com");
        List<String> tempList1 = Arrays.asList("John", "johnnybravo@mail.com");
        List<String> tempList2 = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> tempList3 = Arrays.asList("Mary", "mary@mail.com");

        list.add(tempList);
        list.add(tempList1);
        list.add(tempList2);
        list.add(tempList3);


        accountsMerge(list).forEach(System.out::println);
    }

    //Runtime: 29 ms, faster than 90.26% of Java online
    //We want to merge same emails into single account. Eg:johnsmith@mail.com, occurs in 1st and 3rd place of List
    //So, we'll merge John account as => {'John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'}
    private static List<List<String>> accountsMerge( List<List<String>> accounts ) {

        //creating disjoint set to group Email that has same parent = John
        int[] rank = new int[accounts.size()];
        for (int i = 0; i < rank.length; i++)
            rank[i] = i;

        //map only helps to group emails
        Map<String, Integer> map = new HashMap<>();

        //This looping method is same as MostStonesRemoved
        for (int i = 0; i < accounts.size(); i++) {

            //for each list size, loop from 1 bcz 0 is Name
            for (int j = 1; j < accounts.get(i).size(); j++) {

                String currEmail = accounts.get(i).get(j);

                //if map has same EMAIL, group it to a Disjoint set
                if (map.containsKey(currEmail)) {
                    int prevPersonIndex = map.get(currEmail);
                    int currPersonIndex = i;

                    if (findParent(prevPersonIndex, rank) != findParent(currPersonIndex, rank)) {
                        union(prevPersonIndex, currPersonIndex, rank);
                    }
                } else {
                    map.put(currEmail, i);
                }
            }
        }

        //Now we know every index 1...N => Parent's ID
        //It's time to group each parent ID to the same EMAIL.
        Map<Integer, TreeSet<String>> users = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {

            //finding parent ID of each index from Disjoint set..
            int parentIndex = findParent(i, rank);

            users.putIfAbsent(parentIndex, new TreeSet<>());

            //finding all email of current index
            List<String> emails = accounts.get(i);
            List<String> filterEmails = emails.subList(1, emails.size()); //skip name from zeroth index

            //now group emails acc. to ParentIndex bcz ParentIndex must be common for other ID 1..N
            users.get(parentIndex).addAll(filterEmails);
        }

        //We already grouped all emails in users HashMap.
        //But for result we need to append Name = John as well.
        List<List<String>> resList = new ArrayList<>();
        for (Integer id : users.keySet()) {

            //fetching Name acc. to Disjoint set Parent index
            String name = accounts.get(id).get(0);

            //fetch EMail from Disjoint set grouped ID
            List<String> list = new ArrayList<>(users.get(id));

            list.add(0, name);
            resList.add(list);
        }

        return resList;
    }

    //rank(b) = a {a,b} => findParent(,)
    private static void union( int a, int b, int[] rank ) {
        rank[findParent(b, rank)] = findParent(a, rank);
    }

    private static int findParent( int p, int[] rank ) {
        if (p != rank[p]) {
            rank[p] = findParent(rank[p], rank);
        }

        return rank[p];
    }
}
