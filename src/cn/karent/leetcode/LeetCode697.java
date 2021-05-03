package cn.karent.leetcode;

import java.util.*;

/**
 * 数组的度
 */
public class LeetCode697 {

    public int findShortestSubArray(int[] nums) {
        int i = 0, j = 0;
        int ret = Integer.MAX_VALUE;
        int indegree = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 先计算数组的度
        while( j < nums.length ) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            indegree = Math.max(indegree, map.get(nums[j]));
            j++;
        }
        map.clear();
        j = 0;
        int item = -1;
        int wnd = 0;
        while( j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            if( map.get(nums[j]) > wnd) {
                wnd = map.get(nums[j]);
                item = nums[j];
            }
            j++;
            while( wnd == indegree) {
                ret = Math.min(ret, j - i);
                if( item == nums[i]) {
                    wnd--;
                }
                map.put(nums[i], map.get(nums[i])-1);
                i++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode697 lc = new LeetCode697();
//        int[] nums = {1, 2, 2, 3, 1};
        int[] nums = {1,2,2,3,1,4,2};
//        int[] nums = {1,2,2,1, 2,1,1,1, 1,2,2,2};
        int ret = lc.findShortestSubArray(nums);
        System.out.println(ret);
    }

}
