package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 安排电影院座位
 * @author wan
 * @date 2021.04.16
 */
public class LeetCode1386 {
/*
    // 超时
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Queue<int[]>> map = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            int x = reservedSeat[0];
            map.computeIfAbsent(x, (k) -> new LinkedList<>()).offer(reservedSeat);
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seat = new boolean[10];
            Queue<int[]> rs = map.getOrDefault(i+1, null);
            if( rs != null) {
                while (!rs.isEmpty() ) {
                    int[] tmp = rs.poll();
                    seat[tmp[1]-1] = true;
                }
            }
            int j = 1;
            boolean flag = true;
            while (j <= 4 && (flag = !seat[j])) j++;
            if( flag) {
                ret++;
                j = 5;
                while (j <= 8 && (flag = !seat[j])) j++;
                if( flag ) ret++;
            } else {
                j = 3;
                flag = true;
                while (j < 7 && (flag = !seat[j])) j++;
                if( flag ) ret++;
                else {
                    j = 5;
                    flag = true;
                    while (j <= 8 && (flag = !seat[j])) j++;
                    if( flag) ret++;
                }
            }
        }
        return  ret;
    }

   */

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int left = 0b11110000;
        int mid = 0b11000011;
        int right = 0b00001111;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            int x = reservedSeat[0];
            int y = reservedSeat[1];
            if( y >= 2 && y <= 9) {
                int seat = map.getOrDefault(x, 0);
                seat |= 1 << (y-1);
                map.put(x, seat);
            }
        }
        int ret = 2 * (n - map.size());
        for (int key : map.keySet()) {
            int v = map.get(key);
            if( (v | left) == left
                    || (v | mid) == mid
                    || (v|right) == right) ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1386 lc = new LeetCode1386();
//        int n = 3;
//        int[][] reservedSeats = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
//        int n = 2;
//        int[][] reservedSeats = {{2,1},{1,8},{2,6}};
        int n = 4;
        int[][] reservedSeats = {{4,3},{1,4},{4,6},{1,7}};
        int ret = lc.maxNumberOfFamilies(n, reservedSeats);
        System.out.println(ret);
//        System.out.println(1 << 1);
    }

}
