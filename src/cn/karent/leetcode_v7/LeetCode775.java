package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 全局倒置和局部倒置
 * @author wan
 * @date 2022.11.16 08:31
 ******************************************/
public class LeetCode775 {

    public boolean isIdealPermutation1(int[] nums) {
        // 全局倒置一定是包含局部倒置的, 所以查找全局倒置的数量即可
        TreeSet<Integer> tree = new TreeSet<>();
        Integer last = null;
        for (int i = 0; i < nums.length; i++) {
            Integer higher = tree.higher(nums[i]);
            if (higher != null) return false;
            if (last != null) {
                tree.add(last);
            }
            last = nums[i];
        }
        return true;
    }

    public boolean isIdealPermutation(int[] nums) {
        int size = nums.length, min = nums[size - 1];
        for (int i = size-3; i >= 0; i--) {
            if (nums[i] > min) return false;
            min = Math.min(nums[i+1], min);
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode775 lc = new LeetCode775();
    }

}
