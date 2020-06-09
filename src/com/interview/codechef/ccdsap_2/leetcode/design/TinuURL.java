package com.interview.codechef.ccdsap_2.leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class TinuURL {

    private static String BASE_HOST = "http://tinyurl.com/";
    private static Map<String, String> index = new HashMap<String, String>();
    private static Map<String, String> revIndex = new HashMap<String, String>();

    //https://leetcode.com/problems/encode-and-decode-tinyurl/
    // 62^6 => (10+26*2)6 = 56,800,235,584 codes with length 6.
    public static void main( String[] args ) {
        String str = encode("9990909090");
        System.out.println(str);

        System.out.println(decode("http://tinyurl.com/" + str));
    }

    // Encodes a URL to a shortened URL.
    private static String encode( String longUrl ) {

        if (revIndex.containsKey(longUrl))
            return BASE_HOST + revIndex.get(longUrl);

        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        String key;

        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < longUrl.length(); i++) {
                //Returns a {@code double} value with a positive sign, greater
                // than or equal to {@code 0.0} and less than {@code 1.0}.
                int r = (int) (Math.random() * charSet.length());
                sb.append(charSet.charAt(r));
            }
            key = sb.toString();
        } while (index.containsKey(key)); //run atleast one-time or until unique key is found.

        index.put(key, longUrl);
        revIndex.put(longUrl, key);

        return BASE_HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    private static String decode( String shortUrl ) {
        return index.get(shortUrl.replace(BASE_HOST, ""));
    }
}
