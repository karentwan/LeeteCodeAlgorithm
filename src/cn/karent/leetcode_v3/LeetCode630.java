package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 课程表三
 * @author wan
 * @date 2021.04.10
 */
public class LeetCode630 {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (k1, k2) -> {
            return k1[1] == k2[1] ? k1[0] - k2[0] : k1[1] - k2[1];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((k1, k2) -> k2 - k1);
        int s = 0;
        for (int[] course : courses) {
            int d = course[0];
            int e = course[1];
            if( s + d <= e) {
                pq.offer(d);
                s += d;
            } else {
                if( !pq.isEmpty() && pq.peek() > d) {
                    s = s - pq.poll() + d;
                    pq.offer(d);
                }
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        LeetCode630 lc = new LeetCode630();
//        int[][] nums = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        int[][] nums = {{5,5}, {4,6}, {2,6}};
        int ret = lc.scheduleCourse(nums);
        System.out.println(ret);
    }

}
