package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 特殊数组的特征值
 * @author wan
 * @date 2022.09.12 09:24
 ******************************************/
public class LeetCode1608 {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] >= size - i && (i == 0 || nums[i-1] < size - i)) {
                return size - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode1608 lc = new LeetCode1608();
//        int[] nums = {3,5};
//        int[] nums = {0,0};
//        int[] nums = {0,4,3,0,4};
        int[] nums = {3,6,7,7,0};
        System.out.println(lc.specialArray(nums));
    }

}
