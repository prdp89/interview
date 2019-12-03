package com.interview.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 04/04/2016
 *
 * @author Tushar Roy
 * <p>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Reference
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {

    public static void main( String[] args ) {
        // restoreIpAddressesMethod2("25525511135").forEach(v -> System.out.println(v));

        restoreIpAddressesMethod1("25525511135").forEach(v -> System.out.println(v));
    }

    //method---2 : tushar roy----------
    public List<String> restoreIpAddressesMethod2( String s ) {
        List<String> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        restoreIpAddressesUtil(s, 0, 0, result, current);
        return result;
    }

    private static void restoreIpAddressesUtil( String s, int start, int count, List<String> result, List<String> current ) {
        if (start == s.length() && count == 4) {
            StringBuffer stringBuffer = new StringBuffer(current.get(0));
            for (int i = 1; i < current.size(); i++) {
                stringBuffer.append(".").append(current.get(i));
            }
            result.add(stringBuffer.toString());
            return;
        } else if (start == s.length() || count == 4) {
            return;
        }
        for (int i = start; i < s.length() && i < start + 3; i++) {
            if (i != start && s.charAt(start) == '0') {
                break;
            }
            String ip = s.substring(start, i + 1);
            if (Integer.valueOf(ip) > 255) {
                continue;
            }
            current.add(ip);
            restoreIpAddressesUtil(s, i + 1, count + 1, result, current);
            current.remove(current.size() - 1);
        }
    }

    //----------------------------------

    //very easy implementation
    //from-------https://leetcode.com/problems/restore-ip-addresses/discuss/30949/My-code-in-Java
    private static List<String> restoreIpAddressesMethod1( String s ) {
        List<String> res = new ArrayList<String>();
        int len = s.length();

        for (int i = 1; i < 4 && i < len - 2; i++) { //i should less than 4 length and if total str length = 4 then 4 - 2 = 2; 0 <= i <= 2

            for (int j = i + 1; j < i + 4 && j < len - 1; j++) { //next j should less than 4 chars after i

                for (int k = j + 1; k < j + 4 && k < len; k++) {

                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, len);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return res;
    }

    private static boolean isValid( String s ) {
        return s.length() <= 3 && s.length() != 0 && (s.charAt(0) != '0' || s.length() <= 1) && Integer.parseInt(s) <= 255;
    }
    //----------------------------------------------------------------------------------------------
}
