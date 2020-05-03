package com.interview.companies.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

    //https://leetcode.com/problems/exclusive-time-of-functions/
    public static void main( String[] args ) {
        int n = 2;
        List<String> list = new ArrayList<>(Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"));

        System.out.println(Arrays.toString(exclusiveTime(n, list)));
    }

    //Runtime: 9 ms, faster than 98.21% of Java
    private static int[] exclusiveTime( int n, List<String> logs ) {
        int[] res = new int[n];
        Stack<Log> stack = new Stack<>();

        for (String log : logs) {
            Log currLog = new Log(log);

            if (currLog.isStart) {
                stack.push(currLog);
            } else { //now the curr log is EndLog
                Log startLog = stack.pop();

                //"1:start:2", "1:end:5" => 5 - 2 + 1 => 4 => res[1] = 1
                res[startLog.id] += currLog.time - startLog.time + 1;

                //now stack contains: 0:start:0
                //"1:start:2", "1:end:5" => 5 - 2 + 1 => 4 => res[0] = -4
                if (!stack.isEmpty()) {
                    res[stack.peek().id] -= (currLog.time - startLog.time + 1);
                }

                //on 2nd iteration:
                //then on next iteration : "0:end:6"
                //Now operation: "0:end:6", "0:start:0" => 6 - 0 => 6 => res[0] = 6 - 4 +1 => 3
            }
        }

        return res;
    }

    private static class Log {
        boolean isStart;
        int id;
        int time;

        Log( String log ) {
            String[] strs = log.split(":");
            id = Integer.valueOf(strs[0]);
            isStart = strs[1].equals("start");
            time = Integer.valueOf(strs[2]);
        }
    }
}
