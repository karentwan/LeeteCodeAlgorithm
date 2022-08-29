package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 重新排列数组
 * @author wan
 * @date 2022.08.29 08:13
 ******************************************/
public class LeetCode1470 {

    public int[] shuffle(int[] nums, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = n; j < nums.length; i++, j++) {
            list.add(nums[i]);
            list.add(nums[j]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        LeetCode1470 lc = new LeetCode1470();
    }

}
