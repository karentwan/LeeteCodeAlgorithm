package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 公交站间的距离
 * @author wan
 * @date 2021.05.19
 ********************************************/
public class LeetCode1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int ret = 0;
        // 顺时针
        int n = distance.length;
        for (int i = start; i != destination; i = (i+1)%n) {
            ret += distance[i];
        }
        int t = 0;
        for (int i = destination; i != start; i = (i+1)%n) {
            t += distance[i];
        }
        return Math.min(ret, t);
    }

    public static void main(String[] args) {
        LeetCode1184 lc = new LeetCode1184();
        int[] distance = {1, 2, 3, 4};
        int start = 0;
        int destination = 1;
        int ret = lc.distanceBetweenBusStops(distance, start, destination);
        System.out.println(ret);
    }

}
