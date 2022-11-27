package cn.karent.leetcode_v8;

import java.util.*;

/******************************************
 * 检查数组是否经排序和轮转得到
 * @author wan
 * @date 2022.11.27 11:18
 ******************************************/
public class LeetCode1752 {

    public boolean check(int[] nums) {
        if (nums.length <= 1) return true;
        int[] tmps = new int[nums.length*2];
        for (int i = 0; i < nums.length; i++) {
            tmps[i] = tmps[i + nums.length] = nums[i];
        }
        int cnt = 1;
        for (int i = 1; i < tmps.length; i++) {
            if (tmps[i] >= tmps[i-1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt == nums.length) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode1752 lc = new LeetCode1752();
    }

}
