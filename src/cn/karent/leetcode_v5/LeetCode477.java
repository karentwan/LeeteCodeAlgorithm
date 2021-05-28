package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 汉明距离总和
 * @author wan
 * @date 2021.05.28
 ********************************************/
public class LeetCode477 {

    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int ret = 0;
        for (int i = 30; i >= 0; i--) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if( (nums[j] & (1 << i)) != 0) {
                    cnt++;
                }
            }
            ret += cnt * ( n - cnt);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode477 lc = new LeetCode477();
        int[] arr = {4, 14, 2};
        int ret = lc.totalHammingDistance(arr);
        System.out.println(ret);
    }

}
