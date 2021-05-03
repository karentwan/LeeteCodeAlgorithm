package cn.karent.leetcode;

import java.util.*;

/**
 * 找到所有数组中消失的数字
 */
public class LeetCode448 {

    // 原地哈希可以一试
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while( nums[nums[i]-1] != nums[i]) {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        List<Integer> rets = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if( nums[i] != i+1) {
                rets.add(i+1);
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode448 lc = new LeetCode448();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> rets = lc.findDisappearedNumbers(nums);
        for(int i : rets) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
