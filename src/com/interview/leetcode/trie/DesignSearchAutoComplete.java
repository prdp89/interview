package com.interview.leetcode.trie;

import java.util.*;

/*
Design a search autocomplete system for a search engine.
Users may input a sentence (at least one word and end with a special character '#').
For each character they type except '#', you need to return the top 3 historical hot sentences
that have prefix the same as the part of sentence already typed. Here are the specific rules:

    1. The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
    2. The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one).
       If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
    3. If less than 3 hot sentences exist, then just return as many as you can.

  When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
Your job is to implement the following functions:

The constructor function:

AutocompleteSystem(String[] sentences, int[] times): This is the constructor.
                  The input is historical data. Sentences is a string array consists of previously typed sentences.
                  Times is the corresponding times a sentence has been typed. Your system should record these historical data.

Now, the user wants to input a new sentence. The following function will provide the next character the user types:

List input(char c): The input c is the next character typed by the user.
                    The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#').
                    Also, the previously typed sentence should be recorded in your system.
                    The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.

Example:

    Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
    The system have already tracked down the following sentences and their corresponding times:
    "i love you" : 5 times
    "island" : 3 times
    "ironman" : 2 times
    "i love leetcode" : 2 times
    Now, the user begins another search:

    Operation: input('i')
    Output: ["i love you", "island","i love leetcode"]
    Explanation:
    There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree.
    Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.

    Operation: input(' ')
    Output: ["i love you","i love leetcode"]
    Explanation:
    There are only two sentences that have prefix "i ".

    Operation: input('a')
    Output: []
    Explanation:
    There are no sentences that have prefix "i a".

    Operation: input('#')
    Output: []
    Explanation:
    The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.

 */
public class DesignSearchAutoComplete {

    private HashMap<String, Integer> count = new HashMap<>();
    private TrieNode root;
    private String curr = ""; //to hold the input character

    private DesignSearchAutoComplete( String[] sentences, int[] times ) {

        root = new TrieNode();

        for (int i = 0; i < sentences.length; i++) {
            count.put(sentences[i], times[i]);
            insert(sentences[i]);
        }
    }

    //https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/642-design-search-autocomplete-system.html
    public static void main( String[] args ) {
        String[] sentences = {"i love you", "island", "ironman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};

        DesignSearchAutoComplete d = new DesignSearchAutoComplete(sentences, times);
        d.input('i');

        d.input(' ');

        d.input('a');

        d.input('#');
    }

    private void input( char c ) {
        TrieNode node = root;
        List<String> res = new LinkedList<>();

        if (c == '#') {
            if (!count.containsKey(curr)) {
                insert(curr);
                count.put(curr, 1);
            } else {
                count.put(curr, count.get(curr) + 1);
            }
        } else {
            curr += c;
            res = findTopKElements(3, res, node);
        }

        res.forEach(System.out::print);
        System.out.println();
    }

    private List<String> findTopKElements( int k, List<String> res, TrieNode node ) {
        for (char ch : curr.toCharArray()) {
            //moving to next node, to find next char of prefix
            int index = ch == ' ' ? 26 : ch - 'a';
            node = node.next[index];
        }

        bfs(res, node);

        res.sort(( a, b ) -> !Objects.equals(count.get(a), count.get(b))
                ? count.get(b) - count.get(a)
                : a.compareTo(b));

        return res.subList(0, Math.min(k, res.size()));
    }

    private void bfs( List<String> res, TrieNode node ) {
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {
                TrieNode temp = queue.poll();

                if (null != temp && temp.isWord)
                    res.add(temp.word);

                for (int i = 0; i < 27; i++) {
                    if (null != temp && temp.next[i] != null)
                        queue.offer(temp.next[i]);
                }
            }
        }
    }

    private void insert( String sentence ) {
        TrieNode node = root;

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            int index = ch == ' ' ? 26 : ch - 'a';

            if (node.next[index] == null)
                node.next[index] = new TrieNode();

            node = node.next[index];
        }

        node.isWord = true;
        node.word = sentence;
    }

    private class TrieNode {
        boolean isWord;
        String word;
        TrieNode[] next = new TrieNode[27];
    }
}
