package cn.karent.leetcode_v1;

import java.util.Arrays;

/******************************************
 * 公交站间的距离
 * @author wan
 * @date 2022.07.24 10:18
 ******************************************/
public class LeetCode1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = Arrays.stream(distance).sum();
        int ret = 0;
        for (int i = start; i != destination; i = (i + 1) % distance.length) {
            ret += distance[i];
        }
        return Math.min(ret, sum - ret);
    }

    public static void main(String[] args) {
        LeetCode1184 lc = new LeetCode1184();
        int[] distance = {1,2,3,4};
        int start = 0;
        int destination = 1;
        System.out.println(lc.distanceBetweenBusStops(distance, start, destination));
    }

}
