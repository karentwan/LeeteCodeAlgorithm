package cn.karent.leetcode_v3;

import java.util.*;

/********************************************
 * description: 连续数组
 * @author wan
 * @date 2021.04.25
 ********************************************/
public class LeetCode525 {

    public int findMaxLength(int[] nums) {
        int ret = 0;
        if( nums.length == 0) return ret;
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            cnt += nums[i] == 0 ? -1 : 1;
            if( map.containsKey(cnt) ) ret = Math.max(ret, i - map.get(cnt));
            else map.put(cnt, i);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode525 lc = new LeetCode525();
//        int[] nums = {0,1};
        int[] nums = {0,1,0};
        int ret = lc.findMaxLength(nums);
        System.out.println(ret);
    }

}
