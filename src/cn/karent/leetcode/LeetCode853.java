package cn.karent.leetcode;

import java.util.*;

/**
 * 车队
 */
public class LeetCode853 {

    public int carFleet(int target, int[] position, int[] speed) {
        Integer[] indices = new Integer[position.length];
        for(int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        double[] times = new double[position.length];
        for(int i = 0; i < position.length; i++) {
            times[i] = (target - position[i]) * 1.0 / speed[i];
        }
        Arrays.sort(indices, (k1, k2) -> {
            return position[k2] - position[k1];
        });
        int ret = 0;
        int i = 0, j = 0;
        while( i < position.length) {
            j = i+1;
            while( j < position.length && times[indices[j]] <= times[indices[i]]) {
                j++;
            }
            ret++;
            i = j;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode853 lc = new LeetCode853();
//        int target = 12;
//        int[] position = {10, 8, 0, 5, 3};
//        int[] speed = {2, 4, 1, 1, 3};
//        int target = 10;
//        int[] position = {0, 4, 2};
//        int[] speed = {2, 1, 3};
        int target = 10;
        int[] position = {8,3,7,4,6,5};
        int[] speed = {4,4,4,4,4,4};
        int ret = lc.carFleet(target, position, speed);
        System.out.println(ret);
    }

}
