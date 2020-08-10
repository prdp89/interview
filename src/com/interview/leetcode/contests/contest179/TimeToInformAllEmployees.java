package com.interview.leetcode.contests.contest179;

import java.util.*;

public class TimeToInformAllEmployees {

    //https://leetcode.com/problems/time-needed-to-inform-all-employees/
    public static void main( String[] args ) {
        int n = 6, headID = 2, manager[] = {2, 2, -1, 2, 2, 2}, informTime[] = {0, 0, 1, 0, 0, 0};

        System.out.println(numOfMinutes(n, headID, manager, informTime));
    }

    /*
    Each employee has one direct manager given in the manager array where manager[i] is the direct
    manager of the i-th employee, manager[headID] = -1.
     */

    //This is N-Way BFS problem. A standard problem structure :)
    private static int numOfMinutes( int n, int headID, int[] manager, int[] informTime ) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1)
                continue;

            map.putIfAbsent(manager[i], new ArrayList<>());

            //bcz manager[i] is the manager of ith Employee
            map.get(manager[i]).add(i);
        }

        Queue<Employee> queue = new LinkedList<>();
        //head never report to anyone :P
        queue.offer(new Employee(headID, 0));

        int totalReportingTime = 0;

        while (!queue.isEmpty()) {

            Employee reportinEmp = queue.poll();
            totalReportingTime = Math.max(totalReportingTime, reportinEmp.reportingTime);

            //if this employee reports then employee under it can also report..
            if (informTime[reportinEmp.managerId] != 0) {
                List<Integer> reportingEmpIds = map.get(reportinEmp.managerId);

                for (int i = 0; i < reportingEmpIds.size(); i++) {

                    //totalTime : prevEmployeeTime + currentEmployeeTime
                    queue.offer(new Employee(reportingEmpIds.get(i)
                            , reportinEmp.reportingTime + informTime[reportinEmp.managerId]));
                }
            }
        }

        return totalReportingTime;
    }

    private static class Employee {
        int managerId;
        int reportingTime;

        Employee( int managerId,
                  int reportingTime ) {
            this.managerId = managerId;
            this.reportingTime = reportingTime;
        }
    }
}
