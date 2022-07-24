package cn.karent.leetcode_v1.weeklycontest303;

import java.util.*;

/******************************************
 * 优质数对的数目
 * @author wan
 * @date 2022.07.24 11:05
 ******************************************/
public class LeetCode6127 {

    // a & b + a | b 其实1的位数就等于a + b
    public long countExcellentPairs(int[] nums, int k) {
        // 去重
        int[] tmps = Arrays.stream(nums).distinct().toArray();
        // 预处理统计1的位数
        for (int i = 0; i < tmps.length; i++) {
            tmps[i] = Integer.bitCount(tmps[i]);
        }
        long ret = 0;
        Arrays.sort(tmps);
        int n = tmps.length;
        for (int i = 0, j = n-1; i < n; i++) {
            while ( j >= 0 && tmps[j] + tmps[i] >= k) {
                j--;
            }
            ret += n - j - 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode6127 lc = new LeetCode6127();
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(lc.countExcellentPairs(nums, k));
    }

}
