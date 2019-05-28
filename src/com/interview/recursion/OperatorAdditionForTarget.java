package com.interview.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Date 02/23/2016
 *
 * @author Tushar Roy
 * <p>
 * Given a string eg. 123 and target e.g 6. Put operators *, +, - between 123 so that it evaluates to 6
 * <p>
 * https://leetcode.com/problems/expression-add-operators/
 */
public class OperatorAdditionForTarget {
    public static void main( String args[] ) {
        OperatorAdditionForTarget p = new OperatorAdditionForTarget();
        List<String> result = p.addOperators("1234", -1);
        result.stream().forEach(s -> System.out.println(s));
    }

    //Easy program explanation : https://leetcode.com/articles/expression-add-operators/
    //Easy program to consider : https://leetcode.com/problems/expression-add-operators/discuss/71895/Java-Standard-Backtrace-AC-Solutoin-short-and-clear

    public List<String> addOperators( String num, int target ) {
        if (num.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        StringBuffer buff = new StringBuffer();
        dfs(num, 0, target, 0, 0, result, buff);
        return result;
    }

    private void dfs( String nums, int pos, int target, long runningTotal, long multiplicationVal, List<String> result, StringBuffer buff ) {
        if (pos == nums.length()) {
            if (runningTotal == target) {
                result.add(buff.toString());
            }
            return;
        }

        for (int i = pos; i < nums.length(); i++) {

            //if i > 0 means eg: 105,  i at 0 value and current value is 0 then invalid expression
            if (i != pos && nums.charAt(pos) == '0') {
                break;
            }

            String subStr = nums.substring(pos, i + 1);
            long num = Long.parseLong(subStr);

            //This is the case where we just need to traverse the string "115" eg: "1" "15"
            if (pos == 0) {
                dfs(nums, i + 1, target, num, num, result, buff.append(num));
                buff.delete(buff.length() - subStr.length(), buff.length());
                continue;
            }
            dfs(nums, i + 1, target, runningTotal + num, num, result, buff.append("+").append(subStr));
            buff.delete(buff.length() - subStr.length() - 1, buff.length());

            dfs(nums, i + 1, target, runningTotal - num, -num, result, buff.append("-").append(subStr));
            buff.delete(buff.length() - subStr.length() - 1, buff.length());

            //Explanation is in article: 10 + 2 * 4 = 18
            //It is done as : ((10+2) - 2) + (2 * 4) = 18
            dfs(nums, i + 1, target, runningTotal + num * multiplicationVal - multiplicationVal, num * multiplicationVal,
                    result, buff.append("*").append(subStr));
            buff.delete(buff.length() - subStr.length() - 1, buff.length());
        }
    }
}