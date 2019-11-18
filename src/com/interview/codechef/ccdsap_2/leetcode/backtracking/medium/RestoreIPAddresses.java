package com.interview.codechef.ccdsap_2.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    //https://leetcode.com/problems/restore-ip-addresses/
    public static void main( String[] args ) {
        restoreIpAddresses("25525511135").forEach(System.out::println);
    }

    //easy implementation  from : https://leetcode.com/problems/restore-ip-addresses/discuss/30972/WHO-CAN-BEAT-THIS-CODE
    private static List<String> restoreIpAddresses( String s ) {
        List<String> ret = new ArrayList<>();

        StringBuilder ip = new StringBuilder();

        for (int a = 1; a < 4; ++a)
            for (int b = 1; b < 4; ++b)
                for (int c = 1; c < 4; ++c)
                    for (int d = 1; d < 4; ++d) {

                        //Each Ip address component sum should be of size Input string
                        if (a + b + c + d == s.length()) {

                            //getting each part of IP address {1..4}
                            int n1 = Integer.parseInt(s.substring(0, a));
                            int n2 = Integer.parseInt(s.substring(a, a + b));
                            int n3 = Integer.parseInt(s.substring(a + b, a + b + c));
                            int n4 = Integer.parseInt(s.substring(a + b + c));

                            //checking if each part is <= 255
                            if (n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {

                                //append . char between each ip component
                                ip.append(n1).append('.').append(n2)
                                        .append('.').append(n3).append('.').append(n4);

                                //checking of generated IP length === input string + 3 (three append dots)
                                if (ip.length() == s.length() + 3)
                                    ret.add(ip.toString());

                                //delete last ip string to generate a new string
                                ip.delete(0, ip.length());
                            }
                        }
                    }

        return ret;
    }
}
