package com.interview.leetcode.contests.contest170;

import java.util.*;

public class VideosWatchedByFriends {

    //https://leetcode.com/contest/weekly-contest-170/problems/get-watched-videos-by-your-friends/
    public static void main( String[] args ) {
        List<List<String>> watchedVideos = new ArrayList<>();

        List<String> freindVideos = new ArrayList<>(Arrays.asList("a", "b"));
        watchedVideos.add(freindVideos);

        freindVideos = new ArrayList<>(Arrays.asList("c"));
        watchedVideos.add(freindVideos);

        freindVideos = new ArrayList<>(Arrays.asList("b", "c"));
        watchedVideos.add(freindVideos);

        freindVideos = new ArrayList<>(Arrays.asList("d"));
        watchedVideos.add(freindVideos);

        int id = 0, level = 1, friends[][] = {{1, 2}, {0, 3}, {0, 3}, {1, 2}};

        watchedVideosByFriends(watchedVideos, friends, id, level).forEach(System.out::println);
    }

    //finding friends of ID = id and till Level = ? {friend - of - friends} : Using BFS
    //Then sort acc. to Freq. of watched Videos where: watchedVideos[i] is the video viewed by Friend i
    private static List<String> watchedVideosByFriends( List<List<String>> watchedVideos, int[][] friends, int id, int level ) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);

        boolean[] visited = new boolean[friends.length];
        visited[id] = true;

        while (level-- > 0) {

            int size = queue.size();
            //finding each friend of id = 0

            //till Level becomes zero
            while (size-- > 0) {
                int friend = queue.poll();

                //means 0 id friend is Friend[0]: {1, 2} 1 & 2 are zeros friend
                for (int f : friends[friend]) {
                    if (!visited[f]) {
                        visited[f] = true;

                        //storing each friend of i = 0
                        queue.offer(f);
                    }
                }
            }
        }

        //now mapping each friend to Videos watches
        HashMap<String, Integer> freq = new HashMap<>();
        while (!queue.isEmpty()) {

            for (String video : watchedVideos.get(queue.poll())) {
                freq.put(video, freq.getOrDefault(video, 0) + 1);
            }
        }

        //Now sorting acc. to videos freq.
        List<String> list = new ArrayList<>(freq.keySet());

        //sort acc. to freq.
        Collections.sort(list, ( a, b ) -> freq.get(a).equals(freq.get(b)) ? a.compareTo(b) : freq.get(a) - freq.get(b));

        return list;
    }
}
