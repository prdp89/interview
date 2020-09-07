package com.interview.leetcode.trie;

import java.util.LinkedList;
import java.util.Queue;

public class MapSumPairs {

    private static Trie root = new Trie();

    public MapSumPairs() {

    }

    //https://leetcode.com/problems/map-sum-pairs/

    //Read this too: https://leetcode.com/problems/map-sum-pairs/solution/
    public static void main( String[] args ) {
        MapSumPairs mapSumPairs = new MapSumPairs();

        mapSumPairs.insert("apple", 3);
        System.out.println(mapSumPairs.sum("ap"));

        mapSumPairs.insert("app", 2);
        System.out.println(mapSumPairs.sum("ap"));
    }

    /*
    Time Complexity: Every insert operation is O(K),
    where KK is the length of the key. Every sum operation is O(K).

     */
    public void insert( String key, int val ) {
        Trie node = root;
        createTrie(node, key, val);
    }

    private void createTrie( Trie node, String key, int val ) {
        for (char ch : key.toCharArray()) {
            if (node.next[ch - 'a'] == null)
                node.next[ch - 'a'] = new Trie();

            node = node.next[ch - 'a'];
        }

        node.weight = val;
    }

    public int sum( String prefix ) {
        Trie node = root;

        for (char ch : prefix.toCharArray()) {
            if (node.next[ch - 'a'] == null)
                return 0;

            //moving to next node, to find next char of prefix
            node = node.next[ch - 'a'];
        }

        //if we iterate all chars of prefix, then we have to do BFS on that string till NODE == null
        //bcz from curr NODE path we need to traverse to all required path to calculate SUM.
        return bfs(node);
    }

    //done by me.. :)
    //This logic is similar to LongestWordInDictionary
    private int bfs( Trie node ) {
        Queue<Trie> queue = new LinkedList<>();

        queue.offer(node);

        int sum = 0;

        //This is like Level order traversal
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                Trie curr = queue.poll();

                sum += curr.weight;

                for (int i = 0; i < 26; i++) {
                    if (curr.next[i] != null)
                        queue.offer(curr.next[i]);
                }
            }
        }

        return sum;
    }

    private static class Trie {
        int weight;
        Trie[] next = new Trie[26];
    }

    //one more approach using TreeMap:
    //https://leetcode.com/problems/map-sum-pairs/discuss/412778/Java-Solution-using-TreeMap's-inbuilt-functions
    /*
    class MapSum {
    TreeMap<String, Integer> map;

	public MapSum() {
		map = new TreeMap<String, Integer>();
	}

	public void insert(String key, int val) {
		map.put(key, val);
	}

	public int sum(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return 0;
		}
		int sum = 0;
		String key = map.ceilingKey(prefix);
        while(key != null && key.startsWith(prefix)) {
        	sum += map.get(key);
            key = map.higherKey(key);
        }
		return sum;
	}

    }
     */
}
