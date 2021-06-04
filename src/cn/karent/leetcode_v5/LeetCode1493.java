package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 删掉一个元素以后全为1的最长子数组
 * @author wan
 * @date 2021.06.04
 ********************************************/
public class LeetCode1493 {

    public int longestSubarray(int[] nums) {
        int zero = 0;
        int ret = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if( nums[i] == 0 ) {
                zero++;
            }
            if( zero <= 1) ret = Math.max(ret, i - j);
            else {
                if( nums[j] == 0) zero--;
                j++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1493 lc = new LeetCode1493();
//        int[] arr = {1, 1, 0, 1};
        int[] arr = {0,1,1,1,0,1,1,0,1};
        int ret = lc.longestSubarray(arr);
        System.out.println(ret);
    }

}
