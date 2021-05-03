package cn.karent.leetcode_v4.weeklycontest239;

import java.util.*;

/********************************************
 * description: 到目标元素的最小距离
 * @author wan
 * @date 2021.05.02
 ********************************************/
public class Algo5746 {

    public int getMinDistance(int[] nums, int target, int start) {
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if( nums[i] == target && Math.abs(i - start) < ret) {
                ret = Math.abs(i - start);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Algo5746 lc = new Algo5746();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 5;
        int start = 3;
        int ret = lc.getMinDistance(nums, target, start);
        System.out.println(ret);
    }

}
