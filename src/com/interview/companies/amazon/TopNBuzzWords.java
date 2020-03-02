package com.interview.companies.amazon;

import java.util.*;

public class TopNBuzzWords {

    //https://leetcode.com/discuss/interview-question/460127/
    //Return a list of strings of the most popular N toys in order of most to least frequently mentioned

    /*
    Input:
    numToys = 6
    topToys = 2
    toys = ["elmo", "elsa", "legos", "drone", "tablet", "warcraft"]
    numQuotes = 6
    quotes = [
    "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
    "The new Elmo dolls are super high quality",
    "Expect the Elsa dolls to be very popular this year, Elsa!",
    "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
    "For parents of older kids, look into buying them a drone",
    "Warcraft is slowly rising in popularity ahead of the holiday season"
    ];

    Output:
    ["elmo", "elsa"]
     */
    public static void main( String[] args ) {

        int numToys = 6, topToys = 2, numQuotes = 6;
        String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};

        String[] quotes = {
                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"
        };

        topNBuzzwords(numToys, topToys, toys, numQuotes, quotes).forEach(System.out::println);
    }

    private static List<String> topNBuzzwords( int numToys, int topToys, String[] toys, int numQuotes, String[] quotes ) {
        List<String> res = new ArrayList<>();

        Set<String> setToys = new HashSet<>();
        Map<String, WordStats> mapWords = new HashMap<>();

        for (int i = 0; i < numToys; i++)
            setToys.add(toys[i]);

        for (int i = 0; i < numQuotes; i++) {

            String q = quotes[i];
            q = q.replaceAll("[\\!?,;.]", "").toLowerCase();

            String[] words = q.split(" ");

            for (int w = 0; w < words.length; w++) {
                String word = words[w];

                if (setToys.contains(word)) {

                    WordStats stats;
                    if (mapWords.containsKey(word))
                        stats = mapWords.get(word);
                    else
                        stats = new WordStats(word, 0);

                    stats.countTimes++;
                    stats.quotesIds.add(i);
                    mapWords.put(word, stats);
                }
            }
        }

        PriorityQueue<WordStats> pq = new PriorityQueue<WordStats>(new Comparator<WordStats>() {
            @Override
            public int compare( WordStats o1, WordStats o2 ) {
                if (o1.countTimes != o2.countTimes)
                    return Integer.compare(o2.countTimes, o1.countTimes); //desc of CountTimes
                else if (o1.quotesIds.size() != o2.quotesIds.size())
                    return Integer.compare(o2.quotesIds.size(), o1.quotesIds.size()); //desc of quotId
                else
                    return o1.word.compareTo(o2.word); //desc of word
            }
        });

        pq.addAll(mapWords.values());

        if (topToys > pq.size())
            for (int i = 0; i < numToys && !pq.isEmpty(); i++)
                res.add(pq.poll().word);
        else
            for (int i = 0; i < pq.size(); i++)
                res.add(pq.poll().word);

        return res;
    }

    private static class WordStats {
        String word;
        int countTimes;

        Set<Integer> quotesIds;

        WordStats( String word, int countTimes ) {
            this.word = word;
            this.countTimes = countTimes;
            this.quotesIds = new HashSet<>();
        }
    }
}
