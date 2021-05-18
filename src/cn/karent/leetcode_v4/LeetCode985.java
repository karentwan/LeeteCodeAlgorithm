package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 查询后的偶数和
 * @author wan
 * @date 2021.05.18
 ********************************************/
public class LeetCode985 {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for (int num : nums) {
            if( num % 2 == 0) sum += num;
        }
        int[] rets = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][1];
            int val = queries[i][0];
            if( nums[idx] % 2 == 0) {
                sum -= nums[idx];
            }
            nums[idx] += val;
            if( nums[idx] % 2 == 0) sum += nums[idx];
            rets[i] = sum;
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode985 lc = new LeetCode985();
        int[] arr = {1, 2, 3, 4};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        int[] rets = lc.sumEvenAfterQueries(arr, queries);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
