package com.mdy.sort;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * User: maodayu
 * Date: 2021/2/23 18:45
 */
public class Solution207 {

    public static void main(String[] args) {

        //链表每隔k结点翻转一次  123456->321654   654321
        int[][] nums = {{1, 0}};
        boolean result = canFinish(2, nums);
        System.out.println(result);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] tempArr = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            tempArr[prerequisites[i][0]]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (tempArr[i] == 0) deque.offer(i);
        }

        int k = 0;
        while (!deque.isEmpty()) {
            int currValue = deque.poll();
            result[k++] = currValue;
            for (int i = 0; i < prerequisites.length; i++) {
               if(prerequisites[i][1] == currValue){
                   tempArr[prerequisites[i][0]]--;
                   if(tempArr[prerequisites[i][0]] ==0){
                       deque.offer(prerequisites[i][0]);
                   }
               }
            }
        }

        return k == numCourses;
    }
}
