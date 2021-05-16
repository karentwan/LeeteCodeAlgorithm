package cn.karent.leetcode_v4.weeklycontest241;

import java.util.*;

/********************************************
 * description: 找出所有子集的异或总和再求和
 * @author wan
 * @date 2021.05.16
 ********************************************/
public class Algo5759 {

    private int ret;

    private void dfs(int[] nums, int idx, int t) {
        for (int i = idx; i < nums.length; i++) {
            t ^= nums[i];
            ret += t;
            dfs(nums, i+1, t);
            t ^= nums[i];
        }
    }

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return ret;
    }

    public static void main(String[] args) {
        Algo5759 lc = new Algo5759();
//        int[] nums = {1,3};
        int[] nums = {5,1,6};
        int ret = lc.subsetXORSum(nums);
        System.out.println(ret);
    }

}
