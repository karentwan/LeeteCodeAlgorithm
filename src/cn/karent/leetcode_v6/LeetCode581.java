package cn.karent.leetcode_v6;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/***********************************************
 * description: 最短无序连续子数组
 * @author wan
 * @date 2021.08.03
 ***********************************************/
public class LeetCode581 {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int l = -1, r = -1;
        for (int i = n-1; i >= 0; i--) {
            if( nums[i] > min) {
                l = i;
            }
            min = Math.min(min, nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if( nums[i] < max) {
                r = i;
            }
            max = Math.max(max, nums[i]);
        }
        return r == -1 ? 0 : r - l + 1;
    }

    public static void main(String[] args) {
        LeetCode581 lc = new LeetCode581();
//        int[] arr1 = {2,6,4,8,10,9,15};
//        int[] arr = {2,6,4,8,10,9,15};
        int[][] arr = {
                {1,2,3,4},
                {2,6,4,8,10,9,15},
                {1,2,3,3,3},
                {1,3,2,2,2},
                {1,3,2,3,3}, //
                {2,3,3,2,4}, //
                {1,2,4,5,3}  //
        };
//        int ret = lc.findUnsortedSubarray(arr);
//        System.out.println(ret);
        LeetCodeUtil.run((t)-> System.out.println(lc.findUnsortedSubarray(t)),
                arr);
    }

}
