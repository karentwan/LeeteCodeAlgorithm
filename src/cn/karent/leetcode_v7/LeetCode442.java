package cn.karent.leetcode_v7;

import java.util.*;

/*******************************************
 * @author wan
 * @date: 2022-05-08 09:22
 * @description: 数组中重复的数据
 *******************************************/
public class LeetCode442 {

    public List<Integer> findDuplicates(int[] nums) {
        // 将数据交换到下标位置
        for (int i = 0; i < nums.length; i++) {
            while ( nums[i]-1 != i && nums[nums[i]-1]-1 != nums[i]-1) {
                int t = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = t;
            }
        }
        List<Integer> rets = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]-1 != i) {
                rets.add(nums[i]);
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode442 lc = new LeetCode442();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> rets = lc.findDuplicates(nums);
        for (Integer ret : rets) {
            System.out.print(ret + " ");
        }

    }

}
