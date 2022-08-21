package cn.karent.leetcode_v7.weeklycontests85;

import cn.karent.util.LeetCodeUtil;

import java.util.*;

/******************************************
 * 删除操作后的最大字段和
 * @author wan
 * @date 2022.08.21 15:25
 ******************************************/
public class LeetCode6159 {

    private int[] parent;
    private long[] sum;
    int max;
    private int find(int idx) {
        return idx == parent[idx] ? idx : find(parent[idx]);
    }

    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        // 反向增加就可以转换为并查集算法
        parent = new int[nums.length+1];
        sum = new long[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            parent[i] = i;
        }
        long[] rets = new long[nums.length];
        for (int i = nums.length -1; i > 0; i--) {
            int x = removeQueries[i];
            int to = find(x+1);
            parent[x] = to;
            sum[to] += sum[x] + nums[x];
            rets[i-1] = Math.max(rets[i], sum[to]);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode6159 lc = new LeetCode6159();
//        int[] nums = {1,2,5,6,1};
//        int[] removeQueries = {0,3,2,4,1};
        int[] nums = {500,822,202,707,298,484,311,680,901,319,343,340};
        int[] removeQueries = {6,4,0,5,2,3,10,8,7,9,1,11};
        long[] rets = lc.maximumSegmentSum(nums, removeQueries);
        LeetCodeUtil.print(rets);
    }

}
